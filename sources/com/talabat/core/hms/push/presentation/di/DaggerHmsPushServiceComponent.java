package com.talabat.core.hms.push.presentation.di;

import android.content.Context;
import com.braze.Braze;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.hms.push.presentation.HmsPushService;
import com.talabat.core.hms.push.presentation.HmsPushService_MembersInjector;
import com.talabat.core.hms.push.presentation.di.HmsPushServiceComponent;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.wearable.huawei.domain.HuaweiWatchCoreLibApi;
import com.talabat.core.wearable.huawei.domain.TalabatHuaweiWatch;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineScope;

@DaggerGenerated
public final class DaggerHmsPushServiceComponent {

    public static final class Factory implements HmsPushServiceComponent.Factory {
        private Factory() {
        }

        public HmsPushServiceComponent create(ContextCoreLibApi contextCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, HuaweiWatchCoreLibApi huaweiWatchCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(gmsBaseCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(huaweiWatchCoreLibApi);
            return new HmsPushServiceComponentImpl(contextCoreLibApi, gmsBaseCoreLibApi, dispatcherCoreLibApi, observabilityCoreLibApi, huaweiWatchCoreLibApi);
        }
    }

    public static final class HmsPushServiceComponentImpl implements HmsPushServiceComponent {
        private final ContextCoreLibApi contextCoreLibApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final GmsBaseCoreLibApi gmsBaseCoreLibApi;
        private final HmsPushServiceComponentImpl hmsPushServiceComponentImpl;
        private final HuaweiWatchCoreLibApi huaweiWatchCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;

        private HmsPushServiceComponentImpl(ContextCoreLibApi contextCoreLibApi2, GmsBaseCoreLibApi gmsBaseCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, HuaweiWatchCoreLibApi huaweiWatchCoreLibApi2) {
            this.hmsPushServiceComponentImpl = this;
            this.huaweiWatchCoreLibApi = huaweiWatchCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.gmsBaseCoreLibApi = gmsBaseCoreLibApi2;
            this.contextCoreLibApi = contextCoreLibApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
        }

        private Braze braze() {
            return HmsPushServiceModule_AppBoyFactory.appBoy((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()));
        }

        private CoroutineScope coroutineScope() {
            return HmsPushServiceModule_UiScopeFactory.uiScope((CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()));
        }

        private HmsPushService injectHmsPushService(HmsPushService hmsPushService) {
            HmsPushService_MembersInjector.injectTalabatHuaweiWatch(hmsPushService, (TalabatHuaweiWatch) Preconditions.checkNotNullFromComponent(this.huaweiWatchCoreLibApi.getHuaweiWatch()));
            HmsPushService_MembersInjector.injectObservabilityManager(hmsPushService, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            HmsPushService_MembersInjector.injectIsGmsAvailable(hmsPushService, this.gmsBaseCoreLibApi.isGmsAvailable());
            HmsPushService_MembersInjector.injectBraze(hmsPushService, braze());
            HmsPushService_MembersInjector.injectUiScope(hmsPushService, coroutineScope());
            return hmsPushService;
        }

        public void inject(HmsPushService hmsPushService) {
            injectHmsPushService(hmsPushService);
        }
    }

    private DaggerHmsPushServiceComponent() {
    }

    public static HmsPushServiceComponent.Factory factory() {
        return new Factory();
    }
}
