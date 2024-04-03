package com.talabat.configuration.areas.endpoint;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class Areas2BaseUrl_Factory implements Factory<Areas2BaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final Areas2BaseUrl_Factory INSTANCE = new Areas2BaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static Areas2BaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Areas2BaseUrl newInstance() {
        return new Areas2BaseUrl();
    }

    public Areas2BaseUrl get() {
        return newInstance();
    }
}
