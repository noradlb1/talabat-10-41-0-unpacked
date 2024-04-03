package com.instabug.library;

import com.instabug.library.util.threading.PoolProvider;

class x implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f50599b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c0 f50600c;

    public x(c0 c0Var, boolean z11) {
        this.f50600c = c0Var;
        this.f50599b = z11;
    }

    public void run() {
        if (this.f50599b) {
            this.f50600c.f50535c.d();
        }
        PoolProvider.postIOTask(new w(this));
    }
}
