package com.instabug.featuresrequest.ui.base.featureslist;

import android.widget.AbsListView;

class g implements AbsListView.OnScrollListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f46640b;

    public g(h hVar) {
        this.f46640b = hVar;
    }

    public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
        int i14 = i11 + i12;
        if (i13 > 0 && i14 == i13 && !this.f46640b.f46648k) {
            boolean unused = this.f46640b.f46648k = true;
            if (this.f46640b.C != null) {
                ((n) this.f46640b.C).g();
            }
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i11) {
    }
}
