package com.talabat.core.featureflag.fake;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FakeTalabatFeatureFlag_Factory implements Factory<FakeTalabatFeatureFlag> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FakeTalabatFeatureFlag_Factory INSTANCE = new FakeTalabatFeatureFlag_Factory();

        private InstanceHolder() {
        }
    }

    public static FakeTalabatFeatureFlag_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FakeTalabatFeatureFlag newInstance() {
        return new FakeTalabatFeatureFlag();
    }

    public FakeTalabatFeatureFlag get() {
        return newInstance();
    }
}
