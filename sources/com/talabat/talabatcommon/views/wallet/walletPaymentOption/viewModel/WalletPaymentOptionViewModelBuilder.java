package com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel;

import android.content.Context;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.feature.walletBalance.GetWalletBalanceUseCase;
import com.talabat.talabatcommon.feature.walletBalance.network.WalletBalanceService;
import com.talabat.talabatcommon.feature.walletBalance.repository.WalletBalanceRepositoryImpl;
import com.talabat.talabatcommon.feature.walletPayment.GetDebitWalletUseCase;
import com.talabat.talabatcommon.feature.walletPayment.GetTopUpWalletUseCase;
import com.talabat.talabatcommon.feature.walletPayment.GetVerifyWalletQRCodeUseCase;
import com.talabat.talabatcommon.feature.walletPayment.GetVerifyWalletTransactionUseCase;
import com.talabat.talabatcommon.feature.walletPayment.GetWalletTopUpSuggestionAmountUseCase;
import com.talabat.talabatcommon.feature.walletPayment.network.VerifyQRService;
import com.talabat.talabatcommon.feature.walletPayment.network.WalletPaymentService;
import com.talabat.talabatcommon.feature.walletPayment.repository.WalletPaymentRepositoryImpl;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.GetWalletPaymentOptionViewConfigUseCase;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.GetWalletPaymentWidgetUpdateUseCase;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentOptionViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModelBuilder$Companion;", "", "()V", "getWalletPaymentOptionViewModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModelImpl;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WalletPaymentOptionViewModelImpl getWalletPaymentOptionViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope) {
            Context context2 = context;
            CoroutineScope coroutineScope2 = coroutineScope;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
            WalletBalanceService walletBalanceService = new WalletBalanceService(new TalabatAPIBuilder());
            WalletPaymentService walletPaymentService = new WalletPaymentService(new TalabatAPIBuilder());
            VerifyQRService verifyQRService = new VerifyQRService(new TalabatAPIBuilder());
            WalletBalanceRepositoryImpl walletBalanceRepositoryImpl = new WalletBalanceRepositoryImpl(new NetworkHandler(context2), walletBalanceService, ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository());
            WalletPaymentRepositoryImpl walletPaymentRepositoryImpl = new WalletPaymentRepositoryImpl(new NetworkHandler(context2), walletPaymentService, verifyQRService);
            WalletPaymentRepositoryImpl walletPaymentRepositoryImpl2 = walletPaymentRepositoryImpl;
            CoroutineScope coroutineScope3 = coroutineScope;
            return new WalletPaymentOptionViewModelImpl(new GetWalletBalanceUseCase(walletBalanceRepositoryImpl, coroutineScope2, Dispatchers.getMain()), new GetWalletPaymentOptionViewConfigUseCase(), new GetWalletPaymentWidgetUpdateUseCase(), new GetTopUpWalletUseCase(walletPaymentRepositoryImpl2, coroutineScope3, Dispatchers.getMain(), (Function1) null, 8, (DefaultConstructorMarker) null), new GetVerifyWalletTransactionUseCase(walletPaymentRepositoryImpl2, coroutineScope3, Dispatchers.getMain(), (Function1) null, 8, (DefaultConstructorMarker) null), new GetDebitWalletUseCase(walletPaymentRepositoryImpl2, coroutineScope3, Dispatchers.getMain(), (Function1) null, 8, (DefaultConstructorMarker) null), new GetVerifyWalletQRCodeUseCase(walletPaymentRepositoryImpl2, coroutineScope3, Dispatchers.getMain(), (Function1) null, 8, (DefaultConstructorMarker) null), new GetWalletTopUpSuggestionAmountUseCase(walletPaymentRepositoryImpl2, coroutineScope3, Dispatchers.getMain(), (Function1) null, 8, (DefaultConstructorMarker) null));
        }
    }
}
