package it.mifsoft.signature.web;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.forms.ReserveForm;
import it.mifsoft.signature.web.list.MenuList;
import it.mifsoft.signature.web.ui.FooterView;
import it.mifsoft.signature.web.ui.HeaderView;
import it.mifsoft.signature.web.utils.FlexStyleUtils;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "/")
public class MainLayout extends Div implements RouterLayout, AfterNavigationObserver, ModalDelegate {
    private final HeaderView headerView;
    private final ContentLayout contentView;
    private final Image contentImage;
    private final FooterView footerView;
    private final ReserveForm reserveForm;
    private final MenuList menuList;
    private Div modalView;
    private boolean isModalVisible = false;
    private final Image closeModalBtn;
    private final Image menuBackgroundImg;
    public MainLayout(HeaderView headerView,
                      ContentLayout contentView,
                      FooterView footerView,
                      ReserveForm reserveForm,
                      MenuList menuList) {

        this.headerView = headerView;
        this.headerView.setDelegate(this);

        this.contentView = contentView;
        this.footerView = footerView;
        this.footerView.setDelegate(this);

        this.reserveForm = reserveForm;
        this.reserveForm.setDelegate(this);

        this.menuList = menuList;

        this.contentImage = createContentImg();
        this.menuBackgroundImg = createMenuBackgroundImg();

        this.closeModalBtn = createCloseModalBtn();
        this.menuList.setDelegate(this);

        this.addClassNames("main-layout");

        // this.menuListView = createMenuListView(this.menuList);
        this.add(headerView);
    }
    public Image createMenuBackgroundImg() {
        final Image img = new Image("img/main-menu-img.png", "");
        img.getStyle().set("position", "absolute");
        img.getStyle().set("width", "100%");
        img.getStyle().set("height", "100%");
        // img.getStyle().set("z-index","1");
        img.addClassName("modal-menu-img");
        return img;
    }
    public void showModal(HtmlComponent form) {
        if (isModalVisible) {
            return;
        }
        final Div modalView = createModalView(form);
        if (this.getChildren().anyMatch(c -> c == this.modalView)) {
            this.remove(this.modalView);
        }
        if (this.getChildren().noneMatch(c -> c == this.modalView)) {
            this.add(modalView);
            this.isModalVisible = true;
            this.headerView.yellowColor();
            this.reserveForm.setYellowCloseBtn();
        }
        this.modalView = modalView;
    }
    private Div createMenuListView(HtmlComponent form) {
        final Div div = new Div();
        form.getStyle().setZIndex(Integer.MAX_VALUE);
        div.addClassName("adaptive-menu-list-layout");
        div.add(form);
        return div;
    }
    public Image createCloseModalBtn() {
        final Image img = new Image("img/gold-close-icon.png","");
        img.addClickListener(event -> {
            this.hideModal();
            this.headerView.setVisible(true);
        });
        img.addClassName("close-menu-btn");
        return img;
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
        div.getStyle().set("background-color", "rgba(255, 255, 255, 0.33)");
        div.getStyle().set("backdrop-filter", "blur(10px)");
        div.addClassName("modal-view-wrapper");
        div.add(createCloseModalBtn(), form, createMenuBackgroundImg());
        div.addClickListener(event -> {

        });
        return div;
    }
    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        this.footerView.reserveButton.addClickListener((event) -> {
            if (!isModalVisible) {

            }
        });
        this.add(this.footerView);
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        final var location = event.getLocation();
        final String path = location.getPath();

        updateFooterStateByPath(path);
        updateHeaderStateByPath(path);

        if (path.equals("main/welcome")) {
            //this.headerView.yellowColor();
            if (this.getChildren().noneMatch(c -> c == this.contentImage)) {
                this.add(this.contentImage);
            }
//            this.footerView.hideBottom();
            this.footerView.changeFooterPosition();
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
            case "main/vines", "main/dishes", "main/pictures" -> {
                this.getStyle().set("background-image", "url('./img/background-vine.png')");
                //this.headerView.yellowColor();
//                this.footerView.hideBottom();
//                this.footerView.hide();
                this.hideModal();
            }

            case "main/contacts" -> {
                this.getStyle().set("background-image", "url('./img/contacts-background-img.png')");
                //this.headerView.whiteColor();
//                this.footerView.showBottom();
                this.hideModal();
                footerView.addClassNames("contacts-footer");
            }

            case "main/achievement" -> {
                this.getStyle().set("background-image", "url('./img/contacts-background-img.png')");
                //this.headerView.whiteColor();
              //  this.footerView.hideBottom();
                this.hideModal();
               // this.footerView.changeFooterStyle();
            }
            default -> {
                this.getStyle().remove("background-image");
            }
        }
    }

    private void updateFooterStateByPath(String path) {
        switch (path) {
            case "main/vines", "main/dishes", "main/pictures" -> {
                this.footerView.hide();
            }
            case "main/contacts" -> {
                this.footerView.show();
                updateFooterForState(FooterStates.FULL);
            }
            default -> {
                this.footerView.show();
                updateFooterForState(FooterStates.SHORT);
            }
        }
    }

    private void updateHeaderStateByPath(String path) {
        switch (path) {
            case "main/contacts","main/achievement" -> updateHeaderForState(HeaderStates.WHITE);
            default -> updateHeaderForState(HeaderStates.GOLD);
        }
    }

    private void updateFooterForState(FooterStates state) {
        final String SHORT_CLASS_NAME = "short-footer";
        final String FULL_CLASS_NAME = "full-footer";

        if (state.equals(FooterStates.SHORT)) {
            this.footerView.removeClassName(FULL_CLASS_NAME);
            this.footerView.addClassName(SHORT_CLASS_NAME);
        } else if (state.equals(FooterStates.FULL)) {
            this.footerView.removeClassName(SHORT_CLASS_NAME);
            this.footerView.addClassName(FULL_CLASS_NAME);
        }
    }

    private void updateHeaderForState(HeaderStates state) {
        final String GOLD_CLASS_NAME = "gold-header";
        final String WHITE_CLASS_NAME = "white-header";

        if (state.equals(HeaderStates.GOLD)) {
            this.headerView.removeClassName(WHITE_CLASS_NAME);
            this.headerView.addClassName(GOLD_CLASS_NAME);
        } else if (state.equals(HeaderStates.WHITE)) {
            this.headerView.removeClassName(GOLD_CLASS_NAME);
            this.headerView.addClassName(WHITE_CLASS_NAME);
        }
    }

    enum FooterStates {
        SHORT,
        FULL;
    }

    enum HeaderStates {
        GOLD,
        WHITE;
    }

    public Image createContentImg() {
        final Image content = new Image("img/main-img.png", "");
        content.addClassName("content-img");
        return content;
    }
    @Override
    public void hideModal() {
        if (!isModalVisible) {
            return;
        }
        if (this.getChildren().anyMatch(c -> c == this.modalView)) {
            this.remove(this.modalView);
            this.isModalVisible = false;
            this.headerView.setVisible(true);
            this.footerView.setVisible(true);
        }
    }

    @Override
    public void showMenuList() {
        this.showModal(menuList);
    }

    @Override
    public void showReserveForm() {
        this.showModal(reserveForm);
    }
}