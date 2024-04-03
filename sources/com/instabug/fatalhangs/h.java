package com.instabug.fatalhangs;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class h extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i f46473g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(i iVar) {
        super(0);
        this.f46473g = iVar;
    }

    public final void a() {
        this.f46473g.d().set(0);
        this.f46473g.a().set(false);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
