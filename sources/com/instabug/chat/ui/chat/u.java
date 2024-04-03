package com.instabug.chat.ui.chat;

import android.view.View;
import com.instabug.chat.model.g;

class u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f46251b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h0 f46252c;

    public u(h0 h0Var, g gVar) {
        this.f46252c = h0Var;
        this.f46251b = gVar;
    }

    public void onClick(View view) {
        if (this.f46252c.f46220f != null && this.f46251b.e() != null) {
            this.f46252c.f46220f.b(this.f46251b.e());
        }
    }
}
