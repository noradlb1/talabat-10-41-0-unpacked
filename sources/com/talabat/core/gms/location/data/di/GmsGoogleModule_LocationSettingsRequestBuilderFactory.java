package com.talabat.core.gms.location.data.di;

import com.google.android.gms.location.LocationSettingsRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsGoogleModule_LocationSettingsRequestBuilderFactory implements Factory<LocationSettingsRequest.Builder> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final GmsGoogleModule_LocationSettingsRequestBuilderFactory INSTANCE = new GmsGoogleModule_LocationSettingsRequestBuilderFactory();

        private InstanceHolder() {
        }
    }

    public static GmsGoogleModule_LocationSettingsRequestBuilderFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LocationSettingsRequest.Builder locationSettingsRequestBuilder() {
        return (LocationSettingsRequest.Builder) Preconditions.checkNotNullFromProvides(GmsGoogleModule.INSTANCE.locationSettingsRequestBuilder());
    }

    public LocationSettingsRequest.Builder get() {
        return locationSettingsRequestBuilder();
    }
}
