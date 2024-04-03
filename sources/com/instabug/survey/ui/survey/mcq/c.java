package com.instabug.survey.ui.survey.mcq;

import android.content.res.Resources;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.library.util.ResourcesUtils;
import com.instabug.survey.R;

class c extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f52567c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f52568d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ f f52569e;

    public c(f fVar, int i11, boolean z11) {
        this.f52569e = fVar;
        this.f52567c = i11;
        this.f52568d = z11;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        Resources resources = view.getResources();
        String selectedText = ResourcesUtils.getSelectedText(resources, this.f52568d);
        String c11 = this.f52569e.a(resources, this.f52567c + 1, selectedText, this.f52567c);
        accessibilityNodeInfoCompat.setImportantForAccessibility(true);
        accessibilityNodeInfoCompat.setText(c11);
        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, resources.getString(R.string.ib_action_select)));
    }
}
