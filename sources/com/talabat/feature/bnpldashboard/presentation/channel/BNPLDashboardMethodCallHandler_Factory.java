package com.talabat.feature.bnpldashboard.presentation.channel;

import com.talabat.feature.bnpldashboard.presentation.BNPLDashboardChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BNPLDashboardMethodCallHandler_Factory implements Factory<BNPLDashboardMethodCallHandler> {
    private final Provider<BNPLDashboardChannelCallback> callbackProvider;
    private final Provider<String> eventOriginProvider;

    public BNPLDashboardMethodCallHandler_Factory(Provider<String> provider, Provider<BNPLDashboardChannelCallback> provider2) {
        this.eventOriginProvider = provider;
        this.callbackProvider = provider2;
    }

    public static BNPLDashboardMethodCallHandler_Factory create(Provider<String> provider, Provider<BNPLDashboardChannelCallback> provider2) {
        return new BNPLDashboardMethodCallHandler_Factory(provider, provider2);
    }

    public static BNPLDashboardMethodCallHandler newInstance(String str, BNPLDashboardChannelCallback bNPLDashboardChannelCallback) {
        return new BNPLDashboardMethodCallHandler(str, bNPLDashboardChannelCallback);
    }

    public BNPLDashboardMethodCallHandler get() {
        return newInstance(this.eventOriginProvider.get(), this.callbackProvider.get());
    }
}
