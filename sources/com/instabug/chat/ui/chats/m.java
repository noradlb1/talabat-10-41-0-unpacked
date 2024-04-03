package com.instabug.chat.ui.chats;

import android.content.Context;
import com.instabug.chat.model.d;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f46280b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f46281c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f46282d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c f46283e;

    public /* synthetic */ m(d dVar, d dVar2, Context context, c cVar) {
        this.f46280b = dVar;
        this.f46281c = dVar2;
        this.f46282d = context;
        this.f46283e = cVar;
    }

    public final void run() {
        this.f46280b.a(this.f46281c, this.f46282d, this.f46283e);
    }
}
