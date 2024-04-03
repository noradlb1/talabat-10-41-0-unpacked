package com.talabat.feature.darkstoresflutter.data.mapper;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterMapToProductMapper_Factory implements Factory<FlutterMapToProductMapper> {
    private final Provider<Moshi> moshiProvider;

    public FlutterMapToProductMapper_Factory(Provider<Moshi> provider) {
        this.moshiProvider = provider;
    }

    public static FlutterMapToProductMapper_Factory create(Provider<Moshi> provider) {
        return new FlutterMapToProductMapper_Factory(provider);
    }

    public static FlutterMapToProductMapper newInstance(Moshi moshi) {
        return new FlutterMapToProductMapper(moshi);
    }

    public FlutterMapToProductMapper get() {
        return newInstance(this.moshiProvider.get());
    }
}
