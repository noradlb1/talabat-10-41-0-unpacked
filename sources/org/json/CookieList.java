package org.json;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;

public class CookieList {
    public static JSONObject toJSONObject(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONTokener jSONTokener = new JSONTokener(str);
        while (jSONTokener.more()) {
            String unescape = Cookie.unescape(jSONTokener.nextTo((char) SignatureVisitor.INSTANCEOF));
            jSONTokener.next((char) SignatureVisitor.INSTANCEOF);
            jSONObject.put(unescape, (Object) Cookie.unescape(jSONTokener.nextTo((char) TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER)));
            jSONTokener.next();
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = false;
        for (String next : jSONObject.keySet()) {
            Object opt = jSONObject.opt(next);
            if (!JSONObject.NULL.equals(opt)) {
                if (z11) {
                    sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
                }
                sb2.append(Cookie.escape(next));
                sb2.append("=");
                sb2.append(Cookie.escape(opt.toString()));
                z11 = true;
            }
        }
        return sb2.toString();
    }
}
