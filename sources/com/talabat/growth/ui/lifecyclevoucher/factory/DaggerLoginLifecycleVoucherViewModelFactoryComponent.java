package com.talabat.growth.ui.lifecyclevoucher.factory;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.growth.ui.lifecyclevoucher.factory.LoginLifecycleVoucherViewModelFactoryComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerLoginLifecycleVoucherViewModelFactoryComponent {

    public static final class Factory implements LoginLifecycleVoucherViewModelFactoryComponent.Factory {
        private Factory() {
        }

        public LoginLifecycleVoucherViewModelFactoryComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            return new LoginLifecycleVoucherViewModelFactoryComponentImpl(configurationLocalCoreLibApi);
        }
    }

    public static final class LoginLifecycleVoucherViewModelFactoryComponentImpl implements LoginLifecycleVoucherViewModelFactoryComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final LoginLifecycleVoucherViewModelFactoryComponentImpl loginLifecycleVoucherViewModelFactoryComponentImpl;

        private LoginLifecycleVoucherViewModelFactoryComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
            this.loginLifecycleVoucherViewModelFactoryComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        private LoginLifecycleVoucherViewModelFactory injectLoginLifecycleVoucherViewModelFactory(LoginLifecycleVoucherViewModelFactory loginLifecycleVoucherViewModelFactory) {
            LoginLifecycleVoucherViewModelFactory_MembersInjector.injectConfigurationLocalCoreLibApi(loginLifecycleVoucherViewModelFactory, this.configurationLocalCoreLibApi);
            return loginLifecycleVoucherViewModelFactory;
        }

        public void inject(LoginLifecycleVoucherViewModelFactory loginLifecycleVoucherViewModelFactory) {
            injectLoginLifecycleVoucherViewModelFactory(loginLifecycleVoucherViewModelFactory);
        }
    }

    private DaggerLoginLifecycleVoucherViewModelFactoryComponent() {
    }

    public static LoginLifecycleVoucherViewModelFactoryComponent.Factory factory() {
        return new Factory();
    }
}
