package com.instabug.library.visualusersteps;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.model.StepType;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;
import rd.a;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private Deque f52181a = new LinkedBlockingDeque();

    /* renamed from: b  reason: collision with root package name */
    private int f52182b;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Boolean bool) throws Exception {
    }

    /* access modifiers changed from: private */
    public boolean a(@Nullable String str) {
        String str2;
        Context applicationContext = Instabug.getApplicationContext();
        if (str == null) {
            str2 = "Couldn't execute deleteFile(). file name is null";
        } else if (applicationContext != null) {
            File visualUserStepsDirectory = VisualUserStepsHelper.getVisualUserStepsDirectory(applicationContext);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(visualUserStepsDirectory);
            String str3 = File.separator;
            sb2.append(str3);
            sb2.append(str);
            File file = new File(sb2.toString());
            if (!file.exists()) {
                int indexOfExtension = FileUtils.getIndexOfExtension(str);
                String substring = str.substring(indexOfExtension);
                if (indexOfExtension == -1) {
                    indexOfExtension = str.length();
                }
                String str4 = visualUserStepsDirectory + str3 + str.substring(0, indexOfExtension) + FileUtils.FLAG_ENCRYPTED + substring;
                File file2 = new File(str4);
                if (!file2.exists()) {
                    str2 = "Couldn't execute deleteFile(). File does not exist";
                } else if (file2.delete()) {
                    InstabugSDKLogger.v("IBG-Core", "VisualUserStep screenshot deleted! filename= " + str4);
                    return true;
                } else {
                    str2 = "Couldn't delete screenshot=" + str4 + ". Something went wrong";
                }
            } else if (file.delete()) {
                InstabugSDKLogger.v("IBG-Core", "VisualUserStep screenshot deleted! filename= " + str);
                return true;
            } else {
                str2 = "Couldn't delete screenshot=" + str + ". Something went wrong";
            }
        } else {
            str2 = "Couldn't execute deleteFile(). Context is null";
        }
        InstabugSDKLogger.e("IBG-Core", str2);
        return false;
    }

    @Nullable
    private d b() {
        return (d) this.f52181a.peekFirst();
    }

    private Observable c(@Nullable String str) {
        return Observable.fromCallable(new o(this, str));
    }

    private void h() {
        d dVar = (d) this.f52181a.peekFirst();
        if (dVar != null) {
            c d11 = dVar.d();
            if (d11 != null) {
                b(d11.a());
            }
            this.f52182b -= dVar.h();
            this.f52181a.pollFirst();
        }
    }

    public void d(d dVar) {
        this.f52181a.add(dVar);
    }

    public void e(d dVar, VisualUserStep visualUserStep) {
        if ((visualUserStep.getStepType() == null || !visualUserStep.getStepType().equals(StepType.END_EDITING)) && !b(dVar, visualUserStep)) {
            if (visualUserStep.getStepType() != null && visualUserStep.getStepType().equals(StepType.START_EDITING) && visualUserStep.getView() != null && !visualUserStep.getView().equals("a text field")) {
                visualUserStep.setView(StringUtility.applyDoubleQuotations(visualUserStep.getView()));
            }
            dVar.b(visualUserStep);
            this.f52182b++;
        }
    }

    public void g() {
        this.f52181a.clear();
    }

    @Nullable
    public d i() {
        return (d) this.f52181a.peekLast();
    }

    public Deque j() {
        return this.f52181a;
    }

    public int k() {
        return this.f52181a.size();
    }

    public int l() {
        return this.f52182b;
    }

    public void m() {
        d b11 = b();
        if (b11 == null || b11.h() <= 1) {
            h();
            return;
        }
        this.f52182b--;
        if (b() != null) {
            b().k();
        }
    }

    public void n() {
        if (i() != null && i().f().size() > 0) {
            VisualUserStep visualUserStep = (VisualUserStep) i().f().getLast();
            if (visualUserStep.getStepType() != null && visualUserStep.getStepType().equals(StepType.TAP)) {
                i().l();
                this.f52182b--;
            }
        }
    }

    private boolean b(d dVar, VisualUserStep visualUserStep) {
        VisualUserStep c11;
        if (dVar == null || (c11 = dVar.c()) == null || visualUserStep == null || c11.getView() == null || visualUserStep.getView() == null || !c11.getView().replace("\"", "").equals(visualUserStep.getView()) || c11.getStepType() == null || !c11.getStepType().equals(StepType.START_EDITING) || c11.getScreenName() == null || visualUserStep.getScreenName() == null || !c11.getScreenName().equals(visualUserStep.getScreenName())) {
            return false;
        }
        return true;
    }

    public void c(int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            h();
        }
    }

    @SuppressLint({"CheckResult"})
    private void b(@Nullable String str) {
        c(str).subscribeOn(Schedulers.io()).subscribe(new a());
    }

    @SuppressLint({"CheckResult"})
    public void a() {
        String[] strArr = new String[1];
        Observable.fromCallable(new n(this, strArr)).subscribeOn(Schedulers.io()).subscribe(new m(this, strArr));
    }
}
