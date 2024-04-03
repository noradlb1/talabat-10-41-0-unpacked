package com.talabat.core.tracking.data.di;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import com.talabat.core.tracking.data.adjust.AdjustTrackerImpl_Factory;
import com.talabat.core.tracking.data.di.TrackingCoreLibComponent;
import com.talabat.core.tracking.data.migration.DefaultFlutterMigrationTools;
import com.talabat.core.tracking.data.migration.DefaultFlutterMigrationTools_Factory;
import com.talabat.core.tracking.data.perseus.LegacyPerseusEvenTools;
import com.talabat.core.tracking.data.perseus.LegacyPerseusEvenTools_Factory;
import com.talabat.core.tracking.domain.AnalyticsType;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.adjust.AdjustTracker;
import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.core.tracking.domain.perseus.PerseusEventTools;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerTrackingCoreLibComponent {

    public static final class Factory implements TrackingCoreLibComponent.Factory {
        private Factory() {
        }

        public TrackingCoreLibComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(gmsBaseCoreLibApi);
            Preconditions.checkNotNull(hmsBaseCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(talabatPerseusCoreLibApi);
            return new TrackingCoreLibComponentImpl(configurationLocalCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, gmsBaseCoreLibApi, hmsBaseCoreLibApi, observabilityCoreLibApi, talabatPerseusCoreLibApi);
        }
    }

    public static final class TrackingCoreLibComponentImpl implements TrackingCoreLibComponent {
        private Provider<AnalyticsType> analyticsTypeProvider;
        private Provider<DefaultFlutterMigrationTools> defaultFlutterMigrationToolsProvider;
        private Provider<Context> getContextProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TalabatPerseusRepository> getTalabatPerseusRepositoryProvider;
        private Provider<Boolean> isGmsAvailableProvider;
        private Provider<Boolean> isHmsAvailableProvider;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private Provider<AdjustTracker> provideAdjustTrackerProvider;
        private Provider<TalabatTracker> provideTalabatTrackerProvider;
        private Provider<IRemoteConfigurationDataSource> remoteConfigurationDataSourceProvider;
        private final TrackingCoreLibComponentImpl trackingCoreLibComponentImpl;

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

        public static final class GetRepositoryProvider implements Provider<ConfigurationLocalRepository> {
            private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

            public GetRepositoryProvider(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
                this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            }

            public ConfigurationLocalRepository get() {
                return (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository());
            }
        }

        public static final class GetTalabatFeatureFlagProvider implements Provider<ITalabatFeatureFlag> {
            private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

            public GetTalabatFeatureFlagProvider(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
                this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            }

            public ITalabatFeatureFlag get() {
                return (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag());
            }
        }

        public static final class GetTalabatPerseusRepositoryProvider implements Provider<TalabatPerseusRepository> {
            private final TalabatPerseusCoreLibApi talabatPerseusCoreLibApi;

            public GetTalabatPerseusRepositoryProvider(TalabatPerseusCoreLibApi talabatPerseusCoreLibApi2) {
                this.talabatPerseusCoreLibApi = talabatPerseusCoreLibApi2;
            }

            public TalabatPerseusRepository get() {
                return (TalabatPerseusRepository) Preconditions.checkNotNullFromComponent(this.talabatPerseusCoreLibApi.getTalabatPerseusRepository());
            }
        }

        public static final class IsGmsAvailableProvider implements Provider<Boolean> {
            private final GmsBaseCoreLibApi gmsBaseCoreLibApi;

            public IsGmsAvailableProvider(GmsBaseCoreLibApi gmsBaseCoreLibApi2) {
                this.gmsBaseCoreLibApi = gmsBaseCoreLibApi2;
            }

            public Boolean get() {
                return Boolean.valueOf(this.gmsBaseCoreLibApi.isGmsAvailable());
            }
        }

        public static final class IsHmsAvailableProvider implements Provider<Boolean> {
            private final HmsBaseCoreLibApi hmsBaseCoreLibApi;

            public IsHmsAvailableProvider(HmsBaseCoreLibApi hmsBaseCoreLibApi2) {
                this.hmsBaseCoreLibApi = hmsBaseCoreLibApi2;
            }

            public Boolean get() {
                return Boolean.valueOf(this.hmsBaseCoreLibApi.isHmsAvailable());
            }
        }

        private TrackingCoreLibComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi2, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
            this.trackingCoreLibComponentImpl = this;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            initialize(configurationLocalCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, gmsBaseCoreLibApi, hmsBaseCoreLibApi, observabilityCoreLibApi2, talabatPerseusCoreLibApi);
        }

        private DefaultFlutterMigrationTools defaultFlutterMigrationTools() {
            return new DefaultFlutterMigrationTools((IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()), this.remoteConfigurationDataSourceProvider.get());
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi2, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
            this.isGmsAvailableProvider = new IsGmsAvailableProvider(gmsBaseCoreLibApi);
            IsHmsAvailableProvider isHmsAvailableProvider2 = new IsHmsAvailableProvider(hmsBaseCoreLibApi);
            this.isHmsAvailableProvider = isHmsAvailableProvider2;
            this.analyticsTypeProvider = SingleCheck.provider(TrackingCoreModule_AnalyticsTypeFactory.create(this.isGmsAvailableProvider, isHmsAvailableProvider2));
            this.provideAdjustTrackerProvider = SingleCheck.provider(AdjustTrackerImpl_Factory.create());
            this.getContextProvider = new GetContextProvider(contextCoreLibApi);
            this.getObservabilityManagerProvider = new GetObservabilityManagerProvider(observabilityCoreLibApi2);
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getTalabatPerseusRepositoryProvider = new GetTalabatPerseusRepositoryProvider(talabatPerseusCoreLibApi);
            this.getRepositoryProvider = new GetRepositoryProvider(configurationLocalCoreLibApi);
            Provider<IRemoteConfigurationDataSource> provider = SingleCheck.provider(RemoteConfigCoreLibModule_RemoteConfigurationDataSourceFactory.create());
            this.remoteConfigurationDataSourceProvider = provider;
            this.defaultFlutterMigrationToolsProvider = DefaultFlutterMigrationTools_Factory.create(this.getObservabilityManagerProvider, provider);
            this.provideTalabatTrackerProvider = SingleCheck.provider(TrackingCoreModule_ProvideTalabatTrackerFactory.create(this.getContextProvider, this.analyticsTypeProvider, this.getObservabilityManagerProvider, LegacyPerseusEvenTools_Factory.create(), this.getTalabatFeatureFlagProvider, this.getTalabatPerseusRepositoryProvider, this.getRepositoryProvider, this.defaultFlutterMigrationToolsProvider));
        }

        public AdjustTracker getAdjustTracker() {
            return this.provideAdjustTrackerProvider.get();
        }

        public AnalyticsType getAnalyticsType() {
            return this.analyticsTypeProvider.get();
        }

        public FlutterMigrationTools getFlutterMigrationTools() {
            return defaultFlutterMigrationTools();
        }

        public PerseusEventTools getPerseusEventTools() {
            return new LegacyPerseusEvenTools();
        }

        public TalabatTracker getTalabatTracker() {
            return this.provideTalabatTrackerProvider.get();
        }
    }

    private DaggerTrackingCoreLibComponent() {
    }

    public static TrackingCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
