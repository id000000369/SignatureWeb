package it.mifsoft.signature.web;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ui.FooterView;
import it.mifsoft.signature.web.ui.HeaderView;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "/")
public class MainLayout extends Div implements RouterLayout, AfterNavigationObserver {

    private final HeaderView headerView;
    private final ContentLayout contentView;
    private final FooterView footerView;

    public MainLayout(HeaderView headerView,
                      ContentLayout contentView,
                      FooterView footerView) {
        this.headerView = headerView;
        this.contentView = contentView;
        this.footerView = footerView;
        this.setHeight("100vh");
        this.getStyle().setOverflow(Style.Overflow.HIDDEN);
        add(headerView);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        this.add(this.footerView);
    }


    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        final var location = event.getLocation();
        final String path = location.getPath();

        if (location.getPath().equals("main/vines")) {
            this.getStyle().set("background-image", "url('./img/background-vine.png')");
        } else if (location.getPath().equals("main/pictures")) {
            this.getStyle().set("background-image", "url('./img/background-vine.png')");
        } else if (location.getPath().equals("main/dishes")) {
            this.getStyle().set("background-image", "url('./img/background-vine.png')");
        }
    }
}
