package com.talabat.talabatcommon.views.vouchers.applyVoucherView.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersView;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersView_MembersInjector;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.di.ApplyVouchersViewComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerApplyVouchersViewComponent {

    public static final class ApplyVouchersViewComponentImpl implements ApplyVouchersViewComponent {
        private final ApplyVouchersViewComponentImpl applyVouchersViewComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

        private ApplyVouchersViewComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
            this.applyVouchersViewComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        private ApplyVouchersView injectApplyVouchersView(ApplyVouchersView applyVouchersView) {
            ApplyVouchersView_MembersInjector.injectFeatureFlagRepo(applyVouchersView, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            ApplyVouchersView_MembersInjector.injectConfigurationLocalRepository(applyVouchersView, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return applyVouchersView;
        }

        public void inject(ApplyVouchersView applyVouchersView) {
            injectApplyVouchersView(applyVouchersView);
        }
    }

    public static final class Factory implements ApplyVouchersViewComponent.Factory {
        private Factory() {
        }

        public ApplyVouchersViewComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            return new ApplyVouchersViewComponentImpl(featureFlagCoreLibApi, configurationLocalCoreLibApi);
        }
    }

    private DaggerApplyVouchersViewComponent() {
    }

    public static ApplyVouchersViewComponent.Factory factory() {
        return new Factory();
    }
}
