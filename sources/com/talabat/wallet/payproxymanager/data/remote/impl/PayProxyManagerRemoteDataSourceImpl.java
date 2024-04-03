package com.talabat.wallet.payproxymanager.data.remote.impl;

import com.talabat.wallet.payproxymanager.data.remote.PayProxyManagerRemoteDataSource;
import com.talabat.wallet.payproxymanager.data.remote.api.PayProxyManagerApi;
import com.talabat.wallet.payproxymanager.data.remote.dto.request.PayProxyCVVRequestModel;
import com.talabat.wallet.payproxymanager.data.remote.dto.response.PayProxyCVVRemoteDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/payproxymanager/data/remote/impl/PayProxyManagerRemoteDataSourceImpl;", "Lcom/talabat/wallet/payproxymanager/data/remote/PayProxyManagerRemoteDataSource;", "payProxyManagerApi", "Lcom/talabat/wallet/payproxymanager/data/remote/api/PayProxyManagerApi;", "(Lcom/talabat/wallet/payproxymanager/data/remote/api/PayProxyManagerApi;)V", "sendCVVToPayProxy", "Lcom/talabat/wallet/payproxymanager/data/remote/dto/response/PayProxyCVVRemoteDto;", "payProxyCVVRequestModel", "Lcom/talabat/wallet/payproxymanager/data/remote/dto/request/PayProxyCVVRequestModel;", "(Lcom/talabat/wallet/payproxymanager/data/remote/dto/request/PayProxyCVVRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayProxyManagerRemoteDataSourceImpl implements PayProxyManagerRemoteDataSource {
    @NotNull
    private final PayProxyManagerApi payProxyManagerApi;

    public PayProxyManagerRemoteDataSourceImpl(@NotNull PayProxyManagerApi payProxyManagerApi2) {
        Intrinsics.checkNotNullParameter(payProxyManagerApi2, "payProxyManagerApi");
        this.payProxyManagerApi = payProxyManagerApi2;
    }

    @Nullable
    public Object sendCVVToPayProxy(@NotNull PayProxyCVVRequestModel payProxyCVVRequestModel, @NotNull Continuation<? super PayProxyCVVRemoteDto> continuation) {
        return this.payProxyManagerApi.sendCVVToPayProxy(payProxyCVVRequestModel, continuation);
    }
}
