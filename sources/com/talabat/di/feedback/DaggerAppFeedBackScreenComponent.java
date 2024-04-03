package com.talabat.di.feedback;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.AppFeedBackScreen;
import com.talabat.AppFeedBackScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.di.feedback.AppFeedBackScreenComponent;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerAppFeedBackScreenComponent {

    public static final class AppFeedBackScreenComponentImpl implements AppFeedBackScreenComponent {
        private final AppFeedBackScreenComponentImpl appFeedBackScreenComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final HelpCenterFeatureApi helpCenterFeatureApi;

        private AppFeedBackScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, HelpCenterFeatureApi helpCenterFeatureApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.appFeedBackScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.helpCenterFeatureApi = helpCenterFeatureApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private AppFeedBackScreen injectAppFeedBackScreen(AppFeedBackScreen appFeedBackScreen) {
            AppFeedBackScreen_MembersInjector.injectAppVersionProvider(appFeedBackScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            AppFeedBackScreen_MembersInjector.injectConfigurationLocalRepository(appFeedBackScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            AppFeedBackScreen_MembersInjector.injectHelpCenterDeeplinkBuilder(appFeedBackScreen, (IHelpCenterDeeplinkBuilder) Preconditions.checkNotNullFromComponent(this.helpCenterFeatureApi.getHelpCenterDeeplinkNavigator()));
            AppFeedBackScreen_MembersInjector.injectDeepLinkNavigator(appFeedBackScreen, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return appFeedBackScreen;
        }

        public void inject(AppFeedBackScreen appFeedBackScreen) {
            injectAppFeedBackScreen(appFeedBackScreen);
        }
    }

    public static final class Factory implements AppFeedBackScreenComponent.Factory {
        private Factory() {
        }

        public AppFeedBackScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, HelpCenterFeatureApi helpCenterFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(helpCenterFeatureApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new AppFeedBackScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, helpCenterFeatureApi, deepLinkCoreLibApi);
        }
    }

    private DaggerAppFeedBackScreenComponent() {
    }

    public static AppFeedBackScreenComponent.Factory factory() {
        return new Factory();
    }
}
