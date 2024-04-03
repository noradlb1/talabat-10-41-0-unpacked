package com.talabat.growth.ui.vouchers.details.di;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.growth.ui.vouchers.details.VoucherDetailsFragment;
import com.talabat.growth.ui.vouchers.details.VoucherDetailsFragment_MembersInjector;
import com.talabat.growth.ui.vouchers.details.di.VoucherDetailsFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerVoucherDetailsFragmentComponent {

    public static final class Factory implements VoucherDetailsFragmentComponent.Factory {
        private Factory() {
        }

        public VoucherDetailsFragmentComponent create(ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new VoucherDetailsFragmentComponentImpl(observabilityCoreLibApi);
        }
    }

    public static final class VoucherDetailsFragmentComponentImpl implements VoucherDetailsFragmentComponent {
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final VoucherDetailsFragmentComponentImpl voucherDetailsFragmentComponentImpl;

        private VoucherDetailsFragmentComponentImpl(ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.voucherDetailsFragmentComponentImpl = this;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
        }

        private VoucherDetailsFragment injectVoucherDetailsFragment(VoucherDetailsFragment voucherDetailsFragment) {
            VoucherDetailsFragment_MembersInjector.injectObservabilityManager(voucherDetailsFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            return voucherDetailsFragment;
        }

        public void inject(VoucherDetailsFragment voucherDetailsFragment) {
            injectVoucherDetailsFragment(voucherDetailsFragment);
        }
    }

    private DaggerVoucherDetailsFragmentComponent() {
    }

    public static VoucherDetailsFragmentComponent.Factory factory() {
        return new Factory();
    }
}
