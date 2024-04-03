package com.talabat.feature.tpro.presentation.di;

import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TproPresentationModule_ProvideTalabatRemoteConfigFactory implements Factory<RemoteConfiguration> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TproPresentationModule_ProvideTalabatRemoteConfigFactory INSTANCE = new TproPresentationModule_ProvideTalabatRemoteConfigFactory();

        private InstanceHolder() {
        }
    }

    public static TproPresentationModule_ProvideTalabatRemoteConfigFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RemoteConfiguration provideTalabatRemoteConfig() {
        return (RemoteConfiguration) Preconditions.checkNotNullFromProvides(TproPresentationModule.INSTANCE.provideTalabatRemoteConfig());
    }

    public RemoteConfiguration get() {
        return provideTalabatRemoteConfig();
    }
}
