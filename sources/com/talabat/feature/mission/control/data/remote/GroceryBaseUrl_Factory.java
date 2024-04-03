package com.talabat.feature.mission.control.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GroceryBaseUrl_Factory implements Factory<GroceryBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final GroceryBaseUrl_Factory INSTANCE = new GroceryBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static GroceryBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static GroceryBaseUrl newInstance() {
        return new GroceryBaseUrl();
    }

    public GroceryBaseUrl get() {
        return newInstance();
    }
}
