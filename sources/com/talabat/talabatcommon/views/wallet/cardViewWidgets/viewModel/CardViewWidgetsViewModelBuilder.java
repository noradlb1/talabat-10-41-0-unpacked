package com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase;
import com.talabat.talabatcommon.feature.walletCardList.GetCardListUseCase;
import com.talabat.talabatcommon.feature.walletCardList.network.WalletCardListService;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.GetWalletPaymentWidgetConfigUseCase;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.network.WalletPaymentWidgetConfigService;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.repository.WalletPaymentWidgetRepositoryImpl;
import com.talabat.talabatcommon.views.wallet.benefitmanager.di.module.BenefitManagerDomainModule;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.di.module.QPayDomainModule;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.wallet.features.walletCardList.repository.WalletCardListRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/CardViewWidgetsViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CardViewWidgetsViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/CardViewWidgetsViewModelBuilder$Companion;", "", "()V", "getDefaultCardViewModel", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/CardViewWidgetsViewModelImpl;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "source", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CardViewWidgetsViewModelImpl getDefaultCardViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
            Intrinsics.checkNotNullParameter(str, "source");
            WalletCardListService walletCardListService = new WalletCardListService(new TalabatAPIBuilder());
            WalletPaymentWidgetConfigService walletPaymentWidgetConfigService = new WalletPaymentWidgetConfigService(new TalabatAPIBuilder());
            WalletCardListRepositoryImpl walletCardListRepositoryImpl = new WalletCardListRepositoryImpl(new NetworkHandler(context), walletCardListService);
            WalletPaymentWidgetRepositoryImpl walletPaymentWidgetRepositoryImpl = new WalletPaymentWidgetRepositoryImpl(new NetworkHandler(context), walletPaymentWidgetConfigService);
            GetCardListUseCase getCardListUseCase = new GetCardListUseCase(walletCardListRepositoryImpl, coroutineScope, Dispatchers.getMain());
            GetWalletPaymentWidgetConfigUseCase getWalletPaymentWidgetConfigUseCase = new GetWalletPaymentWidgetConfigUseCase(walletPaymentWidgetRepositoryImpl, coroutineScope, Dispatchers.getMain(), (Function1) null, 8, (DefaultConstructorMarker) null);
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                ConfigurationLocalRepository repository = ((ConfigurationLocalCoreLibApi) ((ApiContainer) applicationContext).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
                return new CardViewWidgetsViewModelImpl(getCardListUseCase, getWalletPaymentWidgetConfigUseCase, new DebitCardDeflectionUseCase(BenefitManagerDomainModule.INSTANCE.provideGetBenefitBinDetailUseCase(repository, iTalabatFeatureFlag), QPayDomainModule.INSTANCE.provideGetQPayDeflectionBinsUseCase(PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_QPAY_SAVED_CARD_DEFLECTION_ENABLED, iTalabatFeatureFlag), repository), str);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
        }
    }
}
