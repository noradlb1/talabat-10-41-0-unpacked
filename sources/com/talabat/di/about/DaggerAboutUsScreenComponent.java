package com.talabat.di.about;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.AboutUsScreen;
import com.talabat.AboutUsScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.di.about.AboutUsScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerAboutUsScreenComponent {

    public static final class AboutUsScreenComponentImpl implements AboutUsScreenComponent {
        private final AboutUsScreenComponentImpl aboutUsScreenComponentImpl;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

        private AboutUsScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.aboutUsScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private AboutUsScreen injectAboutUsScreen(AboutUsScreen aboutUsScreen) {
            AboutUsScreen_MembersInjector.injectTermsAndConditionsConfigurationRepository(aboutUsScreen, (TermsAndConditionsConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getTermsAndConditionsConfigurationRepository()));
            return aboutUsScreen;
        }

        public void inject(AboutUsScreen aboutUsScreen) {
            injectAboutUsScreen(aboutUsScreen);
        }
    }

    public static final class Factory implements AboutUsScreenComponent.Factory {
        private Factory() {
        }

        public AboutUsScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new AboutUsScreenComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    private DaggerAboutUsScreenComponent() {
    }

    public static AboutUsScreenComponent.Factory factory() {
        return new Factory();
    }
}
