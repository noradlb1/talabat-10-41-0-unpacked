package com.google.android.play.core.integrity;

import android.content.Context;

final class h implements k {

    /* renamed from: a  reason: collision with root package name */
    private Context f44544a;

    private h() {
    }

    public /* synthetic */ h(g gVar) {
    }

    public final h a(Context context) {
        context.getClass();
        this.f44544a = context;
        return this;
    }

    public final j b() {
        Context context = this.f44544a;
        if (context != null) {
            return new j(context, (i) null);
        }
        throw new IllegalStateException(String.valueOf(Context.class.getCanonicalName()).concat(" must be set"));
    }
}
