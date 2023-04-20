package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import it.mifsoft.signature.web.utils.FlexStyleUtils;
import it.mifsoft.signature.web.utils.SizeStyleUtils;

public class VineCategoryListItem extends Div {

    private final VinesType type;

    private final Div image;
    private final Paragraph titleParagraph;

    private boolean isSelected = false;

    public VineCategoryListItem(final VinesType type) {
        this.type = type;
        this.image = this.type.createImage();
        this.titleParagraph = createParagraph();
        stylize();
        this.add(image, titleParagraph);
    }

    private void stylize() {
        FlexStyleUtils.doItCenteredColumn(this.getElement());
        SizeStyleUtils.sizeIt(this.getElement(), 74, 68);
        this.getStyle().set("padding-left", "10px");
        this.getStyle().set("padding-right", "10px");
    }

    private Paragraph createParagraph() {
        final Paragraph paragraph = new Paragraph();
        paragraph.setText(this.type.title);
        paragraph.getStyle().set("color", "#91793A");
        paragraph.getStyle().set("font-size", "12px");
        return paragraph;
    }

    public void setSelected(boolean selected) {
        if (selected) {
            image.getStyle().set("border-color", "#FFFFFF");
            image.getStyle().set("box-shadow", "0px 0px 33px 5px #91793A");
        } else {
            image.getStyle().set("border-color", "transparent");
            image.getStyle().set("box-shadow", "0px 0px 33px 5px transparent");
        }
        this.isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public enum VinesType {
        ALL("Любые", "#91793A"),
        RED("Красное", "#8A0514"),
        WHITE("Белое", "#D9C88C"),
        PINK("Розовое", "#E78AA3"),
        SPARKLING("Игристое", "sss") {
            @Override
            protected Div createImage() {
                final Div container = createDefaultImage();
                final Image image = new Image();
                image.setWidth("35px");
                image.setHeight("35px");
                image.setSrc(super.colorOrImage);
                container.add(image);
                return container;
            }
        };

        private final String title;
        protected final String colorOrImage;

        VinesType(String title, String colorOrImage) {
            this.title = title;
            this.colorOrImage = colorOrImage;
        }

        protected Div createImage() {
            return createColoredImage();
        }

        protected Div createColoredImage() {
            final Div image = createDefaultImage();
            image.getStyle().set("background-color", this.colorOrImage);
            return image;
        }

        protected Div createDefaultImage() {
            final Div image = new Div();
            image.setWidth("35px");
            image.setHeight("35px");

            image.getStyle().set("border-color", "transparent");
            image.getStyle().set("border-style", "solid");
            image.getStyle().set("border-width", "2px");
            image.getStyle().set("border-radius", "50%");

            image.getStyle().set("box-shadow", "0px 0px 33px 5px transparent");

            return image;
        }
    }
}
