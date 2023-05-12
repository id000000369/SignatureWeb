package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ModalDelegate;
import it.mifsoft.signature.web.SignatureNavigator;
import it.mifsoft.signature.web.list.item.MenuListItem;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@UIScope
public class MenuList extends Div {

    private ModalDelegate delegate;
    private final Image backgroundImg;
    private final SignatureNavigator navigator;
    private final Collection<Holder> menuItemsHolders;
    private final List<MenuListItem> listItems;

    public MenuList(SignatureNavigator navigator) {
        this.navigator = navigator;
        this.menuItemsHolders = createMenuItemHolders(navigator);
        this.listItems = createMenuItems();
        this.listItems.forEach(this::add);
        this.backgroundImg = createBackgroundImg();

        this.getStyle().set("border-radius", "16px");
//        this.getStyle().set("width","100%");
//        this.getStyle().set("height","100%");
        // this.getStyle().set("background-color","rgba(0,60,72)");

        this.addClassName("menu-list-container");
        //  this.add(createBackgroundImg());
    }

    public void setDelegate(ModalDelegate delegate) {
        this.delegate = delegate;
    }

    private Collection<Holder> createMenuItemHolders(SignatureNavigator nav) {
        return List.of(
                new Holder("О НАС", event -> nav.navigateToAbout()),
                new Holder("ЭКСПОЗИЦИЯ", event -> nav.navigateToPicturesGallery()),
                new Holder("ВИННАЯ ГАЛЕРЕЯ", event -> nav.navigateToVinesGallery()),
                new Holder("МЕНЮ", event -> nav.navigateToMenu()),
                new Holder("ЗАБРОНИРОВАТЬ СТОЛИК", event -> {
                    if (delegate != null) {
                        delegate.showReserveForm();
                    }
                }),
                new Holder("КОНТАКТЫ", event -> nav.navigateToContacts())
        );
    }

    private Image createBackgroundImg() {
        final Image img = new Image("img/main-menu-img.png", "");
        img.addClassName("main-menu-background-img");
        return img;
    }

    private List<MenuListItem> createMenuItems() {
        return this.menuItemsHolders.stream().map(holder -> {
            final MenuListItem item = new MenuListItem(holder.title);
            item.addClassName("menu-list-item");
            item.addClickListener(holder.listener);
            return item;
        }).toList();
    }

    static class Holder {
        final String title;
        final ComponentEventListener<ClickEvent<Div>> listener;

        Holder(String title, ComponentEventListener<ClickEvent<Div>> listener) {
            this.title = title;
            this.listener = listener;
        }
    }
}
