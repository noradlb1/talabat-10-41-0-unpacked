package com.pichillilorenzo.flutter_inappwebview.types;

import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ContentWorld {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ContentWorld DEFAULT_CLIENT = new ContentWorld("defaultClient");
    public static final ContentWorld PAGE = new ContentWorld("page");

    /* renamed from: name  reason: collision with root package name */
    private String f52876name;

    private ContentWorld(String str) {
        this.f52876name = str;
    }

    public static ContentWorld fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new ContentWorld((String) map.get("name"));
    }

    public static ContentWorld world(String str) {
        return new ContentWorld(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f52876name.equals(((ContentWorld) obj).f52876name);
    }

    public String getName() {
        return this.f52876name;
    }

    public int hashCode() {
        return this.f52876name.hashCode();
    }

    public void setName(String str) {
        this.f52876name = str;
    }

    public String toString() {
        return "ContentWorld{name='" + this.f52876name + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
