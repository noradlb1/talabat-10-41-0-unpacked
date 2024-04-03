package com.talabat.talabatcommon.feature.vouchers.loyalty.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VouchersService_Factory implements Factory<VouchersService> {
    private final Provider<TalabatAPIBuilder> talabatAPIBuilderProvider;

    public VouchersService_Factory(Provider<TalabatAPIBuilder> provider) {
        this.talabatAPIBuilderProvider = provider;
    }

    public static VouchersService_Factory create(Provider<TalabatAPIBuilder> provider) {
        return new VouchersService_Factory(provider);
    }

    public static VouchersService newInstance(TalabatAPIBuilder talabatAPIBuilder) {
        return new VouchersService(talabatAPIBuilder);
    }

    public VouchersService get() {
        return newInstance(this.talabatAPIBuilderProvider.get());
    }
}
