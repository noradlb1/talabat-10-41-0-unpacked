package com.google.android.play.integrity.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class u implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f44588a;

    public /* synthetic */ u(v vVar, t tVar) {
        this.f44588a = vVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f44588a.f44591c.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        v vVar = this.f44588a;
        vVar.c().post(new r(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f44588a.f44591c.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        v vVar = this.f44588a;
        vVar.c().post(new s(this));
    }
}
