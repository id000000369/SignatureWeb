package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.dto.GalleryItemsData;
import it.mifsoft.signature.web.dto.PicturesData;
import it.mifsoft.signature.web.list.item.PictureListItem;
import it.mifsoft.signature.web.service.GalleryItemsApiService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@UIScope
public class PicturesList extends Div {

    public static final long PICTURES_GALLERY_ID = 1;

    private List<PicturesData> pictures = new ArrayList<>();
    private List<PictureListItem> pictureListItems = new ArrayList<>();
    private PictureListItem selectedPictureListItem;

    private final GalleryItemsApiService galleryItemsApiService;

    public PicturesList(GalleryItemsApiService galleryItemsApiService) {
        this.galleryItemsApiService = galleryItemsApiService;

        galleryItemsApiService
                .getAllByGalleryId(PICTURES_GALLERY_ID)
                .doOnSuccess(this::updatePicturesList)
                .subscribe();

        this.addClassName("achievements-list");
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
            this.pictureListItems = createListItems();
            this.pictureListItems.forEach(this::add);
        }));
    }

    private void moveTo(PictureListItem item) {
        final String script = "document.getElementById('%s').scrollIntoView({behavior: \"smooth\", inline: \"center\"})";
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
}
