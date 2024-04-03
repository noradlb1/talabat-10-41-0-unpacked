package com.talabat.feature.pharmacy.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class MobileVerificationBaseUrl_Factory implements Factory<MobileVerificationBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final MobileVerificationBaseUrl_Factory INSTANCE = new MobileVerificationBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static MobileVerificationBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MobileVerificationBaseUrl newInstance() {
        return new MobileVerificationBaseUrl();
    }

    public MobileVerificationBaseUrl get() {
        return newInstance();
    }
}
