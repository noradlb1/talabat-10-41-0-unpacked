package com.deliveryhero.chatsdk.network.websocket;

import com.deliveryhero.chatsdk.domain.model.ConnectionState;
import com.deliveryhero.chatsdk.domain.model.messages.ConfigMessage;
import com.deliveryhero.chatsdk.domain.model.messages.FileMessage;
import com.deliveryhero.chatsdk.domain.model.messages.LocationMessage;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import com.deliveryhero.chatsdk.domain.model.messages.TextMessage;
import com.deliveryhero.chatsdk.network.websocket.model.MessageReadEvent;
import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.deliveryhero.chatsdk.network.websocket.model.MessagesHistoryRequest;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketConfigRequest;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketFileMessage;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketLocationMessage;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketTextMessage;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H&J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u0017\u001a\u00020\u001bH&J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\u0006\u0010\u0017\u001a\u00020\u001eH&J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00062\u0006\u0010\u0017\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H&¨\u0006$"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/WebSocketService;", "", "connect", "Lio/reactivex/Completable;", "disconnect", "getMessages", "Lio/reactivex/Single;", "", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "request", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryRequest;", "markMessageAsRead", "", "readEvent", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReadEvent;", "observeConnectionState", "Lio/reactivex/Flowable;", "Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;", "observeIncomingMessages", "observeReadReceipt", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReceipt;", "sendConfigRequest", "Lcom/deliveryhero/chatsdk/domain/model/messages/ConfigMessage;", "message", "Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketConfigRequest;", "sendFileMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/FileMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketFileMessage;", "sendLocationMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/LocationMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketLocationMessage;", "sendTextMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/TextMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketTextMessage;", "userId", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WebSocketService {
    @NotNull
    Completable connect();

    @NotNull
    Completable disconnect();

    @NotNull
    Single<List<Message>> getMessages(@NotNull MessagesHistoryRequest messagesHistoryRequest);

    boolean markMessageAsRead(@NotNull MessageReadEvent messageReadEvent);

    @NotNull
    Flowable<ConnectionState> observeConnectionState();

    @NotNull
    Flowable<Message> observeIncomingMessages();

    @NotNull
    Flowable<MessageReceipt> observeReadReceipt();

    @NotNull
    Single<ConfigMessage> sendConfigRequest(@NotNull OutgoingWebSocketConfigRequest outgoingWebSocketConfigRequest);

    @NotNull
    Single<FileMessage> sendFileMessage(@NotNull OutgoingWebSocketFileMessage outgoingWebSocketFileMessage);

    @NotNull
    Single<LocationMessage> sendLocationMessage(@NotNull OutgoingWebSocketLocationMessage outgoingWebSocketLocationMessage);

    @NotNull
    Single<TextMessage> sendTextMessage(@NotNull OutgoingWebSocketTextMessage outgoingWebSocketTextMessage, @NotNull String str);
}
