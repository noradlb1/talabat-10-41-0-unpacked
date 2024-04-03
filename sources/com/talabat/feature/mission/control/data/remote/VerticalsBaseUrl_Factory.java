package com.talabat.feature.mission.control.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VerticalsBaseUrl_Factory implements Factory<VerticalsBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final VerticalsBaseUrl_Factory INSTANCE = new VerticalsBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static VerticalsBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static VerticalsBaseUrl newInstance() {
        return new VerticalsBaseUrl();
    }

    public VerticalsBaseUrl get() {
        return newInstance();
    }
}
