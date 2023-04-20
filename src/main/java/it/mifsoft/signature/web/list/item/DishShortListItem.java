package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import it.mifsoft.signature.web.utils.FlexStyleUtils;

public class DishShortListItem extends Div {

    private final String imageUrl;
    private final String title;
    private final String description;

    private final H1 titleH1;
    private final H2 descriptionH2;
    private final Image image;
    private final Div imageColumn;
    private final Div detailColumn;

    public DishShortListItem(String title, String description, String imageUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;

        this.titleH1 = createTitleH1();
        this.descriptionH2 = createDescriptionH2();
        this.image = createImage();

        imageColumn = new Div();
            imageColumn.addClassName("menu-image-column");
        imageColumn.add(this.image);

        detailColumn = new Div();
        detailColumn.add(this.titleH1, this.descriptionH2);

        this.addClassNames("dish-short-item-main");

        FlexStyleUtils.doItRow(this.getElement());
        FlexStyleUtils.doItCenteredColumn(detailColumn.getElement());

        this.add(imageColumn, detailColumn);
    }

    private H1 createTitleH1() {
        final H1 title = new H1();
        title.setText(this.title);
        title.addClassName("dish-short-item-title");
        return title;
    }

    private H2 createDescriptionH2() {
        final H2 description = new H2();
        description.setText(this.description);
        description.addClassName("dish-short-item-description");
        return description;
    }

    private Image createImage() {
        final Image image = new Image();
        image.setSrc(imageUrl);
        image.addClassName("dish-short-item-image");
        return image;
    }

}
