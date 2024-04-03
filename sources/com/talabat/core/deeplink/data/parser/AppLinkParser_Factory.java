package com.talabat.core.deeplink.data.parser;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class AppLinkParser_Factory implements Factory<AppLinkParser> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AppLinkParser_Factory INSTANCE = new AppLinkParser_Factory();

        private InstanceHolder() {
        }
    }

    public static AppLinkParser_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AppLinkParser newInstance() {
        return new AppLinkParser();
    }

    public AppLinkParser get() {
        return newInstance();
    }
}
