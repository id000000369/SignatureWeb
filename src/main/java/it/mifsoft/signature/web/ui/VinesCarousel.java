package it.mifsoft.signature.web.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.dom.Style;

import java.util.List;
import java.util.stream.Collectors;

public class VinesCarousel extends Div {

    private final List<String> vines = List.of(
            "/img/blackVineImg.png",
            "/img/orangeVineImg.png",
            "/img/blackVineImg1.png",
            "/img/orangeVineImg3.png",
            "/img/blackVineImg2.png",
            "/img/orangeVineImg1.png",
            "/img/blackVineImg3.png",
            "/img/orangeVineImg2.png",
            "/img/redVineImg.png",
            "/img/redVineImg1.png",
            "/img/redVineImg2.png"
    );
    private final List<VinesCarouselItem> items;

    private int currentIndex = 5;
    private VinesCarouselItem currentItem;
    double fullWidth = 644;

    public VinesCarousel() {
        this.getStyle().setWidth("644px");
        this.getStyle().setHeight("882px");
        this.getStyle().setPosition(Style.Position.RELATIVE);
        this.items = createItems();
        this.items.forEach(item -> this.add(item.image));
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
            return createCarouselItem(index, vine, position, isSymmetric);
        }).collect(Collectors.toList());
    }

    private VinesCarouselItem createCarouselItem(int index, String imageUrl, VinePositions position, boolean isSymmetric) {
        final VinesCarouselItem item = new VinesCarouselItem(String.valueOf(index), imageUrl, position, isSymmetric);
        item.image.addClickListener(event -> {
            this.currentIndex = index;
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

        });
        return item;
    }

    private class VinesCarouselItem {
        final Image image;
        VinePositions position;
        boolean isSymmetric;

        private VinesCarouselItem(String id, String imageUrl, VinePositions position, boolean isSymmetric) {
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
            image.getStyle().setTransition("width 2s, height 2s, left 2s, top 2s");
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
        GRAND(193, 710, 227, 0),
        SECOND(163, 600, 63,85),
        THIRD(123, 450, 0, 180),
        FOURTH(110, 406, 59, 202),
        FIVE(100, 366, 145,212),
        SIX(85, 314, 189,248),
        HIDDEN(0,0,0,0);

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
