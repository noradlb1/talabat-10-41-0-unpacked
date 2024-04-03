package com.talabat.core.experiment.data.datasource;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FwfExperimentDataSource$getIntVariant$3$1 extends Lambda implements Function1<Object, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Continuation<Integer> f55857g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f55858h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FwfExperimentDataSource$getIntVariant$3$1(Continuation<? super Integer> continuation, int i11) {
        super(1);
        this.f55857g = continuation;
        this.f55858h = i11;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        Continuation<Integer> continuation = this.f55857g;
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        continuation.resumeWith(Result.m6329constructorimpl(Integer.valueOf(num != null ? num.intValue() : this.f55858h)));
    }
}
