package com.huawei.location.tiles.store;

class E5 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ dC f50244b;

    public E5(dC dCVar) {
        this.f50244b = dCVar;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        currentThread.setName("SDM-TileStoreManager-" + hashCode());
        dC.a(this.f50244b);
    }
}
