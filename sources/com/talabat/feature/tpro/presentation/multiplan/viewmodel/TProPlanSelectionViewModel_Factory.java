package com.talabat.feature.tpro.presentation.multiplan.viewmodel;

import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProPlanSelectionViewModel_Factory implements Factory<TProPlanSelectionViewModel> {
    private final Provider<ISubscriptionsTracker> subscriptionsTrackerProvider;

    public TProPlanSelectionViewModel_Factory(Provider<ISubscriptionsTracker> provider) {
        this.subscriptionsTrackerProvider = provider;
    }

    public static TProPlanSelectionViewModel_Factory create(Provider<ISubscriptionsTracker> provider) {
        return new TProPlanSelectionViewModel_Factory(provider);
    }

    public static TProPlanSelectionViewModel newInstance(ISubscriptionsTracker iSubscriptionsTracker) {
        return new TProPlanSelectionViewModel(iSubscriptionsTracker);
    }

    public TProPlanSelectionViewModel get() {
        return newInstance(this.subscriptionsTrackerProvider.get());
    }
}
