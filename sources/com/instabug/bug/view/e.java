package com.instabug.bug.view;

import android.app.Activity;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.bug.R;
import com.instabug.library.util.KeyboardUtils;

class e extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f45822c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f45823d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f45824e;

    public e(l lVar, String str, k kVar) {
        this.f45824e = lVar;
        this.f45822c = str;
        this.f45823d = kVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, boolean z11) {
        if (z11) {
            KeyboardUtils.hide((Activity) this.f45824e.f45861g);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setContentDescription(this.f45822c);
        accessibilityNodeInfoCompat.setRoleDescription("");
        view.setOnFocusChangeListener(new s(this));
        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, this.f45823d.itemView.getContext().getString(R.string.ibg_bug_report_video_play_content_description)));
    }
}
