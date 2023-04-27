package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.list.item.VineCategoryListItem;
import it.mifsoft.signature.web.utils.FlexStyleUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@UIScope
public class VineCategoriesList extends Div {
    private final List<VineCategoryListItem.VinesType> vines = List.of(
            VineCategoryListItem.VinesType.ALL,
            VineCategoryListItem.VinesType.RED,
            VineCategoryListItem.VinesType.WHITE,
            VineCategoryListItem.VinesType.PINK,
            VineCategoryListItem.VinesType.SPARKLING
    );

    private final List<VineCategoryListItem> listItems = vines.stream()
            .map(this::createItem)
            .toList();
    private final Set<VineCategoryListItem> selectedItems = new HashSet<>();

    public VineCategoriesList() {
        FlexStyleUtils.doItCenteredRow(this.getElement());
        listItems.forEach(this::add);
    }

    private VineCategoryListItem createItem(VineCategoryListItem.VinesType type) {
        final VineCategoryListItem item = new VineCategoryListItem(type);
        item.addClickListener(event -> {
            if (item.isSelected()) {
                selectedItems.remove(item);
                item.setSelected(false);
            } else {
                selectedItems.add(item);
                item.setSelected(true);
            }
        });
        return item;
    }
}
