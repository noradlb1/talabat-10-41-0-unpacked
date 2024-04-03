package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreImplLibApi;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/DeeplinkNavigationChannelCoreLibComponent;", "Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreLibApi;", "Factory", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {DispatcherCoreLibApi.class, DeeplinkNavigationChannelCoreImplLibApi.class}, modules = {DeeplinkNavigationChannelCoreLibModule.class})
public interface DeeplinkNavigationChannelCoreLibComponent extends DeeplinkNavigationChannelCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/DeeplinkNavigationChannelCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/flutter/channels/data/di/DeeplinkNavigationChannelCoreLibComponent;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "deeplinkNavigationChannelCoreImplLibApi", "Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreImplLibApi;", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        DeeplinkNavigationChannelCoreLibComponent create(@NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull DeeplinkNavigationChannelCoreImplLibApi deeplinkNavigationChannelCoreImplLibApi);
    }
}
