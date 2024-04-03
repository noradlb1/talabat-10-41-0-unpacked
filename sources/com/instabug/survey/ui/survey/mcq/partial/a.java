package com.instabug.survey.ui.survey.mcq.partial;

import android.widget.AbsListView;

class a implements AbsListView.OnScrollListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f52578b;

    public a(b bVar) {
        this.f52578b = bVar;
    }

    public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i11) {
        if (this.f52578b.L != null && i11 == 1) {
            b bVar = this.f52578b;
            bVar.l0(bVar.L, false);
        }
    }
}
