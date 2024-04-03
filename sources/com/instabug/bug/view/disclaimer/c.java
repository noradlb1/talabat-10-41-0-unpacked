package com.instabug.bug.view.disclaimer;

import android.view.View;
import android.widget.AdapterView;

class c implements AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f45817b;

    public c(d dVar) {
        this.f45817b = dVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
        h hVar = this.f45817b.H;
        if (hVar != null) {
            a a11 = hVar.getItem(i11);
            if (a11.c()) {
                this.f45817b.a(a11);
            }
        }
    }
}
