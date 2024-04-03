package com.talabat.core.wearable.huawei.data.di;

import android.content.Context;
import com.huawei.wearengine.auth.AuthClient;
import com.huawei.wearengine.device.DeviceClient;
import com.huawei.wearengine.p2p.P2pClient;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit;
import com.talabat.core.wearable.huawei.data.di.HuaweiWatchCoreLibApiComponent;
import com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit;
import com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit_Factory;
import com.talabat.core.wearable.huawei.domain.TalabatHuaweiWatch;
import com.talabat.talabatcore.cache.Cache;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerHuaweiWatchCoreLibApiComponent {

    public static final class Factory implements HuaweiWatchCoreLibApiComponent.Factory {
        private Factory() {
        }

        public HuaweiWatchCoreLibApiComponent create(ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            return new HuaweiWatchCoreLibApiComponentImpl(contextCoreLibApi);
        }
    }

    public static final class HuaweiWatchCoreLibApiComponentImpl implements HuaweiWatchCoreLibApiComponent {
        private Provider<AuthClient> authClientProvider;
        private Provider<DefaultHuaweiWearEngineKit> defaultHuaweiWearEngineKitProvider;
        private Provider<DeviceClient> deviceClientProvider;
        private Provider<Cache> diskCacheProvider;
        private Provider<Context> getContextProvider;
        private final HuaweiWatchCoreLibApiComponentImpl huaweiWatchCoreLibApiComponentImpl;
        private Provider<TalabatHuaweiWatch> huaweiWatchProvider;
        private Provider<HuaweiWearEngineKit> huaweiWearEngineKitProvider;
        private Provider<P2pClient> p2pClientProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        private HuaweiWatchCoreLibApiComponentImpl(ContextCoreLibApi contextCoreLibApi) {
            this.huaweiWatchCoreLibApiComponentImpl = this;
            initialize(contextCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi) {
            this.diskCacheProvider = SingleCheck.provider(HuaweiWatchModule_Companion_DiskCacheFactory.create());
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            this.deviceClientProvider = SingleCheck.provider(HuaweiWatchModule_Companion_DeviceClientFactory.create(getContextProvider2));
            this.authClientProvider = SingleCheck.provider(HuaweiWatchModule_Companion_AuthClientFactory.create(this.getContextProvider));
            Provider<P2pClient> provider = SingleCheck.provider(HuaweiWatchModule_Companion_P2pClientFactory.create(this.getContextProvider));
            this.p2pClientProvider = provider;
            DefaultHuaweiWearEngineKit_Factory create = DefaultHuaweiWearEngineKit_Factory.create(this.diskCacheProvider, this.deviceClientProvider, this.authClientProvider, provider);
            this.defaultHuaweiWearEngineKitProvider = create;
            Provider<HuaweiWearEngineKit> provider2 = SingleCheck.provider(create);
            this.huaweiWearEngineKitProvider = provider2;
            this.huaweiWatchProvider = SingleCheck.provider(HuaweiWatchModule_Companion_HuaweiWatchFactory.create(provider2));
        }

        public TalabatHuaweiWatch getHuaweiWatch() {
            return this.huaweiWatchProvider.get();
        }
    }

    private DaggerHuaweiWatchCoreLibApiComponent() {
    }

    public static HuaweiWatchCoreLibApiComponent.Factory factory() {
        return new Factory();
    }
}
