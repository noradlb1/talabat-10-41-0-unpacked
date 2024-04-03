package com.talabat.core.navigation.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ActivityNavigator_Factory implements Factory<ActivityNavigator> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ActivityNavigator_Factory INSTANCE = new ActivityNavigator_Factory();

        private InstanceHolder() {
        }
    }

    public static ActivityNavigator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ActivityNavigator newInstance() {
        return new ActivityNavigator();
    }

    public ActivityNavigator get() {
        return newInstance();
    }
}
