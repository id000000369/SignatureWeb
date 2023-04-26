package it.mifsoft.signature.web.dto;

public class MenuCategoryData {
    private long id;
    private String name;
    private String image;
    private String icon;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }

    public String getIcon() { return icon; }
    public void setIcon(String value) { this.icon = value; }
}
