package com.instabug.chat.ui.chat;

import android.view.View;
import android.widget.ImageView;
import com.instabug.chat.R;
import com.instabug.chat.model.e;
import com.instabug.chat.model.g;

class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f46245b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f46246c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g0 f46247d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h0 f46248e;

    public s(h0 h0Var, g gVar, String str, g0 g0Var) {
        this.f46248e = h0Var;
        this.f46245b = gVar;
        this.f46246c = str;
        this.f46247d = g0Var;
    }

    public void onClick(View view) {
        ImageView imageView;
        int i11;
        e d11 = this.f46245b.d();
        e eVar = e.f46028a;
        if (d11 == eVar) {
            this.f46248e.f46215a.start(this.f46246c);
            this.f46245b.a(e.PLAYING);
            imageView = this.f46247d.f46207f;
            if (imageView != null) {
                i11 = R.drawable.ibg_core_ic_pause;
            } else {
                return;
            }
        } else {
            this.f46248e.f46215a.pause();
            this.f46245b.a(eVar);
            imageView = this.f46247d.f46207f;
            if (imageView != null) {
                i11 = R.drawable.ibg_core_ic_play;
            } else {
                return;
            }
        }
        imageView.setImageResource(i11);
    }
}
