package it.mifsoft.signature.web.page;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.list.AchievementsList;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "achievment", layout = ContentLayout.class)
public class AchievmentPage extends Div {

    private final AchievementsList achivmentsList;
    public AchievmentPage(AchievementsList achivmentsList) {

        this.setWidthFull();
        this.setHeightFull();
        this.achivmentsList = achivmentsList;
        this.add(this.achivmentsList);
    }
}
