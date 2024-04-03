package com.talabat.feature.bnplcheckout.presentation.channel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BNPLCheckoutMethodCallHandler_Factory implements Factory<BNPLCheckoutMethodCallHandler> {
    private final Provider<BNPLCheckoutChannelCallback> callbackProvider;
    private final Provider<String> orderAmountProvider;
    private final Provider<String> planIdProvider;

    public BNPLCheckoutMethodCallHandler_Factory(Provider<BNPLCheckoutChannelCallback> provider, Provider<String> provider2, Provider<String> provider3) {
        this.callbackProvider = provider;
        this.planIdProvider = provider2;
        this.orderAmountProvider = provider3;
    }

    public static BNPLCheckoutMethodCallHandler_Factory create(Provider<BNPLCheckoutChannelCallback> provider, Provider<String> provider2, Provider<String> provider3) {
        return new BNPLCheckoutMethodCallHandler_Factory(provider, provider2, provider3);
    }

    public static BNPLCheckoutMethodCallHandler newInstance(BNPLCheckoutChannelCallback bNPLCheckoutChannelCallback, String str, String str2) {
        return new BNPLCheckoutMethodCallHandler(bNPLCheckoutChannelCallback, str, str2);
    }

    public BNPLCheckoutMethodCallHandler get() {
        return newInstance(this.callbackProvider.get(), this.planIdProvider.get(), this.orderAmountProvider.get());
    }
}
