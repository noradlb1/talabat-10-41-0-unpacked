package com.talabat.wallet.features.walletCardList.repository;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.walletCardList.model.response.WalletCreditCardGetListResponse;
import com.talabat.talabatcommon.feature.walletCardList.model.response.WalletCreditCardMetadataObject;
import com.talabat.talabatcommon.feature.walletCardList.network.WalletCardListApi;
import com.talabat.talabatcommon.feature.walletPayment.utils.PaymentProviderHelper;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/features/walletCardList/repository/WalletCardListRepositoryImpl;", "Lcom/talabat/wallet/features/walletCardList/repository/WalletCardListRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "walletCardListService", "Lcom/talabat/talabatcommon/feature/walletCardList/network/WalletCardListApi;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatcommon/feature/walletCardList/network/WalletCardListApi;)V", "getWalletCardList", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "country", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardListRepositoryImpl implements WalletCardListRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final WalletCardListApi walletCardListService;

    public WalletCardListRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull WalletCardListApi walletCardListApi) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(walletCardListApi, "walletCardListService");
        this.networkHandler = networkHandler2;
        this.walletCardListService = walletCardListApi;
    }

    @NotNull
    public Either<Failure, WalletCardListDisplayModel> getWalletCardList(int i11) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.walletCardListService.getWalletCardList(String.valueOf(PaymentProviderHelper.Companion.getPaymentProvider(i11)), String.valueOf(i11)), WalletCardListRepositoryImpl$getWalletCardList$1.INSTANCE, new WalletCreditCardGetListResponse((List) null, (String) null, (WalletCreditCardMetadataObject) null, (String) null, 15, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
