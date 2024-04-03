package com.deliveryhero.chatsdk.network;

import com.deliveryhero.chatsdk.domain.SocketRepository;
import com.deliveryhero.chatsdk.domain.model.ConnectionState;
import com.deliveryhero.chatsdk.domain.model.Location;
import com.deliveryhero.chatsdk.domain.model.LocationKt;
import com.deliveryhero.chatsdk.domain.model.UserInfo;
import com.deliveryhero.chatsdk.domain.model.messages.ConfigMessage;
import com.deliveryhero.chatsdk.domain.model.messages.FileMessage;
import com.deliveryhero.chatsdk.domain.model.messages.LocationMessage;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import com.deliveryhero.chatsdk.domain.model.messages.TextMessage;
import com.deliveryhero.chatsdk.network.websocket.WebSocketService;
import com.deliveryhero.chatsdk.network.websocket.model.ContentType;
import com.deliveryhero.chatsdk.network.websocket.model.EventType;
import com.deliveryhero.chatsdk.network.websocket.model.FileContent;
import com.deliveryhero.chatsdk.network.websocket.model.MessageReadEvent;
import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.deliveryhero.chatsdk.network.websocket.model.MessagesHistoryRequest;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketConfigRequest;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketFileMessage;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketLocationMessage;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketTextMessage;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J<\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130 H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020$0 H\u0016J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J&\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J&\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J@\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u00152\b\u00101\u001a\u0004\u0018\u00010\u00152\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u0015H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/deliveryhero/chatsdk/network/SocketRepositoryImpl;", "Lcom/deliveryhero/chatsdk/domain/SocketRepository;", "webSocketService", "Lcom/deliveryhero/chatsdk/network/websocket/WebSocketService;", "userInfo", "Lcom/deliveryhero/chatsdk/domain/model/UserInfo;", "(Lcom/deliveryhero/chatsdk/network/websocket/WebSocketService;Lcom/deliveryhero/chatsdk/domain/model/UserInfo;)V", "autoBackgroundDetection", "", "getAutoBackgroundDetection", "()Z", "setAutoBackgroundDetection", "(Z)V", "connect", "Lio/reactivex/Completable;", "disconnect", "getMessages", "Lio/reactivex/Single;", "", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "channelId", "", "limit", "", "timestamp", "", "inverted", "correlationID", "markMessageAsRead", "", "message", "observeConnectionState", "Lio/reactivex/Flowable;", "Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;", "observeIncomingMessages", "observeReadReceipts", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReceipt;", "sendConfigRequest", "Lcom/deliveryhero/chatsdk/domain/model/messages/ConfigMessage;", "sendFileMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/FileMessage;", "fileUrl", "sendLocationMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/LocationMessage;", "location", "Lcom/deliveryhero/chatsdk/domain/model/Location;", "sendTextMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/TextMessage;", "text", "language", "supportedLanguages", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SocketRepositoryImpl implements SocketRepository {
    private boolean autoBackgroundDetection = true;
    @NotNull
    private final UserInfo userInfo;
    @NotNull
    private final WebSocketService webSocketService;

    public SocketRepositoryImpl(@NotNull WebSocketService webSocketService2, @NotNull UserInfo userInfo2) {
        Intrinsics.checkNotNullParameter(webSocketService2, "webSocketService");
        Intrinsics.checkNotNullParameter(userInfo2, "userInfo");
        this.webSocketService = webSocketService2;
        this.userInfo = userInfo2;
    }

    /* access modifiers changed from: private */
    /* renamed from: observeReadReceipts$lambda-0  reason: not valid java name */
    public static final boolean m8107observeReadReceipts$lambda0(MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(messageReceipt, "it");
        return messageReceipt.isMessageReadReceipt();
    }

    @NotNull
    public Completable connect() {
        return this.webSocketService.connect();
    }

    @NotNull
    public Completable disconnect() {
        return this.webSocketService.disconnect();
    }

    public boolean getAutoBackgroundDetection() {
        return this.autoBackgroundDetection;
    }

    @NotNull
    public Single<List<Message>> getMessages(@NotNull String str, int i11, long j11, boolean z11, @NotNull String str2) {
        MessagesHistoryRequest.Mode mode;
        String str3 = str;
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str2, "correlationID");
        if (z11) {
            mode = MessagesHistoryRequest.Mode.BEFORE_TIMESTAMP;
        } else {
            mode = MessagesHistoryRequest.Mode.AFTER_TIMESTAMP;
        }
        return this.webSocketService.getMessages(new MessagesHistoryRequest(str, i11, j11, mode, (String) null, str2, 16, (DefaultConstructorMarker) null));
    }

    public void markMessageAsRead(@NotNull String str, @NotNull Message message, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(str2, "correlationID");
        this.webSocketService.markMessageAsRead(new MessageReadEvent(str, message.getTimestamp(), (String) null, str2, 4, (DefaultConstructorMarker) null));
    }

    @NotNull
    public Flowable<ConnectionState> observeConnectionState() {
        return this.webSocketService.observeConnectionState();
    }

    @NotNull
    public Flowable<Message> observeIncomingMessages() {
        return this.webSocketService.observeIncomingMessages();
    }

    @NotNull
    public Flowable<MessageReceipt> observeReadReceipts() {
        Flowable<MessageReceipt> filter = this.webSocketService.observeReadReceipt().filter(new d());
        Intrinsics.checkNotNullExpressionValue(filter, "webSocketService.observe….isMessageReadReceipt() }");
        return filter;
    }

    @NotNull
    public Single<ConfigMessage> sendConfigRequest(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str2, "correlationID");
        return this.webSocketService.sendConfigRequest(new OutgoingWebSocketConfigRequest(str, this.userInfo.getUserId(), EventType.config, str2));
    }

    @NotNull
    public Single<FileMessage> sendFileMessage(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str2, "fileUrl");
        Intrinsics.checkNotNullParameter(str3, "correlationID");
        return this.webSocketService.sendFileMessage(new OutgoingWebSocketFileMessage(new FileContent(str2, ""), this.userInfo.getUserId(), ContentType.TEXT, EventType.image, str, str3));
    }

    @NotNull
    public Single<LocationMessage> sendLocationMessage(@NotNull String str, @NotNull Location location, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(str2, "correlationID");
        return this.webSocketService.sendLocationMessage(new OutgoingWebSocketLocationMessage(str, LocationKt.toLocationContent(location), ContentType.TEXT, str2, EventType.location, this.userInfo.getUserId()));
    }

    @NotNull
    public Single<TextMessage> sendTextMessage(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<String> list, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(str4, "correlationID");
        return this.webSocketService.sendTextMessage(new OutgoingWebSocketTextMessage(str2, EventType.message, ContentType.TEXT, str, str3, list, str4), this.userInfo.getUserId());
    }

    public void setAutoBackgroundDetection(boolean z11) {
        this.autoBackgroundDetection = z11;
    }
}
