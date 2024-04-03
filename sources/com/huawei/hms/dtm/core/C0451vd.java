package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.dtm.core.util.f;

/* renamed from: com.huawei.hms.dtm.core.vd  reason: case insensitive filesystem */
public class C0451vd extends C0436sd {
    public C0451vd(Activity activity) {
        super(activity);
        this.f48587a.setId(R.id.dtm_preview_control_button_id);
        this.f48587a.setImageResource(R.mipmap.dtm_preview_control_button);
        this.f48587a.setContentDescription(J.a(R.string.dtm_preview_control_button_description));
    }

    /* access modifiers changed from: private */
    public View b(ViewGroup viewGroup) {
        return viewGroup.findViewById(R.id.dtm_preview_control_button_id);
    }

    /* access modifiers changed from: private */
    public boolean c(ViewGroup viewGroup) {
        return b(viewGroup) != null;
    }

    public void a() {
        ViewGroup viewGroup;
        Activity activity = this.f48588b;
        if (activity != null && (viewGroup = (ViewGroup) f.a(activity)) != null) {
            this.f48588b.runOnUiThread(new C0446ud(this, viewGroup));
        }
    }

    public void a(int i11) {
    }

    public void a(ViewGroup viewGroup) {
        viewGroup.post(new C0441td(this, viewGroup));
    }

    public void c() {
        if (this.f48589c == null) {
            this.f48589c = C0456wd.c();
        }
        this.f48589c.show(this.f48588b.getFragmentManager(), "previewDialog");
        Jc.b().a(false);
    }
}
