package com.instabug.chat.ui.chat;

import com.instabug.chat.eventbus.c;
import io.reactivex.functions.Consumer;

class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f46227b;

    public k(l lVar) {
        this.f46227b = lVar;
    }

    /* renamed from: a */
    public void accept(c cVar) {
        if (this.f46227b.f46231d.getId().equals(cVar.b())) {
            this.f46227b.f46231d.setId(cVar.a());
        }
    }
}
