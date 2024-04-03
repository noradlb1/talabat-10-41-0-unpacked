package com.google.android.play.integrity.internal;

final class p extends l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f44584a;

    public p(v vVar) {
        this.f44584a = vVar;
    }

    public final void b() {
        v vVar = this.f44584a;
        if (vVar.f44602n != null) {
            vVar.f44591c.d("Unbind from service.", new Object[0]);
            v vVar2 = this.f44584a;
            vVar2.f44590b.unbindService(vVar2.f44601m);
            this.f44584a.f44596h = false;
            this.f44584a.f44602n = null;
            this.f44584a.f44601m = null;
        }
        this.f44584a.t();
    }
}
