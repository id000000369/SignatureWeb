package it.mifsoft.signature.web.list.item;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;

@Route("category")
public class CategoryListItem extends Div {

    H1 withLove;
    Label descriptionWithLove;
    Button reserveATable;
    H1 ourConcentration;
    Label descriptionOurConcentration;
    H1 teamProfession;
    Image awards;
    Image imageWithLove;
    Image imageOurConcentration;
    Image imageTeamProfession;
    Label descriptionAwards;

    public CategoryListItem() {

        this.withLove = createWithLoveText();
        this.descriptionWithLove = createDescriptionWithLove();
        this.reserveATable = createReserveATableButton();
        this.ourConcentration = createOurConcentrationText();
        this.descriptionOurConcentration = createDescriptionOurConcentration();
        this.teamProfession = createTeamProfessionText();
        this.awards = createAwards();
        this.descriptionAwards = createDescriptionAwards();

        this.addClassNames("category-main");

        add(windowOneComponent(), windowTwoComponent(), windowTreeComponent());
    }


    public Div windowOneComponent() {
        Div items = new Div();
        items.add(createWithLoveText(), createDescriptionWithLove(), createReserveATableButton());
        items.addClassNames("window-one-category");
        return items;
    }

    public Div windowTwoComponent() {
        Div items = new Div();
        items.add(createOurConcentrationText(), createDescriptionOurConcentration());
        items.addClassNames("window-two-category");
        return items;
    }

    public Div windowTreeComponent() {
        Div items = new Div();
        items.add(createTeamProfessionText(), createAwards(), createDescriptionAwards());
        items.addClassNames("window-tree-category");
        return items;
    }


    public H1 createWithLoveText() {
        H1 main = new H1();
        main.setText("О НАС С ЛЮБОВЬЮ");
        main.addClassNames("with-love-text-category");
        return main;
    }

    public H1 createOurConcentrationText() {
        H1 main = new H1();
        main.setText("НАША КОНЦЕТРАЦИЯ");
        main.addClassNames("our-concentration-text-category");
        return main;
    }

    public H1 createTeamProfessionText() {
        H1 main = new H1();
        main.setText("КОМАНДА ПРОФЕССИОНАЛОВ");
        main.addClassNames("team-profession-text-category");
        return main;
    }

    public Image createAwards() {
        Image image = new Image("https://i.ibb.co/PFMRV1n/2022-NY-medals-1.png", "Image");
        image.addClassNames("awards-image-category");
        return image;
    }

    public Image createImageWithLove() {
        Image image = new Image("https://i.ibb.co/4Znp481/2-cards-1.png", "Image");
        image.addClassNames("with-love-image-category");
        return image;
    }

    public Image createImageOurConcentration() {
        Image image = new Image("https://i.ibb.co/dKz8c7R/3-cards.png", "Image");
        image.addClassNames("with-love-image-category");
        return image;
    }

    public Image createImageTeamProfession() {
        Image image = new Image("https://i.ibb.co/3m70Q8m/4-cards.png", "Image");
        image.addClassNames("team-profession-image-category");
        return image;
    }

    public Label createDescriptionWithLove() {
        Label dataPersonLabel = new Label();
        dataPersonLabel.setText("В каждом нашем блюде есть секретный ингредиент – любовь. Любовь к еде и к нашим клиентам.");
        dataPersonLabel.addClassNames("description-with-love-label-category");
        return dataPersonLabel;
    }

    public Label createDescriptionOurConcentration() {
        Label dataPersonLabel = new Label();
        dataPersonLabel.setText("Наш ресторан Signature Art транслирует уникальную концепцию арт-пространства. " +
                "Мы дарим гостям новый опыт, " +
                "возможность прожить новый экспириенс – стать ценителем искусства и дегустатором.\n" +
                "Высотка на Котельнической набережной - примечательное место Москвы, место притяжения, " +
                "дом-эпоха, дом личностей, дом стиля. Уже это требует наполнения вкусом и искусством, " +
                "эмоциями и красотой.Рады сообщить вам, что уже в марте мы откроем для вас двери арт ресторана, " +
                "где вы сможете не просто вкусно поесть, а также ощутить новое " +
                "особенное внимательное к вам пространство.");

        dataPersonLabel.addClassNames("description-our-concentration-category");
        return dataPersonLabel;
    }

    public Label createDescriptionAwards() {
        Label dataPersonLabel = new Label();
        dataPersonLabel.setText("Наша команда оправдает ваши самые высокие ожидания");
        dataPersonLabel.addClassNames("description-awards-category");
        return dataPersonLabel;
    }

    public Button createReserveATableButton() {
        Button signUpForATasting = new Button();
        signUpForATasting.setText("Забронировать столик");
        signUpForATasting.addClassNames("reserve-a-table-button-category");
        return signUpForATasting;
    }
}
