package com.talabat.feature.subscriptions.data.tracking;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.helpers.DateUtils;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionsTracker_Factory implements Factory<SubscriptionsTracker> {
    private final Provider<DateUtils> dateUtilsProvider;
    private final Provider<IntegrationGlobalDataModel.Companion> globalDataModelProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public SubscriptionsTracker_Factory(Provider<TalabatTracker> provider, Provider<IntegrationGlobalDataModel.Companion> provider2, Provider<DateUtils> provider3) {
        this.talabatTrackerProvider = provider;
        this.globalDataModelProvider = provider2;
        this.dateUtilsProvider = provider3;
    }

    public static SubscriptionsTracker_Factory create(Provider<TalabatTracker> provider, Provider<IntegrationGlobalDataModel.Companion> provider2, Provider<DateUtils> provider3) {
        return new SubscriptionsTracker_Factory(provider, provider2, provider3);
    }

    public static SubscriptionsTracker newInstance(TalabatTracker talabatTracker, IntegrationGlobalDataModel.Companion companion, DateUtils dateUtils) {
        return new SubscriptionsTracker(talabatTracker, companion, dateUtils);
    }

    public SubscriptionsTracker get() {
        return newInstance(this.talabatTrackerProvider.get(), this.globalDataModelProvider.get(), this.dateUtilsProvider.get());
    }
}
