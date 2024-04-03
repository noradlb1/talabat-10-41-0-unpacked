package com.talabat.core.tracking.data.perseus;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LegacyPerseusEvenTools_Factory implements Factory<LegacyPerseusEvenTools> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LegacyPerseusEvenTools_Factory INSTANCE = new LegacyPerseusEvenTools_Factory();

        private InstanceHolder() {
        }
    }

    public static LegacyPerseusEvenTools_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LegacyPerseusEvenTools newInstance() {
        return new LegacyPerseusEvenTools();
    }

    public LegacyPerseusEvenTools get() {
        return newInstance();
    }
}
