package com.talabat.feature.rating.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl", f = "ShouldRateLastOrderUseCaseImpl.kt", i = {}, l = {28}, m = "getLastOrder", n = {}, s = {})
public final class ShouldRateLastOrderUseCaseImpl$getLastOrder$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58685h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ShouldRateLastOrderUseCaseImpl f58686i;

    /* renamed from: j  reason: collision with root package name */
    public int f58687j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShouldRateLastOrderUseCaseImpl$getLastOrder$1(ShouldRateLastOrderUseCaseImpl shouldRateLastOrderUseCaseImpl, Continuation<? super ShouldRateLastOrderUseCaseImpl$getLastOrder$1> continuation) {
        super(continuation);
        this.f58686i = shouldRateLastOrderUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58685h = obj;
        this.f58687j |= Integer.MIN_VALUE;
        return this.f58686i.getLastOrder(this);
    }
}
