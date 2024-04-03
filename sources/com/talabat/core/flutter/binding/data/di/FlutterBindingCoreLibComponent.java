package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.flutter.binding.domain.di.FlutterBindingCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Component(dependencies = {ContextCoreLibApi.class, DeeplinkNavigationChannelCoreLibApi.class, FlutterChannelsCoreLibApi.class, FlutterEngineCoreLibApi.class}, modules = {FlutterBindingCoreLibModule.class})
@Singleton
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/flutter/binding/data/di/FlutterBindingCoreLibComponent;", "Lcom/talabat/core/flutter/binding/domain/di/FlutterBindingCoreLibApi;", "Factory", "com_talabat_core_flutter-binding_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FlutterBindingCoreLibComponent extends FlutterBindingCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/binding/data/di/FlutterBindingCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/flutter/binding/data/di/FlutterBindingCoreLibComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "deeplinkNavigationChannelCoreLibApi", "Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreLibApi;", "flutterChannelsCoreLibApi", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsCoreLibApi;", "flutterEngineCoreLibApi", "Lcom/talabat/core/flutter/engine/domain/di/FlutterEngineCoreLibApi;", "com_talabat_core_flutter-binding_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        FlutterBindingCoreLibComponent create(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi, @NotNull FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, @NotNull FlutterEngineCoreLibApi flutterEngineCoreLibApi);
    }
}
