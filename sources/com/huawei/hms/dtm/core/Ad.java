package com.huawei.hms.dtm.core;

import android.view.View;

public class Ad extends C0426qd {
    public static Ad c() {
        return new Ad();
    }

    public void a() {
        Ed.d().a(true);
    }

    public void a(View view) {
        if (view == this.f48547b) {
            a();
            dismiss();
            Ed.d().b();
        } else if (view == this.f48548c) {
            a();
            dismiss();
        }
    }

    public void b() {
        this.f48548c.setText(J.a(R.string.dtm_visual_dialog_button_cancel));
        this.f48547b.setText(J.a(R.string.dtm_visual_dialog_button_confirm));
        this.f48546a.setText(J.a(R.string.dtm_visual_dialog_message));
    }
}
