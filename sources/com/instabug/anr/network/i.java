package com.instabug.anr.network;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.anr.cache.a;
import com.instabug.anr.model.b;
import com.instabug.crash.utils.e;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;
import org.json.JSONException;

public class i extends InstabugNetworkJob {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static i f45090a;

    private i() {
    }

    /* access modifiers changed from: private */
    public static void b(@NonNull Context context) throws JSONException {
        List<b> a11 = a.a(context);
        InstabugSDKLogger.v("IBG-CR", "Found " + a11.size() + " ANRs in cache");
        for (b bVar : a11) {
            if (bVar.a() == 1) {
                if (com.instabug.crash.settings.b.a().isRateLimited()) {
                    a(context, bVar);
                    b();
                } else {
                    com.instabug.crash.settings.b.a().setLastRequestStartedAt(System.currentTimeMillis());
                    InstabugSDKLogger.d("IBG-CR", "Uploading anr: " + bVar.toString());
                    d.a().a(bVar, (Request.Callbacks) new e(bVar, context));
                }
            } else if (bVar.a() == 2) {
                InstabugSDKLogger.v("IBG-CR", "ANR: " + bVar.toString() + " already uploaded but has unsent logs, uploading now");
                d(bVar);
            } else if (bVar.a() == 3) {
                InstabugSDKLogger.v("IBG-CR", "ANR: " + bVar.toString() + " already uploaded but has unsent attachments, uploading now");
                c(bVar);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void c(b bVar) throws JSONException {
        InstabugSDKLogger.d("IBG-CR", "Found " + bVar.b().size() + " attachments related to ANR: " + bVar.c());
        d.a().b(bVar, new g(bVar));
    }

    /* access modifiers changed from: private */
    public static void d(b bVar) {
        InstabugSDKLogger.d("IBG-CR", "START uploading all logs related to this ANR id = " + bVar.c());
        d.a().c(bVar, new f(bVar));
    }

    public void start() {
        b(IBGNetworkWorker.CRASH, new h(this));
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (f45090a == null) {
                f45090a = new i();
            }
            iVar = f45090a;
        }
        return iVar;
    }

    private static void a(Context context, @NonNull b bVar) {
        e.a(context, bVar);
    }

    /* access modifiers changed from: private */
    public static void b(RateLimitedException rateLimitedException, @NonNull b bVar, Context context) {
        com.instabug.crash.settings.b.a().setLimitedUntil(rateLimitedException.getPeriod());
        b();
        a(context, bVar);
    }

    private static void b() {
        InstabugSDKLogger.d("IBG-CR", String.format(RateLimitedException.RATE_LIMIT_REACHED, new Object[]{"Crashes"}));
    }
}
