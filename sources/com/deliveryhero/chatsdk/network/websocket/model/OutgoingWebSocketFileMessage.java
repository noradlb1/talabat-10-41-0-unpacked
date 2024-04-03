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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00052\b\b\u0003\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006$"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketFileMessage;", "", "content", "Lcom/deliveryhero/chatsdk/network/websocket/model/FileContent;", "senderId", "", "contentType", "Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "eventType", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "channelId", "correlationId", "(Lcom/deliveryhero/chatsdk/network/websocket/model/FileContent;Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getContent", "()Lcom/deliveryhero/chatsdk/network/websocket/model/FileContent;", "getContentType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "getCorrelationId", "getEventType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "getSenderId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OutgoingWebSocketFileMessage {
    @NotNull
    private final String channelId;
    @NotNull
    private final FileContent content;
    @NotNull
    private final ContentType contentType;
    @NotNull
    private final String correlationId;
    @NotNull
    private final EventType eventType;
    @NotNull
    private final String senderId;

    public OutgoingWebSocketFileMessage(@NotNull @Json(name = "content") FileContent fileContent, @NotNull @Json(name = "sender_id") String str, @NotNull @Json(name = "content_type") ContentType contentType2, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "channel_id") String str2, @NotNull @Json(name = "correlation_id") String str3) {
        Intrinsics.checkNotNullParameter(fileContent, "content");
        Intrinsics.checkNotNullParameter(str, "senderId");
        Intrinsics.checkNotNullParameter(contentType2, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str3, "correlationId");
        this.content = fileContent;
        this.senderId = str;
        this.contentType = contentType2;
        this.eventType = eventType2;
        this.channelId = str2;
        this.correlationId = str3;
    }

    public static /* synthetic */ OutgoingWebSocketFileMessage copy$default(OutgoingWebSocketFileMessage outgoingWebSocketFileMessage, FileContent fileContent, String str, ContentType contentType2, EventType eventType2, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            fileContent = outgoingWebSocketFileMessage.content;
        }
        if ((i11 & 2) != 0) {
            str = outgoingWebSocketFileMessage.senderId;
        }
        String str4 = str;
        if ((i11 & 4) != 0) {
            contentType2 = outgoingWebSocketFileMessage.contentType;
        }
        ContentType contentType3 = contentType2;
        if ((i11 & 8) != 0) {
            eventType2 = outgoingWebSocketFileMessage.eventType;
        }
        EventType eventType3 = eventType2;
        if ((i11 & 16) != 0) {
            str2 = outgoingWebSocketFileMessage.channelId;
        }
        String str5 = str2;
        if ((i11 & 32) != 0) {
            str3 = outgoingWebSocketFileMessage.correlationId;
        }
        return outgoingWebSocketFileMessage.copy(fileContent, str4, contentType3, eventType3, str5, str3);
    }

    @NotNull
    public final FileContent component1() {
        return this.content;
    }

    @NotNull
    public final String component2() {
        return this.senderId;
    }

    @NotNull
    public final ContentType component3() {
        return this.contentType;
    }

    @NotNull
    public final EventType component4() {
        return this.eventType;
    }

    @NotNull
    public final String component5() {
        return this.channelId;
    }

    @NotNull
    public final String component6() {
        return this.correlationId;
    }

    @NotNull
    public final OutgoingWebSocketFileMessage copy(@NotNull @Json(name = "content") FileContent fileContent, @NotNull @Json(name = "sender_id") String str, @NotNull @Json(name = "content_type") ContentType contentType2, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "channel_id") String str2, @NotNull @Json(name = "correlation_id") String str3) {
        Intrinsics.checkNotNullParameter(fileContent, "content");
        Intrinsics.checkNotNullParameter(str, "senderId");
        Intrinsics.checkNotNullParameter(contentType2, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str3, "correlationId");
        return new OutgoingWebSocketFileMessage(fileContent, str, contentType2, eventType2, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OutgoingWebSocketFileMessage)) {
            return false;
        }
        OutgoingWebSocketFileMessage outgoingWebSocketFileMessage = (OutgoingWebSocketFileMessage) obj;
        return Intrinsics.areEqual((Object) this.content, (Object) outgoingWebSocketFileMessage.content) && Intrinsics.areEqual((Object) this.senderId, (Object) outgoingWebSocketFileMessage.senderId) && this.contentType == outgoingWebSocketFileMessage.contentType && this.eventType == outgoingWebSocketFileMessage.eventType && Intrinsics.areEqual((Object) this.channelId, (Object) outgoingWebSocketFileMessage.channelId) && Intrinsics.areEqual((Object) this.correlationId, (Object) outgoingWebSocketFileMessage.correlationId);
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final FileContent getContent() {
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
        return (((((((((this.content.hashCode() * 31) + this.senderId.hashCode()) * 31) + this.contentType.hashCode()) * 31) + this.eventType.hashCode()) * 31) + this.channelId.hashCode()) * 31) + this.correlationId.hashCode();
    }

    @NotNull
    public String toString() {
        return "OutgoingWebSocketFileMessage(content=" + this.content + ", senderId=" + this.senderId + ", contentType=" + this.contentType + ", eventType=" + this.eventType + ", channelId=" + this.channelId + ", correlationId=" + this.correlationId + ')';
    }
}
