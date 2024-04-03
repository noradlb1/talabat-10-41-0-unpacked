package com.talabat.core.experiment.data.datasource;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FwfExperimentDataSource$getBooleanVariant$1 extends Lambda implements Function1<Object, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f55851g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f55852h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FwfExperimentDataSource$getBooleanVariant$1(Function1<? super Boolean, Unit> function1, boolean z11) {
        super(1);
        this.f55851g = function1;
        this.f55852h = z11;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        Function1<Boolean, Unit> function1 = this.f55851g;
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        function1.invoke(Boolean.valueOf(bool != null ? bool.booleanValue() : this.f55852h));
    }
}
