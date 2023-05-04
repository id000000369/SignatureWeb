package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.list.item.VineListItem;
import it.mifsoft.signature.web.ui.VinesCarousel;
import it.mifsoft.signature.web.utils.FlexStyleUtils;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class VinesList extends Div {
    private final VineCategoriesList categoriesList = new VineCategoriesList();
    public VinesList(){
        this.getStyle().setPadding("40px");
        setup();
    }

    private void setup() {
        final Div leftSide = new Div();
        FlexStyleUtils.doItCenteredColumn(leftSide.getElement());
        leftSide.getStyle().set("justify-content", "unset");
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
