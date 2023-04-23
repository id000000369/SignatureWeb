package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.list.item.DishListItem;
import it.mifsoft.signature.web.list.item.PictureListItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@UIScope

public class PicturesList extends Div {

    private final List<PicturesList.PicturesData> pictures;
    private List<PictureListItem> pictureListItems;
    private PictureListItem selectedPictureListItem;

    public PicturesList() {
        //testt
        pictures = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            pictures.add(new PicturesList.PicturesData(
                    i,
                    i % 2 == 0 ? "./img/picture_3.png" : "./img/picture_2.png",
                    "НОКТЮРН В ХОЛОДНЫХ ТОНАХ " + i,
                    "https://i.ibb.co/JFRWgJQ/artist-portrait-322224352-732690051793933-7383961788090724650-n-1.png",
                    "Иван Федоров " + i,
                    "https://i.ibb.co/JFRWgJQ/artist-portrait-322224352-732690051793933-7383961788090724650-n-1.png",
                    "Иван Федотов — выпускник Дальневосточной государственной академии искусств. Пусть вас не обманывает молодой возраст, за его плечами уже множество проектов. Произведения художника выставляются в галереях Дальнего Востока, а также в музеях. Работы Ивана Федотова находятся в частных коллекциях, в том числе в личной коллекции губернатора Приморского края."
            ));
        }
        this.pictureListItems = createListItems();
        this.pictureListItems.forEach(this::add);
        this.addClassName("achievements-list");

    }

    private void moveTo(PictureListItem item) {
        final String script = "document.getElementById('%s').scrollIntoView({behavior: \"smooth\", block: \"center\"})";
        if (item.getId().isPresent())
            item.getElement().executeJs(String.format(script, item.getId().get()));
    }

    private List<PictureListItem> createListItems() {
        return pictures.stream()
                .map(item -> {
                    if (item.id == 1)
                        return createPictureListItem(item, true);
                    else
                        return createPictureListItem(item, false);
                })
                .toList();
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        pictureListItems.stream()
                .filter(i -> i.getId().orElse("").equals("1"))
                .findFirst()
                .ifPresent(i -> {
                    moveTo(i);
                    this.selectedPictureListItem = i;
                });
    }

    private PictureListItem createPictureListItem(PicturesList.PicturesData data, boolean expanded) {
        final Div content = new Div();
        content.addClassName("content-some-class-name");
        final Image img = new Image();
        img.setSrc(data.image);
        img.addClassNames("image-achievements");
        content.add(img);

        final H2 description = new H2();
        description.setText(data.description);
        description.addClassName("achievment-description");
        content.add(description);

        final PictureListItem item = new PictureListItem(
                data.image,
                data.mainText,
                data.iconPerson,
                data.dataPerson,
                data.linkInst,
                data.description,
                expanded
        );
        item.addClickListener(event -> {
            if (item.equals(selectedPictureListItem))
                return;
            item.expand();
            if (selectedPictureListItem != null) {
                selectedPictureListItem.collapse();
            }
            selectedPictureListItem = item;
            moveTo(selectedPictureListItem);
        });
        item.setId(""+data.id);
        return item;
    }

    class PicturesData {
        int id;
        String image;
        String mainText;
        String iconPerson;
        String dataPerson;
        String linkInst;
        String description;


        public PicturesData(int id,
                            String image,
                            String mainText,
                            String iconPerson,
                            String dataPerson,
                            String linkInst,
                            String description) {
            this.id = id;
            this.image = image;
            this.mainText = mainText;
            this.iconPerson = iconPerson;
            this.dataPerson = dataPerson;
            this.linkInst = linkInst;
            this.description = description;
        }
    }
}
