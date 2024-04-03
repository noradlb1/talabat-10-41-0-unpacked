package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase", f = "GetActiveSubscriptionsUseCase.kt", i = {0}, l = {19}, m = "invoke", n = {"this"}, s = {"L$0"})
public final class GetActiveSubscriptionsUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58984h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58985i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetActiveSubscriptionsUseCase f58986j;

    /* renamed from: k  reason: collision with root package name */
    public int f58987k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetActiveSubscriptionsUseCase$invoke$1(GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase, Continuation<? super GetActiveSubscriptionsUseCase$invoke$1> continuation) {
        super(continuation);
        this.f58986j = getActiveSubscriptionsUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58985i = obj;
        this.f58987k |= Integer.MIN_VALUE;
        return this.f58986j.invoke((GetActiveSubscriptionsUseCase.Params) null, this);
    }
}
