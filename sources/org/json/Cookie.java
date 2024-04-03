package org.json;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;

public class Cookie {
    public static String escape(String str) {
        String trim = str.trim();
        int length = trim.length();
        StringBuilder sb2 = new StringBuilder(length);
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = trim.charAt(i11);
            if (charAt < ' ' || charAt == '+' || charAt == '%' || charAt == '=' || charAt == ';') {
                sb2.append('%');
                sb2.append(Character.forDigit((char) ((charAt >>> 4) & 15), 16));
                sb2.append(Character.forDigit((char) (charAt & 15), 16));
            } else {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }

    public static JSONObject toJSONObject(String str) throws JSONException {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        JSONTokener jSONTokener = new JSONTokener(str);
        jSONObject.put("name", (Object) jSONTokener.nextTo((char) SignatureVisitor.INSTANCEOF));
        jSONTokener.next((char) SignatureVisitor.INSTANCEOF);
        jSONObject.put("value", (Object) jSONTokener.nextTo((char) TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER));
        jSONTokener.next();
        while (jSONTokener.more()) {
            String unescape = unescape(jSONTokener.nextTo("=;"));
            if (jSONTokener.next() == '=') {
                obj = unescape(jSONTokener.nextTo((char) TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER));
                jSONTokener.next();
            } else if (unescape.equals("secure")) {
                obj = Boolean.TRUE;
            } else {
                throw jSONTokener.syntaxError("Missing '=' in cookie parameter.");
            }
            jSONObject.put(unescape, obj);
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(escape(jSONObject.getString("name")));
        sb2.append("=");
        sb2.append(escape(jSONObject.getString("value")));
        if (jSONObject.has("expires")) {
            sb2.append(";expires=");
            sb2.append(jSONObject.getString("expires"));
        }
        if (jSONObject.has("domain")) {
            sb2.append(";domain=");
            sb2.append(escape(jSONObject.getString("domain")));
        }
        if (jSONObject.has("path")) {
            sb2.append(";path=");
            sb2.append(escape(jSONObject.getString("path")));
        }
        if (jSONObject.optBoolean("secure")) {
            sb2.append(";secure");
        }
        return sb2.toString();
    }

    public static String unescape(String str) {
        int i11;
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i12 = 0;
        while (i12 < length) {
            char charAt = str.charAt(i12);
            if (charAt == '+') {
                charAt = ' ';
            } else if (charAt == '%' && (i11 = i12 + 2) < length) {
                int dehexchar = JSONTokener.dehexchar(str.charAt(i12 + 1));
                int dehexchar2 = JSONTokener.dehexchar(str.charAt(i11));
                if (dehexchar >= 0 && dehexchar2 >= 0) {
                    charAt = (char) ((dehexchar * 16) + dehexchar2);
                    i12 = i11;
                }
            }
            sb2.append(charAt);
            i12++;
        }
        return sb2.toString();
    }
}
