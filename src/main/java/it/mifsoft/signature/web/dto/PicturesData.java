package it.mifsoft.signature.web.dto;


public class PicturesData {

    long id;
    String image;
    String mainText;
    String iconPerson;
    String dataPerson;
    String linkInst;
    String description;

    public PicturesData(long id, String image, String mainText, String iconPerson,
                        String dataPerson, String linkInst, String description) {
        this.id = id;
        this.image = image;
        this.mainText = mainText;
        this.iconPerson = iconPerson;
        this.dataPerson = dataPerson;
        this.linkInst = linkInst;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getIconPerson() {
        return iconPerson;
    }

    public void setIconPerson(String iconPerson) {
        this.iconPerson = iconPerson;
    }

    public String getDataPerson() {
        return dataPerson;
    }

    public void setDataPerson(String dataPerson) {
        this.dataPerson = dataPerson;
    }

    public String getLinkInst() {
        return linkInst;
    }

    public void setLinkInst(String linkInst) {
        this.linkInst = linkInst;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PicturesData picturesData = (PicturesData) o;
//        return id == picturesData.id;
//    }
}
