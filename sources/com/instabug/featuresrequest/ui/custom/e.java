package com.instabug.featuresrequest.ui.custom;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class e extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f46703a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f46704b;

    public e(q qVar, int i11) {
        this.f46704b = qVar;
        this.f46703a = i11;
    }

    public void onAnimationEnd(View view) {
        this.f46704b.d(this.f46703a);
    }

    public void onAnimationStart(View view) {
        this.f46704b.f46719c.b(0, 180);
    }
}
