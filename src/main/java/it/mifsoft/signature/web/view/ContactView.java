package it.mifsoft.signature.web.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "contacts", layout = ContentLayout.class)
public class ContactView extends Div {
    private final Div contactsContainer;

    //private final Map mapView;
    private final Image backgroundImg;
    private final Image vkIco;
    private final Image ytIco;
    private final Image instaIco;

    private final H1 addressInfo;
    private final H1 phoneInfo;
    private final H1 adminLabel;
    private final H1 copyRights;
    public ContactView() {

        this.contactsContainer = new Div();
        this.contactsContainer.addClassName("contacts-container");

        this.backgroundImg = createBackgroundImg();

        this.vkIco = createVkIco();
        this.ytIco = createYtIco();
        this.instaIco = createInstaIco();

        this.addressInfo = createAddressInfo();
        this.phoneInfo = createPhoneInfo();
        this.adminLabel = createAdminLabel();
        this.copyRights = createCopyRights();

        this.contactsContainer.add(createAddressInfo(), createAdminLabel(),
                createPhoneInfo(), createSocialContainer(), createCopyRights());

        this.addClassName("contacts-main");
        this.add(backgroundImg, contactsContainer);
    }

    public Div createSocialContainer() {
        final Div container = new Div();
        container.addClassName("social-container");
        container.add(vkIco, ytIco, instaIco);
        return container;
    }
    public Image createBackgroundImg() {
        final Image img = new Image("img/contacts-background-img.png", "");
        img.addClassName("contacts-background-img");
        return img;
    }
    public Image createVkIco() {
        final Image img = new Image("img/vk-ico.png", "");
        img.addClassName("vk-ico");
        return img;
    }
    public Image createYtIco() {
        final Image img = new Image("img/yt-ico.png","");
        img.addClassName("yt-ico");
        return img;
    }
    public Image createInstaIco() {
        final Image img = new Image("img/insta-ico.png","");
        img.addClassName("insta-ico");
        return img;
    }
    public H1 createAddressInfo() {
        final H1 text = new H1("Москва, Котельническая набережная, \n дом 1/15, корпус В");
        text.addClassName("address-info-text");
        return text;
    }
    public H1 createAdminLabel() {
        final H1 text = new H1("Администратор");
        text.addClassName("admin-label-text");
        return text;
    }
    public H1 createPhoneInfo() {
        final H1 text = new H1("+7 989 077 70 07");
        text.addClassName("phone-info-text");
        return text;
    }
    public H1 createCopyRights() {
        final H1 text = new H1("© 2022 – 2023  ООО «Сигнатура арт ресторан рус». Все права защищены.");
        text.addClassName("copy-rights-text");
        return text;
    }
}
