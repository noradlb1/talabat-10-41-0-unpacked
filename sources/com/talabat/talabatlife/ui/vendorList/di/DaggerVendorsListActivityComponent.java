package com.talabat.talabatlife.ui.vendorList.di;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatlife.ui.vendorList.VendorsListActivity;
import com.talabat.talabatlife.ui.vendorList.VendorsListActivity_MembersInjector;
import com.talabat.talabatlife.ui.vendorList.di.VendorsListActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerVendorsListActivityComponent {

    public static final class Factory implements VendorsListActivityComponent.Factory {
        private Factory() {
        }

        public VendorsListActivityComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new VendorsListActivityComponentImpl(featureFlagCoreLibApi);
        }
    }

    public static final class VendorsListActivityComponentImpl implements VendorsListActivityComponent {
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final VendorsListActivityComponentImpl vendorsListActivityComponentImpl;

        private VendorsListActivityComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.vendorsListActivityComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private VendorsListActivity injectVendorsListActivity(VendorsListActivity vendorsListActivity) {
            VendorsListActivity_MembersInjector.injectTalabatFeatureFlag(vendorsListActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return vendorsListActivity;
        }

        public void inject(VendorsListActivity vendorsListActivity) {
            injectVendorsListActivity(vendorsListActivity);
        }
    }

    private DaggerVendorsListActivityComponent() {
    }

    public static VendorsListActivityComponent.Factory factory() {
        return new Factory();
    }
}
