package com.instabug.bug.view.reporting;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class s extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f45911c;

    public s(x xVar, String str) {
        this.f45911c = str;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setText(this.f45911c);
        accessibilityNodeInfoCompat.setShowingHintText(true);
    }
}
