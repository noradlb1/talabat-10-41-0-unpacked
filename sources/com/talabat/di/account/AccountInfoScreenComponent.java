package com.talabat.di.account;

import com.talabat.AccountInfoScreen;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import dagger.Component;

@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, FeatureFlagCoreLibApi.class, SafetyCoreLibApi.class})
public interface AccountInfoScreenComponent {

    @Component.Factory
    public interface Factory {
        AccountInfoScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, SafetyCoreLibApi safetyCoreLibApi);
    }

    void inject(AccountInfoScreen accountInfoScreen);
}
