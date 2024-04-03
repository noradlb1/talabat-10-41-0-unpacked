package com.talabat.talabatcommon.views.ridersTip.di;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.views.ridersTip.RiderTipButton;
import com.talabat.talabatcommon.views.ridersTip.RiderTipButton_MembersInjector;
import com.talabat.talabatcommon.views.ridersTip.di.RiderTipButtonComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRiderTipButtonComponent {

    public static final class Factory implements RiderTipButtonComponent.Factory {
        private Factory() {
        }

        public RiderTipButtonComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new RiderTipButtonComponentImpl(featureFlagCoreLibApi);
        }
    }

    public static final class RiderTipButtonComponentImpl implements RiderTipButtonComponent {
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final RiderTipButtonComponentImpl riderTipButtonComponentImpl;

        private RiderTipButtonComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.riderTipButtonComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private RiderTipButton injectRiderTipButton(RiderTipButton riderTipButton) {
            RiderTipButton_MembersInjector.injectFeatureFlagRepo(riderTipButton, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return riderTipButton;
        }

        public void inject(RiderTipButton riderTipButton) {
            injectRiderTipButton(riderTipButton);
        }
    }

    private DaggerRiderTipButtonComponent() {
    }

    public static RiderTipButtonComponent.Factory factory() {
        return new Factory();
    }
}
