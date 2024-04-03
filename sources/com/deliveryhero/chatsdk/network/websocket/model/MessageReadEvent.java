package com.deliveryhero.chatsdk.network.websocket.model;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReadEvent;", "", "channelId", "", "timestamp", "", "eventType", "correlationId", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getCorrelationId", "getEventType", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessageReadEvent {
    @NotNull
    private final String channelId;
    @NotNull
    private final String correlationId;
    @NotNull
    private final String eventType;
    private final long timestamp;

    public MessageReadEvent(@NotNull @Json(name = "channel_id") String str, @Json(name = "timestamp") long j11, @NotNull @Json(name = "event_type") String str2, @NotNull @Json(name = "correlation_id") String str3) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str3, "correlationId");
        this.channelId = str;
        this.timestamp = j11;
        this.eventType = str2;
        this.correlationId = str3;
    }

    public static /* synthetic */ MessageReadEvent copy$default(MessageReadEvent messageReadEvent, String str, long j11, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = messageReadEvent.channelId;
        }
        if ((i11 & 2) != 0) {
            j11 = messageReadEvent.timestamp;
        }
        long j12 = j11;
        if ((i11 & 4) != 0) {
            str2 = messageReadEvent.eventType;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            str3 = messageReadEvent.correlationId;
        }
        return messageReadEvent.copy(str, j12, str4, str3);
    }

    @NotNull
    public final String component1() {
        return this.channelId;
    }

    public final long component2() {
        return this.timestamp;
    }

    @NotNull
    public final String component3() {
        return this.eventType;
    }

    @NotNull
    public final String component4() {
        return this.correlationId;
    }

    @NotNull
    public final MessageReadEvent copy(@NotNull @Json(name = "channel_id") String str, @Json(name = "timestamp") long j11, @NotNull @Json(name = "event_type") String str2, @NotNull @Json(name = "correlation_id") String str3) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str3, "correlationId");
        return new MessageReadEvent(str, j11, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageReadEvent)) {
            return false;
        }
        MessageReadEvent messageReadEvent = (MessageReadEvent) obj;
        return Intrinsics.areEqual((Object) this.channelId, (Object) messageReadEvent.channelId) && this.timestamp == messageReadEvent.timestamp && Intrinsics.areEqual((Object) this.eventType, (Object) messageReadEvent.eventType) && Intrinsics.areEqual((Object) this.correlationId, (Object) messageReadEvent.correlationId);
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getCorrelationId() {
        return this.correlationId;
    }

    @NotNull
    public final String getEventType() {
        return this.eventType;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((this.channelId.hashCode() * 31) + a.a(this.timestamp)) * 31) + this.eventType.hashCode()) * 31) + this.correlationId.hashCode();
    }

    @NotNull
    public String toString() {
        return "MessageReadEvent(channelId=" + this.channelId + ", timestamp=" + this.timestamp + ", eventType=" + this.eventType + ", correlationId=" + this.correlationId + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageReadEvent(String str, long j11, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11, (i11 & 4) != 0 ? MessageReadEventKt.READ_RECEIPT_EVENT_TYPE : str2, str3);
    }
}
