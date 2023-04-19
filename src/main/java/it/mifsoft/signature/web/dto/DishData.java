package it.mifsoft.signature.web.dto;

public class DishData {
    private long id;
    private String name;
    private String description;
    private double price;
    private String image;

    public DishData() {

    }

    public DishData(long id, String name, String description, double price, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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

    public double getPrice() {
        return price;
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
        DishData dishData = (DishData) o;
        return id == dishData.id;
    }
}
