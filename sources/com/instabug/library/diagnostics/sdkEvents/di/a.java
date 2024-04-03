package com.instabug.library.diagnostics.sdkEvents.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.diagnostics_db.m;
import com.instabug.library.diagnostics.sdkEvents.cache.c;
import com.instabug.library.diagnostics.sdkEvents.cache.g;
import com.instabug.library.diagnostics.sdkEvents.configurations.b;
import com.instabug.library.diagnostics.sdkEvents.e;
import com.instabug.library.diagnostics.sdkEvents.f;
import com.instabug.library.diagnostics.sdkEvents.h;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.threading.PoolProvider;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f34336a = new a();

    private a() {
    }

    private final Context a() {
        return Instabug.getApplicationContext();
    }

    private final synchronized c g() {
        return new g(new com.instabug.library.diagnostics.sdkEvents.mappers.a(), m.f34273b.a());
    }

    @NotNull
    public static final synchronized e i() {
        e eVar;
        synchronized (a.class) {
            eVar = new e();
        }
        return eVar;
    }

    @Nullable
    public final synchronized SharedPreferences b() {
        SharedPreferences sharedPreferences;
        Context a11 = a();
        if (a11 == null) {
            sharedPreferences = null;
        } else {
            sharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(a11, SettingsManager.INSTABUG_SHARED_PREF_NAME);
        }
        return sharedPreferences;
    }

    @NotNull
    public final synchronized com.instabug.library.diagnostics.sdkEvents.configurations.a c() {
        SettingsManager instance;
        instance = SettingsManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return new b(instance, b());
    }

    @NotNull
    public final synchronized com.instabug.library.diagnostics.mappers.a d() {
        return new com.instabug.library.diagnostics.sdkEvents.mappers.c();
    }

    @NotNull
    public final synchronized com.instabug.library.diagnostics.sdkEvents.cache.a e() {
        return new com.instabug.library.diagnostics.sdkEvents.cache.b(g(), new h(c()));
    }

    @NotNull
    public final synchronized com.instabug.library.diagnostics.configuration.a f() {
        return new com.instabug.library.diagnostics.sdkEvents.b();
    }

    @NotNull
    public final synchronized ThreadPoolExecutor h() {
        ThreadPoolExecutor iOExecutor;
        iOExecutor = PoolProvider.getInstance().getIOExecutor();
        Intrinsics.checkNotNullExpressionValue(iOExecutor, "getInstance().ioExecutor");
        return iOExecutor;
    }

    @NotNull
    public final synchronized f j() {
        return new com.instabug.library.diagnostics.sdkEvents.g();
    }
}
