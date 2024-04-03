package com.deliveryhero.chatsdk.domain.mapper;

import com.deliveryhero.chatsdk.domain.model.messages.UnreadChatDetails;
import com.deliveryhero.chatsdk.network.http.model.ChannelUnreadCountResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/mapper/ChatDetailsMapper;", "", "()V", "mapResponseToChatDetails", "Lcom/deliveryhero/chatsdk/domain/model/messages/UnreadChatDetails;", "charUnreadCountResponse", "Lcom/deliveryhero/chatsdk/network/http/model/ChannelUnreadCountResponse;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatDetailsMapper {
    @NotNull
    public static final ChatDetailsMapper INSTANCE = new ChatDetailsMapper();

    private ChatDetailsMapper() {
    }

    @NotNull
    public final UnreadChatDetails mapResponseToChatDetails(@NotNull ChannelUnreadCountResponse channelUnreadCountResponse) {
        Intrinsics.checkNotNullParameter(channelUnreadCountResponse, "charUnreadCountResponse");
        return new UnreadChatDetails(channelUnreadCountResponse.getCount(), channelUnreadCountResponse.getHasUnRepliedMessage());
    }
}
