package com.talabat.feature.mission.control.data.remote.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PrimaryMissionControlMapper_Factory implements Factory<PrimaryMissionControlMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PrimaryMissionControlMapper_Factory INSTANCE = new PrimaryMissionControlMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static PrimaryMissionControlMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PrimaryMissionControlMapper newInstance() {
        return new PrimaryMissionControlMapper();
    }

    public PrimaryMissionControlMapper get() {
        return newInstance();
    }
}
