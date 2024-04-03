package com.talabat.core.flutter.channels.impl.data.di;

import android.content.Context;
import com.talabat.application.device.id.domain.DeviceIdProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreImplLibModule_Companion_ProvideDeviceIdProviderImplFactory implements Factory<DeviceIdProvider> {
    private final Provider<Context> contextProvider;

    public FlutterChannelsCoreImplLibModule_Companion_ProvideDeviceIdProviderImplFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static FlutterChannelsCoreImplLibModule_Companion_ProvideDeviceIdProviderImplFactory create(Provider<Context> provider) {
        return new FlutterChannelsCoreImplLibModule_Companion_ProvideDeviceIdProviderImplFactory(provider);
    }

    public static DeviceIdProvider provideDeviceIdProviderImpl(Context context) {
        return (DeviceIdProvider) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreImplLibModule.Companion.provideDeviceIdProviderImpl(context));
    }

    public DeviceIdProvider get() {
        return provideDeviceIdProviderImpl(this.contextProvider.get());
    }
}
