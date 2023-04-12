package it.mifsoft.signature.web.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.ContentLayout;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "hello", layout = ContentLayout.class)
public class AboutView extends Div {
   // private final Image art;
    public AboutView() {

      //  this.art = createArtImg();

        this.add(new Paragraph("Наш ресторан Signature Art\nтранслирует уникальную\nконцепцию арт-пространства.\nМы дарим гостям новый опыт,\nвозможность прожить новый\nэкспириенс – стать ценителем\nискусства и дегустатором.\n" +
                "Подробности..."));
     //   this.add(art);
        this.addClassName("about-us-view");
    }

    public Image createArtImg() {
        Image art = new Image("img/art-image.png", "");
        art.addClassName("art-img");
        this.add(art);
        return art;
    }
}
