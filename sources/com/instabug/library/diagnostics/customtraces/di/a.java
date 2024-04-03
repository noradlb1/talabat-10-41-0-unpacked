package com.instabug.library.diagnostics.customtraces.di;

import com.instabug.library.diagnostics.customtraces.b;
import com.instabug.library.diagnostics.customtraces.cache.CustomTracesCacheManager;
import com.instabug.library.diagnostics.customtraces.cache.c;
import com.instabug.library.diagnostics.customtraces.cache.d;
import com.instabug.library.diagnostics.customtraces.cache.e;
import com.instabug.library.util.threading.PoolProvider;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f34228a = new a();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Map f34229b = new LinkedHashMap();

    private a() {
    }

    @JvmStatic
    @NotNull
    public static final synchronized com.instabug.library.diagnostics.customtraces.a d() {
        Object obj;
        com.instabug.library.diagnostics.customtraces.a aVar;
        synchronized (a.class) {
            Map map = f34229b;
            WeakReference weakReference = (WeakReference) map.get("TracesManager");
            if (weakReference == null) {
                obj = null;
            } else {
                obj = weakReference.get();
            }
            if (!(obj instanceof com.instabug.library.diagnostics.customtraces.a)) {
                obj = null;
            }
            aVar = (com.instabug.library.diagnostics.customtraces.a) obj;
            if (aVar == null) {
                aVar = new b((CustomTracesCacheManager) null, (ThreadPoolExecutor) null, 3, (DefaultConstructorMarker) null);
                map.put("TracesManager", new WeakReference(aVar));
            }
        }
        return aVar;
    }

    @NotNull
    public final synchronized com.instabug.library.diagnostics.customtraces.cache.a a() {
        Object obj;
        com.instabug.library.diagnostics.customtraces.cache.a aVar;
        Map map = f34229b;
        WeakReference weakReference = (WeakReference) map.get("AttributesDBHelper");
        Object obj2 = null;
        if (weakReference == null) {
            obj = null;
        } else {
            obj = weakReference.get();
        }
        if (obj instanceof com.instabug.library.diagnostics.customtraces.cache.a) {
            obj2 = obj;
        }
        aVar = (com.instabug.library.diagnostics.customtraces.cache.a) obj2;
        if (aVar == null) {
            aVar = new com.instabug.library.diagnostics.customtraces.cache.b();
            map.put("AttributesDBHelper", new WeakReference(aVar));
        }
        return aVar;
    }

    @NotNull
    public final synchronized CustomTracesCacheManager b() {
        Object obj;
        CustomTracesCacheManager customTracesCacheManager;
        Map map = f34229b;
        WeakReference weakReference = (WeakReference) map.get("CacheManager");
        if (weakReference == null) {
            obj = null;
        } else {
            obj = weakReference.get();
        }
        if (!(obj instanceof CustomTracesCacheManager)) {
            obj = null;
        }
        customTracesCacheManager = (CustomTracesCacheManager) obj;
        if (customTracesCacheManager == null) {
            customTracesCacheManager = new c((d) null, (com.instabug.library.diagnostics.customtraces.cache.a) null, 3, (DefaultConstructorMarker) null);
            map.put("CacheManager", new WeakReference(customTracesCacheManager));
        }
        return customTracesCacheManager;
    }

    @NotNull
    public final synchronized ThreadPoolExecutor c() {
        ThreadPoolExecutor iOExecutor;
        iOExecutor = PoolProvider.getInstance().getIOExecutor();
        Intrinsics.checkNotNullExpressionValue(iOExecutor, "getInstance().ioExecutor");
        return iOExecutor;
    }

    @NotNull
    public final synchronized com.instabug.library.diagnostics.customtraces.network.a e() {
        Object obj;
        com.instabug.library.diagnostics.customtraces.network.a aVar;
        Map map = f34229b;
        WeakReference weakReference = (WeakReference) map.get("TracesMapper");
        Object obj2 = null;
        if (weakReference == null) {
            obj = null;
        } else {
            obj = weakReference.get();
        }
        if (obj instanceof com.instabug.library.diagnostics.customtraces.network.a) {
            obj2 = obj;
        }
        aVar = (com.instabug.library.diagnostics.customtraces.network.a) obj2;
        if (aVar == null) {
            aVar = new com.instabug.library.diagnostics.customtraces.network.b();
            map.put("TracesMapper", new WeakReference(aVar));
        }
        return aVar;
    }

    @NotNull
    public final synchronized com.instabug.library.diagnostics.mappers.a f() {
        Object obj;
        com.instabug.library.diagnostics.customtraces.network.c cVar;
        Map map = f34229b;
        WeakReference weakReference = (WeakReference) map.get("RequestParamResolver");
        Object obj2 = null;
        if (weakReference == null) {
            obj = null;
        } else {
            obj = weakReference.get();
        }
        if (obj instanceof com.instabug.library.diagnostics.customtraces.network.c) {
            obj2 = obj;
        }
        cVar = (com.instabug.library.diagnostics.customtraces.network.c) obj2;
        if (cVar == null) {
            cVar = new com.instabug.library.diagnostics.customtraces.network.c();
            map.put("RequestParamResolver", new WeakReference(cVar));
        }
        return cVar;
    }

    @NotNull
    public final synchronized com.instabug.library.diagnostics.configuration.a g() {
        Object obj;
        com.instabug.library.diagnostics.configuration.a aVar;
        Map map = f34229b;
        WeakReference weakReference = (WeakReference) map.get("ConfigurationHandler");
        Object obj2 = null;
        if (weakReference == null) {
            obj = null;
        } else {
            obj = weakReference.get();
        }
        if (obj instanceof com.instabug.library.diagnostics.configuration.a) {
            obj2 = obj;
        }
        aVar = (com.instabug.library.diagnostics.configuration.a) obj2;
        if (aVar == null) {
            aVar = com.instabug.library.diagnostics.customtraces.settings.c.f34239a;
            map.put("ConfigurationHandler", new WeakReference(aVar));
        }
        return aVar;
    }

    @NotNull
    public final synchronized d h() {
        Object obj;
        d dVar;
        Map map = f34229b;
        WeakReference weakReference = (WeakReference) map.get("TracesDBHelper");
        Object obj2 = null;
        if (weakReference == null) {
            obj = null;
        } else {
            obj = weakReference.get();
        }
        if (obj instanceof d) {
            obj2 = obj;
        }
        dVar = (d) obj2;
        if (dVar == null) {
            dVar = new e();
            map.put("TracesDBHelper", new WeakReference(dVar));
        }
        return dVar;
    }
}
