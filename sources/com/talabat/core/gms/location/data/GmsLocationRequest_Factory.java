package com.talabat.core.gms.location.data;

import com.google.android.gms.location.LocationRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsLocationRequest_Factory implements Factory<GmsLocationRequest> {
    private final Provider<LocationRequest> googleLocationRequestProvider;

    public GmsLocationRequest_Factory(Provider<LocationRequest> provider) {
        this.googleLocationRequestProvider = provider;
    }

    public static GmsLocationRequest_Factory create(Provider<LocationRequest> provider) {
        return new GmsLocationRequest_Factory(provider);
    }

    public static GmsLocationRequest newInstance(LocationRequest locationRequest) {
        return new GmsLocationRequest(locationRequest);
    }

    public GmsLocationRequest get() {
        return newInstance(this.googleLocationRequestProvider.get());
    }
}
