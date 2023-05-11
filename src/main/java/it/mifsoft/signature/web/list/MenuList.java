package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.SignatureNavigator;
import it.mifsoft.signature.web.list.item.MenuListItem;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@UIScope
public class MenuList extends Div {
    private final Image backgroundImg;
    private final SignatureNavigator navigator;
    private Collection<String> menuItemsNames = List.of(
            "О НАС", "ЭКСПОЗИЦИЯ", "ВИННАЯ ГАЛЕРЕЯ", "МЕНЮ", "ЗАБРОНИРОВАТЬ СТОЛИК", "КОНТАКТЫ"
    );
    private final List<MenuListItem> listItems;
    public MenuList(SignatureNavigator navigator) {
        this.navigator = navigator;
        this.listItems = createMenuItems();
        this.listItems.forEach(this::add);
        this.backgroundImg = createBackgroundImg();

        this.getStyle().set("border-radius","16px");
//        this.getStyle().set("width","100%");
//        this.getStyle().set("height","100%");
       // this.getStyle().set("background-color","rgba(0,60,72)");

        this.addClassName("menu-list-container");
      //  this.add(createBackgroundImg());
    }

    private Image createBackgroundImg() {
        final Image img = new Image("img/main-menu-img.png","");
        img.addClassName("main-menu-background-img");
        return img;
    }
    private List<MenuListItem> createMenuItems() {
        return this.menuItemsNames.stream().map(title -> {
            final MenuListItem item = new MenuListItem(title);
            item.addClassName("menu-list-item");
            return item;
        }).toList();
    }
}
