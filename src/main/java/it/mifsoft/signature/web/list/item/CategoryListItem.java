package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;

import java.util.Objects;

public class CategoryListItem extends Paragraph {

    private boolean isSelected;
    private String title;

    public CategoryListItem(String title) {
        this.title = title;
        this.addClassNames("category-list-item-main");
        stylize();
    }

    private void stylize() {
        this.setText(this.title);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryListItem listItem = (CategoryListItem) o;
        return Objects.equals(title, listItem.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
