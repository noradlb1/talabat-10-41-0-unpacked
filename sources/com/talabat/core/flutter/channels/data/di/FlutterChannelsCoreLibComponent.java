package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreImplLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.flutter.secrets.domain.FlutterSecretsCoreLibApi;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Component(dependencies = {DispatcherCoreLibApi.class, FlutterChannelsCoreImplLibApi.class, FlutterSecretsCoreLibApi.class, ObservabilityCoreLibApi.class}, modules = {FlutterChannelsCoreLibModule.class})
@Singleton
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/FlutterChannelsCoreLibComponent;", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsCoreLibApi;", "Factory", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FlutterChannelsCoreLibComponent extends FlutterChannelsCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/FlutterChannelsCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/flutter/channels/data/di/FlutterChannelsCoreLibComponent;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "flutterChannelsCoreImplLibApi", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsCoreImplLibApi;", "flutterSecretsCoreLibApi", "Lcom/talabat/flutter/secrets/domain/FlutterSecretsCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        FlutterChannelsCoreLibComponent create(@NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi, @NotNull FlutterSecretsCoreLibApi flutterSecretsCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi);
    }
}
