package com.deliveryhero.chatsdk;

import com.deliveryhero.chatsdk.domain.model.ConnectionState;
import com.deliveryhero.chatsdk.domain.model.messages.UnreadChatDetails;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0004\u0012\u00020\t0\u000bH&ø\u0001\u0000J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J%\u0010\u0013\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0004\u0012\u00020\t0\u000bH&ø\u0001\u0000J\b\u0010\u0014\u001a\u00020\tH&J\b\u0010\u0015\u001a\u00020\u0016H'J-\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00102\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\f\u0012\u0004\u0012\u00020\t0\u000bH&ø\u0001\u0000J%\u0010\u001b\u001a\u00020\t2\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\f\u0012\u0004\u0012\u00020\t0\u000bH&ø\u0001\u0000J5\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0004\u0012\u00020\t0\u000bH&ø\u0001\u0000J\b\u0010 \u001a\u00020\tH&J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0016H'J\u001c\u0010#\u001a\u00020\t2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u000bH&J-\u0010%\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00102\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0004\u0012\u00020\t0\u000bH&ø\u0001\u0000R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/deliveryhero/chatsdk/ChatSdk;", "", "connectionState", "Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;", "getConnectionState", "()Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;", "setConnectionState", "(Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;)V", "connect", "", "completionHandler", "Lkotlin/Function1;", "Lkotlin/Result;", "connectChannel", "Lcom/deliveryhero/chatsdk/Channel;", "channelId", "", "listener", "Lcom/deliveryhero/chatsdk/ChannelListener;", "disconnect", "dispose", "getAutoBackgroundDetection", "", "getChannelUnreadMessagesCount", "channelID", "resultListener", "Lcom/deliveryhero/chatsdk/domain/model/messages/UnreadChatDetails;", "getTotalUnreadMessagesCount", "", "registerDevicePushToken", "deviceToken", "appId", "removeConnectionStateChangesListener", "setAutoBackgroundDetection", "enable", "setConnectionStateChangesListener", "connectionStateListener", "unregisterDevicePushToken", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChatSdk {
    void connect(@NotNull Function1<? super Result<Unit>, Unit> function1);

    @NotNull
    Channel connectChannel(@NotNull String str, @NotNull ChannelListener channelListener);

    void disconnect(@NotNull Function1<? super Result<Unit>, Unit> function1);

    void dispose();

    @Deprecated(message = "Do not use. New versions(>1.0.12) of the SDK do not detect app states")
    boolean getAutoBackgroundDetection();

    void getChannelUnreadMessagesCount(@NotNull String str, @NotNull Function1<? super Result<UnreadChatDetails>, Unit> function1);

    @NotNull
    ConnectionState getConnectionState();

    void getTotalUnreadMessagesCount(@NotNull Function1<? super Result<Integer>, Unit> function1);

    void registerDevicePushToken(@NotNull String str, @NotNull String str2, @NotNull Function1<? super Result<Unit>, Unit> function1);

    void removeConnectionStateChangesListener();

    @Deprecated(message = "Do not use. New versions(>1.0.12) of the SDK do not detect app states")
    void setAutoBackgroundDetection(boolean z11);

    void setConnectionState(@NotNull ConnectionState connectionState);

    void setConnectionStateChangesListener(@NotNull Function1<? super ConnectionState, Unit> function1);

    void unregisterDevicePushToken(@NotNull String str, @NotNull Function1<? super Result<Unit>, Unit> function1);
}
