package com.talabat.feature.pharmacy.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.feature.pharmacy.di.PrescriptionFragmentComponent;
import com.talabat.feature.pharmacy.presentation.ui.fragment.PrescriptionFragment;
import com.talabat.feature.pharmacy.presentation.ui.fragment.PrescriptionFragment_MembersInjector;
import com.talabat.feature.pharmacy.remote.PharmacyPrescriptionBaseUrl;
import com.talabat.feature.pharmacy.remote.PrescriptionApiImpl;
import com.talabat.feature.pharmacy.repository.PrescriptionRepositoryImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerPrescriptionFragmentComponent {

    public static final class Factory implements PrescriptionFragmentComponent.Factory {
        private Factory() {
        }

        public PrescriptionFragmentComponent create(NetworkCoreLibApi networkCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            return new PrescriptionFragmentComponentImpl(networkCoreLibApi, dispatcherCoreLibApi);
        }
    }

    public static final class PrescriptionFragmentComponentImpl implements PrescriptionFragmentComponent {
        private final NetworkCoreLibApi networkCoreLibApi;
        private final PrescriptionFragmentComponentImpl prescriptionFragmentComponentImpl;

        private PrescriptionFragmentComponentImpl(NetworkCoreLibApi networkCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi) {
            this.prescriptionFragmentComponentImpl = this;
            this.networkCoreLibApi = networkCoreLibApi2;
        }

        private PrescriptionFragment injectPrescriptionFragment(PrescriptionFragment prescriptionFragment) {
            PrescriptionFragment_MembersInjector.injectPrescriptionRepo(prescriptionFragment, prescriptionRepositoryImpl());
            return prescriptionFragment;
        }

        private PrescriptionApiImpl prescriptionApiImpl() {
            return new PrescriptionApiImpl(new TalabatAPIBuilder(), (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory()), new PharmacyPrescriptionBaseUrl());
        }

        private PrescriptionRepositoryImpl prescriptionRepositoryImpl() {
            return new PrescriptionRepositoryImpl(prescriptionApiImpl());
        }

        public void inject(PrescriptionFragment prescriptionFragment) {
            injectPrescriptionFragment(prescriptionFragment);
        }
    }

    private DaggerPrescriptionFragmentComponent() {
    }

    public static PrescriptionFragmentComponent.Factory factory() {
        return new Factory();
    }
}
