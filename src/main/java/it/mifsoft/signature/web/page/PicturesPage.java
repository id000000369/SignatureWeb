package it.mifsoft.signature.web.page;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.list.PicturesList;
import org.springframework.stereotype.Component;

@Component
@UIScope

public class PicturesPage extends Div {

    private final PicturesList picturesList;

    public PicturesPage(PicturesList picturesList) {


        this.addClassNames("picture-main-div");
        this.picturesList = picturesList;

        this.add(this.picturesList);
    }
}
