package it.mifsoft.signature.web.ui;


import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.AbstractSignatureNavigator;
import it.mifsoft.signature.web.MainLayout;
import it.mifsoft.signature.web.SignatureNavigator;
import it.mifsoft.signature.web.list.MenuList;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@UIScope
public class HeaderView extends HorizontalLayout {
    public interface HeaderViewDelegate {
        void showMenuList();
    }
    private HeaderViewDelegate delegate;

    AbstractSignatureNavigator navigate;
    private final String LOGO_IMAGE_SRC = "https://i.ibb.co/GQm92bq/Vector-1.png";
    private Collection<String> menuItemsNames = List.of(
            "О НАС", "ЭКСПОЗИЦИЯ", "ВИННАЯ ГАЛЕРЕЯ", "МЕНЮ", "КОНТАКТЫ"
    );
    private final Image logoImage;
    private final MenuBar menuBar;
    private final List<MenuItem> menuItems;
    private final SignatureNavigator navigator;
    private final Image mobileMenuButtonImg;

    public HeaderView(SignatureNavigator navigator) {
        this.navigator = navigator;

        this.logoImage = createImage();
        this.menuBar = createMenu();
        this.menuItems = createMenuItems(this.menuBar);
        this.mobileMenuButtonImg = createMobileMenuButtonImg();

        this.addClassName("header");

        logoImage.addClassName("header-logo");

        this.add(logoImage, menuBar, createMobileMenuButtonImg());
    }

    public Image createMobileMenuButtonImg(){
        final Image img = new Image("/img/mobile-menu-button.png","");
        img.addClickListener(event -> {
            if (delegate != null) {
                delegate.showMenuList();
            }
        });
        img.addClassName("mobile-menu-button");

        return img;
    }

    private Image createImage() {
        Image logoImage = new Image();
        logoImage.setSrc(LOGO_IMAGE_SRC);
        logoImage.addClickListener(event -> this.navigator.navigateToHome());
        return logoImage;
    }

    private MenuBar createMenu() {
        final MenuBar menu = new MenuBar();
        return menu;
    }

    private List<MenuItem> createMenuItems(MenuBar menu) {
        return this.menuItemsNames.stream().map(title -> {
            final MenuItem item = menu.addItem(title, event -> this.navigator.router(title));
            item.addClassName("menu-item");
            return item;
        }).toList();
    }

    public void whiteColor() {
        this.menuItems.forEach(item -> item.getStyle().set("color", "#FFFFFF"));
        this.logoImage.setSrc("/img/signature-white.png");
    }

    public void yellowColor() {
        this.menuItems.forEach(item -> item.getStyle().set("color", "#91793a"));
        this.logoImage.setSrc("/img/signature-yellow.png");
    }

    public void setDelegate(HeaderViewDelegate delegate) {
        this.delegate = delegate;
    }
}
