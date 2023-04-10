package it.mifsoft.signature.web.forms;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Route(value = "reserve")
public class ReserveForm extends FormLayout {

    private final H1 firstHeaderText;
    private final H1 secondHeaderText;
    private final H1 reminderText;
    private final H1 infoText;
    private final TextField name;
    private final TextField phoneNumber;
    private final DateTimePicker date;
    private final TextField guestCount;

    public ReserveForm () {
        this.firstHeaderText = createFirstHeaderText();
        this.secondHeaderText = createSecondHeaderText();
        this.name = createNameField();
        this.phoneNumber = createPhoneNumberField();
        this.date = createDateTimePicker();
        this.guestCount = createGuestCountField();
        this.reminderText = createReminderText();
        this.infoText = createInfoText();

        this.add(reserveItems());
        this.addClassName("reserve-view");
    }

    public Div reserveItems(){
        Div items = new Div();
        items.add(firstHeaderText, secondHeaderText, name, phoneNumber, date, guestCount, reminderText, infoText);
        items.addClassName("reserve-items");
        return items;
    }

    public H1 createFirstHeaderText(){
        H1 name = new H1("ЗАБРОНИРОВАТЬ");
        name.addClassName("first-header-text");
        return name;
    }

    public H1 createSecondHeaderText(){
        H1 name = new H1("СТОЛИК");
        name.addClassName("second-header-text");
        return name;
    }


    public H1 createReminderText(){
        H1 name = new H1("Напомните мне о бронировании");
        name.addClassName("reminder-text");
        return name;
    }

    public H1 createInfoText(){
        H1 name = new H1("Вам придет пуш-уведомление о бронировании, чтобы мы с вами точно встретились :)");
        name.addClassName("info-text");
        return name;
    }
    public TextField createNameField(){
        TextField name = new TextField();
        name.setPrefixComponent(VaadinIcon.USER.create());
        name.setLabel("ПРЕДСТАВЬТЕСЬ ПОЖАЛУЙСТА");
        name.setPlaceholder("Имя");
        name.addClassName("name-text");
        return name;
    }

    public TextField createPhoneNumberField(){
        TextField phoneNumber = new TextField();
        phoneNumber.setPrefixComponent(VaadinIcon.USER.create());
        phoneNumber.setLabel("ТЕЛЕФОН");
        phoneNumber.setPlaceholder("+7 (---) --- -- --");
        phoneNumber.addClassName("phone-number-text");
        return phoneNumber;
    }

    public DateTimePicker createDateTimePicker(){
        DateTimePicker dateTimePicker = new DateTimePicker();
        dateTimePicker.setLabel("ДАТА");
        dateTimePicker.setDatePlaceholder("18 апреля 2023");
        dateTimePicker.setTimePlaceholder("18:00");
        dateTimePicker.addClassName("date-time-picker");
        return dateTimePicker;
    }

    public TextField createGuestCountField(){
        TextField countField = new TextField();
        countField.setLabel("НАС БУДЕТ");
        countField.setPlaceholder("4 гостя");
        countField.addClassName("guest-count-text");
        return countField;
    }
}
