package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase;
import com.talabat.talabatcommon.feature.walletCardList.GetCardListUseCase;
import com.talabat.talabatcommon.feature.walletCardList.network.WalletCardListService;
import com.talabat.talabatcommon.feature.walletCardManagement.GetAddCardToWalletUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.GetSetWalletDefaultCardUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.GetWalletCardManagementFeatureEnabledUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.SendCardDeleteClickedEventUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.SendCardDeletedFailedEventUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.SendCardDeletedSuccessEventUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl;
import com.talabat.talabatcommon.feature.walletCardManagement.di.module.DomainModule;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementRetrofitBuilder;
import com.talabat.talabatcommon.feature.walletCardManagement.repository.WalletCardManagementRepositoryImpl;
import com.talabat.talabatcommon.views.wallet.IsWalletAddCardFlutterScreenEnabledUseCase;
import com.talabat.talabatcommon.views.wallet.benefitmanager.di.module.BenefitManagerDomainModule;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.di.module.QPayDomainModule;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.wallet.features.walletCardList.repository.WalletCardListRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/WalletCardManagementViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardManagementViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/WalletCardManagementViewModelBuilder$Companion;", "", "()V", "getWalletCardManagementViewModel", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/WalletCardManagementViewModel;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "generateCardTokenUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "walletCardManagementApi", "Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WalletCardManagementViewModel getWalletCardManagementViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull GenerateCardTokenUseCase generateCardTokenUseCase, @NotNull PaymentConfigurationRepository paymentConfigurationRepository, @NotNull IObservabilityManager iObservabilityManager, @NotNull WalletCardManagementApi walletCardManagementApi, @NotNull TalabatTracker talabatTracker, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
            Context context2 = context;
            CoroutineScope coroutineScope2 = coroutineScope;
            ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
            WalletCardManagementApi walletCardManagementApi2 = walletCardManagementApi;
            TalabatTracker talabatTracker2 = talabatTracker;
            CoroutineDispatchersFactory coroutineDispatchersFactory2 = coroutineDispatchersFactory;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "featureFlagRepo");
            Intrinsics.checkNotNullParameter(generateCardTokenUseCase, "generateCardTokenUseCase");
            Intrinsics.checkNotNullParameter(paymentConfigurationRepository, "paymentConfigurationRepository");
            Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
            Intrinsics.checkNotNullParameter(walletCardManagementApi2, "walletCardManagementApi");
            Intrinsics.checkNotNullParameter(talabatTracker2, "tracker");
            Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "coroutineDispatchersFactory");
            GetCardListUseCase getCardListUseCase = new GetCardListUseCase(new WalletCardListRepositoryImpl(new NetworkHandler(context2), new WalletCardListService(new TalabatAPIBuilder())), coroutineScope2, Dispatchers.getMain());
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                ConfigurationLocalRepository repository = ((ConfigurationLocalCoreLibApi) ((ApiContainer) applicationContext).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
                DebitCardDeflectionUseCase debitCardDeflectionUseCase = new DebitCardDeflectionUseCase(BenefitManagerDomainModule.INSTANCE.provideGetBenefitBinDetailUseCase(repository, iTalabatFeatureFlag2), QPayDomainModule.INSTANCE.provideGetQPayDeflectionBinsUseCase(PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_QPAY_WALLET_DEFLECTION_ENABLED, iTalabatFeatureFlag2), repository);
                WalletCardManagementRetrofitBuilder walletCardManagementRetrofitBuilder = WalletCardManagementRetrofitBuilder.INSTANCE;
                return new WalletCardManagementViewModel(new GetSetWalletDefaultCardUseCase(new WalletCardManagementRepositoryImpl(new WalletCardManagementNetworkDaoImpl(walletCardManagementRetrofitBuilder.getWalletCardManagementAPIBuilder()))), new GetDeleteWalletCardUseCase(new WalletCardManagementRepositoryImpl(new WalletCardManagementNetworkDaoImpl(walletCardManagementApi2)), new SendCardDeletedSuccessEventUseCase(talabatTracker2, coroutineDispatchersFactory2), new SendCardDeletedFailedEventUseCase(talabatTracker2, coroutineDispatchersFactory2)), new GetAddCardToWalletUseCase(new WalletCardManagementRepositoryImpl(new WalletCardManagementNetworkDaoImpl(walletCardManagementRetrofitBuilder.getWalletCardAddCardAPIBuilder()))), getCardListUseCase, paymentConfigurationRepository, generateCardTokenUseCase, new GetWalletCardManagementFeatureEnabledUseCase(iTalabatFeatureFlag2, DomainModule.INSTANCE.provideSelectedCountryId()), debitCardDeflectionUseCase, new IsWalletAddCardFlutterScreenEnabledUseCase(iTalabatFeatureFlag2), new SendCardDeleteClickedEventUseCase(talabatTracker2, coroutineDispatchersFactory2), iObservabilityManager);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
        }
    }
}
