package com.instabug.survey.announcements.network;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.announcements.cache.e;
import com.instabug.survey.announcements.models.a;
import com.instabug.survey.common.models.f;
import java.util.Iterator;
import java.util.List;

public class g extends InstabugNetworkJob {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static g f52267a;

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f52267a == null) {
                f52267a = new g();
            }
            gVar = f52267a;
        }
        return gVar;
    }

    private static void a(@NonNull List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.a(f.SYNCED);
            aVar.b().clear();
        }
        e.b(list);
    }

    /* access modifiers changed from: private */
    public static void b(@NonNull Context context) {
        InstabugSDKLogger.d("IBG-Surveys", "submitAnnouncements started");
        List<a> c11 = e.c();
        InstabugSDKLogger.d("IBG-Surveys", "ready to send Announcements size: " + c11.size());
        if (com.instabug.survey.di.a.b().d()) {
            a((List) c11);
            return;
        }
        for (a aVar : c11) {
            d.a().a(context, aVar, new e(aVar));
        }
    }

    public void start() {
        b(IBGNetworkWorker.SURVEYS, new f(this));
    }
}
