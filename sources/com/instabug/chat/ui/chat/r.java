package com.instabug.chat.ui.chat;

import android.view.View;
import com.instabug.chat.model.g;

class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f46243b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h0 f46244c;

    public r(h0 h0Var, g gVar) {
        this.f46244c = h0Var;
        this.f46243b = gVar;
    }

    public void onClick(View view) {
        f0 b11;
        String h11;
        if (this.f46244c.f46220f != null) {
            if (this.f46243b.e() != null) {
                b11 = this.f46244c.f46220f;
                h11 = this.f46243b.e();
            } else if (this.f46243b.h() != null) {
                b11 = this.f46244c.f46220f;
                h11 = this.f46243b.h();
            } else {
                return;
            }
            b11.a(h11);
        }
    }
}
