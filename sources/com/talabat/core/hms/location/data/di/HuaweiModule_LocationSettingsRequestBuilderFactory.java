package com.talabat.core.hms.location.data.di;

import com.huawei.hms.location.LocationSettingsRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HuaweiModule_LocationSettingsRequestBuilderFactory implements Factory<LocationSettingsRequest.Builder> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final HuaweiModule_LocationSettingsRequestBuilderFactory INSTANCE = new HuaweiModule_LocationSettingsRequestBuilderFactory();

        private InstanceHolder() {
        }
    }

    public static HuaweiModule_LocationSettingsRequestBuilderFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LocationSettingsRequest.Builder locationSettingsRequestBuilder() {
        return (LocationSettingsRequest.Builder) Preconditions.checkNotNullFromProvides(HuaweiModule.INSTANCE.locationSettingsRequestBuilder());
    }

    public LocationSettingsRequest.Builder get() {
        return locationSettingsRequestBuilder();
    }
}
