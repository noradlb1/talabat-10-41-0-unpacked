package com.talabat.feature.darkstores.swimlanes.data.remote.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SwimlanesMapper_Factory implements Factory<SwimlanesMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SwimlanesMapper_Factory INSTANCE = new SwimlanesMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SwimlanesMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SwimlanesMapper newInstance() {
        return new SwimlanesMapper();
    }

    public SwimlanesMapper get() {
        return newInstance();
    }
}
