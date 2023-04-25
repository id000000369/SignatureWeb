package it.mifsoft.signature.web.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.dom.Style;

import java.util.List;
import java.util.stream.Collectors;

public class VinesCarousel extends Div {

    private final List<String> vines = List.of(
            "/img/bottle-2.png",
            "/img/bottle-3.png",
            "/img/bottle-5.png",
            "/img/bottle-6.png",
            "/img/bottle-8.png",
            "/img/bottle-9.png",
            "/img/bottle-10.png",
            "/img/bottle-11.png",
            "/img/bottle-12.png",
            "/img/bottle-13.png",
            "/img/bottle-14.png",
            "/img/bottle-15.png",
            "/img/bottle-16.png",
            "/img/bottle-17.png",
            "/img/bottle-18.png",
            "/img/bottle-19.png",
            "/img/bottle-20.png",
            "/img/bottle-21.png",
            "/img/bottle-22.png"
    );
    private final List<VinesCarouselItem> items;

    private int currentIndex = 5;
    private VinesCarouselItem currentItem;
    double fullWidth = 350;

    public VinesCarousel() {
        this.getStyle().setWidth("350px");
        this.getStyle().setHeight("502px");
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
