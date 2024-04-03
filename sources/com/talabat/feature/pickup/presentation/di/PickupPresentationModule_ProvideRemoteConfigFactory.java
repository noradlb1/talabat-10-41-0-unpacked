package com.talabat.feature.pickup.presentation.di;

import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PickupPresentationModule_ProvideRemoteConfigFactory implements Factory<RemoteConfiguration> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PickupPresentationModule_ProvideRemoteConfigFactory INSTANCE = new PickupPresentationModule_ProvideRemoteConfigFactory();

        private InstanceHolder() {
        }
    }

    public static PickupPresentationModule_ProvideRemoteConfigFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RemoteConfiguration provideRemoteConfig() {
        return (RemoteConfiguration) Preconditions.checkNotNullFromProvides(PickupPresentationModule.INSTANCE.provideRemoteConfig());
    }

    public RemoteConfiguration get() {
        return provideRemoteConfig();
    }
}
