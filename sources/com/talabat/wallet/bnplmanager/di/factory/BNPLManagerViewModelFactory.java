package com.talabat.wallet.bnplmanager.di.factory;

import android.app.Activity;
import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.gms.common.util.VisibleForTesting;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.bnplmanager.data.local.BNPLManagerLocalDataSource;
import com.talabat.wallet.bnplmanager.di.module.BNPLManagerModule;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLInstallmentsUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetPayOrderWithBNPLUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.IsUserEligibleForBNPLPaymentFallbackUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.SetIsUserSeenBNPLPaymentFallbackOptionUseCase;
import com.talabat.wallet.bnplmanager.domain.tracking.BNPLTracker;
import com.talabat.wallet.bnplmanager.domain.tracking.BNPLTrackerImpl;
import com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel;
import com.talabat.wallet.checkoutpaymentmanager.di.module.DomainModule;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B;\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/bnplmanager/di/factory/BNPLManagerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "bNPLTracker", "Lcom/talabat/wallet/bnplmanager/domain/tracking/BNPLTracker;", "getBNPLInstallmentsUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLInstallmentsUseCase;", "getPayOrderWithBNPLUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetPayOrderWithBNPLUseCase;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "isUserEligibleForBNPLPaymentFallbackUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/IsUserEligibleForBNPLPaymentFallbackUseCase;", "setIsUserSeenBNPLPaymentFallbackOptionUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/SetIsUserSeenBNPLPaymentFallbackOptionUseCase;", "(Lcom/talabat/wallet/bnplmanager/domain/tracking/BNPLTracker;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLInstallmentsUseCase;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetPayOrderWithBNPLUseCase;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/IsUserEligibleForBNPLPaymentFallbackUseCase;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/SetIsUserSeenBNPLPaymentFallbackOptionUseCase;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLManagerViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static BNPLManagerViewModel mockedBNPLManagerViewModel;
    @NotNull
    private final BNPLTracker bNPLTracker;
    @NotNull
    private final GetBNPLInstallmentsUseCase getBNPLInstallmentsUseCase;
    @NotNull
    private final GetPayOrderWithBNPLUseCase getPayOrderWithBNPLUseCase;
    @Nullable
    private final IsUserEligibleForBNPLPaymentFallbackUseCase isUserEligibleForBNPLPaymentFallbackUseCase;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private final SetIsUserSeenBNPLPaymentFallbackOptionUseCase setIsUserSeenBNPLPaymentFallbackOptionUseCase;

    private BNPLManagerViewModelFactory(BNPLTracker bNPLTracker2, GetBNPLInstallmentsUseCase getBNPLInstallmentsUseCase2, GetPayOrderWithBNPLUseCase getPayOrderWithBNPLUseCase2, LocationConfigurationRepository locationConfigurationRepository2, IsUserEligibleForBNPLPaymentFallbackUseCase isUserEligibleForBNPLPaymentFallbackUseCase2, SetIsUserSeenBNPLPaymentFallbackOptionUseCase setIsUserSeenBNPLPaymentFallbackOptionUseCase2) {
        this.bNPLTracker = bNPLTracker2;
        this.getBNPLInstallmentsUseCase = getBNPLInstallmentsUseCase2;
        this.getPayOrderWithBNPLUseCase = getPayOrderWithBNPLUseCase2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.isUserEligibleForBNPLPaymentFallbackUseCase = isUserEligibleForBNPLPaymentFallbackUseCase2;
        this.setIsUserSeenBNPLPaymentFallbackOptionUseCase = setIsUserSeenBNPLPaymentFallbackOptionUseCase2;
    }

    public /* synthetic */ BNPLManagerViewModelFactory(BNPLTracker bNPLTracker2, GetBNPLInstallmentsUseCase getBNPLInstallmentsUseCase2, GetPayOrderWithBNPLUseCase getPayOrderWithBNPLUseCase2, LocationConfigurationRepository locationConfigurationRepository2, IsUserEligibleForBNPLPaymentFallbackUseCase isUserEligibleForBNPLPaymentFallbackUseCase2, SetIsUserSeenBNPLPaymentFallbackOptionUseCase setIsUserSeenBNPLPaymentFallbackOptionUseCase2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bNPLTracker2, getBNPLInstallmentsUseCase2, getPayOrderWithBNPLUseCase2, locationConfigurationRepository2, isUserEligibleForBNPLPaymentFallbackUseCase2, setIsUserSeenBNPLPaymentFallbackOptionUseCase2);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        T t11 = mockedBNPLManagerViewModel;
        return t11 == null ? new BNPLManagerViewModel(this.bNPLTracker, this.getBNPLInstallmentsUseCase, this.getPayOrderWithBNPLUseCase, this.locationConfigurationRepository, this.isUserEligibleForBNPLPaymentFallbackUseCase, this.setIsUserSeenBNPLPaymentFallbackOptionUseCase) : t11;
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J.\u0010\n\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/talabat/wallet/bnplmanager/di/factory/BNPLManagerViewModelFactory$Companion;", "", "()V", "mockedBNPLManagerViewModel", "Lcom/talabat/wallet/bnplmanager/presentation/viewmodel/BNPLManagerViewModel;", "getMockedBNPLManagerViewModel$annotations", "getMockedBNPLManagerViewModel", "()Lcom/talabat/wallet/bnplmanager/presentation/viewmodel/BNPLManagerViewModel;", "setMockedBNPLManagerViewModel", "(Lcom/talabat/wallet/bnplmanager/presentation/viewmodel/BNPLManagerViewModel;)V", "create", "Lcom/talabat/wallet/bnplmanager/di/factory/BNPLManagerViewModelFactory;", "activity", "Landroid/app/Activity;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "bnplManagerLocalDataSource", "Lcom/talabat/wallet/bnplmanager/data/local/BNPLManagerLocalDataSource;", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getMockedBNPLManagerViewModel$annotations() {
        }

        @NotNull
        public final BNPLManagerViewModelFactory create(@NotNull Activity activity, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IObservabilityManager iObservabilityManager, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
            Activity activity2 = activity;
            ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
            IObservabilityManager iObservabilityManager2 = iObservabilityManager;
            BNPLManagerLocalDataSource bNPLManagerLocalDataSource2 = bNPLManagerLocalDataSource;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "featureFlagRepo");
            Intrinsics.checkNotNullParameter(iObservabilityManager2, "observabilityManager");
            ConfigurationLocalRepository configurationLocalRepository2 = configurationLocalRepository;
            Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
            Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
            Intrinsics.checkNotNullParameter(bNPLManagerLocalDataSource2, "bnplManagerLocalDataSource");
            AppTracker appTracker = new AppTracker(new TalabatGTM());
            BNPLManagerModule bNPLManagerModule = BNPLManagerModule.INSTANCE;
            LocationConfigurationRepository locationConfigurationRepository2 = locationConfigurationRepository;
            return new BNPLManagerViewModelFactory(new BNPLTrackerImpl(activity, appTracker, bNPLManagerModule.provideTalabatTracker(activity), bNPLManagerModule.provideIsTalabatTrackerEnabledForBNPL(iTalabatFeatureFlag2), configurationLocalRepository2, locationConfigurationRepository2), bNPLManagerModule.provideGetBNPLInstallmentsUseCase(activity, iObservabilityManager2, bNPLManagerLocalDataSource2), bNPLManagerModule.provideGetPayOrderWithBNPLUseCase(activity, iObservabilityManager2, bNPLManagerLocalDataSource2), locationConfigurationRepository2, (IsUserEligibleForBNPLPaymentFallbackUseCase) null, (SetIsUserSeenBNPLPaymentFallbackOptionUseCase) null, (DefaultConstructorMarker) null);
        }

        @Nullable
        public final BNPLManagerViewModel getMockedBNPLManagerViewModel() {
            return BNPLManagerViewModelFactory.mockedBNPLManagerViewModel;
        }

        public final void setMockedBNPLManagerViewModel(@Nullable BNPLManagerViewModel bNPLManagerViewModel) {
            BNPLManagerViewModelFactory.mockedBNPLManagerViewModel = bNPLManagerViewModel;
        }

        @NotNull
        public final BNPLManagerViewModel create(@NotNull AppCompatActivity appCompatActivity, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull IObservabilityManager iObservabilityManager, @NotNull BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
            AppCompatActivity appCompatActivity2 = appCompatActivity;
            IObservabilityManager iObservabilityManager2 = iObservabilityManager;
            BNPLManagerLocalDataSource bNPLManagerLocalDataSource2 = bNPLManagerLocalDataSource;
            Intrinsics.checkNotNullParameter(appCompatActivity2, "appCompatActivity");
            Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
            Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
            Intrinsics.checkNotNullParameter(iObservabilityManager2, "observabilityManager");
            Intrinsics.checkNotNullParameter(bNPLManagerLocalDataSource2, "bnplManagerLocalDataSource");
            DomainModule domainModule = DomainModule.INSTANCE;
            Application application = appCompatActivity.getApplication();
            if (application != null) {
                ITalabatFeatureFlag provideFeatureFlagRepository = domainModule.provideFeatureFlagRepository((ApiContainer) application);
                Application application2 = appCompatActivity.getApplication();
                if (application2 != null) {
                    ITalabatExperiment experimentProvider = ((ExperimentCoreLibApi) ((ApiContainer) application2).getFeature(ExperimentCoreLibApi.class)).getExperimentProvider();
                    BNPLManagerViewModel mockedBNPLManagerViewModel = getMockedBNPLManagerViewModel();
                    if (mockedBNPLManagerViewModel != null) {
                        return mockedBNPLManagerViewModel;
                    }
                    AppTracker appTracker = new AppTracker(new TalabatGTM());
                    BNPLManagerModule bNPLManagerModule = BNPLManagerModule.INSTANCE;
                    BNPLManagerModule bNPLManagerModule2 = bNPLManagerModule;
                    BNPLManagerViewModelFactory bNPLManagerViewModelFactory = r8;
                    BNPLManagerViewModelFactory bNPLManagerViewModelFactory2 = new BNPLManagerViewModelFactory(new BNPLTrackerImpl(appCompatActivity, appTracker, bNPLManagerModule.provideTalabatTracker(appCompatActivity2), bNPLManagerModule.provideIsTalabatTrackerEnabledForBNPL(provideFeatureFlagRepository), configurationLocalRepository, locationConfigurationRepository), bNPLManagerModule2.provideGetBNPLInstallmentsUseCase(appCompatActivity2, iObservabilityManager2, bNPLManagerLocalDataSource2), bNPLManagerModule2.provideGetPayOrderWithBNPLUseCase(appCompatActivity2, iObservabilityManager2, bNPLManagerLocalDataSource2), locationConfigurationRepository, bNPLManagerModule2.provideIsUserEligibleForBNPLPaymentFallbackUseCase(appCompatActivity2, provideFeatureFlagRepository, experimentProvider, bNPLManagerLocalDataSource2), bNPLManagerModule2.provideSetIsUserSeenBNPLPaymentFallbackOptionUseCase(appCompatActivity2, bNPLManagerLocalDataSource2), (DefaultConstructorMarker) null);
                    return (BNPLManagerViewModel) new ViewModelProvider((ViewModelStoreOwner) appCompatActivity2, (ViewModelProvider.Factory) bNPLManagerViewModelFactory).get(BNPLManagerViewModel.class);
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
        }
    }
}
