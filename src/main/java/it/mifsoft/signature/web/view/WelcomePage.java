package it.mifsoft.signature.web.view;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.list.DishesShortList;
import it.mifsoft.signature.web.ui.ExpandableButton;
import it.mifsoft.signature.web.ui.menu.MenuItems;
import org.apache.catalina.webresources.FileResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@UIScope
@Route(value = "welcome", layout = ContentLayout.class)
public class WelcomePage extends Div {

    private final ExpandableButton expositionButton;
    private final ExpandableButton aboutUsButton;
    private final ExpandableButton menuButton;
    private final ExpandableButton vineGalleryButton;
    private final ExpandableButton contactsButton;

    private final ExpandableButton guestButton;
    private final ExpandableButton bronButton;

    private final Image mainImg;
    private final Image menuLine;
    private final Image contactsLine;
    private final Image bronLine;
    private final Image guestLine;
    private final Image vineGalleryLine;
    private final Image expositionLine;

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
        this.guestButton = createGuestButton();
        this.bronButton = createBronButton();

        this.contactsLine = createContactsLine();
        this.bronLine = createBronLine();
        this.guestLine = createGuestLine();
        this.vineGalleryLine = createVineGalleryLine();
        this.expositionLine = createExpositionLine();
        this.menuLine = createMenuLine();

        this.mainImg = createContentImg();

        this.add(expositionButton, aboutUsButton, menuButton,
                vineGalleryButton, contactsButton, guestButton, bronButton,
                mainImg,
                contactsLine, bronLine, guestLine, vineGalleryLine, expositionLine, menuLine);
    }
    public Image createContactsLine() {
        Image line = new Image("img/contacts-line.png","");
        line.addClassName("contacts-line");
        return line;
    }

    public Image createBronLine() {
        Image line = new Image("img/bron-line.png","");
        line.addClassName("bron-line");
        return line;
    }

    public Image createGuestLine() {
        Image line = new Image("img/guest-line.png","");
        line.addClassName("guest-line");
        return line;
    }

    public Image createVineGalleryLine() {
        Image line = new Image("img/vine-gallery-line.png","");
        line.addClassName("vine-gallery-line");
        return line;
    }

    public Image createExpositionLine() {
        Image line = new Image("img/exposition-line.png","");
        line.addClassName("exposition-line");
        return line;
    }

    public Image createMenuLine() {
        Image line = new Image("img/menu-line.png","");
        line.addClassName("menu-line");
        return line;
    }
    public Image createContentImg() {
        Image content = new Image("img/main-image.png", "");
        content.addClassName("content-img");
        this.add(content);
        return content;
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
        vineGalleryButton.addClassName("vine-gallery-button");
        return vineGalleryButton;
    }

    public ExpandableButton createContactsButton() {
        final ExpandableButton contactsButton = new ExpandableButton("Контакты", new AboutView());
        contactsButton.addClassName("contacts-button");
        return contactsButton;
    }

    public ExpandableButton createGuestButton() {
        final ExpandableButton guestButton = new ExpandableButton("Оформить карту гостя", new AboutView());
        guestButton.addClassName("guest-button");
        return guestButton;
    }

    public ExpandableButton createBronButton() {
        final ExpandableButton bronButton = new ExpandableButton("Забронировать столик", new AboutView());
        bronButton.addClassName("bron-button");
        return bronButton;
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
       // this.getStyle().set("background-image", "url('https://i.ibb.co/HNgSvkm/main-image-IMG-4926-1.png')");
    }
}
