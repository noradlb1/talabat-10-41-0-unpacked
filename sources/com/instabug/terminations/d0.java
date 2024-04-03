package com.instabug.terminations;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

final /* synthetic */ class d0 extends FunctionReferenceImpl implements Function0 {
    public d0(Object obj) {
        super(0, obj, i0.class, "handleTerminationStateChanged", "handleTerminationStateChanged()V", 0);
    }

    public final void a() {
        ((i0) this.receiver).d();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
