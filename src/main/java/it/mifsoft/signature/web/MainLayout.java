package it.mifsoft.signature.web;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.forms.ReserveForm;
import it.mifsoft.signature.web.ui.FooterView;
import it.mifsoft.signature.web.ui.HeaderView;
import it.mifsoft.signature.web.ui.menu.MenuItems;
import it.mifsoft.signature.web.utils.FlexStyleUtils;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "/")
public class MainLayout extends Div implements RouterLayout, AfterNavigationObserver {

    private final HeaderView headerView;
    private final ContentLayout contentView;
    private final Image contentImage;
    private final FooterView footerView;
    private final ReserveForm reserveForm;
    private final MenuItems menuItems;
    private final Div modalView;
    private boolean isModalVisible = false;

    public MainLayout(HeaderView headerView,
                      ContentLayout contentView,
                      FooterView footerView,
                      ReserveForm reserveForm,
                      MenuItems menuItems) {
        this.headerView = headerView;
        this.contentView = contentView;
        this.footerView = footerView;
        this.reserveForm = reserveForm;
        this.menuItems = menuItems;

        this.contentImage = createContentImg();

        this.setHeight("100vh");
        this.getStyle().setOverflow(Style.Overflow.AUTO);
        this.getStyle().set("background-repeat", "repeat-x");

        this.modalView = createModalView(this.reserveForm);
        this.add(headerView);
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

    private Div createModalView(HtmlComponent form) {
        final Div div = new Div();
        div.setWidthFull();
        div.setHeightFull();
        FlexStyleUtils.doItCenteredRow(div.getElement());
        div.getStyle().setPosition(Style.Position.ABSOLUTE);
        div.getStyle().setLeft("0px");
        div.getStyle().setTop("0px");
        div.getStyle().setZIndex(3);
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
        if (path.equals("main/welcome")) {
            this.headerView.yellowColor();
            if (this.getChildren().noneMatch(c -> c == this.contentImage)) {
                this.add(this.contentImage);
            }
            this.contentImage.setVisible(true);
        } else {
            if (this.getChildren().anyMatch(c -> c == this.contentImage)) {
                this.contentImage.setVisible(false);
            }
        }

        if (path.equals("main/pictures")) {
            this.contentView.setClassName("content-view-pictures");
        } else {
            this.contentView.setClassName("content-view");
        }

        switch (path) {
            case "main/vines", "main/dishes", "main/pictures", "main/welcome" -> {
                this.getStyle().set("background-image", "url('./img/background-vine.png')");
                this.headerView.yellowColor();
                this.footerView.hideBottom();
            }
            case "main/contacts", "main/achievement" -> {
                this.getStyle().set("background-image", "url('./img/contacts-background-img.png')");
                this.headerView.whiteColor();
                this.footerView.showBottom();
            }
            default -> {
                this.getStyle().remove("background-image");
                this.footerView.showBottom();
            }
        }
    }

    public Image createContentImg() {
        final Image content = new Image("img/main-img.png", "");
        content.addClassName("content-img");
        return content;
    }
}
