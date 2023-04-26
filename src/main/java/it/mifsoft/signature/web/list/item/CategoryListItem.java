package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.html.Paragraph;
import it.mifsoft.signature.web.dto.MenuCategoryData;

public class CategoryListItem extends Paragraph {

    private boolean isSelected;
    private final MenuCategoryData category;

    public CategoryListItem(MenuCategoryData category) {
        this.category = category;
        this.addClassNames("category-list-item-main");
        stylize();
    }

    private void stylize() {
        if (this.category != null)
            this.setText(this.category.getName());
        this.getStyle().setBackground("transparent");
    }

    public void select() {
        this.isSelected = true;
        this.getStyle().set("color", "#FFFFFF");
    }

    public void unselect() {
        this.isSelected = false;
        this.getStyle().set("color", "#A0AEAF");
    }

    public boolean isSelected() {
        return isSelected;
    }

    public MenuCategoryData getCategory() {
        return category;
    }
}
