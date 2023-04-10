package it.mifsoft.signature.web.view;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.ui.ExpandableButton;
import it.mifsoft.signature.web.ui.menu.MenuItems;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "welcome", layout = ContentLayout.class)
public class WelcomePage extends Div {

    public WelcomePage() {

        MenuItems.MENU_ITEM_NAMES.forEach(title -> {
            var button = new ExpandableButton(title, new AboutView());
            this.add(button);
        });
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        this.getStyle().set("background-image", "url('https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png')");
    }
}
