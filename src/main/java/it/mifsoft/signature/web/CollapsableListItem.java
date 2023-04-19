package it.mifsoft.signature.web;

import com.vaadin.flow.component.html.*;

public class CollapsableListItem extends Div {

    private final CollapsableListItemState state;

    private Paragraph mainText;
    private Paragraph personData;
    private final Image personIcon;
    private Anchor instaLink;
    private H2 description;

//            new CollapsableListItemState(
//            "Hello",
//            "Mrs",
//            "https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png"
//    );

    public CollapsableListItem(String mainText, String personData, String avatarUrl) {
        this.state = new CollapsableListItemState(mainText, personData, avatarUrl);
        this.personIcon = createImage();

        render();
    }

    private void render() {
        this.getStyle().setBackground("blue");
        switch (this.state.displayType) {
            case EXPANDED -> renderExpanded();
            case COLLAPSED -> renderCollapsed();
        }
    }

    private void renderCollapsed() {
        this.removeAll();
        this.add(this.personIcon);
    }

    private void renderExpanded() {
        this.removeAll();
        if (this.mainText == null) {
            this.mainText = createMainText();
        }
        if (this.personData == null) {
            this.personData = createPersonData();
        }

        this.add(this.personIcon, this.mainText, this.personData);
    }

    private Image createImage() {
        final Image image = new Image();
        image.setSrc(this.state.personIcon);
        image.setWidth("250px");
        image.setWidth("250px");
        return image;
    }

    private Paragraph createMainText() {
        final Paragraph paragraph = new Paragraph();
        paragraph.setText(this.state.mainText);
        return paragraph;
    }

    private Paragraph createPersonData() {
        final Paragraph paragraph = new Paragraph();
        paragraph.setText(this.state.personData);
        return paragraph;
    }

    public void changeDisplayType(CollapsableListItemDisplayType displayType) {
        this.state.setDisplayType(displayType);
        render();
    }
    public CollapsableListItemDisplayType getDisplayType() {
        return this.state.displayType;
    }

    private static class CollapsableListItemState {
        private CollapsableListItemDisplayType displayType = CollapsableListItemDisplayType.COLLAPSED;
        final String mainText;
        final String personData;
        final String personIcon;
        public CollapsableListItemState(String mainText, String personData, String personIcon) {
            this.mainText = mainText;
            this.personData = personData;
            this.personIcon = personIcon;
        }
        public void setDisplayType(CollapsableListItemDisplayType displayType) {
            this.displayType = displayType;
        }
    }
    public enum CollapsableListItemDisplayType {
        COLLAPSED,
        EXPANDED
    }
}