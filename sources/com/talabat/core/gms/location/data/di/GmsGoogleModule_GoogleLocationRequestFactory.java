package com.talabat.core.gms.location.data.di;

import com.google.android.gms.location.LocationRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsGoogleModule_GoogleLocationRequestFactory implements Factory<LocationRequest> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final GmsGoogleModule_GoogleLocationRequestFactory INSTANCE = new GmsGoogleModule_GoogleLocationRequestFactory();

        private InstanceHolder() {
        }
    }

    public static GmsGoogleModule_GoogleLocationRequestFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LocationRequest googleLocationRequest() {
        return (LocationRequest) Preconditions.checkNotNullFromProvides(GmsGoogleModule.INSTANCE.googleLocationRequest());
    }

    public LocationRequest get() {
        return googleLocationRequest();
    }
}
