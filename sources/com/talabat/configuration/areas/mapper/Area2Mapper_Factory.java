package com.talabat.configuration.areas.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class Area2Mapper_Factory implements Factory<Area2Mapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final Area2Mapper_Factory INSTANCE = new Area2Mapper_Factory();

        private InstanceHolder() {
        }
    }

    public static Area2Mapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Area2Mapper newInstance() {
        return new Area2Mapper();
    }

    public Area2Mapper get() {
        return newInstance();
    }
}
