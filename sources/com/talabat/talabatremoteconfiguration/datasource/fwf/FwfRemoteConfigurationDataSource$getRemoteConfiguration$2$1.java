package com.talabat.talabatremoteconfiguration.datasource.fwf;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FwfRemoteConfigurationDataSource$getRemoteConfiguration$2$1 extends Lambda implements Function1<Object, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Continuation<T> f12128g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FwfRemoteConfigurationDataSource f12129h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ T f12130i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Class<T> f12131j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FwfRemoteConfigurationDataSource$getRemoteConfiguration$2$1(Continuation<? super T> continuation, FwfRemoteConfigurationDataSource fwfRemoteConfigurationDataSource, T t11, Class<T> cls) {
        super(1);
        this.f12128g = continuation;
        this.f12129h = fwfRemoteConfigurationDataSource;
        this.f12130i = t11;
        this.f12131j = cls;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        Continuation<T> continuation = this.f12128g;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(this.f12129h.getParser().getTheVariationValue(obj, this.f12130i, this.f12131j)));
    }
}
