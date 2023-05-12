package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;

public class MenuListItem extends Div {
    private final String title;
    public MenuListItem(String title) {
        this.title = title;
        this.getStyle().set("width","382px");
        this.getStyle().set("height","80px");
        this.getStyle().set("display","flex");
        this.getStyle().set("justify-content","center");
        this.getStyle().set("align-items","center");
        this.getStyle().set("border-radius","16px");
        this.getStyle().set("font-size","20px");
        this.getStyle().set("letter-spacing","0.07em");
        this.getStyle().set("text-shadow","0px 4px 4px rgba(0, 0, 0, 0.25)");
        this.getStyle().set("box-shadow","0px 2px 2px rgba(0, 0, 0, 0.25)");
        this.getStyle().set("z-index","-1");
        this.getStyle().set("margin-bottom","8px");
        this.addClassName("menu-item-main");
        this.setText(title);
    }
}