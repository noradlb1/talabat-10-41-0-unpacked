package com.talabat.core.wearable.huawei.data.di;

import android.content.Context;
import com.huawei.wearengine.auth.AuthClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class HuaweiWatchModule_Companion_AuthClientFactory implements Factory<AuthClient> {
    private final Provider<Context> contextProvider;

    public HuaweiWatchModule_Companion_AuthClientFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static AuthClient authClient(Context context) {
        return (AuthClient) Preconditions.checkNotNullFromProvides(HuaweiWatchModule.Companion.authClient(context));
    }

    public static HuaweiWatchModule_Companion_AuthClientFactory create(Provider<Context> provider) {
        return new HuaweiWatchModule_Companion_AuthClientFactory(provider);
    }

    public AuthClient get() {
        return authClient(this.contextProvider.get());
    }
}
