package com.instabug.library.util.threading;

import kotlin.jvm.functions.Function1;

public final class g extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f52109b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f52110c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Runnable runnable, i iVar, Function1 function1) {
        super(runnable);
        this.f52109b = iVar;
        this.f52110c = function1;
    }

    public void interrupt() {
        super.interrupt();
        this.f52110c.invoke(this);
    }

    public void run() {
        i iVar = this.f52109b;
        iVar.rename(this, iVar.getIdentifier());
        super.run();
    }
}
