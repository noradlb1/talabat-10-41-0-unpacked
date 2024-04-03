package com.talabat.di.changeemail;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.ChangeEmailScreen;
import com.talabat.ChangeEmailScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.di.changeemail.ChangeEmailScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerChangeEmailScreenComponent {

    public static final class ChangeEmailScreenComponentImpl implements ChangeEmailScreenComponent {
        private final ChangeEmailScreenComponentImpl changeEmailScreenComponentImpl;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

        private ChangeEmailScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.changeEmailScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private ChangeEmailScreen injectChangeEmailScreen(ChangeEmailScreen changeEmailScreen) {
            ChangeEmailScreen_MembersInjector.injectAppVersionProvider(changeEmailScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            ChangeEmailScreen_MembersInjector.injectTalabatFeatureFlag(changeEmailScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return changeEmailScreen;
        }

        public void inject(ChangeEmailScreen changeEmailScreen) {
            injectChangeEmailScreen(changeEmailScreen);
        }
    }

    public static final class Factory implements ChangeEmailScreenComponent.Factory {
        private Factory() {
        }

        public ChangeEmailScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new ChangeEmailScreenComponentImpl(configurationRemoteCoreLibApi, featureFlagCoreLibApi);
        }
    }

    private DaggerChangeEmailScreenComponent() {
    }

    public static ChangeEmailScreenComponent.Factory factory() {
        return new Factory();
    }
}
