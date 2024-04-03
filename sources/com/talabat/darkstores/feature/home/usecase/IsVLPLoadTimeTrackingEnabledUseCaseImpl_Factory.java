package com.talabat.darkstores.feature.home.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsVLPLoadTimeTrackingEnabledUseCaseImpl_Factory implements Factory<IsVLPLoadTimeTrackingEnabledUseCaseImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final IsVLPLoadTimeTrackingEnabledUseCaseImpl_Factory INSTANCE = new IsVLPLoadTimeTrackingEnabledUseCaseImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static IsVLPLoadTimeTrackingEnabledUseCaseImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IsVLPLoadTimeTrackingEnabledUseCaseImpl newInstance() {
        return new IsVLPLoadTimeTrackingEnabledUseCaseImpl();
    }

    public IsVLPLoadTimeTrackingEnabledUseCaseImpl get() {
        return newInstance();
    }
}
