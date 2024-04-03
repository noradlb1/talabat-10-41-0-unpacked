package com.talabat.core.network.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TalabatAPIBuilder_Factory implements Factory<TalabatAPIBuilder> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TalabatAPIBuilder_Factory INSTANCE = new TalabatAPIBuilder_Factory();

        private InstanceHolder() {
        }
    }

    public static TalabatAPIBuilder_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TalabatAPIBuilder newInstance() {
        return new TalabatAPIBuilder();
    }

    public TalabatAPIBuilder get() {
        return newInstance();
    }
}
