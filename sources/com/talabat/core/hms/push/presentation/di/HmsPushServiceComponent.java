package com.talabat.core.hms.push.presentation.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.hms.push.presentation.HmsPushService;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.wearable.huawei.domain.HuaweiWatchCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/hms/push/presentation/di/HmsPushServiceComponent;", "", "inject", "", "hmsPushService", "Lcom/talabat/core/hms/push/presentation/HmsPushService;", "Factory", "com_talabat_core_hms_push_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ContextCoreLibApi.class, GmsBaseCoreLibApi.class, DispatcherCoreLibApi.class, ObservabilityCoreLibApi.class, HuaweiWatchCoreLibApi.class}, modules = {HmsPushServiceModule.class})
public interface HmsPushServiceComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/hms/push/presentation/di/HmsPushServiceComponent$Factory;", "", "create", "Lcom/talabat/core/hms/push/presentation/di/HmsPushServiceComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "gmsBaseCoreLibApi", "Lcom/talabat/core/gms/base/domain/GmsBaseCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "huaweiWatchCoreLibApi", "Lcom/talabat/core/wearable/huawei/domain/HuaweiWatchCoreLibApi;", "com_talabat_core_hms_push_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        HmsPushServiceComponent create(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull GmsBaseCoreLibApi gmsBaseCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull HuaweiWatchCoreLibApi huaweiWatchCoreLibApi);
    }

    void inject(@NotNull HmsPushService hmsPushService);
}
