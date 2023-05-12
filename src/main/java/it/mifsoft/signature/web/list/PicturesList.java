package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.dto.DishData;
import it.mifsoft.signature.web.dto.GalleryItemsData;
import it.mifsoft.signature.web.dto.PicturesData;
import it.mifsoft.signature.web.list.item.DishListItem;
import it.mifsoft.signature.web.list.item.PictureListItem;
import it.mifsoft.signature.web.service.GalleryItemsApiService;
import it.mifsoft.signature.web.ui.DotsIndicator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@UIScope
public class PicturesList extends Div implements DotsIndicator.DotsIndicatorDelegate {

    public static final long PICTURES_GALLERY_ID = 1;

    private List<PicturesData> pictures = new ArrayList<>();
    private List<PictureListItem> items;
    private final PicturesListState state;
    private final Div dotsIndicatorContainer;
    private List<PictureListItem> pictureListItems = new ArrayList<>();
    private PictureListItem selectedPictureListItem;
    private DotsIndicator dotsIndicator;


    private final GalleryItemsApiService galleryItemsApiService;

    public PicturesList(GalleryItemsApiService galleryItemsApiService) {
        this.galleryItemsApiService = galleryItemsApiService;
        this.state = new PicturesListState();
        this.dotsIndicatorContainer = createDotsContainer();

        this.dotsIndicator = createDotsIndicator(state.pictures);
        this.dotsIndicatorContainer.add(this.dotsIndicator);


        galleryItemsApiService
                .getAllByGalleryId(PICTURES_GALLERY_ID)
                .doOnSuccess(this::updatePicturesList)
                .subscribe();

        dotsIndicatorContainer.addClassName("dots-indicator-container");

        this.addClassName("picture-list");
        add(dotsIndicatorContainer);
    }

    private Image createPicturesTopImg() {
        final Image img = new Image("img/pictures-top-img.png", "");
        img.addClassName("pictures-top-img");
        return img;
    }

//    private DotsIndicator createDotsIndicator(List<DishData> dishes) {
//        final List<String> dishesIds = dishes.stream()
//                .map(dish -> String.valueOf(dish.getId()))
//                .toList();
//        final DotsIndicator indicator = new DotsIndicator(dishesIds, this);
//        indicator.setWidthFull();
//        indicator.setHeightFull();
//        return indicator;
//    }

    private Div createDotsContainer() {
        final Div container = new Div();
        return container;
    }

    private void updatePicturesList(List<GalleryItemsData> galleryItems) {
        getUI().ifPresent(ui -> ui.access(() -> {
            this.removeAll();
            this.pictures = galleryItems.stream().map(item -> new PicturesData(
                    item.getId(),
                    item.getImage(),
                    item.getName(),
                    "",
                    "",
                    "",
                    item.getDescription()
            )).toList();
            final DotsIndicator indicator = createDotsIndicator(state.pictures);
            this.dotsIndicatorContainer.removeAll();
            this.dotsIndicatorContainer.add(indicator);
            this.dotsIndicator = indicator;
            this.pictureListItems = createListItems();
            this.pictureListItems.forEach(this::add);

        }));
    }

    private DotsIndicator createDotsIndicator(List<PicturesData> pictures) {
        final List<String> picturesIds = pictures.stream()
                .map(picture -> String.valueOf(picture.getId()))
                .toList();
        final DotsIndicator indicator = new DotsIndicator(picturesIds, this);
        indicator.setWidthFull();
        indicator.setHeightFull();
        return indicator;
    }

    private void moveTo(PictureListItem item) {
        final String script =
                "document.getElementById('%s').scrollIntoView({behavior: 'smooth', block: 'nearest', inline: 'center'})";
        if (item.getId().isPresent())
            item.getElement().executeJs(String.format(script, item.getId().get()));
    }

    private List<PictureListItem> createListItems() {
        return pictures.stream()
                .map(item -> {
                    if (item.getId() == 1)
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

    private PictureListItem createPictureListItem(PicturesData data, boolean expanded) {
        final Div content = new Div();
        content.addClassName("content-some-class-name");
        final Image img = new Image();
        img.setSrc(data.getImage());
        img.addClassNames("image-achievements");
        content.add(img);

        final H2 description = new H2();
        description.setText(data.getDescription());
        description.addClassName("achievment-description");
        content.add(description);

        final PictureListItem item = new PictureListItem(
                data.getImage(),
                data.getMainText(),
                data.getIconPerson(),
                data.getDataPerson(),
                data.getLinkInst(),
                data.getDescription(),
                expanded,
                data);
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
        item.setId("" + data.getId());
        return item;
    }

    @Override
    public void dotChangedAction(DotsIndicator.Dot oldDot, DotsIndicator.Dot newDot) {
        final Optional<PictureListItem> item = items.stream().filter(i -> {
            final String itemId = "dot_" + i.getPictureData().getId();
            final String newDotId = newDot.getId().orElse("");
            return itemId.equals(newDotId);
        }).findFirst();

        item.ifPresent(dishListItem -> {
            final int index = items.indexOf(dishListItem);
            this.state.setCurrent(index);
            this.moveTo(dishListItem);
        });
    }

    private static class PicturesListState {
        private long categoryId = -1;
        private PicturesData current;
        private List<PicturesData> pictures = new ArrayList<>();

        PicturesListState() {
        }

        public long getCategoryId() {
            return categoryId;
        }

        public PicturesData getCurrent() {
            return current;
        }

        public List<PicturesData> getDishes() {
            return pictures;
        }

        public void setCurrent(int index) {
            this.current = pictures.get(index);
        }

        public int currentIndex() {
            return pictures.indexOf(current);
        }
    }
}
