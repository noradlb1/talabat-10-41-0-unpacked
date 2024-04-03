package com.talabat.wallet.features.walletTransactionDetail;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.features.walletTransactionDetail.GetWalletTransactionDetailUseCase", f = "GetWalletTransactionDetailUseCase.kt", i = {}, l = {12}, m = "invoke", n = {}, s = {})
public final class GetWalletTransactionDetailUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f12592h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetWalletTransactionDetailUseCase f12593i;

    /* renamed from: j  reason: collision with root package name */
    public int f12594j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetWalletTransactionDetailUseCase$invoke$1(GetWalletTransactionDetailUseCase getWalletTransactionDetailUseCase, Continuation<? super GetWalletTransactionDetailUseCase$invoke$1> continuation) {
        super(continuation);
        this.f12593i = getWalletTransactionDetailUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12592h = obj;
        this.f12594j |= Integer.MIN_VALUE;
        return this.f12593i.invoke((WalletTransactionDetailParam) null, this);
    }
}
