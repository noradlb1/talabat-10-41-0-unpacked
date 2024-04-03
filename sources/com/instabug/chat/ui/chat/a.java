package com.instabug.chat.ui.chat;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class a extends AccessibilityDelegateCompat {
    public a(c cVar) {
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setImportantForAccessibility(true);
    }
}
