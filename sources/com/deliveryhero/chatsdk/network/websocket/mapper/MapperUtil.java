package com.deliveryhero.chatsdk.network.websocket.mapper;

import com.deliveryhero.chatsdk.domain.model.ConnectionState;
import com.deliveryhero.chatsdk.network.websocket.model.EventType;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.SocketEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/mapper/MapperUtil;", "", "()V", "mapIncomingMessageToMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "message", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage;", "mapSocketEventToConnectionState", "Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;", "event", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MapperUtil {
    @NotNull
    public static final MapperUtil INSTANCE = new MapperUtil();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            iArr[EventType.joined.ordinal()] = 1;
            iArr[EventType.left.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MapperUtil() {
    }

    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r1v14, types: [com.deliveryhero.chatsdk.domain.model.messages.ChannelFrozenMessage] */
    /* JADX WARNING: type inference failed for: r2v19, types: [com.deliveryhero.chatsdk.domain.model.messages.ConfigUpdateMessage] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.deliveryhero.chatsdk.domain.model.messages.Message mapIncomingMessageToMessage(@org.jetbrains.annotations.NotNull com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage r15) {
        /*
            r14 = this;
            java.lang.String r0 = "message"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            boolean r0 = r15 instanceof com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage
            r1 = 0
            if (r0 == 0) goto L_0x00d9
            r0 = r15
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage r0 = (com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage) r0
            boolean r2 = r0 instanceof com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage.IncomingWebSocketTextMessage
            if (r2 == 0) goto L_0x004b
            com.deliveryhero.chatsdk.domain.model.User r10 = new com.deliveryhero.chatsdk.domain.model.User
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketTextMessage r15 = (com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage.IncomingWebSocketTextMessage) r15
            java.lang.String r0 = r15.getSenderId()
            java.lang.String r2 = r15.getSenderNickname()
            r10.<init>(r0, r2)
            java.lang.String r4 = r15.getMessageId()
            java.lang.String r5 = r15.getChannelId()
            long r6 = r15.getTimestamp()
            java.lang.String r9 = r15.getContent()
            java.util.Map r11 = r15.getTranslations()
            com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent r0 = r15.getMetadata()
            if (r0 == 0) goto L_0x003e
            com.deliveryhero.chatsdk.domain.model.MetaData r1 = com.deliveryhero.chatsdk.network.websocket.model.MetaDataContentKt.toMetaData(r0)
        L_0x003e:
            r8 = r1
            java.lang.String r12 = r15.getCorrelationId()
            com.deliveryhero.chatsdk.domain.model.messages.TextMessage r15 = new com.deliveryhero.chatsdk.domain.model.messages.TextMessage
            r3 = r15
            r3.<init>(r4, r5, r6, r8, r9, r10, r11, r12)
            goto L_0x01b8
        L_0x004b:
            boolean r2 = r0 instanceof com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage.IncomingWebSocketFileMessage
            if (r2 == 0) goto L_0x0095
            com.deliveryhero.chatsdk.domain.model.User r11 = new com.deliveryhero.chatsdk.domain.model.User
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketFileMessage r15 = (com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage.IncomingWebSocketFileMessage) r15
            java.lang.String r0 = r15.getSenderId()
            java.lang.String r2 = r15.getSenderNickname()
            r11.<init>(r0, r2)
            java.lang.String r4 = r15.getMessageId()
            java.lang.String r5 = r15.getChannelId()
            long r6 = r15.getTimestamp()
            com.deliveryhero.chatsdk.network.websocket.model.FileContent r0 = r15.getImage()
            java.lang.String r9 = r0.getUrl()
            com.deliveryhero.chatsdk.network.websocket.model.FileContent r0 = r15.getImage()
            java.lang.String r10 = r0.getCaption()
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent r0 = r15.getMetadata()
            if (r0 == 0) goto L_0x0088
            com.deliveryhero.chatsdk.domain.model.MetaData r1 = com.deliveryhero.chatsdk.network.websocket.model.MetaDataContentKt.toMetaData(r0)
        L_0x0088:
            r8 = r1
            java.lang.String r13 = r15.getCorrelationId()
            com.deliveryhero.chatsdk.domain.model.messages.FileMessage r15 = new com.deliveryhero.chatsdk.domain.model.messages.FileMessage
            r3 = r15
            r3.<init>(r4, r5, r6, r8, r9, r10, r11, r12, r13)
            goto L_0x01b8
        L_0x0095:
            boolean r0 = r0 instanceof com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage.IncomingWebSocketLocationMessage
            if (r0 == 0) goto L_0x00d3
            com.deliveryhero.chatsdk.domain.model.User r9 = new com.deliveryhero.chatsdk.domain.model.User
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketLocationMessage r15 = (com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage.IncomingWebSocketLocationMessage) r15
            java.lang.String r0 = r15.getSenderId()
            java.lang.String r2 = r15.getSenderNickname()
            r9.<init>(r0, r2)
            java.lang.String r3 = r15.getMessageId()
            java.lang.String r4 = r15.getChannelId()
            long r5 = r15.getTimestamp()
            com.deliveryhero.chatsdk.network.websocket.model.LocationContent r0 = r15.getLocation()
            com.deliveryhero.chatsdk.domain.model.Location r8 = com.deliveryhero.chatsdk.network.websocket.model.LocationContentKt.toLocation(r0)
            com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent r0 = r15.getMetadata()
            if (r0 == 0) goto L_0x00c6
            com.deliveryhero.chatsdk.domain.model.MetaData r1 = com.deliveryhero.chatsdk.network.websocket.model.MetaDataContentKt.toMetaData(r0)
        L_0x00c6:
            r7 = r1
            java.lang.String r10 = r15.getCorrelationId()
            com.deliveryhero.chatsdk.domain.model.messages.LocationMessage r15 = new com.deliveryhero.chatsdk.domain.model.messages.LocationMessage
            r2 = r15
            r2.<init>(r3, r4, r5, r7, r8, r9, r10)
            goto L_0x01b8
        L_0x00d3:
            kotlin.NoWhenBranchMatchedException r15 = new kotlin.NoWhenBranchMatchedException
            r15.<init>()
            throw r15
        L_0x00d9:
            boolean r0 = r15 instanceof com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage.IncomingWebSocketAdminMessage
            if (r0 == 0) goto L_0x0126
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage$IncomingWebSocketAdminMessage r15 = (com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage.IncomingWebSocketAdminMessage) r15
            com.deliveryhero.chatsdk.network.websocket.model.EventType r0 = r15.getEventType()
            int[] r2 = com.deliveryhero.chatsdk.network.websocket.mapper.MapperUtil.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r2[r0]
            r2 = 1
            if (r0 == r2) goto L_0x00fc
            r2 = 2
            if (r0 != r2) goto L_0x00f4
            com.deliveryhero.chatsdk.domain.model.messages.AdminMessage$Type r0 = com.deliveryhero.chatsdk.domain.model.messages.AdminMessage.Type.LEFT
            goto L_0x00fe
        L_0x00f4:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "event type should be either 'joined' or 'left'"
            r15.<init>(r0)
            throw r15
        L_0x00fc:
            com.deliveryhero.chatsdk.domain.model.messages.AdminMessage$Type r0 = com.deliveryhero.chatsdk.domain.model.messages.AdminMessage.Type.JOINED
        L_0x00fe:
            r9 = r0
            java.lang.String r3 = r15.getMessageId()
            java.lang.String r4 = r15.getChannelId()
            long r5 = r15.getTimestamp()
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage$IncomingWebSocketAdminMessage$Content r0 = r15.getContent()
            java.lang.String r8 = r0.getNickName()
            com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent r15 = r15.getMetadata()
            if (r15 == 0) goto L_0x011d
            com.deliveryhero.chatsdk.domain.model.MetaData r1 = com.deliveryhero.chatsdk.network.websocket.model.MetaDataContentKt.toMetaData(r15)
        L_0x011d:
            r7 = r1
            com.deliveryhero.chatsdk.domain.model.messages.AdminMessage r15 = new com.deliveryhero.chatsdk.domain.model.messages.AdminMessage
            r2 = r15
            r2.<init>(r3, r4, r5, r7, r8, r9)
            goto L_0x01b8
        L_0x0126:
            boolean r0 = r15 instanceof com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage.IncomingWebSocketConfigMessage
            if (r0 == 0) goto L_0x0177
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage$IncomingWebSocketConfigMessage r15 = (com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage.IncomingWebSocketConfigMessage) r15
            java.lang.String r3 = r15.getMessageId()
            java.lang.String r4 = r15.getChannelId()
            long r5 = r15.getTimestamp()
            java.util.List r0 = r15.getConfigs()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r8 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r2)
            r8.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L_0x014d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0161
            java.lang.Object r2 = r0.next()
            com.deliveryhero.chatsdk.network.websocket.model.ConfigData r2 = (com.deliveryhero.chatsdk.network.websocket.model.ConfigData) r2
            com.deliveryhero.chatsdk.domain.model.Config r2 = com.deliveryhero.chatsdk.network.websocket.model.ConfigDataKt.toConfig(r2)
            r8.add(r2)
            goto L_0x014d
        L_0x0161:
            com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent r0 = r15.getMetadata()
            if (r0 == 0) goto L_0x016b
            com.deliveryhero.chatsdk.domain.model.MetaData r1 = com.deliveryhero.chatsdk.network.websocket.model.MetaDataContentKt.toMetaData(r0)
        L_0x016b:
            r7 = r1
            java.lang.String r9 = r15.getCorrelationId()
            com.deliveryhero.chatsdk.domain.model.messages.ConfigMessage r15 = new com.deliveryhero.chatsdk.domain.model.messages.ConfigMessage
            r2 = r15
            r2.<init>(r3, r4, r5, r7, r8, r9)
            goto L_0x01b8
        L_0x0177:
            boolean r0 = r15 instanceof com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage.IncomingWebSocketConfigUpdateMessage
            if (r0 == 0) goto L_0x019b
            com.deliveryhero.chatsdk.domain.model.messages.ConfigUpdateMessage r0 = new com.deliveryhero.chatsdk.domain.model.messages.ConfigUpdateMessage
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage$IncomingWebSocketConfigUpdateMessage r15 = (com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage.IncomingWebSocketConfigUpdateMessage) r15
            java.lang.String r3 = r15.getMessageId()
            java.lang.String r4 = r15.getChannelId()
            long r5 = r15.getTimestamp()
            com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent r15 = r15.getMetadata()
            if (r15 == 0) goto L_0x0195
            com.deliveryhero.chatsdk.domain.model.MetaData r1 = com.deliveryhero.chatsdk.network.websocket.model.MetaDataContentKt.toMetaData(r15)
        L_0x0195:
            r7 = r1
            r2 = r0
            r2.<init>(r3, r4, r5, r7)
            goto L_0x01b7
        L_0x019b:
            boolean r0 = r15 instanceof com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage.IncomingWebSocketChannelFrozenMessage
            if (r0 == 0) goto L_0x01b9
            com.deliveryhero.chatsdk.domain.model.messages.ChannelFrozenMessage r0 = new com.deliveryhero.chatsdk.domain.model.messages.ChannelFrozenMessage
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage$IncomingWebSocketChannelFrozenMessage r15 = (com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage.IncomingWebSocketChannelFrozenMessage) r15
            java.lang.String r2 = r15.getMessageId()
            java.lang.String r3 = r15.getChannelId()
            long r4 = r15.getTimestamp()
            r6 = 0
            r7 = 8
            r8 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r7, r8)
        L_0x01b7:
            r15 = r0
        L_0x01b8:
            return r15
        L_0x01b9:
            kotlin.NoWhenBranchMatchedException r15 = new kotlin.NoWhenBranchMatchedException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatsdk.network.websocket.mapper.MapperUtil.mapIncomingMessageToMessage(com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage):com.deliveryhero.chatsdk.domain.model.messages.Message");
    }

    @NotNull
    public final ConnectionState mapSocketEventToConnectionState(@NotNull SocketEvent socketEvent) {
        boolean z11;
        Intrinsics.checkNotNullParameter(socketEvent, "event");
        if (socketEvent instanceof SocketEvent.Open) {
            return ConnectionState.OPEN;
        }
        if (socketEvent instanceof SocketEvent.Connecting) {
            return ConnectionState.CONNECTING;
        }
        boolean z12 = true;
        if (socketEvent instanceof SocketEvent.Closing) {
            z11 = true;
        } else {
            z11 = socketEvent instanceof SocketEvent.Closed;
        }
        if (!z11) {
            z12 = socketEvent instanceof SocketEvent.Failed;
        }
        if (z12) {
            return ConnectionState.CLOSED;
        }
        throw new NoWhenBranchMatchedException();
    }
}
