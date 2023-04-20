package it.mifsoft.signature.web.page;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.forms.ReserveForm;
import it.mifsoft.signature.web.ui.FooterView;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "reserve", layout = ContentLayout.class)
public class ReservePage extends Div {
    private final FooterView footerView;
    private final ReserveForm reserveForm;

    public ReservePage(ReserveForm reserveForm, FooterView footerView) {
        this.reserveForm = reserveForm;
        this.footerView = footerView;
        this.add(this.reserveForm, this.footerView);
    }
}