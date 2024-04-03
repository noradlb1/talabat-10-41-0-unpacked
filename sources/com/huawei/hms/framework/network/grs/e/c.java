package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

public class c {

    /* renamed from: b  reason: collision with root package name */
    private static final String f48860b = "c";

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, PLSharedPreferences> f48861c = new ConcurrentHashMap(16);

    /* renamed from: a  reason: collision with root package name */
    private final PLSharedPreferences f48862a;

    public c(Context context, String str) {
        String packageName = context.getPackageName();
        Logger.d(f48860b, "get pkgname from context is{%s}", packageName);
        Map<String, PLSharedPreferences> map = f48861c;
        if (map.containsKey(str + packageName)) {
            this.f48862a = map.get(str + packageName);
        } else {
            PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(context, str + packageName);
            this.f48862a = pLSharedPreferences;
            map.put(str + packageName, pLSharedPreferences);
        }
        a(context);
    }

    private void a(Context context) {
        String str = f48860b;
        Logger.i(str, "ContextHolder.getAppContext() from GRS is:" + ContextHolder.getAppContext());
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            String l11 = Long.toString((long) context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
            String a11 = a("version", "");
            if (!l11.equals(a11)) {
                Logger.i(str, "app version changed! old version{%s} and new version{%s}", a11, l11);
                b();
                b("version", l11);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.w(f48860b, "get app version failed and catch NameNotFoundException");
        }
    }

    public String a(String str, String str2) {
        String string;
        PLSharedPreferences pLSharedPreferences = this.f48862a;
        if (pLSharedPreferences == null) {
            return str2;
        }
        synchronized (pLSharedPreferences) {
            string = this.f48862a.getString(str, str2);
        }
        return string;
    }

    public Map<String, ?> a() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.f48862a;
        if (pLSharedPreferences == null) {
            return new HashMap();
        }
        synchronized (pLSharedPreferences) {
            all = this.f48862a.getAll();
        }
        return all;
    }

    public void a(String str) {
        PLSharedPreferences pLSharedPreferences = this.f48862a;
        if (pLSharedPreferences != null) {
            synchronized (pLSharedPreferences) {
                this.f48862a.remove(str);
            }
        }
    }

    public void b() {
        PLSharedPreferences pLSharedPreferences = this.f48862a;
        if (pLSharedPreferences != null) {
            synchronized (pLSharedPreferences) {
                this.f48862a.clear();
            }
        }
    }

    public void b(String str, String str2) {
        PLSharedPreferences pLSharedPreferences = this.f48862a;
        if (pLSharedPreferences != null) {
            synchronized (pLSharedPreferences) {
                this.f48862a.putString(str, str2);
            }
        }
    }
}
