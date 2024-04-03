package com.talabat.wallet.features.walletTransactionDetail.repository;

import com.talabat.wallet.features.walletTransactionDetail.dao.WalletTransactionDetailNetworkDao;
import com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionDetail/repository/WalletTransactionDetailRepositoryImpl;", "Lcom/talabat/wallet/features/walletTransactionDetail/repository/WalletTransactionDetailRepository;", "walletTransactionDetailNetworkDao", "Lcom/talabat/wallet/features/walletTransactionDetail/dao/WalletTransactionDetailNetworkDao;", "(Lcom/talabat/wallet/features/walletTransactionDetail/dao/WalletTransactionDetailNetworkDao;)V", "getWalletTransactionDetail", "Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetail;", "transactionType", "", "transactionId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailRepositoryImpl implements WalletTransactionDetailRepository {
    @NotNull
    private final WalletTransactionDetailNetworkDao walletTransactionDetailNetworkDao;

    public WalletTransactionDetailRepositoryImpl(@NotNull WalletTransactionDetailNetworkDao walletTransactionDetailNetworkDao2) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailNetworkDao2, "walletTransactionDetailNetworkDao");
        this.walletTransactionDetailNetworkDao = walletTransactionDetailNetworkDao2;
    }

    @Nullable
    public Object getWalletTransactionDetail(int i11, int i12, @NotNull Continuation<? super WalletTransactionDetail> continuation) {
        return this.walletTransactionDetailNetworkDao.getWalletTransactionDetail(i11, i12, continuation);
    }
}
