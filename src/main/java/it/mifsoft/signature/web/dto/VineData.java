package it.mifsoft.signature.web.dto;

public class VineData {

    private String name;
    private String subName;
    private String type;
    private double strength;
    private double volume;
    private String region;
    private String manufacturer;
    private String grape;
    private String idealFor;
    private String additionally;
    private String image;

    public VineData(String name,
                    String subName,
                    String image) {
        this.name = name;
        this.subName = subName;
        this.image = image;
    }

    public VineData(String name,
                    String subName,
                    String type,
                    double strength,
                    double volume,
                    String region,
                    String manufacturer,
                    String grape,
                    String idealFor,
                    String additionally) {
        this.name = name;
        this.subName = subName;
        this.type = type;
        this.strength = strength;
        this.volume = volume;
        this.region = region;
        this.manufacturer = manufacturer;
        this.grape = grape;
        this.idealFor = idealFor;
        this.additionally = additionally;
    }

    public String getName() {
        return name;
    }

    public String getSubName() {
        return subName;
    }

    public String getType() {
        return type;
    }

    public double getStrength() {
        return strength;
    }

    public double getVolume() {
        return volume;
    }

    public String getRegion() {
        return region;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getGrape() {
        return grape;
    }

    public String getIdealFor() {
        return idealFor;
    }

    public String getAdditionally() {
        return additionally;
    }

    public String getImage() {
        return image;
    }
}
