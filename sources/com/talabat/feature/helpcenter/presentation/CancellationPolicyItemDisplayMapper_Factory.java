package com.talabat.feature.helpcenter.presentation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CancellationPolicyItemDisplayMapper_Factory implements Factory<CancellationPolicyItemDisplayMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CancellationPolicyItemDisplayMapper_Factory INSTANCE = new CancellationPolicyItemDisplayMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static CancellationPolicyItemDisplayMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CancellationPolicyItemDisplayMapper newInstance() {
        return new CancellationPolicyItemDisplayMapper();
    }

    public CancellationPolicyItemDisplayMapper get() {
        return newInstance();
    }
}
