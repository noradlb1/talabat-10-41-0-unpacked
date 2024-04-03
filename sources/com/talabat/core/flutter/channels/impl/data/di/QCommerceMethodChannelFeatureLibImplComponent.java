package com.talabat.core.flutter.channels.impl.data.di;

import com.talabat.core.flutter.channels.domain.di.QCommerceMethodChannelFeatureLibImplApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/di/QCommerceMethodChannelFeatureLibImplComponent;", "Lcom/talabat/core/flutter/channels/domain/di/QCommerceMethodChannelFeatureLibImplApi;", "Factory", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {NavigationCoreLibApi.class, ParserCoreLibApi.class}, modules = {QCommerceMethodChannelFeatureImplLibModule.class})
public interface QCommerceMethodChannelFeatureLibImplComponent extends QCommerceMethodChannelFeatureLibImplApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/di/QCommerceMethodChannelFeatureLibImplComponent$Factory;", "", "create", "Lcom/talabat/core/flutter/channels/impl/data/di/QCommerceMethodChannelFeatureLibImplComponent;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        QCommerceMethodChannelFeatureLibImplComponent create(@NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull ParserCoreLibApi parserCoreLibApi);
    }
}
