package com.talabat.wallet.features.walletTransactionDetail.dao;

import com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionDetail/dao/WalletTransactionDetailNetworkDao;", "", "getWalletTransactionDetail", "Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetail;", "transactionType", "", "transactionId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletTransactionDetailNetworkDao {
    @Nullable
    Object getWalletTransactionDetail(int i11, int i12, @NotNull Continuation<? super WalletTransactionDetail> continuation);
}
