package it.mifsoft.signature.web.list.item;


import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("picture")
@AnonymousAllowed
public class PictureListItem extends Div {

    private final Image image;
    private final H1 mainText;
    private final Avatar iconPerson;
    private final Label dataPerson;
    private final Anchor linkInst;
    private final H2 description;

    public PictureListItem() {

        this.image = createImage();
        this.mainText = createMainText();
        this.iconPerson = createIconPerson();
        this.dataPerson = createDataPerson();
        this.linkInst = createLinkInst();
        this.description = createDescription();


        addClassNames("picture");

        add(image, mainText, windowMainItems(), description);
    }


    public Div windowMainItems() {
        Div items = new Div();
        items.add(iconPerson, subMainItems());
        items.addClassNames("picture-main");
        return items;
    }

    public Div subMainItems() {
        Div items = new Div();
        items.add(dataPerson, linkInst);
        items.addClassNames("picture-sub");
        return items;
    }

    public Image createImage() {
        Image image = new Image("https://i.ibb.co/56xWWmC/2-artist-284339061-1020051115547276-9161416504874219292-n-1.png", "Image");
        image.addClassNames("image-picture");
        return image;
    }

    public H1 createMainText() {
        H1 main = new H1();
        main.setText("НОКТЮРН В ХОЛОДНЫХ ТОНАХ");
        main.addClassNames("main-picture-text");
        return main;
    }

    public Avatar createIconPerson() {
        Avatar avatar = new Avatar();
        avatar.setImage("https://i.ibb.co/JFRWgJQ/artist-portrait-322224352-732690051793933-7383961788090724650-n-1.png");
        avatar.addClassNames("avatar");
        return avatar;
    }

    public Label createDataPerson() {
        Label dataPersonLabel = new Label();
        dataPersonLabel.setText("Иван Федоров");
        dataPersonLabel.addClassNames("data-person");
        return dataPersonLabel;
    }

    public Anchor createLinkInst() {
        Anchor linkInst = new Anchor("https://i.ibb.co/JFRWgJQ/artist-portrait-322224352-732690051793933-7383961788090724650-n-1.png", "@ivan_fedotov_art");
        return linkInst;
    }

    public H2 createDescription() {
        H2 descriptionLabel = new H2();
        descriptionLabel.setText("Иван Федотов — выпускник Дальневосточной государственной академии искусств. " +
                "Пусть вас не обманывает молодой возраст, за его плечами уже множество проектов." + "\n" +
                "Произведения художника выставляются в галереях Дальнего Востока, а также в музеях. " +
                "Работы Ивана Федотова находятся в частных коллекциях, " +
                "в том числе в личной коллекции губернатора Приморского края.");
        descriptionLabel.addClassNames("description-picture");
        return descriptionLabel;
    }
}
