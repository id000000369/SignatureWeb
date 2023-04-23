package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.spring.annotation.UIScope;
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

    public PictureListItem(String image, String mainText, String iconPerson,
                           String dataPerson, String linkInst, String description, boolean isExpanded) {

        this.image = image;
        this.mainText = mainText;
        this.iconPerson = iconPerson;
        this.dataPerson = dataPerson;
        this.linkInst = linkInst;
        this.description = description;
        this.imageI = createImage();
        this.mainTextH = createMainText();
        this.iconPersonA = createIconPerson();
        this.dataPersonL = createDataPerson();
        this.linkInstA = createLinkInst();
        this.descriptionH = createDescription();

        addClassNames("picture");

        middleDiv = windowMainItems();

        configureAnimation();
        add(imageI, mainTextH, middleDiv, descriptionH);

        this.isExpanded = isExpanded;
        if (isExpanded) {
            expand();
        } else {
            collapse();
        }
    }

    private void configureAnimation() {
        this.getStyle().setTransition("width 2s, height 2s");
        this.imageI.getStyle().setTransition("width 2s, height 2s, margin 2s, box-shadow 2s");
        this.mainTextH.getStyle().setTransition("visibility 2s, opacity 2s");
        this.middleDiv.getStyle().setTransition("visibility 2s, opacity 2s");
        this.descriptionH.getStyle().setTransition("visibility 2s, opacity 2s");
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
        imageG.setSrc(image);
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
        descriptionLabel.setText(description);
        descriptionLabel.addClassNames("description-picture");
        return descriptionLabel;
    }

    public void collapse() {
        this.getStyle().set("height", "17%");
        this.imageI.getStyle().set("min-width", "100%");
        this.imageI.getStyle().set("min-height", "100%");
        this.imageI.getStyle().set("margin", "0");
        this.imageI.getStyle().remove("box-shadow");
        this.mainTextH.setVisible(false);
        this.middleDiv.setVisible(false);
        this.descriptionH.setVisible(false);
        this.isExpanded = false;
    }

    public void expand() {
        this.imageI.getStyle().set("min-width", "30vw");
        this.imageI.getStyle().set("min-height", "50vh");
        this.imageI.getStyle().set("max-width", "30vw");
        this.imageI.getStyle().set("max-height", "50vh");

        this.imageI.getStyle().remove("margin");
        this.imageI.getStyle().set("margin-top", "4%");
        this.imageI.getStyle().set("box-shadow", "0px 10px 50px 10px #91793A");

        this.mainTextH.setVisible(true);
        this.middleDiv.setVisible(true);
        this.descriptionH.setVisible(true);
        this.isExpanded = true;
    }

    public boolean isExpanded() {
        return isExpanded;
    }
}
