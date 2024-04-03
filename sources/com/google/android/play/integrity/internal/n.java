package com.google.android.play.integrity.internal;

import android.os.IBinder;

public final /* synthetic */ class n implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v f44581a;

    public /* synthetic */ n(v vVar) {
        this.f44581a = vVar;
    }

    public final void binderDied() {
        v.h(this.f44581a);
    }
}
