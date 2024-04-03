package com.deliveryhero.customerchat.service;

import com.deliveryhero.contract.ChatRepository;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.FileMessageData;
import com.deliveryhero.contract.model.GroupChannel;
import com.deliveryhero.contract.model.LocationData;
import com.deliveryhero.contract.model.Receipt;
import com.deliveryhero.contract.model.TextMessageData;
import com.deliveryhero.contract.model.UserInfo;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J2\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\rH\u0016J2\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\rH\u0016J\u0016\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J>\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00112\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u00060\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\rH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J$\u0010#\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J2\u0010&\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\rH\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J@\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\r2\u001a\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060,H\u0016J@\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020/2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\r2\u001a\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060,H\u0016JP\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u0002022\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00192\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\r2\u001a\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060,H\u0016J\u0010\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0017H\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0011H\u0016J0\u00108\u001a\u00020\u00062\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\r2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00060\rH\u0016J\b\u0010;\u001a\u00020\u0006H\u0016J\b\u0010<\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/deliveryhero/customerchat/service/GccChannelService;", "Lcom/deliveryhero/customerchat/service/ChannelService;", "repository", "Lcom/deliveryhero/contract/ChatRepository;", "(Lcom/deliveryhero/contract/ChatRepository;)V", "clear", "", "connect", "userInfo", "Lcom/deliveryhero/contract/model/UserInfo;", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "", "connectChannel", "id", "", "disconnect", "handler", "fetchConfig", "correlationID", "getAutoBackgroundDetection", "", "getChatList", "", "Lcom/deliveryhero/contract/model/BaseMessage;", "isConnected", "isConnectionClosed", "isLoading", "markAllMessagesAsRead", "messageReceipt", "Lcom/deliveryhero/contract/model/Receipt;", "message", "reconnect", "registerConnectionHandler", "onStarted", "onSucceeded", "registerUser", "removeConnectionHandler", "sendFileMessage", "fileParams", "Lcom/deliveryhero/contract/model/FileMessageData;", "onNewMessage", "Lkotlin/Function2;", "sendLocationMessage", "data", "Lcom/deliveryhero/contract/model/LocationData;", "sendMessage", "messageData", "Lcom/deliveryhero/contract/model/TextMessageData;", "supportedTranslation", "setAutoBackgroundDetection", "enable", "setPreferredLanguage", "language", "subscribeForMessages", "onMessageReceiptUpdate", "Lcom/deliveryhero/contract/model/GroupChannel;", "unsubscribeForMessages", "userId", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccChannelService implements ChannelService {
    @NotNull
    private final ChatRepository repository;

    public GccChannelService(@NotNull ChatRepository chatRepository) {
        Intrinsics.checkNotNullParameter(chatRepository, "repository");
        this.repository = chatRepository;
    }

    public void clear() {
        this.repository.clear();
    }

    public void connect(@NotNull UserInfo userInfo, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        this.repository.connect(userInfo, function0, function1);
    }

    public void connectChannel(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        this.repository.connectChannel(str, function0, function1);
    }

    public void disconnect(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "handler");
        this.repository.disconnect(function0);
    }

    public void fetchConfig(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "correlationID");
        this.repository.fetchConfig(str);
    }

    public boolean getAutoBackgroundDetection() {
        return this.repository.getAutoBackgroundDetection();
    }

    public void getChatList(@NotNull String str, @NotNull Function1<? super List<? extends BaseMessage>, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "correlationID");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        this.repository.getChatList(str, function1, function12);
    }

    public boolean isConnected() {
        return this.repository.isConnected();
    }

    public boolean isConnectionClosed() {
        return this.repository.isConnectionClosed();
    }

    public boolean isLoading() {
        return this.repository.isLoading();
    }

    public void markAllMessagesAsRead(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "correlationID");
        this.repository.markAllMessagesAsRead(str);
    }

    @NotNull
    public Receipt messageReceipt(@NotNull BaseMessage baseMessage) {
        Intrinsics.checkNotNullParameter(baseMessage, "message");
        return this.repository.messageReceipt(baseMessage);
    }

    public boolean reconnect() {
        return this.repository.reconnect();
    }

    public void registerConnectionHandler(@NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "onStarted");
        Intrinsics.checkNotNullParameter(function02, "onSucceeded");
        this.repository.registerConnectionHandler(function0, function02);
    }

    public void registerUser(@NotNull UserInfo userInfo, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        this.repository.registerUser(userInfo, function0, function1);
    }

    public void removeConnectionHandler() {
        this.repository.removeConnectionHandler();
    }

    public void sendFileMessage(@NotNull FileMessageData fileMessageData, @NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function2<? super BaseMessage, ? super Throwable, Unit> function2) {
        Intrinsics.checkNotNullParameter(fileMessageData, "fileParams");
        Intrinsics.checkNotNullParameter(function1, "onNewMessage");
        Intrinsics.checkNotNullParameter(function2, "onError");
        this.repository.sendFileMessage(fileMessageData, function1, function2);
    }

    public void sendLocationMessage(@NotNull LocationData locationData, @NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function2<? super BaseMessage, ? super Throwable, Unit> function2) {
        Intrinsics.checkNotNullParameter(locationData, "data");
        Intrinsics.checkNotNullParameter(function1, "onNewMessage");
        Intrinsics.checkNotNullParameter(function2, "onError");
        this.repository.sendLocationMessage(locationData, function1, function2);
    }

    public void sendMessage(@NotNull TextMessageData textMessageData, @Nullable List<String> list, @NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function2<? super BaseMessage, ? super Throwable, Unit> function2) {
        Intrinsics.checkNotNullParameter(textMessageData, "messageData");
        Intrinsics.checkNotNullParameter(function1, "onNewMessage");
        Intrinsics.checkNotNullParameter(function2, "onError");
        this.repository.sendMessage(textMessageData, list, function1, function2);
    }

    public void setAutoBackgroundDetection(boolean z11) {
        this.repository.setAutoBackgroundDetection(z11);
    }

    public void setPreferredLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ConstantsKt.ADJUST_LANGUAGE);
        this.repository.setPreferredLanguage(str);
    }

    public void subscribeForMessages(@NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function1<? super GroupChannel, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onNewMessage");
        Intrinsics.checkNotNullParameter(function12, "onMessageReceiptUpdate");
        this.repository.subscribeForMessages(function1, function12);
    }

    public void unsubscribeForMessages() {
        this.repository.unsubscribeForMessages();
    }

    @NotNull
    public String userId() {
        return this.repository.userId();
    }
}
