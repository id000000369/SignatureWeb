package it.mifsoft.signature.web.page;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.list.VineCategoriesList;
import it.mifsoft.signature.web.list.item.VineListItem;
import it.mifsoft.signature.web.ui.VinesCarousel;
import it.mifsoft.signature.web.utils.FlexStyleUtils;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "vines", layout = ContentLayout.class)
public class VinesPage extends Div {

    private final VineCategoriesList categoriesList = new VineCategoriesList();

    public VinesPage() {
        this.getStyle().setPadding("40px");
        setup();
    }

    private void setup() {
        final Div leftSide = new Div();
        FlexStyleUtils.doItCenteredColumn(leftSide.getElement());
        leftSide.setWidth("50vw");
        leftSide.setHeight("100vh");

        final VinesCarousel carousel = new VinesCarousel();
        leftSide.add(categoriesList, carousel);

        final Div rightSide = new Div();

        rightSide.add(new VineListItem());
        rightSide.setWidth("50vw");
        rightSide.setHeight("100vh");

        FlexStyleUtils.doItCenteredRow(this.getElement());

        this.add(leftSide, rightSide);
    }
}
