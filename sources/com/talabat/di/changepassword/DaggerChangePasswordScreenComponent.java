package com.talabat.di.changepassword;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.ChangePasswordScreen;
import com.talabat.ChangePasswordScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.di.changepassword.ChangePasswordScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerChangePasswordScreenComponent {

    public static final class ChangePasswordScreenComponentImpl implements ChangePasswordScreenComponent {
        private final ChangePasswordScreenComponentImpl changePasswordScreenComponentImpl;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

        private ChangePasswordScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.changePasswordScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private ChangePasswordScreen injectChangePasswordScreen(ChangePasswordScreen changePasswordScreen) {
            ChangePasswordScreen_MembersInjector.injectAppVersionProvider(changePasswordScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            ChangePasswordScreen_MembersInjector.injectTalabatFeatureFlag(changePasswordScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return changePasswordScreen;
        }

        public void inject(ChangePasswordScreen changePasswordScreen) {
            injectChangePasswordScreen(changePasswordScreen);
        }
    }

    public static final class Factory implements ChangePasswordScreenComponent.Factory {
        private Factory() {
        }

        public ChangePasswordScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new ChangePasswordScreenComponentImpl(configurationRemoteCoreLibApi, featureFlagCoreLibApi);
        }
    }

    private DaggerChangePasswordScreenComponent() {
    }

    public static ChangePasswordScreenComponent.Factory factory() {
        return new Factory();
    }
}
