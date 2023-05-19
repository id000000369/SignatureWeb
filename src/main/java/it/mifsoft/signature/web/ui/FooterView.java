package it.mifsoft.signature.web.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.HasModal;
import it.mifsoft.signature.web.ModalDelegate;
import it.mifsoft.signature.web.forms.ReserveForm;
import org.springframework.stereotype.Component;


@Component
@UIScope
public class FooterView extends HorizontalLayout {
    private ModalDelegate delegate;
    private final HasModal modalContainer;
    private final ReserveForm reserveForm;
    private final Div adaptiveSocialContainer;
    private final Image logoImage;
    private final H1 contactsText;
    public final Button reserveButton;

    ///////////- Adaptive -/////////////////
    private final H1 addressInfo;
    private final H1 phoneInfo;
    private final H1 adminLabel;
    private final Image adaptivePhoneImg;
    private final Image vkIco;
    private final Image ytIco;
    private final Image instaIco;
    private final H1 adaptiveContactsAddressInfo;
    private final H1 adaptiveCopyRights;
    private final Div footerContactsInfo;
    ////////////////////////////////////////

    public FooterView(HasModal modalContainer, ReserveForm reserveForm) {
        this.modalContainer = modalContainer;
        this.reserveForm = reserveForm;
        this.modalContainer.setModal(this.reserveForm);

        this.logoImage = createLogoImage();
        this.contactsText = createContactsText();
        this.reserveButton = createReserveButton();

        ///////////- Adaptive -/////////////////
        this.adminLabel = createAdminLabel();
        this.phoneInfo = createPhoneInfo();
        this.addressInfo = createAddressInfo();
        this.adaptivePhoneImg = createAdaptivePhoneImg();

        this.vkIco = createVkIco();
        this.ytIco = createYtIco();
        this.instaIco = createInstaIco();

        this.adaptiveContactsAddressInfo = createAdaptiveContactsAddressInfo();
        this.adaptiveSocialContainer = createAdaptiveSocialContainer();
        this.adaptiveCopyRights = createAdaptiveCopyRights();
        this.footerContactsInfo = createFooterContactsInfo();
        ////////////////////////////////////////

        this.addClassName("footer");


        this.add(this.logoImage, this.contactsText, this.reserveButton,
                createAdminLabel(), createPhoneInfo(),
                createAddressInfo(), createAdaptivePhoneImg(),

                // createAdaptiveSocialContainer(), createAdaptiveCopyRights(),
//                createAdaptiveContactsAddressInfo(),
                createFooterContactsInfo()
        );
    }

    public H1 createAdaptiveCopyRights() {
        final H1 text = new H1("© 2022 – 2023  ООО «Сигнатура арт ресторан рус». Все права защищены.");
        text.addClassName("adaptive-copy-rights-text");
        return text;
    }

    public Div createAdaptiveSocialContainer() {
        final Div container = new Div();
        container.addClassName("adaptive-social-container");
        container.add(vkIco, ytIco, instaIco);
        return container;
    }

    public Image createVkIco() {
        final Image img = new Image("img/vk-ico.png", "");
        img.addClassName("vk-ico");
        return img;
    }

    public Image createYtIco() {
        final Image img = new Image("img/yt-ico.png", "");
        img.addClassName("yt-ico");
        return img;
    }

    public Image createInstaIco() {
        final Image img = new Image("img/insta-ico.png", "");
        img.addClassName("insta-ico");
        return img;
    }

    private Image createLogoImage() {
        final Image image = new Image();
        image.setSrc("https://i.ibb.co/Cbr2Zpg/Vector-2.png");
        image.addClassName("footer-logo");
        return image;
    }

    private H1 createContactsText() {
        final H1 text = new H1();
        text.setText("Котельническая наб., 1/15, к.В, Москва \n +7 495 915 35 00");
        text.addClassName("footer-contacts");
        return text;
    }

    private Button createReserveButton() {
        final Button button = new Button();
        button.setText("Забронировать столик");
        button.addClickListener(event -> {
            if (delegate != null) {
                delegate.showReserveForm();
            }
        });
        button.addClassName("footer-button");
        return button;
    }

    /////////////////////- For adaptive ///////////////////
    private H1 createAdminLabel() {
        final H1 text = new H1("Администратор");
        text.addClassName("adaptive-admin-label-text");
        return text;
    }

    private H1 createPhoneInfo() {
        final H1 text = new H1("+7 989 077 70 07");
        text.addClassName("adaptive-phone-info-text");
        return text;
    }

    private H1 createAddressInfo() {
        final H1 text = new H1("Котельническая наб., 1/15, к.В, Москва");
        text.addClassName("adaptive-address-info-text");
        return text;
    }

    private Image createAdaptivePhoneImg() {
        final Image img = new Image("/img/adaptive-phone-img.png", "");
        img.addClassName("adaptive-phone-button-img");
        return img;
    }

    public H1 createAdaptiveContactsAddressInfo() {
        final H1 text = new H1("Москва, Котельническая набережная,\n дом 1/15, корпус В");
        text.addClassName("adaptive-contacts-address-info-text");
        return text;
    }

    /////////////////////////////////////////////////////////
    public Div createFooterContactsInfo() {
        final Div container = new Div();
        container.add(adaptiveContactsAddressInfo, adaptiveSocialContainer, adaptiveCopyRights);
        container.addClassName("footer-contacts-info");
        return container;
    }

    public void showBottom() {
        this.footerContactsInfo.getStyle().set("display", "block");
        this.footerContactsInfo.setVisible(true);
    }

    public void hideBottom() {
//        this.footerContactsInfo.addClassName("footer-bottom-visible");
//        this.footerContactsInfo.removeClassName("footer-bottom-invisible");
        this.footerContactsInfo.getStyle().set("display", "none");
        //this.getStyle().set("display", "block");
        this.adaptiveContactsAddressInfo.getStyle().set("display", "none");
        this.adaptiveSocialContainer.getStyle().set("display", "none");
        this.adaptiveCopyRights.getStyle().set("display", "none");
    }

    public void changeFooterPosition() {
        this.getStyle().set("top", "80%");
        // this.getStyle().set("height", "");
        this.addressInfo.getStyle().set("display", "block");
        //   this.getStyle().set("background-image", "linear-gradient(to bottom, rgba(3, 45, 50, 1) 50%, rgba(0, 32, 36, 1) 50%)");
    }

    public void hide() {
        this.removeClassName("visible-footer");
        this.addClassName("hidden-footer");
    }

    public void show() {
        this.removeClassName("hidden-footer");
        this.addClassName("visible-footer");
    }

    public void changeFooterStyle() {
        this.addressInfo.getStyle().set("display", "block");
        this.getStyle().set("background-image", "linear-gradient(to bottom, rgba(3, 45, 50, 1) 50%, rgba(0, 32, 36, 1) 50%)");
    }

    public void setDelegate(ModalDelegate delegate) {
        this.delegate = delegate;
    }
}
