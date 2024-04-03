package com.talabat.busypopup.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.busypopup.BusyPopupBottomSheet;
import com.talabat.busypopup.BusyPopupBottomSheet_MembersInjector;
import com.talabat.busypopup.di.BusyPopupBottomSheetComponent;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerBusyPopupBottomSheetComponent {

    public static final class BusyPopupBottomSheetComponentImpl implements BusyPopupBottomSheetComponent {
        private final BusyPopupBottomSheetComponentImpl busyPopupBottomSheetComponentImpl;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

        private BusyPopupBottomSheetComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.busyPopupBottomSheetComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private BusyPopupBottomSheet injectBusyPopupBottomSheet(BusyPopupBottomSheet busyPopupBottomSheet) {
            BusyPopupBottomSheet_MembersInjector.injectTalabatFeatureFlag(busyPopupBottomSheet, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            BusyPopupBottomSheet_MembersInjector.injectLocationConfigurationRepository(busyPopupBottomSheet, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return busyPopupBottomSheet;
        }

        public void inject(BusyPopupBottomSheet busyPopupBottomSheet) {
            injectBusyPopupBottomSheet(busyPopupBottomSheet);
        }
    }

    public static final class Factory implements BusyPopupBottomSheetComponent.Factory {
        private Factory() {
        }

        public BusyPopupBottomSheetComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new BusyPopupBottomSheetComponentImpl(configurationRemoteCoreLibApi, featureFlagCoreLibApi);
        }
    }

    private DaggerBusyPopupBottomSheetComponent() {
    }

    public static BusyPopupBottomSheetComponent.Factory factory() {
        return new Factory();
    }
}
