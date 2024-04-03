package com.talabat.core.flutter.channels.impl.data.di;

import com.talabat.location.SelectedLocationProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreImplLibModule_Companion_ProvideSelectedLocationProviderImplFactory implements Factory<SelectedLocationProvider> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FlutterChannelsCoreImplLibModule_Companion_ProvideSelectedLocationProviderImplFactory INSTANCE = new FlutterChannelsCoreImplLibModule_Companion_ProvideSelectedLocationProviderImplFactory();

        private InstanceHolder() {
        }
    }

    public static FlutterChannelsCoreImplLibModule_Companion_ProvideSelectedLocationProviderImplFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SelectedLocationProvider provideSelectedLocationProviderImpl() {
        return (SelectedLocationProvider) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreImplLibModule.Companion.provideSelectedLocationProviderImpl());
    }

    public SelectedLocationProvider get() {
        return provideSelectedLocationProviderImpl();
    }
}
