package it.mifsoft.signature.web.utils;

import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.Style;

public class FlexStyleUtils {

    public static void doItRow(Element element) {
        element.getStyle().setDisplay(Style.Display.FLEX);
        element.getStyle().set("flex-direction","row");
    }

    public static void doItColumn(Element element) {
        element.getStyle().setDisplay(Style.Display.FLEX);
        element.getStyle().set("flex-direction","column");
    }

    public static void doItCenteredRow(Element element) {
        doItRow(element);
        doItCentered(element);
    }

    public static void doItCenteredColumn(Element element) {
        doItColumn(element);
        doItCentered(element);
    }

    private static void doItCentered(Element element) {
        element.getStyle().set("align-items", "center");
        element.getStyle().set("justify-content", "center");
    }
}
