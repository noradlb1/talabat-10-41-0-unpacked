package com.talabat.wallet.features.refund.dao;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl", f = "WalletRefundToBankNetworkDaoImpl.kt", i = {}, l = {22}, m = "refundToBankStatus", n = {}, s = {})
public final class WalletRefundToBankNetworkDaoImpl$refundToBankStatus$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f12586h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletRefundToBankNetworkDaoImpl f12587i;

    /* renamed from: j  reason: collision with root package name */
    public int f12588j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletRefundToBankNetworkDaoImpl$refundToBankStatus$1(WalletRefundToBankNetworkDaoImpl walletRefundToBankNetworkDaoImpl, Continuation<? super WalletRefundToBankNetworkDaoImpl$refundToBankStatus$1> continuation) {
        super(continuation);
        this.f12587i = walletRefundToBankNetworkDaoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12586h = obj;
        this.f12588j |= Integer.MIN_VALUE;
        return this.f12587i.refundToBankStatus((String) null, this);
    }
}
