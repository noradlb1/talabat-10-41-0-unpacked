package com.deliveryhero.chatsdk.network.websocket.okhttp;

import com.deliveryhero.chatsdk.domain.model.ConnectionState;
import com.deliveryhero.chatsdk.domain.model.Location;
import com.deliveryhero.chatsdk.domain.model.MetaData;
import com.deliveryhero.chatsdk.domain.model.User;
import com.deliveryhero.chatsdk.domain.model.messages.ConfigMessage;
import com.deliveryhero.chatsdk.domain.model.messages.FileMessage;
import com.deliveryhero.chatsdk.domain.model.messages.LocationMessage;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import com.deliveryhero.chatsdk.domain.model.messages.TextMessage;
import com.deliveryhero.chatsdk.network.websocket.WebSocketService;
import com.deliveryhero.chatsdk.network.websocket.converter.Converter;
import com.deliveryhero.chatsdk.network.websocket.mapper.MapperUtil;
import com.deliveryhero.chatsdk.network.websocket.model.ConfigData;
import com.deliveryhero.chatsdk.network.websocket.model.ConfigDataKt;
import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage;
import com.deliveryhero.chatsdk.network.websocket.model.LocationContentKt;
import com.deliveryhero.chatsdk.network.websocket.model.MessageReadEvent;
import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.deliveryhero.chatsdk.network.websocket.model.MessagesHistoryRequest;
import com.deliveryhero.chatsdk.network.websocket.model.MessagesHistoryResponse;
import com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent;
import com.deliveryhero.chatsdk.network.websocket.model.MetaDataContentKt;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketConfigRequest;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketFileMessage;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketLocationMessage;
import com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketTextMessage;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.MessageEvent;
import com.deliveryhero.chatsdk.network.websocket.okhttp.model.SocketEvent;
import com.deliveryhero.chatsdk.network.websocket.okhttp.proxy.ProxyConnector;
import com.deliveryhero.chatsdk.network.websocket.okhttp.proxy.ProxyWebSocket;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.processors.BehaviorProcessor;
import io.reactivex.processors.PublishProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n4.a;
import n4.a0;
import n4.b;
import n4.b0;
import n4.c;
import n4.c0;
import n4.d;
import n4.d0;
import n4.e;
import n4.e0;
import n4.f;
import n4.f0;
import n4.g;
import n4.g0;
import n4.h;
import n4.h0;
import n4.i;
import n4.i0;
import n4.j;
import n4.j0;
import n4.k;
import n4.k0;
import n4.l;
import n4.m;
import n4.n;
import n4.o;
import n4.p;
import n4.q;
import n4.r;
import n4.s;
import n4.t;
import n4.u;
import n4.v;
import n4.w;
import n4.x;
import n4.y;
import n4.z;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 =2\u00020\u0001:\u0001=B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020!0)H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020-0)H\u0016J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u001f2\u0006\u00100\u001a\u000201H\u0016J\u0016\u00102\u001a\b\u0012\u0004\u0012\u0002030\u001f2\u0006\u00100\u001a\u000204H\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002060\u001f2\u0006\u00100\u001a\u000207H\u0016J\u001e\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001f2\u0006\u00100\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\r0\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/OkHttpWebSocketService;", "Lcom/deliveryhero/chatsdk/network/websocket/WebSocketService;", "connector", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxyConnector;", "converter", "Lcom/deliveryhero/chatsdk/network/websocket/converter/Converter;", "(Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxyConnector;Lcom/deliveryhero/chatsdk/network/websocket/converter/Converter;)V", "messagePublisher", "Lio/reactivex/processors/PublishProcessor;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent;", "kotlin.jvm.PlatformType", "statePublisher", "Lio/reactivex/processors/BehaviorProcessor;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent;", "webSocket", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxyWebSocket;", "connect", "Lio/reactivex/Completable;", "connectIfNeeded", "", "event", "connectInternal", "convert", "Lio/reactivex/MaybeSource;", "T", "messageEvent", "clazz", "Ljava/lang/Class;", "disconnect", "disconnectIfNeeded", "getMessages", "Lio/reactivex/Single;", "", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "request", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryRequest;", "markMessageAsRead", "", "readEvent", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReadEvent;", "observeConnectionState", "Lio/reactivex/Flowable;", "Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;", "observeIncomingMessages", "observeReadReceipt", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReceipt;", "sendConfigRequest", "Lcom/deliveryhero/chatsdk/domain/model/messages/ConfigMessage;", "message", "Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketConfigRequest;", "sendFileMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/FileMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketFileMessage;", "sendLocationMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/LocationMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketLocationMessage;", "sendTextMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/TextMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketTextMessage;", "userId", "", "Factory", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OkHttpWebSocketService implements WebSocketService {
    @NotNull
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);
    @NotNull
    private final ProxyConnector connector;
    @NotNull
    private final Converter converter;
    /* access modifiers changed from: private */
    @NotNull
    public final PublishProcessor<MessageEvent> messagePublisher;
    /* access modifiers changed from: private */
    @NotNull
    public final BehaviorProcessor<SocketEvent> statePublisher;
    private ProxyWebSocket webSocket;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/OkHttpWebSocketService$Factory;", "", "()V", "getInstance", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/OkHttpWebSocketService;", "connector", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/proxy/ProxyConnector;", "converter", "Lcom/deliveryhero/chatsdk/network/websocket/converter/Converter;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OkHttpWebSocketService getInstance(@NotNull ProxyConnector proxyConnector, @NotNull Converter converter) {
            Intrinsics.checkNotNullParameter(proxyConnector, "connector");
            Intrinsics.checkNotNullParameter(converter, "converter");
            return new OkHttpWebSocketService(proxyConnector, converter);
        }
    }

    public OkHttpWebSocketService(@NotNull ProxyConnector proxyConnector, @NotNull Converter converter2) {
        Intrinsics.checkNotNullParameter(proxyConnector, "connector");
        Intrinsics.checkNotNullParameter(converter2, "converter");
        this.connector = proxyConnector;
        this.converter = converter2;
        PublishProcessor<MessageEvent> create = PublishProcessor.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<MessageEvent>()");
        this.messagePublisher = create;
        BehaviorProcessor<SocketEvent> createDefault = BehaviorProcessor.createDefault(new SocketEvent.Closed(1000, OkHttpWebSocketServiceKt.NORMAL_CLOSURE_MESSAGE));
        Intrinsics.checkNotNullExpressionValue(createDefault, "createDefault<SocketEven…AL_CLOSURE_MESSAGE)\n    )");
        this.statePublisher = createDefault;
    }

    /* access modifiers changed from: private */
    /* renamed from: connect$lambda-2  reason: not valid java name */
    public static final Publisher m8109connect$lambda2(OkHttpWebSocketService okHttpWebSocketService, SocketEvent socketEvent) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(socketEvent, "event");
        return Flowable.fromCallable(new a(socketEvent, okHttpWebSocketService));
    }

    /* access modifiers changed from: private */
    /* renamed from: connect$lambda-2$lambda-1  reason: not valid java name */
    public static final SocketEvent m8110connect$lambda2$lambda1(SocketEvent socketEvent, OkHttpWebSocketService okHttpWebSocketService) {
        Intrinsics.checkNotNullParameter(socketEvent, "$event");
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        okHttpWebSocketService.connectIfNeeded(socketEvent);
        return socketEvent;
    }

    /* access modifiers changed from: private */
    /* renamed from: connect$lambda-4  reason: not valid java name */
    public static final Publisher m8111connect$lambda4(OkHttpWebSocketService okHttpWebSocketService, SocketEvent socketEvent) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(socketEvent, "it");
        return okHttpWebSocketService.statePublisher.doOnNext(new f0());
    }

    /* access modifiers changed from: private */
    /* renamed from: connect$lambda-4$lambda-3  reason: not valid java name */
    public static final void m8112connect$lambda4$lambda3(SocketEvent socketEvent) {
        if (socketEvent instanceof SocketEvent.Failed) {
            throw ((SocketEvent.Failed) socketEvent).getException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: connect$lambda-5  reason: not valid java name */
    public static final boolean m8113connect$lambda5(SocketEvent socketEvent) {
        Intrinsics.checkNotNullParameter(socketEvent, "it");
        return socketEvent instanceof SocketEvent.Open;
    }

    private final void connectIfNeeded(SocketEvent socketEvent) {
        if (!(socketEvent instanceof SocketEvent.Open) && !(socketEvent instanceof SocketEvent.Connecting)) {
            this.webSocket = connectInternal();
        }
    }

    private final ProxyWebSocket connectInternal() {
        this.statePublisher.onNext(SocketEvent.Connecting.INSTANCE);
        return this.connector.connect(new OkHttpWebSocketService$connectInternal$1(this));
    }

    private final <T> MaybeSource<T> convert(MessageEvent messageEvent, Class<T> cls) {
        Object tryConvert = this.converter.tryConvert(messageEvent, cls);
        Maybe just = tryConvert != null ? Maybe.just(tryConvert) : null;
        if (just != null) {
            return just;
        }
        Maybe empty = Maybe.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "empty()");
        return empty;
    }

    /* access modifiers changed from: private */
    /* renamed from: disconnect$lambda-8  reason: not valid java name */
    public static final Publisher m8114disconnect$lambda8(OkHttpWebSocketService okHttpWebSocketService, SocketEvent socketEvent) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(socketEvent, "event");
        return Flowable.fromCallable(new d0(socketEvent, okHttpWebSocketService));
    }

    /* access modifiers changed from: private */
    /* renamed from: disconnect$lambda-8$lambda-7  reason: not valid java name */
    public static final SocketEvent m8115disconnect$lambda8$lambda7(SocketEvent socketEvent, OkHttpWebSocketService okHttpWebSocketService) {
        Intrinsics.checkNotNullParameter(socketEvent, "$event");
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        okHttpWebSocketService.disconnectIfNeeded(socketEvent);
        return socketEvent;
    }

    /* access modifiers changed from: private */
    /* renamed from: disconnect$lambda-9  reason: not valid java name */
    public static final boolean m8116disconnect$lambda9(SocketEvent socketEvent) {
        Intrinsics.checkNotNullParameter(socketEvent, "it");
        if ((socketEvent instanceof SocketEvent.Closed) || (socketEvent instanceof SocketEvent.Failed)) {
            return true;
        }
        return false;
    }

    private final void disconnectIfNeeded(SocketEvent socketEvent) {
        if ((socketEvent instanceof SocketEvent.Open) || (socketEvent instanceof SocketEvent.Connecting)) {
            ProxyWebSocket proxyWebSocket = this.webSocket;
            if (proxyWebSocket == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webSocket");
                proxyWebSocket = null;
            }
            proxyWebSocket.close(1000, OkHttpWebSocketServiceKt.NORMAL_CLOSURE_MESSAGE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getMessages$lambda-34  reason: not valid java name */
    public static final MaybeSource m8117getMessages$lambda34(OkHttpWebSocketService okHttpWebSocketService, MessageEvent messageEvent) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(messageEvent, "it");
        return okHttpWebSocketService.convert(messageEvent, MessagesHistoryResponse.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: getMessages$lambda-35  reason: not valid java name */
    public static final void m8118getMessages$lambda35(OkHttpWebSocketService okHttpWebSocketService, String str, Subscription subscription) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(str, "$serializedRequest");
        ProxyWebSocket proxyWebSocket = okHttpWebSocketService.webSocket;
        if (proxyWebSocket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocket");
            proxyWebSocket = null;
        }
        proxyWebSocket.send(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: getMessages$lambda-36  reason: not valid java name */
    public static final boolean m8119getMessages$lambda36(MessagesHistoryRequest messagesHistoryRequest, MessagesHistoryResponse messagesHistoryResponse) {
        Intrinsics.checkNotNullParameter(messagesHistoryRequest, "$request");
        Intrinsics.checkNotNullParameter(messagesHistoryResponse, "it");
        return Intrinsics.areEqual((Object) messagesHistoryResponse.getCorrelationId(), (Object) messagesHistoryRequest.getCorrelationId());
    }

    /* access modifiers changed from: private */
    /* renamed from: getMessages$lambda-37  reason: not valid java name */
    public static final List m8120getMessages$lambda37(MessagesHistoryResponse messagesHistoryResponse) {
        Intrinsics.checkNotNullParameter(messagesHistoryResponse, "it");
        Iterable<IncomingWebSocketMessage> messages = messagesHistoryResponse.getMessages();
        MapperUtil mapperUtil = MapperUtil.INSTANCE;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(messages, 10));
        for (IncomingWebSocketMessage mapIncomingMessageToMessage : messages) {
            arrayList.add(mapperUtil.mapIncomingMessageToMessage(mapIncomingMessageToMessage));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: getMessages$lambda-39  reason: not valid java name */
    public static final List m8121getMessages$lambda39(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return CollectionsKt___CollectionsKt.sortedWith(list, new OkHttpWebSocketService$getMessages$lambda39$$inlined$sortedBy$1());
    }

    /* access modifiers changed from: private */
    /* renamed from: observeConnectionState$lambda-10  reason: not valid java name */
    public static final ConnectionState m8122observeConnectionState$lambda10(SocketEvent socketEvent) {
        Intrinsics.checkNotNullParameter(socketEvent, "it");
        return MapperUtil.INSTANCE.mapSocketEventToConnectionState(socketEvent);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeIncomingMessages$lambda-11  reason: not valid java name */
    public static final MaybeSource m8123observeIncomingMessages$lambda11(OkHttpWebSocketService okHttpWebSocketService, MessageEvent messageEvent) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(messageEvent, "it");
        return okHttpWebSocketService.convert(messageEvent, IncomingWebSocketMessage.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeIncomingMessages$lambda-12  reason: not valid java name */
    public static final Message m8124observeIncomingMessages$lambda12(IncomingWebSocketMessage incomingWebSocketMessage) {
        Intrinsics.checkNotNullParameter(incomingWebSocketMessage, "it");
        return MapperUtil.INSTANCE.mapIncomingMessageToMessage(incomingWebSocketMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeReadReceipt$lambda-40  reason: not valid java name */
    public static final MaybeSource m8125observeReadReceipt$lambda40(OkHttpWebSocketService okHttpWebSocketService, MessageEvent messageEvent) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(messageEvent, "it");
        return okHttpWebSocketService.convert(messageEvent, MessageReceipt.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendConfigRequest$lambda-28  reason: not valid java name */
    public static final MaybeSource m8126sendConfigRequest$lambda28(OkHttpWebSocketService okHttpWebSocketService, MessageEvent messageEvent) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(messageEvent, "it");
        return okHttpWebSocketService.convert(messageEvent, IncomingWebSocketMessage.IncomingWebSocketConfigMessage.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendConfigRequest$lambda-29  reason: not valid java name */
    public static final boolean m8127sendConfigRequest$lambda29(OutgoingWebSocketConfigRequest outgoingWebSocketConfigRequest, IncomingWebSocketMessage.IncomingWebSocketConfigMessage incomingWebSocketConfigMessage) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketConfigRequest, "$message");
        Intrinsics.checkNotNullParameter(incomingWebSocketConfigMessage, "it");
        return Intrinsics.areEqual((Object) incomingWebSocketConfigMessage.getCorrelationId(), (Object) outgoingWebSocketConfigRequest.getCorrelationId());
    }

    /* access modifiers changed from: private */
    /* renamed from: sendConfigRequest$lambda-30  reason: not valid java name */
    public static final void m8128sendConfigRequest$lambda30(OkHttpWebSocketService okHttpWebSocketService, String str, Subscription subscription) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(str, "$serializedMessage");
        ProxyWebSocket proxyWebSocket = okHttpWebSocketService.webSocket;
        if (proxyWebSocket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocket");
            proxyWebSocket = null;
        }
        proxyWebSocket.send(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendConfigRequest$lambda-31  reason: not valid java name */
    public static final boolean m8129sendConfigRequest$lambda31(OutgoingWebSocketConfigRequest outgoingWebSocketConfigRequest, IncomingWebSocketMessage.IncomingWebSocketConfigMessage incomingWebSocketConfigMessage) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketConfigRequest, "$message");
        Intrinsics.checkNotNullParameter(incomingWebSocketConfigMessage, "it");
        return Intrinsics.areEqual((Object) incomingWebSocketConfigMessage.getCorrelationId(), (Object) outgoingWebSocketConfigRequest.getCorrelationId());
    }

    /* access modifiers changed from: private */
    /* renamed from: sendConfigRequest$lambda-33  reason: not valid java name */
    public static final ConfigMessage m8130sendConfigRequest$lambda33(IncomingWebSocketMessage.IncomingWebSocketConfigMessage incomingWebSocketConfigMessage) {
        MetaData metaData;
        Intrinsics.checkNotNullParameter(incomingWebSocketConfigMessage, "it");
        String messageId = incomingWebSocketConfigMessage.getMessageId();
        String channelId = incomingWebSocketConfigMessage.getChannelId();
        long timestamp = incomingWebSocketConfigMessage.getTimestamp();
        Iterable<ConfigData> configs = incomingWebSocketConfigMessage.getConfigs();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(configs, 10));
        for (ConfigData config : configs) {
            arrayList.add(ConfigDataKt.toConfig(config));
        }
        MetaDataContent metadata = incomingWebSocketConfigMessage.getMetadata();
        if (metadata != null) {
            metaData = MetaDataContentKt.toMetaData(metadata);
        } else {
            metaData = null;
        }
        MetaData metaData2 = metaData;
        String correlationId = incomingWebSocketConfigMessage.getCorrelationId();
        if (correlationId != null) {
            return new ConfigMessage(messageId, channelId, timestamp, metaData2, arrayList, correlationId);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: sendFileMessage$lambda-23  reason: not valid java name */
    public static final MaybeSource m8131sendFileMessage$lambda23(OkHttpWebSocketService okHttpWebSocketService, MessageEvent messageEvent) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(messageEvent, "it");
        return okHttpWebSocketService.convert(messageEvent, MessageReceipt.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendFileMessage$lambda-24  reason: not valid java name */
    public static final boolean m8132sendFileMessage$lambda24(MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(messageReceipt, "it");
        return messageReceipt.isMessageSentReceipt();
    }

    /* access modifiers changed from: private */
    /* renamed from: sendFileMessage$lambda-25  reason: not valid java name */
    public static final void m8133sendFileMessage$lambda25(OkHttpWebSocketService okHttpWebSocketService, String str, Subscription subscription) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(str, "$serializedMessage");
        ProxyWebSocket proxyWebSocket = okHttpWebSocketService.webSocket;
        if (proxyWebSocket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocket");
            proxyWebSocket = null;
        }
        proxyWebSocket.send(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendFileMessage$lambda-26  reason: not valid java name */
    public static final boolean m8134sendFileMessage$lambda26(OutgoingWebSocketFileMessage outgoingWebSocketFileMessage, MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketFileMessage, "$message");
        Intrinsics.checkNotNullParameter(messageReceipt, "it");
        return Intrinsics.areEqual((Object) messageReceipt.getCorrelationId(), (Object) outgoingWebSocketFileMessage.getCorrelationId());
    }

    /* access modifiers changed from: private */
    /* renamed from: sendFileMessage$lambda-27  reason: not valid java name */
    public static final FileMessage m8135sendFileMessage$lambda27(OutgoingWebSocketFileMessage outgoingWebSocketFileMessage, MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketFileMessage, "$message");
        Intrinsics.checkNotNullParameter(messageReceipt, "it");
        String messageId = messageReceipt.getMessageId();
        if (messageId != null) {
            String channelId = messageReceipt.getChannelId();
            long timestamp = messageReceipt.getTimestamp();
            String url = outgoingWebSocketFileMessage.getContent().getUrl();
            String caption = outgoingWebSocketFileMessage.getContent().getCaption();
            User user = new User(outgoingWebSocketFileMessage.getSenderId(), "");
            List emptyList = CollectionsKt__CollectionsKt.emptyList();
            String correlationId = messageReceipt.getCorrelationId();
            if (correlationId != null) {
                return new FileMessage(messageId, channelId, timestamp, (MetaData) null, url, caption, user, emptyList, correlationId, 8, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: sendLocationMessage$lambda-18  reason: not valid java name */
    public static final MaybeSource m8136sendLocationMessage$lambda18(OkHttpWebSocketService okHttpWebSocketService, MessageEvent messageEvent) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(messageEvent, "it");
        return okHttpWebSocketService.convert(messageEvent, MessageReceipt.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendLocationMessage$lambda-19  reason: not valid java name */
    public static final boolean m8137sendLocationMessage$lambda19(MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(messageReceipt, "it");
        return messageReceipt.isMessageSentReceipt();
    }

    /* access modifiers changed from: private */
    /* renamed from: sendLocationMessage$lambda-20  reason: not valid java name */
    public static final void m8138sendLocationMessage$lambda20(OkHttpWebSocketService okHttpWebSocketService, String str, Subscription subscription) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(str, "$serializedMessage");
        ProxyWebSocket proxyWebSocket = okHttpWebSocketService.webSocket;
        if (proxyWebSocket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocket");
            proxyWebSocket = null;
        }
        proxyWebSocket.send(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendLocationMessage$lambda-21  reason: not valid java name */
    public static final boolean m8139sendLocationMessage$lambda21(OutgoingWebSocketLocationMessage outgoingWebSocketLocationMessage, MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketLocationMessage, "$message");
        Intrinsics.checkNotNullParameter(messageReceipt, "it");
        return Intrinsics.areEqual((Object) messageReceipt.getCorrelationId(), (Object) outgoingWebSocketLocationMessage.getCorrelationId());
    }

    /* access modifiers changed from: private */
    /* renamed from: sendLocationMessage$lambda-22  reason: not valid java name */
    public static final LocationMessage m8140sendLocationMessage$lambda22(OutgoingWebSocketLocationMessage outgoingWebSocketLocationMessage, MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketLocationMessage, "$message");
        Intrinsics.checkNotNullParameter(messageReceipt, "it");
        String messageId = messageReceipt.getMessageId();
        if (messageId != null) {
            String channelId = messageReceipt.getChannelId();
            long timestamp = messageReceipt.getTimestamp();
            User user = new User(outgoingWebSocketLocationMessage.getSenderId(), "");
            Location location = LocationContentKt.toLocation(outgoingWebSocketLocationMessage.getContent());
            String correlationId = messageReceipt.getCorrelationId();
            if (correlationId != null) {
                return new LocationMessage(messageId, channelId, timestamp, (MetaData) null, location, user, correlationId, 8, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: sendTextMessage$lambda-13  reason: not valid java name */
    public static final MaybeSource m8141sendTextMessage$lambda13(OkHttpWebSocketService okHttpWebSocketService, MessageEvent messageEvent) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(messageEvent, "it");
        return okHttpWebSocketService.convert(messageEvent, MessageReceipt.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendTextMessage$lambda-14  reason: not valid java name */
    public static final boolean m8142sendTextMessage$lambda14(MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(messageReceipt, "it");
        return messageReceipt.isMessageSentReceipt();
    }

    /* access modifiers changed from: private */
    /* renamed from: sendTextMessage$lambda-15  reason: not valid java name */
    public static final void m8143sendTextMessage$lambda15(OkHttpWebSocketService okHttpWebSocketService, String str, Subscription subscription) {
        Intrinsics.checkNotNullParameter(okHttpWebSocketService, "this$0");
        Intrinsics.checkNotNullParameter(str, "$serializedMessage");
        ProxyWebSocket proxyWebSocket = okHttpWebSocketService.webSocket;
        if (proxyWebSocket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocket");
            proxyWebSocket = null;
        }
        proxyWebSocket.send(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendTextMessage$lambda-16  reason: not valid java name */
    public static final boolean m8144sendTextMessage$lambda16(OutgoingWebSocketTextMessage outgoingWebSocketTextMessage, MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketTextMessage, "$message");
        Intrinsics.checkNotNullParameter(messageReceipt, "it");
        return Intrinsics.areEqual((Object) messageReceipt.getCorrelationId(), (Object) outgoingWebSocketTextMessage.getCorrelationId());
    }

    /* access modifiers changed from: private */
    /* renamed from: sendTextMessage$lambda-17  reason: not valid java name */
    public static final TextMessage m8145sendTextMessage$lambda17(OutgoingWebSocketTextMessage outgoingWebSocketTextMessage, String str, MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketTextMessage, "$message");
        Intrinsics.checkNotNullParameter(str, "$userId");
        Intrinsics.checkNotNullParameter(messageReceipt, "it");
        String messageId = messageReceipt.getMessageId();
        Intrinsics.checkNotNull(messageId);
        String channelId = messageReceipt.getChannelId();
        long timestamp = messageReceipt.getTimestamp();
        String content = outgoingWebSocketTextMessage.getContent();
        User user = new User(str, "");
        String correlationId = messageReceipt.getCorrelationId();
        if (correlationId != null) {
            return new TextMessage(messageId, channelId, timestamp, (MetaData) null, content, user, (Map) null, correlationId, 72, (DefaultConstructorMarker) null);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @NotNull
    public Completable connect() {
        Completable ignoreElement = this.statePublisher.take(1).switchMap(new a0(this)).switchMap(new b0(this)).filter(new c0()).firstOrError().ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "statePublisher\n        .…\n        .ignoreElement()");
        return ignoreElement;
    }

    @NotNull
    public Completable disconnect() {
        Completable ignoreElement = this.statePublisher.switchMap(new w(this)).filter(new e0()).firstOrError().ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "statePublisher\n        .…\n        .ignoreElement()");
        return ignoreElement;
    }

    @NotNull
    public Single<List<Message>> getMessages(@NotNull MessagesHistoryRequest messagesHistoryRequest) {
        Intrinsics.checkNotNullParameter(messagesHistoryRequest, "request");
        Single<R> firstOrError = this.messagePublisher.flatMapMaybe(new g(this)).doOnSubscribe(new h(this, this.converter.serialize(messagesHistoryRequest, MessagesHistoryRequest.class))).filter(new i(messagesHistoryRequest)).map(new j()).map(new k()).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "messagePublisher\n       …          .firstOrError()");
        return firstOrError;
    }

    public boolean markMessageAsRead(@NotNull MessageReadEvent messageReadEvent) {
        Intrinsics.checkNotNullParameter(messageReadEvent, "readEvent");
        String serialize = this.converter.serialize(messageReadEvent, MessageReadEvent.class);
        ProxyWebSocket proxyWebSocket = this.webSocket;
        if (proxyWebSocket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocket");
            proxyWebSocket = null;
        }
        return proxyWebSocket.send(serialize);
    }

    @NotNull
    public Flowable<ConnectionState> observeConnectionState() {
        Flowable<R> map = this.statePublisher.map(new l());
        Intrinsics.checkNotNullExpressionValue(map, "statePublisher.map { map…ntToConnectionState(it) }");
        return map;
    }

    @NotNull
    public Flowable<Message> observeIncomingMessages() {
        Flowable<R> map = this.messagePublisher.flatMapMaybe(new y(this)).map(new z());
        Intrinsics.checkNotNullExpressionValue(map, "messagePublisher\n       …ingMessageToMessage(it) }");
        return map;
    }

    @NotNull
    public Flowable<MessageReceipt> observeReadReceipt() {
        Flowable<R> flatMapMaybe = this.messagePublisher.flatMapMaybe(new r(this));
        Intrinsics.checkNotNullExpressionValue(flatMapMaybe, "messagePublisher\n       …ageReceipt::class.java) }");
        return flatMapMaybe;
    }

    @NotNull
    public Single<ConfigMessage> sendConfigRequest(@NotNull OutgoingWebSocketConfigRequest outgoingWebSocketConfigRequest) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketConfigRequest, "message");
        Single<R> firstOrError = this.messagePublisher.flatMapMaybe(new b(this)).filter(new c(outgoingWebSocketConfigRequest)).doOnSubscribe(new d(this, this.converter.serialize(outgoingWebSocketConfigRequest, OutgoingWebSocketConfigRequest.class))).filter(new e(outgoingWebSocketConfigRequest)).map(new f()).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "messagePublisher\n       …          .firstOrError()");
        return firstOrError;
    }

    @NotNull
    public Single<FileMessage> sendFileMessage(@NotNull OutgoingWebSocketFileMessage outgoingWebSocketFileMessage) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketFileMessage, "message");
        Single<R> firstOrError = this.messagePublisher.flatMapMaybe(new m(this)).filter(new n()).doOnSubscribe(new o(this, this.converter.serialize(outgoingWebSocketFileMessage, OutgoingWebSocketFileMessage.class))).filter(new p(outgoingWebSocketFileMessage)).map(new q(outgoingWebSocketFileMessage)).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "messagePublisher\n       …          .firstOrError()");
        return firstOrError;
    }

    @NotNull
    public Single<LocationMessage> sendLocationMessage(@NotNull OutgoingWebSocketLocationMessage outgoingWebSocketLocationMessage) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketLocationMessage, "message");
        Single<R> firstOrError = this.messagePublisher.flatMapMaybe(new s(this)).filter(new t()).doOnSubscribe(new u(this, this.converter.serialize(outgoingWebSocketLocationMessage, OutgoingWebSocketLocationMessage.class))).filter(new v(outgoingWebSocketLocationMessage)).map(new x(outgoingWebSocketLocationMessage)).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "messagePublisher\n       …          .firstOrError()");
        return firstOrError;
    }

    @NotNull
    public Single<TextMessage> sendTextMessage(@NotNull OutgoingWebSocketTextMessage outgoingWebSocketTextMessage, @NotNull String str) {
        Intrinsics.checkNotNullParameter(outgoingWebSocketTextMessage, "message");
        Intrinsics.checkNotNullParameter(str, "userId");
        Single<R> firstOrError = this.messagePublisher.flatMapMaybe(new g0(this)).filter(new h0()).doOnSubscribe(new i0(this, this.converter.serialize(outgoingWebSocketTextMessage, OutgoingWebSocketTextMessage.class))).filter(new j0(outgoingWebSocketTextMessage)).map(new k0(outgoingWebSocketTextMessage, str)).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "messagePublisher\n       …          .firstOrError()");
        return firstOrError;
    }
}
