package com.talabat.core.flutter.channels.impl.data.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreImplLibApi;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Component(dependencies = {DeepLinkCoreLibApi.class}, modules = {DeeplinkNavigationChannelCoreImplLibModule.class})
@Singleton
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/di/DeeplinkNavigationChannelCoreImplLibComponent;", "Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreImplLibApi;", "Factory", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DeeplinkNavigationChannelCoreImplLibComponent extends DeeplinkNavigationChannelCoreImplLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/di/DeeplinkNavigationChannelCoreImplLibComponent$Factory;", "", "create", "Lcom/talabat/core/flutter/channels/impl/data/di/DeeplinkNavigationChannelCoreImplLibComponent;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        DeeplinkNavigationChannelCoreImplLibComponent create(@NotNull DeepLinkCoreLibApi deepLinkCoreLibApi);
    }
}
