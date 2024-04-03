package com.talabat.gem;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.gem.ports.analytics.AnalyticsPort;
import com.talabat.gem.ports.data.DataSourcesPort;
import com.talabat.gem.ports.flags.FeatureFlagPort;
import com.talabat.gem.ports.logging.LoggerPort;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\b\u00102\u001a\u00020\u0007H\u0002\u001a!\u00103\u001a\u0002042\u0017\u00105\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020406¢\u0006\u0002\b7H\u0007\u001a\u0015\u00108\u001a\u000204*\u00020-2\u0006\u00108\u001a\u00020\u0001H\u0004\u001a\u0015\u00109\u001a\u000204*\u00020-2\u0006\u00109\u001a\u00020\u0007H\u0004\u001a\u0015\u0010:\u001a\u000204*\u00020-2\u0006\u0010:\u001a\u00020\u0014H\u0004\u001a\u0015\u0010;\u001a\u000204*\u00020-2\u0006\u0010<\u001a\u00020\u001bH\u0004\u001a\u0015\u0010=\u001a\u000204*\u00020-2\u0006\u0010=\u001a\u00020 H\u0004\u001a\u0015\u0010&\u001a\u000204*\u00020-2\u0006\u0010<\u001a\u00020'H\u0004\"\u001a\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00070\u00070\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0014@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\"\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\"$\u0010!\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020 @@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\"\u001a\u0010&\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\"\u001e\u0010,\u001a\u00020-*\u00020-8FX\u0004¢\u0006\f\u0012\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u0006>"}, d2 = {"Analytics", "Lcom/talabat/gem/ports/analytics/AnalyticsPort;", "getAnalytics", "()Lcom/talabat/gem/ports/analytics/AnalyticsPort;", "setAnalytics", "(Lcom/talabat/gem/ports/analytics/AnalyticsPort;)V", "<set-?>", "Lcom/talabat/gem/ports/data/DataSourcesPort;", "DataSources", "getDataSources", "()Lcom/talabat/gem/ports/data/DataSourcesPort;", "setDataSources", "(Lcom/talabat/gem/ports/data/DataSourcesPort;)V", "DataSources$delegate", "Lkotlin/properties/ReadWriteProperty;", "DataSourcesObservable", "Lio/reactivex/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "getDataSourcesObservable", "()Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/gem/ports/flags/FeatureFlagPort;", "FeatureFlags", "getFeatureFlags", "()Lcom/talabat/gem/ports/flags/FeatureFlagPort;", "setFeatureFlags", "(Lcom/talabat/gem/ports/flags/FeatureFlagPort;)V", "LocationConfig", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfig", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfig", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "Lcom/talabat/gem/ports/logging/LoggerPort;", "Logger", "getLogger", "()Lcom/talabat/gem/ports/logging/LoggerPort;", "setLogger", "(Lcom/talabat/gem/ports/logging/LoggerPort;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "set", "Lcom/talabat/gem/GemCoreIntegrator;", "getSet$annotations", "(Lcom/talabat/gem/GemCoreIntegrator;)V", "getSet", "(Lcom/talabat/gem/GemCoreIntegrator;)Lcom/talabat/gem/GemCoreIntegrator;", "DefaultDataSourcesPort", "GemCoreIntegration", "", "integration", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "analytics", "dataSources", "featureFlags", "locationConfig", "value", "logger", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class IntegrationKt {
    @NotNull
    private static AnalyticsPort Analytics = new IntegrationKt$Analytics$1();
    @NotNull
    private static final ReadWriteProperty DataSources$delegate = new IntegrationKt$special$$inlined$observable$1(DefaultDataSourcesPort());
    @NotNull
    private static final BehaviorSubject<DataSourcesPort> DataSourcesObservable;
    @NotNull
    private static FeatureFlagPort FeatureFlags = new IntegrationKt$FeatureFlags$1();
    public static LocationConfigurationRepository LocationConfig;
    @NotNull
    private static LoggerPort Logger = new IntegrationKt$Logger$1();

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f59831a = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(IntegrationKt.class, "DataSources", "getDataSources()Lcom/talabat/gem/ports/data/DataSourcesPort;", 1))};
    public static Navigator navigator;

    static {
        BehaviorSubject<DataSourcesPort> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<DataSourcesPort>()");
        DataSourcesObservable = create;
        Delegates delegates = Delegates.INSTANCE;
    }

    private static final DataSourcesPort DefaultDataSourcesPort() {
        return new IntegrationKt$DefaultDataSourcesPort$1();
    }

    @GemIntegrationDsl
    public static final void GemCoreIntegration(@NotNull Function1<? super GemCoreIntegrator, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "integration");
        function1.invoke(new GemCoreIntegrator());
    }

    @GemIntegrationDsl
    public static final void analytics(@NotNull GemCoreIntegrator gemCoreIntegrator, @NotNull AnalyticsPort analyticsPort) {
        Intrinsics.checkNotNullParameter(gemCoreIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(analyticsPort, "analytics");
        Analytics = analyticsPort;
    }

    @GemIntegrationDsl
    public static final void dataSources(@NotNull GemCoreIntegrator gemCoreIntegrator, @NotNull DataSourcesPort dataSourcesPort) {
        Intrinsics.checkNotNullParameter(gemCoreIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(dataSourcesPort, "dataSources");
        setDataSources(dataSourcesPort);
    }

    @GemIntegrationDsl
    public static final void featureFlags(@NotNull GemCoreIntegrator gemCoreIntegrator, @NotNull FeatureFlagPort featureFlagPort) {
        Intrinsics.checkNotNullParameter(gemCoreIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(featureFlagPort, "featureFlags");
        FeatureFlags = featureFlagPort;
    }

    @NotNull
    public static final AnalyticsPort getAnalytics() {
        return Analytics;
    }

    @NotNull
    public static final DataSourcesPort getDataSources() {
        return (DataSourcesPort) DataSources$delegate.getValue(null, f59831a[0]);
    }

    @NotNull
    public static final BehaviorSubject<DataSourcesPort> getDataSourcesObservable() {
        return DataSourcesObservable;
    }

    @NotNull
    public static final FeatureFlagPort getFeatureFlags() {
        return FeatureFlags;
    }

    @NotNull
    public static final LocationConfigurationRepository getLocationConfig() {
        LocationConfigurationRepository locationConfigurationRepository = LocationConfig;
        if (locationConfigurationRepository != null) {
            return locationConfigurationRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("LocationConfig");
        return null;
    }

    @NotNull
    public static final LoggerPort getLogger() {
        return Logger;
    }

    @NotNull
    public static final Navigator getNavigator() {
        Navigator navigator2 = navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    @NotNull
    public static final GemCoreIntegrator getSet(@NotNull GemCoreIntegrator gemCoreIntegrator) {
        Intrinsics.checkNotNullParameter(gemCoreIntegrator, "<this>");
        return gemCoreIntegrator;
    }

    @GemIntegrationDsl
    public static /* synthetic */ void getSet$annotations(GemCoreIntegrator gemCoreIntegrator) {
    }

    @GemIntegrationDsl
    public static final void locationConfig(@NotNull GemCoreIntegrator gemCoreIntegrator, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(gemCoreIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "value");
        setLocationConfig(locationConfigurationRepository);
    }

    @GemIntegrationDsl
    public static final void logger(@NotNull GemCoreIntegrator gemCoreIntegrator, @NotNull LoggerPort loggerPort) {
        Intrinsics.checkNotNullParameter(gemCoreIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(loggerPort, "logger");
        Logger = loggerPort;
    }

    @GemIntegrationDsl
    public static final void navigator(@NotNull GemCoreIntegrator gemCoreIntegrator, @NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(gemCoreIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(navigator2, "value");
        setNavigator(navigator2);
    }

    public static final void setAnalytics(@NotNull AnalyticsPort analyticsPort) {
        Intrinsics.checkNotNullParameter(analyticsPort, "<set-?>");
        Analytics = analyticsPort;
    }

    public static final void setDataSources(@NotNull DataSourcesPort dataSourcesPort) {
        Intrinsics.checkNotNullParameter(dataSourcesPort, "<set-?>");
        DataSources$delegate.setValue(null, f59831a[0], dataSourcesPort);
    }

    public static final void setFeatureFlags(@NotNull FeatureFlagPort featureFlagPort) {
        Intrinsics.checkNotNullParameter(featureFlagPort, "<set-?>");
        FeatureFlags = featureFlagPort;
    }

    public static final void setLocationConfig(@NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "<set-?>");
        LocationConfig = locationConfigurationRepository;
    }

    public static final void setLogger(@NotNull LoggerPort loggerPort) {
        Intrinsics.checkNotNullParameter(loggerPort, "<set-?>");
        Logger = loggerPort;
    }

    public static final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        navigator = navigator2;
    }
}
