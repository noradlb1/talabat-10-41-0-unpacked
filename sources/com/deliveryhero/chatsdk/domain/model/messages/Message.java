package com.deliveryhero.chatsdk.domain.model.messages;

import com.deliveryhero.chatsdk.domain.model.MetaData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "", "channelId", "", "getChannelId", "()Ljava/lang/String;", "id", "getId", "metadata", "Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "getMetadata", "()Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "timestamp", "", "getTimestamp", "()J", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Message {
    @NotNull
    String getChannelId();

    @NotNull
    String getId();

    @Nullable
    MetaData getMetadata();

    long getTimestamp();
}
