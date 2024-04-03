package com.talabat.feature.darkstores.presentation.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.feature.darkstores.presentation.activity.DarkStoresDeepLinkActivity;
import com.talabat.feature.darkstores.presentation.activity.DarkStoresDeepLinkActivity_MembersInjector;
import com.talabat.feature.darkstores.presentation.di.DarkStoresViewComponent;
import com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel;
import com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerDarkStoresViewComponent {

    public static final class DarkStoresViewComponentImpl implements DarkStoresViewComponent {
        private Provider<DarkStoresDeepLinkViewModel> darkStoresDeepLinkViewModelProvider;
        private final DarkStoresViewComponentImpl darkStoresViewComponentImpl;
        private final DarkstoresFeatureApi darkstoresFeatureApi;
        private Provider<DarkstoresRepository> darkstoresRepositoryProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;

        public static final class DarkstoresRepositoryProvider implements Provider<DarkstoresRepository> {
            private final DarkstoresFeatureApi darkstoresFeatureApi;

            public DarkstoresRepositoryProvider(DarkstoresFeatureApi darkstoresFeatureApi2) {
                this.darkstoresFeatureApi = darkstoresFeatureApi2;
            }

            public DarkstoresRepository get() {
                return (DarkstoresRepository) Preconditions.checkNotNullFromComponent(this.darkstoresFeatureApi.darkstoresRepository());
            }
        }

        public static final class GetRepositoryProvider implements Provider<ConfigurationLocalRepository> {
            private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

            public GetRepositoryProvider(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
                this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            }

            public ConfigurationLocalRepository get() {
                return (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository());
            }
        }

        private DarkStoresViewComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DarkstoresFeatureApi darkstoresFeatureApi2) {
            this.darkStoresViewComponentImpl = this;
            this.darkstoresFeatureApi = darkstoresFeatureApi2;
            initialize(configurationLocalCoreLibApi, darkstoresFeatureApi2);
        }

        private DarkStoresDeepLinkViewModelFactory darkStoresDeepLinkViewModelFactory() {
            return new DarkStoresDeepLinkViewModelFactory(this.darkStoresDeepLinkViewModelProvider);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DarkstoresFeatureApi darkstoresFeatureApi2) {
            this.darkstoresRepositoryProvider = new DarkstoresRepositoryProvider(darkstoresFeatureApi2);
            GetRepositoryProvider getRepositoryProvider2 = new GetRepositoryProvider(configurationLocalCoreLibApi);
            this.getRepositoryProvider = getRepositoryProvider2;
            this.darkStoresDeepLinkViewModelProvider = DarkStoresDeepLinkViewModel_Factory.create(this.darkstoresRepositoryProvider, getRepositoryProvider2);
        }

        private DarkStoresDeepLinkActivity injectDarkStoresDeepLinkActivity(DarkStoresDeepLinkActivity darkStoresDeepLinkActivity) {
            DarkStoresDeepLinkActivity_MembersInjector.injectViewModelFactory(darkStoresDeepLinkActivity, darkStoresDeepLinkViewModelFactory());
            DarkStoresDeepLinkActivity_MembersInjector.injectDarkStoresNavigator(darkStoresDeepLinkActivity, (DarkstoresNavigator) Preconditions.checkNotNullFromComponent(this.darkstoresFeatureApi.darkstoresNavigator()));
            return darkStoresDeepLinkActivity;
        }

        public void inject(DarkStoresDeepLinkActivity darkStoresDeepLinkActivity) {
            injectDarkStoresDeepLinkActivity(darkStoresDeepLinkActivity);
        }
    }

    public static final class Factory implements DarkStoresViewComponent.Factory {
        private Factory() {
        }

        public DarkStoresViewComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DarkstoresFeatureApi darkstoresFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(darkstoresFeatureApi);
            return new DarkStoresViewComponentImpl(configurationLocalCoreLibApi, darkstoresFeatureApi);
        }
    }

    private DaggerDarkStoresViewComponent() {
    }

    public static DarkStoresViewComponent.Factory factory() {
        return new Factory();
    }
}
