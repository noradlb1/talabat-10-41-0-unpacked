package com.huawei.hms.dtm.core;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class X implements K {

    /* renamed from: a  reason: collision with root package name */
    private X f48434a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, C0435sc<?>> f48435b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f48436c;

    /* renamed from: d  reason: collision with root package name */
    private K f48437d;

    /* renamed from: e  reason: collision with root package name */
    private Context f48438e;

    public X(K k11) {
        this.f48437d = k11;
    }

    private X(X x11) {
        this.f48437d = x11.f48437d;
        this.f48434a = x11;
        this.f48435b = null;
    }

    public final X a() {
        return new X(this);
    }

    public X a(Context context) {
        this.f48438e = context;
        return this;
    }

    public X a(Bundle bundle) {
        this.f48436c = bundle;
        return this;
    }

    public final X a(String str, C0435sc<?> scVar) {
        if (this.f48435b == null) {
            this.f48435b = new HashMap();
        }
        this.f48435b.put(str, scVar);
        return this;
    }

    public final C0435sc<?> a(String str) {
        X x11 = this;
        do {
            Map<String, C0435sc<?>> map = x11.f48435b;
            if (map != null && map.containsKey(str)) {
                return x11.f48435b.get(str);
            }
            x11 = x11.f48434a;
        } while (x11 != null);
        return C0470zc.f48641a;
    }

    public Bundle b() {
        for (X x11 = this; x11 != null; x11 = x11.f48434a) {
            Bundle bundle = x11.f48436c;
            if (bundle != null) {
                return bundle;
            }
        }
        return null;
    }

    public final void b(String str, C0435sc<?> scVar) {
        X x11 = this;
        do {
            Map<String, C0435sc<?>> map = x11.f48435b;
            if (map == null || !map.containsKey(str)) {
                x11 = x11.f48434a;
            } else {
                x11.f48435b.put(str, scVar);
                return;
            }
        } while (x11 != null);
    }

    public final boolean b(String str) {
        X x11 = this;
        do {
            Map<String, C0435sc<?>> map = x11.f48435b;
            if (map != null && map.containsKey(str)) {
                return true;
            }
            x11 = x11.f48434a;
        } while (x11 != null);
        return false;
    }

    public Context c() {
        for (X x11 = this; x11 != null; x11 = x11.f48434a) {
            Context context = x11.f48438e;
            if (context != null) {
                return context;
            }
        }
        return null;
    }

    public String getConfigurationID() {
        return this.f48437d.getConfigurationID();
    }

    public Executor getCoreExecutor() {
        return this.f48437d.getCoreExecutor();
    }

    public String getResourceVersion() {
        return this.f48437d.getResourceVersion();
    }

    public String getUserProfile(String str) {
        return this.f48437d.getUserProfile(str);
    }

    public boolean isReportToHwAnalytics() {
        return this.f48437d.isReportToHwAnalytics();
    }

    public void onEventExecuted(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f48437d.onEventExecuted(str, bundle);
            return;
        }
        throw new V("eventName is empty.");
    }
}
