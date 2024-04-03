package com.talabat.core.tracking.data.di;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import com.talabat.core.tracking.domain.AnalyticsType;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.core.tracking.domain.perseus.PerseusEventTools;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class TrackingCoreModule_ProvideTalabatTrackerFactory implements Factory<TalabatTracker> {
    private final Provider<AnalyticsType> analyticsTypeProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<FlutterMigrationTools> migrationToolsProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PerseusEventTools> perseusEventToolsProvider;
    private final Provider<TalabatPerseusRepository> perseusRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagsProvider;

    public TrackingCoreModule_ProvideTalabatTrackerFactory(Provider<Context> provider, Provider<AnalyticsType> provider2, Provider<IObservabilityManager> provider3, Provider<PerseusEventTools> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<TalabatPerseusRepository> provider6, Provider<ConfigurationLocalRepository> provider7, Provider<FlutterMigrationTools> provider8) {
        this.contextProvider = provider;
        this.analyticsTypeProvider = provider2;
        this.observabilityManagerProvider = provider3;
        this.perseusEventToolsProvider = provider4;
        this.talabatFeatureFlagsProvider = provider5;
        this.perseusRepositoryProvider = provider6;
        this.configurationLocalRepositoryProvider = provider7;
        this.migrationToolsProvider = provider8;
    }

    public static TrackingCoreModule_ProvideTalabatTrackerFactory create(Provider<Context> provider, Provider<AnalyticsType> provider2, Provider<IObservabilityManager> provider3, Provider<PerseusEventTools> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<TalabatPerseusRepository> provider6, Provider<ConfigurationLocalRepository> provider7, Provider<FlutterMigrationTools> provider8) {
        return new TrackingCoreModule_ProvideTalabatTrackerFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static TalabatTracker provideTalabatTracker(Context context, AnalyticsType analyticsType, IObservabilityManager iObservabilityManager, PerseusEventTools perseusEventTools, ITalabatFeatureFlag iTalabatFeatureFlag, TalabatPerseusRepository talabatPerseusRepository, ConfigurationLocalRepository configurationLocalRepository, FlutterMigrationTools flutterMigrationTools) {
        return (TalabatTracker) Preconditions.checkNotNullFromProvides(TrackingCoreModule.INSTANCE.provideTalabatTracker(context, analyticsType, iObservabilityManager, perseusEventTools, iTalabatFeatureFlag, talabatPerseusRepository, configurationLocalRepository, flutterMigrationTools));
    }

    public TalabatTracker get() {
        return provideTalabatTracker(this.contextProvider.get(), this.analyticsTypeProvider.get(), this.observabilityManagerProvider.get(), this.perseusEventToolsProvider.get(), this.talabatFeatureFlagsProvider.get(), this.perseusRepositoryProvider.get(), this.configurationLocalRepositoryProvider.get(), this.migrationToolsProvider.get());
    }
}
