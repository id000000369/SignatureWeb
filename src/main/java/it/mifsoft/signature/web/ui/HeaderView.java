package it.mifsoft.signature.web.ui;


import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.SignatureNavigator;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@UIScope
public class HeaderView extends HorizontalLayout {

    private final String LOGO_IMAGE_SRC = "https://i.ibb.co/GQm92bq/Vector-1.png";

    private Collection<String> menuItemsNames = List.of(
            "О НАС", "ЭКСПОЗИЦИЯ", "ВИННАЯ ГАЛЕРЕЯ", "МЕНЮ", "КОНТАКТЫ"
    );

    private final Image logoImage;
    private final MenuBar menuList;
    private final SignatureNavigator navigator;

    public HeaderView(SignatureNavigator navigator) {
//        this.getStyle().set("background-image", "url('https://i.ibb.co/Vtn861j/light-gradient.png')");

        this.navigator = navigator;
        this.logoImage = createImage();
        this.menuList = createMenu();

        this.addClassName("header");

        logoImage.addClassName("header-logo");
        menuList.addClassName("menu-list");

        this.add(logoImage, menuList);
    }

    private Image createImage() {
        Image logoImage = new Image();
        logoImage.setSrc(LOGO_IMAGE_SRC);
        logoImage.addClickListener(event -> this.navigator.navigateToHome());
        return logoImage;
    }

    private MenuBar createMenu() {
        final MenuBar menu = new MenuBar();
        this.menuItemsNames.forEach(title -> menu.addItem(title, event -> this.navigator.router(title)));
        return menu;
    }
}
