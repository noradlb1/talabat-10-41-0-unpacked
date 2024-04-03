package com.deliveryhero.chatsdk.domain;

import com.deliveryhero.chatsdk.Channel;
import com.deliveryhero.chatsdk.ChannelListener;
import com.deliveryhero.chatsdk.domain.model.Location;
import com.deliveryhero.chatsdk.domain.model.messages.ConfigMessage;
import com.deliveryhero.chatsdk.domain.model.messages.LocationMessage;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import com.deliveryhero.chatsdk.domain.model.messages.TextMessage;
import com.deliveryhero.chatsdk.domain.model.messages.UploadFile;
import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k4.a;
import k4.b;
import k4.c;
import k4.d;
import k4.e;
import k4.f;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016JR\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u001e\u0010\u001b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001e0\u001d\u0012\u0004\u0012\u00020\u00120\u001cH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J-\u0010!\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00032\u0018\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001d\u0012\u0004\u0012\u00020\u00120\u001cH\u0016ø\u0001\u0000J5\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u00032\u0018\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001d\u0012\u0004\u0012\u00020\u00120\u001cH\u0016ø\u0001\u0000J5\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u00032\u0018\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001d\u0012\u0004\u0012\u00020\u00120\u001cH\u0016ø\u0001\u0000JO\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u00032\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00032\u0018\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001d\u0012\u0004\u0012\u00020\u00120\u001cH\u0016ø\u0001\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/ChannelImpl;", "Lcom/deliveryhero/chatsdk/Channel;", "channelId", "", "socketRepository", "Lcom/deliveryhero/chatsdk/domain/SocketRepository;", "httpRepository", "Lcom/deliveryhero/chatsdk/domain/HTTPRepository;", "channelListener", "Lcom/deliveryhero/chatsdk/ChannelListener;", "(Ljava/lang/String;Lcom/deliveryhero/chatsdk/domain/SocketRepository;Lcom/deliveryhero/chatsdk/domain/HTTPRepository;Lcom/deliveryhero/chatsdk/ChannelListener;)V", "channelDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getChannelId", "()Ljava/lang/String;", "lastReceivedMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "dispose", "", "getMessages", "limit", "", "timestamp", "", "inverted", "", "correlationID", "completionHandler", "Lkotlin/Function1;", "Lkotlin/Result;", "", "(ILjava/lang/Long;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "markAllMessagesAsRead", "sendConfigRequestMessage", "sendFileMessage", "file", "Ljava/io/File;", "sendLocationMessage", "location", "Lcom/deliveryhero/chatsdk/domain/model/Location;", "sendMessage", "message", "language", "supportedTranslations", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChannelImpl implements Channel {
    @NotNull
    private final CompositeDisposable channelDisposable;
    @NotNull
    private final String channelId;
    /* access modifiers changed from: private */
    @NotNull
    public final ChannelListener channelListener;
    @NotNull
    private final HTTPRepository httpRepository;
    @Nullable
    private Message lastReceivedMessage;
    @NotNull
    private final SocketRepository socketRepository;

    public ChannelImpl(@NotNull String str, @NotNull SocketRepository socketRepository2, @NotNull HTTPRepository hTTPRepository, @NotNull ChannelListener channelListener2) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(socketRepository2, "socketRepository");
        Intrinsics.checkNotNullParameter(hTTPRepository, "httpRepository");
        Intrinsics.checkNotNullParameter(channelListener2, "channelListener");
        this.channelId = str;
        this.socketRepository = socketRepository2;
        this.httpRepository = hTTPRepository;
        this.channelListener = channelListener2;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.channelDisposable = compositeDisposable;
        Flowable<Message> doOnNext = socketRepository2.observeIncomingMessages().filter(new b(this)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).filter(new c(this)).doOnNext(new d(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "socketRepository\n       …astReceivedMessage = it }");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default((Flowable) doOnNext, (Function1) AnonymousClass4.INSTANCE, (Function0) null, (Function1) new Function1<Message, Unit>(this) {
            final /* synthetic */ ChannelImpl this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Message) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Message message) {
                ChannelListener access$getChannelListener$p = this.this$0.channelListener;
                ChannelImpl channelImpl = this.this$0;
                Intrinsics.checkNotNullExpressionValue(message, "newMessage");
                access$getChannelListener$p.onMessageReceived(channelImpl, message);
            }
        }, 2, (Object) null));
        Flowable<MessageReceipt> subscribeOn = socketRepository2.observeReadReceipts().filter(new e(this)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "socketRepository\n       …scribeOn(Schedulers.io())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default((Flowable) subscribeOn, (Function1) AnonymousClass7.INSTANCE, (Function0) null, (Function1) new Function1<MessageReceipt, Unit>(this) {
            final /* synthetic */ ChannelImpl this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MessageReceipt) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(MessageReceipt messageReceipt) {
                this.this$0.channelListener.onLastReadMessageUpdated(messageReceipt.getTimestamp());
            }
        }, 2, (Object) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final boolean m8096_init_$lambda0(ChannelImpl channelImpl, Message message) {
        Intrinsics.checkNotNullParameter(channelImpl, "this$0");
        Intrinsics.checkNotNullParameter(message, "it");
        return Intrinsics.areEqual((Object) message.getChannelId(), (Object) channelImpl.getChannelId());
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final boolean m8097_init_$lambda1(ChannelImpl channelImpl, Message message) {
        String str;
        Intrinsics.checkNotNullParameter(channelImpl, "this$0");
        Intrinsics.checkNotNullParameter(message, "it");
        String id2 = message.getId();
        Message message2 = channelImpl.lastReceivedMessage;
        if (message2 != null) {
            str = message2.getId();
        } else {
            str = null;
        }
        return !Intrinsics.areEqual((Object) id2, (Object) str);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m8098_init_$lambda2(ChannelImpl channelImpl, Message message) {
        Intrinsics.checkNotNullParameter(channelImpl, "this$0");
        channelImpl.lastReceivedMessage = message;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final boolean m8099_init_$lambda3(ChannelImpl channelImpl, MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(channelImpl, "this$0");
        Intrinsics.checkNotNullParameter(messageReceipt, "it");
        return Intrinsics.areEqual((Object) messageReceipt.getChannelId(), (Object) channelImpl.getChannelId());
    }

    /* access modifiers changed from: private */
    /* renamed from: getMessages$lambda-5  reason: not valid java name */
    public static final void m8100getMessages$lambda5(ChannelImpl channelImpl, List list) {
        Intrinsics.checkNotNullParameter(channelImpl, "this$0");
        Intrinsics.checkNotNullExpressionValue(list, "it");
        channelImpl.lastReceivedMessage = (Message) CollectionsKt___CollectionsKt.last(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendFileMessage$lambda-4  reason: not valid java name */
    public static final SingleSource m8101sendFileMessage$lambda4(ChannelImpl channelImpl, String str, UploadFile uploadFile) {
        Intrinsics.checkNotNullParameter(channelImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$correlationID");
        Intrinsics.checkNotNullParameter(uploadFile, "it");
        return channelImpl.socketRepository.sendFileMessage(channelImpl.getChannelId(), uploadFile.getUrl(), str).timeout(3, TimeUnit.SECONDS).retry(2);
    }

    public void dispose() {
        this.channelDisposable.dispose();
    }

    @NotNull
    public String getChannelId() {
        return this.channelId;
    }

    public void getMessages(int i11, @Nullable Long l11, boolean z11, @NotNull String str, @NotNull Function1<? super Result<? extends List<? extends Message>>, Unit> function1) {
        long j11;
        Intrinsics.checkNotNullParameter(str, "correlationID");
        Intrinsics.checkNotNullParameter(function1, "completionHandler");
        CompositeDisposable compositeDisposable = this.channelDisposable;
        SocketRepository socketRepository2 = this.socketRepository;
        String channelId2 = getChannelId();
        if (l11 != null) {
            j11 = l11.longValue();
        } else {
            j11 = 0;
        }
        Single<List<Message>> doOnSuccess = socketRepository2.getMessages(channelId2, i11, j11, z11, str).timeout(3, TimeUnit.SECONDS).retry(2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new a(this));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "socketRepository.getMess…ivedMessage = it.last() }");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(doOnSuccess, (Function1<? super Throwable, Unit>) new ChannelImpl$getMessages$2(function1), new ChannelImpl$getMessages$3(function1)));
    }

    public void markAllMessagesAsRead(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "correlationID");
        Message message = this.lastReceivedMessage;
        if (message != null) {
            this.socketRepository.markMessageAsRead(getChannelId(), message, str);
        }
    }

    public void sendConfigRequestMessage(@NotNull String str, @NotNull Function1<? super Result<? extends Message>, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "correlationID");
        Intrinsics.checkNotNullParameter(function1, "completionHandler");
        CompositeDisposable compositeDisposable = this.channelDisposable;
        Single<ConfigMessage> observeOn = this.socketRepository.sendConfigRequest(getChannelId(), str).timeout(3, TimeUnit.SECONDS).retry(2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "socketRepository.sendCon…dSchedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(observeOn, (Function1<? super Throwable, Unit>) new ChannelImpl$sendConfigRequestMessage$1(function1), new ChannelImpl$sendConfigRequestMessage$2(function1)));
    }

    public void sendFileMessage(@NotNull File file, @NotNull String str, @NotNull Function1<? super Result<? extends Message>, Unit> function1) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(str, "correlationID");
        Intrinsics.checkNotNullParameter(function1, "completionHandler");
        CompositeDisposable compositeDisposable = this.channelDisposable;
        Single<R> observeOn = this.httpRepository.uploadFile(file).flatMap(new f(this, str)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "httpRepository.uploadFil…dSchedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(observeOn, (Function1<? super Throwable, Unit>) new ChannelImpl$sendFileMessage$2(function1), new ChannelImpl$sendFileMessage$3(function1)));
    }

    public void sendLocationMessage(@NotNull Location location, @NotNull String str, @NotNull Function1<? super Result<? extends Message>, Unit> function1) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(str, "correlationID");
        Intrinsics.checkNotNullParameter(function1, "completionHandler");
        CompositeDisposable compositeDisposable = this.channelDisposable;
        Single<LocationMessage> observeOn = this.socketRepository.sendLocationMessage(getChannelId(), location, str).timeout(3, TimeUnit.SECONDS).retry(2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "socketRepository.sendLoc…dSchedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(observeOn, (Function1<? super Throwable, Unit>) new ChannelImpl$sendLocationMessage$1(function1), new ChannelImpl$sendLocationMessage$2(function1)));
    }

    public void sendMessage(@NotNull String str, @Nullable String str2, @Nullable List<String> list, @NotNull String str3, @NotNull Function1<? super Result<? extends Message>, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str3, "correlationID");
        Intrinsics.checkNotNullParameter(function1, "completionHandler");
        CompositeDisposable compositeDisposable = this.channelDisposable;
        Single<TextMessage> observeOn = this.socketRepository.sendTextMessage(getChannelId(), str, str2, list, str3).timeout(3, TimeUnit.SECONDS).retry(2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "socketRepository.sendTex…dSchedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(observeOn, (Function1<? super Throwable, Unit>) new ChannelImpl$sendMessage$1(function1), new ChannelImpl$sendMessage$2(function1)));
    }
}
