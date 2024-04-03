package com.talabat.observabilityNew.tracker;

import com.talabat.observabilityNew.ObservabilityManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TimeTrackerImplementation_MembersInjector implements MembersInjector<TimeTrackerImplementation> {
    private final Provider<ObservabilityManager> observabilityManagerProvider;

    public TimeTrackerImplementation_MembersInjector(Provider<ObservabilityManager> provider) {
        this.observabilityManagerProvider = provider;
    }

    public static MembersInjector<TimeTrackerImplementation> create(Provider<ObservabilityManager> provider) {
        return new TimeTrackerImplementation_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.observabilityNew.tracker.TimeTrackerImplementation.observabilityManager")
    public static void injectObservabilityManager(TimeTrackerImplementation timeTrackerImplementation, ObservabilityManager observabilityManager) {
        timeTrackerImplementation.observabilityManager = observabilityManager;
    }

    public void injectMembers(TimeTrackerImplementation timeTrackerImplementation) {
        injectObservabilityManager(timeTrackerImplementation, this.observabilityManagerProvider.get());
    }
}
