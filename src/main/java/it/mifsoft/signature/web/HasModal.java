package it.mifsoft.signature.web;

import com.vaadin.flow.component.Component;

public interface HasModal {
    void setModal(Component component);
    void showModal();
    void hideModal();
}
