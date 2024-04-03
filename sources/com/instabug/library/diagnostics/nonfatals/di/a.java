package com.instabug.library.diagnostics.nonfatals.di;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.diagnostics_db.m;
import com.instabug.library.diagnostics.nonfatals.cache.NonFatalCacheManager;
import com.instabug.library.diagnostics.nonfatals.cache.c;
import com.instabug.library.diagnostics.nonfatals.e;
import com.instabug.library.diagnostics.nonfatals.f;
import com.instabug.library.diagnostics.nonfatals.networking.mapping.b;
import com.instabug.library.internal.resolver.d;
import com.instabug.library.util.threading.PoolProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f34299a = new HashMap();

    @Nullable
    private static Object a(@NonNull String str) {
        Map map = f34299a;
        if (!map.containsKey(str) || map.get(str) == null || ((WeakReference) map.get(str)).get() == null) {
            return null;
        }
        return ((WeakReference) map.get(str)).get();
    }

    public static synchronized m b() {
        m c11;
        synchronized (a.class) {
            c11 = m.c();
        }
        return c11;
    }

    @Nullable
    public static synchronized NonFatalCacheManager c() {
        NonFatalCacheManager nonFatalCacheManager;
        synchronized (a.class) {
            Object a11 = a("NonFatalCacheManager");
            if (a11 == null && d.a().b() != null) {
                a11 = new com.instabug.library.diagnostics.nonfatals.cache.a(f(), j(), d.a().b());
                f34299a.put("NonFatalCacheManager", new WeakReference(a11));
            }
            nonFatalCacheManager = (NonFatalCacheManager) a11;
        }
        return nonFatalCacheManager;
    }

    public static synchronized com.instabug.library.diagnostics.nonfatals.networking.mapping.a d() {
        com.instabug.library.diagnostics.nonfatals.networking.mapping.a aVar;
        synchronized (a.class) {
            Object a11 = a("NonFatalMapper");
            if (a11 == null) {
                a11 = new b();
                f34299a.put("NonFatalMapper", new WeakReference(a11));
            }
            aVar = (com.instabug.library.diagnostics.nonfatals.networking.mapping.a) a11;
        }
        return aVar;
    }

    public static synchronized com.instabug.library.diagnostics.configuration.a e() {
        com.instabug.library.diagnostics.configuration.a aVar;
        synchronized (a.class) {
            Object a11 = a("ConfigurationHandler");
            if (a11 == null) {
                a11 = new com.instabug.library.diagnostics.nonfatals.d();
                f34299a.put("ConfigurationHandler", new WeakReference(a11));
            }
            aVar = (com.instabug.library.diagnostics.configuration.a) a11;
        }
        return aVar;
    }

    public static synchronized com.instabug.library.diagnostics.nonfatals.cache.b f() {
        com.instabug.library.diagnostics.nonfatals.cache.b bVar;
        synchronized (a.class) {
            Object a11 = a("NonFatalsDBHelper");
            if (a11 == null) {
                a11 = new c();
                f34299a.put("NonFatalsDBHelper", new WeakReference(a11));
            }
            bVar = (com.instabug.library.diagnostics.nonfatals.cache.b) a11;
        }
        return bVar;
    }

    @Nullable
    public static synchronized e g() {
        e eVar;
        synchronized (a.class) {
            Object a11 = a("NonFatalsManager");
            if (!(a11 != null || d.a().b() == null || c() == null)) {
                a11 = new f(c(), d.a().b());
                f34299a.put("NonFatalsManager", new WeakReference(a11));
            }
            eVar = (e) a11;
        }
        return eVar;
    }

    public static synchronized com.instabug.library.diagnostics.mappers.a h() {
        com.instabug.library.diagnostics.nonfatals.networking.mapping.c cVar;
        synchronized (a.class) {
            Object a11 = a("NonFatalsRequestParamMapper");
            if (a11 == null) {
                a11 = new com.instabug.library.diagnostics.nonfatals.networking.mapping.c();
                f34299a.put("NonFatalsRequestParamMapper", new WeakReference(a11));
            }
            cVar = (com.instabug.library.diagnostics.nonfatals.networking.mapping.c) a11;
        }
        return cVar;
    }

    public static synchronized Executor i() {
        Executor singleThreadExecutor;
        synchronized (a.class) {
            singleThreadExecutor = PoolProvider.getSingleThreadExecutor("ibg-non-fatal-executor");
        }
        return singleThreadExecutor;
    }

    public static synchronized com.instabug.library.diagnostics.nonfatals.cache.d j() {
        com.instabug.library.diagnostics.nonfatals.cache.d dVar;
        synchronized (a.class) {
            Object a11 = a("OccurrencesDBHelper");
            if (a11 == null) {
                a11 = new com.instabug.library.diagnostics.nonfatals.cache.e();
                f34299a.put("OccurrencesDBHelper", new WeakReference(a11));
            }
            dVar = (com.instabug.library.diagnostics.nonfatals.cache.d) a11;
        }
        return dVar;
    }

    @Nullable
    public static synchronized Context a() {
        Context applicationContext;
        synchronized (a.class) {
            applicationContext = Instabug.getApplicationContext();
        }
        return applicationContext;
    }
}
