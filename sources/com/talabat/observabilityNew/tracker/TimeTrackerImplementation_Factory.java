package com.talabat.observabilityNew.tracker;

import com.talabat.observabilityNew.ObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.HashMap;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.observabilityNew.data.di.TimeCacheMap"})
public final class TimeTrackerImplementation_Factory implements Factory<TimeTrackerImplementation> {
    private final Provider<ObservabilityManager> observabilityManagerProvider;
    private final Provider<HashMap<Object, TimeTrackingData>> timesCacheProvider;

    public TimeTrackerImplementation_Factory(Provider<HashMap<Object, TimeTrackingData>> provider, Provider<ObservabilityManager> provider2) {
        this.timesCacheProvider = provider;
        this.observabilityManagerProvider = provider2;
    }

    public static TimeTrackerImplementation_Factory create(Provider<HashMap<Object, TimeTrackingData>> provider, Provider<ObservabilityManager> provider2) {
        return new TimeTrackerImplementation_Factory(provider, provider2);
    }

    public static TimeTrackerImplementation newInstance(HashMap<Object, TimeTrackingData> hashMap) {
        return new TimeTrackerImplementation(hashMap);
    }

    public TimeTrackerImplementation get() {
        TimeTrackerImplementation newInstance = newInstance(this.timesCacheProvider.get());
        TimeTrackerImplementation_MembersInjector.injectObservabilityManager(newInstance, this.observabilityManagerProvider.get());
        return newInstance;
    }
}
