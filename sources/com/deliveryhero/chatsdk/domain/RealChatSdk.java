package com.deliveryhero.chatsdk.domain;

import com.deliveryhero.chatsdk.Channel;
import com.deliveryhero.chatsdk.ChannelListener;
import com.deliveryhero.chatsdk.ChatSdk;
import com.deliveryhero.chatsdk.domain.model.ConnectionState;
import com.deliveryhero.chatsdk.domain.model.messages.UnreadChatDetails;
import com.deliveryhero.chatsdk.factory.ChannelFactory;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import k4.g;
import k4.h;
import k4.i;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0014\u001a\u00020\u00122\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0016\u0012\u0004\u0012\u00020\u00120\u0011H\u0016ø\u0001\u0000J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J%\u0010\u001d\u001a\u00020\u00122\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0016\u0012\u0004\u0012\u00020\u00120\u0011H\u0016ø\u0001\u0000J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020 H\u0017J-\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u001a2\u0018\u0010#\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0016\u0012\u0004\u0012\u00020\u00120\u0011H\u0016ø\u0001\u0000J%\u0010%\u001a\u00020\u00122\u0018\u0010#\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u0016\u0012\u0004\u0012\u00020\u00120\u0011H\u0016ø\u0001\u0000J5\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\u0018\u0010#\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0016\u0012\u0004\u0012\u00020\u00120\u0011H\u0016ø\u0001\u0000J\b\u0010*\u001a\u00020\u0012H\u0016J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020 H\u0017J\u001c\u0010-\u001a\u00020\u00122\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J-\u0010.\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001a2\u0018\u0010#\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0016\u0012\u0004\u0012\u00020\u00120\u0011H\u0016ø\u0001\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/RealChatSdk;", "Lcom/deliveryhero/chatsdk/ChatSdk;", "socketRepository", "Lcom/deliveryhero/chatsdk/domain/SocketRepository;", "httpRepository", "Lcom/deliveryhero/chatsdk/domain/HTTPRepository;", "(Lcom/deliveryhero/chatsdk/domain/SocketRepository;Lcom/deliveryhero/chatsdk/domain/HTTPRepository;)V", "chatSdkDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "connectionDisposable", "connectionState", "Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;", "getConnectionState", "()Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;", "setConnectionState", "(Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;)V", "connectionStateListener", "Lkotlin/Function1;", "", "stateDisposable", "connect", "completionHandler", "Lkotlin/Result;", "connectChannel", "Lcom/deliveryhero/chatsdk/Channel;", "channelId", "", "listener", "Lcom/deliveryhero/chatsdk/ChannelListener;", "disconnect", "dispose", "getAutoBackgroundDetection", "", "getChannelUnreadMessagesCount", "channelID", "resultListener", "Lcom/deliveryhero/chatsdk/domain/model/messages/UnreadChatDetails;", "getTotalUnreadMessagesCount", "", "registerDevicePushToken", "deviceToken", "appId", "removeConnectionStateChangesListener", "setAutoBackgroundDetection", "enable", "setConnectionStateChangesListener", "unregisterDevicePushToken", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealChatSdk implements ChatSdk {
    @NotNull
    private CompositeDisposable chatSdkDisposable = new CompositeDisposable();
    @NotNull
    private CompositeDisposable connectionDisposable = new CompositeDisposable();
    @NotNull
    private ConnectionState connectionState;
    /* access modifiers changed from: private */
    @Nullable
    public Function1<? super ConnectionState, Unit> connectionStateListener;
    @NotNull
    private final HTTPRepository httpRepository;
    @NotNull
    private final SocketRepository socketRepository;
    @NotNull
    private CompositeDisposable stateDisposable;

    public RealChatSdk(@NotNull SocketRepository socketRepository2, @NotNull HTTPRepository hTTPRepository) {
        Intrinsics.checkNotNullParameter(socketRepository2, "socketRepository");
        Intrinsics.checkNotNullParameter(hTTPRepository, "httpRepository");
        this.socketRepository = socketRepository2;
        this.httpRepository = hTTPRepository;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.stateDisposable = compositeDisposable;
        Flowable<ConnectionState> observeOn = socketRepository2.observeConnectionState().doOnNext(new g(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "socketRepository.observe…dSchedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default((Flowable) observeOn, (Function1) AnonymousClass2.INSTANCE, (Function0) null, (Function1) new Function1<ConnectionState, Unit>(this) {
            final /* synthetic */ RealChatSdk this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ConnectionState) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ConnectionState connectionState) {
                Function1 access$getConnectionStateListener$p = this.this$0.connectionStateListener;
                if (access$getConnectionStateListener$p != null) {
                    Intrinsics.checkNotNullExpressionValue(connectionState, "it");
                    access$getConnectionStateListener$p.invoke(connectionState);
                }
            }
        }, 2, (Object) null));
        this.connectionState = ConnectionState.CLOSED;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m8102_init_$lambda0(RealChatSdk realChatSdk, ConnectionState connectionState2) {
        Intrinsics.checkNotNullParameter(realChatSdk, "this$0");
        Intrinsics.checkNotNullExpressionValue(connectionState2, "it");
        realChatSdk.setConnectionState(connectionState2);
    }

    /* access modifiers changed from: private */
    /* renamed from: connect$lambda-1  reason: not valid java name */
    public static final CompletableSource m8103connect$lambda1(RealChatSdk realChatSdk, ConnectionState connectionState2) {
        Intrinsics.checkNotNullParameter(realChatSdk, "this$0");
        Intrinsics.checkNotNullParameter(connectionState2, "it");
        if (connectionState2 == ConnectionState.OPEN) {
            return Completable.complete();
        }
        return realChatSdk.socketRepository.connect();
    }

    /* access modifiers changed from: private */
    /* renamed from: disconnect$lambda-2  reason: not valid java name */
    public static final void m8104disconnect$lambda2(RealChatSdk realChatSdk) {
        Intrinsics.checkNotNullParameter(realChatSdk, "this$0");
        realChatSdk.connectionDisposable.clear();
    }

    public synchronized void connect(@NotNull Function1<? super Result<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "completionHandler");
        this.connectionDisposable.clear();
        CompositeDisposable compositeDisposable = this.connectionDisposable;
        Completable observeOn = this.socketRepository.observeConnectionState().take(1).flatMapCompletable(new i(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "socketRepository.observe…dSchedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(observeOn, (Function1<? super Throwable, Unit>) new RealChatSdk$connect$2(function1), (Function0<Unit>) new RealChatSdk$connect$3(function1)));
    }

    @NotNull
    public Channel connectChannel(@NotNull String str, @NotNull ChannelListener channelListener) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(channelListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return ChannelFactory.INSTANCE.createChannel(str, this.socketRepository, this.httpRepository, channelListener);
    }

    public void disconnect(@NotNull Function1<? super Result<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "completionHandler");
        CompositeDisposable compositeDisposable = this.connectionDisposable;
        Completable doFinally = this.socketRepository.disconnect().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).doFinally(new h(this));
        Intrinsics.checkNotNullExpressionValue(doFinally, "socketRepository.disconn…ctionDisposable.clear() }");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(doFinally, (Function1<? super Throwable, Unit>) new RealChatSdk$disconnect$2(function1), (Function0<Unit>) new RealChatSdk$disconnect$3(function1)));
    }

    public void dispose() {
        this.chatSdkDisposable.clear();
        this.connectionStateListener = null;
        this.stateDisposable.clear();
    }

    @Deprecated(message = "To be replaced with a better implementation")
    public boolean getAutoBackgroundDetection() {
        return this.socketRepository.getAutoBackgroundDetection();
    }

    public void getChannelUnreadMessagesCount(@NotNull String str, @NotNull Function1<? super Result<UnreadChatDetails>, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "channelID");
        Intrinsics.checkNotNullParameter(function1, "resultListener");
        CompositeDisposable compositeDisposable = this.chatSdkDisposable;
        Single<UnreadChatDetails> subscribeOn = this.httpRepository.getChannelUnreadMessagesCount(str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "httpRepository.getChanne…scribeOn(Schedulers.io())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(subscribeOn, (Function1<? super Throwable, Unit>) new RealChatSdk$getChannelUnreadMessagesCount$1(function1), new RealChatSdk$getChannelUnreadMessagesCount$2(function1)));
    }

    @NotNull
    public ConnectionState getConnectionState() {
        return this.connectionState;
    }

    public void getTotalUnreadMessagesCount(@NotNull Function1<? super Result<Integer>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "resultListener");
        CompositeDisposable compositeDisposable = this.chatSdkDisposable;
        Single<Integer> subscribeOn = this.httpRepository.getTotalUnreadMessagesCount().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "httpRepository.getTotalU…scribeOn(Schedulers.io())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(subscribeOn, (Function1<? super Throwable, Unit>) new RealChatSdk$getTotalUnreadMessagesCount$1(function1), new RealChatSdk$getTotalUnreadMessagesCount$2(function1)));
    }

    public void registerDevicePushToken(@NotNull String str, @NotNull String str2, @NotNull Function1<? super Result<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "deviceToken");
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(function1, "resultListener");
        CompositeDisposable compositeDisposable = this.chatSdkDisposable;
        Completable subscribeOn = this.httpRepository.registerDevicePushToken(str, str2).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "httpRepository.registerD…scribeOn(Schedulers.io())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(subscribeOn, (Function1<? super Throwable, Unit>) new RealChatSdk$registerDevicePushToken$1(function1), (Function0<Unit>) new RealChatSdk$registerDevicePushToken$2(function1)));
    }

    public void removeConnectionStateChangesListener() {
        this.connectionStateListener = null;
    }

    @Deprecated(message = "To be replaced with a better implementation")
    public void setAutoBackgroundDetection(boolean z11) {
        this.socketRepository.setAutoBackgroundDetection(z11);
    }

    public void setConnectionState(@NotNull ConnectionState connectionState2) {
        Intrinsics.checkNotNullParameter(connectionState2, "<set-?>");
        this.connectionState = connectionState2;
    }

    public void setConnectionStateChangesListener(@NotNull Function1<? super ConnectionState, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "connectionStateListener");
        this.connectionStateListener = function1;
    }

    public void unregisterDevicePushToken(@NotNull String str, @NotNull Function1<? super Result<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "deviceToken");
        Intrinsics.checkNotNullParameter(function1, "resultListener");
        CompositeDisposable compositeDisposable = this.chatSdkDisposable;
        Completable subscribeOn = this.httpRepository.unregisterDevicePushToken(str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "httpRepository.unregiste…scribeOn(Schedulers.io())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(subscribeOn, (Function1<? super Throwable, Unit>) new RealChatSdk$unregisterDevicePushToken$1(function1), (Function0<Unit>) new RealChatSdk$unregisterDevicePushToken$2(function1)));
    }
}
