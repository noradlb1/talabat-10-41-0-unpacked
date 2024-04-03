package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.e.c;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class a {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f48819e = "a";

    /* renamed from: a  reason: collision with root package name */
    private final GrsBaseInfo f48820a;

    /* renamed from: b  reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f48821b;

    /* renamed from: c  reason: collision with root package name */
    private g f48822c;

    /* renamed from: d  reason: collision with root package name */
    private c f48823d;

    @Instrumented
    /* renamed from: com.huawei.hms.framework.network.grs.a$a  reason: collision with other inner class name */
    public static class C0068a implements b {

        /* renamed from: a  reason: collision with root package name */
        String f48824a;

        /* renamed from: b  reason: collision with root package name */
        Map<String, String> f48825b;

        /* renamed from: c  reason: collision with root package name */
        IQueryUrlsCallBack f48826c;

        /* renamed from: d  reason: collision with root package name */
        Context f48827d;

        /* renamed from: e  reason: collision with root package name */
        GrsBaseInfo f48828e;

        /* renamed from: f  reason: collision with root package name */
        com.huawei.hms.framework.network.grs.e.a f48829f;

        public C0068a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f48824a = str;
            this.f48825b = map;
            this.f48826c = iQueryUrlsCallBack;
            this.f48827d = context;
            this.f48828e = grsBaseInfo;
            this.f48829f = aVar;
        }

        public void a() {
            Map<String, String> map = this.f48825b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f48824a, StringUtils.anonymizeMessage(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) this.f48825b))));
                this.f48826c.onCallBackSuccess(this.f48825b);
            } else if (this.f48825b == null) {
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                Map a11 = com.huawei.hms.framework.network.grs.f.b.a(this.f48827d.getPackageName()).a(this.f48827d, this.f48829f, this.f48828e, this.f48824a, true);
                if (a11 == null || a11.isEmpty()) {
                    Logger.e(a.f48819e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f48824a);
                }
                if (a11 == null) {
                    a11 = new ConcurrentHashMap();
                }
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f48824a, StringUtils.anonymizeMessage(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) a11))));
                this.f48826c.onCallBackSuccess(a11);
            } else {
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f48824a);
                this.f48826c.onCallBackFail(-3);
            }
        }

        public void a(d dVar) {
            IQueryUrlsCallBack iQueryUrlsCallBack;
            String j11 = dVar.j();
            Map<String, String> a11 = a.a(j11, this.f48824a);
            if (!a11.isEmpty()) {
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.f48824a, StringUtils.anonymizeMessage(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) a11))));
                iQueryUrlsCallBack = this.f48826c;
            } else {
                Map<String, String> map = this.f48825b;
                if (map != null && !map.isEmpty()) {
                    Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.f48824a, StringUtils.anonymizeMessage(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) this.f48825b))));
                    iQueryUrlsCallBack = this.f48826c;
                    a11 = this.f48825b;
                } else if (this.f48825b == null) {
                    if (!TextUtils.isEmpty(j11)) {
                        Logger.e(a.f48819e, "The serviceName[%s] is not configured on the GRS server.", this.f48824a);
                    }
                    Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                    Map a12 = com.huawei.hms.framework.network.grs.f.b.a(this.f48827d.getPackageName()).a(this.f48827d, this.f48829f, this.f48828e, this.f48824a, true);
                    if (a12 == null || a12.isEmpty()) {
                        Logger.e(a.f48819e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f48824a);
                    }
                    if (a12 == null) {
                        a12 = new ConcurrentHashMap();
                    }
                    Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f48824a, StringUtils.anonymizeMessage(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) a12))));
                    this.f48826c.onCallBackSuccess(a12);
                    return;
                } else {
                    Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f48824a);
                    this.f48826c.onCallBackFail(-5);
                    return;
                }
            }
            iQueryUrlsCallBack.onCallBackSuccess(a11);
        }
    }

    public static class b implements b {

        /* renamed from: a  reason: collision with root package name */
        String f48830a;

        /* renamed from: b  reason: collision with root package name */
        String f48831b;

        /* renamed from: c  reason: collision with root package name */
        IQueryUrlCallBack f48832c;

        /* renamed from: d  reason: collision with root package name */
        String f48833d;

        /* renamed from: e  reason: collision with root package name */
        Context f48834e;

        /* renamed from: f  reason: collision with root package name */
        GrsBaseInfo f48835f;

        /* renamed from: g  reason: collision with root package name */
        com.huawei.hms.framework.network.grs.e.a f48836g;

        public b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f48830a = str;
            this.f48831b = str2;
            this.f48832c = iQueryUrlCallBack;
            this.f48833d = str3;
            this.f48834e = context;
            this.f48835f = grsBaseInfo;
            this.f48836g = aVar;
        }

        public void a() {
            if (!TextUtils.isEmpty(this.f48833d)) {
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f48830a, this.f48831b, StringUtils.anonymizeMessage(this.f48833d));
                this.f48832c.onCallBackSuccess(this.f48833d);
            } else if (TextUtils.isEmpty(this.f48833d)) {
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                String a11 = com.huawei.hms.framework.network.grs.f.b.a(this.f48834e.getPackageName()).a(this.f48834e, this.f48836g, this.f48835f, this.f48830a, this.f48831b, true);
                if (a11 == null || a11.isEmpty()) {
                    Logger.e(a.f48819e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f48830a, this.f48831b);
                }
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f48830a, this.f48831b, StringUtils.anonymizeMessage(a11));
                this.f48832c.onCallBackSuccess(a11);
            } else {
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f48830a, this.f48831b);
                this.f48832c.onCallBackFail(-3);
            }
        }

        public void a(d dVar) {
            IQueryUrlCallBack iQueryUrlCallBack;
            String str;
            String j11 = dVar.j();
            Map<String, String> a11 = a.a(j11, this.f48830a);
            if (a11.containsKey(this.f48831b)) {
                String a12 = a.f48819e;
                String str2 = this.f48831b;
                Logger.i(a12, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", this.f48830a, str2, StringUtils.anonymizeMessage(a11.get(str2)));
                iQueryUrlCallBack = this.f48832c;
                str = a11.get(this.f48831b);
            } else if (!TextUtils.isEmpty(this.f48833d)) {
                String a13 = a.f48819e;
                String str3 = this.f48831b;
                Logger.i(a13, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f48830a, str3, StringUtils.anonymizeMessage(a11.get(str3)));
                iQueryUrlCallBack = this.f48832c;
                str = this.f48833d;
            } else if (TextUtils.isEmpty(this.f48833d)) {
                if (!TextUtils.isEmpty(j11)) {
                    Logger.e(a.f48819e, "The serviceName[%s][%s] is not configured on the GRS server.", this.f48830a, this.f48831b);
                }
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                String a14 = com.huawei.hms.framework.network.grs.f.b.a(this.f48834e.getPackageName()).a(this.f48834e, this.f48836g, this.f48835f, this.f48830a, this.f48831b, true);
                if (a14 == null || a14.isEmpty()) {
                    Logger.e(a.f48819e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f48830a, this.f48831b);
                }
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f48830a, this.f48831b, StringUtils.anonymizeMessage(a14));
                this.f48832c.onCallBackSuccess(a14);
                return;
            } else {
                Logger.i(a.f48819e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f48830a, this.f48831b);
                this.f48832c.onCallBackFail(-5);
                return;
            }
            iQueryUrlCallBack.onCallBackSuccess(str);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, g gVar, c cVar) {
        this.f48820a = grsBaseInfo;
        this.f48821b = aVar;
        this.f48822c = gVar;
        this.f48823d = cVar;
    }

    public static CountryCodeBean a(Context context, boolean z11) {
        return new CountryCodeBean(context, z11);
    }

    public static Map<String, Map<String, String>> a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(f48819e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e11) {
            Logger.w(f48819e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return concurrentHashMap;
        }
    }

    private Map<String, String> a(String str, com.huawei.hms.framework.network.grs.e.b bVar, Context context) {
        Map<String, String> a11 = this.f48821b.a(this.f48820a, str, bVar, context);
        if (a11 == null || a11.isEmpty()) {
            Map<String, String> a12 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f48821b, this.f48820a, str, false);
            Logger.i(f48819e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
            return a12 != null ? a12 : new HashMap();
        }
        Logger.i(f48819e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
        return a11;
    }

    public static Map<String, String> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.w(f48819e, "isSpExpire jsonValue from server is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.w(f48819e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return hashMap;
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.get(next).toString());
            }
            return hashMap;
        } catch (JSONException e11) {
            Logger.w(f48819e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return hashMap;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String obj = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(obj)) {
                    concurrentHashMap.put(next, obj);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e11) {
            Logger.w(f48819e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return concurrentHashMap;
        }
    }

    public String a(Context context, String str, int i11) {
        d a11 = this.f48822c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f48820a, context), str, this.f48823d, i11);
        return a11 == null ? "" : a11.m() ? this.f48821b.a().a(this.f48820a.getGrsParasKey(true, true, context), "") : a11.j();
    }

    public String a(String str, String str2, Context context, int i11) {
        String str3 = str;
        String str4 = str2;
        Context context2 = context;
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str5 = a(str3, bVar, context2).get(str4);
        if (!bVar.a() || TextUtils.isEmpty(str5)) {
            String a11 = a(context2, str3, i11);
            String str6 = a(a11, str3).get(str4);
            if (!TextUtils.isEmpty(str6)) {
                Logger.i(f48819e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str3, str4, StringUtils.anonymizeMessage(str6));
                return str6;
            }
            if (TextUtils.isEmpty(str5)) {
                if (!TextUtils.isEmpty(a11)) {
                    Logger.e(f48819e, "The serviceName[%s][%s] is not configured on the GRS server.", str3, str4);
                }
                String str7 = f48819e;
                Logger.i(str7, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
                str5 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f48821b, this.f48820a, str, str2, true);
                if (str5 == null || str5.isEmpty()) {
                    Logger.e(str7, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", str3, str4);
                }
            }
            Logger.i(f48819e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str3, str4, StringUtils.anonymizeMessage(str5));
            return str5;
        }
        Logger.i(f48819e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str3, str4, StringUtils.anonymizeMessage(str5));
        return str5;
    }

    public Map<String, String> a(String str, Context context, int i11) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> a11 = a(str, bVar, context);
        if (!bVar.a() || a11.isEmpty()) {
            String a12 = a(context, str, i11);
            Map<String, String> a13 = a(a12, str);
            if (!a13.isEmpty()) {
                Logger.i(f48819e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) a13))));
                return a13;
            }
            if (a11.isEmpty()) {
                if (!TextUtils.isEmpty(a12)) {
                    Logger.e(f48819e, "The serviceName[%s] is not configured on the GRS server.", str);
                }
                String str2 = f48819e;
                Logger.i(str2, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
                a11 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f48821b, this.f48820a, str, true);
                if (a11 == null || a11.isEmpty()) {
                    Logger.e(str2, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", str);
                }
            }
            String str3 = f48819e;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = StringUtils.anonymizeMessage(a11 != null ? JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) a11)) : "");
            Logger.i(str3, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", objArr);
            return a11;
        }
        Logger.i(f48819e, "Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) a11))));
        return a11;
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, int i11) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> a11 = a(str, bVar, context);
        if (!bVar.a()) {
            com.huawei.hms.framework.network.grs.g.j.c cVar = new com.huawei.hms.framework.network.grs.g.j.c(this.f48820a, context);
            this.f48822c.a(cVar, new C0068a(str, a11, iQueryUrlsCallBack, context, this.f48820a, this.f48821b), str, this.f48823d, i11);
        } else if (a11.isEmpty()) {
            Logger.i(f48819e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            String str2 = f48819e;
            Logger.i(str2, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) a11))));
            Logger.i(str2, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) a11))));
            iQueryUrlsCallBack.onCallBackSuccess(a11);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context, int i11) {
        String str3 = str;
        String str4 = str2;
        IQueryUrlCallBack iQueryUrlCallBack2 = iQueryUrlCallBack;
        Context context2 = context;
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str5 = a(str, bVar, context2).get(str2);
        if (!bVar.a()) {
            com.huawei.hms.framework.network.grs.g.j.c cVar = new com.huawei.hms.framework.network.grs.g.j.c(this.f48820a, context2);
            g gVar = this.f48822c;
            b bVar2 = new b(str, str2, iQueryUrlCallBack, str5, context, this.f48820a, this.f48821b);
            gVar.a(cVar, bVar2, str, this.f48823d, i11);
        } else if (TextUtils.isEmpty(str5)) {
            Logger.i(f48819e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", str3, str4);
            iQueryUrlCallBack2.onCallBackFail(-5);
        } else {
            Logger.i(f48819e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url: %s", str3, str4, StringUtils.anonymizeMessage(str5));
            iQueryUrlCallBack2.onCallBackSuccess(str5);
        }
    }
}
