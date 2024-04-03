package com.talabat.feature.subscriptions.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase", f = "GetSubscriptionCancellationReasonsUseCase.kt", i = {}, l = {13}, m = "invoke", n = {}, s = {})
public final class GetSubscriptionCancellationReasonsUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58988h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetSubscriptionCancellationReasonsUseCase f58989i;

    /* renamed from: j  reason: collision with root package name */
    public int f58990j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetSubscriptionCancellationReasonsUseCase$invoke$1(GetSubscriptionCancellationReasonsUseCase getSubscriptionCancellationReasonsUseCase, Continuation<? super GetSubscriptionCancellationReasonsUseCase$invoke$1> continuation) {
        super(continuation);
        this.f58989i = getSubscriptionCancellationReasonsUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58988h = obj;
        this.f58990j |= Integer.MIN_VALUE;
        return this.f58989i.invoke(this);
    }
}
