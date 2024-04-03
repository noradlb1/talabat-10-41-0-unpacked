package com.talabat.wallet.qPayManager.data.remote.impl;

import com.talabat.wallet.qPayManager.data.remote.QPayManagerRemoteDataSource;
import com.talabat.wallet.qPayManager.data.remote.api.QPayManagerApi;
import com.talabat.wallet.qPayManager.data.remote.dto.QPayRedirectUrlRemoteDto;
import com.talabat.wallet.qPayManager.data.remote.dto.QPayRedirectUrlRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/qPayManager/data/remote/impl/QPayManagerRemoteSourceImpl;", "Lcom/talabat/wallet/qPayManager/data/remote/QPayManagerRemoteDataSource;", "qPayManagerApi", "Lcom/talabat/wallet/qPayManager/data/remote/api/QPayManagerApi;", "(Lcom/talabat/wallet/qPayManager/data/remote/api/QPayManagerApi;)V", "getQPayRedirectUrl", "Lcom/talabat/wallet/qPayManager/data/remote/dto/QPayRedirectUrlRemoteDto;", "url", "", "request", "Lcom/talabat/wallet/qPayManager/data/remote/dto/QPayRedirectUrlRequest;", "(Ljava/lang/String;Lcom/talabat/wallet/qPayManager/data/remote/dto/QPayRedirectUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayManagerRemoteSourceImpl implements QPayManagerRemoteDataSource {
    @NotNull
    private final QPayManagerApi qPayManagerApi;

    public QPayManagerRemoteSourceImpl(@NotNull QPayManagerApi qPayManagerApi2) {
        Intrinsics.checkNotNullParameter(qPayManagerApi2, "qPayManagerApi");
        this.qPayManagerApi = qPayManagerApi2;
    }

    @Nullable
    public Object getQPayRedirectUrl(@NotNull String str, @NotNull QPayRedirectUrlRequest qPayRedirectUrlRequest, @NotNull Continuation<? super QPayRedirectUrlRemoteDto> continuation) {
        return this.qPayManagerApi.getQPayRedirectUrl(str, qPayRedirectUrlRequest, continuation);
    }
}
