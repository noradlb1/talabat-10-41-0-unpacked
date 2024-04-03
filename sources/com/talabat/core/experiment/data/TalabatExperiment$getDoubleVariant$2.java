package com.talabat.core.experiment.data;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatExperiment$getDoubleVariant$2 extends Lambda implements Function1<Double, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Double, Unit> f55845g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatExperiment$getDoubleVariant$2(Function1<? super Double, Unit> function1) {
        super(1);
        this.f55845g = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).doubleValue());
        return Unit.INSTANCE;
    }

    public final void invoke(double d11) {
        this.f55845g.invoke(Double.valueOf(d11));
    }
}
