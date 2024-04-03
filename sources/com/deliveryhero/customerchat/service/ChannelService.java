package com.deliveryhero.customerchat.service;

import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.FileMessageData;
import com.deliveryhero.contract.model.GroupChannel;
import com.deliveryhero.contract.model.LocationData;
import com.deliveryhero.contract.model.Receipt;
import com.deliveryhero.contract.model.TextMessageData;
import com.deliveryhero.contract.model.UserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J2\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\nH&J2\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\nH&J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\bH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000eH&J\b\u0010\u0013\u001a\u00020\u0014H&J>\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000e2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00030\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\nH&J\b\u0010\u0018\u001a\u00020\u0014H&J\b\u0010\u0019\u001a\u00020\u0014H&J\b\u0010\u001a\u001a\u00020\u0014H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000eH&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H&J\b\u0010\u001f\u001a\u00020\u0014H&J$\u0010 \u001a\u00020\u00032\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\bH&J2\u0010#\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\nH&J\b\u0010$\u001a\u00020\u0003H&J@\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\n2\u001a\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030)H&J@\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\n2\u001a\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030)H&JP\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00162\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\n2\u001a\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030)H&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0014H&J\u0010\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u000eH&J0\u00105\u001a\u00020\u00032\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\n2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00030\nH&J\b\u00108\u001a\u00020\u0003H&J\b\u00109\u001a\u00020\u000eH&¨\u0006:"}, d2 = {"Lcom/deliveryhero/customerchat/service/ChannelService;", "", "clear", "", "connect", "userInfo", "Lcom/deliveryhero/contract/model/UserInfo;", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "", "connectChannel", "id", "", "disconnect", "handler", "fetchConfig", "correlationID", "getAutoBackgroundDetection", "", "getChatList", "", "Lcom/deliveryhero/contract/model/BaseMessage;", "isConnected", "isConnectionClosed", "isLoading", "markAllMessagesAsRead", "messageReceipt", "Lcom/deliveryhero/contract/model/Receipt;", "message", "reconnect", "registerConnectionHandler", "onStarted", "onSucceeded", "registerUser", "removeConnectionHandler", "sendFileMessage", "fileParams", "Lcom/deliveryhero/contract/model/FileMessageData;", "onNewMessage", "Lkotlin/Function2;", "sendLocationMessage", "data", "Lcom/deliveryhero/contract/model/LocationData;", "sendMessage", "messageData", "Lcom/deliveryhero/contract/model/TextMessageData;", "supportedTranslation", "setAutoBackgroundDetection", "enable", "setPreferredLanguage", "language", "subscribeForMessages", "onMessageReceiptUpdate", "Lcom/deliveryhero/contract/model/GroupChannel;", "unsubscribeForMessages", "userId", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChannelService {
    void clear();

    void connect(@NotNull UserInfo userInfo, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1);

    void connectChannel(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1);

    void disconnect(@NotNull Function0<Unit> function0);

    void fetchConfig(@NotNull String str);

    boolean getAutoBackgroundDetection();

    void getChatList(@NotNull String str, @NotNull Function1<? super List<? extends BaseMessage>, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12);

    boolean isConnected();

    boolean isConnectionClosed();

    boolean isLoading();

    void markAllMessagesAsRead(@NotNull String str);

    @NotNull
    Receipt messageReceipt(@NotNull BaseMessage baseMessage);

    boolean reconnect();

    void registerConnectionHandler(@NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);

    void registerUser(@NotNull UserInfo userInfo, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1);

    void removeConnectionHandler();

    void sendFileMessage(@NotNull FileMessageData fileMessageData, @NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function2<? super BaseMessage, ? super Throwable, Unit> function2);

    void sendLocationMessage(@NotNull LocationData locationData, @NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function2<? super BaseMessage, ? super Throwable, Unit> function2);

    void sendMessage(@NotNull TextMessageData textMessageData, @Nullable List<String> list, @NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function2<? super BaseMessage, ? super Throwable, Unit> function2);

    void setAutoBackgroundDetection(boolean z11);

    void setPreferredLanguage(@NotNull String str);

    void subscribeForMessages(@NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function1<? super GroupChannel, Unit> function12);

    void unsubscribeForMessages();

    @NotNull
    String userId();
}
