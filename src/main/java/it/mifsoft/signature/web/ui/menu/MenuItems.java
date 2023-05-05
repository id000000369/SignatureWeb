package it.mifsoft.signature.web.ui.menu;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.SignatureNavigator;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
@Component
@UIScope
public class MenuItems extends Div {
    private final MenuBar menuList;
    private final List<MenuItem> menuItems;
    private final SignatureNavigator navigator;
    public static final Collection<String> MENU_ITEM_NAMES = List.of(
            "О НАС", "ЭКСПОЗИЦИЯ", "ВИННАЯ ГАЛЕРЕЯ", "МЕНЮ", "ЗАБРОНИРОВАТЬ", "КОНТАКТЫ"
    );
     public MenuItems(SignatureNavigator navigator){
         this.navigator = navigator;
         this.menuList = createMenu();
         this.menuItems = createMenuItems(this.menuList);
         menuList.addClassName("adaptive-menu-list");
         this.addClassName("adaptive-menu-list-adaptive");
         this.add(menuList);
     }
    private MenuBar createMenu() {
        final MenuBar menu = new MenuBar();
        return menu;
    }
    private List<MenuItem> createMenuItems(MenuBar menu) {
        return this.MENU_ITEM_NAMES.stream().map(title -> {
            final MenuItem item = menu.addItem(title, event -> this.navigator.router(title));
            item.addClassName("adaptive-menu-item");
            return item;
        }).toList();
    }
}
