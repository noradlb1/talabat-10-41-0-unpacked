package com.talabat.wallet.features.refund.repository;

import com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/features/refund/repository/WalletRefundToBankRepositoryImpl;", "Lcom/talabat/wallet/features/refund/repository/WalletRefundToBankRepository;", "walletRefundToBankNetworkDao", "Lcom/talabat/wallet/features/refund/dao/WalletRefundToBankNetworkDao;", "(Lcom/talabat/wallet/features/refund/dao/WalletRefundToBankNetworkDao;)V", "getCanRefundToBankStatus", "", "orderId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refundToBankStatus", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletRefundToBankRepositoryImpl implements WalletRefundToBankRepository {
    @NotNull
    private final WalletRefundToBankNetworkDao walletRefundToBankNetworkDao;

    public WalletRefundToBankRepositoryImpl(@NotNull WalletRefundToBankNetworkDao walletRefundToBankNetworkDao2) {
        Intrinsics.checkNotNullParameter(walletRefundToBankNetworkDao2, "walletRefundToBankNetworkDao");
        this.walletRefundToBankNetworkDao = walletRefundToBankNetworkDao2;
    }

    @Nullable
    public Object getCanRefundToBankStatus(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        return this.walletRefundToBankNetworkDao.getCanRefundToBankStatus(str, continuation);
    }

    @Nullable
    public Object refundToBankStatus(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        return this.walletRefundToBankNetworkDao.refundToBankStatus(str, continuation);
    }
}
