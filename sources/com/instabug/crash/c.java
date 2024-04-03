package com.instabug.crash;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.instabug.commons.g;
import com.instabug.crash.cache.a;
import com.instabug.crash.settings.b;
import com.instabug.crash.settings.h;
import com.instabug.crash.utils.CrashReportingUtility;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import fc.i;
import fc.j;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c implements g {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Context f46389a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f46390b = LazyKt__LazyJVMKt.lazy(b.f46388a);

    @WorkerThread
    private final void d() {
        InstabugSDKLogger.v("IBG-CR", "CrashPlugin checking EncryptorVersion");
        if (b.a().c()) {
            InstabugSDKLogger.v("IBG-CR", "CrashPlugin checking EncryptorVersion > firstRunAfterEncryptorUpdate");
            a.a();
        }
    }

    private final void e() {
        if (h.b() != null) {
            h.b().b(0);
        }
    }

    private final com.instabug.commons.configurations.a f() {
        return (com.instabug.commons.configurations.a) this.f46390b.getValue();
    }

    private final void g() {
        Boolean bool = d.f46394c;
        Intrinsics.checkNotNullExpressionValue(bool, "isRegistered");
        if (!bool.booleanValue()) {
            InstabugSDKLogger.d("IBG-CR", "setting Uncaught Exception Handler com.instabug.crash.InstabugUncaughtExceptionHandler");
            Thread.setDefaultUncaughtExceptionHandler(new d(Instabug.getApplicationContext()));
        }
    }

    private final void h() {
        if (this.f46389a != null) {
            PoolProvider.postIOTask(new i(this));
        } else {
            InstabugSDKLogger.v("IBG-CR", "Context is null.");
        }
    }

    @WorkerThread
    private final void i() {
        if (CrashReportingUtility.isCrashReportingEnabled() && com.instabug.crash.cache.b.b() > 0) {
            com.instabug.crash.network.h.b().start();
        }
    }

    @WorkerThread
    private final void j() {
        a.b();
    }

    public void a() {
    }

    public void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PoolProvider.postIOTaskWithCheck(new j(context, this));
    }

    public void b() {
    }

    public void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f46389a = context;
        f().a();
        c(context);
        g();
    }

    public void c() {
        this.f46389a = null;
        b.d();
    }

    /* access modifiers changed from: private */
    public static final void a(Context context, c cVar) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        b.a(context);
        cVar.d();
        cVar.i();
    }

    private final void c(Context context) {
        if (!InstabugCore.isLastSDKStateEnabled(context)) {
            com.instabug.crash.utils.a.c();
        }
    }

    public void a(@NotNull SDKCoreEvent sDKCoreEvent) {
        Intrinsics.checkNotNullParameter(sDKCoreEvent, "sdkCoreEvent");
        String type = sDKCoreEvent.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != -296668708) {
                if (hashCode != 3599307) {
                    if (hashCode == 1843485230 && type.equals(SDKCoreEvent.Network.TYPE_NETWORK) && Intrinsics.areEqual((Object) sDKCoreEvent.getValue(), (Object) SDKCoreEvent.Network.VALUE_ACTIVATED) && CrashReportingUtility.isCrashReportingEnabled()) {
                        h();
                    }
                } else if (type.equals("user") && Intrinsics.areEqual((Object) sDKCoreEvent.getValue(), (Object) SDKCoreEvent.User.VALUE_LOGGED_OUT)) {
                    e();
                }
            } else if (type.equals(SDKCoreEvent.Feature.TYPE_FEATURES_FETCHED)) {
                f().a(sDKCoreEvent.getValue());
                com.instabug.crash.settings.a.a(sDKCoreEvent.getValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void a(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        com.instabug.crash.utils.a.b();
        int b11 = com.instabug.crash.cache.b.b();
        if (b11 > 0) {
            if (b11 > 100) {
                cVar.j();
            }
            com.instabug.crash.network.h.b().start();
        }
    }
}
