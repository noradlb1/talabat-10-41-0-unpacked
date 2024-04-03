package com.deliveryhero.chatsdk.network.websocket.converter;

import com.deliveryhero.chatsdk.network.websocket.okhttp.model.MessageEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H&¢\u0006\u0002\u0010\bJ+\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0005\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\n0\u0007H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/converter/Converter;", "", "serialize", "", "In", "data", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/String;", "tryConvert", "Out", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent;", "(Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent;Ljava/lang/Class;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Converter {
    @NotNull
    <In> String serialize(In in2, @NotNull Class<In> cls);

    @Nullable
    <Out> Out tryConvert(@NotNull MessageEvent messageEvent, @NotNull Class<Out> cls);
}
