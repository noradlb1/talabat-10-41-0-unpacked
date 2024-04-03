package com.talabat.app.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsFeatureImplLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsFeatureLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FeaturesModule_FlutterChannelsFeatureLibApiFactory implements Factory<FlutterChannelsFeatureLibApi> {
    private final Provider<DispatcherCoreLibApi> dispatcherCoreLibApiProvider;
    private final Provider<FlutterChannelsFeatureImplLibApi> flutterChannelsFeatureImplLibApiProvider;

    public FeaturesModule_FlutterChannelsFeatureLibApiFactory(Provider<DispatcherCoreLibApi> provider, Provider<FlutterChannelsFeatureImplLibApi> provider2) {
        this.dispatcherCoreLibApiProvider = provider;
        this.flutterChannelsFeatureImplLibApiProvider = provider2;
    }

    public static FeaturesModule_FlutterChannelsFeatureLibApiFactory create(Provider<DispatcherCoreLibApi> provider, Provider<FlutterChannelsFeatureImplLibApi> provider2) {
        return new FeaturesModule_FlutterChannelsFeatureLibApiFactory(provider, provider2);
    }

    public static FlutterChannelsFeatureLibApi flutterChannelsFeatureLibApi(DispatcherCoreLibApi dispatcherCoreLibApi, FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi) {
        return (FlutterChannelsFeatureLibApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.flutterChannelsFeatureLibApi(dispatcherCoreLibApi, flutterChannelsFeatureImplLibApi));
    }

    public FlutterChannelsFeatureLibApi get() {
        return flutterChannelsFeatureLibApi(this.dispatcherCoreLibApiProvider.get(), this.flutterChannelsFeatureImplLibApiProvider.get());
    }
}
