package com.talabat.feature.cancellationpolicy.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CancellationPolicyMapper_Factory implements Factory<CancellationPolicyMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CancellationPolicyMapper_Factory INSTANCE = new CancellationPolicyMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static CancellationPolicyMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CancellationPolicyMapper newInstance() {
        return new CancellationPolicyMapper();
    }

    public CancellationPolicyMapper get() {
        return newInstance();
    }
}
