package com.talabat.feature.ulcampaign.data.di;

import android.content.Context;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.ulcampaign.data.CampaignMigratorObservability;
import com.talabat.feature.ulcampaign.data.CampaignMigratorObservabilityImpl;
import com.talabat.feature.ulcampaign.data.CampaignMigratorObservabilityImpl_Factory;
import com.talabat.feature.ulcampaign.data.CampaignMigratorRepositoryImpl;
import com.talabat.feature.ulcampaign.data.CampaignMigratorRepositoryImpl_Factory;
import com.talabat.feature.ulcampaign.data.CampaignMigratorSharedPreferencesImpl;
import com.talabat.feature.ulcampaign.data.CampaignMigratorSharedPreferencesImpl_Factory;
import com.talabat.feature.ulcampaign.data.di.CampaignMigratorFeatureComponent;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorRepository;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignCacheUseCase;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignDeeplinkUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerCampaignMigratorFeatureComponent {

    public static final class CampaignMigratorFeatureComponentImpl implements CampaignMigratorFeatureComponent {
        private final CampaignMigratorFeatureComponentImpl campaignMigratorFeatureComponentImpl;
        private Provider<CampaignMigratorObservabilityImpl> campaignMigratorObservabilityImplProvider;
        private Provider<CampaignMigratorObservability> campaignMigratorObservabilityProvider;
        private Provider<CampaignMigratorRepositoryImpl> campaignMigratorRepositoryImplProvider;
        private Provider<CampaignMigratorRepository> campaignMigratorRepositoryProvider;
        private Provider<CampaignMigratorSharedPreferencesImpl> campaignMigratorSharedPreferencesImplProvider;
        private Provider<Context> getContextProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<CampaignMigratorSharedPreferences> provideSharedPreferenceManagerProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetObservabilityManagerProvider implements Provider<IObservabilityManager> {
            private final ObservabilityCoreLibApi observabilityCoreLibApi;

            public GetObservabilityManagerProvider(ObservabilityCoreLibApi observabilityCoreLibApi2) {
                this.observabilityCoreLibApi = observabilityCoreLibApi2;
            }

            public IObservabilityManager get() {
                return (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager());
            }
        }

        private CampaignMigratorFeatureComponentImpl(ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            this.campaignMigratorFeatureComponentImpl = this;
            initialize(contextCoreLibApi, observabilityCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            CampaignMigratorSharedPreferencesImpl_Factory create = CampaignMigratorSharedPreferencesImpl_Factory.create(getContextProvider2);
            this.campaignMigratorSharedPreferencesImplProvider = create;
            this.provideSharedPreferenceManagerProvider = SingleCheck.provider(create);
            GetObservabilityManagerProvider getObservabilityManagerProvider2 = new GetObservabilityManagerProvider(observabilityCoreLibApi);
            this.getObservabilityManagerProvider = getObservabilityManagerProvider2;
            CampaignMigratorObservabilityImpl_Factory create2 = CampaignMigratorObservabilityImpl_Factory.create(getObservabilityManagerProvider2);
            this.campaignMigratorObservabilityImplProvider = create2;
            Provider<CampaignMigratorObservability> provider = SingleCheck.provider(create2);
            this.campaignMigratorObservabilityProvider = provider;
            CampaignMigratorRepositoryImpl_Factory create3 = CampaignMigratorRepositoryImpl_Factory.create(provider, this.provideSharedPreferenceManagerProvider);
            this.campaignMigratorRepositoryImplProvider = create3;
            this.campaignMigratorRepositoryProvider = SingleCheck.provider(create3);
        }

        public CampaignMigratorSharedPreferences getCampaignMigratorSharedPreferences() {
            return this.provideSharedPreferenceManagerProvider.get();
        }

        public VoucherCampaignCacheUseCase getVoucherCampaignCacheUseCase() {
            return new VoucherCampaignCacheUseCase(this.provideSharedPreferenceManagerProvider.get());
        }

        public VoucherCampaignDeeplinkUseCase getVoucherCampaignDeeplinkUseCase() {
            return new VoucherCampaignDeeplinkUseCase(this.campaignMigratorRepositoryProvider.get());
        }
    }

    public static final class Factory implements CampaignMigratorFeatureComponent.Factory {
        private Factory() {
        }

        public CampaignMigratorFeatureComponent create(ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new CampaignMigratorFeatureComponentImpl(contextCoreLibApi, observabilityCoreLibApi);
        }
    }

    private DaggerCampaignMigratorFeatureComponent() {
    }

    public static CampaignMigratorFeatureComponent.Factory factory() {
        return new Factory();
    }
}
