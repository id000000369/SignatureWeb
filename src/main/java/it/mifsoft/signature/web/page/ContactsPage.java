package it.mifsoft.signature.web.page;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.view.ContactView;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "contacts", layout = ContentLayout.class)
public class ContactsPage extends Div {
    private final ContactView contactView;
    public ContactsPage(ContactView contactView) {
        this.contactView = contactView;
        this.add(contactView);
    }
}
