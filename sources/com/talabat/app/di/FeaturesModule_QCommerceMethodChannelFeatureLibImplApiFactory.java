package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.flutter.channels.domain.di.QCommerceMethodChannelFeatureLibImplApi;
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
public final class FeaturesModule_QCommerceMethodChannelFeatureLibImplApiFactory implements Factory<QCommerceMethodChannelFeatureLibImplApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_QCommerceMethodChannelFeatureLibImplApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_QCommerceMethodChannelFeatureLibImplApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_QCommerceMethodChannelFeatureLibImplApiFactory(provider);
    }

    public static QCommerceMethodChannelFeatureLibImplApi qCommerceMethodChannelFeatureLibImplApi(Map<Class<?>, Api> map) {
        return (QCommerceMethodChannelFeatureLibImplApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.qCommerceMethodChannelFeatureLibImplApi(map));
    }

    public QCommerceMethodChannelFeatureLibImplApi get() {
        return qCommerceMethodChannelFeatureLibImplApi(this.coreApisProvider.get());
    }
}
