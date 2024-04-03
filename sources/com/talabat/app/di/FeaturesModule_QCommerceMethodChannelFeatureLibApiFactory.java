package com.talabat.app.di;

import com.talabat.core.flutter.channels.domain.di.QCommerceMethodChannelFeatureLibApi;
import com.talabat.core.flutter.channels.domain.di.QCommerceMethodChannelFeatureLibImplApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FeaturesModule_QCommerceMethodChannelFeatureLibApiFactory implements Factory<QCommerceMethodChannelFeatureLibApi> {
    private final Provider<QCommerceMethodChannelFeatureLibImplApi> qCommerceMethodChannelFeatureLibImplApiProvider;

    public FeaturesModule_QCommerceMethodChannelFeatureLibApiFactory(Provider<QCommerceMethodChannelFeatureLibImplApi> provider) {
        this.qCommerceMethodChannelFeatureLibImplApiProvider = provider;
    }

    public static FeaturesModule_QCommerceMethodChannelFeatureLibApiFactory create(Provider<QCommerceMethodChannelFeatureLibImplApi> provider) {
        return new FeaturesModule_QCommerceMethodChannelFeatureLibApiFactory(provider);
    }

    public static QCommerceMethodChannelFeatureLibApi qCommerceMethodChannelFeatureLibApi(QCommerceMethodChannelFeatureLibImplApi qCommerceMethodChannelFeatureLibImplApi) {
        return (QCommerceMethodChannelFeatureLibApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.qCommerceMethodChannelFeatureLibApi(qCommerceMethodChannelFeatureLibImplApi));
    }

    public QCommerceMethodChannelFeatureLibApi get() {
        return qCommerceMethodChannelFeatureLibApi(this.qCommerceMethodChannelFeatureLibImplApiProvider.get());
    }
}
