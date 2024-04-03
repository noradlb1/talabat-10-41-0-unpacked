package com.huawei.hms.dtm.core;

import android.view.View;

/* renamed from: com.huawei.hms.dtm.core.wd  reason: case insensitive filesystem */
public class C0456wd extends C0426qd {
    public static C0456wd c() {
        return new C0456wd();
    }

    public void a() {
        Jc.b().a(true);
    }

    public void a(View view) {
        if (view == this.f48547b) {
            a();
            dismiss();
            DynamicTagManager.getInstance().preview((String) null);
        } else if (view == this.f48548c) {
            a();
            dismiss();
        }
    }

    public void b() {
        this.f48548c.setText(J.a(R.string.dtm_visual_dialog_button_cancel));
        this.f48547b.setText(J.a(R.string.dtm_preview_dialog_button_confirm));
        this.f48546a.setText(J.a(R.string.dtm_preview_float_dialog_message));
    }
}
