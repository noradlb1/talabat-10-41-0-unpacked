package com.talabat.darkstores.domain.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class MissionControlProductsResponseToDomainMapperImpl_Factory implements Factory<MissionControlProductsResponseToDomainMapperImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final MissionControlProductsResponseToDomainMapperImpl_Factory INSTANCE = new MissionControlProductsResponseToDomainMapperImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static MissionControlProductsResponseToDomainMapperImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MissionControlProductsResponseToDomainMapperImpl newInstance() {
        return new MissionControlProductsResponseToDomainMapperImpl();
    }

    public MissionControlProductsResponseToDomainMapperImpl get() {
        return newInstance();
    }
}
