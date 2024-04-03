package com.talabat.core.deeplink.data.parser;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DeepLinkParser_Factory implements Factory<DeepLinkParser> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DeepLinkParser_Factory INSTANCE = new DeepLinkParser_Factory();

        private InstanceHolder() {
        }
    }

    public static DeepLinkParser_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DeepLinkParser newInstance() {
        return new DeepLinkParser();
    }

    public DeepLinkParser get() {
        return newInstance();
    }
}
