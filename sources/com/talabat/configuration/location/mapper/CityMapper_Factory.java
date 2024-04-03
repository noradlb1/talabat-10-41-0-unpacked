package com.talabat.configuration.location.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CityMapper_Factory implements Factory<CityMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CityMapper_Factory INSTANCE = new CityMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static CityMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CityMapper newInstance() {
        return new CityMapper();
    }

    public CityMapper get() {
        return newInstance();
    }
}
