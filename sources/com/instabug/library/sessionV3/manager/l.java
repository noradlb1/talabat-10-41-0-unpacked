package com.instabug.library.sessionV3.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.lifecycle.a;
import com.instabug.library.internal.lifecycle.b;
import com.instabug.library.internal.lifecycle.c;
import com.instabug.library.internal.lifecycle.d;
import com.instabug.library.internal.video.i;
import com.instabug.library.model.v3Session.r;
import com.instabug.library.model.v3Session.s;
import com.instabug.library.model.v3Session.u;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class l implements b, d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final l f51814a = new l();

    /* renamed from: b  reason: collision with root package name */
    private static int f51815b;

    private l() {
    }

    public final void a(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        application.registerActivityLifecycleCallbacks(this);
        application.registerComponentCallbacks(this);
    }

    public final void b(@NotNull Application application) {
        Object obj;
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        try {
            Result.Companion companion = Result.Companion;
            application.unregisterActivityLifecycleCallbacks(this);
            application.unregisterComponentCallbacks(this);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        String str = "";
        if (r02 != null) {
            String message = r02.getMessage();
            if (message == null) {
                message = str;
            }
            InstabugCore.reportError(r02, Intrinsics.stringPlus("Something went wrong while un register session activity callbacks", message));
        }
        Throwable r52 = Result.m6332exceptionOrNullimpl(obj);
        if (r52 != null) {
            String message2 = r52.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while un register session activity callbacks", str), r52);
        }
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        a.a(this, activity, bundle);
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        a.a(this, activity);
    }

    public void onActivityPaused(@NotNull Activity activity) {
        a.b(this, activity);
    }

    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (f51815b == 1) {
            i.f51800a.a((u) new s());
        }
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        a.b(this, activity, bundle);
    }

    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        f51815b++;
    }

    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Context applicationContext = Instabug.getApplicationContext();
        int i11 = f51815b - 1;
        f51815b = i11;
        if (i11 == 0 && applicationContext != null && i.a(applicationContext)) {
            i.f51800a.a((u) new r());
        }
    }

    public void onConfigurationChanged(@NotNull Configuration configuration) {
        c.a(this, configuration);
    }

    public void onLowMemory() {
        c.a(this);
    }

    public void onTrimMemory(int i11) {
        if (i11 == 20) {
            i.f51800a.a((u) new r());
        }
    }
}
