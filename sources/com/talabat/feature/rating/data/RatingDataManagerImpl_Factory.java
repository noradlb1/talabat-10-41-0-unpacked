package com.talabat.feature.rating.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingDataManagerImpl_Factory implements Factory<RatingDataManagerImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RatingDataManagerImpl_Factory INSTANCE = new RatingDataManagerImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static RatingDataManagerImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RatingDataManagerImpl newInstance() {
        return new RatingDataManagerImpl();
    }

    public RatingDataManagerImpl get() {
        return newInstance();
    }
}
