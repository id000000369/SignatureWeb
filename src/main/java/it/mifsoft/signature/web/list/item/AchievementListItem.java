package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;

public class AchievementListItem extends Div {
    private final String imageUrl;
    private final String title;
    private final String subTitle;
    private final Div content;
    private final H1 titleH;
    private final H1 subTitleH;

    public AchievementListItem(String title, String subTitle, String imageUrl, Div content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.titleH = createTitleH();
        this.subTitleH = createSubTitleH();
        this.addClassNames("achievment-main");
        this.getStyle().set("background-image", "url('" + imageUrl + "')");
        this.add(titleH, subTitleH, content);
    }

    public H1 createTitleH() {
        final H1 title = new H1();
        title.setText(this.title);
        title.addClassName("achievment-title");
        return title;
    }

    public H1 createSubTitleH() {
        final H1 subTitle = new H1();
        subTitle.setText(this.subTitle);
        subTitle.addClassName("achievment-subtitle");
        return subTitle;
    }



//    public H2 createDescriptionH() {
//        final H2 description = new H2();
//        description.setText(this.description);
//        description.addClassName("achievment-description");
//        return description;
//    }
}