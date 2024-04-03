package com.talabat.feature.pharmacy.repository;

import com.talabat.feature.pharmacy.remote.PrescriptionApiImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PrescriptionRepositoryImpl_Factory implements Factory<PrescriptionRepositoryImpl> {
    private final Provider<PrescriptionApiImpl> prescriptionApiProvider;

    public PrescriptionRepositoryImpl_Factory(Provider<PrescriptionApiImpl> provider) {
        this.prescriptionApiProvider = provider;
    }

    public static PrescriptionRepositoryImpl_Factory create(Provider<PrescriptionApiImpl> provider) {
        return new PrescriptionRepositoryImpl_Factory(provider);
    }

    public static PrescriptionRepositoryImpl newInstance(PrescriptionApiImpl prescriptionApiImpl) {
        return new PrescriptionRepositoryImpl(prescriptionApiImpl);
    }

    public PrescriptionRepositoryImpl get() {
        return newInstance(this.prescriptionApiProvider.get());
    }
}
