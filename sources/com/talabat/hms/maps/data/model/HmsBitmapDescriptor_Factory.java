package com.talabat.hms.maps.data.model;

import com.huawei.hms.maps.model.BitmapDescriptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsBitmapDescriptor_Factory implements Factory<HmsBitmapDescriptor> {
    private final Provider<BitmapDescriptor> huaweiBitmapDescriptorProvider;

    public HmsBitmapDescriptor_Factory(Provider<BitmapDescriptor> provider) {
        this.huaweiBitmapDescriptorProvider = provider;
    }

    public static HmsBitmapDescriptor_Factory create(Provider<BitmapDescriptor> provider) {
        return new HmsBitmapDescriptor_Factory(provider);
    }

    public static HmsBitmapDescriptor newInstance(BitmapDescriptor bitmapDescriptor) {
        return new HmsBitmapDescriptor(bitmapDescriptor);
    }

    public HmsBitmapDescriptor get() {
        return newInstance(this.huaweiBitmapDescriptorProvider.get());
    }
}
