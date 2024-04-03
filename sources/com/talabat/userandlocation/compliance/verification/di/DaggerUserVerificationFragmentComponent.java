package com.talabat.userandlocation.compliance.verification.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.userandlocation.compliance.verification.di.UserVerificationFragmentComponent;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerUserVerificationFragmentComponent {

    public static final class Factory implements UserVerificationFragmentComponent.Factory {
        private Factory() {
        }

        public UserVerificationFragmentComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new UserVerificationFragmentComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class UserVerificationFragmentComponentImpl implements UserVerificationFragmentComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final UserVerificationFragmentComponentImpl userVerificationFragmentComponentImpl;

        private UserVerificationFragmentComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.userVerificationFragmentComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        private UserVerificationFragment injectUserVerificationFragment(UserVerificationFragment userVerificationFragment) {
            UserVerificationFragment_MembersInjector.injectTermsAndConditionsConfigurationRepository(userVerificationFragment, (TermsAndConditionsConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getTermsAndConditionsConfigurationRepository()));
            return userVerificationFragment;
        }

        public void inject(UserVerificationFragment userVerificationFragment) {
            injectUserVerificationFragment(userVerificationFragment);
        }
    }

    private DaggerUserVerificationFragmentComponent() {
    }

    public static UserVerificationFragmentComponent.Factory factory() {
        return new Factory();
    }
}
