package com.talabat.gms.maps.data.model;

import com.google.android.gms.maps.model.CircleOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsCircleOptionsWrapper_Factory implements Factory<GmsCircleOptionsWrapper> {
    private final Provider<CircleOptions> googleCircleOptionsProvider;

    public GmsCircleOptionsWrapper_Factory(Provider<CircleOptions> provider) {
        this.googleCircleOptionsProvider = provider;
    }

    public static GmsCircleOptionsWrapper_Factory create(Provider<CircleOptions> provider) {
        return new GmsCircleOptionsWrapper_Factory(provider);
    }

    public static GmsCircleOptionsWrapper newInstance(CircleOptions circleOptions) {
        return new GmsCircleOptionsWrapper(circleOptions);
    }

    public GmsCircleOptionsWrapper get() {
        return newInstance(this.googleCircleOptionsProvider.get());
    }
}
