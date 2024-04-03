package com.talabat.feature.darkstoresflutter.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ProductToFlutterCartItemMapper_Factory implements Factory<ProductToFlutterCartItemMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ProductToFlutterCartItemMapper_Factory INSTANCE = new ProductToFlutterCartItemMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ProductToFlutterCartItemMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ProductToFlutterCartItemMapper newInstance() {
        return new ProductToFlutterCartItemMapper();
    }

    public ProductToFlutterCartItemMapper get() {
        return newInstance();
    }
}
