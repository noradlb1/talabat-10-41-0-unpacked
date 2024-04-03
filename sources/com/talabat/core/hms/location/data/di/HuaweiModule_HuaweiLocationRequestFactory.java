package com.talabat.core.hms.location.data.di;

import com.huawei.hms.location.LocationRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HuaweiModule_HuaweiLocationRequestFactory implements Factory<LocationRequest> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final HuaweiModule_HuaweiLocationRequestFactory INSTANCE = new HuaweiModule_HuaweiLocationRequestFactory();

        private InstanceHolder() {
        }
    }

    public static HuaweiModule_HuaweiLocationRequestFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LocationRequest huaweiLocationRequest() {
        return (LocationRequest) Preconditions.checkNotNullFromProvides(HuaweiModule.INSTANCE.huaweiLocationRequest());
    }

    public LocationRequest get() {
        return huaweiLocationRequest();
    }
}
