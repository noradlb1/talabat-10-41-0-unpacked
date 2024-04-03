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
public final class CartDatabaseModule_ProvideMigrationFrom8To9Factory implements Factory<Migration> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CartDatabaseModule_ProvideMigrationFrom8To9Factory INSTANCE = new CartDatabaseModule_ProvideMigrationFrom8To9Factory();

        private InstanceHolder() {
        }
    }

    public static CartDatabaseModule_ProvideMigrationFrom8To9Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Migration provideMigrationFrom8To9() {
        return (Migration) Preconditions.checkNotNullFromProvides(CartDatabaseModule.INSTANCE.provideMigrationFrom8To9());
    }

    public Migration get() {
        return provideMigrationFrom8To9();
    }
}
