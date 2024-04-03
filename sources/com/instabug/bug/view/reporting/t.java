package com.instabug.bug.view.reporting;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class t extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h0 f45912c;

    public t(x xVar, h0 h0Var) {
        this.f45912c = h0Var;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        h0 h0Var = this.f45912c;
        if (h0Var != null) {
            accessibilityNodeInfoCompat.setText(h0Var.a());
        }
        accessibilityNodeInfoCompat.setShowingHintText(true);
    }
}
