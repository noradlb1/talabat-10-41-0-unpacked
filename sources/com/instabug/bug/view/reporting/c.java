package com.instabug.bug.view.reporting;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

class c extends BottomSheetBehavior.BottomSheetCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x f45877a;

    public c(x xVar) {
        this.f45877a = xVar;
    }

    public void onSlide(@NonNull View view, float f11) {
    }

    public void onStateChanged(@NonNull View view, int i11) {
        if (this.f45877a.f45932p != null) {
            this.f45877a.f45932p.setState(4);
        }
    }
}
