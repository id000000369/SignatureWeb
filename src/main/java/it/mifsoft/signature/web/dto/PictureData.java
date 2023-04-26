package it.mifsoft.signature.web.dto;

public class PictureData {
    private long id;
    private String name;
    private String description;
    private String image;

    public PictureData() {

    }

    public PictureData(long id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PictureData pictureData = (PictureData) o;
        return id == pictureData.id;
    }
}
