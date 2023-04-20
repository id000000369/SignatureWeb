package it.mifsoft.signature.web;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.forms.ReserveForm;
import it.mifsoft.signature.web.ui.FooterView;
import it.mifsoft.signature.web.ui.HeaderView;
import it.mifsoft.signature.web.utils.FlexStyleUtils;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "/")
public class MainLayout extends Div implements RouterLayout, AfterNavigationObserver {

    private final HeaderView headerView;
    private final ContentLayout contentView;
    private final FooterView footerView;
    private final ReserveForm reserveForm;
    private final Div modalView;
    private boolean isModalVisible = false;

    public MainLayout(HeaderView headerView,
                      ContentLayout contentView,
                      FooterView footerView, ReserveForm reserveForm) {
        this.headerView = headerView;
        this.contentView = contentView;
        this.footerView = footerView;
        this.reserveForm = reserveForm;
        this.setHeight("100vh");
        this.getStyle().setOverflow(Style.Overflow.HIDDEN);

        this.modalView = createModalView(this.reserveForm);

        add(headerView);
    }

    public void showModal() {
        if (isModalVisible) {
            return;
        }

        if (this.getChildren().noneMatch(c -> c == this.modalView)) {
            this.add(this.modalView);
            this.isModalVisible = true;
        }
    }

    public void hideModal() {
        if (!isModalVisible) {
            return;
        }
        if (this.getChildren().anyMatch(c -> c == this.modalView)) {
            this.remove(this.modalView);
            this.isModalVisible = false;
        }
    }

    private Div createModalView(ReserveForm form) {
        final Div div = new Div();
        div.setWidthFull();
        div.setHeightFull();
        FlexStyleUtils.doItCenteredRow(div.getElement());
        div.getStyle().setPosition(Style.Position.ABSOLUTE);
        div.getStyle().setLeft("0px");
        div.getStyle().setTop("0px");
        div.getStyle().setZIndex(Integer.MAX_VALUE - Byte.MAX_VALUE);
        form.getStyle().setZIndex(Integer.MAX_VALUE);
        div.getStyle().set("background", "rgba(255, 255, 255, 0.33)");
        div.getStyle().set("backdrop-filter", "blur(10px)");
        div.add(form);
        div.addClickListener(event -> {

        });
        return div;
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        this.footerView.reserveButton.addClickListener((event) -> {
            if (!isModalVisible) {
                showModal();
            }
        });
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
