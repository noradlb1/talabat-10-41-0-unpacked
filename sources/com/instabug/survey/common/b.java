package com.instabug.survey.common;

import android.app.Activity;
import android.content.Intent;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.h;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.utils.j;

class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f52317b;

    public b(c cVar) {
        this.f52317b = cVar;
    }

    public void run() {
        c cVar = this.f52317b;
        if (!cVar.f52319c.a(cVar.f52318b.getId())) {
            String simpleName = d.class.getSimpleName();
            InstabugSDKLogger.w(simpleName, "this survey " + this.f52317b.f52318b.getId() + " is answered and outdated");
            return;
        }
        Activity targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
        if (targetActivity != null && h.e() != null) {
            h.e().m();
            j.b();
            if (this.f52317b.f52318b.isOptInSurvey() && this.f52317b.f52318b.getSurveyEvents() != null && this.f52317b.f52318b.getSurveyEvents().size() > 0 && !this.f52317b.f52318b.isLastEventDismiss()) {
                this.f52317b.f52318b.clearAnswers();
            }
            this.f52317b.f52319c.b(true);
            this.f52317b.f52318b.addShowEvent();
            Intent intent = new Intent(targetActivity, SurveyActivity.class);
            intent.putExtra("survey", this.f52317b.f52318b);
            targetActivity.startActivity(intent);
            targetActivity.overridePendingTransition(0, 0);
        }
    }
}
