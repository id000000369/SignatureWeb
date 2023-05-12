package it.mifsoft.signature.web.dto;

import java.util.List;

public class NewsData {
    private long id;
    private List<ImageData> images;
    private String title;
    private boolean isMain;
    private long order;
    private long amountOfImages;
    private boolean read;

    public long getID() {
        return id;
    }

    public void setID(long value) {
        this.id = value;
    }

    public List<ImageData> getImages() {
        return images;
    }

    public void setImages(List<ImageData> value) {
        this.images = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public boolean getIsMain() {
        return isMain;
    }

    public void setIsMain(boolean value) {
        this.isMain = value;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long value) {
        this.order = value;
    }

    public long getAmountOfImages() {
        return amountOfImages;
    }

    public void setAmountOfImages(long value) {
        this.amountOfImages = value;
    }

    public boolean getRead() {
        return read;
    }

    public void setRead(boolean value) {
        this.read = value;
    }
}



