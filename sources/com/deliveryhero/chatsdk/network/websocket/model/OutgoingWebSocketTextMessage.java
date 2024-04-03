package com.deliveryhero.chatsdk.network.websocket.model;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\b\b\u0003\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketTextMessage;", "", "content", "", "eventType", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "contentType", "Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "channelId", "language", "supportedLanguages", "", "correlationId", "(Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getContent", "getContentType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "getCorrelationId", "getEventType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "getLanguage", "getSupportedLanguages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OutgoingWebSocketTextMessage {
    @NotNull
    private final String channelId;
    @NotNull
    private final String content;
    @NotNull
    private final ContentType contentType;
    @NotNull
    private final String correlationId;
    @NotNull
    private final EventType eventType;
    @Nullable
    private final String language;
    @Nullable
    private final List<String> supportedLanguages;

    public OutgoingWebSocketTextMessage(@NotNull @Json(name = "content") String str, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "content_type") ContentType contentType2, @NotNull @Json(name = "channel_id") String str2, @Nullable @Json(name = "language") String str3, @Nullable @Json(name = "supported_languages") List<String> list, @NotNull @Json(name = "correlation_id") String str4) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(contentType2, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str4, "correlationId");
        this.content = str;
        this.eventType = eventType2;
        this.contentType = contentType2;
        this.channelId = str2;
        this.language = str3;
        this.supportedLanguages = list;
        this.correlationId = str4;
    }

    public static /* synthetic */ OutgoingWebSocketTextMessage copy$default(OutgoingWebSocketTextMessage outgoingWebSocketTextMessage, String str, EventType eventType2, ContentType contentType2, String str2, String str3, List<String> list, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = outgoingWebSocketTextMessage.content;
        }
        if ((i11 & 2) != 0) {
            eventType2 = outgoingWebSocketTextMessage.eventType;
        }
        EventType eventType3 = eventType2;
        if ((i11 & 4) != 0) {
            contentType2 = outgoingWebSocketTextMessage.contentType;
        }
        ContentType contentType3 = contentType2;
        if ((i11 & 8) != 0) {
            str2 = outgoingWebSocketTextMessage.channelId;
        }
        String str5 = str2;
        if ((i11 & 16) != 0) {
            str3 = outgoingWebSocketTextMessage.language;
        }
        String str6 = str3;
        if ((i11 & 32) != 0) {
            list = outgoingWebSocketTextMessage.supportedLanguages;
        }
        List<String> list2 = list;
        if ((i11 & 64) != 0) {
            str4 = outgoingWebSocketTextMessage.correlationId;
        }
        return outgoingWebSocketTextMessage.copy(str, eventType3, contentType3, str5, str6, list2, str4);
    }

    @NotNull
    public final String component1() {
        return this.content;
    }

    @NotNull
    public final EventType component2() {
        return this.eventType;
    }

    @NotNull
    public final ContentType component3() {
        return this.contentType;
    }

    @NotNull
    public final String component4() {
        return this.channelId;
    }

    @Nullable
    public final String component5() {
        return this.language;
    }

    @Nullable
    public final List<String> component6() {
        return this.supportedLanguages;
    }

    @NotNull
    public final String component7() {
        return this.correlationId;
    }

    @NotNull
    public final OutgoingWebSocketTextMessage copy(@NotNull @Json(name = "content") String str, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "content_type") ContentType contentType2, @NotNull @Json(name = "channel_id") String str2, @Nullable @Json(name = "language") String str3, @Nullable @Json(name = "supported_languages") List<String> list, @NotNull @Json(name = "correlation_id") String str4) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(contentType2, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "correlationId");
        return new OutgoingWebSocketTextMessage(str, eventType2, contentType2, str2, str3, list, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OutgoingWebSocketTextMessage)) {
            return false;
        }
        OutgoingWebSocketTextMessage outgoingWebSocketTextMessage = (OutgoingWebSocketTextMessage) obj;
        return Intrinsics.areEqual((Object) this.content, (Object) outgoingWebSocketTextMessage.content) && this.eventType == outgoingWebSocketTextMessage.eventType && this.contentType == outgoingWebSocketTextMessage.contentType && Intrinsics.areEqual((Object) this.channelId, (Object) outgoingWebSocketTextMessage.channelId) && Intrinsics.areEqual((Object) this.language, (Object) outgoingWebSocketTextMessage.language) && Intrinsics.areEqual((Object) this.supportedLanguages, (Object) outgoingWebSocketTextMessage.supportedLanguages) && Intrinsics.areEqual((Object) this.correlationId, (Object) outgoingWebSocketTextMessage.correlationId);
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getContent() {
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

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final List<String> getSupportedLanguages() {
        return this.supportedLanguages;
    }

    public int hashCode() {
        int hashCode = ((((((this.content.hashCode() * 31) + this.eventType.hashCode()) * 31) + this.contentType.hashCode()) * 31) + this.channelId.hashCode()) * 31;
        String str = this.language;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.supportedLanguages;
        if (list != null) {
            i11 = list.hashCode();
        }
        return ((hashCode2 + i11) * 31) + this.correlationId.hashCode();
    }

    @NotNull
    public String toString() {
        return "OutgoingWebSocketTextMessage(content=" + this.content + ", eventType=" + this.eventType + ", contentType=" + this.contentType + ", channelId=" + this.channelId + ", language=" + this.language + ", supportedLanguages=" + this.supportedLanguages + ", correlationId=" + this.correlationId + ')';
    }
}
