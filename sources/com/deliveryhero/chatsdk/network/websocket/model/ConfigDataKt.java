package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.domain.model.Config;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toConfig", "Lcom/deliveryhero/chatsdk/domain/model/Config;", "Lcom/deliveryhero/chatsdk/network/websocket/model/ConfigData;", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ConfigDataKt {
    @NotNull
    public static final Config toConfig(@NotNull ConfigData configData) {
        Intrinsics.checkNotNullParameter(configData, "<this>");
        return new Config(configData.getName(), configData.getData());
    }
}
