package com.talabat.core.flutter.channels.domain.di;

import com.talabat.core.di.Api;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R-\u0010\u0002\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsCoreLibApi;", "Lcom/talabat/core/di/Api;", "channels", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "Lkotlin/jvm/JvmSuppressWildcards;", "getChannels", "()Ljava/util/Map;", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FlutterChannelsCoreLibApi extends Api {
    @NotNull
    Map<Class<?>, Provider<PlatformChannel>> getChannels();
}
