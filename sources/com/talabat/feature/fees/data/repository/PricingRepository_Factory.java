package com.talabat.feature.fees.data.repository;

import com.talabat.feature.fees.data.local.LocalFeesDataSource;
import com.talabat.feature.fees.data.mapper.FeesMapper;
import com.talabat.feature.fees.data.remote.PricingApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class PricingRepository_Factory implements Factory<PricingRepository> {
    private final Provider<Integer> countryIdProvider;
    private final Provider<String> deliveryModeProvider;
    private final Provider<FeesMapper> feesMapperProvider;
    private final Provider<LocalFeesDataSource> localFeesDataSourceProvider;
    private final Provider<PricingApi> pricingApiProvider;
    private final Provider<Integer> vendorIdProvider;

    public PricingRepository_Factory(Provider<PricingApi> provider, Provider<LocalFeesDataSource> provider2, Provider<FeesMapper> provider3, Provider<Integer> provider4, Provider<Integer> provider5, Provider<String> provider6) {
        this.pricingApiProvider = provider;
        this.localFeesDataSourceProvider = provider2;
        this.feesMapperProvider = provider3;
        this.countryIdProvider = provider4;
        this.vendorIdProvider = provider5;
        this.deliveryModeProvider = provider6;
    }

    public static PricingRepository_Factory create(Provider<PricingApi> provider, Provider<LocalFeesDataSource> provider2, Provider<FeesMapper> provider3, Provider<Integer> provider4, Provider<Integer> provider5, Provider<String> provider6) {
        return new PricingRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PricingRepository newInstance(PricingApi pricingApi, LocalFeesDataSource localFeesDataSource, FeesMapper feesMapper, int i11, int i12, String str) {
        return new PricingRepository(pricingApi, localFeesDataSource, feesMapper, i11, i12, str);
    }

    public PricingRepository get() {
        return newInstance(this.pricingApiProvider.get(), this.localFeesDataSourceProvider.get(), this.feesMapperProvider.get(), this.countryIdProvider.get().intValue(), this.vendorIdProvider.get().intValue(), this.deliveryModeProvider.get());
    }
}
