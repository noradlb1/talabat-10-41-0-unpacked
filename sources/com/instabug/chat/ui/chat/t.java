package com.instabug.chat.ui.chat;

import android.widget.ImageView;
import com.instabug.chat.R;
import com.instabug.chat.model.e;
import com.instabug.chat.model.g;
import com.instabug.library.internal.media.AudioPlayer;

class t extends AudioPlayer.OnStopListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f46249a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g0 f46250b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(h0 h0Var, String str, g gVar, g0 g0Var) {
        super(str);
        this.f46249a = gVar;
        this.f46250b = g0Var;
    }

    public void onStop() {
        this.f46249a.a(e.f46028a);
        ImageView imageView = this.f46250b.f46207f;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ibg_core_ic_play);
        }
    }
}
