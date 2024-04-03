package com.instabug.library.visualusersteps;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Fragment;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.e0;
import com.instabug.library.internal.storage.ProcessedBytes;
import com.instabug.library.model.StepType;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.visualusersteps.VisualUserStep;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import rd.b;
import rd.c;

@Instrumented
public class y {

    /* renamed from: h  reason: collision with root package name */
    private static y f52200h;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f52201a;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public p f52202b = new p();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private VisualUserStep f52203c;

    /* renamed from: d  reason: collision with root package name */
    private int f52204d = 0;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public String f52205e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f52206f = true;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public long f52207g;

    @SuppressLint({"CheckResult"})
    private y() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            PoolProvider.postIOTask(new r(this, applicationContext));
        }
        SDKCoreEventSubscriber.subscribe(new s(this));
    }

    public static synchronized y d() {
        y yVar;
        synchronized (y.class) {
            if (f52200h == null) {
                f52200h = new y();
            }
            yVar = f52200h;
        }
        return yVar;
    }

    /* access modifiers changed from: private */
    @Nullable
    public d e() {
        if (this.f52202b.j() == null) {
            return null;
        }
        return (d) this.f52202b.j().peekLast();
    }

    private boolean f() {
        return e0.c().b((Object) Feature.REPRO_STEPS) == Feature.State.ENABLED;
    }

    /* access modifiers changed from: private */
    public void i() {
        if (f() && this.f52206f) {
            a(StepType.APPLICATION_FOREGROUND);
            this.f52206f = false;
        }
    }

    private void j() {
        for (d dVar : this.f52202b.j()) {
            ArrayList arrayList = new ArrayList();
            for (VisualUserStep visualUserStep : dVar.f()) {
                if (visualUserStep.getStepType() != null && (visualUserStep.getStepType().equals(StepType.ACTIVITY_PAUSED) || visualUserStep.getStepType().equals(StepType.FRAGMENT_PAUSED) || visualUserStep.getStepType().equals(StepType.DIALOG_FRAGMENT_RESUMED))) {
                    arrayList.add(visualUserStep);
                }
            }
            dVar.f().removeAll(arrayList);
        }
    }

    public void a(String str, @Nullable Bitmap bitmap) {
        try {
            if (!InstabugCore.isForegroundBusy()) {
                p();
                if (str != null && !str.isEmpty()) {
                    j(str, StepType.ACTIVITY_RESUMED);
                }
                if (SettingsManager.getInstance().isReproStepsScreenshotEnabled()) {
                    if (bitmap != null) {
                        d e11 = e();
                        InstabugInternalTrackingDelegate instance = InstabugInternalTrackingDelegate.getInstance();
                        if (instance != null && instance.getTargetActivity() != null && e11 != null) {
                            f(instance.getTargetActivity(), bitmap, e11);
                        }
                    } else if (e() != null) {
                        g(e());
                    }
                }
            }
        } catch (Exception e12) {
            InstabugCore.reportError(e12, "Error while adding VUS");
        }
    }

    public void b(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        b(this.f52202b.i(), str, str2, str3, str4);
    }

    @Nullable
    public d c() {
        return this.f52202b.i();
    }

    public void g() {
        Object lastSeenView = InstabugCore.getLastSeenView();
        if (lastSeenView != null) {
            b(lastSeenView instanceof Fragment ? StepType.FRAGMENT_RESUMED : StepType.ACTIVITY_RESUMED, lastSeenView.getClass().getSimpleName(), lastSeenView.getClass().getName(), (String) null);
        }
    }

    public void k() {
        try {
            this.f52202b.n();
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "Error while removing last tap step");
        }
    }

    public void l() {
        this.f52204d = 0;
    }

    /* access modifiers changed from: private */
    public void h() {
        if (f()) {
            d().b(StepType.APPLICATION_BACKGROUND, (String) null, (String) null, (String) null);
            this.f52206f = true;
        }
    }

    /* access modifiers changed from: private */
    public boolean m() {
        return SettingsManager.getInstance().getCurrentPlatform() == 7 || SettingsManager.getInstance().getCurrentPlatform() == 4 || SettingsManager.getInstance().getCurrentPlatform() == 8;
    }

    /* access modifiers changed from: private */
    public void n() {
        ReproStepsScreenshotEventBus.INSTANCE.post(2);
    }

    private void o() {
        ReproStepsScreenshotEventBus.INSTANCE.post(1);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void p() {
        try {
            q();
            r();
            j();
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "Error while trimming reprosteps");
        }
    }

    private void q() {
        try {
            if (this.f52202b.k() > 20) {
                this.f52202b.c(this.f52202b.k() - 20);
            }
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "Error while trimming screenshots");
        }
    }

    private void r() {
        try {
            if (this.f52202b.l() > 110) {
                while (this.f52202b.l() > 100) {
                    this.f52202b.m();
                }
            }
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "Error while triming steps");
        }
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public void b(@Nullable d dVar, String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        o();
        PoolProvider.getSingleThreadExecutor("steps-executor").execute(new t(this, str2, str, dVar, str3, str4));
    }

    @VisibleForTesting
    public void f(Activity activity, Bitmap bitmap, d dVar) {
        PoolProvider.postIOTask(new x(this, dVar, bitmap, activity));
    }

    public Bitmap l(String str) {
        ProcessedBytes decryptOnTheFly = InstabugCore.decryptOnTheFly(str);
        byte[] fileBytes = decryptOnTheFly.isProcessSuccessful() ? decryptOnTheFly.getFileBytes() : new byte[0];
        return BitmapFactoryInstrumentation.decodeByteArray(fileBytes, 0, fileBytes.length);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(String str, String str2, String str3, String str4) {
        a(this.f52202b.i(), str, str2, str3, str4);
    }

    /* access modifiers changed from: private */
    public boolean b(d dVar) {
        if (dVar.f().isEmpty()) {
            return true;
        }
        if (dVar.f().size() != 1 || ((VisualUserStep) dVar.f().getFirst()).getStepType() == null || !((VisualUserStep) dVar.f().getFirst()).getStepType().equals(StepType.APPLICATION_FOREGROUND)) {
            return false;
        }
        return true;
    }

    public void c(String str) {
        for (d dVar : this.f52202b.j()) {
            if (dVar.d() != null && dVar.d().a() != null && dVar.d().a().equals(str)) {
                dVar.d().a((String) null);
                return;
            }
        }
    }

    @VisibleForTesting
    public String e(@Nullable WeakReference weakReference) {
        EditText editText;
        if (!(weakReference == null || weakReference.get() == null || weakReference.get() == null || !(weakReference.get() instanceof EditText) || (editText = (EditText) weakReference.get()) == null)) {
            if (editText.getHint() != null) {
                if (!VisualUserStepsHelper.a(editText) && !TextUtils.isEmpty(editText.getHint().toString())) {
                    return editText.getHint().toString();
                }
            } else if (editText.getContentDescription() != null && !TextUtils.isEmpty(editText.getContentDescription().toString())) {
                return editText.getContentDescription().toString();
            }
        }
        return "a text field";
    }

    @VisibleForTesting
    public void g(d dVar) {
        if (!dVar.i() && SettingsManager.getInstance().isReproStepsScreenshotEnabled() && e0.c().b((Object) Feature.BUG_REPORTING) == Feature.State.ENABLED) {
            Activity targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
            o();
            dVar.a(true);
            new Handler(Looper.getMainLooper()).postDelayed(new v(this, targetActivity, dVar), 500);
        }
    }

    public void b(boolean z11) {
        PoolProvider.getSingleThreadExecutor("steps-executor").execute(new c(this, z11));
    }

    public ArrayList b() {
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.f52202b.j()) {
            VisualUserStep.b c11 = VisualUserStep.Builder((String) null).d(dVar.e()).b((String) null).c(dVar.a());
            if (dVar.d() != null) {
                c11.e(dVar.d().a()).g(dVar.d().b());
            }
            arrayList.add(c11.a());
            arrayList.addAll(dVar.f());
        }
        return arrayList;
    }

    @VisibleForTesting
    public void j(@Nullable String str, @Nullable String str2) {
        try {
            p pVar = this.f52202b;
            int i11 = this.f52204d + 1;
            this.f52204d = i11;
            pVar.d(new d(String.valueOf(i11), str, str2));
            if (this.f52203c != null && this.f52202b.i() != null) {
                this.f52202b.i().b(VisualUserStep.Builder(this.f52203c.getStepType()).d(str).b(this.f52202b.i().a()).f("").a(false).a((String) null).a());
                this.f52203c = null;
            }
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "couldn't add Parent to visualUserSteps");
        }
    }

    private void a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        PoolProvider.getSingleThreadExecutor("steps-executor").execute(new b(this, str, str2, str3, str4));
    }

    /* access modifiers changed from: private */
    public void a(@Nullable d dVar, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        d e11;
        try {
            if (!InstabugCore.isForegroundBusy()) {
                if (dVar == null) {
                    if (!m()) {
                        if (str != null && !str.equals(StepType.APPLICATION_BACKGROUND)) {
                            j(str2, str);
                            dVar = c();
                        }
                    } else {
                        return;
                    }
                }
                if (str != null) {
                    if (str.equals(StepType.SCROLL) || str.equals(StepType.PINCH) || str.equals(StepType.SWIPE)) {
                        str3 = null;
                    }
                }
                if (str3 == null) {
                    str3 = "";
                }
                if (!(dVar == null || str == null || ((!str.equals(StepType.SWIPE) && !str.equals(StepType.SCROLL)) || dVar.g() == null || !dVar.g().equals(StepType.TAB_SELECT) || !dVar.f().isEmpty() || (e11 = e()) == null))) {
                    dVar = e11;
                    str = StepType.SWIPE;
                }
                if (dVar != null) {
                    this.f52202b.e(dVar, VisualUserStep.Builder(str).d(str2).b(dVar.a()).f(str3).a(!TextUtils.isEmpty(str4)).a(str4).a());
                }
            }
        } catch (Exception e12) {
            IBGDiagnostics.reportNonFatal(e12, "couldn't add step to visualUsersSteps");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z11) {
        try {
            a(c(), z11);
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "couldn't log keyboard event");
        }
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void a(@Nullable d dVar, boolean z11) {
        if (!(!z11 || dVar == null || dVar.c() == null || dVar.c().getStepType() == null || !dVar.c().getStepType().equals(StepType.START_EDITING))) {
            WeakReference weakReference = this.f52201a;
            if (weakReference != null) {
                String e11 = e(weakReference);
                String view = dVar.c().getView();
                if (view != null && !view.equals(e11)) {
                    a(StepType.END_EDITING, dVar.c().getScreenName(), dVar.c().getView(), (String) null);
                }
            } else {
                return;
            }
        }
        a(dVar, z11 ? StepType.START_EDITING : StepType.END_EDITING, this.f52205e, e(this.f52201a), (String) null);
    }

    @VisibleForTesting
    public void a(String str) {
        this.f52203c = VisualUserStep.Builder(str).d((String) null).b((String) null).f("").a(false).a((String) null).a();
    }

    public void a() {
        this.f52202b.a();
        this.f52202b.g();
    }

    public void a(View view, View view2) {
        if (view != null) {
            a(StepType.END_EDITING, this.f52205e, e(new WeakReference(view)), (String) null);
        }
        if (view2 != null) {
            a(StepType.START_EDITING, this.f52205e, e(new WeakReference(view2)), (String) null);
        } else {
            a(StepType.END_EDITING, this.f52205e, e(new WeakReference(view)), (String) null);
        }
    }
}
