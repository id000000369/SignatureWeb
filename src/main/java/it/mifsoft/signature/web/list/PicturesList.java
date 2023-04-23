package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.dto.PictureData;
import it.mifsoft.signature.web.list.item.PictureListItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@UIScope

public class PicturesList extends Div {

    private final PicturesListState state;
    private List<PictureListItem> items;
    private PictureListItem currentItem;

    private Image previousButton;
    private Image nextButton;
    private final Div scrollableContainer;


    public PicturesList() {
        //long categoryId
        this.getStyle().setPosition(Style.Position.RELATIVE);

        this.state = new PicturesListState(0);

        this.previousButton = createPreviousButton();
        this.nextButton = createNextButton();
        this.scrollableContainer = createScrollableContainer();

        previousButton.addClassNames("dish-previous-button");
        nextButton.addClassNames("dish-next-button");

        this.add(previousButton,
                scrollableContainer,
                nextButton);
        if (this.currentItem != null) {
            moveTo(this.currentItem);
        }
    }


    private void next(ClickEvent<Image> imageClickEvent) {
        final int currentIndex = this.state.currentIndex();
        final int nextIndex = currentIndex + 1;
        final PictureListItem item = this.items.get(nextIndex);
        this.state.setCurrent(nextIndex);
        moveTo(item);
    }

    private void previous(ClickEvent<Image> imageClickEvent) {
        final int currentIndex = this.state.currentIndex();
        final int previousIndex = currentIndex - 1;
        final PictureListItem item = this.items.get(previousIndex);
        this.state.setCurrent(previousIndex);
        moveTo(item);
    }

    private void moveTo(PictureListItem item) {
        final String script = "document.getElementById('%s').scrollIntoView({behavior: \"smooth\", inline: \"center\"})";
        if (item.getId().isPresent())
            item.getElement().executeJs(String.format(script, item.getId().get()));
    }

    private Image createPreviousButton() {
        final Image previous = new Image();
        previous.getStyle().setPosition(Style.Position.ABSOLUTE);
        previous.getStyle().setTop("20%");
        previous.getStyle().setLeft("0px");
        previous.getStyle().setZIndex(Integer.MAX_VALUE);
        previous.setSrc("https://i.ibb.co/yVxCF4Q/plate-1513116566-1-1.png");
        previous.addClickListener(this::previous);
        return previous;
    }

    private Image createNextButton() {
        final Image next = new Image();
        next.getStyle().setPosition(Style.Position.ABSOLUTE);
        next.getStyle().setTop("20%");
        next.getStyle().setRight("0px");
        next.getStyle().setZIndex(Integer.MAX_VALUE);
        next.setSrc("https://i.ibb.co/j379CsM/plate-1513116566-2.png");
        next.addClickListener(this::next);
        return next;
    }

    private Div createScrollableContainer() {
        final Div container = new Div();
        container.getStyle().setDisplay(Style.Display.FLEX);
        container.getStyle().set("flex-direction", "row");
        container.getStyle().set("overflow-x", "hidden");
        container.getStyle().set("overflow-y", "none");

        final List<PictureListItem> items = state.getPicture()
                .stream()
                .map(pictureData -> {
                    final PictureListItem listItem = new PictureListItem();
                    listItem.setId(String.valueOf(pictureData.getId()));
                    listItem.getStyle().setWidth("100vw");
                    listItem.getStyle().set("min-width", "100vw");
                    listItem.getStyle().setHeight("100vh");
                    listItem.getStyle().set("max-height", "100vh");
                    return listItem;
                })
                .toList();
        this.items = items;
        this.currentItem = this.items.size() > 0 ? this.items.get(0) : null;
        items.forEach(container::add);
        container.addClassName("test-div");
        return container;
    }

    private static class PicturesListState {
        private final long categoryId;
        private PictureData current;
        private final List<PictureData> picture = new ArrayList<>();

        PicturesListState(final long categoryId) {
            this.categoryId = categoryId;

            //test
            for (int i = 1; i < 10; i++) {
                final PictureData pictureData = new PictureData(i, "", "", 1, "");
                picture.add(pictureData);
            }
            this.current = picture.get(0);
        }

        public long getCategoryId() {
            return categoryId;
        }

        public PictureData getCurrent() {
            return current;
        }

        public List<PictureData> getPicture() {
            return picture;
        }

        public void setCurrent(int index) {
            this.current = picture.get(index);
        }

        public int currentIndex() {
            return picture.indexOf(current);
        }
    }
}
