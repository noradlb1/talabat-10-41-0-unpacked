package com.instabug.survey.ui;

import android.os.Bundle;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.models.Survey;

class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f52434b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f52435c;

    public a(g gVar, Bundle bundle) {
        this.f52435c = gVar;
        this.f52434b = bundle;
    }

    public void run() {
        Survey survey;
        if (InstabugCore.getStartedActivitiesCount() <= 1) {
            InstabugSDKLogger.d("IBG-Surveys", "Survey Error: StartedActivitiesCount <= 1");
            this.f52435c.finish();
            return;
        }
        try {
            if (!this.f52435c.isFinishing()) {
                g gVar = this.f52435c;
                if (!gVar.f52509j) {
                    gVar.finish();
                } else if (this.f52434b != null) {
                } else {
                    if (gVar.f34199i == null || !((l) this.f52435c.f34199i).c() || (survey = this.f52435c.f52512m) == null || survey.getType() == 2) {
                        g gVar2 = this.f52435c;
                        Survey survey2 = gVar2.f52512m;
                        if (survey2 != null) {
                            j.a(gVar2.getSupportFragmentManager(), survey2);
                            return;
                        }
                        return;
                    }
                    g gVar3 = this.f52435c;
                    gVar3.i(gVar3.f52512m);
                }
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Surveys", "Survey has not been shown due to this error: " + e11.getMessage());
            this.f52435c.finish();
        }
    }
}
