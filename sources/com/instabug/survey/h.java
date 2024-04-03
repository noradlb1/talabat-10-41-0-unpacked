package com.instabug.survey;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.UserEventsEventBus;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.user.UserManagerWrapper;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.TaskDebouncer;
import com.instabug.library.util.TimeUtils;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.survey.common.models.i;
import com.instabug.survey.configuration.d;
import com.instabug.survey.di.a;
import com.instabug.survey.models.Survey;
import com.instabug.survey.network.b;
import com.instabug.survey.network.c;
import com.instabug.survey.network.e;
import com.instabug.survey.network.f;
import com.instabug.survey.utils.j;
import com.instabug.survey.utils.l;
import com.instabug.survey.utils.m;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

public class h implements e, l, b {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static h f52383h;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f52384a;

    /* renamed from: b  reason: collision with root package name */
    private final f f52385b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final m f52386c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Disposable f52387d;

    /* renamed from: e  reason: collision with root package name */
    private final c f52388e;

    /* renamed from: f  reason: collision with root package name */
    private final TaskDebouncer f52389f;

    /* renamed from: g  reason: collision with root package name */
    private final d f52390g = a.b();

    private h(@NonNull Context context) {
        this.f52384a = new WeakReference(context);
        this.f52385b = new f(this);
        this.f52386c = new m(this, InstabugDeviceProperties.getAppVersionName(context), InstabugDeviceProperties.getAppVersion(context));
        this.f52388e = new c(this);
        this.f52389f = new TaskDebouncer(TimeUnit.MINUTES.toMillis(1));
        i();
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (str != null) {
            try {
                if (this.f52384a.get() != null) {
                    this.f52385b.a((Context) this.f52384a.get(), str);
                }
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-Surveys", "Couldn't fetch surveys due to: " + e11.getMessage(), e11);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean b() {
        return InstabugStateProvider.getInstance().getState().equals(InstabugState.ENABLED) && j.d() && Instabug.isAppOnForeground() && !InstabugCore.isForegroundBusy() && this.f52390g.a();
    }

    private void c(@NonNull Survey survey) {
        if (b()) {
            d(survey);
        }
    }

    @Nullable
    private Survey d() {
        return this.f52386c.a();
    }

    private void d(@NonNull Survey survey) {
        com.instabug.survey.common.d.a().a(survey);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static synchronized h e() {
        h hVar;
        synchronized (h.class) {
            if (f52383h == null) {
                f();
            }
            hVar = f52383h;
        }
        return hVar;
    }

    public static synchronized void f() {
        synchronized (h.class) {
            if (Instabug.getApplicationContext() != null) {
                f52383h = new h(Instabug.getApplicationContext());
            }
        }
    }

    private void l() {
        try {
            Thread.sleep(10000);
            if (com.instabug.survey.settings.c.o() && Instabug.isAppOnForeground()) {
                UserEventsEventBus.getInstance().post(new c());
            }
        } catch (InterruptedException e11) {
            if (e11.getMessage() != null) {
                InstabugSDKLogger.e("IBG-Surveys", "Couldn't show survey because thread was interrupted");
            }
        }
    }

    @VisibleForTesting
    public void a() {
        if (this.f52384a.get() != null) {
            com.instabug.survey.settings.c.b(LocaleUtils.getCurrentLocaleResolved((Context) this.f52384a.get()));
        }
    }

    public synchronized void a(@NonNull Survey survey) {
        c(survey);
    }

    public void a(com.instabug.survey.models.a aVar) {
        try {
            com.instabug.survey.settings.c.a(aVar.toJson());
            com.instabug.survey.announcements.settings.a.a(aVar.toJson());
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-Surveys", "Can't update country info due to: " + e11.getMessage());
        }
    }

    public void a(String str) {
        b(str);
    }

    public void a(Throwable th2) {
        if (th2.getMessage() != null) {
            InstabugSDKLogger.e("IBG-Surveys", "Couldn't fetch surveys due to: " + th2.getMessage(), th2);
        }
        l();
    }

    public void a(List list) {
        a();
        l(list);
        h(list);
        p(list);
        if (Instabug.isEnabled()) {
            l();
        }
    }

    public synchronized void b(long j11) {
        if (com.instabug.survey.cache.l.b(j11) != null) {
            c(com.instabug.survey.cache.l.b(j11));
        }
    }

    public synchronized void b(@NonNull Survey survey) {
        c(survey);
    }

    @VisibleForTesting
    public boolean e(Survey survey, Survey survey2) {
        com.instabug.survey.common.models.d d11 = survey.getTarget().d();
        com.instabug.survey.common.models.d d12 = survey2.getTarget().d();
        return (d11.c() == d12.c() && d11.a() == d12.a() && d11.b() == d12.b()) ? false : true;
    }

    public void f(String str) {
        this.f52389f.debounce((Runnable) new d(this, str));
    }

    public void g(com.instabug.survey.models.a aVar) {
        try {
            String b11 = com.instabug.survey.settings.c.b();
            long j11 = com.instabug.survey.settings.c.f52433a;
            if (b11 != null) {
                aVar.fromJson(b11);
                j11 = aVar.d();
            }
            if (TimeUtils.currentTimeMillis() - com.instabug.survey.settings.c.c() > TimeUnit.DAYS.toMillis(j11)) {
                WeakReference weakReference = this.f52384a;
                if (weakReference != null && weakReference.get() != null) {
                    this.f52388e.a((Context) this.f52384a.get());
                    return;
                }
                return;
            }
            a(aVar);
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-Surveys", "Can't resolve country info due to: " + e11.getMessage());
        }
    }

    @VisibleForTesting
    public void h(List list) {
        for (Survey survey : com.instabug.survey.cache.l.b()) {
            if (!list.contains(survey)) {
                com.instabug.survey.cache.l.a(survey.getId());
            }
        }
    }

    public void i() {
        Disposable disposable = this.f52387d;
        if (disposable == null || disposable.isDisposed()) {
            this.f52387d = UserEventsEventBus.getInstance().subscribe(new e(this));
        }
    }

    @VisibleForTesting
    public boolean i(Survey survey, Survey survey2) {
        return survey.getLocalization().a() != null && !survey.getLocalization().a().equals(survey2.getLocalization().a());
    }

    @VisibleForTesting
    @Nullable
    public Survey j(String str) {
        for (Survey survey : com.instabug.survey.cache.l.b()) {
            if (survey.getToken() != null && survey.getToken().equals(str)) {
                InstabugSDKLogger.d("IBG-Surveys", "Showing survey With token " + str);
                return survey;
            }
        }
        InstabugSDKLogger.d("IBG-Surveys", "No Survey With token " + str);
        return null;
    }

    public List k() {
        return this.f52386c.c();
    }

    @VisibleForTesting
    public void l(List list) {
        i a11;
        List<Survey> b11 = com.instabug.survey.cache.l.b();
        String userUUID = UserManagerWrapper.getUserUUID();
        ArrayList arrayList = new ArrayList();
        for (Survey survey : b11) {
            if (!list.contains(survey) && (a11 = com.instabug.survey.common.userInteractions.a.a(survey.getId(), userUUID, 0)) != null) {
                arrayList.add(a11);
            }
        }
        if (!arrayList.isEmpty()) {
            com.instabug.survey.common.userInteractions.a.a(arrayList);
        }
    }

    public void m() {
        Disposable disposable = this.f52387d;
        if (disposable != null && !disposable.isDisposed()) {
            this.f52387d.dispose();
        }
    }

    @VisibleForTesting
    public boolean m(Survey survey, Survey survey2) {
        return survey2.isPaused() != survey.isPaused();
    }

    public void n() {
        for (Survey survey : com.instabug.survey.cache.l.b()) {
            if (survey.isCancelled() && survey.shouldShowAgain()) {
                survey.incrementSessionCount();
                com.instabug.survey.cache.l.d(survey);
            }
        }
    }

    @VisibleForTesting
    public void n(List list) {
        String userUUID = UserManagerWrapper.getUserUUID();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Survey survey = (Survey) it.next();
            i a11 = com.instabug.survey.common.userInteractions.a.a(survey.getId(), userUUID, 0);
            if (a11 != null) {
                survey.setUserInteraction(a11);
                arrayList.add(survey);
            }
        }
        if (!list.isEmpty()) {
            com.instabug.survey.cache.l.b((List) arrayList);
        }
    }

    public boolean o(String str) {
        Survey j11 = j(str);
        if (j11 != null) {
            return j11.isAnswered();
        }
        InstabugSDKLogger.e("IBG-Surveys", "No survey with token:" + str + " was found.");
        return false;
    }

    public void onError(Throwable th2) {
        InstabugSDKLogger.e("IBG-Surveys", "Can't resolve country info due to: " + th2.getMessage());
    }

    @VisibleForTesting
    @WorkerThread
    public void p(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Survey survey = (Survey) it.next();
            if (com.instabug.survey.cache.l.c(survey.getId())) {
                Survey b11 = com.instabug.survey.cache.l.b(survey.getId());
                if (b11 != null) {
                    boolean m11 = m(survey, b11);
                    boolean i11 = !survey.isPaused() ? i(survey, b11) : false;
                    if (m11 || i11) {
                        com.instabug.survey.cache.l.a(survey, m11, i11);
                    }
                    if (e(survey, b11)) {
                        b11.getTarget().a(survey.getTarget().d());
                        com.instabug.survey.cache.l.e(b11);
                    }
                }
            } else if (!survey.isPaused()) {
                com.instabug.survey.cache.l.a(survey);
            }
        }
    }

    public boolean q(String str) {
        Survey j11;
        if (!b() || (j11 = j(str)) == null || j11.isPaused()) {
            return false;
        }
        c(j11);
        return true;
    }

    public void r() {
        UserManagerWrapper.getUUIDAsync(new f(this));
    }

    public void s() {
        PoolProvider.postIOTask(new g(this));
    }

    public synchronized void t() {
        m();
        com.instabug.survey.common.d.a().a(false);
        com.instabug.survey.common.d.a().b(false);
        com.instabug.survey.common.d.a().b();
        if (f52383h != null) {
            f52383h = null;
        }
    }

    @SuppressLint({"THREAD_SAFETY_VIOLATION"})
    public boolean u() {
        Survey d11;
        if (!Instabug.isEnabled()) {
            InstabugSDKLogger.e("IBG-Surveys", "Couldn't show survey because Instabug SDK is disabled.");
            return false;
        }
        try {
            if (!b() || (d11 = d()) == null) {
                return false;
            }
            c(d11);
            return true;
        } catch (ParseException e11) {
            InstabugSDKLogger.e("IBG-Surveys", "Something went wrong while getting first valid survey", e11);
            return false;
        }
    }
}
