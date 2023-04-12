package it.mifsoft.signature.web;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ui.FooterView;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "/")
public class MainLayout extends VerticalLayout implements RouterLayout {

    private final ContentLayout contentView;
    private final FooterView footerView;

    public MainLayout(ContentLayout contentView,
                      FooterView footerView) {
        this.contentView = contentView;
        this.footerView = footerView;
        this.setSpacing(false);
        this.setHeight("100vh");
    }
    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        this.add(this.footerView);
    }
}
