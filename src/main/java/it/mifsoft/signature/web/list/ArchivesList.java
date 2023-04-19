package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.dto.CategoryData;
import it.mifsoft.signature.web.list.item.ArchivesListItem;
import it.mifsoft.signature.web.list.item.CategoryListItem;
import it.mifsoft.signature.web.list.item.DishListItem;
import it.mifsoft.signature.web.utils.SignatureStyleUtils;

import java.util.ArrayList;
import java.util.List;


@Route(value = "archives", layout = ContentLayout.class)
public class ArchivesList extends Div {
    

    public ArchivesList(){



    }
}
