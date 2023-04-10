package it.mifsoft.signature.web;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RoutePrefix;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ui.HeaderView;
import org.springframework.stereotype.Component;

@Component
@UIScope
@ParentLayout(MainLayout.class)
@RoutePrefix("main")
public final class ContentLayout extends Div implements HasModal, RouterLayout {
    private final HeaderView headerView;

    public ContentLayout(HeaderView headerView) {
        this.headerView = headerView;

        this.getStyle().setBackground("orange");
        this.addClassName("content-view");
        this.add(headerView);
    }

    @Override
    public void setModal(com.vaadin.flow.component.Component component) {

    }

    @Override
    public void showModal() {

    }

    @Override
    public void hideModal() {

    }
}
