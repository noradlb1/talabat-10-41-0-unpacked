package com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IncentiveAutoApplyDiscountsRemoteDataSource_Factory implements Factory<IncentiveAutoApplyDiscountsRemoteDataSource> {
    private final Provider<IncentiveAutoApplyDiscountsApi> incentiveAutoApplyDiscountsServiceProvider;

    public IncentiveAutoApplyDiscountsRemoteDataSource_Factory(Provider<IncentiveAutoApplyDiscountsApi> provider) {
        this.incentiveAutoApplyDiscountsServiceProvider = provider;
    }

    public static IncentiveAutoApplyDiscountsRemoteDataSource_Factory create(Provider<IncentiveAutoApplyDiscountsApi> provider) {
        return new IncentiveAutoApplyDiscountsRemoteDataSource_Factory(provider);
    }

    public static IncentiveAutoApplyDiscountsRemoteDataSource newInstance(Lazy<IncentiveAutoApplyDiscountsApi> lazy) {
        return new IncentiveAutoApplyDiscountsRemoteDataSource(lazy);
    }

    public IncentiveAutoApplyDiscountsRemoteDataSource get() {
        return newInstance(DoubleCheck.lazy(this.incentiveAutoApplyDiscountsServiceProvider));
    }
}
