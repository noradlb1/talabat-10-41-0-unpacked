package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.core.Service;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

@Instrumented
public class b implements AGConnectOptions {

    /* renamed from: a  reason: collision with root package name */
    private final String f47476a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f47477b;

    /* renamed from: c  reason: collision with root package name */
    private final String f47478c;

    /* renamed from: d  reason: collision with root package name */
    private final AGCRoutePolicy f47479d;

    /* renamed from: e  reason: collision with root package name */
    private final ConfigReader f47480e;

    /* renamed from: f  reason: collision with root package name */
    private final e f47481f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f47482g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Service> f47483h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, String> f47484i = new HashMap();

    public b(Context context, String str, AGCRoutePolicy aGCRoutePolicy, InputStream inputStream, Map<String, String> map, List<Service> list, String str2) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f47477b = context;
        str = str == null ? context.getPackageName() : str;
        this.f47478c = str;
        if (inputStream != null) {
            this.f47480e = new i(inputStream, str);
            Utils.closeQuietly(inputStream);
        } else {
            this.f47480e = new m(context, str);
        }
        this.f47481f = new e(this.f47480e);
        AGCRoutePolicy aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy == aGCRoutePolicy2 || !"1.0".equals(this.f47480e.getString("/configuration_version", (String) null))) {
            this.f47479d = (aGCRoutePolicy == null || aGCRoutePolicy == aGCRoutePolicy2) ? Utils.getRoutePolicyFromJson(this.f47480e.getString("/region", (String) null), this.f47480e.getString("/agcgw/url", (String) null)) : aGCRoutePolicy;
            this.f47482g = Utils.fixKeyPathMap(map);
            this.f47483h = list;
            this.f47476a = str2 == null ? b() : str2;
            return;
        }
        throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
    }

    private String a(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (!processors.containsKey(str)) {
            return null;
        }
        if (this.f47484i.containsKey(str)) {
            return this.f47484i.get(str);
        }
        JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
        if (jsonProcessor == null) {
            return null;
        }
        String processOption = jsonProcessor.processOption(this);
        this.f47484i.put(str, processOption);
        return processOption;
    }

    private String b() {
        return String.valueOf(("{packageName='" + this.f47478c + '\'' + ", routePolicy=" + this.f47479d + ", reader=" + this.f47480e.toString().hashCode() + ", customConfigMap=" + JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) this.f47482g)).hashCode() + AbstractJsonLexerKt.END_OBJ).hashCode());
    }

    public List<Service> a() {
        return this.f47483h;
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z11) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z11)));
    }

    public Context getContext() {
        return this.f47477b;
    }

    public String getIdentifier() {
        return this.f47476a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i11) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i11)));
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    public String getPackageName() {
        return this.f47478c;
    }

    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy aGCRoutePolicy = this.f47479d;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String fixPath = Utils.fixPath(str);
        String str3 = this.f47482g.get(fixPath);
        if (str3 != null) {
            return str3;
        }
        String a11 = a(fixPath);
        if (a11 != null) {
            return a11;
        }
        String string = this.f47480e.getString(fixPath, str2);
        return e.a(string) ? this.f47481f.decrypt(string, str2) : string;
    }
}
