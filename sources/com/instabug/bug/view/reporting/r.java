package com.instabug.bug.view.reporting;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.bug.R;

class r extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ x f45910c;

    public r(x xVar) {
        this.f45910c = xVar;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setContentDescription(this.f45910c.getLocalizedString(R.string.ibg_bug_report_add_attachment_content_description));
    }
}
