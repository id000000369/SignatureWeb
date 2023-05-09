package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;
import it.mifsoft.signature.web.dto.DishData;
import it.mifsoft.signature.web.dto.PicturesData;

public class DishListItem extends Div {


    public H1 mainText;
    private final Label peculiarities;
    private final TextField calories;
    private final TextField protein;
    private final TextField fats;
    private final TextField carbohydrates;
    private final Label allergicReaction;
    private final TextField ingredientOneAllergicReaction;
    private final TextField ingredientTwoAllergicReaction;
    private final H1 price;
    private final Button purchase;
    private final Label ingredients;
    private final Image dishIcon;

    private final DishData dishData;

    public DishListItem(DishData dishData) {
        this.dishData = dishData;

        this.mainText = createMainText();
        this.peculiarities = createPeculiarities();
        this.calories = createCaloriesText();
        this.protein = createProteinText();
        this.fats = createFatsText();
        this.carbohydrates = createCarbohydratesText();
        this.allergicReaction = createAllergicReaction();
        this.ingredientOneAllergicReaction = createIngredientOneAllergicReaction();
        this.ingredientTwoAllergicReaction = createIngredientTwoAllergicReaction();
        this.price = createPriceText();
        this.purchase = createPurchaseText();
        this.ingredients = createIngredientsText();
        this.dishIcon = createImage();
        this.addClassName("dish-list-item");

        add(mainText, mainComponent());
    }

    public Div mainComponent() {
        Div items = new Div();
        items.add(windowOne(), dishIcon, windowTwo());
        items.addClassNames("main-component-dishes");
        return items;
    }

    public H1 createMainText() {
        H1 main = new H1();
        main.setText(dishData.getName());
        main.addClassNames("main-text-dish");
        return main;
    }


    public Div windowOne() {
        Div items = new Div();
        items.add(peculiarities, calories, containerTwoElement());
        items.addClassNames("window-one-dishes");
        return items;
    }

    public Div containerTwoElement() {
        Div items = new Div();
        items.add(protein, fats, carbohydrates);
//        items.addClassNames("window-one-dishes");
        return items;
    }

    public Div containerTreeElement() {
        Div items = new Div();
        items.add(price, purchase);
        items.addClassNames("window-tree-dishes");
        return items;
    }

    public Div windowTwo() {
        Div items = new Div();
        items.add(ingredients, containerTreeElement());
        items.addClassNames("window-two-dishes");
        return items;
    }


    public Label createPeculiarities() {
        Label peculiaritiesText = new Label();
        peculiaritiesText.setText("ОСОБЕННОСТИ");
        peculiaritiesText.addClassNames("peculiarities-text");
        return peculiaritiesText;
    }

    public TextField createCaloriesText() {
        TextField caloriesText = new TextField();
        caloriesText.setReadOnly(true);
        caloriesText.setLabel("КАЛОРИЙНОСТЬ");
        caloriesText.setValue("300 Ккал / 100 г.");
        caloriesText.addClassNames("calories-text");
        return caloriesText;
    }

    public TextField createFatsText() {
        TextField fatsText = new TextField();
        fatsText.setReadOnly(true);
        fatsText.setLabel("ЖИРЫ");
        fatsText.setValue("12% 8г.");
        fatsText.addClassNames("fats-text");
        return fatsText;
    }

    public TextField createProteinText() {
        TextField proteinText = new TextField();
        proteinText.setReadOnly(true);
        proteinText.setLabel("БЕЛКИ");
        proteinText.setValue("12% 120г.");
        proteinText.addClassNames("protein-text");
        return proteinText;
    }

    public TextField createCarbohydratesText() {
        TextField carbohydratesText = new TextField();
        carbohydratesText.setReadOnly(true);
        carbohydratesText.setLabel("УГЛЕВОДЫ");
        carbohydratesText.setValue("12% 8г.");
        carbohydratesText.addClassNames("carbohydrates-text");
        return carbohydratesText;
    }

    public Label createAllergicReaction() {
        Label allergicReactionText = new Label();
        allergicReactionText.setText("АЛЕРГИЧЕСКАЯ РЕАКЦИЯ");
        allergicReactionText.addClassNames("allergic-reaction");
        return allergicReactionText;
    }

    public TextField createIngredientOneAllergicReaction() {
        TextField ingredientOneAllergicReactionText = new TextField();
        ingredientOneAllergicReactionText.setReadOnly(true);
        ingredientOneAllergicReactionText.setValue("Octopus regularis");
        ingredientOneAllergicReactionText.addClassNames("ingredient-one-allergic-reaction-text");
        return ingredientOneAllergicReactionText;
    }

    public TextField createIngredientTwoAllergicReaction() {
        TextField ingredientTwoAllergicReactionText = new TextField();
        ingredientTwoAllergicReactionText.setReadOnly(true);
        ingredientTwoAllergicReactionText.setValue("Tomatus");
        ingredientTwoAllergicReactionText.addClassNames("ingredient-two-allergic-reaction-text");
        return ingredientTwoAllergicReactionText;
    }

    public H1 createPriceText() {
        H1 priceText = new H1();
        priceText.setText(dishData.getPrice() + "₽");
        priceText.addClassNames("price-dish");
        return priceText;
    }

    public Button createPurchaseText() {
        Button purchaseIcon = new Button(new Image("./img/bag.png", "bag"));

        purchaseIcon.addClassNames("purchase-dish");
        return purchaseIcon;
    }

    public Label createIngredientsText() {
        Label ingredientsText = new Label();
        ingredientsText.setText("ИНГРЕДИЕНТЫ");
        ingredientsText.addClassNames("main-dishes-text");
        return ingredientsText;
    }

    public Image createImage() {
        Image image = new Image("https://i.ibb.co/XsVJCr6/plate-1513116566-1.png", "Image");
        image.addClassNames("image-dish");
        return image;
    }

    public DishData getDishData() {
        return dishData;
    }
}
