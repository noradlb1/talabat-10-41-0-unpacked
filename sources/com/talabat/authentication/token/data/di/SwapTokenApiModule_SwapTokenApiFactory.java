package com.talabat.authentication.token.data.di;

import com.talabat.authentication.token.data.remote.api.SwapTokenApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SwapTokenApiModule_SwapTokenApiFactory implements Factory<SwapTokenApi> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SwapTokenApiModule_SwapTokenApiFactory INSTANCE = new SwapTokenApiModule_SwapTokenApiFactory();

        private InstanceHolder() {
        }
    }

    public static SwapTokenApiModule_SwapTokenApiFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SwapTokenApi swapTokenApi() {
        return (SwapTokenApi) Preconditions.checkNotNullFromProvides(SwapTokenApiModule.INSTANCE.swapTokenApi());
    }

    public SwapTokenApi get() {
        return swapTokenApi();
    }
}
