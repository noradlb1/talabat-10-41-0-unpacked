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
public final class CartDatabaseModule_ProvideMigrationFrom13To14Factory implements Factory<Migration> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CartDatabaseModule_ProvideMigrationFrom13To14Factory INSTANCE = new CartDatabaseModule_ProvideMigrationFrom13To14Factory();

        private InstanceHolder() {
        }
    }

    public static CartDatabaseModule_ProvideMigrationFrom13To14Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Migration provideMigrationFrom13To14() {
        return (Migration) Preconditions.checkNotNullFromProvides(CartDatabaseModule.INSTANCE.provideMigrationFrom13To14());
    }

    public Migration get() {
        return provideMigrationFrom13To14();
    }
}
