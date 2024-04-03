package com.pichillilorenzo.flutter_inappwebview.types;

import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class CustomTabsMenuItem {

    /* renamed from: id  reason: collision with root package name */
    private int f52878id;
    private String label;

    public CustomTabsMenuItem(int i11, String str) {
        this.f52878id = i11;
        this.label = str;
    }

    public static CustomTabsMenuItem fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new CustomTabsMenuItem(((Integer) map.get("id")).intValue(), (String) map.get("label"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CustomTabsMenuItem customTabsMenuItem = (CustomTabsMenuItem) obj;
        if (this.f52878id != customTabsMenuItem.f52878id) {
            return false;
        }
        return this.label.equals(customTabsMenuItem.label);
    }

    public int getId() {
        return this.f52878id;
    }

    public String getLabel() {
        return this.label;
    }

    public int hashCode() {
        return (this.f52878id * 31) + this.label.hashCode();
    }

    public void setId(int i11) {
        this.f52878id = i11;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String toString() {
        return "CustomTabsMenuItem{id=" + this.f52878id + ", label='" + this.label + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
