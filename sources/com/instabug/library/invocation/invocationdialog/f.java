package com.instabug.library.invocation.invocationdialog;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class f extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InstabugDialogItem f51294c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h f51295d;

    public f(h hVar, InstabugDialogItem instabugDialogItem) {
        this.f51295d = hVar;
        this.f51294c = instabugDialogItem;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setContentDescription(this.f51295d.a(this.f51294c));
    }
}
