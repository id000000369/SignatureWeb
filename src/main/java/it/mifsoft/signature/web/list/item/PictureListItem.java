package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.dto.PicturesData;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class PictureListItem extends Div {

    private final String image;
    private final String mainText;
    private final String iconPerson;
    private final String dataPerson;
    private final String linkInst;
    private final String description;

    private final Image imageI;
    private final H1 mainTextH;
    private final Avatar iconPersonA;
    private final Label dataPersonL;
    private final Anchor linkInstA;
    private final H2 descriptionH;

    private final Div middleDiv;

    private boolean isExpanded;

    private final PicturesData pictureData;

    public PictureListItem(String image, String mainText, String iconPerson,
                           String dataPerson, String linkInst, String description,
                           boolean isExpanded, PicturesData pictureData) {

        this.setId(String.valueOf(pictureData.getId()));
        this.image = image;
        this.mainText = mainText;
        this.iconPerson = iconPerson;
        this.dataPerson = dataPerson;
        this.linkInst = linkInst;
        this.description = description;
        this.pictureData = pictureData;
        this.imageI = createImage();
        this.mainTextH = createMainText();
        this.iconPersonA = createIconPerson();
        this.dataPersonL = createDataPerson();
        this.linkInstA = createLinkInst();
        this.descriptionH = createDescription();

        addClassNames("picture");

        middleDiv = windowMainItems();

        configureAnimation();

        add(imageI, createMainContainer());

        this.isExpanded = isExpanded;
        if (isExpanded) {
            expand();
        } else {
            collapse();
        }
    }

    public Div createMainContainer() {
        final Div items = new Div();
        items.add(addVerticalSeparator(), createItemsContainer());
        items.addClassNames("picture-main-container");
        return items;
    }

    public Div createItemsContainer() {
        final Div items = new Div();
        items.add(mainTextH, middleDiv, descriptionH);
        return items;
    }

    private void configureAnimation() {
        this.getStyle().setTransition("width 2s, height 2s");
        this.imageI.getStyle().setTransition("width 2s, height 2s, margin 2s, box-shadow 2s");
        this.mainTextH.getStyle().setTransition("visibility 2s, opacity 2s");
        this.middleDiv.getStyle().setTransition("visibility 2s, opacity 2s");
        this.descriptionH.getStyle().setTransition("visibility 2s, opacity 2s");
    }

    public Div addVerticalSeparator() {
        final Div items = new Div();
        items.add(createVerticalSeparator());
        return items;
    }

    public Image createVerticalSeparator() {
        final Image image = new Image("/img/vertical-separator.png", "");
        image.addClassNames("vertical-separator-pictures");
        return image;
    }

    public Div windowMainItems() {
        Div items = new Div();
        items.add(iconPersonA, subMainItems());
        items.addClassNames("picture-main");
        return items;
    }

    public Div subMainItems() {
        Div items = new Div();
        items.add(dataPersonL, linkInstA);
        items.addClassNames("picture-sub");
        return items;
    }

    public Image createImage() {
        Image imageG = new Image();
        imageG.setSrc(pictureData.getImage());
        imageG.addClassNames("image-picture");
        return imageG;
    }

    public H1 createMainText() {
        H1 main = new H1();
        main.setText(mainText);
        main.addClassNames("main-picture-text");
        return main;
    }

    public Avatar createIconPerson() {
        Avatar avatar = new Avatar();
        avatar.setImage(iconPerson);
        avatar.addClassNames("avatar");
        return avatar;
    }

    public Label createDataPerson() {
        Label dataPersonLabel = new Label();
        dataPersonLabel.setText(dataPerson);
        dataPersonLabel.addClassNames("data-person");
        return dataPersonLabel;
    }

    public Anchor createLinkInst() {
        Anchor linkInstU = new Anchor();
        linkInstU.setHref(linkInst);
        return linkInstU;
    }

    public H2 createDescription() {
        H2 descriptionLabel = new H2();
        descriptionLabel.getElement().setProperty("innerHTML", pictureData.getDescription());
        descriptionLabel.addClassNames("description-picture");
        return descriptionLabel;
    }

    public void collapse() {
        this.getStyle().set("height", "17%");
        this.imageI.getStyle().set("min-width", "100%");
        this.imageI.getStyle().set("min-height", "100%");
//        this.imageI.getStyle().set("margin-top", "10vh");
        this.imageI.getStyle().remove("box-shadow");
        this.mainTextH.setVisible(false);
        this.middleDiv.setVisible(false);
        this.descriptionH.setVisible(false);
        this.isExpanded = false;
    }

    public void expand() {


        this.imageI.getStyle().set("min-width", "20vw");
//        this.imageI.getStyle().set("min-height", "40vh");
//        this.imageI.getStyle().set("max-width", "20vw");
//        this.imageI.getStyle().set("max-height", "40vh");
        this.imageI.getStyle().set("margin-top", "4%");
        this.imageI.getStyle().set("box-shadow", "0px 10px 50px 10px #91793A");

        this.imageI.getStyle().remove("margin");


//        this.addClassName("picture-image-style");
        this.mainTextH.setVisible(true);
        this.middleDiv.setVisible(true);
        this.descriptionH.setVisible(true);
        this.isExpanded = true;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public PicturesData getPictureData() {
        return pictureData;
    }
}
