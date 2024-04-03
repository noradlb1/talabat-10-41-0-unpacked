package com.talabat.darkstores.domain.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsFlutterVLPEnabledUseCaseImpl_Factory implements Factory<IsFlutterVLPEnabledUseCaseImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final IsFlutterVLPEnabledUseCaseImpl_Factory INSTANCE = new IsFlutterVLPEnabledUseCaseImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static IsFlutterVLPEnabledUseCaseImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IsFlutterVLPEnabledUseCaseImpl newInstance() {
        return new IsFlutterVLPEnabledUseCaseImpl();
    }

    public IsFlutterVLPEnabledUseCaseImpl get() {
        return newInstance();
    }
}
