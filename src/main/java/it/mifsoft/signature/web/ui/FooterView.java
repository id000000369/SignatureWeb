package it.mifsoft.signature.web.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.HasModal;
import it.mifsoft.signature.web.forms.ReserveForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@UIScope
public class FooterView extends HorizontalLayout {

    private final HasModal modalContainer;
    private final ReserveForm reserveForm;

    private final Image logoImage;
    private final H1 contactsText;
    public final Button reserveButton;

    ///////////- Adaptive -/////////////////
    private final H1 addressInfo;
    private final H1 phoneInfo;
    private final H1 adminLabel;
    private final Image adaptivePhoneImg;
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
        ////////////////////////////////////////

        this.addClassName("footer");
        this.add(this.logoImage, this.contactsText, this.reserveButton,
                createAdminLabel(), createPhoneInfo(),
                createAddressInfo(), createAdaptivePhoneImg()
                );
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
        //button.addClickListener(event -> this.modalContainer.showModal());
//        button.addClickListener(event -> button.getUI().ifPresent(ui ->
//                ui.navigate("main/reserve")));
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
        final Image img = new Image("/img/adaptive-phone-img.png","");
        img.addClassName("adaptive-phone-button-img");
        return img;
    }
    /////////////////////////////////////////////////////////
}
