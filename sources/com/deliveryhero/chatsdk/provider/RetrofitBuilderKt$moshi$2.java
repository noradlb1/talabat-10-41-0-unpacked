package com.deliveryhero.chatsdk.provider;

import com.deliveryhero.chatsdk.network.websocket.converter.adapters.DefaultWebSocketMessageAdapterFactory;
import com.deliveryhero.chatsdk.network.websocket.converter.adapters.IgnoreUnknownListAdapterFactory;
import com.deliveryhero.chatsdk.network.websocket.converter.adapters.PolymorphicJsonAdapterFactory;
import com.deliveryhero.chatsdk.network.websocket.model.EventType;
import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage;
import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage;
import com.deliveryhero.chatsdk.network.websocket.model.MessageType;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.EnumJsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RetrofitBuilderKt$moshi$2 extends Lambda implements Function0<Moshi> {
    public static final RetrofitBuilderKt$moshi$2 INSTANCE = new RetrofitBuilderKt$moshi$2();

    public RetrofitBuilderKt$moshi$2() {
        super(0);
    }

    public final Moshi invoke() {
        Class<MessageType> cls = MessageType.class;
        Moshi.Builder add = new Moshi.Builder().add(cls, EnumJsonAdapter.create(cls).withUnknownFallback(MessageType.unknown));
        PolymorphicJsonAdapterFactory.Companion companion = PolymorphicJsonAdapterFactory.Companion;
        Class cls2 = IncomingWebSocketMessage.IncomingWebSocketAdminMessage.class;
        Class cls3 = IncomingWebSocketSubMessage.class;
        return add.add((JsonAdapter.Factory) companion.of(IncomingWebSocketMessage.class, "event_type").withSubtype$customerchat_basicRelease(cls2, EventType.joined.name()).withSubtype$customerchat_basicRelease(cls2, EventType.left.name()).withSubtype$customerchat_basicRelease(cls3, EventType.message.name()).withSubtype$customerchat_basicRelease(IncomingWebSocketMessage.IncomingWebSocketConfigMessage.class, EventType.config.name()).withSubtype$customerchat_basicRelease(IncomingWebSocketMessage.IncomingWebSocketConfigUpdateMessage.class, EventType.configUpdate.name()).withSubtype$customerchat_basicRelease(IncomingWebSocketMessage.IncomingWebSocketChannelFrozenMessage.class, EventType.frozen.name())).add((JsonAdapter.Factory) companion.of(cls3, "message_type").withSubtype$customerchat_basicRelease(IncomingWebSocketSubMessage.IncomingWebSocketTextMessage.class, MessageType.message.name()).withSubtype$customerchat_basicRelease(IncomingWebSocketSubMessage.IncomingWebSocketFileMessage.class, MessageType.image.name()).withSubtype$customerchat_basicRelease(IncomingWebSocketSubMessage.IncomingWebSocketLocationMessage.class, MessageType.location.name()).withFallbackJsonAdapterFactory$customerchat_basicRelease(new DefaultWebSocketMessageAdapterFactory())).add((JsonAdapter.Factory) new IgnoreUnknownListAdapterFactory()).build();
    }
}
