package it.mifsoft.signature.web;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class SignatureNavigator extends AbstractSignatureNavigator implements MenuNavigator {

    public SignatureNavigator() {
    }

    @Override
    public void navigateToHome() {
        super.route(UI.getCurrent(), "/main/welcome");
    }

    @Override
    public void navigateToAbout() {
        super.route(UI.getCurrent(), "main/achievement");
    }

    @Override
    public void navigateToVinesGallery() {
        super.route(UI.getCurrent(), "/main/vines");
    }

    @Override
    public void navigateToMenu() {
        super.route(UI.getCurrent(), "/main/dishes");
    }

    @Override
    public void navigateToPicturesGallery() {
        super.route(UI.getCurrent(), "/main/pictures");
    }

    @Override
    public void navigateToContacts() {
        super.route(UI.getCurrent(), "/main/contacts");
    }
}
