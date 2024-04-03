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
public final class FlutterCartToMapMapper_Factory implements Factory<FlutterCartToMapMapper> {
    private final Provider<Moshi> moshiProvider;

    public FlutterCartToMapMapper_Factory(Provider<Moshi> provider) {
        this.moshiProvider = provider;
    }

    public static FlutterCartToMapMapper_Factory create(Provider<Moshi> provider) {
        return new FlutterCartToMapMapper_Factory(provider);
    }

    public static FlutterCartToMapMapper newInstance(Moshi moshi) {
        return new FlutterCartToMapMapper(moshi);
    }

    public FlutterCartToMapMapper get() {
        return newInstance(this.moshiProvider.get());
    }
}
