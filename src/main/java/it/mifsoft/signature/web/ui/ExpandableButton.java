package it.mifsoft.signature.web.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;

public class ExpandableButton extends Div {
    private static final String WIDTH = "405px";

    private boolean isExpanded = false;
    private final Button button;
    private final Div content;

    public ExpandableButton(String title, Component... components) {
        this.content = new Div();

        //this.content.setWidth(WIDTH);
        //this.content.setHeight("100%");
        //this.content.setMaxHeight("400px");
        this.content.setVisible(false);

        this.content.add(components);

        this.button = new Button(title);

        //this.button.setWidth(WIDTH);
        //this.button.setHeight("70px");
        this.button.addClickListener(event -> {
            if (!isExpanded) {
                this.content.setVisible(true);
                isExpanded = true;
            } else {
                this.content.setVisible(false);
                isExpanded = false;
            }
        });
        this.button.addClassName("expandable-button");
        this.addClassName("expandable-button-container");
        this.add(this.button, this.content);
    }

    public Image createHeaderImg() {
        Image headerImg = new Image("img/header-image.png", "");
        headerImg.addClassName("header-img");
        this.add(headerImg);
        return headerImg;
    }
}
