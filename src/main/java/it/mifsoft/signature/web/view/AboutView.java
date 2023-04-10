package it.mifsoft.signature.web.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "hello", layout = ContentLayout.class)
public class AboutView extends Div {

    public AboutView() {
        this.add(new Paragraph("Hello world"));
        this.setWidth("500px");
        this.setHeight("500px");
        this.getStyle().setBackground("pink");
    }
}
