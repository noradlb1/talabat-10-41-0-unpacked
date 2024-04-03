package com.talabat.wallet.ui.walletTransactionDetail.viewModel;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcommon.feature.orderDetail.GetOrderDetailUseCase;
import com.talabat.talabatcommon.feature.orderDetail.dao.OrderDetailNetworkDaoImpl;
import com.talabat.talabatcommon.feature.orderDetail.repository.OrderDetailRepositoryImpl;
import com.talabat.wallet.features.refund.GetWalletCanRevertRefundToBankUseCase;
import com.talabat.wallet.features.refund.GetWalletRevertRefundToBankUseCase;
import com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl;
import com.talabat.wallet.features.refund.network.WalletRefundToBankRetrofitBuilder;
import com.talabat.wallet.features.refund.repository.WalletRefundToBankRepositoryImpl;
import com.talabat.wallet.features.walletTransactionDetail.GetWalletTransactionDetailUseCase;
import com.talabat.wallet.features.walletTransactionDetail.dao.WalletTransactionDetailNetworkDaoImpl;
import com.talabat.wallet.features.walletTransactionDetail.network.WalletTransactionDetailApi;
import com.talabat.wallet.features.walletTransactionDetail.repository.WalletTransactionDetailRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailViewModelBuilder$Companion;", "", "()V", "getWalletTransactionDetailPaymentViewModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailPaymentViewModel;", "getWalletTransactionDetailRefundViewModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailRefundViewModel;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getWalletTransactionViewModelBuilder", "Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailViewModelImpl;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WalletTransactionDetailPaymentViewModel getWalletTransactionDetailPaymentViewModel() {
            return new WalletTransactionDetailPaymentViewModel(new GetOrderDetailUseCase(new OrderDetailRepositoryImpl(new OrderDetailNetworkDaoImpl())));
        }

        @NotNull
        public final WalletTransactionDetailRefundViewModel getWalletTransactionDetailRefundViewModel(@NotNull ConfigurationLocalRepository configurationLocalRepository) {
            Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
            WalletRefundToBankRetrofitBuilder walletRefundToBankRetrofitBuilder = WalletRefundToBankRetrofitBuilder.INSTANCE;
            return new WalletTransactionDetailRefundViewModel(new GetWalletCanRevertRefundToBankUseCase(new WalletRefundToBankRepositoryImpl(new WalletRefundToBankNetworkDaoImpl(walletRefundToBankRetrofitBuilder.getWalletRefundToBankApi(), configurationLocalRepository))), new GetWalletRevertRefundToBankUseCase(new WalletRefundToBankRepositoryImpl(new WalletRefundToBankNetworkDaoImpl(walletRefundToBankRetrofitBuilder.getWalletRefundToBankApi(), configurationLocalRepository))));
        }

        @NotNull
        public final WalletTransactionDetailViewModelImpl getWalletTransactionViewModelBuilder(@NotNull ConfigurationLocalRepository configurationLocalRepository) {
            Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
            return new WalletTransactionDetailViewModelImpl(new GetWalletTransactionDetailUseCase(new WalletTransactionDetailRepositoryImpl(new WalletTransactionDetailNetworkDaoImpl((WalletTransactionDetailApi) null, 1, (DefaultConstructorMarker) null))), configurationLocalRepository);
        }
    }
}
