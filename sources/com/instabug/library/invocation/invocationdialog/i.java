package com.instabug.library.invocation.invocationdialog;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.library.R;

class i extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f51301c;

    public i(l lVar) {
        this.f51301c = lVar;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(4096, this.f51301c.getLocalizedString(R.string.ibg_prompt_options_list_view_scroll_description)));
    }
}
