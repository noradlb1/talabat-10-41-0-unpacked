package com.instabug.commons.di;

import android.content.Context;
import com.instabug.commons.caching.SessionCacheDirectory;
import com.instabug.commons.caching.h;
import com.instabug.commons.session.g;
import com.instabug.commons.snapshot.CaptorsRegistry;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.sessionV3.configurations.IBGSessionCrashesConfigurations;
import com.instabug.library.sessionV3.providers.FeatureSessionDataController;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.util.threading.PriorityThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CommonsLocator {
    @NotNull
    public static final CommonsLocator INSTANCE = new CommonsLocator();
    @NotNull
    private static final Lazy captorsRegistry$delegate = LazyKt__LazyJVMKt.lazy(a.f46299a);
    @NotNull
    private static final Lazy compositeLifecycleOwner$delegate = LazyKt__LazyJVMKt.lazy(b.f46300a);
    @NotNull
    private static final Lazy crashesCacheDir$delegate = LazyKt__LazyJVMKt.lazy(c.f46301a);
    @NotNull
    private static final Lazy detectorsListenersRegistry$delegate = LazyKt__LazyJVMKt.lazy(d.f46302a);
    @NotNull
    private static final Lazy sessionIncidentCachingHandler$delegate = LazyKt__LazyJVMKt.lazy(e.f46303a);
    @NotNull
    private static final Lazy sessionLinker$delegate = LazyKt__LazyJVMKt.lazy(f.f46304a);

    public static final class a extends Lambda implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f46299a = new a();

        public a() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final CaptorsRegistry invoke() {
            return new CaptorsRegistry();
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f46300a = new b();

        public b() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.instabug.commons.lifecycle.c invoke() {
            ScheduledExecutorService scheduledExecutor = PoolProvider.getInstance().getScheduledExecutor();
            Intrinsics.checkNotNullExpressionValue(scheduledExecutor, "getInstance().scheduledExecutor");
            return new com.instabug.commons.lifecycle.c(scheduledExecutor);
        }
    }

    public static final class c extends Lambda implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final c f46301a = new c();

        public c() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final h invoke() {
            return new h(a.f46305a, b.f46306a);
        }
    }

    public static final class d extends Lambda implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final d f46302a = new d();

        public d() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.instabug.commons.a invoke() {
            return new com.instabug.commons.a();
        }
    }

    public static final class e extends Lambda implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final e f46303a = new e();

        public e() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.instabug.commons.session.b invoke() {
            return new com.instabug.commons.session.b();
        }
    }

    public static final class f extends Lambda implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final f f46304a = new f();

        public f() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.instabug.commons.session.d invoke() {
            return new com.instabug.commons.session.d();
        }
    }

    private CommonsLocator() {
    }

    @JvmStatic
    @NotNull
    public static final CaptorsRegistry getCaptorsRegistry() {
        return (CaptorsRegistry) captorsRegistry$delegate.getValue();
    }

    @JvmStatic
    @NotNull
    public static final SessionCacheDirectory getCrashesCacheDir() {
        return (SessionCacheDirectory) crashesCacheDir$delegate.getValue();
    }

    @NotNull
    public static final FeatureSessionDataController getCrashesSessionDataController() {
        return com.instabug.commons.session.a.f46333a;
    }

    @JvmStatic
    public static /* synthetic */ void getCrashesSessionDataController$annotations() {
    }

    @NotNull
    public static final g getSessionLinker() {
        return (g) sessionLinker$delegate.getValue();
    }

    @JvmStatic
    public static /* synthetic */ void getSessionLinker$annotations() {
    }

    @Nullable
    public final Context getAppCtx() {
        return Instabug.getApplicationContext();
    }

    @NotNull
    public final com.instabug.commons.lifecycle.c getCompositeLifecycleOwner() {
        return (com.instabug.commons.lifecycle.c) compositeLifecycleOwner$delegate.getValue();
    }

    @Nullable
    public final Context getCtx() {
        return Instabug.getApplicationContext();
    }

    @NotNull
    public final com.instabug.commons.c getDetectorsListenersRegistry() {
        return (com.instabug.commons.c) detectorsListenersRegistry$delegate.getValue();
    }

    @NotNull
    public final ScheduledExecutorService getScheduledExecutor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new PriorityThreadFactory(str, 10));
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "PriorityThreadFactory(na…cutor(tFactory)\n        }");
        return newSingleThreadScheduledExecutor;
    }

    @NotNull
    public final IBGSessionCrashesConfigurations getSessionCrashesConfigurations() {
        IBGSessionCrashesConfigurations v3SessionCrashesConfigurations = InstabugCore.getV3SessionCrashesConfigurations();
        Intrinsics.checkNotNullExpressionValue(v3SessionCrashesConfigurations, "getV3SessionCrashesConfigurations()");
        return v3SessionCrashesConfigurations;
    }

    @NotNull
    public final com.instabug.commons.session.f getSessionIncidentCachingHandler() {
        return (com.instabug.commons.session.f) sessionIncidentCachingHandler$delegate.getValue();
    }
}
