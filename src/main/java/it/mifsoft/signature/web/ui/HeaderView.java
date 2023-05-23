package it.mifsoft.signature.web.ui;


import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ModalDelegate;
import it.mifsoft.signature.web.SignatureNavigator;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@UIScope
public class HeaderView extends HorizontalLayout {
    private ModalDelegate delegate;
    private Collection<String> menuItemsNames = List.of(
            "О НАС", "ЭКСПОЗИЦИЯ", "ВИННАЯ ГАЛЕРЕЯ", "МЕНЮ", "КОНТАКТЫ"
    );
    public Image yellowLogoImage;
    public Image whiteLogoImage;
    public Image logoImage;
    private final MenuBar menuBar;
    private final List<MenuItem> menuItems;
    private final SignatureNavigator navigator;
    private final Image menuButtonImg;

    public HeaderView(SignatureNavigator navigator) {
        this.navigator = navigator;

//        this.yellowLogoImage = createYellowLogo();
//        this.whiteLogoImage = createWhiteLogo();
        this.logoImage = createLogo();

        this.menuBar = createMenu();
        this.menuItems = createMenuItems(this.menuBar);
        this.menuButtonImg = createMobileMenuButtonImg();

        this.addClassName("header");
        this.add(logoImage, menuBar, menuButtonImg);
    }

    public Image createMobileMenuButtonImg() {
        final Image menuButtonImg = new Image();
        menuButtonImg.setSrc("");
        menuButtonImg.addClickListener(event -> {
            if (delegate != null) {
                delegate.showMenuList();
            }
        });
        menuButtonImg.addClassName("mobile-menu-button");
        return menuButtonImg;
    }
    private Image createLogo() {
        Image logo = new Image();
        logo.setSrc("");
        logo.addClassName("header-logo");
        logo.addClickListener(event -> this.navigator.navigateToHome());
        return logo;
    }
//    private Image createYellowLogo() {
//        Image yellowLogoImage = new Image();
//        //yellowLogoImage.setSrc("img/signature-yellow.png");
//        yellowLogoImage.addClassName("yellow-header-logo");
//        yellowLogoImage.addClickListener(event -> this.navigator.navigateToHome());
//        return yellowLogoImage;
//    }
//    private Image createWhiteLogo() {
//        Image whiteLogoImage = new Image();
//        //whiteLogoImage.setSrc("img/signature-white.png");
//        whiteLogoImage.addClassName("white-header-logo");
//        whiteLogoImage.addClickListener(event -> this.navigator.navigateToHome());
//        return whiteLogoImage;
//    }

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
        this.logoImage.getStyle().set("display","block");
        this.menuItems.forEach(item -> item.getStyle().set("color", "#FFFFFF"));
        this.logoImage.setSrc("/img/signature-white.png");
     //   this.menuButtonImg.setSrc("/img/white-menu-btn.png");
    }

    public void yellowColor() {
        this.logoImage.getStyle().set("display","block");
        this.menuItems.forEach(item -> item.getStyle().set("color", "#91793a"));
        this.logoImage.setSrc("/img/signature-yellow.png");
     //   this.menuButtonImg.setSrc("/img/yellow-menu-btn.png");
    }

    public void setWhiteMenuBtnColor() {
        this.menuButtonImg.setSrc("/img/white-menu-btn.png");
    }
    public void setYellowMenuBtnColor() {
        this.menuButtonImg.setSrc("/img/yellow-menu-btn.png");
    }

//    public void hideYellowLogo() {
//        this.yellowLogoImage.getStyle().set("display","none");
//    }
//    public void hideWhiteLogo() {
//        this.whiteLogoImage.getStyle().set("display","none");
//    }
//    public void showYellowLogo() {
//      //  this.yellowLogoImage.getStyle().set("display","block");
//        this.yellowLogoImage.setSrc("/img/signature-yellow.png");
//    }
//    public void showWhiteLogo() {
//       // this.whiteLogoImage.getStyle().set("display","block");
//        this.yellowLogoImage.setSrc("/img/signature-white.png");
//
//    }
    public void setDelegate(ModalDelegate delegate) {
        this.delegate = delegate;
    }
}
