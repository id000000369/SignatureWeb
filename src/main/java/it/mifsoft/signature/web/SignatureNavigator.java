package it.mifsoft.signature.web;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class SignatureNavigator extends AbstractSignatureNavigator implements MenuNavigator {

    @Override
    public void navigateToHome() {
        super.route(UI.getCurrent(), "/home");
    }

    @Override
    public void navigateToAbout() {
        super.route(UI.getCurrent(), "/about");
    }

    @Override
    public void navigateToVinesGallery() {
        super.route(UI.getCurrent(), "/vines");
    }

    @Override
    public void navigateToMenu() {
        super.route(UI.getCurrent(), "/dishes");
    }

    @Override
    public void navigateToPicturesGallery() {
        super.route(UI.getCurrent(), "/pictures");
    }

    @Override
    public void navigateToContacts() {
        super.route(UI.getCurrent(), "/contacts");
    }
}
