package it.mifsoft.signature.web.forms;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.spring.annotation.UIScope;
import it.mifsoft.signature.web.MainLayout;
import it.mifsoft.signature.web.ModalDelegate;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class ReserveForm extends Div {
    private final H1 firstHeaderText;
    private ModalDelegate delegate;
    private final H1 reminderText;
    private final H1 infoText;
    private final TextField name;
    private final TextField phoneNumber;
    private final DateTimePicker date;
    private final TextField guestCount;
    private final Button reserveButton;
    private final Div buttonContainer;
//    private final Div infoTextContainer;
//    private final Div reminderTextContainer;
    private final Image namePrefix = new Image();
    private final Image phonePrefix = new Image();
    private final Image guestPrefix = new Image();
    private final Label checkbox;
    private final Image verticalSeparator;
    private final Div itemsContainer;
    private final Image adaptiveBackgroundImg;
    private final Image closeModalBtn;
//    private final Div bottomItems;
    public ReserveForm() {

        this.firstHeaderText = createFirstHeaderText();
        this.name = createNameField();
        this.phoneNumber = createPhoneNumberField();
        this.date = createDateTimePicker();
        this.guestCount = createGuestCountField();
        this.reminderText = createReminderText();
        this.infoText = createInfoText();
        this.reserveButton = createReserveButton();
        this.buttonContainer = createButtonContainer();
//        this.infoTextContainer = createInfoTextContainer();
//        this.reminderTextContainer = createReminderTextContainer();
        this.checkbox = createCheckbox();
        this.verticalSeparator = createVerticalSeparator();
        this.itemsContainer = createItemsContainer();

        this.adaptiveBackgroundImg = createAdaptiveBackgroundImg();
        this.closeModalBtn = createCloseModalBtn();
        this.add(
                createVerticalSeparator(),
                createItemsContainer(), createAdaptiveBackgroundImg(), closeModalBtn);
        this.addClassName("reserve-container");
    }

    public void hide() {
        this.getStyle().set("display","none");
    }
    public Image createCloseModalBtn() {
        final Image img = new Image();
        img.setSrc("");
        img.addClickListener(event -> {
            this.delegate.hideModal();
        });
        img.addClassName("close-form-btn");
        return img;
    }

    public void setYellowCloseBtn() {
        this.closeModalBtn.setSrc("img/gold-close-icon.png");
    }

    public void setGreyCloseBtn() {
        this.closeModalBtn.setSrc("img/grey-close-icon.png");

    }

    private final Image createAdaptiveBackgroundImg() {
        final Image img = new Image("/img/adaptive-reserve-background-img.png", "");
        img.addClassName("adaptive-reserve-background-img");
        return img;
    }

    private Div createItemsContainer() {
        final Div items = new Div();
        items.add(reserveItems());
        items.addClassName("reserve-items-container");
        return items;
    }

    private Image createVerticalSeparator() {
        final Image separator = new Image("/img/vertical-separator.png", "");
        separator.addClassNames("reserve-separator");
        return separator;
    }

//    private Div createReminderTextContainer() {
//        final Div container = new Div();
//        container.add(reminderText, createCheckbox());
//        container.addClassName("reminder-text-container");
//        return container;
//    }
//
//    private Div createInfoTextContainer() {
//        final Div container = new Div();
//        container.add(infoText);
//        container.addClassName("info-text-container");
//        return container;
//    }

    private Div createButtonContainer() {
        final Div container = new Div();
        container.add(reserveButton, infoText, reminderText, createCheckbox());
        container.addClassName("reserve-button-container");
        return container;
    }

    private Button createReserveButton() {
        Button button = new Button();
        button.setText("Забронировать столик");
        button.addClassName("reserve-button");
        return button;
    }

    private Label createCheckbox() {
        final Label label = new Label();
        label.addClassName("switch");
        final Input input = new Input();
        input.setType("checkbox");
        final Span span = new Span();
        span.addClassNames("slider", "round");
        label.add(input, span);
        return label;
    }

    public Div reserveItems() {
        Div items = new Div();
        items.add(
                firstHeaderText,
                name,
                phoneNumber,
                date,
                guestCount,
                createButtonContainer()
//                createReminderTextContainer(),
//                createInfoTextContainer()
        );

        items.addClassName("reserve-items");
        return items;
    }

    public H1 createFirstHeaderText() {
        H1 name = new H1("ЗАБРОНИРОВАТЬ СТОЛИК");
        name.addClassName("header-text");
        return name;
    }

    public H1 createReminderText() {
        H1 name = new H1("Напомните мне о бронировании");
        name.addClassName("reminder-text");
        return name;
    }

    public H1 createInfoText() {
        H1 name = new H1("Вам придет пуш-уведомление о бронировании,\nчтобы мы с вами точно встретились :)");
        name.addClassName("info-text");
        return name;
    }

    public TextField createNameField() {
        TextField name = new TextField();
        name.setLabel("ПРЕДСТАВЬТЕСЬ ПОЖАЛУЙСТА");
        name.setPrefixComponent(VaadinIcon.USER.create());
        name.setPlaceholder("Виктория");
        name.addClassName("name-text");
        namePrefix.setSrc("https://i.ibb.co/bKSrRHK/Rectangle-890.png");
        namePrefix.addClassName("name-prefix");
        name.addClassName("adaptive-reserve-name-text");
        name.setPrefixComponent(namePrefix);
        add(name);
        return name;
    }

    public TextField createPhoneNumberField() {
        TextField phoneNumber = new TextField("ТЕЛЕФОН");
        phoneNumber.setPrefixComponent(VaadinIcon.USER.create());
        phoneNumber.setPlaceholder("+7 (---) --- -- --");
        phoneNumber.addClassName("phone-number-text");
        phonePrefix.setSrc("https://i.ibb.co/m9JzsJJ/Vector.png");
        phonePrefix.addClassName("phone-prefix");
        phoneNumber.addClassName("adaptive-reserve-phone-text");
        phoneNumber.setPrefixComponent(phonePrefix);
        return phoneNumber;
    }

    public DateTimePicker createDateTimePicker() {
        DateTimePicker dateTimePicker = new DateTimePicker("ДАТА");
        dateTimePicker.setDatePlaceholder("18 апреля 2023");
        dateTimePicker.setTimePlaceholder("18:00");
        dateTimePicker.addClassName("date-time-picker");
        return dateTimePicker;
    }

    public TextField createGuestCountField() {
        TextField countField = new TextField("НАС БУДЕТ");
        countField.setPlaceholder("4 гостя");
        countField.addClassName("guest-count-text");
        guestPrefix.setSrc("https://i.ibb.co/tCywqWy/Group-37387.png");
        guestPrefix.addClassName("guest-prefix");
        countField.setPrefixComponent(guestPrefix);
        return countField;
    }

    public void setDelegate(ModalDelegate delegate) {
        this.delegate = delegate;
    }
}