package com.talabat.wallet.ui.walletTopUp.viewModel;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase;
import com.talabat.talabatcommon.feature.walletCardList.GetCardListUseCase;
import com.talabat.talabatcommon.feature.walletCardList.network.WalletCardListService;
import com.talabat.talabatcommon.feature.walletCardManagement.GetWalletCardManagementFeatureEnabledUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.di.module.DomainModule;
import com.talabat.talabatcommon.feature.walletPayment.GetWalletPaymentFlagEnabledUseCase;
import com.talabat.talabatcommon.views.wallet.IsWalletAddCardFlutterScreenEnabledUseCase;
import com.talabat.talabatcommon.views.wallet.benefitmanager.di.module.BenefitManagerDomainModule;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.di.module.QPayDomainModule;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.wallet.features.walletCardList.repository.WalletCardListRepositoryImpl;
import com.talabat.wallet.features.walletCashBack.GetCalculatedCashBackUseCase;
import com.talabat.wallet.features.walletCashBack.GetCashBackCampaignOfferUseCase;
import com.talabat.wallet.features.walletCashBack.GetCashBackCampaignsUseCase;
import com.talabat.wallet.features.walletCashBack.GetFormattedWalletTopUpListUseCase;
import com.talabat.wallet.features.walletCashBack.network.WalletCashBackService;
import com.talabat.wallet.features.walletCashBack.repository.WalletCashBackRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/viewModel/WalletTopUpViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J.\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/viewModel/WalletTopUpViewModelBuilder$Companion;", "", "()V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "context", "Landroid/content/Context;", "debitCardDeflectionUseCase", "Lcom/talabat/talabatcommon/feature/walletCardList/DebitCardDeflectionUseCase;", "localConfigurationRepository", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getWalletTopUpViewModel", "Lcom/talabat/wallet/ui/walletTopUp/viewModel/WalletTopUpViewModelImpl;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ConfigurationLocalRepository configurationLocalRepository(Context context) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                return ((ConfigurationLocalCoreLibApi) ((ApiContainer) applicationContext).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
        }

        private final DebitCardDeflectionUseCase debitCardDeflectionUseCase(ConfigurationLocalRepository configurationLocalRepository, ITalabatFeatureFlag iTalabatFeatureFlag) {
            return new DebitCardDeflectionUseCase(BenefitManagerDomainModule.INSTANCE.provideGetBenefitBinDetailUseCase(configurationLocalRepository, iTalabatFeatureFlag), QPayDomainModule.INSTANCE.provideGetQPayDeflectionBinsUseCase(PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_QPAY_WALLET_DEFLECTION_ENABLED, iTalabatFeatureFlag), configurationLocalRepository);
        }

        @NotNull
        public final WalletTopUpViewModelImpl getWalletTopUpViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull TalabatTracker talabatTracker) {
            Context context2 = context;
            CoroutineScope coroutineScope2 = coroutineScope;
            ConfigurationLocalRepository configurationLocalRepository2 = configurationLocalRepository;
            ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
            TalabatTracker talabatTracker2 = talabatTracker;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
            Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "featureFlagRepo");
            Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
            GetCardListUseCase getCardListUseCase = new GetCardListUseCase(new WalletCardListRepositoryImpl(new NetworkHandler(context2), new WalletCardListService(new TalabatAPIBuilder())), coroutineScope2, Dispatchers.getMain());
            WalletCashBackRepositoryImpl walletCashBackRepositoryImpl = new WalletCashBackRepositoryImpl(new NetworkHandler(context2), new WalletCashBackService(new TalabatAPIBuilder()), configurationLocalRepository2);
            GetCashBackCampaignsUseCase getCashBackCampaignsUseCase = new GetCashBackCampaignsUseCase(walletCashBackRepositoryImpl, configurationLocalRepository2, coroutineScope2, Dispatchers.getMain());
            GetCashBackCampaignOfferUseCase getCashBackCampaignOfferUseCase = new GetCashBackCampaignOfferUseCase(walletCashBackRepositoryImpl, configurationLocalRepository2, coroutineScope2, Dispatchers.getMain());
            GetCalculatedCashBackUseCase getCalculatedCashBackUseCase = new GetCalculatedCashBackUseCase(walletCashBackRepositoryImpl, coroutineScope2, Dispatchers.getMain(), (Function1) null, 8, (DefaultConstructorMarker) null);
            SetDebitCardsDeflectionUseCase setDebitCardsDeflectionUseCase = new SetDebitCardsDeflectionUseCase(debitCardDeflectionUseCase(configurationLocalRepository(context), iTalabatFeatureFlag2));
            GetFormattedWalletTopUpListUseCase getFormattedWalletTopUpListUseCase = new GetFormattedWalletTopUpListUseCase();
            DomainModule domainModule = DomainModule.INSTANCE;
            return new WalletTopUpViewModelImpl(getCardListUseCase, getCashBackCampaignsUseCase, getCashBackCampaignOfferUseCase, getFormattedWalletTopUpListUseCase, getCalculatedCashBackUseCase, new GetWalletCardManagementFeatureEnabledUseCase(iTalabatFeatureFlag2, domainModule.provideSelectedCountryId()), new GetWalletPaymentFlagEnabledUseCase(iTalabatFeatureFlag2, domainModule.provideSelectedCountryId()), setDebitCardsDeflectionUseCase, new IsWalletAddCardFlutterScreenEnabledUseCase(iTalabatFeatureFlag2), new TrackCreditCardClickedUseCase(talabatTracker2));
        }
    }
}
