package com.talabat.di.auth;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.ForgotPasswordScreen;
import com.talabat.ForgotPasswordScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.auth.ForgotPasswordScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerForgotPasswordScreenComponent {

    public static final class Factory implements ForgotPasswordScreenComponent.Factory {
        private Factory() {
        }

        public ForgotPasswordScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new ForgotPasswordScreenComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class ForgotPasswordScreenComponentImpl implements ForgotPasswordScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final ForgotPasswordScreenComponentImpl forgotPasswordScreenComponentImpl;

        private ForgotPasswordScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.forgotPasswordScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private ForgotPasswordScreen injectForgotPasswordScreen(ForgotPasswordScreen forgotPasswordScreen) {
            ForgotPasswordScreen_MembersInjector.injectAppVersionProvider(forgotPasswordScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return forgotPasswordScreen;
        }

        public void inject(ForgotPasswordScreen forgotPasswordScreen) {
            injectForgotPasswordScreen(forgotPasswordScreen);
        }
    }

    private DaggerForgotPasswordScreenComponent() {
    }

    public static ForgotPasswordScreenComponent.Factory factory() {
        return new Factory();
    }
}
