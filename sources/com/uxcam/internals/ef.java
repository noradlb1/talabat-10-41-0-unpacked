package com.uxcam.internals;

import com.checkout.logging.utils.LoggingAttributesKt;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Pair;
import okhttp3.Headers;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ef {

    /* renamed from: a  reason: collision with root package name */
    public final eg f13268a;

    /* renamed from: b  reason: collision with root package name */
    public final aa f13269b;

    public static class aa {

        /* renamed from: a  reason: collision with root package name */
        public final List f13270a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final List f13271b;

        /* renamed from: com.uxcam.internals.ef$aa$aa  reason: collision with other inner class name */
        public static class C0001aa {

            /* renamed from: a  reason: collision with root package name */
            public final List f13272a = new ArrayList();

            /* renamed from: b  reason: collision with root package name */
            public final List f13273b = new ArrayList();
        }

        public aa(List list, List list2) {
            this.f13271b = list2;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f13270a.add(Pattern.compile((String) it.next(), 2));
            }
        }
    }

    public static class ab {
    }

    public ef(eg egVar, aa aaVar) {
        this.f13268a = egVar;
        this.f13269b = aaVar;
    }

    public final JSONObject a(Request request) {
        String host = request.url().url().getHost();
        Iterator it = this.f13269b.f13271b.iterator();
        if (!it.hasNext()) {
            String method = request.method();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL, (Object) "");
                jSONObject.put(AnalyticsAttribute.REQUEST_URL_ATTRIBUTE, (Object) host);
                jSONObject.put("httpVerb", (Object) method);
                jSONObject.put(LoggingAttributesKt.HTTP_STATUS_CODE, (Object) "-1");
                jSONObject.put("callDurationMs", -1);
                jSONObject.put("responseSizeBytes", -1);
                jSONObject.put("sentRequestAt", -1);
                jSONObject.put("receivedResponseAt", -1);
                jSONObject.put("requestHeaders", (Object) a(request.headers()));
                jSONObject.put("throwableMessage", (Object) "");
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }
        ((ab) it.next()).getClass();
        throw null;
    }

    public final JSONArray a(Headers headers) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Pair<String, String>> it = headers.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            JSONObject jSONObject = new JSONObject();
            Locale locale = Locale.ENGLISH;
            String lowerCase = ((String) next.getFirst()).toLowerCase(locale);
            String lowerCase2 = ((String) next.getSecond()).toLowerCase(locale);
            try {
                jSONObject.put("key", (Object) lowerCase);
                jSONObject.put("value", (Object) lowerCase2);
            } catch (JSONException unused) {
            }
            boolean z11 = false;
            for (Pattern pattern : this.f13269b.f13270a) {
                boolean find = pattern.matcher(lowerCase).find(0);
                pattern.toString();
                z11 = find;
            }
            if (!z11) {
                jSONArray.put((Object) jSONObject);
            }
        }
        return jSONArray;
    }
}
