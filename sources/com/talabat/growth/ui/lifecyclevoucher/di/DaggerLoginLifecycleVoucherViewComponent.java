package com.talabat.growth.ui.lifecyclevoucher.di;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.growth.ui.lifecyclevoucher.LoginLifecycleVoucherView;
import com.talabat.growth.ui.lifecyclevoucher.LoginLifecycleVoucherView_MembersInjector;
import com.talabat.growth.ui.lifecyclevoucher.di.LoginLifecycleVoucherViewComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerLoginLifecycleVoucherViewComponent {

    public static final class Factory implements LoginLifecycleVoucherViewComponent.Factory {
        private Factory() {
        }

        public LoginLifecycleVoucherViewComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new LoginLifecycleVoucherViewComponentImpl(featureFlagCoreLibApi);
        }
    }

    public static final class LoginLifecycleVoucherViewComponentImpl implements LoginLifecycleVoucherViewComponent {
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final LoginLifecycleVoucherViewComponentImpl loginLifecycleVoucherViewComponentImpl;

        private LoginLifecycleVoucherViewComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.loginLifecycleVoucherViewComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private LoginLifecycleVoucherView injectLoginLifecycleVoucherView(LoginLifecycleVoucherView loginLifecycleVoucherView) {
            LoginLifecycleVoucherView_MembersInjector.injectFeatureFlagRepo(loginLifecycleVoucherView, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return loginLifecycleVoucherView;
        }

        public void inject(LoginLifecycleVoucherView loginLifecycleVoucherView) {
            injectLoginLifecycleVoucherView(loginLifecycleVoucherView);
        }
    }

    private DaggerLoginLifecycleVoucherViewComponent() {
    }

    public static LoginLifecycleVoucherViewComponent.Factory factory() {
        return new Factory();
    }
}
