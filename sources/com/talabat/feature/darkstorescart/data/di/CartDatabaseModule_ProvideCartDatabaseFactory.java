package com.talabat.feature.darkstorescart.data.di;

import android.content.Context;
import androidx.room.migration.Migration;
import com.talabat.feature.darkstorescart.data.local.CartDatabase;
import com.talabat.feature.darkstorescart.data.local.CartDatabaseEnvironment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartDatabaseModule_ProvideCartDatabaseFactory implements Factory<CartDatabase> {
    private final Provider<Context> contextProvider;
    private final Provider<CartDatabaseEnvironment> environmentProvider;
    private final Provider<Set<Migration>> migrationsProvider;

    public CartDatabaseModule_ProvideCartDatabaseFactory(Provider<Context> provider, Provider<CartDatabaseEnvironment> provider2, Provider<Set<Migration>> provider3) {
        this.contextProvider = provider;
        this.environmentProvider = provider2;
        this.migrationsProvider = provider3;
    }

    public static CartDatabaseModule_ProvideCartDatabaseFactory create(Provider<Context> provider, Provider<CartDatabaseEnvironment> provider2, Provider<Set<Migration>> provider3) {
        return new CartDatabaseModule_ProvideCartDatabaseFactory(provider, provider2, provider3);
    }

    public static CartDatabase provideCartDatabase(Context context, CartDatabaseEnvironment cartDatabaseEnvironment, Set<Migration> set) {
        return (CartDatabase) Preconditions.checkNotNullFromProvides(CartDatabaseModule.INSTANCE.provideCartDatabase(context, cartDatabaseEnvironment, set));
    }

    public CartDatabase get() {
        return provideCartDatabase(this.contextProvider.get(), this.environmentProvider.get(), this.migrationsProvider.get());
    }
}
