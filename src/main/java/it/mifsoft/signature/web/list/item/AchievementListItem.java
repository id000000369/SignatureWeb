package it.mifsoft.signature.web.list.item;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;

public class AchievementListItem extends Div {
    private final String imageUrl;
    private final String title;
    private final Div content;
    private final H1 titleH;

    public AchievementListItem(String title, String imageUrl, Div content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.titleH = createTitleH();
        this.addClassNames("achievment-main");
        this.getStyle().set("background-image", "url('"+imageUrl+"')");
        this.add(titleH, content);
    }
    public H1 createTitleH() {
        final H1 title = new H1();
        title.setText(this.title);
        title.addClassName("achievment-title");
        return title;
    }
}