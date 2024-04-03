package com.talabat.feature.pharmacy.remote;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.network.TalabatAPIBuilder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PrescriptionApiImpl_Factory implements Factory<PrescriptionApiImpl> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<PharmacyPrescriptionBaseUrl> baseUrlProvider;
    private final Provider<TalabatAPIBuilder> talabatAPIBuilderProvider;

    public PrescriptionApiImpl_Factory(Provider<TalabatAPIBuilder> provider, Provider<BaseUrlFactory> provider2, Provider<PharmacyPrescriptionBaseUrl> provider3) {
        this.talabatAPIBuilderProvider = provider;
        this.baseUrlFactoryProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static PrescriptionApiImpl_Factory create(Provider<TalabatAPIBuilder> provider, Provider<BaseUrlFactory> provider2, Provider<PharmacyPrescriptionBaseUrl> provider3) {
        return new PrescriptionApiImpl_Factory(provider, provider2, provider3);
    }

    public static PrescriptionApiImpl newInstance(TalabatAPIBuilder talabatAPIBuilder, BaseUrlFactory baseUrlFactory, PharmacyPrescriptionBaseUrl pharmacyPrescriptionBaseUrl) {
        return new PrescriptionApiImpl(talabatAPIBuilder, baseUrlFactory, pharmacyPrescriptionBaseUrl);
    }

    public PrescriptionApiImpl get() {
        return newInstance(this.talabatAPIBuilderProvider.get(), this.baseUrlFactoryProvider.get(), this.baseUrlProvider.get());
    }
}
