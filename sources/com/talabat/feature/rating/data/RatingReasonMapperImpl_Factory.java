package com.talabat.feature.rating.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingReasonMapperImpl_Factory implements Factory<RatingReasonMapperImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RatingReasonMapperImpl_Factory INSTANCE = new RatingReasonMapperImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static RatingReasonMapperImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RatingReasonMapperImpl newInstance() {
        return new RatingReasonMapperImpl();
    }

    public RatingReasonMapperImpl get() {
        return newInstance();
    }
}
