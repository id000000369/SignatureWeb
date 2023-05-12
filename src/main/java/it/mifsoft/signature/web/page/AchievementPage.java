package it.mifsoft.signature.web.page;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import it.mifsoft.signature.web.list.AchievementsList;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "achievement", layout = ContentLayout.class)
public class AchievementPage extends Div {

    private final AchievementsList achievementsList;

    public AchievementPage(AchievementsList achievementsList) {

        this.setWidthFull();
        this.setHeightFull();
        this.achievementsList = achievementsList;
        this.add(this.achievementsList);
    }
}
