package com.instabug.apm.lifecycle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.handler.session.k;
import com.instabug.apm.handler.uitrace.e;
import com.instabug.apm.handler.uitrace.f;
import com.instabug.library.model.common.Session;
import com.instabug.library.settings.SettingsManager;

public class a implements Application.ActivityLifecycleCallbacks, com.instabug.apm.handler.session.a {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f45453d = false;

    /* renamed from: a  reason: collision with root package name */
    private final e f45454a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final c f45455b;

    /* renamed from: c  reason: collision with root package name */
    private int f45456c = 0;

    @SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
    public a(Context context, Boolean bool, boolean z11) {
        b();
        k.a(this);
        this.f45454a = com.instabug.apm.di.a.j0();
        this.f45455b = com.instabug.apm.di.a.b(context, bool.booleanValue(), z11);
    }

    private void a(@NonNull Activity activity, long j11) {
        e eVar;
        if (SettingsManager.getInstance().getCurrentPlatform() != 2 || (eVar = this.f45454a) == null) {
            f k02 = com.instabug.apm.di.a.k0();
            if (k02 != null) {
                k02.a(activity);
                return;
            }
            return;
        }
        eVar.a(activity, j11);
    }

    public static boolean a() {
        return f45453d;
    }

    private static void b() {
        f45453d = true;
    }

    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        com.instabug.apm.model.e eVar = new com.instabug.apm.model.e();
        e eVar2 = this.f45454a;
        if (eVar2 != null) {
            eVar2.b(activity, eVar);
        }
        this.f45455b.b(activity, eVar);
    }

    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    public void onActivityPaused(@NonNull Activity activity) {
        a(activity, System.nanoTime());
    }

    public void onActivityPostCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        com.instabug.apm.model.e eVar = new com.instabug.apm.model.e();
        e eVar2 = this.f45454a;
        if (eVar2 != null) {
            eVar2.g(activity, eVar);
        }
    }

    public void onActivityPostResumed(@NonNull Activity activity) {
        if (this.f45454a != null) {
            this.f45454a.d(activity, new com.instabug.apm.model.e());
        }
    }

    public void onActivityPostStarted(@NonNull Activity activity) {
        com.instabug.apm.model.e eVar = new com.instabug.apm.model.e();
        e eVar2 = this.f45454a;
        if (eVar2 != null) {
            eVar2.f(activity, eVar);
        }
    }

    public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        com.instabug.apm.model.e eVar = new com.instabug.apm.model.e();
        e eVar2 = this.f45454a;
        if (eVar2 != null) {
            eVar2.e(activity, eVar);
        }
    }

    public void onActivityPreResumed(@NonNull Activity activity) {
        com.instabug.apm.model.e eVar = new com.instabug.apm.model.e();
        e eVar2 = this.f45454a;
        if (eVar2 != null) {
            eVar2.j(activity, eVar);
        }
    }

    public void onActivityPreStarted(@NonNull Activity activity) {
        com.instabug.apm.model.e eVar = new com.instabug.apm.model.e();
        e eVar2 = this.f45454a;
        if (eVar2 != null) {
            eVar2.h(activity, eVar);
        }
    }

    public void onActivityResumed(@NonNull Activity activity) {
        com.instabug.apm.model.e eVar = new com.instabug.apm.model.e();
        e eVar2 = this.f45454a;
        if (eVar2 != null) {
            eVar2.a(activity, eVar);
            this.f45454a.i(activity, eVar);
        }
        this.f45455b.a(activity, eVar);
    }

    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    public void onActivityStarted(@NonNull Activity activity) {
        this.f45456c++;
        com.instabug.apm.model.e eVar = new com.instabug.apm.model.e();
        e eVar2 = this.f45454a;
        if (eVar2 != null) {
            eVar2.c(activity, eVar);
        }
        this.f45455b.c(activity, eVar);
    }

    public void onActivityStopped(@NonNull Activity activity) {
        int i11 = this.f45456c;
        boolean z11 = true;
        if (i11 != 0) {
            this.f45456c = i11 - 1;
        }
        e eVar = this.f45454a;
        if (eVar != null) {
            if (this.f45456c != 0) {
                z11 = false;
            }
            eVar.a(activity, z11);
        }
        this.f45455b.b();
    }

    public synchronized void onNewSessionStarted(@NonNull Session session, @Nullable Session session2) {
        this.f45455b.a(session);
    }
}
