package com.talabat.wallet.bnplmanager.di.module;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.endpoint.BNPLEndPointProvider;
import com.talabat.core.network.network.OKHttpBuilder;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl;
import com.talabat.wallet.bnplmanager.data.local.BNPLManagerLocalDataSource;
import com.talabat.wallet.bnplmanager.data.remote.api.BNPLEligibilityApi;
import com.talabat.wallet.bnplmanager.data.remote.api.BNPLManagerApi;
import com.talabat.wallet.bnplmanager.data.remote.impl.BNPLManagerRemoteDataSourceImpl;
import com.talabat.wallet.bnplmanager.domain.application.usecase.GetBnplFeatureFlagUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligibilityUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLInstallmentsUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLPlansUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetPayOrderWithBNPLUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.IsUserEligibleForBNPLPaymentFallbackUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.SetIsUserSeenBNPLPaymentFallbackOptionUseCase;
import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
import com.talabat.wallet.bnplmanager.domain.tracking.BNPLTrackerImpl;
import com.talabat.wallet.bnplmanager.domain.tracking.IsTalabatTrackerEnabledForBNPL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import library.talabat.mvp.login.di.DependencyProvider;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0002J6\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010#\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(¨\u0006)"}, d2 = {"Lcom/talabat/wallet/bnplmanager/di/module/BNPLManagerModule;", "", "()V", "provideBNPLManagerRepository", "Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;", "context", "Landroid/content/Context;", "bnplManagerLocalDataSource", "Lcom/talabat/wallet/bnplmanager/data/local/BNPLManagerLocalDataSource;", "provideGetBNPLEligibilityUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLEligibilityUseCase;", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "provideGetBNPLEligiblePlanUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLEligiblePlanUseCase;", "provideGetBNPLInstallmentsUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLInstallmentsUseCase;", "provideGetBNPLPlansUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLPlansUseCase;", "provideGetPayOrderWithBNPLUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetPayOrderWithBNPLUseCase;", "provideIsTalabatTrackerEnabledForBNPL", "Lcom/talabat/wallet/bnplmanager/domain/tracking/IsTalabatTrackerEnabledForBNPL;", "provideIsUserEligibleForBNPLPaymentFallbackUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/IsUserEligibleForBNPLPaymentFallbackUseCase;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "provideSetIsUserSeenBNPLPaymentFallbackOptionUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/SetIsUserSeenBNPLPaymentFallbackOptionUseCase;", "provideTalabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "activity", "Landroid/app/Activity;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLManagerModule {
    @NotNull
    public static final BNPLManagerModule INSTANCE = new BNPLManagerModule();

    private BNPLManagerModule() {
    }

    private final BNPLManagerRepository provideBNPLManagerRepository(Context context, BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
        TalabatAPIBuilder talabatAPIBuilder = new TalabatAPIBuilder();
        BNPLEndPointProvider bNPLEndPointProvider = BNPLEndPointProvider.INSTANCE;
        return new BNPLManagerRepositoryImpl(new BNPLManagerRemoteDataSourceImpl((BNPLManagerApi) talabatAPIBuilder.createApi(bNPLEndPointProvider.getBaseUrl(), BNPLManagerApi.class), (BNPLEligibilityApi) new TalabatAPIBuilder().createApi(bNPLEndPointProvider.getBaseUrl(), BNPLEligibilityApi.class, OKHttpBuilder.getDefaultHttpClient$default(OKHttpBuilder.INSTANCE, (List) null, 10, 1, (Object) null))), bNPLManagerLocalDataSource, context);
    }

    private final GetBNPLEligibilityUseCase provideGetBNPLEligibilityUseCase(AppCompatActivity appCompatActivity, IObservabilityManager iObservabilityManager, ITalabatFeatureFlag iTalabatFeatureFlag, ConfigurationLocalRepository configurationLocalRepository, LocationConfigurationRepository locationConfigurationRepository, BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
        ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
        IObservabilityManager iObservabilityManager2 = iObservabilityManager;
        return new GetBNPLEligibilityUseCase(provideBNPLManagerRepository(appCompatActivity, bNPLManagerLocalDataSource), Dispatchers.getIO(), new BNPLTrackerImpl(appCompatActivity, new AppTracker(new TalabatGTM()), provideTalabatTracker(appCompatActivity), provideIsTalabatTrackerEnabledForBNPL(iTalabatFeatureFlag), configurationLocalRepository, locationConfigurationRepository), iObservabilityManager);
    }

    private final GetBNPLPlansUseCase provideGetBNPLPlansUseCase(Context context, ConfigurationLocalRepository configurationLocalRepository, IObservabilityManager iObservabilityManager, BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
        return new GetBNPLPlansUseCase(provideBNPLManagerRepository(context, bNPLManagerLocalDataSource), Dispatchers.getIO(), configurationLocalRepository, iObservabilityManager);
    }

    @NotNull
    public final GetBNPLEligiblePlanUseCase provideGetBNPLEligiblePlanUseCase(@NotNull AppCompatActivity appCompatActivity, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull IObservabilityManager iObservabilityManager, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
        AppCompatActivity appCompatActivity2 = appCompatActivity;
        ConfigurationLocalRepository configurationLocalRepository2 = configurationLocalRepository;
        IObservabilityManager iObservabilityManager2 = iObservabilityManager;
        BNPLManagerLocalDataSource bNPLManagerLocalDataSource2 = bNPLManagerLocalDataSource;
        Intrinsics.checkNotNullParameter(appCompatActivity, "appCompatActivity");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager2, "observabilityManager");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        Intrinsics.checkNotNullParameter(bNPLManagerLocalDataSource2, "bnplManagerLocalDataSource");
        CustomerRepository provideCustomerRepository = DependencyProvider.INSTANCE.provideCustomerRepository(appCompatActivity);
        return new GetBNPLEligiblePlanUseCase(new GetBnplFeatureFlagUseCase(iTalabatFeatureFlag, configurationLocalRepository, (CoroutineDispatcher) null, 4, (DefaultConstructorMarker) null), provideCustomerRepository, provideGetBNPLEligibilityUseCase(appCompatActivity, iObservabilityManager, iTalabatFeatureFlag, configurationLocalRepository, locationConfigurationRepository, bNPLManagerLocalDataSource), provideGetBNPLPlansUseCase(appCompatActivity, configurationLocalRepository2, iObservabilityManager2, bNPLManagerLocalDataSource2));
    }

    @NotNull
    public final GetBNPLInstallmentsUseCase provideGetBNPLInstallmentsUseCase(@NotNull Context context, @NotNull IObservabilityManager iObservabilityManager, @NotNull BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(bNPLManagerLocalDataSource, "bnplManagerLocalDataSource");
        return new GetBNPLInstallmentsUseCase(provideBNPLManagerRepository(context, bNPLManagerLocalDataSource), Dispatchers.getIO(), iObservabilityManager);
    }

    @NotNull
    public final GetPayOrderWithBNPLUseCase provideGetPayOrderWithBNPLUseCase(@NotNull Context context, @NotNull IObservabilityManager iObservabilityManager, @NotNull BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(bNPLManagerLocalDataSource, "bnplManagerLocalDataSource");
        return new GetPayOrderWithBNPLUseCase(provideBNPLManagerRepository(context, bNPLManagerLocalDataSource), Dispatchers.getIO(), iObservabilityManager);
    }

    @NotNull
    public final IsTalabatTrackerEnabledForBNPL provideIsTalabatTrackerEnabledForBNPL(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        return new IsTalabatTrackerEnabledForBNPL(iTalabatFeatureFlag);
    }

    @NotNull
    public final IsUserEligibleForBNPLPaymentFallbackUseCase provideIsUserEligibleForBNPLPaymentFallbackUseCase(@NotNull Context context, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(bNPLManagerLocalDataSource, "bnplManagerLocalDataSource");
        return new IsUserEligibleForBNPLPaymentFallbackUseCase(provideBNPLManagerRepository(context, bNPLManagerLocalDataSource), Dispatchers.getIO(), iTalabatExperiment, iTalabatFeatureFlag);
    }

    @NotNull
    public final SetIsUserSeenBNPLPaymentFallbackOptionUseCase provideSetIsUserSeenBNPLPaymentFallbackOptionUseCase(@NotNull Context context, @NotNull BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bNPLManagerLocalDataSource, "bnplManagerLocalDataSource");
        return new SetIsUserSeenBNPLPaymentFallbackOptionUseCase(provideBNPLManagerRepository(context, bNPLManagerLocalDataSource), Dispatchers.getIO());
    }

    @NotNull
    public final TalabatTracker provideTalabatTracker(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return ((TrackingCoreLibApi) AndroidComponentsKt.apiContainer(activity).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
    }
}
