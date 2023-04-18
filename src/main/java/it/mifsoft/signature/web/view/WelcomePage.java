package it.mifsoft.signature.web.view;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.ui.ExpandableButton;
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
    private final ExpandableButton guestButton;
    private final ExpandableButton bronButton;

    private final Image mainImg;
    //private final Image headerImg;

    private final Image menuLine;
    private final Image contactsLine;
    private final Image bronLine;
    private final Image guestLine;
    private final Image vineGalleryLine;
    private final Image expositionLine;

    private final Image firstSideIcon;
    private final Image secondSideIcon;
    private final Image thirdSideIcon;
    private final Image fourthSideIcon;
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

        this.firstSideIcon = createFirstSideIcon();
        this.secondSideIcon = createSecondSideIcon();
        this.thirdSideIcon = createThirdSideIcon();
        this.fourthSideIcon = createFourthSideIcon();

        this.mainImg = createContentImg();
        //this.headerImg = createHeaderImg();
        this.add(expositionButton, aboutUsButton, menuButton,
                vineGalleryButton, contactsButton, guestButton, bronButton,
                mainImg,
                contactsLine, bronLine, guestLine, vineGalleryLine, expositionLine, menuLine,
                firstSideIcon, secondSideIcon, thirdSideIcon, fourthSideIcon);
    }

    public Image createFirstSideIcon() {
        final Image sideIcon = new Image("img/first-side-icon.png", "");
        sideIcon.addClassName("first-side-icon");
        this.add(sideIcon);
        return sideIcon;
    }
    public Image createSecondSideIcon() {
        final Image sideIcon = new Image("img/second-side-icon", "");
        sideIcon.addClassName("second-side-icon");
        this.add(sideIcon);
        return sideIcon;
    }
    public Image createThirdSideIcon() {
        final Image sideIcon = new Image("img/third-side-icon", "");
        sideIcon.addClassName("third-side-icon");
        this.add(sideIcon);
        return sideIcon;
    }
    public Image createFourthSideIcon() {
        final Image sideIcon = new Image("img/fourth-side-icon", "");
        sideIcon.addClassName("fourth-side-icon");
        this.add(sideIcon);
        return sideIcon;
    }
    public Image createContentImg() {
        final Image content = new Image("img/main-img.png", "");
        content.addClassName("content-img");
        this.add(content);
        return content;
    }
    public Image createContactsLine() {
        final Image line = new Image("img/contacts-line.png","");
        line.addClassName("contacts-line");
        return line;
    }

    public Image createBronLine() {
        final Image line = new Image("img/bron-line.png","");
        line.addClassName("bron-line");
        return line;
    }

    public Image createGuestLine() {
        final Image line = new Image("img/guest-line.png","");
        line.addClassName("guest-line");
        return line;
    }

    public Image createVineGalleryLine() {
        final Image line = new Image("img/vine-gallery-line.png","");
        line.addClassName("vine-gallery-line");
        return line;
    }

    public Image createExpositionLine() {
        final Image line = new Image("img/exposition-line.png","");
        line.addClassName("exposition-line");
        return line;
    }

    public Image createMenuLine() {
        final Image line = new Image("img/menu-line.png","");
        line.addClassName("menu-line");
        return line;
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
