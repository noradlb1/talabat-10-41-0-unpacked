package com.instabug.bug.view.reporting;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f45890b;

    public g(x xVar) {
        this.f45890b = xVar;
    }

    public void run() {
        BottomSheetBehavior bottomSheetBehavior;
        if (this.f45890b.f45923f != null && this.f45890b.f45932p != null) {
            int i11 = 4;
            if (this.f45890b.f45932p.getState() == 4) {
                this.f45890b.f45923f.setVisibility(8);
                bottomSheetBehavior = this.f45890b.f45932p;
                i11 = 3;
            } else {
                bottomSheetBehavior = this.f45890b.f45932p;
            }
            bottomSheetBehavior.setState(i11);
        }
    }
}
