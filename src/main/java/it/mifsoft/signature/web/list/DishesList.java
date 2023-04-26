package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.dto.DishData;
import it.mifsoft.signature.web.list.item.DishListItem;
import it.mifsoft.signature.web.service.MenuItemsApiService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@UIScope
public class DishesList extends Div {
    private final DishesListState state;
    private List<DishListItem> items;
    private DishListItem currentItem;

    public Image previousButton;
    public Image nextButton;
    private final Div scrollableContainer;

    private final MenuItemsApiService menuItemsApiService;

    public DishesList(MenuItemsApiService menuItemsApiService) {
        this.menuItemsApiService = menuItemsApiService;
        //long categoryId
        this.getStyle().setPosition(Style.Position.RELATIVE);

        this.state = new DishesListState();

        this.previousButton = createPreviousButton();
        this.nextButton = createNextButton();
        this.scrollableContainer = createScrollableContainer();

        previousButton.addClassNames("dish-previous-button");
        nextButton.addClassNames("dish-next-button");
        this.addClassNames("main-component-dishes");

        this.add(previousButton,  scrollableContainer, nextButton);
        if (this.currentItem != null) {
            moveTo(this.currentItem);
        }
    }

    private void next(ClickEvent<Image> imageClickEvent) {
        final int currentIndex = this.state.currentIndex();
        final int nextIndex = currentIndex + 1;
        final DishListItem item = this.items.get(nextIndex);
        this.state.setCurrent(nextIndex);
        moveTo(item);
    }

    private void previous(ClickEvent<Image> imageClickEvent) {
        final int currentIndex = this.state.currentIndex();
        final int previousIndex = currentIndex - 1;
        final DishListItem item = this.items.get(previousIndex);
        this.state.setCurrent(previousIndex);
        moveTo(item);
    }

    private void moveTo(DishListItem item) {
        final String script = "document.getElementById('%s').scrollIntoView({behavior: \"smooth\", block: \"center\"})";
        if (item.getId().isPresent())
            item.getElement().executeJs(String.format(script, item.getId().get()));
    }

    private Image createPreviousButton() {
        final Image previous = new Image();
        previous.getStyle().setPosition(Style.Position.ABSOLUTE);
        previous.getStyle().setTop("14%");
        previous.getStyle().setLeft("0px");
        previous.getStyle().setZIndex(Integer.MAX_VALUE);
            previous.setSrc("/img/plate-left.png");
        previous.addClickListener(this::previous);
        return previous;
    }

    private Image createNextButton() {
        final Image next = new Image();
        next.getStyle().setPosition(Style.Position.ABSOLUTE);
        next.getStyle().setTop("14%");
        next.getStyle().setRight("0px");
        next.getStyle().setZIndex(Integer.MAX_VALUE);
        next.setSrc("/img/plate-right.png");
        next.addClickListener(this::next);
        return next;
    }

    private Div createScrollableContainer() {
        final Div container = new Div();
        container.getStyle().setDisplay(Style.Display.FLEX);
        container.getStyle().set("flex-direction", "row");
        container.getStyle().set("overflow-x", "hidden");
        container.getStyle().set("overflow-y", "none");

        return container;
    }

    private void createItems() {
        this.items = state.getDishes()
                .stream()
                .map(dishData -> {
                    final DishListItem listItem = new DishListItem(dishData);
                    listItem.setId(String.valueOf(dishData.getId()));
//                    listItem.getStyle().setWidth("100vw");
//                    listItem.getStyle().set("min-width", "100vw");
//                    listItem.getStyle().setHeight("100vh");
//                    listItem.getStyle().set("max-height", "100vh");
                    return listItem;
                })
                .toList();;
        this.currentItem = this.items.size() > 0 ? this.items.get(0) : null;
        getUI().ifPresent(ui -> ui.access(() -> items.forEach(scrollableContainer::add)));
    }

    public void setCategoryId(long categoryId) {
        if (categoryId == this.state.categoryId)
            return;

        menuItemsApiService.getDishesByCategoryId(categoryId).doOnSuccess(dishes -> {
            updateDishes(dishes, categoryId);
        }).block();
    }

    private void updateDishes(final List<DishData> dishes, final long categoryId) {
        dishes.forEach(d -> System.out.println("Dish in category " + categoryId + " with name " +d.getName()));
        getUI().ifPresent(ui -> ui.access(this.scrollableContainer::removeAll));
        this.state.categoryId = categoryId;
        this.state.dishes = dishes;
        createItems();
    }

    private static class DishesListState {
        private long categoryId = -1;
        private DishData current;
        private List<DishData> dishes = new ArrayList<>();

        DishesListState() {
        }

        public long getCategoryId() {
            return categoryId;
        }

        public DishData getCurrent() {
            return current;
        }

        public List<DishData> getDishes() {
            return dishes;
        }

        public void setCurrent(int index) {
            this.current = dishes.get(index);
        }

        public int currentIndex() {
            return dishes.indexOf(current);
        }
    }
}
