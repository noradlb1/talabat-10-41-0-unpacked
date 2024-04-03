package com.talabat.core.flutter.binding.data.apicallmocks;

import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallbackDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApiCallMocksFlutterEngineBinding_Factory implements Factory<ApiCallMocksFlutterEngineBinding> {
    private final Provider<ApiCallsMockChannelCallbackDomain> apiCallsMockChannelFlutterDomainProvider;

    public ApiCallMocksFlutterEngineBinding_Factory(Provider<ApiCallsMockChannelCallbackDomain> provider) {
        this.apiCallsMockChannelFlutterDomainProvider = provider;
    }

    public static ApiCallMocksFlutterEngineBinding_Factory create(Provider<ApiCallsMockChannelCallbackDomain> provider) {
        return new ApiCallMocksFlutterEngineBinding_Factory(provider);
    }

    public static ApiCallMocksFlutterEngineBinding newInstance(ApiCallsMockChannelCallbackDomain apiCallsMockChannelCallbackDomain) {
        return new ApiCallMocksFlutterEngineBinding(apiCallsMockChannelCallbackDomain);
    }

    public ApiCallMocksFlutterEngineBinding get() {
        return newInstance(this.apiCallsMockChannelFlutterDomainProvider.get());
    }
}
