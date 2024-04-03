package com.talabat.feature.swimlanevoucherslist.data;

import com.talabat.feature.swimlanevoucherslist.data.datasource.mapper.CustomerVoucherMapper;
import com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CustomerVouchersSwimLaneRealRepository_Factory implements Factory<CustomerVouchersSwimLaneRealRepository> {
    private final Provider<CustomerVoucherMapper> vouchersMapperProvider;
    private final Provider<SwimLaneVouchersRemoteDataSource> vouchersRemoteDataSourceProvider;

    public CustomerVouchersSwimLaneRealRepository_Factory(Provider<SwimLaneVouchersRemoteDataSource> provider, Provider<CustomerVoucherMapper> provider2) {
        this.vouchersRemoteDataSourceProvider = provider;
        this.vouchersMapperProvider = provider2;
    }

    public static CustomerVouchersSwimLaneRealRepository_Factory create(Provider<SwimLaneVouchersRemoteDataSource> provider, Provider<CustomerVoucherMapper> provider2) {
        return new CustomerVouchersSwimLaneRealRepository_Factory(provider, provider2);
    }

    public static CustomerVouchersSwimLaneRealRepository newInstance(SwimLaneVouchersRemoteDataSource swimLaneVouchersRemoteDataSource, CustomerVoucherMapper customerVoucherMapper) {
        return new CustomerVouchersSwimLaneRealRepository(swimLaneVouchersRemoteDataSource, customerVoucherMapper);
    }

    public CustomerVouchersSwimLaneRealRepository get() {
        return newInstance(this.vouchersRemoteDataSourceProvider.get(), this.vouchersMapperProvider.get());
    }
}
