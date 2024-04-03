package com.instabug.bug.view;

import android.app.Activity;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.bug.R;
import com.instabug.library.util.KeyboardUtils;

class a extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f45799c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ j f45800d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f45801e;

    public a(l lVar, String str, j jVar) {
        this.f45801e = lVar;
        this.f45799c = str;
        this.f45800d = jVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, boolean z11) {
        if (z11) {
            KeyboardUtils.hide((Activity) this.f45801e.f45861g);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setContentDescription(this.f45799c);
        accessibilityNodeInfoCompat.setRoleDescription("");
        view.setOnFocusChangeListener(new r(this));
        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, this.f45801e.a(R.string.ibg_bug_report_attachment_edit_content_description, this.f45800d.itemView.getContext())));
    }
}
