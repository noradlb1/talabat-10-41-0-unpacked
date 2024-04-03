package com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase", f = "GetCheckoutTimeOutVariationUseCase.kt", i = {0}, l = {15}, m = "invoke", n = {"this"}, s = {"L$0"})
public final class GetCheckoutTimeOutVariationUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12537h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12538i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetCheckoutTimeOutVariationUseCase f12539j;

    /* renamed from: k  reason: collision with root package name */
    public int f12540k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetCheckoutTimeOutVariationUseCase$invoke$1(GetCheckoutTimeOutVariationUseCase getCheckoutTimeOutVariationUseCase, Continuation<? super GetCheckoutTimeOutVariationUseCase$invoke$1> continuation) {
        super(continuation);
        this.f12539j = getCheckoutTimeOutVariationUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12538i = obj;
        this.f12540k |= Integer.MIN_VALUE;
        return this.f12539j.invoke(this);
    }
}
