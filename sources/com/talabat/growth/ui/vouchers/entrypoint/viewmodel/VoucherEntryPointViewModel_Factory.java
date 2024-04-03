package com.talabat.growth.ui.vouchers.entrypoint.viewmodel;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ActiveVouchersUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.VoucherCountTextUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VoucherEntryPointViewModel_Factory implements Factory<VoucherEntryPointViewModel> {
    private final Provider<ActiveVouchersUseCase> activeVouchersUseCaseProvider;
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<GrowthTracker> growthTrackerProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<VoucherCountTextUseCase> voucherCountTextUseCaseProvider;

    public VoucherEntryPointViewModel_Factory(Provider<ActiveVouchersUseCase> provider, Provider<VoucherCountTextUseCase> provider2, Provider<ConfigurationLocalCoreLibApi> provider3, Provider<CoroutineDispatchersFactory> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<IObservabilityManager> provider6, Provider<GrowthTracker> provider7) {
        this.activeVouchersUseCaseProvider = provider;
        this.voucherCountTextUseCaseProvider = provider2;
        this.configurationLocalCoreLibApiProvider = provider3;
        this.coroutineDispatchersFactoryProvider = provider4;
        this.talabatFeatureFlagProvider = provider5;
        this.observabilityManagerProvider = provider6;
        this.growthTrackerProvider = provider7;
    }

    public static VoucherEntryPointViewModel_Factory create(Provider<ActiveVouchersUseCase> provider, Provider<VoucherCountTextUseCase> provider2, Provider<ConfigurationLocalCoreLibApi> provider3, Provider<CoroutineDispatchersFactory> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<IObservabilityManager> provider6, Provider<GrowthTracker> provider7) {
        return new VoucherEntryPointViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static VoucherEntryPointViewModel newInstance(ActiveVouchersUseCase activeVouchersUseCase, VoucherCountTextUseCase voucherCountTextUseCase, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, CoroutineDispatchersFactory coroutineDispatchersFactory, ITalabatFeatureFlag iTalabatFeatureFlag, IObservabilityManager iObservabilityManager, GrowthTracker growthTracker) {
        return new VoucherEntryPointViewModel(activeVouchersUseCase, voucherCountTextUseCase, configurationLocalCoreLibApi, coroutineDispatchersFactory, iTalabatFeatureFlag, iObservabilityManager, growthTracker);
    }

    public VoucherEntryPointViewModel get() {
        return newInstance(this.activeVouchersUseCaseProvider.get(), this.voucherCountTextUseCaseProvider.get(), this.configurationLocalCoreLibApiProvider.get(), this.coroutineDispatchersFactoryProvider.get(), this.talabatFeatureFlagProvider.get(), this.observabilityManagerProvider.get(), this.growthTrackerProvider.get());
    }
}
