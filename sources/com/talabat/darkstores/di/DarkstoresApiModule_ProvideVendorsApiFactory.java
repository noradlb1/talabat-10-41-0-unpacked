package com.talabat.darkstores.di;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.darkstores.data.vendors.remote.VendorsApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Vendor"})
public final class DarkstoresApiModule_ProvideVendorsApiFactory implements Factory<VendorsApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<TalabatAPIBuilder> talabatAPIBuilderProvider;

    public DarkstoresApiModule_ProvideVendorsApiFactory(Provider<TalabatAPIBuilder> provider, Provider<String> provider2) {
        this.talabatAPIBuilderProvider = provider;
        this.baseUrlProvider = provider2;
    }

    public static DarkstoresApiModule_ProvideVendorsApiFactory create(Provider<TalabatAPIBuilder> provider, Provider<String> provider2) {
        return new DarkstoresApiModule_ProvideVendorsApiFactory(provider, provider2);
    }

    public static VendorsApi provideVendorsApi(TalabatAPIBuilder talabatAPIBuilder, String str) {
        return (VendorsApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideVendorsApi(talabatAPIBuilder, str));
    }

    public VendorsApi get() {
        return provideVendorsApi(this.talabatAPIBuilderProvider.get(), this.baseUrlProvider.get());
    }
}
