package com.talabat.core.advertisement.google.data.di;

import android.content.Context;
import com.talabat.core.advertisement.google.data.AdMobRepository;
import com.talabat.core.advertisement.google.data.AdMobRepository_Factory;
import com.talabat.core.advertisement.google.data.datasource.GoogleAidDataSource;
import com.talabat.core.advertisement.google.data.datasource.legacy.LegacyGoogleAidDataSource_Factory;
import com.talabat.core.advertisement.google.data.di.GoogleAdvertisementCoreLibComponent;
import com.talabat.core.advertisement.google.domain.GoogleAdvertisementRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerGoogleAdvertisementCoreLibComponent {

    public static final class Factory implements GoogleAdvertisementCoreLibComponent.Factory {
        private Factory() {
        }

        public GoogleAdvertisementCoreLibComponent create(ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            return new GoogleAdvertisementCoreLibComponentImpl(contextCoreLibApi);
        }
    }

    public static final class GoogleAdvertisementCoreLibComponentImpl implements GoogleAdvertisementCoreLibComponent {
        private Provider<AdMobRepository> adMobRepositoryProvider;
        private Provider<GoogleAdvertisementRepository> adMobRepositoryProvider2;
        private Provider<Context> getContextProvider;
        private final GoogleAdvertisementCoreLibComponentImpl googleAdvertisementCoreLibComponentImpl;
        private Provider<GoogleAidDataSource> legacyDataSourceProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        private GoogleAdvertisementCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi) {
            this.googleAdvertisementCoreLibComponentImpl = this;
            initialize(contextCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi) {
            this.getContextProvider = new GetContextProvider(contextCoreLibApi);
            Provider<GoogleAidDataSource> provider = SingleCheck.provider(LegacyGoogleAidDataSource_Factory.create());
            this.legacyDataSourceProvider = provider;
            AdMobRepository_Factory create = AdMobRepository_Factory.create(this.getContextProvider, provider);
            this.adMobRepositoryProvider = create;
            this.adMobRepositoryProvider2 = SingleCheck.provider(create);
        }

        public GoogleAdvertisementRepository getGoogleAdvertisementRepository() {
            return this.adMobRepositoryProvider2.get();
        }
    }

    private DaggerGoogleAdvertisementCoreLibComponent() {
    }

    public static GoogleAdvertisementCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
