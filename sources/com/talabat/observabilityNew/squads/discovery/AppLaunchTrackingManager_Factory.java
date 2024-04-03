package com.talabat.observabilityNew.squads.discovery;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AppLaunchTrackingManager_Factory implements Factory<AppLaunchTrackingManager> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public AppLaunchTrackingManager_Factory(Provider<IObservabilityManager> provider) {
        this.observabilityManagerProvider = provider;
    }

    public static AppLaunchTrackingManager_Factory create(Provider<IObservabilityManager> provider) {
        return new AppLaunchTrackingManager_Factory(provider);
    }

    public static AppLaunchTrackingManager newInstance(IObservabilityManager iObservabilityManager) {
        return new AppLaunchTrackingManager(iObservabilityManager);
    }

    public AppLaunchTrackingManager get() {
        return newInstance(this.observabilityManagerProvider.get());
    }
}
