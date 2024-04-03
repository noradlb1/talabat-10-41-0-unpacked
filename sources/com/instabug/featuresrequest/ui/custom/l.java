package com.instabug.featuresrequest.ui.custom;

import android.view.View;
import com.instabug.featuresrequest.ui.custom.SnackbarLayout;

class l implements SnackbarLayout.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f46711a;

    public l(q qVar) {
        this.f46711a = qVar;
    }

    public void a(View view) {
    }

    public void b(View view) {
        if (this.f46711a.f()) {
            q.f46716h.post(new k(this));
        }
    }
}
