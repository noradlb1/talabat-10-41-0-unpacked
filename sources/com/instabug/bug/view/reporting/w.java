package com.instabug.bug.view.reporting;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.instabug.library.util.AccessibilityUtils;

class w extends BottomSheetBehavior.BottomSheetCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f45916a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f45917b;

    public w(x xVar, ImageView imageView) {
        this.f45917b = xVar;
        this.f45916a = imageView;
    }

    public void onSlide(@NonNull View view, float f11) {
        ImageView imageView;
        AccessibilityDelegateCompat M0;
        ImageView imageView2 = this.f45916a;
        if (imageView2 != null) {
            imageView2.setRotation((1.0f - f11) * 180.0f);
            if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
                if (f11 == 0.0f) {
                    imageView = this.f45916a;
                    M0 = this.f45917b.B;
                } else if (f11 == 1.0f) {
                    imageView = this.f45916a;
                    M0 = this.f45917b.A;
                } else {
                    return;
                }
                ViewCompat.setAccessibilityDelegate(imageView, M0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStateChanged(@androidx.annotation.NonNull android.view.View r5, int r6) {
        /*
            r4 = this;
            com.instabug.bug.view.reporting.x r5 = r4.f45917b
            android.widget.ScrollView r5 = r5.G
            if (r5 == 0) goto L_0x0056
            r5 = 2
            if (r6 != r5) goto L_0x000a
            goto L_0x0056
        L_0x000a:
            int unused = com.instabug.bug.view.reporting.x.D = r6
            r5 = 4
            r0 = 0
            if (r6 != r5) goto L_0x0022
            com.instabug.bug.view.reporting.x r1 = r4.f45917b
            android.widget.ScrollView r1 = r1.G
            android.content.Context r2 = com.instabug.library.Instabug.getApplicationContext()
            r3 = 0
        L_0x001a:
            int r2 = com.instabug.library.view.ViewUtils.convertDpToPx(r2, r3)
            r1.setPadding(r0, r0, r0, r2)
            goto L_0x0030
        L_0x0022:
            r1 = 3
            if (r6 != r1) goto L_0x0030
            com.instabug.bug.view.reporting.x r1 = r4.f45917b
            android.widget.ScrollView r1 = r1.G
            android.content.Context r2 = com.instabug.library.Instabug.getApplicationContext()
            r3 = 1124204544(0x43020000, float:130.0)
            goto L_0x001a
        L_0x0030:
            r0 = 1
            if (r6 != r0) goto L_0x003b
            com.instabug.bug.view.reporting.x r0 = r4.f45917b
            boolean r0 = r0.f45936t
            if (r0 != 0) goto L_0x0043
        L_0x003b:
            com.instabug.bug.view.reporting.x r0 = r4.f45917b
            boolean r0 = r0.f45935s
            if (r0 == 0) goto L_0x0049
        L_0x0043:
            com.instabug.bug.view.reporting.x r5 = r4.f45917b
            r5.y()
            return
        L_0x0049:
            if (r6 != r5) goto L_0x0051
            com.instabug.bug.view.reporting.x r5 = r4.f45917b
            r5.y()
            goto L_0x0056
        L_0x0051:
            com.instabug.bug.view.reporting.x r5 = r4.f45917b
            r5.G()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.view.reporting.w.onStateChanged(android.view.View, int):void");
    }
}
