package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.dto.MenuCategoryData;
import it.mifsoft.signature.web.list.item.CategoryListItem;
import it.mifsoft.signature.web.service.MenuCategoriesApiService;
import it.mifsoft.signature.web.utils.FlexStyleUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@UIScope
public class CategoriesList extends Div {

    private List<MenuCategoryData> categories = new ArrayList<>();

    private List<CategoryListItem> listItems = new ArrayList<>();
    private CategoryListItem selectedItem;

    private final DishesList dishesList;

    private final MenuCategoriesApiService categoriesApiService;

    private final Image adaptiveDishesTopImg;


    public CategoriesList(DishesList dishesList,
                          MenuCategoriesApiService categoriesApiService) {
        this.categoriesApiService = categoriesApiService;

        //FlexStyleUtils.doItRow(this.getElement());

        this.addClassNames("categories-list-main");
        this.dishesList = dishesList;
        this.adaptiveDishesTopImg = createAdaptiveDishesTopImg();

        Div container = new Div();
        container.addClassNames("top-container-dishes");

        container.add(String.valueOf(categoriesApiService.getAll().doOnSuccess(categories -> {
            this.categories = categories;
            this.updateCategories();
            this.add(createAdaptiveDishesTopImg());
        }).block()));


    }

    private Image createAdaptiveDishesTopImg() {
        final Image img = new Image("img/dishes-menu-img.png", "");
        img.addClassName("adaptive-dishes-top-menu-img");
        return img;
    }

    private List<CategoryListItem> createListItems() {
        return categories.stream()
                .map(this::createItem)
                .toList();
    }

    private void updateCategories() {
        this.removeAll();
        this.listItems = createListItems();
        this.listItems.forEach(this::add);
    }

    private CategoryListItem createItem(MenuCategoryData categoryData) {
        final CategoryListItem listItem = new CategoryListItem(categoryData);
        listItem.addClickListener(event -> {
            if (listItem.equals(selectedItem)) {
                selectedItem.unselect();
                this.selectedItem = null;
                return;
            }
            listItem.select();
            if (selectedItem != null)
                selectedItem.unselect();
            this.selectedItem = listItem;

            if (this.selectedItem.getCategory() != null) {
                this.dishesList.setCategoryId(this.selectedItem.getCategory().getID());
            }
        });
        return listItem;
    }


//    private MenuBar createMenu() {
//        final MenuBar menu = new MenuBar();
//        this.categoryItemsNames.forEach(title -> menu.addItem(title, event -> this.navigator.router(title)));
//        return menu;
//    }

}
