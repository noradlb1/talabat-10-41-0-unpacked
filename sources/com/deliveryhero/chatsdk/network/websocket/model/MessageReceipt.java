package com.deliveryhero.chatsdk.network.websocket.model;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReceipt;", "", "channelId", "", "timestamp", "", "messageId", "correlationId", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getCorrelationId", "getMessageId", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "isMessageReadReceipt", "isMessageSentReceipt", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessageReceipt {
    @NotNull
    private final String channelId;
    @Nullable
    private final String correlationId;
    @Nullable
    private final String messageId;
    private final long timestamp;

    public MessageReceipt(@NotNull @Json(name = "channel_id") String str, @Json(name = "timestamp") long j11, @Nullable @Json(name = "message_id") String str2, @Nullable @Json(name = "correlation_id") String str3) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        this.channelId = str;
        this.timestamp = j11;
        this.messageId = str2;
        this.correlationId = str3;
    }

    public static /* synthetic */ MessageReceipt copy$default(MessageReceipt messageReceipt, String str, long j11, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = messageReceipt.channelId;
        }
        if ((i11 & 2) != 0) {
            j11 = messageReceipt.timestamp;
        }
        long j12 = j11;
        if ((i11 & 4) != 0) {
            str2 = messageReceipt.messageId;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            str3 = messageReceipt.correlationId;
        }
        return messageReceipt.copy(str, j12, str4, str3);
    }

    @NotNull
    public final String component1() {
        return this.channelId;
    }

    public final long component2() {
        return this.timestamp;
    }

    @Nullable
    public final String component3() {
        return this.messageId;
    }

    @Nullable
    public final String component4() {
        return this.correlationId;
    }

    @NotNull
    public final MessageReceipt copy(@NotNull @Json(name = "channel_id") String str, @Json(name = "timestamp") long j11, @Nullable @Json(name = "message_id") String str2, @Nullable @Json(name = "correlation_id") String str3) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        return new MessageReceipt(str, j11, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageReceipt)) {
            return false;
        }
        MessageReceipt messageReceipt = (MessageReceipt) obj;
        return Intrinsics.areEqual((Object) this.channelId, (Object) messageReceipt.channelId) && this.timestamp == messageReceipt.timestamp && Intrinsics.areEqual((Object) this.messageId, (Object) messageReceipt.messageId) && Intrinsics.areEqual((Object) this.correlationId, (Object) messageReceipt.correlationId);
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    public final String getCorrelationId() {
        return this.correlationId;
    }

    @Nullable
    public final String getMessageId() {
        return this.messageId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int hashCode = ((this.channelId.hashCode() * 31) + a.a(this.timestamp)) * 31;
        String str = this.messageId;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.correlationId;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    public final boolean isMessageReadReceipt() {
        return !isMessageSentReceipt();
    }

    public final boolean isMessageSentReceipt() {
        return (this.messageId == null || this.correlationId == null) ? false : true;
    }

    @NotNull
    public String toString() {
        return "MessageReceipt(channelId=" + this.channelId + ", timestamp=" + this.timestamp + ", messageId=" + this.messageId + ", correlationId=" + this.correlationId + ')';
    }
}
