package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ImageUrlMapper_Factory implements Factory<ImageUrlMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ImageUrlMapper_Factory INSTANCE = new ImageUrlMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ImageUrlMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ImageUrlMapper newInstance() {
        return new ImageUrlMapper();
    }

    public ImageUrlMapper get() {
        return newInstance();
    }
}
