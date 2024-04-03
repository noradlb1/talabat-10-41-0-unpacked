package com.talabat.core.deeplink.data.handler.wallet;

import com.talabat.core.navigation.domain.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TopUpHandler_Factory implements Factory<TopUpHandler> {
    private final Provider<Navigator> navigatorProvider;

    public TopUpHandler_Factory(Provider<Navigator> provider) {
        this.navigatorProvider = provider;
    }

    public static TopUpHandler_Factory create(Provider<Navigator> provider) {
        return new TopUpHandler_Factory(provider);
    }

    public static TopUpHandler newInstance(Navigator navigator) {
        return new TopUpHandler(navigator);
    }

    public TopUpHandler get() {
        return newInstance(this.navigatorProvider.get());
    }
}
