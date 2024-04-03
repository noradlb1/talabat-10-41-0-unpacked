package com.instabug.survey.ui.popup;

import com.google.android.play.core.review.ReviewInfo;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.a;

class o implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f52543a;

    public o(q qVar) {
        this.f52543a = qVar;
    }

    public void a(ReviewInfo reviewInfo) {
        this.f52543a.f52545g = reviewInfo;
        InstabugSDKLogger.d("IBG-Surveys", "Google Play In-app review task succeeded");
    }

    public void onFailure(Exception exc) {
        InstabugSDKLogger.e("IBG-Surveys", "Requesting Google Play In-app review failed", exc);
    }
}
