package com.talabat.feature.cancellationpolicy.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CancellationPolicyBaseUrl_Factory implements Factory<CancellationPolicyBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CancellationPolicyBaseUrl_Factory INSTANCE = new CancellationPolicyBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static CancellationPolicyBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CancellationPolicyBaseUrl newInstance() {
        return new CancellationPolicyBaseUrl();
    }

    public CancellationPolicyBaseUrl get() {
        return newInstance();
    }
}
