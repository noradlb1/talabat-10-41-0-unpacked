package com.instabug.featuresrequest.ui.custom;

class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f46730b;

    public u(v vVar) {
        this.f46730b = vVar;
    }

    public void run() {
        if (this.f46730b.isResumed() && this.f46730b.isAdded()) {
            this.f46730b.dismiss();
        }
    }
}
