package com.instabug.bug.network;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.bug.configurations.d;
import com.instabug.bug.di.a;
import com.instabug.bug.utils.c;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;

public class i extends InstabugNetworkJob {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static i f45704a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final d f45705b = a.e();

    private i() {
    }

    public static synchronized i b() {
        i iVar;
        synchronized (i.class) {
            if (f45704a == null) {
                f45704a = new i();
            }
            iVar = f45704a;
        }
        return iVar;
    }

    /* access modifiers changed from: private */
    public static void b(Context context) {
        List<com.instabug.bug.model.d> a11 = a.a().a(context);
        InstabugSDKLogger.d("IBG-BR", "Found " + a11.size() + " bugs in cache");
        for (com.instabug.bug.model.d dVar : a11) {
            if (dVar.b().equals(com.instabug.bug.model.a.READY_TO_BE_SENT)) {
                InstabugSDKLogger.d("IBG-BR", "Uploading bug: " + dVar.toString());
                d dVar2 = f45705b;
                if (dVar2.c()) {
                    c.a(dVar, context);
                    c();
                } else {
                    dVar2.a(System.currentTimeMillis());
                    d.a().a(context, dVar, new e(dVar, context));
                }
            } else if (dVar.b().equals(com.instabug.bug.model.a.LOGS_READY_TO_BE_UPLOADED)) {
                InstabugSDKLogger.v("IBG-BR", "Bug: " + dVar.toString() + " already uploaded but has unsent logs, uploading now");
                d(dVar, context);
            } else if (dVar.b().equals(com.instabug.bug.model.a.ATTACHMENTS_READY_TO_BE_UPLOADED)) {
                InstabugSDKLogger.v("IBG-BR", "Bug: " + dVar.toString() + " already uploaded but has unsent attachments, uploading now");
                c(dVar, context);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(RateLimitedException rateLimitedException, @NonNull com.instabug.bug.model.d dVar, Context context) {
        f45705b.a(rateLimitedException.getPeriod());
        c();
        c.a(dVar, context);
    }

    private static void c() {
        InstabugSDKLogger.d("IBG-BR", String.format(RateLimitedException.RATE_LIMIT_REACHED, new Object[]{"Bug Reporting"}));
    }

    /* access modifiers changed from: private */
    public static void c(com.instabug.bug.model.d dVar, Context context) {
        InstabugSDKLogger.v("IBG-BR", "Found " + dVar.a().size() + " attachments related to bug: " + dVar.g());
        d.a().a(dVar, new g(context, dVar));
    }

    /* access modifiers changed from: private */
    public static void d(com.instabug.bug.model.d dVar, Context context) {
        InstabugSDKLogger.v("IBG-BR", "START uploading all logs related to this bug id = " + dVar.getId());
        d.a().b(dVar, (Request.Callbacks) new f(dVar, context));
    }

    public void start() {
        b("InstabugBugsUploaderJob", new h(this));
    }
}
