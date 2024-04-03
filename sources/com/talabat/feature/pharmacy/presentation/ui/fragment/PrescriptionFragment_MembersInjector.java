package com.talabat.feature.pharmacy.presentation.ui.fragment;

import com.talabat.feature.pharmacy.repository.PrescriptionRepositoryImpl;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class PrescriptionFragment_MembersInjector implements MembersInjector<PrescriptionFragment> {
    private final Provider<PrescriptionRepositoryImpl> prescriptionRepoProvider;

    public PrescriptionFragment_MembersInjector(Provider<PrescriptionRepositoryImpl> provider) {
        this.prescriptionRepoProvider = provider;
    }

    public static MembersInjector<PrescriptionFragment> create(Provider<PrescriptionRepositoryImpl> provider) {
        return new PrescriptionFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.pharmacy.presentation.ui.fragment.PrescriptionFragment.prescriptionRepo")
    public static void injectPrescriptionRepo(PrescriptionFragment prescriptionFragment, PrescriptionRepositoryImpl prescriptionRepositoryImpl) {
        prescriptionFragment.prescriptionRepo = prescriptionRepositoryImpl;
    }

    public void injectMembers(PrescriptionFragment prescriptionFragment) {
        injectPrescriptionRepo(prescriptionFragment, this.prescriptionRepoProvider.get());
    }
}
