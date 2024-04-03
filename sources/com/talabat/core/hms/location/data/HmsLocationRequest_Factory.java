package com.talabat.core.hms.location.data;

import com.huawei.hms.location.LocationRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsLocationRequest_Factory implements Factory<HmsLocationRequest> {
    private final Provider<LocationRequest> huaweiLocationRequestProvider;

    public HmsLocationRequest_Factory(Provider<LocationRequest> provider) {
        this.huaweiLocationRequestProvider = provider;
    }

    public static HmsLocationRequest_Factory create(Provider<LocationRequest> provider) {
        return new HmsLocationRequest_Factory(provider);
    }

    public static HmsLocationRequest newInstance(LocationRequest locationRequest) {
        return new HmsLocationRequest(locationRequest);
    }

    public HmsLocationRequest get() {
        return newInstance(this.huaweiLocationRequestProvider.get());
    }
}
