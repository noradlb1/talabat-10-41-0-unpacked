package com.talabat.wallet.checkoutpaymentmanager.di.factory;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.data.impl.TipRiderStateRepositoryImpl;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.SetTipRiderStatusUseCase;
import com.talabat.talabatcommon.views.wallet.benefitmanager.di.module.BenefitManagerDomainModule;
import com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.data.impl.CheckoutPaymentManagerRepositoryImpl;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.di.module.QPayDomainModule;
import com.talabat.wallet.bnplmanager.data.local.BNPLManagerLocalDataSource;
import com.talabat.wallet.bnplmanager.di.module.BNPLManagerModule;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase;
import com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase;
import com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetWalletBalanceApiEnabledUseCase;
import com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.CheckoutTrackerImpl;
import com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate;
import com.talabat.wallet.checkoutpaymentmanager.presentation.viewmodel.CheckoutPaymentUpdateViewModel;
import com.talabat.wallet.knetStatusManager.di.module.KNetStatusManagerDomainModule;
import com.talabat.wallet.qPayManager.di.module.QPayManagerDomainModule;
import com.talabat.wallet.walletbalance.di.module.WalletBalanceDomainModule;
import com.talabat.wallet.walletbalance.domain.business.usecase.WalletBalanceUseCase;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/di/factory/CheckoutPaymentManagerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getPaymentMethodUpdate", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/business/usecase/GetPaymentMethodUpdate;", "getWalletBalanceUseCase", "Lcom/talabat/wallet/walletbalance/domain/business/usecase/WalletBalanceUseCase;", "getWalletBalanceApiEnabledUseCase", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/application/usecase/GetWalletBalanceApiEnabledUseCase;", "getBNPLEligiblePlanUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLEligiblePlanUseCase;", "setTipRiderStatusUseCase", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/SetTipRiderStatusUseCase;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Lcom/talabat/wallet/checkoutpaymentmanager/domain/business/usecase/GetPaymentMethodUpdate;Lcom/talabat/wallet/walletbalance/domain/business/usecase/WalletBalanceUseCase;Lcom/talabat/wallet/checkoutpaymentmanager/domain/application/usecase/GetWalletBalanceApiEnabledUseCase;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLEligiblePlanUseCase;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/SetTipRiderStatusUseCase;Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutPaymentManagerViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static CheckoutPaymentUpdateViewModel mockedCheckoutPaymentUpdateViewModel;
    @NotNull
    private final GetBNPLEligiblePlanUseCase getBNPLEligiblePlanUseCase;
    @NotNull
    private final GetPaymentMethodUpdate getPaymentMethodUpdate;
    @NotNull
    private final GetWalletBalanceApiEnabledUseCase getWalletBalanceApiEnabledUseCase;
    @NotNull
    private final WalletBalanceUseCase getWalletBalanceUseCase;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final SetTipRiderStatusUseCase setTipRiderStatusUseCase;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/di/factory/CheckoutPaymentManagerViewModelFactory$Companion;", "", "()V", "mockedCheckoutPaymentUpdateViewModel", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/viewmodel/CheckoutPaymentUpdateViewModel;", "getMockedCheckoutPaymentUpdateViewModel", "()Lcom/talabat/wallet/checkoutpaymentmanager/presentation/viewmodel/CheckoutPaymentUpdateViewModel;", "setMockedCheckoutPaymentUpdateViewModel", "(Lcom/talabat/wallet/checkoutpaymentmanager/presentation/viewmodel/CheckoutPaymentUpdateViewModel;)V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "apiContainer", "Lcom/talabat/core/di/ApiContainer;", "create", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "bnplManagerLocalDataSource", "Lcom/talabat/wallet/bnplmanager/data/local/BNPLManagerLocalDataSource;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ConfigurationLocalRepository configurationLocalRepository(ApiContainer apiContainer) {
            return ((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
        }

        private final ITalabatFeatureFlag featureFlagRepo(ApiContainer apiContainer) {
            return ((FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
        }

        private final IObservabilityManager observabilityManager(ApiContainer apiContainer) {
            return ((ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager();
        }

        @NotNull
        public final CheckoutPaymentUpdateViewModel create(@NotNull AppCompatActivity appCompatActivity, @NotNull BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
            ViewModelProvider.Factory factory;
            AppCompatActivity appCompatActivity2 = appCompatActivity;
            Intrinsics.checkNotNullParameter(appCompatActivity2, "appCompatActivity");
            Intrinsics.checkNotNullParameter(bNPLManagerLocalDataSource, "bnplManagerLocalDataSource");
            ApiContainer apiContainer = AndroidComponentsKt.apiContainer((Activity) appCompatActivity);
            ConfigurationLocalRepository configurationLocalRepository = configurationLocalRepository(apiContainer);
            LocationConfigurationRepository locationConfigurationRepository = ((ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository();
            IObservabilityManager observabilityManager = observabilityManager(apiContainer);
            ITalabatFeatureFlag featureFlagRepo = featureFlagRepo(apiContainer);
            CheckoutPaymentUpdateViewModel mockedCheckoutPaymentUpdateViewModel = getMockedCheckoutPaymentUpdateViewModel();
            if (mockedCheckoutPaymentUpdateViewModel != null) {
                return mockedCheckoutPaymentUpdateViewModel;
            }
            QPayDomainModule qPayDomainModule = QPayDomainModule.INSTANCE;
            ViewModelProvider.Factory factory2 = factory;
            new CheckoutPaymentManagerViewModelFactory(new GetPaymentMethodUpdate(qPayDomainModule.provideGetQPayDeflectionSavedCardUseCase(PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_QPAY_SAVED_CARD_DEFLECTION_ENABLED, featureFlagRepo), KNetStatusManagerDomainModule.INSTANCE.provideGetKNetStatusUseCase(configurationLocalRepository, featureFlagRepo, observabilityManager), new GetCheckoutTimeOutVariationUseCase(featureFlagRepo, new CheckoutPaymentManagerRepositoryImpl()), configurationLocalRepository, new CheckoutTrackerImpl(appCompatActivity2, new AppTracker(new TalabatGTM())), BenefitManagerDomainModule.INSTANCE.provideGetBenefitBinDetailUseCase(configurationLocalRepository, featureFlagRepo), QPayManagerDomainModule.INSTANCE.provideGetQPayEnabledUseCase(configurationLocalRepository, featureFlagRepo), qPayDomainModule.provideIsQPayServiceDownUseCase(featureFlagRepo)), new WalletBalanceUseCase(WalletBalanceDomainModule.INSTANCE.provideWalletBalanceRepository(configurationLocalRepository), observabilityManager), new GetWalletBalanceApiEnabledUseCase(featureFlagRepo), BNPLManagerModule.INSTANCE.provideGetBNPLEligiblePlanUseCase(appCompatActivity, configurationLocalRepository, locationConfigurationRepository, observabilityManager, featureFlagRepo, bNPLManagerLocalDataSource), new SetTipRiderStatusUseCase(new TipRiderStateRepositoryImpl((Context) null, 1, (DefaultConstructorMarker) null)), locationConfigurationRepository, (DefaultConstructorMarker) null);
            return (CheckoutPaymentUpdateViewModel) new ViewModelProvider((ViewModelStoreOwner) appCompatActivity2, factory2).get(CheckoutPaymentUpdateViewModel.class);
        }

        @Nullable
        public final CheckoutPaymentUpdateViewModel getMockedCheckoutPaymentUpdateViewModel() {
            return CheckoutPaymentManagerViewModelFactory.mockedCheckoutPaymentUpdateViewModel;
        }

        public final void setMockedCheckoutPaymentUpdateViewModel(@Nullable CheckoutPaymentUpdateViewModel checkoutPaymentUpdateViewModel) {
            CheckoutPaymentManagerViewModelFactory.mockedCheckoutPaymentUpdateViewModel = checkoutPaymentUpdateViewModel;
        }
    }

    private CheckoutPaymentManagerViewModelFactory(GetPaymentMethodUpdate getPaymentMethodUpdate2, WalletBalanceUseCase walletBalanceUseCase, GetWalletBalanceApiEnabledUseCase getWalletBalanceApiEnabledUseCase2, GetBNPLEligiblePlanUseCase getBNPLEligiblePlanUseCase2, SetTipRiderStatusUseCase setTipRiderStatusUseCase2, LocationConfigurationRepository locationConfigurationRepository2) {
        this.getPaymentMethodUpdate = getPaymentMethodUpdate2;
        this.getWalletBalanceUseCase = walletBalanceUseCase;
        this.getWalletBalanceApiEnabledUseCase = getWalletBalanceApiEnabledUseCase2;
        this.getBNPLEligiblePlanUseCase = getBNPLEligiblePlanUseCase2;
        this.setTipRiderStatusUseCase = setTipRiderStatusUseCase2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public /* synthetic */ CheckoutPaymentManagerViewModelFactory(GetPaymentMethodUpdate getPaymentMethodUpdate2, WalletBalanceUseCase walletBalanceUseCase, GetWalletBalanceApiEnabledUseCase getWalletBalanceApiEnabledUseCase2, GetBNPLEligiblePlanUseCase getBNPLEligiblePlanUseCase2, SetTipRiderStatusUseCase setTipRiderStatusUseCase2, LocationConfigurationRepository locationConfigurationRepository2, DefaultConstructorMarker defaultConstructorMarker) {
        this(getPaymentMethodUpdate2, walletBalanceUseCase, getWalletBalanceApiEnabledUseCase2, getBNPLEligiblePlanUseCase2, setTipRiderStatusUseCase2, locationConfigurationRepository2);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new CheckoutPaymentUpdateViewModel(this.getPaymentMethodUpdate, this.getWalletBalanceUseCase, this.getWalletBalanceApiEnabledUseCase, this.getBNPLEligiblePlanUseCase, this.setTipRiderStatusUseCase, this.locationConfigurationRepository);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
