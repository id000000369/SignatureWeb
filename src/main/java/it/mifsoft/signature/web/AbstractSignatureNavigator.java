package it.mifsoft.signature.web;

import com.vaadin.flow.component.UI;

public abstract class AbstractSignatureNavigator implements MenuNavigator {

    protected void route(UI ui, String location) {
        if (ui != null) {
            ui.navigate(location);
        }
    }

    public void router(String title) {
        switch (title) {
            case "О НАС" -> this.navigateToAbout();
            case "ЭКСПОЗИЦИЯ" -> this.navigateToPicturesGallery();
            case "ВИННАЯ ГАЛЕРЕЯ" -> this.navigateToVinesGallery();
            case "МЕНЮ" -> this.navigateToMenu();
            case "КОНТАКТЫ" -> this.navigateToContacts();
        }
    }
}
