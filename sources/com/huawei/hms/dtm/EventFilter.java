package com.huawei.hms.dtm;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public final class EventFilter implements C0341c {

    /* renamed from: a  reason: collision with root package name */
    public final l f48247a = l.a();

    /* renamed from: b  reason: collision with root package name */
    public Context f48248b;

    /* renamed from: c  reason: collision with root package name */
    public Object f48249c;

    /* renamed from: d  reason: collision with root package name */
    public Method f48250d;

    /* renamed from: e  reason: collision with root package name */
    public Method f48251e;

    public String getUserProfile(String str) {
        String str2;
        B.a("HMS-DTM", "get user property from HA#" + str);
        Object obj = this.f48249c;
        if (obj == null || this.f48251e == null) {
            B.d("HMS-DTM", "no handler or event");
            return null;
        }
        try {
            Object invoke = this.f48250d.invoke(obj, new Object[]{str});
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (IllegalAccessException unused) {
            str2 = "IllegalAccessException";
            B.b("HMS-DTM", str2);
            return null;
        } catch (InvocationTargetException unused2) {
            str2 = "InvocationTargetException";
            B.b("HMS-DTM", str2);
            return null;
        }
        return null;
    }

    public void initialize(Context context) {
        initialize(context, (Map<Object, Object>) null);
    }

    public void initialize(Context context, Map<Object, Object> map) {
        if (context == null) {
            B.b("HMS-DTM", "initialize dtm api#context is null");
            return;
        }
        this.f48248b = context;
        B.c("HMS-DTM", "initialize dtm api" + System.lineSeparator() + "--------------------------------------" + System.lineSeparator() + "------  Version Name " + "6.6.0.302" + "  ------" + System.lineSeparator() + "--------------------------------------");
        this.f48247a.a(context, map);
        this.f48247a.a((C0472d) new C0340b(this));
    }

    public void logAutoEvent(String str, Bundle bundle) {
        this.f48247a.logAutoEvent(str, bundle);
    }

    public boolean logEvent(String str, Bundle bundle) {
        if (str == null || !str.startsWith("$HA_")) {
            this.f48247a.logEvent(str, bundle);
            return true;
        }
        logAutoEvent(str, bundle);
        return false;
    }

    public void logFilteredEvent(String str, Bundle bundle) {
        String str2;
        B.a("HMS-DTM", "log filtered event to HA#" + str);
        if (this.f48249c == null || this.f48251e == null) {
            B.d("HMS-DTM", "no handler or event");
            return;
        }
        C0339a.a(this.f48248b, bundle);
        try {
            this.f48251e.invoke(this.f48249c, new Object[]{str, bundle});
            return;
        } catch (IllegalAccessException unused) {
            str2 = "IllegalAccessException";
        } catch (InvocationTargetException unused2) {
            str2 = "InvocationTargetException";
        }
        B.b("HMS-DTM", str2);
    }

    public void setLogCallback(Object obj) {
        Class<String> cls = String.class;
        B.a("HMS-DTM", "set log handler to dtm");
        this.f48249c = obj;
        Class<?> cls2 = obj.getClass();
        try {
            this.f48250d = cls2.getDeclaredMethod("getUserProfile", new Class[]{cls});
            this.f48251e = cls2.getDeclaredMethod("logFilteredEvent", new Class[]{cls, Bundle.class});
        } catch (NoSuchMethodException e11) {
            B.b("HMS-DTM", "NoSuchMethodException#" + e11.toString());
        }
    }

    public void setParameter(Map<Object, Object> map) {
        B.a("HMS-DTM", "set parameter from HA");
        this.f48247a.setParameter(map);
    }
}
