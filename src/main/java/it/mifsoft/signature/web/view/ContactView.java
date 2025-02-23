package it.mifsoft.signature.web.view;

import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class ContactView extends Div {
    private final Div contactsContainer;
    private final Image backgroundImg;
    private final Image vkIco;
    private final Image ytIco;
    private final Image instaIco;
    private final H1 addressInfo;
    private final H1 phoneInfo;
    private final H1 adminLabel;
    private final H1 copyRights;
    private final HtmlComponent html = new HtmlComponent("div");
    private final HtmlComponent adaptiveMap;
    private final Div mapContainer = new Div();
    private final Image contactsLogo;

    public ContactView() {
        this.getElement().getStyle().set("font-family", "FuturaNewLight-Reg");
        //html.getElement().setProperty("innerHTML", "<div id=\"map\"></div>");
        html.getElement().setProperty("innerHTML", "<iframe src=\"https://yandex.ru/map-widget/v1/?um=constructor%3A04b70d8dd3abbde806619bb744e739aa46ce275958140fbdb2ecd095244b134f&amp;source=constructor" +
                "\" width=\"100%\" " +
                "height=\"190\" " +
                "zoom=\"85\" " +
                "frameborder=\"0\"" +
//                "webkit-border-radius=\"15px\"" +
//                "-moz-border-radius=\"15px\"" +
//                "border-radius=\"15px\"" +
                "></iframe>");
        // html.getElement().getStyle().set("border-radius", "15px");
//        String yandexMapScriptUrl = "https://api-maps.yandex.ru/services/constructor/1.0/js/?um=constructor%3A04b70d8dd3abbde806619bb744e739aa46ce275958140fbdb2ecd095244b134f&amp;width=650&amp;height=422&amp;lang=ru_RU";

//        html.getElement().executeJs("var script = document.createElement('script');"
//                + "script.type = 'text/javascript';"
//                + "script.src = '" + yandexMapScriptUrl + "';"
//                + "document.head.appendChild(script);");

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
        this.adaptiveMap = createAdaptiveMap();
        this.contactsLogo = createContactsLogo();

        this.mapContainer.add(html);
        this.mapContainer.addClassName("map-container-view");
        this.html.addClassName("map-view");

        this.contactsContainer.add(mapContainer, createAddressInfo(), createAdminLabel(),
                createPhoneInfo(), createSocialContainer(), createCopyRights(), createAdaptiveMap()
        );

        this.addClassName("contacts-main");
        this.add(contactsLogo, backgroundImg, contactsContainer);
    }

    private Image createContactsLogo() {
        final Image img = new Image("img/adaptive-contacts-logo.png", "");
        img.addClassName("adaptive-contacts-logo");
        return img;
    }

    private HtmlComponent createAdaptiveMap() {
        final HtmlComponent map = new HtmlComponent("div");
        map.getElement().setProperty("innerHTML", "<iframe src=\"https://yandex.ru/map-widget/v1/?um=constructor%3A04b70d8dd3abbde806619bb744e739aa46ce275958140fbdb2ecd095244b134f&amp;source=constructor" +
                "\" width=\"470\" " +
                "height=\"400\" " +
                "zoom=\"30\" " +
                "frameborder=\"0\"" +
                "></iframe>");
        map.addClassName("adaptive-map");
        return map;
    }

    public Div createSocialContainer() {
        final Div container = new Div();
        container.addClassName("social-container");
        container.add(vkIco, ytIco, instaIco);
        return container;
    }

    public Image createBackgroundImg() {
        final Image img = new Image("", "");
        img.addClassName("contacts-background-img");
        return img;
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
