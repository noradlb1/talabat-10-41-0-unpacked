package com.talabat.darkstores.data.recentsearches.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RecentSearchDatabaseToDomainModelMapperImpl_Factory implements Factory<RecentSearchDatabaseToDomainModelMapperImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RecentSearchDatabaseToDomainModelMapperImpl_Factory INSTANCE = new RecentSearchDatabaseToDomainModelMapperImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static RecentSearchDatabaseToDomainModelMapperImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RecentSearchDatabaseToDomainModelMapperImpl newInstance() {
        return new RecentSearchDatabaseToDomainModelMapperImpl();
    }

    public RecentSearchDatabaseToDomainModelMapperImpl get() {
        return newInstance();
    }
}
