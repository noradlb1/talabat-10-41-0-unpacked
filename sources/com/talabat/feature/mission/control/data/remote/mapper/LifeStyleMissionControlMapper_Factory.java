package com.talabat.feature.mission.control.data.remote.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LifeStyleMissionControlMapper_Factory implements Factory<LifeStyleMissionControlMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LifeStyleMissionControlMapper_Factory INSTANCE = new LifeStyleMissionControlMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static LifeStyleMissionControlMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LifeStyleMissionControlMapper newInstance() {
        return new LifeStyleMissionControlMapper();
    }

    public LifeStyleMissionControlMapper get() {
        return newInstance();
    }
}
