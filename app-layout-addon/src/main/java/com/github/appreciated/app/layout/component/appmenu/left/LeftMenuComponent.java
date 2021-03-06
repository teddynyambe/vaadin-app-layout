package com.github.appreciated.app.layout.component.appmenu.left;

import com.github.appreciated.app.layout.builder.interfaces.NavigationElementContainer;
import com.github.appreciated.app.layout.webcomponents.appmenu.AppMenu;
import com.vaadin.flow.component.Component;

public class LeftMenuComponent extends AppMenu implements NavigationElementContainer {

    public LeftMenuComponent() {
        getStyle().set("padding", "var(--app-layout-menu-padding)");
    }

    @Override
    public Component getComponent() {
        return this;
    }
}
