package com.instabug.featuresrequest.network.service;

import androidx.annotation.Nullable;
import com.instabug.featuresrequest.cache.a;
import com.instabug.featuresrequest.models.d;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.util.InstabugSDKLogger;

public class l extends InstabugNetworkJob {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static l f46583a;

    private l() {
    }

    private static void a(d dVar, String str) {
        if (Instabug.getApplicationContext() != null) {
            g.a().a(dVar.g(), str, new i(dVar));
        }
    }

    public static synchronized l b() {
        l lVar;
        synchronized (l.class) {
            if (f46583a == null) {
                f46583a = new l();
            }
            lVar = f46583a;
        }
        return lVar;
    }

    /* access modifiers changed from: private */
    public static void c() {
        String str;
        InstabugSDKLogger.d("IBG-FR", "submitVotes started");
        for (d dVar : a.a()) {
            int i11 = k.f46582a[dVar.n().ordinal()];
            if (i11 == 1) {
                str = "POST";
            } else if (i11 == 2) {
                str = "DELETE";
            }
            a(dVar, str);
        }
    }

    public void start() {
        b("IBG-FR", new j(this));
    }
}
