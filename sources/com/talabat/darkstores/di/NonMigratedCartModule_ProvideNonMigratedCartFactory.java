package com.talabat.darkstores.di;

import buisnessmodels.Cart;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class NonMigratedCartModule_ProvideNonMigratedCartFactory implements Factory<Cart> {
    private final NonMigratedCartModule module;

    public NonMigratedCartModule_ProvideNonMigratedCartFactory(NonMigratedCartModule nonMigratedCartModule) {
        this.module = nonMigratedCartModule;
    }

    public static NonMigratedCartModule_ProvideNonMigratedCartFactory create(NonMigratedCartModule nonMigratedCartModule) {
        return new NonMigratedCartModule_ProvideNonMigratedCartFactory(nonMigratedCartModule);
    }

    public static Cart provideNonMigratedCart(NonMigratedCartModule nonMigratedCartModule) {
        return (Cart) Preconditions.checkNotNullFromProvides(nonMigratedCartModule.provideNonMigratedCart());
    }

    public Cart get() {
        return provideNonMigratedCart(this.module);
    }
}
