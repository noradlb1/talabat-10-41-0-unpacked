package com.pichillilorenzo.flutter_inappwebview.types;

import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class HitTestResult {
    private String extra;
    private int type;

    public HitTestResult(int i11, String str) {
        this.type = i11;
        this.extra = str;
    }

    public static HitTestResult fromWebViewHitTestResult(WebView.HitTestResult hitTestResult) {
        if (hitTestResult == null) {
            return null;
        }
        return new HitTestResult(hitTestResult.getType(), hitTestResult.getExtra());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HitTestResult hitTestResult = (HitTestResult) obj;
        if (this.type != hitTestResult.type) {
            return false;
        }
        String str = this.extra;
        String str2 = hitTestResult.extra;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public String getExtra() {
        return this.extra;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i11 = this.type * 31;
        String str = this.extra;
        return i11 + (str != null ? str.hashCode() : 0);
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.type));
        hashMap.put("extra", this.extra);
        return hashMap;
    }

    public String toString() {
        return "HitTestResultMap{type=" + this.type + ", extra='" + this.extra + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
