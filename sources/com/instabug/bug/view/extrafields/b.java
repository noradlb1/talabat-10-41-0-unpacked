package com.instabug.bug.view.extrafields;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.bug.model.e;
import java.util.List;

class b extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f45825c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f45826d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f45827e;

    public b(d dVar, List list, int i11) {
        this.f45827e = dVar;
        this.f45825c = list;
        this.f45826d = i11;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        List list = this.f45825c;
        if (list != null) {
            accessibilityNodeInfoCompat.setText(this.f45827e.getString(((e) list.get(this.f45826d)).a()));
            accessibilityNodeInfoCompat.setShowingHintText(true);
        }
    }
}
