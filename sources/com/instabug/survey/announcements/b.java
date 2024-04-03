package com.instabug.survey.announcements;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.user.UserManagerWrapper;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.TimeUtils;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.survey.announcements.cache.e;
import com.instabug.survey.announcements.cache.m;
import com.instabug.survey.announcements.network.g;
import com.instabug.survey.announcements.settings.a;
import com.instabug.survey.common.d;
import com.instabug.survey.common.models.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import td.c;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static b f52220c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f52221a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private c f52222b;

    public b(Context context) {
        this.f52221a = context;
        m();
    }

    public static b a(Context context) {
        if (f52220c == null) {
            b(context);
        }
        return f52220c;
    }

    private void a() {
        Context context = this.f52221a;
        if (context != null) {
            a.b(LocaleUtils.getCurrentLocaleResolved(context));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.instabug.survey.announcements.models.a aVar) {
        String str;
        try {
            Thread.sleep(((long) aVar.n().f().a()) * 1000);
            b(aVar);
        } catch (InterruptedException e11) {
            if (aVar.p() == 101) {
                str = "Something went wrong while scheduling update msg announcement";
            } else if (aVar.p() == 100) {
                str = "Something went wrong while scheduling what's new announcement";
            } else {
                return;
            }
            InstabugSDKLogger.e("IBG-Surveys", str, e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(String str) {
        List b11 = e.b();
        if (!b11.isEmpty()) {
            com.instabug.survey.common.userInteractions.a.a(b11, str);
            e.a(b11);
        }
    }

    /* access modifiers changed from: private */
    public void a(Throwable th2) {
        InstabugSDKLogger.e("IBG-Surveys", "Announcement Fetching Failed due to " + th2.getMessage());
        l();
    }

    @NonNull
    private c b() {
        if (this.f52222b == null) {
            this.f52222b = new c(InstabugDeviceProperties.getAppVersionName(this.f52221a), InstabugDeviceProperties.getAppVersion(this.f52221a));
        }
        return this.f52222b;
    }

    public static void b(Context context) {
        f52220c = new b(context);
    }

    @WorkerThread
    private void b(com.instabug.survey.announcements.models.a aVar) {
        d.a().a(aVar);
    }

    @WorkerThread
    private void c(List list) {
        String userUUID = UserManagerWrapper.getUserUUID();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.instabug.survey.announcements.models.a aVar = (com.instabug.survey.announcements.models.a) it.next();
            i a11 = com.instabug.survey.common.userInteractions.a.a(aVar.i(), userUUID, 1);
            if (a11 != null) {
                aVar.a(a11);
                arrayList.add(aVar);
            }
        }
        if (!list.isEmpty()) {
            e.b((List) arrayList);
        }
    }

    public static boolean c() {
        return InstabugCore.isFeatureAvailable(Feature.ANNOUNCEMENTS);
    }

    public static boolean d() {
        return InstabugCore.getFeatureState(Feature.ANNOUNCEMENTS) == Feature.State.ENABLED;
    }

    /* access modifiers changed from: private */
    public void e(List list) {
        InstabugSDKLogger.d("IBG-Surveys", "Announcement Fetching Succeeded");
        if (Instabug.isEnabled()) {
            a();
            v(list);
            r(list);
            b(list);
            u(list);
            l();
        }
    }

    private boolean e() {
        return InstabugCore.isFeaturesFetchedBefore();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        List b11 = e.b();
        if (!b11.isEmpty()) {
            c(b11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g() {
        if (!e.c().isEmpty()) {
            g.a().start();
        }
    }

    private void k() {
        com.instabug.survey.announcements.models.a a11;
        if (c() && d() && (a11 = b().a()) != null) {
            PoolProvider.postIOTask(new c(this, a11));
        }
    }

    @WorkerThread
    private void l() {
        List<com.instabug.survey.announcements.models.a> a11 = e.a(101);
        List a12 = e.a(100);
        if (a11.size() > 0) {
            for (com.instabug.survey.announcements.models.a z11 : a11) {
                if (z11.z()) {
                    k();
                    return;
                }
            }
        }
        if (a12.size() > 0) {
            k();
        }
    }

    private void m() {
        if (this.f52221a != null) {
            PoolProvider.postIOTask(new td.d());
        } else {
            InstabugSDKLogger.e("IBG-Surveys", "Couldn't sync announcements due to null context");
        }
    }

    public void b(String str) {
        if (this.f52221a != null) {
            try {
                if (e() && d()) {
                    if (TimeUtils.currentTimeMillis() - a.b().c() > 10000) {
                        com.instabug.survey.announcements.network.d.a().a(str, new a(this));
                    } else {
                        k();
                    }
                }
            } catch (JSONException e11) {
                a((Throwable) e11);
                InstabugSDKLogger.e("IBG-Surveys", "Something went wrong while fetching announcements", e11);
            }
        }
    }

    @WorkerThread
    public void b(List list) {
        for (com.instabug.survey.announcements.models.a aVar : e.b()) {
            if (!list.contains(aVar)) {
                e.a(String.valueOf(aVar.i()));
            }
        }
    }

    public void h() {
        UserManagerWrapper.getUUIDAsync(new td.b());
    }

    public void i() {
        PoolProvider.postIOTask(new td.a(this));
    }

    public void j() {
        if (com.instabug.survey.announcements.settings.b.b() != null) {
            com.instabug.survey.announcements.settings.b.b().b(InstabugDeviceProperties.getAppVersion(this.f52221a));
        }
    }

    @VisibleForTesting
    @WorkerThread
    public void r(List list) {
        i a11;
        List<com.instabug.survey.announcements.models.a> b11 = e.b();
        String userUUID = UserManagerWrapper.getUserUUID();
        ArrayList arrayList = new ArrayList();
        for (com.instabug.survey.announcements.models.a aVar : b11) {
            if (!list.contains(aVar) && (a11 = com.instabug.survey.common.userInteractions.a.a(aVar.i(), userUUID, 1)) != null) {
                arrayList.add(a11);
            }
        }
        if (!arrayList.isEmpty()) {
            com.instabug.survey.common.userInteractions.a.a(arrayList);
        }
    }

    @VisibleForTesting
    public boolean s(com.instabug.survey.announcements.models.a aVar, @Nullable com.instabug.survey.announcements.models.a aVar2) {
        return (aVar2 == null || aVar.j().a() == null || aVar.j().a().equals(aVar2.j().a())) ? false : true;
    }

    @VisibleForTesting
    public boolean t(com.instabug.survey.announcements.models.a aVar, @Nullable com.instabug.survey.announcements.models.a aVar2) {
        return (aVar2 == null || aVar2.v() == aVar.v()) ? false : true;
    }

    @VisibleForTesting
    @WorkerThread
    public void u(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.instabug.survey.announcements.models.a aVar = (com.instabug.survey.announcements.models.a) it.next();
                if (aVar != null) {
                    if (e.b(aVar.i())) {
                        com.instabug.survey.announcements.models.a a11 = e.a(aVar.i());
                        boolean t11 = t(aVar, a11);
                        boolean s11 = s(aVar, a11);
                        if (aVar.e() == 0) {
                            m.a(aVar);
                        }
                        if (t11 || s11) {
                            e.a(aVar, t11, s11);
                        }
                    } else if (!aVar.v()) {
                        m.a(aVar);
                        e.a(aVar);
                    }
                }
            }
        }
    }

    @VisibleForTesting
    public void v(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.instabug.survey.announcements.models.a aVar = (com.instabug.survey.announcements.models.a) it.next();
            if (aVar.p() == 101) {
                a.b().a(aVar.n().f().a());
            } else if (aVar.p() == 100) {
                a.b().b(aVar.n().f().a());
            }
        }
    }
}
