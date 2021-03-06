package com.github.appreciated.app.layout.component.appmenu.left.builder;

import com.github.appreciated.app.layout.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.builder.interfaces.NavigationElementContainer;
import com.github.appreciated.app.layout.component.appmenu.left.LeftMenuComponent;
import com.github.appreciated.app.layout.component.appmenu.left.LeftNavigationComponent;
import com.github.appreciated.app.layout.entity.Section;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

import java.util.ArrayList;
import java.util.List;


/**
 * A Builder to build {@link LeftMenuComponent} this builder is meant to be used in combination with the {@link AppLayoutBuilder}
 */
public class LeftAppMenuBuilder {

    List<Component> components = new ArrayList<>();

    List<Component> header = new ArrayList<>();
    List<Component> body = new ArrayList<>();
    List<Component> footer = new ArrayList<>();

    protected LeftAppMenuBuilder() {
    }

    private LeftAppMenuBuilder(String title, Icon icon) {

    }

    public static LeftAppMenuBuilder get() {
        return new LeftAppMenuBuilder();
    }

    /**
     * returns a SubmenuBuilder with a predefined expanding element that only has a title
     *
     * @param title
     * @return
     */
    public static LeftAppMenuBuilder get(String title) {
        return new LeftAppMenuBuilder(title, null);
    }

    /**
     * returns a SubmenuBuilder with a predefined expanding element that only has an icon
     *
     * @param icon
     * @return
     */
    public static LeftAppMenuBuilder get(Icon icon) {
        return new LeftAppMenuBuilder(null, icon);
    }

    /**
     * returns a SubmenuBuilder with a predefined expanding element that has an icon and a title
     *
     * @param icon
     * @return
     */
    public static LeftAppMenuBuilder get(String title, Icon icon) {
        return new LeftAppMenuBuilder(title, icon);
    }


    public LeftAppMenuBuilder add(Component element) {
        return addToSection(element, Section.DEFAULT);
    }

    public LeftAppMenuBuilder add(String caption, VaadinIcon icon, Class<? extends Component> className) {
        return add(new LeftNavigationComponent(caption, icon, className));
    }

    public LeftAppMenuBuilder add(String caption, Icon icon, Class<? extends Component> className) {
        return add(new LeftNavigationComponent(caption, icon, className));
    }

    public LeftAppMenuBuilder addToSection(Component element, Section section) {
        switch (section) {
            case HEADER:
                header.add(element);
                break;
            case FOOTER:
                footer.add(element);
                break;
            default:
                body.add(element);
        }
        return this;
    }

    public NavigationElementContainer build() {
        components.addAll(header);
        components.addAll(body);
        components.addAll(footer);
        LeftMenuComponent menu = new LeftMenuComponent();
        menu.add(components.toArray(new Component[0]));
        return menu;
    }
}
