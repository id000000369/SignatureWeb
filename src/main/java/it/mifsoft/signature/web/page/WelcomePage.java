package it.mifsoft.signature.web.page;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.MainLayout;
import it.mifsoft.signature.web.ModalDelegate;
import it.mifsoft.signature.web.SignatureNavigator;
import it.mifsoft.signature.web.forms.ReserveForm;
import it.mifsoft.signature.web.list.DishesShortList;
import it.mifsoft.signature.web.ui.ExpandableButton;
import it.mifsoft.signature.web.view.AboutView;
import it.mifsoft.signature.web.view.ExpositionView;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "welcome", layout = ContentLayout.class)
public class WelcomePage extends Div {
    private final SignatureNavigator navigator;
    private final MainLayout mainLayout;
    private final ExpandableButton expositionButton;
    private final ExpandableButton aboutUsButton;
    private final ExpandableButton menuButton;
    private final ExpandableButton vineGalleryButton;
    private final ExpandableButton contactsButton;
    private final ExpandableButton guestButton;
    private final ExpandableButton reserveButton;

    private final Image menuLine;
    private final Image contactsLine;
    private final Image reserveLine;
    private final Image guestLine;
    private final Image vineGalleryLine;
    private final Image expositionLine;
    private final Image mainFirstMobileImg;
    private final Image mainSecondMobileImg;
    private final Image mainThirdMobileImg;
    private final Image mobileHeaderGradient;


//    private final Image firstSideIcon;
//    private final Image secondSideIcon;
//    private final Image thirdSideIcon;
//    private final Image fourthSideIcon;

    private final Div fisrtDiv;
    private final Div secondDiv;
    private final Div thirdDiv;
    private final Div fourthDiv;
    private final Div fiveDiv;
    private final Div sixDiv;
    private final Div sevenDiv;
    private final Div eightDiv;
    private final Div nineDiv;
    private final Div tenDiv;
    private final Div elevenDiv;
    private final Div twelveDiv;
    private final Div thirteenDiv;
    private final Div fourteenDiv;
    private final Div fifteenDiv;
    private final Div sixteenDiv;
    private final Div columnContainer;

    private final ReserveForm reserveForm;
    private final Div mainContainer;
    private final Image backgroundImg;

    public WelcomePage(SignatureNavigator navigator, MainLayout mainLayout, ReserveForm reserveForm) {
        this.navigator = navigator;
        this.mainLayout = mainLayout;
        this.reserveForm = reserveForm;
        this.expositionButton = createExpositionButton();
        this.aboutUsButton = createAboutUsButton();
        this.menuButton = createMenuButton();
        this.vineGalleryButton = createVineGalleryButton();
        this.contactsButton = createContactsButton();
        this.guestButton = createGuestButton();
        this.reserveButton = createReserveButton();

        this.contactsLine = createContactsLine();
        this.reserveLine = createReserveLine();
        this.guestLine = createGuestLine();
        this.vineGalleryLine = createVineGalleryLine();
        this.expositionLine = createExpositionLine();
        this.menuLine = createMenuLine();

//        this.firstSideIcon = createFirstSideIcon();
//        this.secondSideIcon = createSecondSideIcon();
//        this.thirdSideIcon = createThirdSideIcon();
//        this.fourthSideIcon = createFourthSideIcon();

        this.fisrtDiv = createFirstColumn();
        this.secondDiv = createSecondColumn();
        this.thirdDiv = createThirdColumn();
        this.fourthDiv = createFourthColumn();
        this.fiveDiv = createFiveColumn();
        this.sixDiv = createSixColumn();
        this.sevenDiv = createSevenColumn();
        this.eightDiv = createEightColumn();
        this.nineDiv = createNineColumn();
        this.tenDiv = createTenColumn();
        this.elevenDiv = createElevenColumn();
        this.twelveDiv = createTwelveColumn();
        this.thirteenDiv = createThirteenColumn();
        this.fourteenDiv = createFourteenColumn();
        this.fifteenDiv = createFifteenColumn();
        this.sixteenDiv = createSixteenColumn();
        this.columnContainer = createColumnContainer();

        this.mainFirstMobileImg = createFirstMainMobileImg();
        this.mainSecondMobileImg = createSecondMainMobileImg();
        this.mainThirdMobileImg = createThirdMainMobileImg();
        this.mobileHeaderGradient = createMobileHeaderGradient();

        this.mainContainer = createMainContainer();
        this.backgroundImg = createBackgroundImg();

        this.addClassName("main");


        this.add(createMainContainer(),

                createFirstMainMobileImg(), createSecondMainMobileImg(), createThirdMainMobileImg(),
                createMobileHeaderGradient()
//                mainImg,
//                contactsLine, bronLine, guestLine, vineGalleryLine, expositionLine, menuLine,
//                firstSideIcon, secondSideIcon, thirdSideIcon, fourthSideIcon
        );

    }
    public Image createBackgroundImg() {
        final Image img = new Image("img/main-img.png","");
        img.getStyle().set("width","calc((3500 * (100vh - 12.5vh)) / 1100)");
        img.getStyle().set("height","100%");
        this.addClassName("main-img");
        return img;
    }
    public Div createMainContainer() {
        final Div container = new Div();
        container.add(createBackgroundImg(), createColumnContainer(), createReserveButton());
        container.addClassName("main-container");
        return container;
    }

    public Image createMobileHeaderGradient() {
        final Image img = new Image("/img/mobile-header-gradient.png", "");
        img.addClassNames("mobile-header-gradient");
        return img;
    }

    public Image createFirstMainMobileImg() {
        final Image img = new Image("/img/main-first-mobile-background.png", "");
        img.addClassNames("mainFirstMobileImg");
        return img;
    }

    public Image createSecondMainMobileImg() {
        final Image img = new Image("/img/main-second-mobile-background.png", "");
        img.addClassNames("mainSecondMobileImg");
        return img;
    }

    public Image createThirdMainMobileImg() {
        final Image img = new Image("/img/main-third-mobile-background.png", "");
        img.addClassNames("mainThirdMobileImg");
        return img;
    }

    public Div createColumnContainer() {
        final Div columnContainer = new Div();
        columnContainer.add(
                fisrtDiv, secondDiv, thirdDiv, fourthDiv, reserveLine, sixDiv, sevenDiv, eightDiv,
                nineDiv, tenDiv, elevenDiv, twelveDiv, thirteenDiv, fourteenDiv, fifteenDiv, sixteenDiv
        );
        columnContainer.addClassName("column-container");
        return columnContainer;
    }

    public Div createFirstColumn() {
        final Div firstColumn = new Div();
        firstColumn.add();
        firstColumn.addClassName("first-empty-column");
        return firstColumn;
    }

    public Div createSecondColumn() {
        final Div secondColumn = new Div();
        secondColumn.add(expositionButton, expositionLine);
        secondColumn.addClassName("second-exposition-column");
        return secondColumn;
    }

    public Div createThirdColumn() {
        final Div thirdColumn = new Div();
        thirdColumn.add();
        thirdColumn.addClassName("third-bottom-empty-column");
        return thirdColumn;
    }

    public Div createFourthColumn() {
        final Div fourthColumn = new Div();
        fourthColumn.add();
        fourthColumn.addClassName("fourth-bottom-reserve-column");
        return fourthColumn;
    }

    public Div createFiveColumn() {
        final Div fiveColumn = new Div();
        fiveColumn.add();
        fiveColumn.addClassName("five-top-empty-column");
        return fiveColumn;
    }

    public Div createSixColumn() {
        final Div sixColumn = new Div();
        sixColumn.add();
        sixColumn.addClassName("six-empty-column");
        return sixColumn;
    }

    public Div createSevenColumn() {
        final Div sevenColumn = new Div();
        sevenColumn.add(menuButton, menuLine);
        sevenColumn.addClassName("seven-menu-column");
        return sevenColumn;
    }

    public Div createEightColumn() {
        final Div eightColumn = new Div();
        eightColumn.add();
        eightColumn.addClassName("eight-empty-column");
        return eightColumn;
    }

    public Div createNineColumn() {
        final Div nineColumn = new Div();
        nineColumn.add(guestButton, guestLine);
        nineColumn.addClassName("nine-guest-column");
        return nineColumn;
    }

    public Div createTenColumn() {
        final Div tenColumn = new Div();
        tenColumn.add();
        tenColumn.addClassName("ten-empty-column");
        return tenColumn;
    }

    public Div createElevenColumn() {
        final Div elevenColumn = new Div();
        elevenColumn.add(aboutUsButton);
        elevenColumn.addClassName("eleven-about-column");
        return elevenColumn;
    }

    public Div createTwelveColumn() {
        final Div twelveColumn = new Div();
        twelveColumn.add();
        twelveColumn.addClassName("twelve-empty-column");
        return twelveColumn;
    }

    public Div createThirteenColumn() {
        final Div thirteenColumn = new Div();
        thirteenColumn.add(contactsButton, contactsLine);
        thirteenColumn.addClassName("thirteen-contacts-column");
        return thirteenColumn;
    }

    public Div createFourteenColumn() {
        final Div fourteenColumn = new Div();
        fourteenColumn.add();
        fourteenColumn.addClassName("fourteen-empty-column");
        return fourteenColumn;
    }

    public Div createFifteenColumn() {
        final Div fifteenColumn = new Div();
        fifteenColumn.add(vineGalleryButton, vineGalleryLine);
        fifteenColumn.addClassName("fifteen-vine-column");
        return fifteenColumn;
    }

    public Div createSixteenColumn() {
        final Div sixteenColumn = new Div();
        sixteenColumn.add();
        sixteenColumn.addClassName("sixteen-empty-column");
        return sixteenColumn;
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

    public Image createContactsLine() {
        final Image line = new Image("img/contacts-line.png", "");
        line.addClassName("contacts-line");
        return line;
    }

    public Image createReserveLine() {
        final Image line = new Image("img/bron-line.png", "");
        line.addClassName("reserve-line");
        return line;
    }

    public Image createGuestLine() {
        final Image line = new Image("img/guest-line.png", "");
        line.addClassName("guest-line");
        return line;
    }

    public Image createVineGalleryLine() {
        final Image line = new Image("img/vine-gallery-line.png", "");
        line.addClassName("vine-gallery-line");
        return line;
    }

    public Image createExpositionLine() {
        final Image line = new Image("img/exposition-line.png", "");
        line.addClassName("exposition-line");
        return line;
    }

    public Image createMenuLine() {
        final Image line = new Image("img/menu-line.png", "");
        line.addClassName("menu-line");
        return line;
    }

    public ExpandableButton createExpositionButton() {
        final ExpandableButton expositionButton = new ExpandableButton("Экспозиция", new ExpositionView());
        expositionButton.addClassName("exposition-button");
        return expositionButton;
    }

    public ExpandableButton createAboutUsButton() {
        final ExpandableButton aboutUsButton = new ExpandableButton("О нас", new AboutView());
        aboutUsButton.addClassName("about-us-button");
        return aboutUsButton;
    }

    public ExpandableButton createMenuButton() {
        final ExpandableButton menuButton = new ExpandableButton("Меню", new DishesShortList());
        menuButton.addClassName("menu-button");
        return menuButton;
    }

    public ExpandableButton createVineGalleryButton() {
        final ExpandableButton vineGalleryButton = new ExpandableButton("Винная галерея");
        vineGalleryButton.addClickListener(event -> this.navigator.navigateToVinesGallery());
        vineGalleryButton.addClassName("vine-gallery-button");
        return vineGalleryButton;
    }

    public ExpandableButton createContactsButton() {
        final ExpandableButton contactsButton = new ExpandableButton("Контакты");
        contactsButton.addClickListener(event -> this.navigator.navigateToContacts());
        contactsButton.addClassName("contacts-button");
        return contactsButton;
    }

    public ExpandableButton createGuestButton() {
        final ExpandableButton guestButton = new ExpandableButton("Оформить карту гостя");
        guestButton.addClassName("guest-button");
        return guestButton;
    }

    public ExpandableButton createReserveButton() {
        final ExpandableButton reserveButton = new ExpandableButton("Забронировать столик");
        reserveButton.addClickListener(event -> this.mainLayout.showReserveForm());
        reserveButton.addClassName("main-reserve-button");
        reserveButton.addClassName("adaptive-main-reserve-btn");
        return reserveButton;
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        // this.getStyle().set("background-image", "url('https://i.ibb.co/HNgSvkm/main-image-IMG-4926-1.png')");
    }
}