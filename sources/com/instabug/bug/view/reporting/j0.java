package com.instabug.bug.view.reporting;

import android.view.animation.Animation;
import com.instabug.bug.view.reporting.ReportingContainerActivity;

class j0 implements Animation.AnimationListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReportingContainerActivity.b f45901b;

    public j0(ReportingContainerActivity.b bVar) {
        this.f45901b = bVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.f45901b.f45872c.setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
