package com.instabug.library.util.threading;

public final class h extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f52111b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Runnable runnable, i iVar) {
        super(runnable);
        this.f52111b = iVar;
    }

    public void interrupt() {
        super.interrupt();
    }

    public void run() {
        i iVar = this.f52111b;
        iVar.rename(this, iVar.getIdentifier());
        super.run();
    }
}
