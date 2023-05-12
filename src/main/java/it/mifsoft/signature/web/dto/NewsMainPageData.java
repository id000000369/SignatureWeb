package it.mifsoft.signature.web.dto;

import java.util.List;

public class NewsMainPageData {
    private long id;
    private String title;
    private long order;
    private List<String> images;

    public long getID() {
        return id;
    }

    public void setID(long value) {
        this.id = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long value) {
        this.order = value;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> value) {
        this.images = value;
    }
}
