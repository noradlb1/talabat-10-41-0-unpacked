package com.talabat.feature.incentiveautoapplydiscounts.data;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.incentiveautoapplydiscounts.data.datasource.mapper.IncentiveAutoApplyDiscountsMapper;
import com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource;
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
public final class IncentiveAutoApplyDiscountsRealRepository_Factory implements Factory<IncentiveAutoApplyDiscountsRealRepository> {
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<IncentiveAutoApplyDiscountsRemoteDataSource> incentiveAutoApplyDiscountsRemoteDataSourceProvider;
    private final Provider<IncentiveAutoApplyDiscountsMapper> mapperProvider;

    public IncentiveAutoApplyDiscountsRealRepository_Factory(Provider<ITalabatFeatureFlag> provider, Provider<IncentiveAutoApplyDiscountsRemoteDataSource> provider2, Provider<IncentiveAutoApplyDiscountsMapper> provider3) {
        this.featureFlagProvider = provider;
        this.incentiveAutoApplyDiscountsRemoteDataSourceProvider = provider2;
        this.mapperProvider = provider3;
    }

    public static IncentiveAutoApplyDiscountsRealRepository_Factory create(Provider<ITalabatFeatureFlag> provider, Provider<IncentiveAutoApplyDiscountsRemoteDataSource> provider2, Provider<IncentiveAutoApplyDiscountsMapper> provider3) {
        return new IncentiveAutoApplyDiscountsRealRepository_Factory(provider, provider2, provider3);
    }

    public static IncentiveAutoApplyDiscountsRealRepository newInstance(ITalabatFeatureFlag iTalabatFeatureFlag, Lazy<IncentiveAutoApplyDiscountsRemoteDataSource> lazy, IncentiveAutoApplyDiscountsMapper incentiveAutoApplyDiscountsMapper) {
        return new IncentiveAutoApplyDiscountsRealRepository(iTalabatFeatureFlag, lazy, incentiveAutoApplyDiscountsMapper);
    }

    public IncentiveAutoApplyDiscountsRealRepository get() {
        return newInstance(this.featureFlagProvider.get(), DoubleCheck.lazy(this.incentiveAutoApplyDiscountsRemoteDataSourceProvider), this.mapperProvider.get());
    }
}
