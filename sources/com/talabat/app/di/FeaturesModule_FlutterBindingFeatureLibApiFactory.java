package com.talabat.app.di;

import com.talabat.core.flutter.binding.domain.di.FlutterBindingFeatureLibApi;
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
public final class FeaturesModule_FlutterBindingFeatureLibApiFactory implements Factory<FlutterBindingFeatureLibApi> {
    private final Provider<FlutterChannelsFeatureLibApi> flutterChannelsFeatureLibApiProvider;

    public FeaturesModule_FlutterBindingFeatureLibApiFactory(Provider<FlutterChannelsFeatureLibApi> provider) {
        this.flutterChannelsFeatureLibApiProvider = provider;
    }

    public static FeaturesModule_FlutterBindingFeatureLibApiFactory create(Provider<FlutterChannelsFeatureLibApi> provider) {
        return new FeaturesModule_FlutterBindingFeatureLibApiFactory(provider);
    }

    public static FlutterBindingFeatureLibApi flutterBindingFeatureLibApi(FlutterChannelsFeatureLibApi flutterChannelsFeatureLibApi) {
        return (FlutterBindingFeatureLibApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.flutterBindingFeatureLibApi(flutterChannelsFeatureLibApi));
    }

    public FlutterBindingFeatureLibApi get() {
        return flutterBindingFeatureLibApi(this.flutterChannelsFeatureLibApiProvider.get());
    }
}
