package it.mifsoft.signature.web.page;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "vines", layout = ContentLayout.class)
public class VinesPage extends Div {
}
