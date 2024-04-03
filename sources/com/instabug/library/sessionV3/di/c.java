package com.instabug.library.sessionV3.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.core.plugin.b;
import com.instabug.library.internal.storage.cache.dbv2.IBGDbManager;
import com.instabug.library.networkv2.INetworkManager;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.limitation.RateLimitedFeature;
import com.instabug.library.networkv2.limitation.RateLimiter;
import com.instabug.library.sessionV3.cache.SessionCacheManager;
import com.instabug.library.sessionV3.configurations.IBGSessionCrashesConfigurations;
import com.instabug.library.sessionV3.configurations.a;
import com.instabug.library.sessionV3.configurations.f;
import com.instabug.library.sessionV3.configurations.g;
import com.instabug.library.sessionV3.manager.j;
import com.instabug.library.sessionV3.manager.k;
import com.instabug.library.sessionV3.manager.m;
import com.instabug.library.sessionV3.manager.n;
import com.instabug.library.sessionV3.sync.a0;
import com.instabug.library.sessionV3.sync.e;
import com.instabug.library.sessionV3.sync.o;
import com.instabug.library.sessionV3.sync.t;
import com.instabug.library.util.threading.PoolProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f51790a = new c();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f51791b = LazyKt__LazyJVMKt.lazy(b.f51789a);

    private c() {
    }

    @NotNull
    public static final com.instabug.library.sessionV3.sync.c b() {
        return e.f51831a;
    }

    @NotNull
    public static final a c() {
        return f.f51770a;
    }

    private final HashMap h() {
        return (HashMap) f51791b.getValue();
    }

    @NotNull
    public static final com.instabug.library.core.plugin.a j() {
        return b.f34196a;
    }

    @NotNull
    public static final SessionCacheManager k() {
        return com.instabug.library.sessionV3.cache.b.f51763a;
    }

    @NotNull
    public static final com.instabug.library.sessionV3.configurations.c l() {
        return g.f51773a;
    }

    @NotNull
    public static final IBGSessionCrashesConfigurations m() {
        return g.f51773a;
    }

    @NotNull
    public static final j r() {
        return k.f51812a;
    }

    @NotNull
    public static final o u() {
        return t.f51850a;
    }

    @NotNull
    public final com.instabug.library.sessionV3.providers.a a() {
        return com.instabug.library.sessionV3.providers.b.f51821a;
    }

    @NotNull
    public final IBGDbManager d() {
        IBGDbManager instance = IBGDbManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @Nullable
    public final SharedPreferences e() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getSharedPreferences("ibg_session_duration", 0);
    }

    @NotNull
    public final com.instabug.library.sessionV3.cache.e f() {
        return com.instabug.library.sessionV3.cache.e.f51766a;
    }

    @NotNull
    public final Executor g() {
        Executor singleThreadExecutor = PoolProvider.getSingleThreadExecutor("v3-session-experiments");
        Intrinsics.checkNotNullExpressionValue(singleThreadExecutor, "getSingleThreadExecutor(\"v3-session-experiments\")");
        return singleThreadExecutor;
    }

    @NotNull
    public final INetworkManager i() {
        return new NetworkManager();
    }

    @NotNull
    public final a0 n() {
        return a0.f51824a;
    }

    @NotNull
    public final com.instabug.library.sessionV3.providers.c o() {
        return com.instabug.library.sessionV3.providers.e.f51822a;
    }

    @NotNull
    public final Executor p() {
        Executor singleThreadExecutor = PoolProvider.getSingleThreadExecutor("v3-session");
        Intrinsics.checkNotNullExpressionValue(singleThreadExecutor, "getSingleThreadExecutor(\"v3-session\")");
        return singleThreadExecutor;
    }

    @NotNull
    public final com.instabug.library.sessionV3.sync.f q() {
        return com.instabug.library.sessionV3.sync.g.f51833a;
    }

    @NotNull
    public final m s() {
        return n.f51816a;
    }

    @NotNull
    public final InstabugNetworkJob t() {
        return com.instabug.library.sessionV3.sync.n.f51841a;
    }

    @NotNull
    public final RateLimiter a(@NotNull Function1 function1) {
        RateLimiter rateLimiter;
        Object obj;
        Intrinsics.checkNotNullParameter(function1, "onLimited");
        Class<RateLimiter> cls = RateLimiter.class;
        WeakReference weakReference = (WeakReference) h().get(cls.getName());
        if (weakReference == null || (obj = weakReference.get()) == null) {
            rateLimiter = null;
        } else {
            rateLimiter = (RateLimiter) obj;
        }
        if (rateLimiter != null) {
            return rateLimiter;
        }
        RateLimitedFeature rateLimitedFeature = RateLimitedFeature.V3_SESSION;
        RateLimiter rateLimiter2 = new RateLimiter(new com.instabug.library.networkv2.limitation.b(rateLimitedFeature), function1, rateLimitedFeature);
        HashMap h11 = f51790a.h();
        String name2 = cls.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "RateLimiter::class.java.name");
        h11.put(name2, new WeakReference(rateLimiter2));
        return rateLimiter2;
    }

    @NotNull
    public final ReadWriteProperty a(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "keyValue");
        return a((String) pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public final ReadWriteProperty a(@NotNull String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        return new a(str, obj);
    }
}
