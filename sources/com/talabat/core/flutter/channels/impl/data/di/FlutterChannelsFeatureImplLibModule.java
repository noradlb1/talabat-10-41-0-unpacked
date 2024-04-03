package com.talabat.core.flutter.channels.impl.data.di;

import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.flutter.channels.domain.tpro.TProChannelCallback;
import com.talabat.core.flutter.channels.impl.data.qcommerce.QCommerceChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.qcommerce.QCommerceDataModule;
import com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.tpro.TProDataModule;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/di/FlutterChannelsFeatureImplLibModule;", "", "qCommerceChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/domain/qcommerce/QCommerceChannelCallback;", "qCommerceChannelCallbackImplImpl", "Lcom/talabat/core/flutter/channels/impl/data/qcommerce/QCommerceChannelCallbackImpl;", "tProChannelCallback", "Lcom/talabat/core/flutter/channels/domain/tpro/TProChannelCallback;", "tProChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/tpro/TProChannelCallbackImpl;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {TProDataModule.class, QCommerceDataModule.class})
public interface FlutterChannelsFeatureImplLibModule {
    @NotNull
    @Binds
    QCommerceChannelCallback qCommerceChannelCallbackImpl(@NotNull QCommerceChannelCallbackImpl qCommerceChannelCallbackImpl);

    @NotNull
    @Binds
    TProChannelCallback tProChannelCallback(@NotNull TProChannelCallbackImpl tProChannelCallbackImpl);
}
