package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;

public class MenuListItem extends Div {
    private final String title;
    private final Button button;
    public MenuListItem(String title) {
        this.title = title;
        this.button = createItemButton();
        this.addClassName("menu-item-main");
        this.add(createItemButton());
    }
    private Button createItemButton() {
        final Button btn = new Button();
        btn.getStyle().set("width","382px");
        btn.getStyle().set("height","80px");
        btn.getStyle().set("padding-bottom","8px");
        btn.getStyle().set("color","rgba(160, 174, 175, 1)");
        btn.getStyle().set("border-radius","16px");
        btn.getStyle().set("text-align","center");
        btn.getStyle().set("font-size","20px");
        btn.getStyle().set("letter-spacing","0.07em");
        btn.getStyle().set("backdrop-filter","blur(12px)");
        btn.getStyle().set("text-shadow","0px 4px 4px rgba(0, 0, 0, 0.25)");
        btn.getStyle().set("background-image","linear-gradient(to right top, rgb(10 54 60) 0%, rgb(15 89 100) 51%, rgb(84 113 116) 100%)");
        btn.addClassName("menu-item-button");
        btn.setText(this.title);
        return btn;
    }
}