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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006$"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketLocationMessage;", "", "channelId", "", "content", "Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContent;", "contentType", "Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "correlationId", "eventType", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "senderId", "(Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContent;Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getContent", "()Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContent;", "getContentType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "getCorrelationId", "getEventType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "getSenderId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OutgoingWebSocketLocationMessage {
    @NotNull
    private final String channelId;
    @NotNull
    private final LocationContent content;
    @NotNull
    private final ContentType contentType;
    @NotNull
    private final String correlationId;
    @NotNull
    private final EventType eventType;
    @NotNull
    private final String senderId;

    public OutgoingWebSocketLocationMessage(@NotNull @Json(name = "channel_id") String str, @NotNull @Json(name = "content") LocationContent locationContent, @NotNull @Json(name = "content_type") ContentType contentType2, @NotNull @Json(name = "correlation_id") String str2, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "sender_id") String str3) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(locationContent, "content");
        Intrinsics.checkNotNullParameter(contentType2, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str2, "correlationId");
        Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str3, "senderId");
        this.channelId = str;
        this.content = locationContent;
        this.contentType = contentType2;
        this.correlationId = str2;
        this.eventType = eventType2;
        this.senderId = str3;
    }

    public static /* synthetic */ OutgoingWebSocketLocationMessage copy$default(OutgoingWebSocketLocationMessage outgoingWebSocketLocationMessage, String str, LocationContent locationContent, ContentType contentType2, String str2, EventType eventType2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = outgoingWebSocketLocationMessage.channelId;
        }
        if ((i11 & 2) != 0) {
            locationContent = outgoingWebSocketLocationMessage.content;
        }
        LocationContent locationContent2 = locationContent;
        if ((i11 & 4) != 0) {
            contentType2 = outgoingWebSocketLocationMessage.contentType;
        }
        ContentType contentType3 = contentType2;
        if ((i11 & 8) != 0) {
            str2 = outgoingWebSocketLocationMessage.correlationId;
        }
        String str4 = str2;
        if ((i11 & 16) != 0) {
            eventType2 = outgoingWebSocketLocationMessage.eventType;
        }
        EventType eventType3 = eventType2;
        if ((i11 & 32) != 0) {
            str3 = outgoingWebSocketLocationMessage.senderId;
        }
        return outgoingWebSocketLocationMessage.copy(str, locationContent2, contentType3, str4, eventType3, str3);
    }

    @NotNull
    public final String component1() {
        return this.channelId;
    }

    @NotNull
    public final LocationContent component2() {
        return this.content;
    }

    @NotNull
    public final ContentType component3() {
        return this.contentType;
    }

    @NotNull
    public final String component4() {
        return this.correlationId;
    }

    @NotNull
    public final EventType component5() {
        return this.eventType;
    }

    @NotNull
    public final String component6() {
        return this.senderId;
    }

    @NotNull
    public final OutgoingWebSocketLocationMessage copy(@NotNull @Json(name = "channel_id") String str, @NotNull @Json(name = "content") LocationContent locationContent, @NotNull @Json(name = "content_type") ContentType contentType2, @NotNull @Json(name = "correlation_id") String str2, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "sender_id") String str3) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(locationContent, "content");
        Intrinsics.checkNotNullParameter(contentType2, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str2, "correlationId");
        Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str3, "senderId");
        return new OutgoingWebSocketLocationMessage(str, locationContent, contentType2, str2, eventType2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OutgoingWebSocketLocationMessage)) {
            return false;
        }
        OutgoingWebSocketLocationMessage outgoingWebSocketLocationMessage = (OutgoingWebSocketLocationMessage) obj;
        return Intrinsics.areEqual((Object) this.channelId, (Object) outgoingWebSocketLocationMessage.channelId) && Intrinsics.areEqual((Object) this.content, (Object) outgoingWebSocketLocationMessage.content) && this.contentType == outgoingWebSocketLocationMessage.contentType && Intrinsics.areEqual((Object) this.correlationId, (Object) outgoingWebSocketLocationMessage.correlationId) && this.eventType == outgoingWebSocketLocationMessage.eventType && Intrinsics.areEqual((Object) this.senderId, (Object) outgoingWebSocketLocationMessage.senderId);
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final LocationContent getContent() {
        return this.content;
    }

    @NotNull
    public final ContentType getContentType() {
        return this.contentType;
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
        return (((((((((this.channelId.hashCode() * 31) + this.content.hashCode()) * 31) + this.contentType.hashCode()) * 31) + this.correlationId.hashCode()) * 31) + this.eventType.hashCode()) * 31) + this.senderId.hashCode();
    }

    @NotNull
    public String toString() {
        return "OutgoingWebSocketLocationMessage(channelId=" + this.channelId + ", content=" + this.content + ", contentType=" + this.contentType + ", correlationId=" + this.correlationId + ", eventType=" + this.eventType + ", senderId=" + this.senderId + ')';
    }
}
