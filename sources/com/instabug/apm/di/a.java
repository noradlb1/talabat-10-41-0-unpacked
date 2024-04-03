package com.instabug.apm.di;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.apm.cache.handler.session.g;
import com.instabug.apm.configuration.d;
import com.instabug.apm.fragment.s;
import com.instabug.apm.fragment.t;
import com.instabug.apm.fragment.u;
import com.instabug.apm.fragment.v;
import com.instabug.apm.h;
import com.instabug.apm.handler.session.l;
import com.instabug.apm.handler.session.m;
import com.instabug.apm.handler.uitrace.e;
import com.instabug.apm.handler.uitrace.f;
import com.instabug.apm.handler.uitrace.k;
import com.instabug.apm.i;
import com.instabug.apm.lifecycle.b;
import com.instabug.apm.lifecycle.c;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.OnSessionCrashedEventBus;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.utils.stability.handler.exception.ExceptionHandler;
import com.instabug.library.map.TwoWayMapper;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.sessionV3.providers.FeatureSessionDataController;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.util.threading.PriorityThreadFactory;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class a {
    @Nullable
    private static c A;

    /* renamed from: a  reason: collision with root package name */
    private static Context f45275a;

    /* renamed from: b  reason: collision with root package name */
    private static d f45276b;

    /* renamed from: c  reason: collision with root package name */
    private static com.instabug.apm.configuration.a f45277c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static com.instabug.apm.sync.a f45278d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static Map f45279e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static com.instabug.apm.handler.executiontraces.a f45280f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static com.instabug.apm.cache.handler.executiontraces.c f45281g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static com.instabug.apm.cache.handler.executiontraces.a f45282h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static com.instabug.apm.handler.applaunch.a f45283i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static com.instabug.apm.cache.handler.applaunch.a f45284j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static com.instabug.apm.handler.session.c f45285k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static WeakReference f45286l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static WeakReference f45287m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private static WeakReference f45288n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private static WeakReference f45289o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private static com.instabug.apm.cache.handler.uitrace.c f45290p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private static com.instabug.apm.cache.handler.uitrace.a f45291q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private static e f45292r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private static WeakReference f45293s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private static l f45294t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private static com.instabug.apm.handler.uitrace.customuitraces.a f45295u;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    private static f f45296v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    private static com.instabug.apm.handler.attributes.a f45297w;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    private static com.instabug.apm.lifecycle.a f45298x;

    /* renamed from: y  reason: collision with root package name */
    private static b f45299y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    private static com.instabug.apm.handler.experiment.a f45300z;

    public static synchronized com.instabug.apm.handler.executiontraces.a A() {
        com.instabug.apm.handler.executiontraces.a aVar;
        synchronized (a.class) {
            if (f45280f == null) {
                f45280f = new com.instabug.apm.handler.executiontraces.b();
            }
            aVar = f45280f;
        }
        return aVar;
    }

    public static synchronized com.instabug.apm.networking.mapping.executiontraces.a B() {
        com.instabug.apm.networking.mapping.executiontraces.b bVar;
        synchronized (a.class) {
            bVar = new com.instabug.apm.networking.mapping.executiontraces.b();
        }
        return bVar;
    }

    public static com.instabug.apm.cache.handler.executiontraces.e C() {
        return new com.instabug.apm.cache.handler.executiontraces.f(z(), t(), c(), PoolProvider.getSyncExecutor(), Y());
    }

    @Nullable
    public static synchronized com.instabug.apm.handler.experiment.a D() {
        com.instabug.apm.handler.experiment.a aVar;
        synchronized (a.class) {
            aVar = f45300z;
            if (aVar == null) {
                com.instabug.apm.cache.handler.experiment.a F = F();
                com.instabug.apm.cache.handler.session.f Y = Y();
                com.instabug.apm.configuration.c c11 = c();
                com.instabug.apm.logger.internal.a f11 = f();
                if (!(F == null || Y == null || c11 == null || f11 == null)) {
                    aVar = new com.instabug.apm.handler.experiment.c(F, Y, c11, f11);
                }
            }
            f45300z = aVar;
        }
        return aVar;
    }

    public static com.instabug.apm.networking.mapping.experiment.a E() {
        return new com.instabug.apm.networking.mapping.experiment.b();
    }

    @Nullable
    public static com.instabug.apm.cache.handler.experiment.a F() {
        DatabaseManager v11 = v();
        com.instabug.apm.logger.internal.a f11 = f();
        TwoWayMapper G = G();
        if (v11 == null || f11 == null || G == null) {
            return null;
        }
        return new com.instabug.apm.cache.handler.experiment.b(v11, f11, G);
    }

    public static TwoWayMapper G() {
        return com.instabug.apm.cache.handler.experiment.mapping.c.a();
    }

    public static s H() {
        return t.f45351a;
    }

    public static com.instabug.apm.networking.mapping.fragment_span.a I() {
        return new com.instabug.apm.networking.mapping.fragment_span.b();
    }

    public static com.instabug.apm.cache.handler.fragments.a J() {
        return com.instabug.apm.cache.handler.fragments.b.f45132a;
    }

    public static com.instabug.apm.cache.handler.fragments.c K() {
        return com.instabug.apm.cache.handler.fragments.d.f45135a;
    }

    public static com.instabug.apm.handler.fragment.a L() {
        return com.instabug.apm.handler.fragment.b.f45374a;
    }

    public static u M() {
        return v.f45353a;
    }

    public static Executor N() {
        return PoolProvider.getInstance().getBackgroundExecutor();
    }

    public static com.instabug.apm.cache.handler.networklog.c O() {
        return new com.instabug.apm.cache.handler.networklog.d();
    }

    public static com.instabug.apm.handler.networklog.a P() {
        return new com.instabug.apm.handler.networklog.c();
    }

    public static com.instabug.apm.networking.mapping.networklog.a Q() {
        return new com.instabug.apm.networking.mapping.networklog.b();
    }

    public static com.instabug.apm.cache.handler.networklog.e R() {
        return new com.instabug.apm.cache.handler.networklog.f(O(), u(), c(), Y());
    }

    public static NetworkManager S() {
        return new NetworkManager();
    }

    public static synchronized com.instabug.apm.handler.attributes.a T() {
        com.instabug.apm.handler.attributes.a aVar;
        synchronized (a.class) {
            if (f45297w == null) {
                f45297w = new com.instabug.apm.handler.attributes.b();
            }
            aVar = f45297w;
        }
        return aVar;
    }

    public static OnSessionCrashedEventBus U() {
        return OnSessionCrashedEventBus.getInstance();
    }

    public static FeatureSessionDataController V() {
        return i.f45452a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.instabug.apm.handler.session.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.instabug.apm.handler.session.j} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.instabug.apm.handler.session.j} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.instabug.apm.handler.session.j} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.instabug.apm.handler.session.c W() {
        /*
            java.lang.Class<com.instabug.apm.di.a> r0 = com.instabug.apm.di.a.class
            monitor-enter(r0)
            com.instabug.apm.handler.session.c r1 = f45285k     // Catch:{ all -> 0x0026 }
            if (r1 != 0) goto L_0x0024
            com.instabug.library.internal.utils.stability.handler.exception.ExceptionHandler r6 = y()     // Catch:{ all -> 0x0026 }
            com.instabug.apm.logger.internal.a r7 = f()     // Catch:{ all -> 0x0026 }
            com.instabug.apm.cache.handler.session.e r5 = new com.instabug.apm.cache.handler.session.e     // Catch:{ all -> 0x0026 }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x0026 }
            com.instabug.apm.handler.session.j r1 = new com.instabug.apm.handler.session.j     // Catch:{ all -> 0x0026 }
            com.instabug.apm.configuration.c r3 = c()     // Catch:{ all -> 0x0026 }
            com.instabug.apm.configuration.g r4 = h()     // Catch:{ all -> 0x0026 }
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0026 }
            f45285k = r1     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r0)
            return r1
        L_0x0026:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.di.a.W():com.instabug.apm.handler.session.c");
    }

    @NonNull
    public static synchronized com.instabug.apm.networking.mapping.sessions.a X() {
        com.instabug.apm.networking.mapping.sessions.a aVar;
        synchronized (a.class) {
            WeakReference weakReference = f45288n;
            if (weakReference != null) {
                if (weakReference.get() != null) {
                    aVar = (com.instabug.apm.networking.mapping.sessions.a) f45288n.get();
                }
            }
            aVar = new com.instabug.apm.networking.mapping.sessions.b();
            f45288n = new WeakReference(aVar);
        }
        return aVar;
    }

    @Nullable
    public static synchronized com.instabug.apm.cache.handler.session.f Y() {
        com.instabug.apm.cache.handler.session.f fVar;
        synchronized (a.class) {
            WeakReference weakReference = f45286l;
            if (weakReference == null || weakReference.get() == null) {
                f45286l = new WeakReference(new g());
            }
            fVar = (com.instabug.apm.cache.handler.session.f) f45286l.get();
        }
        return fVar;
    }

    @NonNull
    public static synchronized l Z() {
        l lVar;
        synchronized (a.class) {
            lVar = f45294t;
            if (lVar == null) {
                lVar = new m();
            }
            f45294t = lVar;
        }
        return lVar;
    }

    @NonNull
    public static com.instabug.apm.handler.uitrace.uiloading.a a() {
        return Build.VERSION.SDK_INT >= 29 ? new com.instabug.apm.handler.uitrace.uiloading.b() : new com.instabug.apm.handler.uitrace.uiloading.c();
    }

    public static synchronized com.instabug.apm.lifecycle.a a(Context context, boolean z11, boolean z12) {
        com.instabug.apm.lifecycle.a aVar;
        synchronized (a.class) {
            if (f45298x == null) {
                f45298x = new com.instabug.apm.lifecycle.a(context, Boolean.valueOf(z11), z12);
            }
            aVar = f45298x;
        }
        return aVar;
    }

    @RequiresApi(api = 16)
    public static com.instabug.apm.uitrace.a a(com.instabug.apm.handler.uitrace.c cVar, float f11) {
        return new com.instabug.apm.uitrace.b(cVar, f11);
    }

    public static synchronized Executor a(String str) {
        Executor singleThreadExecutor;
        synchronized (a.class) {
            singleThreadExecutor = PoolProvider.getSingleThreadExecutor(str);
        }
        return singleThreadExecutor;
    }

    public static void a(Context context) {
        f45275a = context;
    }

    @Nullable
    public static synchronized SharedPreferences a0() {
        synchronized (a.class) {
            Context r11 = r();
            if (r11 == null) {
                return null;
            }
            SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(r11, "instabug_apm");
            return instabugSharedPreferences;
        }
    }

    public static synchronized com.instabug.apm.configuration.a b() {
        com.instabug.apm.configuration.a aVar;
        synchronized (a.class) {
            if (f45277c == null) {
                f45277c = new com.instabug.apm.configuration.b(c());
            }
            aVar = f45277c;
        }
        return aVar;
    }

    public static synchronized c b(Context context, boolean z11, boolean z12) {
        c cVar;
        synchronized (a.class) {
            if (A == null) {
                A = new com.instabug.apm.lifecycle.f(context, z11, z12);
            }
            cVar = A;
        }
        return cVar;
    }

    public static synchronized Executor b(String str) {
        synchronized (a.class) {
            Map map = f45279e;
            if (map == null) {
                map = new ConcurrentHashMap();
            }
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) map.get(str);
            if (threadPoolExecutor != null) {
                return threadPoolExecutor;
            }
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 30, TimeUnit.MINUTES, new LinkedBlockingQueue(), new PriorityThreadFactory(str, 10));
            map.put(str, threadPoolExecutor2);
            f45279e = map;
            return threadPoolExecutor2;
        }
    }

    @NonNull
    public static synchronized com.instabug.apm.networking.handler.a b0() {
        com.instabug.apm.networking.handler.a aVar;
        synchronized (a.class) {
            WeakReference weakReference = f45287m;
            if (weakReference != null) {
                if (weakReference.get() != null) {
                    aVar = (com.instabug.apm.networking.handler.a) f45287m.get();
                }
            }
            aVar = new com.instabug.apm.networking.handler.b();
            f45287m = new WeakReference(aVar);
        }
        return aVar;
    }

    @NonNull
    public static com.instabug.apm.configuration.c c() {
        return d();
    }

    public static synchronized Executor c0() {
        Executor syncExecutor;
        synchronized (a.class) {
            syncExecutor = PoolProvider.getSyncExecutor();
        }
        return syncExecutor;
    }

    @NonNull
    private static synchronized d d() {
        d dVar;
        synchronized (a.class) {
            if (f45276b == null) {
                f45276b = new d();
            }
            dVar = f45276b;
        }
        return dVar;
    }

    @RequiresApi(api = 16)
    @NonNull
    public static com.instabug.apm.handler.uitrace.uihang.a d0() {
        return new com.instabug.apm.handler.uitrace.uihang.b();
    }

    public static h e() {
        return new h(f());
    }

    @NonNull
    public static synchronized com.instabug.apm.cache.handler.uitrace.a e0() {
        com.instabug.apm.cache.handler.uitrace.a aVar;
        synchronized (a.class) {
            aVar = f45291q;
            if (aVar == null) {
                aVar = new com.instabug.apm.cache.handler.uitrace.b();
            }
            f45291q = aVar;
        }
        return aVar;
    }

    public static com.instabug.apm.logger.internal.a f() {
        return new com.instabug.apm.logger.internal.a(c());
    }

    @NonNull
    public static com.instabug.apm.handler.uitrace.uiloading.d f0() {
        return new com.instabug.apm.handler.uitrace.uiloading.e(a(), f());
    }

    public static com.instabug.apm.configuration.e g() {
        return new com.instabug.apm.configuration.f();
    }

    @NonNull
    public static com.instabug.apm.networking.mapping.uiloading.a g0() {
        return new com.instabug.apm.networking.mapping.uiloading.b();
    }

    @NonNull
    public static com.instabug.apm.configuration.g h() {
        return d();
    }

    @RequiresApi(api = 16)
    public static com.instabug.apm.handler.uitrace.d h0() {
        return (com.instabug.apm.handler.uitrace.d) s();
    }

    public static synchronized com.instabug.apm.sync.a i() {
        com.instabug.apm.sync.a aVar;
        synchronized (a.class) {
            if (f45278d == null) {
                f45278d = new com.instabug.apm.sync.c();
            }
            aVar = f45278d;
        }
        return aVar;
    }

    public static synchronized com.instabug.apm.cache.handler.uitrace.c i0() {
        com.instabug.apm.cache.handler.uitrace.c cVar;
        synchronized (a.class) {
            if (f45290p == null) {
                f45290p = new com.instabug.apm.cache.handler.uitrace.d();
            }
            cVar = f45290p;
        }
        return cVar;
    }

    public static synchronized com.instabug.apm.cache.handler.applaunch.a j() {
        com.instabug.apm.cache.handler.applaunch.a aVar;
        synchronized (a.class) {
            if (f45284j == null) {
                f45284j = new com.instabug.apm.cache.handler.applaunch.b();
            }
            aVar = f45284j;
        }
        return aVar;
    }

    @NonNull
    public static synchronized e j0() {
        e eVar;
        synchronized (a.class) {
            eVar = f45292r;
            if (eVar == null) {
                eVar = new k(c(), SettingsManager.getInstance(), f());
            }
            f45292r = eVar;
        }
        return eVar;
    }

    public static synchronized b k() {
        b bVar;
        synchronized (a.class) {
            if (f45299y == null) {
                f45299y = new b();
            }
            bVar = f45299y;
        }
        return bVar;
    }

    @NonNull
    public static synchronized f k0() {
        f fVar;
        synchronized (a.class) {
            fVar = f45296v;
            if (fVar == null) {
                fVar = new com.instabug.apm.handler.uitrace.g(j0());
            }
            f45296v = fVar;
        }
        return fVar;
    }

    @Nullable
    public static synchronized c l() {
        c cVar;
        synchronized (a.class) {
            cVar = A;
        }
        return cVar;
    }

    @NonNull
    public static synchronized com.instabug.apm.networking.mapping.uitrace.a l0() {
        com.instabug.apm.networking.mapping.uitrace.a aVar;
        synchronized (a.class) {
            WeakReference weakReference = f45289o;
            if (weakReference != null) {
                if (weakReference.get() != null) {
                    aVar = (com.instabug.apm.networking.mapping.uitrace.a) f45289o.get();
                }
            }
            aVar = new com.instabug.apm.networking.mapping.uitrace.b(g0());
            f45289o = new WeakReference(aVar);
        }
        return aVar;
    }

    public static com.instabug.apm.networking.mapping.applaunch.a m() {
        return new com.instabug.apm.networking.mapping.applaunch.b();
    }

    public static synchronized void m0() {
        synchronized (a.class) {
            f45279e = null;
            f45278d = null;
            f45280f = null;
            f45281g = null;
            f45283i = null;
            f45284j = null;
            f45292r = null;
            f45290p = null;
            f45295u = null;
            f45291q = null;
            f45300z = null;
        }
    }

    public static synchronized com.instabug.apm.handler.applaunch.a n() {
        com.instabug.apm.handler.applaunch.a aVar;
        synchronized (a.class) {
            if (f45283i == null) {
                f45283i = new com.instabug.apm.handler.applaunch.b();
            }
            aVar = f45283i;
        }
        return aVar;
    }

    @Nullable
    public static String o() {
        return SettingsManager.getInstance().getAppToken();
    }

    @RequiresApi(api = 16)
    public static com.instabug.apm.handler.uitrace.automatictraces.a p() {
        return new com.instabug.apm.handler.uitrace.automatictraces.c();
    }

    public static Executor q() {
        return a("AutomaticUiTraceHandler");
    }

    @Nullable
    public static synchronized Context r() {
        synchronized (a.class) {
            Context context = f45275a;
            if (context != null) {
                return context;
            }
            if (!Instabug.isBuilt()) {
                return null;
            }
            Context applicationContext = Instabug.getApplicationContext();
            return applicationContext;
        }
    }

    @RequiresApi(api = 16)
    public static synchronized com.instabug.apm.handler.uitrace.customuitraces.a s() {
        com.instabug.apm.handler.uitrace.customuitraces.a aVar;
        synchronized (a.class) {
            if (f45295u == null) {
                f45295u = new com.instabug.apm.handler.uitrace.customuitraces.b(x(), c(), f());
            }
            aVar = f45295u;
        }
        return aVar;
    }

    public static synchronized com.instabug.apm.cache.handler.executiontraces.a t() {
        com.instabug.apm.cache.handler.executiontraces.a aVar;
        synchronized (a.class) {
            if (f45282h == null) {
                f45282h = new com.instabug.apm.cache.handler.executiontraces.b(v(), f());
            }
            aVar = f45282h;
        }
        return aVar;
    }

    public static com.instabug.apm.cache.handler.networklog.a u() {
        return new com.instabug.apm.cache.handler.networklog.b(v());
    }

    @SuppressLint({"RESOURCE_LEAK"})
    @Nullable
    public static synchronized DatabaseManager v() {
        synchronized (a.class) {
            WeakReference weakReference = f45293s;
            if (weakReference != null) {
                if (weakReference.get() != null) {
                    DatabaseManager databaseManager = (DatabaseManager) f45293s.get();
                    return databaseManager;
                }
            }
            if (r() == null) {
                return null;
            }
            try {
                WeakReference weakReference2 = new WeakReference(DatabaseManager.getInstance());
                f45293s = weakReference2;
                DatabaseManager databaseManager2 = (DatabaseManager) weakReference2.get();
                return databaseManager2;
            } catch (Exception e11) {
                com.instabug.apm.logger.internal.a f11 = f();
                f11.b("Error while getting database manager: " + e11.getMessage());
                return null;
            }
        }
    }

    public static com.instabug.apm.util.debug.a w() {
        return new com.instabug.apm.util.debug.b();
    }

    public static com.instabug.apm.util.device.a x() {
        return new com.instabug.apm.util.device.b();
    }

    public static ExceptionHandler y() {
        return new ExceptionHandler().withPenalty(new com.instabug.apm.util.logging.a(f()));
    }

    public static synchronized com.instabug.apm.cache.handler.executiontraces.c z() {
        com.instabug.apm.cache.handler.executiontraces.c cVar;
        synchronized (a.class) {
            if (f45281g == null) {
                f45281g = new com.instabug.apm.cache.handler.executiontraces.d();
            }
            cVar = f45281g;
        }
        return cVar;
    }
}
