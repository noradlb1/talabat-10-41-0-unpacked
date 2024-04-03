package com.talabat.core.hms.location.data;

import com.huawei.hms.location.LocationSettingsRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsLocationSettingsRequestBuilderWrapper_Factory implements Factory<HmsLocationSettingsRequestBuilderWrapper> {
    private final Provider<LocationSettingsRequest.Builder> builderProvider;

    public HmsLocationSettingsRequestBuilderWrapper_Factory(Provider<LocationSettingsRequest.Builder> provider) {
        this.builderProvider = provider;
    }

    public static HmsLocationSettingsRequestBuilderWrapper_Factory create(Provider<LocationSettingsRequest.Builder> provider) {
        return new HmsLocationSettingsRequestBuilderWrapper_Factory(provider);
    }

    public static HmsLocationSettingsRequestBuilderWrapper newInstance(LocationSettingsRequest.Builder builder) {
        return new HmsLocationSettingsRequestBuilderWrapper(builder);
    }

    public HmsLocationSettingsRequestBuilderWrapper get() {
        return newInstance(this.builderProvider.get());
    }
}
