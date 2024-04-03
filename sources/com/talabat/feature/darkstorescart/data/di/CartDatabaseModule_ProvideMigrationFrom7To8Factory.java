package com.talabat.feature.darkstorescart.data.di;

import androidx.room.migration.Migration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartDatabaseModule_ProvideMigrationFrom7To8Factory implements Factory<Migration> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CartDatabaseModule_ProvideMigrationFrom7To8Factory INSTANCE = new CartDatabaseModule_ProvideMigrationFrom7To8Factory();

        private InstanceHolder() {
        }
    }

    public static CartDatabaseModule_ProvideMigrationFrom7To8Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Migration provideMigrationFrom7To8() {
        return (Migration) Preconditions.checkNotNullFromProvides(CartDatabaseModule.INSTANCE.provideMigrationFrom7To8());
    }

    public Migration get() {
        return provideMigrationFrom7To8();
    }
}
