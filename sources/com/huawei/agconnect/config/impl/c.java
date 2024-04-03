package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class c extends AGConnectServicesConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Context f47485a;

    /* renamed from: b  reason: collision with root package name */
    private final String f47486b;

    /* renamed from: c  reason: collision with root package name */
    private LazyInputStream f47487c;

    /* renamed from: d  reason: collision with root package name */
    private volatile ConfigReader f47488d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f47489e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private AGCRoutePolicy f47490f = AGCRoutePolicy.UNKNOWN;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f47491g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private volatile e f47492h;

    public c(Context context, String str) {
        this.f47485a = context;
        this.f47486b = str;
    }

    private static LazyInputStream a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) {
            public InputStream get(Context context) {
                return inputStream;
            }
        };
    }

    private static String a(String str) {
        int i11 = 0;
        if (str.length() > 0) {
            while (str.charAt(i11) == '/') {
                i11++;
            }
        }
        return '/' + str.substring(i11);
    }

    private void a() {
        if (this.f47488d == null) {
            synchronized (this.f47489e) {
                if (this.f47488d == null) {
                    LazyInputStream lazyInputStream = this.f47487c;
                    if (lazyInputStream != null) {
                        this.f47488d = new i(lazyInputStream.loadInputStream(), "UTF-8");
                        this.f47487c.close();
                        this.f47487c = null;
                    } else {
                        this.f47488d = new m(this.f47485a, this.f47486b);
                    }
                    this.f47492h = new e(this.f47488d);
                }
                b();
            }
        }
    }

    private String b(String str) {
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    private void b() {
        if (this.f47490f != AGCRoutePolicy.UNKNOWN) {
            return;
        }
        if (this.f47488d != null) {
            this.f47490f = Utils.getRoutePolicyFromJson(this.f47488d.getString("/region", (String) null), this.f47488d.getString("/agcgw/url", (String) null));
        } else {
            Log.w("AGConnectServiceConfig", "get route fail , config not ready");
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z11) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z11)));
    }

    public Context getContext() {
        return this.f47485a;
    }

    public String getIdentifier() {
        return Utils.DEFAULT_NAME;
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
        return this.f47486b;
    }

    public AGCRoutePolicy getRoutePolicy() {
        if (this.f47490f == null) {
            this.f47490f = AGCRoutePolicy.UNKNOWN;
        }
        AGCRoutePolicy aGCRoutePolicy = this.f47490f;
        AGCRoutePolicy aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy == aGCRoutePolicy2 && this.f47488d == null) {
            a();
        }
        AGCRoutePolicy aGCRoutePolicy3 = this.f47490f;
        return aGCRoutePolicy3 == null ? aGCRoutePolicy2 : aGCRoutePolicy3;
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        if (str != null) {
            if (this.f47488d == null) {
                a();
            }
            String a11 = a(str);
            String str3 = this.f47491g.get(a11);
            if (str3 != null) {
                return str3;
            }
            String b11 = b(a11);
            if (b11 != null) {
                return b11;
            }
            String string = this.f47488d.getString(a11, str2);
            return e.a(string) ? this.f47492h.decrypt(string, str2) : string;
        }
        throw new NullPointerException("path must not be null.");
    }

    public void overlayWith(LazyInputStream lazyInputStream) {
        this.f47487c = lazyInputStream;
    }

    public void overlayWith(InputStream inputStream) {
        overlayWith(a(this.f47485a, inputStream));
    }

    public void setParam(String str, String str2) {
        this.f47491g.put(Utils.fixPath(str), str2);
    }

    public void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.f47490f = aGCRoutePolicy;
    }
}
