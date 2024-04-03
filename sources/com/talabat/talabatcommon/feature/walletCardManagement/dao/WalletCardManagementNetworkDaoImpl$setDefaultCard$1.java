package com.talabat.talabatcommon.feature.walletCardManagement.dao;

import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletSetDefaultCardRequestModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl", f = "WalletCardManagementNetworkDaoImpl.kt", i = {}, l = {17}, m = "setDefaultCard", n = {}, s = {})
public final class WalletCardManagementNetworkDaoImpl$setDefaultCard$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61722h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletCardManagementNetworkDaoImpl f61723i;

    /* renamed from: j  reason: collision with root package name */
    public int f61724j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCardManagementNetworkDaoImpl$setDefaultCard$1(WalletCardManagementNetworkDaoImpl walletCardManagementNetworkDaoImpl, Continuation<? super WalletCardManagementNetworkDaoImpl$setDefaultCard$1> continuation) {
        super(continuation);
        this.f61723i = walletCardManagementNetworkDaoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61722h = obj;
        this.f61724j |= Integer.MIN_VALUE;
        return this.f61723i.setDefaultCard((WalletSetDefaultCardRequestModel) null, this);
    }
}
