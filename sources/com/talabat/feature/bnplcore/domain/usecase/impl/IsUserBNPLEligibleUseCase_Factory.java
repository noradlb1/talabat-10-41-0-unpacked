package com.talabat.feature.bnplcore.domain.usecase.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsUserBNPLEligibleUseCase_Factory implements Factory<IsUserBNPLEligibleUseCase> {
    private final Provider<BNPLCoreFlutterChannel> bNPLCoreFlutterChannelProvider;

    public IsUserBNPLEligibleUseCase_Factory(Provider<BNPLCoreFlutterChannel> provider) {
        this.bNPLCoreFlutterChannelProvider = provider;
    }

    public static IsUserBNPLEligibleUseCase_Factory create(Provider<BNPLCoreFlutterChannel> provider) {
        return new IsUserBNPLEligibleUseCase_Factory(provider);
    }

    public static IsUserBNPLEligibleUseCase newInstance(BNPLCoreFlutterChannel bNPLCoreFlutterChannel) {
        return new IsUserBNPLEligibleUseCase(bNPLCoreFlutterChannel);
    }

    public IsUserBNPLEligibleUseCase get() {
        return newInstance(this.bNPLCoreFlutterChannelProvider.get());
    }
}
