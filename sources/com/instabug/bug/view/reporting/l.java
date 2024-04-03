package com.instabug.bug.view.reporting;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.bug.R;

class l extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f45903c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ x f45904d;

    public l(x xVar, String str) {
        this.f45904d = xVar;
        this.f45903c = str;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setContentDescription(this.f45903c);
        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, this.f45904d.getLocalizedString(R.string.ibg_bug_report_visual_steps_disclaimer_action_description)));
    }
}
