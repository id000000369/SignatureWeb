package it.mifsoft.signature.web.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
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
    private final String logoImageSrc;
    private final String contacts;
    private final String reserveButtonTitle;

    private final Image logoImage;
    private final Text contactsText;
    private final Button reserveButton;

    public FooterView(HasModal modalContainer,
                      ReserveForm reserveForm,
                      @Value("${signature.web.logo-img}") String logoImageSrc,
                      @Value("${signature.web.footer.contacts}") String contacts,
                      @Value("${signature.web.footer.reserve}") String reserveButtonTitle) {
        this.getStyle().setBackground("black");

        this.modalContainer = modalContainer;
        this.reserveForm = reserveForm;
        this.modalContainer.setModal(this.reserveForm);

        this.logoImageSrc = logoImageSrc;
        this.contacts = contacts;
        this.reserveButtonTitle = reserveButtonTitle;


        this.logoImage = createLogoImage();
        this.contactsText = createContactsText();
        this.reserveButton = createReserveButton();

        this.addClassName("footer");
        this.add(this.logoImage, this.contactsText, this.reserveButton);
    }

    private Image createLogoImage() {
        final Image image = new Image();
        image.setSrc(this.logoImageSrc);
        image.addClassName("footer-logo");
        return image;
    }

    private Text createContactsText() {
        final Text text = new Text("Contacts");
        //todo add class name
        return text;
    }

    private Button createReserveButton() {
        final Button button = new Button();
        button.setText(this.reserveButtonTitle);
        button.addClickListener(event -> this.modalContainer.showModal());
        button.addClassName("reserve-button");
        return button;
    }
}
