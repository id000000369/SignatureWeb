package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.list.item.AchievementListItem;
import it.mifsoft.signature.web.utils.FlexStyleUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@UIScope
public class AchievmentsList extends Div {
    private final List<AchievementData> achievements = List.of(
            new AchievementData(
                    "ОТ НАС",
                    "С ЛЮБОВЬЮ",
                    "В каждом нашем блюде есть секретный ингредиент – любовь. Любовь к еде и к нашим клиентам.",
                    "/img/otnas.png ",
                    null,
                    "Забронировать столик"
            ),
            new AchievementData(
                    "НАША",
                    "КОНЦЕПЦИЯ",
                    "Наш ресторан Signature Art транслирует уникальную концепцию " +
                            "арт-пространства. Мы дарим гостям новый опыт, " +
                            "возможность прожить новый экспириенс – стать ценителем искусства и дегустатором. " +
                            "Высотка на Котельнической набережной - примечательное место Москвы, " +
                            "место притяжения, дом-эпоха, дом личностей, дом стиля. " +
                            "Уже это требует наполнения вкусом и искусством, эмоциями и красотой." +
                            "Рады сообщить вам, что уже в марте мы откроем для вас двери арт ресторана, " +
                            "где вы сможете не просто вкусно поесть, а также ощутить новое особенное внимательное " +
                            "к вам пространство.",
                    "/img/conception.png"),

            new AchievementData(
                    "КОМАНДА",
                    "ПРОФЕССИОНАЛОВ",
                    "Наша команда оправдает ваши самые высокие ожидания.",
                    "/img/team.png",
                    "/img/medal.png"
            )
    );
    private List<AchievementListItem> achievementsListItems;

    public AchievmentsList() {
        FlexStyleUtils.doItCenteredRow(this.getElement());
        this.achievementsListItems = createListItems();
        this.achievementsListItems.forEach(this::add);
    }


    private List<AchievementListItem> createListItems() {
        return achievements.stream()
                .map(this::createAchievmentListItem)
                .toList();
    }

    private AchievementListItem createAchievmentListItem(AchievementData data) {
        final Div content = new Div();
        content.addClassName("some-class-name");
        if (data.image.isPresent()) {
            final Image img = new Image();
            img.setSrc(data.image.get());
            content.add(img);
        }

        final Paragraph text = new Paragraph();
        this.addClassName("achievment-paragraph");
        content.add(text);

        if (data.buttonTitle.isPresent()) {
            final Button button = new Button();
            button.setText(data.buttonTitle.get());
            button.addClassName("achievment-reserve-button");
            content.add(button);
        }

        final AchievementListItem item =
                new AchievementListItem(data.title, data.backgroundImage, content);
        item.setWidth("500px");
        item.addClassName("item");
        return item;
    }

    public void addArchiveListItem(String title, String imageUrl, Div content) {
        AchievementListItem archiveListItem = new AchievementListItem(title, imageUrl, content);
        achievementsListItems.add(archiveListItem);
        archiveListItem.addClassName("archiveListItem");
        add(archiveListItem);
    }

    class AchievementData {
        final String title;
        final String subtitle;
        final String description;
        final String backgroundImage;
        final Optional<String> image;
        final Optional<String> buttonTitle;

        public AchievementData(String title,
                               String subtitle,
                               String description,
                               String backgroundImage) {
            this(title, subtitle, description, backgroundImage, null, null);
        }

        public AchievementData(String title,
                               String subtitle,
                               String description,
                               String backgroundImage,
                               String image) {
            this(title, subtitle, description, backgroundImage, image, null);
        }

        public AchievementData(String title,
                               String subtitle,
                               String description,
                               String backgroundImage,
                               String image,
                               String buttonTitle) {
            this.title = title;
            this.subtitle = subtitle;
            this.description = description;
            this.backgroundImage = backgroundImage;
            this.image = Optional.ofNullable(image);
            this.buttonTitle = Optional.ofNullable(buttonTitle);
        }
    }
}
