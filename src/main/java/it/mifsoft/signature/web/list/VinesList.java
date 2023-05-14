package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.dto.VineData;
import it.mifsoft.signature.web.list.item.VineListItem;
import it.mifsoft.signature.web.ui.VinesCarousel;
import org.springframework.stereotype.Component;

import java.util.List;

//"/img/bottle-2.png",
//"/img/bottle-3.png",
//"/img/bottle-5.png",
//"/img/bottle-6.png",
//"/img/bottle-8.png",
//"/img/bottle-9.png",
//"/img/bottle-10.png",
//"/img/bottle-11.png",
//"/img/bottle-12.png",
//"/img/bottle-13.png",
//"/img/bottle-14.png",
//"/img/bottle-15.png",
//"/img/bottle-16.png",
//"/img/bottle-17.png",
//"/img/bottle-18.png",
//"/img/bottle-19.png",
//"/img/bottle-20.png",
//"/img/bottle-21.png",
//"/img/bottle-22.png"

@Component
@UIScope
public class VinesList extends Div implements VinesCarousel.Delegate {
    private final List<VineData> vines = List.of(
            new VineData("ПОЛЬ БРЮЖЕ", "ПОЛЬ БРЮЖЕ ГРИЖЕ", "/img/bottle-2.png"),
            new VineData("ПОЛЬ БРЮЖЕ1", "ПОЛЬ БРЮЖЕ ГРИЖЕ", "/img/bottle-3.png"),
            new VineData("ПОЛЬ БРЮЖЕ2", "ПОЛЬ БРЮЖЕ ГРИЖЕ", "/img/bottle-8.png"),
            new VineData("ПОЛЬ БРЮЖЕ3", "ПОЛЬ БРЮЖЕ ГРИЖЕ", "/img/bottle-5.png"),
            new VineData("ПОЛЬ БРЮЖЕ4", "ПОЛЬ БРЮЖЕ ГРИЖЕ", "/img/bottle-6.png"),
            new VineData("ПОЛЬ БРЮЖЕ5", "ПОЛЬ БРЮЖЕ ГРИЖЕ", "/img/bottle-3.png"),
            new VineData("ПОЛЬ БРЮЖЕ6", "ПОЛЬ БРЮЖЕ ГРИЖЕ", "/img/bottle-8.png"),
            new VineData("ПОЛЬ БРЮЖЕ7", "ПОЛЬ БРЮЖЕ ГРИЖЕ", "/img/bottle-5.png"),
            new VineData("ПОЛЬ БРЮЖЕ8", "ПОЛЬ БРЮЖЕ ГРИЖЕ", "/img/bottle-6.png")
    );

    private final VineCategoriesList categoriesList = new VineCategoriesList();
    private final VinesCarousel carousel;

    private VineListItem currentItem;

    private final Div rightSide;
    private final Div leftSide;

    public VinesList() {
        this.addClassNames("vines-list-main");
        this.carousel = new VinesCarousel(vines);
        this.carousel.setDelegate(this);
        this.leftSide = new Div();
        this.rightSide = new Div();
        setup();
    }

    private void setup() {
        this.currentItem = new VineListItem(vines.get(0));

        this.leftSide.addClassNames("left-side");
        this.leftSide.add(categoriesList, carousel);

        this.rightSide.addClassNames("right-side");
        this.rightSide.add(this.currentItem);
        this.rightSide.getStyle().setTransition("all 2s ease");

        this.add(leftSide, rightSide);
    }

    @Override
    public void onVineChange(VineData vine) {
        this.rightSide.remove(this.currentItem);
        this.currentItem = new VineListItem(vine);
        this.rightSide.add(this.currentItem);
    }
}
