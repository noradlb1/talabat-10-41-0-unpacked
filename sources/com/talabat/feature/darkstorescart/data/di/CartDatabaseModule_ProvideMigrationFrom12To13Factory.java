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
public final class CartDatabaseModule_ProvideMigrationFrom12To13Factory implements Factory<Migration> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CartDatabaseModule_ProvideMigrationFrom12To13Factory INSTANCE = new CartDatabaseModule_ProvideMigrationFrom12To13Factory();

        private InstanceHolder() {
        }
    }

    public static CartDatabaseModule_ProvideMigrationFrom12To13Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Migration provideMigrationFrom12To13() {
        return (Migration) Preconditions.checkNotNullFromProvides(CartDatabaseModule.INSTANCE.provideMigrationFrom12To13());
    }

    public Migration get() {
        return provideMigrationFrom12To13();
    }
}
