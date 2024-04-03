package com.instabug.bug.view.reporting;

import android.graphics.Rect;
import android.view.ViewTreeObserver;

class q implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f45909b;

    public q(x xVar) {
        this.f45909b = xVar;
    }

    public void onGlobalLayout() {
        int i11;
        if (this.f45909b.getActivity() != null && this.f45909b.F != null) {
            Rect rect = new Rect();
            this.f45909b.getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = this.f45909b.getActivity().getWindow().getDecorView().getRootView().getHeight();
            if (((double) (height - rect.bottom)) > ((double) height) * 0.15d) {
                boolean unused = this.f45909b.f45935s = true;
                i11 = 4;
                if (this.f45909b.f45932p != null) {
                    this.f45909b.f45932p.setState(4);
                }
                boolean unused2 = this.f45909b.f45936t = true;
                if (this.f45909b.f45933q == null) {
                    return;
                }
            } else {
                i11 = 0;
                boolean unused3 = this.f45909b.f45936t = false;
                boolean unused4 = this.f45909b.f45935s = false;
                if (this.f45909b.f45934r <= 1 || this.f45909b.f45933q == null) {
                    return;
                }
            }
            this.f45909b.f45933q.setVisibility(i11);
        }
    }
}
