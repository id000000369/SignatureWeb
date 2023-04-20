package it.mifsoft.signature.web.page;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.list.CategoriesList;
import it.mifsoft.signature.web.list.DishesList;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "dishes", layout = ContentLayout.class)
public class DishesPage extends Div {
    private final CategoriesList categoriesList;
    private final DishesList dishesList;
    public DishesPage(CategoriesList categoriesList, DishesList dishesList) {
        this.setWidthFull();
        this.setHeightFull();

        this.categoriesList = categoriesList;
        this.dishesList = dishesList;

        this.add(this.categoriesList, this.dishesList);
    }
}