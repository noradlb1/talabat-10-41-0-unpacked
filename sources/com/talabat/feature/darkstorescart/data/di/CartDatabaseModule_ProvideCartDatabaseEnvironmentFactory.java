package com.talabat.feature.darkstorescart.data.di;

import com.talabat.feature.darkstorescart.data.local.CartDatabaseEnvironment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartDatabaseModule_ProvideCartDatabaseEnvironmentFactory implements Factory<CartDatabaseEnvironment> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CartDatabaseModule_ProvideCartDatabaseEnvironmentFactory INSTANCE = new CartDatabaseModule_ProvideCartDatabaseEnvironmentFactory();

        private InstanceHolder() {
        }
    }

    public static CartDatabaseModule_ProvideCartDatabaseEnvironmentFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CartDatabaseEnvironment provideCartDatabaseEnvironment() {
        return (CartDatabaseEnvironment) Preconditions.checkNotNullFromProvides(CartDatabaseModule.INSTANCE.provideCartDatabaseEnvironment());
    }

    public CartDatabaseEnvironment get() {
        return provideCartDatabaseEnvironment();
    }
}
