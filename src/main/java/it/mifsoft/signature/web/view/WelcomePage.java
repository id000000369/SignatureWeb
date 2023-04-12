package it.mifsoft.signature.web.view;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.list.DishesShortList;
import it.mifsoft.signature.web.ui.ExpandableButton;
import it.mifsoft.signature.web.ui.menu.MenuItems;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "welcome", layout = ContentLayout.class)
public class WelcomePage extends Div {

    private final ExpandableButton expositionButton;
    private final ExpandableButton aboutUsButton;
    private final ExpandableButton menuButton;
    private final ExpandableButton vineGalleryButton;
    private final ExpandableButton contactsButton;

    public WelcomePage() {
//        MenuItems.MENU_ITEM_NAMES.forEach(title -> {
//            var button = new ExpandableButton(title, new AboutView());
//            this.add(button);
//        });

        this.expositionButton = createExpositionButton();
        this.aboutUsButton = createAboutUsButton();
        this.menuButton = createMenuButton();
        this.vineGalleryButton = createVineGalleryButton();
        this.contactsButton = createContactsButton();
        this.add(expositionButton, aboutUsButton, menuButton, vineGalleryButton, contactsButton);
    }

    public ExpandableButton createExpositionButton() {
        final ExpandableButton expositionButton = new ExpandableButton("Экспозиция", new AboutView());
        expositionButton.addClassName("exposition-button");
        return expositionButton;
    }

    public ExpandableButton createAboutUsButton() {
        final ExpandableButton aboutUsButton = new ExpandableButton("О нас", new AboutView());
        aboutUsButton.addClassName("about-us-button");
        return aboutUsButton;
    }

    public ExpandableButton createMenuButton() {
        final ExpandableButton menuButton = new ExpandableButton("Меню", new AboutView());
        menuButton.addClassName("menu-button");
        return menuButton;
    }

    public ExpandableButton createVineGalleryButton() {
        final ExpandableButton vineGalleryButton = new ExpandableButton("Винная галерея", new AboutView());
        vineGalleryButton.addClassName("menu-button");
        return vineGalleryButton;
    }

    public ExpandableButton createContactsButton() {
        final ExpandableButton contactsButton = new ExpandableButton("Контакты", new AboutView());
        contactsButton.addClassName("contacts-button");
        return contactsButton;
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
       // this.getStyle().set("background-image", "url('https://i.ibb.co/HNgSvkm/main-image-IMG-4926-1.png')");
    }
}
