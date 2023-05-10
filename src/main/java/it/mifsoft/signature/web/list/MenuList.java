package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.SignatureNavigator;
import it.mifsoft.signature.web.list.item.MenuListItem;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@UIScope
public class MenuList extends Div {
    private final SignatureNavigator navigator;
   // private final Div menuContainer;
    private Collection<String> menuItemsNames = List.of(
            "О НАС", "ЭКСПОЗИЦИЯ", "ВИННАЯ ГАЛЕРЕЯ", "МЕНЮ", "ЗАБРОНИРОВАТЬ СТОЛИК", "КОНТАКТЫ"
    );
    public MenuList(SignatureNavigator navigator) {
        this.navigator = navigator;
        // this.menuContainer = createMenuContainer();
        this.addClassName("adaptive-menu-items-container");
    }
    private List<MenuListItem> createMenuItems() {
        return this.menuItemsNames.stream().map(title -> {
            final MenuListItem item = new MenuListItem();
            item.addClassName("adaptive-menu-items");
            return item;
        }).toList();
    }
    private Div createMenuContainer(List<MenuListItem> items) {
        final Div container = new Div();
        items.forEach(this::add);
        container.addClassName("menu-items-list");
        return container;
    }
}
