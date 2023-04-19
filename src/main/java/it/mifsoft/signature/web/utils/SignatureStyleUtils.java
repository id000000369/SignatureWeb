package it.mifsoft.signature.web.utils;

import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.Style;

public class SignatureStyleUtils {

    public static void doItRow(Element element) {
        element.getStyle().setDisplay(Style.Display.FLEX);
        element.getStyle().set("flex-direction","row");
    }
}
