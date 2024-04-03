package com.talabat.gms.maps.data.di;

import com.google.android.gms.maps.model.CircleOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GoogleModule_GoogleCircleOptionsFactory implements Factory<CircleOptions> {
    private final GoogleModule module;

    public GoogleModule_GoogleCircleOptionsFactory(GoogleModule googleModule) {
        this.module = googleModule;
    }

    public static GoogleModule_GoogleCircleOptionsFactory create(GoogleModule googleModule) {
        return new GoogleModule_GoogleCircleOptionsFactory(googleModule);
    }

    public static CircleOptions googleCircleOptions(GoogleModule googleModule) {
        return (CircleOptions) Preconditions.checkNotNullFromProvides(googleModule.googleCircleOptions());
    }

    public CircleOptions get() {
        return googleCircleOptions(this.module);
    }
}
