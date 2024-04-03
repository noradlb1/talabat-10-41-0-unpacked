package com.instabug.bug.view.actionList.service;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.C;
import com.instabug.bug.settings.b;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.TaskDebouncer;
import com.instabug.library.util.TimeUtils;

public class d extends InstabugNetworkJob {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final TaskDebouncer f45802a = new TaskDebouncer(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);

    /* renamed from: b  reason: collision with root package name */
    private static final NetworkManager f45803b = new NetworkManager();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static d f45804c;

    private d() {
    }

    /* access modifiers changed from: private */
    public static void b(@Nullable String str) {
        b.f().d(str);
    }

    public static synchronized d c() {
        d dVar;
        synchronized (d.class) {
            if (f45804c == null) {
                f45804c = new d();
            }
            dVar = f45804c;
        }
        return dVar;
    }

    @VisibleForTesting
    public static long d() {
        return b.f().l();
    }

    /* access modifiers changed from: private */
    public static void e() {
        InstabugSDKLogger.d("IBG-BR", "Getting report categories for this application");
        f45803b.doRequest(IBGNetworkWorker.CORE, 1, new Request.Builder().endpoint(Endpoints.REPORT_CATEGORIES).method("GET").hasUuid(false).build(), (Request.Callbacks<RequestResponse, Throwable>) new a());
    }

    @VisibleForTesting
    public static void h(long j11) {
        b.f().b(j11);
    }

    public void start() {
        if (TimeUtils.hasXHoursPassed(d(), 86400000)) {
            b(IBGNetworkWorker.CORE, new c(this));
        }
    }
}
