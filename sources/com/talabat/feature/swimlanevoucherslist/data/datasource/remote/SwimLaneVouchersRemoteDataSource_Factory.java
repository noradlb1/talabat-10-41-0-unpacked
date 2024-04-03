package com.talabat.feature.swimlanevoucherslist.data.datasource.remote;

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
public final class SwimLaneVouchersRemoteDataSource_Factory implements Factory<SwimLaneVouchersRemoteDataSource> {
    private final Provider<VouchersSwimLaneApi> vouchersSwimLaneProvider;

    public SwimLaneVouchersRemoteDataSource_Factory(Provider<VouchersSwimLaneApi> provider) {
        this.vouchersSwimLaneProvider = provider;
    }

    public static SwimLaneVouchersRemoteDataSource_Factory create(Provider<VouchersSwimLaneApi> provider) {
        return new SwimLaneVouchersRemoteDataSource_Factory(provider);
    }

    public static SwimLaneVouchersRemoteDataSource newInstance(Lazy<VouchersSwimLaneApi> lazy) {
        return new SwimLaneVouchersRemoteDataSource(lazy);
    }

    public SwimLaneVouchersRemoteDataSource get() {
        return newInstance(DoubleCheck.lazy(this.vouchersSwimLaneProvider));
    }
}
