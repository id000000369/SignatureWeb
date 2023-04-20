package it.mifsoft.signature.web.utils;

import com.vaadin.flow.dom.Element;

public class SizeStyleUtils {

    public static void sizeIt(Element element, double width, double height) {
        element.getStyle().setWidth(width + "px");
        element.getStyle().setHeight(height + "px");
    }
}
