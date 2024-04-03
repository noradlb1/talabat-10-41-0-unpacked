package com.talabat.core.flutter.channels.impl.data.di;

import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreImplLibModule_Companion_ProvideRemoteConfigurationFactory implements Factory<RemoteConfiguration> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FlutterChannelsCoreImplLibModule_Companion_ProvideRemoteConfigurationFactory INSTANCE = new FlutterChannelsCoreImplLibModule_Companion_ProvideRemoteConfigurationFactory();

        private InstanceHolder() {
        }
    }

    public static FlutterChannelsCoreImplLibModule_Companion_ProvideRemoteConfigurationFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RemoteConfiguration provideRemoteConfiguration() {
        return (RemoteConfiguration) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreImplLibModule.Companion.provideRemoteConfiguration());
    }

    public RemoteConfiguration get() {
        return provideRemoteConfiguration();
    }
}
