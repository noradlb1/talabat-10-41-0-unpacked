package com.talabat.di.branding;

import com.talabat.BrandingScreen;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import dagger.Component;

@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, NavigationCoreLibApi.class, FeatureFlagCoreLibApi.class, DeepLinkCoreLibApi.class})
public interface BrandingScreenComponent {

    @Component.Factory
    public interface Factory {
        BrandingScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi);
    }

    void inject(BrandingScreen brandingScreen);
}
