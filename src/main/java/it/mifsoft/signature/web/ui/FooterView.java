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
    private final Button reserveButton;

    public FooterView(HasModal modalContainer, ReserveForm reserveForm) {
        this.modalContainer = modalContainer;
        this.reserveForm = reserveForm;
        this.modalContainer.setModal(this.reserveForm);

        this.logoImage = createLogoImage();
        this.contactsText = createContactsText();
        this.reserveButton = createReserveButton();

        this.addClassName("footer");
        this.add(this.logoImage, this.contactsText, this.reserveButton);
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
        button.addClickListener(event -> button.getUI().ifPresent(ui ->
                ui.navigate("main/reserve")));
        button.addClassName("footer-button");
        return button;
    }
}
