package com.talabat.darkstores.feature.model.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RecentSearchesToListItemsMapperImpl_Factory implements Factory<RecentSearchesToListItemsMapperImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RecentSearchesToListItemsMapperImpl_Factory INSTANCE = new RecentSearchesToListItemsMapperImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static RecentSearchesToListItemsMapperImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RecentSearchesToListItemsMapperImpl newInstance() {
        return new RecentSearchesToListItemsMapperImpl();
    }

    public RecentSearchesToListItemsMapperImpl get() {
        return newInstance();
    }
}
