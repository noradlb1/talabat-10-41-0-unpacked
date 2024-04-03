package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.nfvinvendorsearch.domain.di.QCommerceFlutterFeatureApi;
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
public final class FeaturesModule_QCommerceFlutterFeatureApiFactory implements Factory<QCommerceFlutterFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_QCommerceFlutterFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_QCommerceFlutterFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_QCommerceFlutterFeatureApiFactory(provider);
    }

    public static QCommerceFlutterFeatureApi qCommerceFlutterFeatureApi(Map<Class<?>, Api> map) {
        return (QCommerceFlutterFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.qCommerceFlutterFeatureApi(map));
    }

    public QCommerceFlutterFeatureApi get() {
        return qCommerceFlutterFeatureApi(this.coreApisProvider.get());
    }
}
