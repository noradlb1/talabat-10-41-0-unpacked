package com.talabat.core.flutter.channels.impl.data.tracking;

import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.fluttercore.channels.AnalyticsMethodChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TrackingChannelCallbackImpl_Factory implements Factory<TrackingChannelCallbackImpl> {
    private final Provider<AnalyticsMethodChannelCallback> analyticsCallbackProvider;
    private final Provider<FlutterMigrationTools> flutterMigrationToolsProvider;

    public TrackingChannelCallbackImpl_Factory(Provider<AnalyticsMethodChannelCallback> provider, Provider<FlutterMigrationTools> provider2) {
        this.analyticsCallbackProvider = provider;
        this.flutterMigrationToolsProvider = provider2;
    }

    public static TrackingChannelCallbackImpl_Factory create(Provider<AnalyticsMethodChannelCallback> provider, Provider<FlutterMigrationTools> provider2) {
        return new TrackingChannelCallbackImpl_Factory(provider, provider2);
    }

    public static TrackingChannelCallbackImpl newInstance(AnalyticsMethodChannelCallback analyticsMethodChannelCallback, FlutterMigrationTools flutterMigrationTools) {
        return new TrackingChannelCallbackImpl(analyticsMethodChannelCallback, flutterMigrationTools);
    }

    public TrackingChannelCallbackImpl get() {
        return newInstance(this.analyticsCallbackProvider.get(), this.flutterMigrationToolsProvider.get());
    }
}
