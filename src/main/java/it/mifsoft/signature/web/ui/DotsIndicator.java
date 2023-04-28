package it.mifsoft.signature.web.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.dom.Style;
import it.mifsoft.signature.web.utils.FlexStyleUtils;

import java.util.List;
import java.util.Optional;

//@CssImport()
public class DotsIndicator extends Div {

    private final static String DEFAULT_SELECTED_COLOR = "white";
    private final static String DEFAULT_COLOR = "black";

    private final List<Dot> dots;
    private Dot selectedDot;
    private DotsIndicatorDelegate delegate;

    private final String selectedColor;
    private final String defaultColor;

    public DotsIndicator(List<String> ids) {
        this(ids, null);
    }

    public DotsIndicator(List<String> ids, DotsIndicatorDelegate delegate) {
        this(ids, DEFAULT_SELECTED_COLOR, DEFAULT_COLOR, delegate);
    }

    public DotsIndicator(List<String> ids, String selectedColor, String defaultColor) {
        this(ids, selectedColor, defaultColor, null);
    }

    public DotsIndicator(List<String> ids, String selectedColor, String defaultColor, DotsIndicatorDelegate delegate) {
        this.dots = createDots(ids, selectedColor, defaultColor);
        this.selectedColor = selectedColor;
        this.defaultColor = defaultColor;
        this.delegate = delegate;
        this.addClassName("dots-indicator");
        setup();
    }

    private void setup() {
        FlexStyleUtils.doItCenteredRow(this.getElement());
        this.dots.forEach(this::add);
        this.getStyle().setOverflow(Style.Overflow.HIDDEN);
    }

    public void select(String id) {
        final Dot oldSelectedDot = this.selectedDot;
        final Optional<Dot> dot = dots
                .stream()
                .filter(d -> d.id.equals(id))
                .findFirst();

        if (dot.isEmpty()) {
            throw new RuntimeException(String.format("Dot with id = %s not found", id));
        }

        if (selectedDot == null) {
            this.selectedDot = dot.get();
            this.selectedDot.setPrimary();
        } else if (selectedDot.id.equals(id)) {
            return;
        } else {
            this.selectedDot.setSecondary();
            this.selectedDot = dot.get();
            this.selectedDot.setPrimary();
        }

        if (delegate != null) {
            delegate.dotChangedAction(oldSelectedDot, this.selectedDot);
        }
    }

    private List<Dot> createDots(List<String> ids) {
        return createDots(ids, DEFAULT_SELECTED_COLOR, DEFAULT_COLOR);
    }

    private List<Dot> createDots(List<String> ids, String selectedColor, String defaultColor) {
        return ids.stream().map(id -> {
            final Dot dot = new Dot(id, selectedColor, defaultColor);
            dot.addClickListener((event) -> {
                select(dot.id);
            });
            return dot;
        }).toList();
    }

    public interface DotsIndicatorDelegate {
        void dotChangedAction(Dot oldDot, Dot newDot);
    }

//    @CssImport("")
    public static class Dot extends Span {

        private final String id;

        private final String secondaryColor;
        private final String primaryColor;

        private boolean isPrimary;

        private Dot(String id) {
            this(id, DEFAULT_SELECTED_COLOR, DEFAULT_COLOR);
        }

        public Dot(String id, String primaryColor, String secondaryColor) {
            this(id, primaryColor, secondaryColor, false);
        }

        public Dot(String id, String primaryColor, String secondaryColor, boolean isPrimary) {
            this.setId("dot_" + id);
            this.id = id;
            this.secondaryColor = secondaryColor;
            this.primaryColor = primaryColor;
            this.isPrimary = isPrimary;
            setup();
        }

        private void setup() {
            this.getStyle().set("border-radius", "50%");
            this.getStyle().set("display", "inline-block");
            this.getStyle().set("width", "12px");
            this.getStyle().set("height", "12px");
            this.getStyle().set("margin", "8px");

            setSecondary();
        }

        private void setSecondary() {
            this.getStyle().set("background-color", secondaryColor);
            this.isPrimary = false;
        }

        public boolean isPrimary() {
            return isPrimary;
        }

        public void setPrimary() {
            this.getStyle().set("background-color", primaryColor);
            this.isPrimary = true;
        }
    }

}
