package it.mifsoft.signature.web.page;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.list.VineCategoriesList;
import it.mifsoft.signature.web.list.VinesList;
import it.mifsoft.signature.web.list.item.VineListItem;
import it.mifsoft.signature.web.ui.VinesCarousel;
import it.mifsoft.signature.web.utils.FlexStyleUtils;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "vines", layout = ContentLayout.class)
public class VinesPage extends Div {
   private final VinesList vinesList;
    public VinesPage(VinesList vinesList) {
        this.addClassNames("vines-list-div");
        this.vinesList = vinesList;

        this.add(this.vinesList);
    }
}
