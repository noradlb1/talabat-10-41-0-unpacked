package com.instabug.featuresrequest.ui.custom;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;

class j implements SwipeDismissBehavior.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f46709a;

    public j(q qVar) {
        this.f46709a = qVar;
    }

    public void onDismiss(View view) {
        this.f46709a.b(0);
    }

    public void onDragStateChanged(int i11) {
        if (i11 == 0) {
            t.c().g(this.f46709a.f46722f);
        } else if (i11 == 1 || i11 == 2) {
            t.c().a(this.f46709a.f46722f);
        }
    }
}
