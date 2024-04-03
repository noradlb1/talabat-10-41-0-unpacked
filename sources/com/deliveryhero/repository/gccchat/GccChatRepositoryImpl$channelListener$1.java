package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.Channel;
import com.deliveryhero.chatsdk.ChannelListener;
import com.deliveryhero.chatsdk.domain.model.UserInfo;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.ConfigMessage;
import com.deliveryhero.contract.model.Events;
import com.deliveryhero.customerchat.commons.TimeUtilKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/deliveryhero/repository/gccchat/GccChatRepositoryImpl$channelListener$1", "Lcom/deliveryhero/chatsdk/ChannelListener;", "onLastReadMessageUpdated", "", "lastReadMessageTimestamp", "", "onMessageReceived", "channel", "Lcom/deliveryhero/chatsdk/Channel;", "message", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$channelListener$1 implements ChannelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30438a;

    public GccChatRepositoryImpl$channelListener$1(GccChatRepositoryImpl gccChatRepositoryImpl) {
        this.f30438a = gccChatRepositoryImpl;
    }

    public void onLastReadMessageUpdated(long j11) {
        this.f30438a.lastReadMessageTimestamp = TimeUtilKt.convertNanosToMillis(j11);
        Function1 access$getOnMessageReceiptUpdateListener$p = this.f30438a.onMessageReceiptUpdateListener;
        if (access$getOnMessageReceiptUpdateListener$p != null) {
            access$getOnMessageReceiptUpdateListener$p.invoke(this.f30438a);
        }
    }

    public void onMessageReceived(@NotNull Channel channel, @NotNull Message message) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(message, "message");
        ChatLogger chatLogger = this.f30438a.chatFeatureCallbacks.getChatLogger();
        if (chatLogger != null) {
            GccChatRepositoryImpl gccChatRepositoryImpl = this.f30438a;
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to(Events.PARAM_CHANNEL_ID, channel.getChannelId());
            pairArr[1] = TuplesKt.to(Events.PARAM_MESSAGE_ID, message.getId());
            UserInfo access$getGccUserInfo$p = gccChatRepositoryImpl.gccUserInfo;
            if (access$getGccUserInfo$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gccUserInfo");
                access$getGccUserInfo$p = null;
            }
            pairArr[2] = TuplesKt.to(Events.PARAM_USER_ID, access$getGccUserInfo$p.getUserId());
            chatLogger.log(Events.GCC_MESSAGE_RECEIVED_EVENT, MapsKt__MapsKt.mapOf(pairArr));
        }
        BaseMessage map = this.f30438a.mapper.map(message);
        if (map instanceof ConfigMessage) {
            this.f30438a.configRelay.setConfig((ConfigMessage) map);
            return;
        }
        Function1 access$getOnNewMessageListener$p = this.f30438a.onNewMessageListener;
        if (access$getOnNewMessageListener$p != null) {
            access$getOnNewMessageListener$p.invoke(map);
        }
    }
}
