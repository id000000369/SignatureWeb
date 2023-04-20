package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.html.Div;
import it.mifsoft.signature.web.dto.DishData;
import it.mifsoft.signature.web.list.item.DishShortListItem;
import it.mifsoft.signature.web.utils.FlexStyleUtils;

import java.util.List;

public class DishesShortList extends Div {

    private final List<DishData> dishes = List.of(
            new DishData(
                    1,
                    "УСТРИЦЫ ИЗ НОРМАНДИИ",
                    "приходите к нам на \n закрытие сезона",
                    800,
                    "/img/food-image.png"
            ),
            new DishData(
                    1,
                    "НАЧНИ ДЕНЬ ПРАВИЛЬНО",
                    "с 6 до 10 утра –  бокал \n Prosecco  в подарок при \n заказе кофе",
                    700,
                    "/img/bokal-image.png"
            )
    );
    private final List<DishShortListItem> dishShortListItemList;

    public DishesShortList() {
        FlexStyleUtils.doItColumn(this.getElement());
        this.setWidthFull();
        this.setHeightFull();
        this.dishShortListItemList = createListItems();
        this.dishShortListItemList.forEach(this::add);
        this.addClassName("dishes-container");
    }

    private List<DishShortListItem> createListItems() {
        return dishes.stream()
                .map(dishData -> new DishShortListItem(
                        dishData.getName(),
                        dishData.getDescription(),
                        dishData.getImage()
                ))
                .toList();
    }
}

