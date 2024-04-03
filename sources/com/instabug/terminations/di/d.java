package com.instabug.terminations.di;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.instabug.commons.caching.FileCacheDirectory;
import com.instabug.commons.caching.SessionCacheDirectory;
import com.instabug.commons.configurations.a;
import com.instabug.commons.di.CommonsLocator;
import com.instabug.commons.diagnostics.di.DiagnosticsLocator;
import com.instabug.commons.diagnostics.reporter.DiagnosticsReporter;
import com.instabug.commons.session.g;
import com.instabug.commons.snapshot.CaptorsRegistry;
import com.instabug.crash.settings.b;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.limitation.RateLimitedFeature;
import com.instabug.library.networkv2.limitation.RateLimiter;
import com.instabug.library.tracking.FirstFGTimeProvider;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.terminations.a0;
import com.instabug.terminations.cache.c;
import com.instabug.terminations.cache.e;
import com.instabug.terminations.i;
import com.instabug.terminations.p;
import com.instabug.terminations.sync.k;
import com.instabug.terminations.v;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final d f52610a = new d();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Map f52611b = new LinkedHashMap();
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Lazy f52612c = LazyKt__LazyJVMKt.lazy(c.f52609a);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Lazy f52613d = LazyKt__LazyJVMKt.lazy(b.f52608a);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Lazy f52614e = LazyKt__LazyJVMKt.lazy(a.f52607a);

    private d() {
    }

    @RequiresApi(30)
    private final a0 k() {
        return new p(a(), d(), i.f52625a.a(s()), h(), b());
    }

    private final a0 l() {
        return new v(a(), d(), i.f52625a.a(s()), h(), b());
    }

    @NotNull
    public final synchronized RateLimiter a(@NotNull Function1 function1) {
        RateLimiter rateLimiter;
        Intrinsics.checkNotNullParameter(function1, "onLimited");
        String obj = Reflection.getOrCreateKotlinClass(RateLimiter.class).toString();
        d dVar = f52610a;
        Object a11 = dVar.a(obj);
        rateLimiter = a11 == null ? null : (RateLimiter) a11;
        if (rateLimiter == null) {
            rateLimiter = new RateLimiter(dVar.n(), function1, (RateLimitedFeature) null, 4, (DefaultConstructorMarker) null);
            dVar.a(obj, rateLimiter);
        }
        return rateLimiter;
    }

    @NotNull
    public final synchronized c b() {
        c cVar;
        String obj = Reflection.getOrCreateKotlinClass(c.class).toString();
        d dVar = f52610a;
        Object a11 = dVar.a(obj);
        cVar = a11 == null ? null : (c) a11;
        if (cVar == null) {
            cVar = new e();
            dVar.a(obj, cVar);
        }
        return cVar;
    }

    @NotNull
    public final CaptorsRegistry c() {
        return CommonsLocator.getCaptorsRegistry();
    }

    @NotNull
    public final SessionCacheDirectory d() {
        return CommonsLocator.getCrashesCacheDir();
    }

    @NotNull
    public final CurrentActivityLifeCycleEventBus e() {
        CurrentActivityLifeCycleEventBus instance = CurrentActivityLifeCycleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @NotNull
    public final com.instabug.commons.c f() {
        return CommonsLocator.INSTANCE.getDetectorsListenersRegistry();
    }

    @NotNull
    public final DiagnosticsReporter g() {
        return DiagnosticsLocator.getReporter();
    }

    @NotNull
    public final FirstFGTimeProvider h() {
        return FirstFGTimeProvider.Factory.INSTANCE.invoke();
    }

    @NotNull
    public final synchronized NetworkManager i() {
        NetworkManager networkManager;
        String obj = Reflection.getOrCreateKotlinClass(NetworkManager.class).toString();
        d dVar = f52610a;
        Object a11 = dVar.a(obj);
        if (a11 == null) {
            networkManager = null;
        } else {
            networkManager = (NetworkManager) a11;
        }
        if (networkManager == null) {
            networkManager = new NetworkManager();
            dVar.a(obj, networkManager);
        }
        return networkManager;
    }

    @NotNull
    public final Executor j() {
        Executor singleThreadExecutor = PoolProvider.getSingleThreadExecutor("termination-operations-executor");
        Intrinsics.checkNotNullExpressionValue(singleThreadExecutor, "getSingleThreadExecutor(…ion-operations-executor\")");
        return singleThreadExecutor;
    }

    @NotNull
    public final g m() {
        return CommonsLocator.getSessionLinker();
    }

    @NotNull
    public final b n() {
        b a11 = b.a();
        Intrinsics.checkNotNullExpressionValue(a11, "getInstance()");
        return a11;
    }

    @NotNull
    public final synchronized InstabugNetworkJob o() {
        InstabugNetworkJob instabugNetworkJob;
        String obj = Reflection.getOrCreateKotlinClass(InstabugNetworkJob.class).toString();
        d dVar = f52610a;
        Object a11 = dVar.a(obj);
        if (a11 == null) {
            instabugNetworkJob = null;
        } else {
            instabugNetworkJob = (InstabugNetworkJob) a11;
        }
        if (instabugNetworkJob == null) {
            instabugNetworkJob = new k();
            dVar.a(obj, instabugNetworkJob);
        }
        return instabugNetworkJob;
    }

    public final int p() {
        return 100;
    }

    @NotNull
    public final FileCacheDirectory q() {
        return (FileCacheDirectory) f52614e.getValue();
    }

    @NotNull
    public final a r() {
        return (a) f52613d.getValue();
    }

    @NotNull
    public final com.instabug.terminations.configuration.c s() {
        return (com.instabug.terminations.configuration.c) f52612c.getValue();
    }

    @NotNull
    public final a0 t() {
        return com.instabug.commons.utils.a.a() ? k() : l();
    }

    private final Object a(String str) {
        WeakReference weakReference = (WeakReference) f52611b.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @NotNull
    public final ScheduledExecutorService b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return CommonsLocator.INSTANCE.getScheduledExecutor(str);
    }

    private final void a(String str, Object obj) {
        f52611b.put(str, new WeakReference(obj));
    }

    @Nullable
    public final Context a() {
        return CommonsLocator.INSTANCE.getAppCtx();
    }
}
