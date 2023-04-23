package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.dto.CategoryData;
import it.mifsoft.signature.web.list.item.CategoryListItem;
import it.mifsoft.signature.web.utils.FlexStyleUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@UIScope
public class CategoriesList extends Div {

    private final List<CategoryData> categories = new ArrayList<>();

    private final List<CategoryListItem> listItems;
    private CategoryListItem selectedItem;

    private final DishesList dishesList;

//    private Collection<String> categoryItemsNames = List.of(
//            "RAW БАР", "САЛАТЫ", "ОВОЩИ", "СУПЫ", "ГОРЯЧИЕ БЛЮДА", "ДЕСЕРТЫ", "НАПИТКИ"
//    );

    public CategoriesList(DishesList dishesList) {

        FlexStyleUtils.doItRow(this.getElement());

        //test
        for (int i = 0; i < 10; i++) {
            CategoryData data = new CategoryData();
            data.setID(i);
            data.setName("Title " + i);
            this.categories.add(data);
        }


        this.addClassNames("categories-list-main");
        this.dishesList = dishesList;
        this.listItems = createListItems();

        this.listItems.forEach(this::add);
    }

    private List<CategoryListItem> createListItems() {
        return categories.stream()
                .map(this::createItem)
                .toList();
    }

    private CategoryListItem createItem(CategoryData categoryData) {
        final CategoryListItem listItem = new CategoryListItem(categoryData.getName());
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
        });
        return listItem;
    }


//    private MenuBar createMenu() {
//        final MenuBar menu = new MenuBar();
//        this.categoryItemsNames.forEach(title -> menu.addItem(title, event -> this.navigator.router(title)));
//        return menu;
//    }

}
