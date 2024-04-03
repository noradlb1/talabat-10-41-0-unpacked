package com.talabat.wallet.knetStatusManager.data.remote.impl;

import com.talabat.wallet.knetStatusManager.data.remote.KNetStatusManagerRemoteDataSource;
import com.talabat.wallet.knetStatusManager.data.remote.api.KNetStatusManagerApi;
import com.talabat.wallet.knetStatusManager.data.remote.dto.KNetStatusRemoteDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/data/remote/impl/KNetStatusManagerRemoteDataSourceImpl;", "Lcom/talabat/wallet/knetStatusManager/data/remote/KNetStatusManagerRemoteDataSource;", "kNetStatusManagerApi", "Lcom/talabat/wallet/knetStatusManager/data/remote/api/KNetStatusManagerApi;", "(Lcom/talabat/wallet/knetStatusManager/data/remote/api/KNetStatusManagerApi;)V", "getKNetStatus", "Lcom/talabat/wallet/knetStatusManager/data/remote/dto/KNetStatusRemoteDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KNetStatusManagerRemoteDataSourceImpl implements KNetStatusManagerRemoteDataSource {
    @NotNull
    private final KNetStatusManagerApi kNetStatusManagerApi;

    public KNetStatusManagerRemoteDataSourceImpl(@NotNull KNetStatusManagerApi kNetStatusManagerApi2) {
        Intrinsics.checkNotNullParameter(kNetStatusManagerApi2, "kNetStatusManagerApi");
        this.kNetStatusManagerApi = kNetStatusManagerApi2;
    }

    @Nullable
    public Object getKNetStatus(@NotNull Continuation<? super KNetStatusRemoteDto> continuation) {
        return this.kNetStatusManagerApi.getKNetStatus(continuation);
    }
}
