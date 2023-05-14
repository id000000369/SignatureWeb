package it.mifsoft.signature.web.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.dom.Style;
import it.mifsoft.signature.web.dto.VineData;

import java.util.List;
import java.util.stream.Collectors;

public class VinesCarousel extends Div {

    public interface Delegate {
        void onVineChange(VineData vine);
    }

    private final List<VineData> vines;
    private final List<VinesCarouselItem> items;

    private int currentIndex = 5;
    private VinesCarouselItem currentItem;
    double fullWidth = 350;

    private Delegate delegate;

    public VinesCarousel(List<VineData> vines) {
        this.vines = vines;
        this.getStyle().setWidth("350px");
        this.getStyle().setHeight("502px");
        this.getStyle().setPosition(Style.Position.STICKY);
        this.getStyle().set("justify-content", "unset");
        this.items = createItems();
        this.items.forEach(item -> this.add(item.image));
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    private List<VinesCarouselItem> createItems() {
        return vines.stream().map(vine -> {
            final int index = vines.indexOf(vine);
            VinePositions position = null;
            int minus = index - currentIndex;
            boolean isSymmetric = minus > 0;
            switch (Math.abs(minus)) {
                case 0 -> position = VinePositions.GRAND;
                case 1 -> position = VinePositions.SECOND;
                case 2 -> position = VinePositions.THIRD;
                case 3 -> position = VinePositions.FOURTH;
                case 4 -> position = VinePositions.FIVE;
                case 5 -> position = VinePositions.SIX;
                default -> position = VinePositions.HIDDEN;
            }
            return createCarouselItem(vine, index, vine.getImage(), position, isSymmetric);
        }).collect(Collectors.toList());
    }

    private VinesCarouselItem createCarouselItem(VineData data, int index, String imageUrl, VinePositions position, boolean isSymmetric) {
        final VinesCarouselItem item = new VinesCarouselItem(data, String.valueOf(index), imageUrl, position, isSymmetric);
        item.image.addClickListener(event -> {
            this.currentIndex = index;
            this.currentItem = item;
            this.items.forEach(it -> {
                if (it.image.getId().isEmpty()) {
                    return;
                }
                final int i = Integer.parseInt(it.image.getId().get());
                VinePositions newPosition;
                int minus = i - currentIndex;
                boolean newIsSymmetric = minus > 0;
                switch (Math.abs(minus)) {
                    case 0 -> newPosition = VinePositions.GRAND;
                    case 1 -> newPosition = VinePositions.SECOND;
                    case 2 -> newPosition = VinePositions.THIRD;
                    case 3 -> newPosition = VinePositions.FOURTH;
                    case 4 -> newPosition = VinePositions.FIVE;
                    case 5 -> newPosition = VinePositions.SIX;
                    default -> newPosition = VinePositions.HIDDEN;
                }
                it.changePosition(newPosition, newIsSymmetric);
            });
            if (delegate != null) {
                delegate.onVineChange(item.data);
            }
        });
        return item;
    }

    private class VinesCarouselItem {
        final VineData data;
        final Image image;
        VinePositions position;
        boolean isSymmetric;

        private VinesCarouselItem(VineData data,
                                  String id,
                                  String imageUrl,
                                  VinePositions position,
                                  boolean isSymmetric) {
            this.data = data;
            this.position = position;
            this.isSymmetric = isSymmetric;
            this.image = createImage(imageUrl, id);
        }

        public void changePosition(VinePositions position, boolean isSymmetric) {
            stylizeImage(this.image, position, isSymmetric, VinesCarousel.this.fullWidth);
            this.isSymmetric = isSymmetric;
            this.position = position;
        }

        private Image createImage(String imageUrl, String id) {
            final Image image = new Image();
            image.setId(id);
            image.setSrc(imageUrl);
            if (position == null) {
                throw new NullPointerException("All images in vine carousel need position. Position is null");
            }
            image.getStyle().setPosition(Style.Position.ABSOLUTE);
            image.getStyle().setTransition("width 2s, height 2s, left 2s, top 2s, z-index 2s");
            return stylizeImage(image, this.position, this.isSymmetric, VinesCarousel.this.fullWidth);
        }

        private Image stylizeImage(final Image image, VinePositions position, boolean isSymmetric, double fullWidth) {
            image.getStyle().setZIndex(1000 - (position.ordinal() + 1));
            image.setWidth(position.width + "px");
            image.setHeight(position.height + "px");
            image.getStyle().setTop(position.top + "px");
            image.getStyle().setLeft(isSymmetric ?
                    position.getSymmetricRightX(fullWidth) + "px" :
                    position.left + "px"
            );
            return image;
        }
    }

    enum VinePositions {
        GRAND(113, 400, 118, 0),
        SECOND(93, 350, 35, 32),
        THIRD(73, 280, 0, 45),
        FOURTH(59, 256, 40, 50),
        FIVE(53, 166, 80, 65),
        SIX(27, 124, 110, 75),
        HIDDEN(0, 0, 120, 50);


        final double width;
        final double height;
        final double left;
        final double top;

        VinePositions(double width,
                      double height,
                      double left,
                      double top) {
            this.width = width;
            this.height = height;
            this.left = left;
            this.top = top;
        }

        public double getSymmetricRightX(double fullWidth) {
            return fullWidth - width - left;
        }
    }
}
