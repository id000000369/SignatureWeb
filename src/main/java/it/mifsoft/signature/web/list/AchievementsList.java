package it.mifsoft.signature.web.list;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.MainLayout;
import it.mifsoft.signature.web.forms.ReserveForm;
import it.mifsoft.signature.web.list.item.AchievementListItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@UIScope
public class AchievementsList extends Div {
    private final MainLayout mainLayout;

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
                    "/img/achievment-medals.png"),
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
                    "/img/achievment-medals.png")
    );
    private List<AchievementListItem> achievementsListItems;

    public AchievementsList(MainLayout mainLayout) {
        this.mainLayout = mainLayout;
        this.achievementsListItems = createListItems();
        add(createAchievementsTopImg());
        this.achievementsListItems.forEach(this::add);
        final Button button = new Button();
        button.setText("Забронировать столик");
        button.addClickListener(event -> this.mainLayout.showModal(new ReserveForm()));
        button.addClassName("achievement-reserve-a-table");
        this.add(button);
        this.addClassName("achievements-list");
    }

    private Image createAchievementsTopImg() {
        final Image img = new Image("img/achievements-top-img.png", "");
        img.addClassName("achievements-top-img");
        return img;
    }


    private List<AchievementListItem> createListItems() {
        return achievements.stream()
                .map(this::createAchievmentListItem)
                .toList();
    }

    private AchievementListItem createAchievmentListItem(AchievementData data) {
        final Div content = new Div();
        content.addClassName("content-some-class-name");
        if (data.image.isPresent()) {
            final Image img = new Image();
            img.setSrc(data.image.get());
            img.addClassNames("image-achievements");
            content.add(img);
        }

        final H2 description = new H2();
        description.setText(data.description);
        description.addClassName("achievment-description");
        content.add(description);

        if (data.buttonTitle.isPresent()) {
            final Button button = new Button();
            button.setText(data.buttonTitle.get());
            button.addClickListener(event -> this.mainLayout.showReserveForm());
            button.addClassName("achievment-reserve-button");
            content.add(button);
        }

        final AchievementListItem item =
                new AchievementListItem(data.title, data.subtitle, data.backgroundImage, content);
        return item;
    }

    public void addArchiveListItem(String title, String subTitle, String imageUrl, Div content) {
        AchievementListItem archiveListItem = new AchievementListItem(title, subTitle, imageUrl, content);
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
