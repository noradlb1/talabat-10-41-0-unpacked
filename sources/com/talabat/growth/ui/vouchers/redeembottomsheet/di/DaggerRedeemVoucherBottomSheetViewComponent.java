package com.talabat.growth.ui.vouchers.redeembottomsheet.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetView;
import com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetView_MembersInjector;
import com.talabat.growth.ui.vouchers.redeembottomsheet.di.RedeemVoucherBottomSheetViewComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRedeemVoucherBottomSheetViewComponent {

    public static final class Factory implements RedeemVoucherBottomSheetViewComponent.Factory {
        private Factory() {
        }

        public RedeemVoucherBottomSheetViewComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new RedeemVoucherBottomSheetViewComponentImpl(configurationLocalCoreLibApi, observabilityCoreLibApi, featureFlagCoreLibApi);
        }
    }

    public static final class RedeemVoucherBottomSheetViewComponentImpl implements RedeemVoucherBottomSheetViewComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final RedeemVoucherBottomSheetViewComponentImpl redeemVoucherBottomSheetViewComponentImpl;

        private RedeemVoucherBottomSheetViewComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.redeemVoucherBottomSheetViewComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
        }

        private RedeemVoucherBottomSheetView injectRedeemVoucherBottomSheetView(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView) {
            RedeemVoucherBottomSheetView_MembersInjector.injectConfigurationLocalRepository(redeemVoucherBottomSheetView, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            RedeemVoucherBottomSheetView_MembersInjector.injectTalabatFeatureFlag(redeemVoucherBottomSheetView, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            RedeemVoucherBottomSheetView_MembersInjector.injectObservabilityManager(redeemVoucherBottomSheetView, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            return redeemVoucherBottomSheetView;
        }

        public void inject(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView) {
            injectRedeemVoucherBottomSheetView(redeemVoucherBottomSheetView);
        }
    }

    private DaggerRedeemVoucherBottomSheetViewComponent() {
    }

    public static RedeemVoucherBottomSheetViewComponent.Factory factory() {
        return new Factory();
    }
}
