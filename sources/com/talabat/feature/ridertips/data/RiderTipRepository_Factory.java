package com.talabat.feature.ridertips.data;

import com.talabat.feature.ridertips.data.convert.IRiderTipResponseToRiderTipMapper;
import com.talabat.feature.ridertips.data.remote.RiderTipApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RiderTipRepository_Factory implements Factory<RiderTipRepository> {
    private final Provider<Integer> countryIdProvider;
    private final Provider<RiderTipApi> riderTipApiProvider;
    private final Provider<IRiderTipResponseToRiderTipMapper> riderTipResponseToRiderTipMapperProvider;

    public RiderTipRepository_Factory(Provider<Integer> provider, Provider<RiderTipApi> provider2, Provider<IRiderTipResponseToRiderTipMapper> provider3) {
        this.countryIdProvider = provider;
        this.riderTipApiProvider = provider2;
        this.riderTipResponseToRiderTipMapperProvider = provider3;
    }

    public static RiderTipRepository_Factory create(Provider<Integer> provider, Provider<RiderTipApi> provider2, Provider<IRiderTipResponseToRiderTipMapper> provider3) {
        return new RiderTipRepository_Factory(provider, provider2, provider3);
    }

    public static RiderTipRepository newInstance(int i11, RiderTipApi riderTipApi, IRiderTipResponseToRiderTipMapper iRiderTipResponseToRiderTipMapper) {
        return new RiderTipRepository(i11, riderTipApi, iRiderTipResponseToRiderTipMapper);
    }

    public RiderTipRepository get() {
        return newInstance(this.countryIdProvider.get().intValue(), this.riderTipApiProvider.get(), this.riderTipResponseToRiderTipMapperProvider.get());
    }
}
