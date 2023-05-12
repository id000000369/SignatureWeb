package it.mifsoft.signature.web.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;

import javax.swing.*;
import java.util.Collection;

public class ExpositionView extends Div {

    private final Paragraph expositionText;

    public ExpositionView() {
        expositionText = new Paragraph();

        String contentTemplate = """
                C 23 марта у нас проходит выставка трех художников – %s %s, %s
                """;
        String hrefTemplate = " <a href=\"%s\" style=\"color:rgb(145,121,58)\">%s</a>";
        String content = String.format(
                contentTemplate,
                String.format(hrefTemplate, "https://www.instagram.com/ivan_fedotov_art/", "@ivan_fedotov_art"),
                String.format(hrefTemplate, "https://www.instagram.com/oksanazarova/", "@oksanazarova"),
                String.format(hrefTemplate, "https://www.instagram.com/pechenevskayalili/", "@pechenevskayalili")
        );
        expositionText.getElement().setProperty("innerHTML", content);

        this.addClassName("exposition-view");
        this.expositionText.addClassName("exposition-text");
        this.add(expositionText);
    }
}
