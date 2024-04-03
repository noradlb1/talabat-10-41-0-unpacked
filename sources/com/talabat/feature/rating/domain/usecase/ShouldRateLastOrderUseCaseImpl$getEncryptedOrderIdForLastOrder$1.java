package com.talabat.feature.rating.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl", f = "ShouldRateLastOrderUseCaseImpl.kt", i = {0}, l = {18}, m = "getEncryptedOrderIdForLastOrder", n = {"this"}, s = {"L$0"})
public final class ShouldRateLastOrderUseCaseImpl$getEncryptedOrderIdForLastOrder$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58681h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58682i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ShouldRateLastOrderUseCaseImpl f58683j;

    /* renamed from: k  reason: collision with root package name */
    public int f58684k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShouldRateLastOrderUseCaseImpl$getEncryptedOrderIdForLastOrder$1(ShouldRateLastOrderUseCaseImpl shouldRateLastOrderUseCaseImpl, Continuation<? super ShouldRateLastOrderUseCaseImpl$getEncryptedOrderIdForLastOrder$1> continuation) {
        super(continuation);
        this.f58683j = shouldRateLastOrderUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58682i = obj;
        this.f58684k |= Integer.MIN_VALUE;
        return this.f58683j.getEncryptedOrderIdForLastOrder(this);
    }
}
