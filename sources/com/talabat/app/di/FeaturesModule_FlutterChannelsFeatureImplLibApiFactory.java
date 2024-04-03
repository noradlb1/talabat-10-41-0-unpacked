package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsFeatureImplLibApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class FeaturesModule_FlutterChannelsFeatureImplLibApiFactory implements Factory<FlutterChannelsFeatureImplLibApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;
    private final Provider<SubscriptionsFeatureApi> subscriptionsFeatureApiProvider;

    public FeaturesModule_FlutterChannelsFeatureImplLibApiFactory(Provider<Map<Class<?>, Api>> provider, Provider<SubscriptionsFeatureApi> provider2) {
        this.coreApisProvider = provider;
        this.subscriptionsFeatureApiProvider = provider2;
    }

    public static FeaturesModule_FlutterChannelsFeatureImplLibApiFactory create(Provider<Map<Class<?>, Api>> provider, Provider<SubscriptionsFeatureApi> provider2) {
        return new FeaturesModule_FlutterChannelsFeatureImplLibApiFactory(provider, provider2);
    }

    public static FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi(Map<Class<?>, Api> map, SubscriptionsFeatureApi subscriptionsFeatureApi) {
        return (FlutterChannelsFeatureImplLibApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.flutterChannelsFeatureImplLibApi(map, subscriptionsFeatureApi));
    }

    public FlutterChannelsFeatureImplLibApi get() {
        return flutterChannelsFeatureImplLibApi(this.coreApisProvider.get(), this.subscriptionsFeatureApiProvider.get());
    }
}
