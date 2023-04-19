package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.dto.CategoryData;
import it.mifsoft.signature.web.list.item.CategoryListItem;
import it.mifsoft.signature.web.utils.SignatureStyleUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@UIScope
public class CategoriesList extends Div {

    private final List<CategoryData> categories = new ArrayList<>();

    private final List<CategoryListItem> listItems;
    private CategoryListItem selectedItem;

    private final DishesList dishesList;
    private final ArchivesList archivesList;

    public CategoriesList(DishesList dishesList, ArchivesList archivesList) {

        SignatureStyleUtils.doItRow(this.getElement());

        //test
        for (int i = 0; i < 10; i++) {
            CategoryData data = new CategoryData();
            data.setID(i);
            data.setName("Title " + i);
            this.categories.add(data);
        }


        this.addClassNames("categories-list-main");
        this.dishesList = dishesList;
        this.archivesList = archivesList;
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
            if (listItem.equals(selectedItem))
                return;
            listItem.select();
            selectedItem.unselect();
            this.selectedItem = listItem;
        });
        return listItem;
    }

}
