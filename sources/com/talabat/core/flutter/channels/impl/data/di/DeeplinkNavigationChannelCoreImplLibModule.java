package com.talabat.core.flutter.channels.impl.data.di;

import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationChannelCallback;
import com.talabat.core.flutter.channels.impl.data.navigation.DeeplinkNavigationChannelCallbackImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/di/DeeplinkNavigationChannelCoreImplLibModule;", "", "provideDeeplinkChannelCallback", "Lcom/talabat/core/flutter/channels/domain/navigation/DeeplinkNavigationChannelCallback;", "impl", "Lcom/talabat/core/flutter/channels/impl/data/navigation/DeeplinkNavigationChannelCallbackImpl;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DeeplinkNavigationChannelCoreImplLibModule {
    @NotNull
    @Binds
    DeeplinkNavigationChannelCallback provideDeeplinkChannelCallback(@NotNull DeeplinkNavigationChannelCallbackImpl deeplinkNavigationChannelCallbackImpl);
}
