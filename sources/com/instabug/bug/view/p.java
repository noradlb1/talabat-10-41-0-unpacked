package com.instabug.bug.view;

import android.view.View;

class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f45865b;

    public p(q qVar) {
        this.f45865b = qVar;
    }

    public void onClick(View view) {
        if (this.f45865b.getActivity() != null) {
            this.f45865b.getActivity().finish();
        }
    }
}
