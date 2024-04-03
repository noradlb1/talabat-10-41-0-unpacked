package org.json;

import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class HTTP {
    public static final String CRLF = "\r\n";

    public static JSONObject toJSONObject(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        HTTPTokener hTTPTokener = new HTTPTokener(str);
        String nextToken = hTTPTokener.nextToken();
        if (nextToken.toUpperCase(Locale.ROOT).startsWith("HTTP")) {
            jSONObject.put("HTTP-Version", (Object) nextToken);
            jSONObject.put("Status-Code", (Object) hTTPTokener.nextToken());
            jSONObject.put("Reason-Phrase", (Object) hTTPTokener.nextTo(0));
            hTTPTokener.next();
        } else {
            jSONObject.put("Method", (Object) nextToken);
            jSONObject.put("Request-URI", (Object) hTTPTokener.nextToken());
            jSONObject.put("HTTP-Version", (Object) hTTPTokener.nextToken());
        }
        while (hTTPTokener.more()) {
            String nextTo = hTTPTokener.nextTo((char) AbstractJsonLexerKt.COLON);
            hTTPTokener.next((char) AbstractJsonLexerKt.COLON);
            jSONObject.put(nextTo, (Object) hTTPTokener.nextTo(0));
            hTTPTokener.next();
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        StringBuilder sb2 = new StringBuilder();
        if (jSONObject.has("Status-Code") && jSONObject.has("Reason-Phrase")) {
            sb2.append(jSONObject.getString("HTTP-Version"));
            sb2.append(' ');
            sb2.append(jSONObject.getString("Status-Code"));
            sb2.append(' ');
            sb2.append(jSONObject.getString("Reason-Phrase"));
        } else if (!jSONObject.has("Method") || !jSONObject.has("Request-URI")) {
            throw new JSONException("Not enough material for an HTTP header.");
        } else {
            sb2.append(jSONObject.getString("Method"));
            sb2.append(' ');
            sb2.append('\"');
            sb2.append(jSONObject.getString("Request-URI"));
            sb2.append('\"');
            sb2.append(' ');
            sb2.append(jSONObject.getString("HTTP-Version"));
        }
        sb2.append(CRLF);
        for (String next : jSONObject.keySet()) {
            String optString = jSONObject.optString(next);
            if (!"HTTP-Version".equals(next) && !"Status-Code".equals(next) && !"Reason-Phrase".equals(next) && !"Method".equals(next) && !"Request-URI".equals(next) && !JSONObject.NULL.equals(optString)) {
                sb2.append(next);
                sb2.append(": ");
                sb2.append(jSONObject.optString(next));
                sb2.append(CRLF);
            }
        }
        sb2.append(CRLF);
        return sb2.toString();
    }
}
