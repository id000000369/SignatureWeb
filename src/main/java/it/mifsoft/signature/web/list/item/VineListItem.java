package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import it.mifsoft.signature.web.dto.VineData;

public class VineListItem extends Div {

    private final H1 mainText;
    private final H1 subMainText;
    private final TextField sparklingWineOrChampagneText;
    private final TextField regionText;
    private final TextField grapeText;
    private final TextField fortressText;
    private final TextField volumeText;
    private final TextField manufacturerText;
    private final TextArea perfectForText;
    private final TextField andAlsoText;
    private final Button signUpForATasting;
    private final Image verticalSeparator;
    private final Div itemsContainer;

    private final VineData data;

    public VineData getData() {
        return data;
    }

    public VineListItem(VineData data) {
        this.data = data;

        this.mainText = createMainText();
        this.subMainText = createSubMainText();
        this.sparklingWineOrChampagneText = createSparklingWineOrChampagneText();
        this.regionText = createRegionText();
        this.grapeText = createGrapeText();
        this.fortressText = createFortressText();
        this.volumeText = createVolumeText();
        this.manufacturerText = createManufacturerText();
        this.perfectForText = createPerfectForText();
        this.andAlsoText = createAndAlsoText();
        this.signUpForATasting = createSignUpForATastingText();
        this.verticalSeparator = createVerticalSeparator();
        this.itemsContainer = createItemsContainer();

        addClassNames("window");
        add( addVerticalSeparator(), createItemsContainer());
    }

    public Div createItemsContainer() {
        final Div items = new Div();
        items.add(windowMainItems(), windowOneItems(), windowTwoItems(), windowTreeItems());
        items.addClassName("vine-items-container");
        return items;
    }

    public Div addVerticalSeparator() {
        final Div items = new Div();
        items.add(createVerticalSeparator());
        return items;
    }

    public Image createVerticalSeparator() {
        final Image image = new Image("/img/vertical-separator.png", "");
        image.addClassNames("vertical-separator");
        return image;
    }

    public Div windowMainItems() {
        Div items = new Div();
        items.add(mainText, subMainText);
        items.addClassNames("window-main-items");
        return items;
    }

    public Div windowOneItems() {
        Div items = new Div();
        items.add(sparklingWineOrChampagneText,
                fortressText,
                volumeText);
        items.addClassNames("window-one-items");
        return items;
    }

    public Div windowTwoItems() {
        Div items = new Div();
        items.add(regionText, manufacturerText);
        items.addClassNames("window-two-items");
        return items;
    }

    public Div windowTreeItems() {
        Div items = new Div();
        items.add(grapeText, perfectForText, andAlsoText, signUpForATasting);
        items.addClassNames("window-tree-items");
        return items;
    }

    public H1 createMainText() {
        H1 main = new H1();
        main.setText(data.getName());
        main.addClassNames("mainWindow");
        return main;
    }

    public H1 createSubMainText() {
        H1 subMain = new H1();
        subMain.setText(data.getSubName());
        subMain.addClassNames("subMain");
        return subMain;
    }

    public TextField createSparklingWineOrChampagneText() {
        TextField sparklingWineOrChampagne = new TextField();
        sparklingWineOrChampagne.setReadOnly(true);
        sparklingWineOrChampagne.getStyle().set("padding", "3px");

        sparklingWineOrChampagne.setLabel("ИГРИСТОЕ ВИНО/ШАМПАНСКОЕ");
        sparklingWineOrChampagne.setValue("Шампанское, сухое, брют");
        sparklingWineOrChampagne.addClassNames("sparklingWineOrChampagne");
        return sparklingWineOrChampagne;
    }

    public TextField createRegionText() {
        TextField regionText = new TextField();
        regionText.setReadOnly(true);
        regionText.getStyle().set("padding", "3px");

        regionText.setLabel("РЕГИОН");
        regionText.setValue("Франция, Шампань");
        regionText.addClassNames("region");
        return regionText;
    }

    public TextField createGrapeText() {
        TextField grapeText = new TextField();
        grapeText.setReadOnly(true);
        grapeText.getStyle().set("padding", "3px");

        grapeText.setLabel("ВИНОГРАД");
        grapeText.setValue("Шардоне: 34%, Пино Менье: 33%, Пино Нуар: 33%");
        grapeText.addClassNames("grape");
        return grapeText;
    }


    public TextField createFortressText() {
        TextField fortressText = new TextField();
        fortressText.setReadOnly(true);
        fortressText.getStyle().set("padding", "3px");

        fortressText.setLabel("КРЕПОСТЬ");
        fortressText.setValue("12%");
        fortressText.addClassNames("fortress");
        return fortressText;
    }

    public TextField createVolumeText() {
        TextField volumeText = new TextField();
        volumeText.setReadOnly(true);
        volumeText.getStyle().set("padding", "3px");
        volumeText.setLabel("ОБЪЕМ");
        volumeText.setValue("0,75");
        volumeText.addClassNames("volume");
        return volumeText;
    }

    public TextArea createPerfectForText() {
        TextArea perfectForText = new TextArea();
        perfectForText.setReadOnly(true);
        perfectForText.getStyle().set("padding", "3px");
        perfectForText.setLabel("ИДЕАЛЬНО ПОДХОДИТ К");
        perfectForText.setValue("Осьминогу на стейке томата,\n" +
                "Палтус с жженым горошком, Томленая ножка кролика с рагу из овощей\n" +
                "Осьминогу на стейке томата\n" +
                "Палтус с жженым горошком,\n" +
                "Томленая ножка кролика с рагу из овощей");
        perfectForText.addClassNames("perfectFor");
        return perfectForText;
    }

    public TextField createAndAlsoText() {
        TextField andAlsoText = new TextField();
        andAlsoText.setReadOnly(true);
        andAlsoText.getStyle().set("padding", "3px");

        andAlsoText.setLabel("А ЕЩЕ");
        andAlsoText.setValue("Это вино принимает участие в дегустационной программе");
        andAlsoText.addClassNames("andAlso");
        return andAlsoText;
    }

    public TextField createManufacturerText() {
        TextField manufacturerText = new TextField();
        manufacturerText.setReadOnly(true);
        manufacturerText.setLabel("ПРОИЗВОДИТЕЛЬ");
        manufacturerText.getStyle().set("padding", "3px");

        manufacturerText.setValue("Pol Roger");
        manufacturerText.addClassNames("manufacturer");
        return manufacturerText;
    }

    public Button createSignUpForATastingText() {
        Button signUpForATasting = new Button();
        signUpForATasting.setText("Записаться на дегустацию");
        signUpForATasting.addClassNames("signUpForATasting");
        return signUpForATasting;
    }
}

