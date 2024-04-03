package com.instabug.terminations;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.terminations.di.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class c0 extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SDKCoreEvent f52596g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ i0 f52597h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c0(SDKCoreEvent sDKCoreEvent, i0 i0Var) {
        super(0);
        this.f52596g = sDKCoreEvent;
        this.f52597h = i0Var;
    }

    public final void a() {
        d.f52610a.r().a(this.f52596g.getValue());
        this.f52597h.d();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
