package com.deliveryhero.chatsdk;

import com.deliveryhero.chatsdk.domain.model.messages.Message;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/chatsdk/ChannelListener;", "", "onLastReadMessageUpdated", "", "lastReadMessageTimestamp", "", "onMessageReceived", "channel", "Lcom/deliveryhero/chatsdk/Channel;", "message", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChannelListener {
    void onLastReadMessageUpdated(long j11);

    void onMessageReceived(@NotNull Channel channel, @NotNull Message message);
}
