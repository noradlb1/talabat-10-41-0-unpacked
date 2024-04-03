package com.instabug.chat.screenrecording;

import com.instabug.chat.eventbus.c;
import io.reactivex.functions.Consumer;

class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f46146b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f46147c;

    public b(c cVar, String str) {
        this.f46147c = cVar;
        this.f46146b = str;
    }

    /* renamed from: a */
    public void accept(c cVar) {
        if (this.f46146b.equalsIgnoreCase(cVar.b())) {
            this.f46147c.b(cVar.a());
        }
    }
}
