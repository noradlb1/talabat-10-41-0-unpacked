package com.talabat.di.account;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.MobileNumberVerification;
import com.talabat.MobileNumberVerification_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.di.account.MobileNumberVerificationScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerMobileNumberVerificationScreenComponent {

    public static final class Factory implements MobileNumberVerificationScreenComponent.Factory {
        private Factory() {
        }

        public MobileNumberVerificationScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new MobileNumberVerificationScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class MobileNumberVerificationScreenComponentImpl implements MobileNumberVerificationScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final MobileNumberVerificationScreenComponentImpl mobileNumberVerificationScreenComponentImpl;

        private MobileNumberVerificationScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.mobileNumberVerificationScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private MobileNumberVerification injectMobileNumberVerification(MobileNumberVerification mobileNumberVerification) {
            MobileNumberVerification_MembersInjector.injectAppVersionProvider(mobileNumberVerification, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            MobileNumberVerification_MembersInjector.injectConfigurationLocalRepository(mobileNumberVerification, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            MobileNumberVerification_MembersInjector.injectDiscoveryConfigurationRepository(mobileNumberVerification, (DiscoveryConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getDiscoveryConfigurationRepository()));
            MobileNumberVerification_MembersInjector.injectLocationConfigurationRepository(mobileNumberVerification, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return mobileNumberVerification;
        }

        public void inject(MobileNumberVerification mobileNumberVerification) {
            injectMobileNumberVerification(mobileNumberVerification);
        }
    }

    private DaggerMobileNumberVerificationScreenComponent() {
    }

    public static MobileNumberVerificationScreenComponent.Factory factory() {
        return new Factory();
    }
}
