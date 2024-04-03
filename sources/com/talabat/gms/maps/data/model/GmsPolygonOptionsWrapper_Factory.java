package com.talabat.gms.maps.data.model;

import com.google.android.gms.maps.model.PolygonOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsPolygonOptionsWrapper_Factory implements Factory<GmsPolygonOptionsWrapper> {
    private final Provider<PolygonOptions> googlePolygonOptionsProvider;

    public GmsPolygonOptionsWrapper_Factory(Provider<PolygonOptions> provider) {
        this.googlePolygonOptionsProvider = provider;
    }

    public static GmsPolygonOptionsWrapper_Factory create(Provider<PolygonOptions> provider) {
        return new GmsPolygonOptionsWrapper_Factory(provider);
    }

    public static GmsPolygonOptionsWrapper newInstance(PolygonOptions polygonOptions) {
        return new GmsPolygonOptionsWrapper(polygonOptions);
    }

    public GmsPolygonOptionsWrapper get() {
        return newInstance(this.googlePolygonOptionsProvider.get());
    }
}
