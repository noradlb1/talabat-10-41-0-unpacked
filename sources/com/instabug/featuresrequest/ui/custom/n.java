package com.instabug.featuresrequest.ui.custom;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class n extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f46713a;

    public n(q qVar) {
        this.f46713a = qVar;
    }

    public void onAnimationEnd(View view) {
        p unused = this.f46713a.f46721e;
        t.c().f(this.f46713a.f46722f);
    }

    public void onAnimationStart(View view) {
        this.f46713a.f46719c.a(70, 180);
    }
}
