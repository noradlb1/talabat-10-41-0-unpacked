package com.deliveryhero.chatsdk.network.websocket.model;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketConfigRequest;", "", "channelId", "", "senderId", "eventType", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getCorrelationId", "getEventType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "getSenderId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OutgoingWebSocketConfigRequest {
    @NotNull
    private final String channelId;
    @NotNull
    private final String correlationId;
    @NotNull
    private final EventType eventType;
    @NotNull
    private final String senderId;

    public OutgoingWebSocketConfigRequest(@NotNull @Json(name = "channel_id") String str, @NotNull @Json(name = "sender_id") String str2, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "correlation_id") String str3) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str2, "senderId");
        Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str3, "correlationId");
        this.channelId = str;
        this.senderId = str2;
        this.eventType = eventType2;
        this.correlationId = str3;
    }

    public static /* synthetic */ OutgoingWebSocketConfigRequest copy$default(OutgoingWebSocketConfigRequest outgoingWebSocketConfigRequest, String str, String str2, EventType eventType2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = outgoingWebSocketConfigRequest.channelId;
        }
        if ((i11 & 2) != 0) {
            str2 = outgoingWebSocketConfigRequest.senderId;
        }
        if ((i11 & 4) != 0) {
            eventType2 = outgoingWebSocketConfigRequest.eventType;
        }
        if ((i11 & 8) != 0) {
            str3 = outgoingWebSocketConfigRequest.correlationId;
        }
        return outgoingWebSocketConfigRequest.copy(str, str2, eventType2, str3);
    }

    @NotNull
    public final String component1() {
        return this.channelId;
    }

    @NotNull
    public final String component2() {
        return this.senderId;
    }

    @NotNull
    public final EventType component3() {
        return this.eventType;
    }

    @NotNull
    public final String component4() {
        return this.correlationId;
    }

    @NotNull
    public final OutgoingWebSocketConfigRequest copy(@NotNull @Json(name = "channel_id") String str, @NotNull @Json(name = "sender_id") String str2, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "correlation_id") String str3) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str2, "senderId");
        Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str3, "correlationId");
        return new OutgoingWebSocketConfigRequest(str, str2, eventType2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OutgoingWebSocketConfigRequest)) {
            return false;
        }
        OutgoingWebSocketConfigRequest outgoingWebSocketConfigRequest = (OutgoingWebSocketConfigRequest) obj;
        return Intrinsics.areEqual((Object) this.channelId, (Object) outgoingWebSocketConfigRequest.channelId) && Intrinsics.areEqual((Object) this.senderId, (Object) outgoingWebSocketConfigRequest.senderId) && this.eventType == outgoingWebSocketConfigRequest.eventType && Intrinsics.areEqual((Object) this.correlationId, (Object) outgoingWebSocketConfigRequest.correlationId);
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
    public final EventType getEventType() {
        return this.eventType;
    }

    @NotNull
    public final String getSenderId() {
        return this.senderId;
    }

    public int hashCode() {
        return (((((this.channelId.hashCode() * 31) + this.senderId.hashCode()) * 31) + this.eventType.hashCode()) * 31) + this.correlationId.hashCode();
    }

    @NotNull
    public String toString() {
        return "OutgoingWebSocketConfigRequest(channelId=" + this.channelId + ", senderId=" + this.senderId + ", eventType=" + this.eventType + ", correlationId=" + this.correlationId + ')';
    }
}
