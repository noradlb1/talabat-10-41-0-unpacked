package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsFeatureImplLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsFeatureLibApi;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Component(dependencies = {DispatcherCoreLibApi.class, FlutterChannelsFeatureImplLibApi.class}, modules = {FlutterChannelsFeatureLibModule.class})
@Singleton
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/FlutterChannelsFeatureLibComponent;", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsFeatureLibApi;", "Factory", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FlutterChannelsFeatureLibComponent extends FlutterChannelsFeatureLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/FlutterChannelsFeatureLibComponent$Factory;", "", "create", "Lcom/talabat/core/flutter/channels/data/di/FlutterChannelsFeatureLibComponent;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "flutterChannelsFeatureImplLibApi", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsFeatureImplLibApi;", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        FlutterChannelsFeatureLibComponent create(@NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi);
    }
}
