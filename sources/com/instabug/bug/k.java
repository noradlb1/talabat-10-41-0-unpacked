package com.instabug.bug;

import android.content.Context;
import com.instabug.bug.model.d;
import com.instabug.bug.testingreport.a;
import com.instabug.library.internal.orchestrator.Action;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.model.Report;
import com.instabug.library.model.State;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.ReportHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.io.IOException;
import org.json.JSONException;

class k implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f45646a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f45647b;

    public k(n nVar, Context context) {
        this.f45647b = nVar;
        this.f45646a = context;
    }

    public void run() {
        String str;
        d a11 = this.f45647b.f45683a;
        if (a11 != null) {
            SettingsManager instance = SettingsManager.getInstance();
            if (instance.getOnReportCreatedListener() != null) {
                Report report = new Report();
                try {
                    instance.getOnReportCreatedListener().onReportCreated(report);
                } catch (Exception e11) {
                    InstabugSDKLogger.e("IBG-BR", "Exception occurred in report Submit Handler ", e11);
                }
                if (n.e().c() != null) {
                    ReportHelper.update(n.e().c().getState(), report);
                }
            }
            this.f45647b.a(this.f45646a);
            this.f45647b.c(this.f45646a);
            AttachmentsUtility.encryptAttachments(a11.a());
            this.f45647b.m();
            this.f45647b.a(o.SUBMIT);
            try {
                State state = a11.getState();
                if (state != null) {
                    this.f45647b.a(this.f45646a, state);
                } else {
                    a11.setState(new State.Builder(this.f45646a).build(true));
                }
                this.f45647b.k();
            } catch (JSONException e12) {
                e = e12;
                str = "Error while committing bug: ";
                InstabugSDKLogger.e("IBG-BR", str, e);
                a.f45789a.postError(e);
                AndroidSchedulers.mainThread().scheduleDirect(new j(this));
            } catch (IOException e13) {
                e = e13;
                str = "IOException while committing bug";
                InstabugSDKLogger.e("IBG-BR", str, e);
                a.f45789a.postError(e);
                AndroidSchedulers.mainThread().scheduleDirect(new j(this));
            }
            AndroidSchedulers.mainThread().scheduleDirect(new j(this));
        }
    }
}
