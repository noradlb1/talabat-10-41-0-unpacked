package com.deliveryhero.chatsdk.network.websocket.model;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.instabug.library.model.session.config.SessionsConfigParameter;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001#BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryRequest;", "", "channelId", "", "limit", "", "timestamp", "", "mode", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryRequest$Mode;", "eventType", "correlationId", "(Ljava/lang/String;IJLcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryRequest$Mode;Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getCorrelationId", "getEventType", "getLimit", "()I", "getMode", "()Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryRequest$Mode;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Mode", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessagesHistoryRequest {
    @NotNull
    private final String channelId;
    @NotNull
    private final String correlationId;
    @NotNull
    private final String eventType;
    private final int limit;
    @NotNull
    private final Mode mode;
    private final long timestamp;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryRequest$Mode;", "", "(Ljava/lang/String;I)V", "AFTER_TIMESTAMP", "BEFORE_TIMESTAMP", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Mode {
        AFTER_TIMESTAMP,
        BEFORE_TIMESTAMP
    }

    public MessagesHistoryRequest(@NotNull @Json(name = "channel_id") String str, @Json(name = "limit") int i11, @Json(name = "timestamp") long j11, @NotNull @Json(name = "mode") Mode mode2, @NotNull @Json(name = "event_type") String str2, @NotNull @Json(name = "correlation_id") String str3) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(mode2, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str3, "correlationId");
        this.channelId = str;
        this.limit = i11;
        this.timestamp = j11;
        this.mode = mode2;
        this.eventType = str2;
        this.correlationId = str3;
    }

    public static /* synthetic */ MessagesHistoryRequest copy$default(MessagesHistoryRequest messagesHistoryRequest, String str, int i11, long j11, Mode mode2, String str2, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = messagesHistoryRequest.channelId;
        }
        if ((i12 & 2) != 0) {
            i11 = messagesHistoryRequest.limit;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            j11 = messagesHistoryRequest.timestamp;
        }
        long j12 = j11;
        if ((i12 & 8) != 0) {
            mode2 = messagesHistoryRequest.mode;
        }
        Mode mode3 = mode2;
        if ((i12 & 16) != 0) {
            str2 = messagesHistoryRequest.eventType;
        }
        String str4 = str2;
        if ((i12 & 32) != 0) {
            str3 = messagesHistoryRequest.correlationId;
        }
        return messagesHistoryRequest.copy(str, i13, j12, mode3, str4, str3);
    }

    @NotNull
    public final String component1() {
        return this.channelId;
    }

    public final int component2() {
        return this.limit;
    }

    public final long component3() {
        return this.timestamp;
    }

    @NotNull
    public final Mode component4() {
        return this.mode;
    }

    @NotNull
    public final String component5() {
        return this.eventType;
    }

    @NotNull
    public final String component6() {
        return this.correlationId;
    }

    @NotNull
    public final MessagesHistoryRequest copy(@NotNull @Json(name = "channel_id") String str, @Json(name = "limit") int i11, @Json(name = "timestamp") long j11, @NotNull @Json(name = "mode") Mode mode2, @NotNull @Json(name = "event_type") String str2, @NotNull @Json(name = "correlation_id") String str3) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(mode2, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str4, "correlationId");
        return new MessagesHistoryRequest(str, i11, j11, mode2, str2, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessagesHistoryRequest)) {
            return false;
        }
        MessagesHistoryRequest messagesHistoryRequest = (MessagesHistoryRequest) obj;
        return Intrinsics.areEqual((Object) this.channelId, (Object) messagesHistoryRequest.channelId) && this.limit == messagesHistoryRequest.limit && this.timestamp == messagesHistoryRequest.timestamp && this.mode == messagesHistoryRequest.mode && Intrinsics.areEqual((Object) this.eventType, (Object) messagesHistoryRequest.eventType) && Intrinsics.areEqual((Object) this.correlationId, (Object) messagesHistoryRequest.correlationId);
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

    public final int getLimit() {
        return this.limit;
    }

    @NotNull
    public final Mode getMode() {
        return this.mode;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((((((this.channelId.hashCode() * 31) + this.limit) * 31) + a.a(this.timestamp)) * 31) + this.mode.hashCode()) * 31) + this.eventType.hashCode()) * 31) + this.correlationId.hashCode();
    }

    @NotNull
    public String toString() {
        return "MessagesHistoryRequest(channelId=" + this.channelId + ", limit=" + this.limit + ", timestamp=" + this.timestamp + ", mode=" + this.mode + ", eventType=" + this.eventType + ", correlationId=" + this.correlationId + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessagesHistoryRequest(String str, int i11, long j11, Mode mode2, String str2, String str3, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, j11, mode2, (i12 & 16) != 0 ? "listChannelMessages" : str2, str3);
    }
}
