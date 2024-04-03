package com.talabat.feature.helpcenter.presentation;

import com.talabat.feature.cancellationpolicy.domain.IHelpCenterEventTracker;
import com.talabat.feature.cancellationpolicy.domain.repo.ICancellationPolicyRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CancellationPolicyViewModel_Factory implements Factory<CancellationPolicyViewModel> {
    private final Provider<ICancellationPolicyItemDisplayMapper> cancellationPolicyItemDisplayMapperProvider;
    private final Provider<ICancellationPolicyRepository> cancellationPolicyRepositoryProvider;
    private final Provider<IHelpCenterEventTracker> helpCenterEventTrackerProvider;

    public CancellationPolicyViewModel_Factory(Provider<ICancellationPolicyRepository> provider, Provider<ICancellationPolicyItemDisplayMapper> provider2, Provider<IHelpCenterEventTracker> provider3) {
        this.cancellationPolicyRepositoryProvider = provider;
        this.cancellationPolicyItemDisplayMapperProvider = provider2;
        this.helpCenterEventTrackerProvider = provider3;
    }

    public static CancellationPolicyViewModel_Factory create(Provider<ICancellationPolicyRepository> provider, Provider<ICancellationPolicyItemDisplayMapper> provider2, Provider<IHelpCenterEventTracker> provider3) {
        return new CancellationPolicyViewModel_Factory(provider, provider2, provider3);
    }

    public static CancellationPolicyViewModel newInstance(ICancellationPolicyRepository iCancellationPolicyRepository, ICancellationPolicyItemDisplayMapper iCancellationPolicyItemDisplayMapper, IHelpCenterEventTracker iHelpCenterEventTracker) {
        return new CancellationPolicyViewModel(iCancellationPolicyRepository, iCancellationPolicyItemDisplayMapper, iHelpCenterEventTracker);
    }

    public CancellationPolicyViewModel get() {
        return newInstance(this.cancellationPolicyRepositoryProvider.get(), this.cancellationPolicyItemDisplayMapperProvider.get(), this.helpCenterEventTrackerProvider.get());
    }
}
