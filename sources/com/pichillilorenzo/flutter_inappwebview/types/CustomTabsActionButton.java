package com.pichillilorenzo.flutter_inappwebview.types;

import java.util.Arrays;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class CustomTabsActionButton {
    private String description;
    private byte[] icon;

    /* renamed from: id  reason: collision with root package name */
    private int f52877id;
    private boolean shouldTint;

    public CustomTabsActionButton(int i11, byte[] bArr, String str, boolean z11) {
        this.f52877id = i11;
        this.icon = bArr;
        this.description = str;
        this.shouldTint = z11;
    }

    public static CustomTabsActionButton fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new CustomTabsActionButton(((Integer) map.get("id")).intValue(), (byte[]) map.get("icon"), (String) map.get("description"), ((Boolean) map.get("shouldTint")).booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CustomTabsActionButton customTabsActionButton = (CustomTabsActionButton) obj;
        if (this.f52877id == customTabsActionButton.f52877id && this.shouldTint == customTabsActionButton.shouldTint && Arrays.equals(this.icon, customTabsActionButton.icon)) {
            return this.description.equals(customTabsActionButton.description);
        }
        return false;
    }

    public String getDescription() {
        return this.description;
    }

    public byte[] getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.f52877id;
    }

    public int hashCode() {
        return (((((this.f52877id * 31) + Arrays.hashCode(this.icon)) * 31) + this.description.hashCode()) * 31) + (this.shouldTint ? 1 : 0);
    }

    public boolean isShouldTint() {
        return this.shouldTint;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIcon(byte[] bArr) {
        this.icon = bArr;
    }

    public void setId(int i11) {
        this.f52877id = i11;
    }

    public void setShouldTint(boolean z11) {
        this.shouldTint = z11;
    }

    public String toString() {
        return "CustomTabsActionButton{id=" + this.f52877id + ", icon=" + Arrays.toString(this.icon) + ", description='" + this.description + '\'' + ", shouldTint=" + this.shouldTint + AbstractJsonLexerKt.END_OBJ;
    }
}
