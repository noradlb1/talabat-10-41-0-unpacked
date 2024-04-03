package com.talabat.wallet.features.walletTransactionList.repository;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.wallet.features.walletTransactionList.model.response.WalletTransactionListResponse;
import com.talabat.wallet.features.walletTransactionList.model.response.WalletTransactionListResult;
import com.talabat.wallet.features.walletTransactionList.network.WalletTransactionListApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionList/repository/WalletTransactionListRepositoryImpl;", "Lcom/talabat/wallet/features/walletTransactionList/repository/WalletTransactionListRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "walletTransactionListApi", "Lcom/talabat/wallet/features/walletTransactionList/network/WalletTransactionListApi;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/wallet/features/walletTransactionList/network/WalletTransactionListApi;)V", "getWalletTransactionList", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResponse;", "countryId", "", "take", "skip", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionListRepositoryImpl implements WalletTransactionListRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final WalletTransactionListApi walletTransactionListApi;

    public WalletTransactionListRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull WalletTransactionListApi walletTransactionListApi2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(walletTransactionListApi2, "walletTransactionListApi");
        this.networkHandler = networkHandler2;
        this.walletTransactionListApi = walletTransactionListApi2;
    }

    @NotNull
    public Either<Failure, WalletTransactionListResponse> getWalletTransactionList(int i11, int i12, int i13) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(WalletTransactionListApi.DefaultImpls.getWalletTransactionList$default(this.walletTransactionListApi, i11, 0, i12, i13, 2, (Object) null), WalletTransactionListRepositoryImpl$getWalletTransactionList$1.INSTANCE, new WalletTransactionListResponse((WalletTransactionListResult) null, (List) null, 3, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
