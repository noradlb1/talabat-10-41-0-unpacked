package com.instabug.survey.network.service;

import androidx.annotation.Nullable;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.cache.l;
import com.instabug.survey.models.Survey;

class a implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Survey f52412a;

    public a(Survey survey) {
        this.f52412a = survey;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        c.b(this.f52412a);
        l.c(this.f52412a);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Surveys", "Submitting surveys got error: " + th2.getMessage());
    }
}
