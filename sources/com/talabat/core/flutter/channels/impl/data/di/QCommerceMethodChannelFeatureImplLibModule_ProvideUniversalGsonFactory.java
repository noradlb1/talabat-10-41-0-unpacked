package com.talabat.core.flutter.channels.impl.data.di;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class QCommerceMethodChannelFeatureImplLibModule_ProvideUniversalGsonFactory implements Factory<Gson> {
    private final QCommerceMethodChannelFeatureImplLibModule module;

    public QCommerceMethodChannelFeatureImplLibModule_ProvideUniversalGsonFactory(QCommerceMethodChannelFeatureImplLibModule qCommerceMethodChannelFeatureImplLibModule) {
        this.module = qCommerceMethodChannelFeatureImplLibModule;
    }

    public static QCommerceMethodChannelFeatureImplLibModule_ProvideUniversalGsonFactory create(QCommerceMethodChannelFeatureImplLibModule qCommerceMethodChannelFeatureImplLibModule) {
        return new QCommerceMethodChannelFeatureImplLibModule_ProvideUniversalGsonFactory(qCommerceMethodChannelFeatureImplLibModule);
    }

    public static Gson provideUniversalGson(QCommerceMethodChannelFeatureImplLibModule qCommerceMethodChannelFeatureImplLibModule) {
        return (Gson) Preconditions.checkNotNullFromProvides(qCommerceMethodChannelFeatureImplLibModule.provideUniversalGson());
    }

    public Gson get() {
        return provideUniversalGson(this.module);
    }
}
