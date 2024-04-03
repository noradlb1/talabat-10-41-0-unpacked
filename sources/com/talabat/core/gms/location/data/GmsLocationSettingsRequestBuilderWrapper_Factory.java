package com.talabat.core.gms.location.data;

import com.google.android.gms.location.LocationSettingsRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsLocationSettingsRequestBuilderWrapper_Factory implements Factory<GmsLocationSettingsRequestBuilderWrapper> {
    private final Provider<LocationSettingsRequest.Builder> builderProvider;

    public GmsLocationSettingsRequestBuilderWrapper_Factory(Provider<LocationSettingsRequest.Builder> provider) {
        this.builderProvider = provider;
    }

    public static GmsLocationSettingsRequestBuilderWrapper_Factory create(Provider<LocationSettingsRequest.Builder> provider) {
        return new GmsLocationSettingsRequestBuilderWrapper_Factory(provider);
    }

    public static GmsLocationSettingsRequestBuilderWrapper newInstance(LocationSettingsRequest.Builder builder) {
        return new GmsLocationSettingsRequestBuilderWrapper(builder);
    }

    public GmsLocationSettingsRequestBuilderWrapper get() {
        return newInstance(this.builderProvider.get());
    }
}
