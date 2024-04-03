package com.talabat.core.wearable.huawei.data.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.wearable.huawei.domain.HuaweiWatchCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/wearable/huawei/data/di/HuaweiWatchCoreLibApiComponent;", "Lcom/talabat/core/wearable/huawei/domain/HuaweiWatchCoreLibApi;", "Factory", "com_talabat_core_wearable_huawei_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ContextCoreLibApi.class}, modules = {HuaweiWatchModule.class})
public interface HuaweiWatchCoreLibApiComponent extends HuaweiWatchCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/wearable/huawei/data/di/HuaweiWatchCoreLibApiComponent$Factory;", "", "create", "Lcom/talabat/core/wearable/huawei/data/di/HuaweiWatchCoreLibApiComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "com_talabat_core_wearable_huawei_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        HuaweiWatchCoreLibApiComponent create(@NotNull ContextCoreLibApi contextCoreLibApi);
    }
}
