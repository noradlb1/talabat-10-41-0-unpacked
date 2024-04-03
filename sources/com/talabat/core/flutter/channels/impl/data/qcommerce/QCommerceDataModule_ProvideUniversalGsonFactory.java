package com.talabat.core.flutter.channels.impl.data.qcommerce;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class QCommerceDataModule_ProvideUniversalGsonFactory implements Factory<Gson> {
    private final QCommerceDataModule module;

    public QCommerceDataModule_ProvideUniversalGsonFactory(QCommerceDataModule qCommerceDataModule) {
        this.module = qCommerceDataModule;
    }

    public static QCommerceDataModule_ProvideUniversalGsonFactory create(QCommerceDataModule qCommerceDataModule) {
        return new QCommerceDataModule_ProvideUniversalGsonFactory(qCommerceDataModule);
    }

    public static Gson provideUniversalGson(QCommerceDataModule qCommerceDataModule) {
        return (Gson) Preconditions.checkNotNullFromProvides(qCommerceDataModule.provideUniversalGson());
    }

    public Gson get() {
        return provideUniversalGson(this.module);
    }
}
