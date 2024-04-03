package com.deliveryhero.chatsdk.network.websocket.model;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage;", "", "()V", "IncomingWebSocketAdminMessage", "IncomingWebSocketChannelFrozenMessage", "IncomingWebSocketConfigMessage", "IncomingWebSocketConfigUpdateMessage", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketAdminMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketConfigMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketConfigUpdateMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketChannelFrozenMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class IncomingWebSocketMessage {

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001'BC\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JG\u0010\u001f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketAdminMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage;", "content", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketAdminMessage$Content;", "eventType", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "timestamp", "", "messageId", "", "channelId", "metadata", "Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "(Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketAdminMessage$Content;Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;JLjava/lang/String;Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;)V", "getChannelId", "()Ljava/lang/String;", "getContent", "()Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketAdminMessage$Content;", "getEventType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "getMessageId", "getMetadata", "()Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Content", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class IncomingWebSocketAdminMessage extends IncomingWebSocketMessage {
        @NotNull
        private final String channelId;
        @NotNull
        private final Content content;
        @NotNull
        private final EventType eventType;
        @NotNull
        private final String messageId;
        @Nullable
        private final MetaDataContent metadata;
        private final long timestamp;

        @JsonClass(generateAdapter = true)
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketAdminMessage$Content;", "", "nickName", "", "(Ljava/lang/String;)V", "getNickName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Content {
            @NotNull
            private final String nickName;

            public Content(@NotNull @Json(name = "nickname") String str) {
                Intrinsics.checkNotNullParameter(str, "nickName");
                this.nickName = str;
            }

            public static /* synthetic */ Content copy$default(Content content, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = content.nickName;
                }
                return content.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.nickName;
            }

            @NotNull
            public final Content copy(@NotNull @Json(name = "nickname") String str) {
                Intrinsics.checkNotNullParameter(str, "nickName");
                return new Content(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Content) && Intrinsics.areEqual((Object) this.nickName, (Object) ((Content) obj).nickName);
            }

            @NotNull
            public final String getNickName() {
                return this.nickName;
            }

            public int hashCode() {
                return this.nickName.hashCode();
            }

            @NotNull
            public String toString() {
                return "Content(nickName=" + this.nickName + ')';
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncomingWebSocketAdminMessage(@NotNull @Json(name = "content") Content content2, @NotNull @Json(name = "event_type") EventType eventType2, @Json(name = "timestamp") long j11, @NotNull @Json(name = "message_id") String str, @NotNull @Json(name = "channel_id") String str2, @Nullable @Json(name = "meta") MetaDataContent metaDataContent) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(content2, "content");
            Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(str, "messageId");
            Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
            this.content = content2;
            this.eventType = eventType2;
            this.timestamp = j11;
            this.messageId = str;
            this.channelId = str2;
            this.metadata = metaDataContent;
        }

        public static /* synthetic */ IncomingWebSocketAdminMessage copy$default(IncomingWebSocketAdminMessage incomingWebSocketAdminMessage, Content content2, EventType eventType2, long j11, String str, String str2, MetaDataContent metaDataContent, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                content2 = incomingWebSocketAdminMessage.content;
            }
            if ((i11 & 2) != 0) {
                eventType2 = incomingWebSocketAdminMessage.eventType;
            }
            EventType eventType3 = eventType2;
            if ((i11 & 4) != 0) {
                j11 = incomingWebSocketAdminMessage.timestamp;
            }
            long j12 = j11;
            if ((i11 & 8) != 0) {
                str = incomingWebSocketAdminMessage.messageId;
            }
            String str3 = str;
            if ((i11 & 16) != 0) {
                str2 = incomingWebSocketAdminMessage.channelId;
            }
            String str4 = str2;
            if ((i11 & 32) != 0) {
                metaDataContent = incomingWebSocketAdminMessage.metadata;
            }
            return incomingWebSocketAdminMessage.copy(content2, eventType3, j12, str3, str4, metaDataContent);
        }

        @NotNull
        public final Content component1() {
            return this.content;
        }

        @NotNull
        public final EventType component2() {
            return this.eventType;
        }

        public final long component3() {
            return this.timestamp;
        }

        @NotNull
        public final String component4() {
            return this.messageId;
        }

        @NotNull
        public final String component5() {
            return this.channelId;
        }

        @Nullable
        public final MetaDataContent component6() {
            return this.metadata;
        }

        @NotNull
        public final IncomingWebSocketAdminMessage copy(@NotNull @Json(name = "content") Content content2, @NotNull @Json(name = "event_type") EventType eventType2, @Json(name = "timestamp") long j11, @NotNull @Json(name = "message_id") String str, @NotNull @Json(name = "channel_id") String str2, @Nullable @Json(name = "meta") MetaDataContent metaDataContent) {
            Intrinsics.checkNotNullParameter(content2, "content");
            Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(str, "messageId");
            Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
            return new IncomingWebSocketAdminMessage(content2, eventType2, j11, str, str2, metaDataContent);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IncomingWebSocketAdminMessage)) {
                return false;
            }
            IncomingWebSocketAdminMessage incomingWebSocketAdminMessage = (IncomingWebSocketAdminMessage) obj;
            return Intrinsics.areEqual((Object) this.content, (Object) incomingWebSocketAdminMessage.content) && this.eventType == incomingWebSocketAdminMessage.eventType && this.timestamp == incomingWebSocketAdminMessage.timestamp && Intrinsics.areEqual((Object) this.messageId, (Object) incomingWebSocketAdminMessage.messageId) && Intrinsics.areEqual((Object) this.channelId, (Object) incomingWebSocketAdminMessage.channelId) && Intrinsics.areEqual((Object) this.metadata, (Object) incomingWebSocketAdminMessage.metadata);
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final Content getContent() {
            return this.content;
        }

        @NotNull
        public final EventType getEventType() {
            return this.eventType;
        }

        @NotNull
        public final String getMessageId() {
            return this.messageId;
        }

        @Nullable
        public final MetaDataContent getMetadata() {
            return this.metadata;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            int hashCode = ((((((((this.content.hashCode() * 31) + this.eventType.hashCode()) * 31) + a.a(this.timestamp)) * 31) + this.messageId.hashCode()) * 31) + this.channelId.hashCode()) * 31;
            MetaDataContent metaDataContent = this.metadata;
            return hashCode + (metaDataContent == null ? 0 : metaDataContent.hashCode());
        }

        @NotNull
        public String toString() {
            return "IncomingWebSocketAdminMessage(content=" + this.content + ", eventType=" + this.eventType + ", timestamp=" + this.timestamp + ", messageId=" + this.messageId + ", channelId=" + this.channelId + ", metadata=" + this.metadata + ')';
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketChannelFrozenMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage;", "channelId", "", "messageId", "eventType", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;J)V", "getChannelId", "()Ljava/lang/String;", "getEventType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "getMessageId", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class IncomingWebSocketChannelFrozenMessage extends IncomingWebSocketMessage {
        @NotNull
        private final String channelId;
        @NotNull
        private final EventType eventType;
        @NotNull
        private final String messageId;
        private final long timestamp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncomingWebSocketChannelFrozenMessage(@NotNull @Json(name = "channel_id") String str, @NotNull @Json(name = "message_id") String str2, @NotNull @Json(name = "event_type") EventType eventType2, @Json(name = "timestamp") long j11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(str2, "messageId");
            Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            this.channelId = str;
            this.messageId = str2;
            this.eventType = eventType2;
            this.timestamp = j11;
        }

        public static /* synthetic */ IncomingWebSocketChannelFrozenMessage copy$default(IncomingWebSocketChannelFrozenMessage incomingWebSocketChannelFrozenMessage, String str, String str2, EventType eventType2, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = incomingWebSocketChannelFrozenMessage.channelId;
            }
            if ((i11 & 2) != 0) {
                str2 = incomingWebSocketChannelFrozenMessage.messageId;
            }
            String str3 = str2;
            if ((i11 & 4) != 0) {
                eventType2 = incomingWebSocketChannelFrozenMessage.eventType;
            }
            EventType eventType3 = eventType2;
            if ((i11 & 8) != 0) {
                j11 = incomingWebSocketChannelFrozenMessage.timestamp;
            }
            return incomingWebSocketChannelFrozenMessage.copy(str, str3, eventType3, j11);
        }

        @NotNull
        public final String component1() {
            return this.channelId;
        }

        @NotNull
        public final String component2() {
            return this.messageId;
        }

        @NotNull
        public final EventType component3() {
            return this.eventType;
        }

        public final long component4() {
            return this.timestamp;
        }

        @NotNull
        public final IncomingWebSocketChannelFrozenMessage copy(@NotNull @Json(name = "channel_id") String str, @NotNull @Json(name = "message_id") String str2, @NotNull @Json(name = "event_type") EventType eventType2, @Json(name = "timestamp") long j11) {
            Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(str2, "messageId");
            Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            return new IncomingWebSocketChannelFrozenMessage(str, str2, eventType2, j11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IncomingWebSocketChannelFrozenMessage)) {
                return false;
            }
            IncomingWebSocketChannelFrozenMessage incomingWebSocketChannelFrozenMessage = (IncomingWebSocketChannelFrozenMessage) obj;
            return Intrinsics.areEqual((Object) this.channelId, (Object) incomingWebSocketChannelFrozenMessage.channelId) && Intrinsics.areEqual((Object) this.messageId, (Object) incomingWebSocketChannelFrozenMessage.messageId) && this.eventType == incomingWebSocketChannelFrozenMessage.eventType && this.timestamp == incomingWebSocketChannelFrozenMessage.timestamp;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final EventType getEventType() {
            return this.eventType;
        }

        @NotNull
        public final String getMessageId() {
            return this.messageId;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return (((((this.channelId.hashCode() * 31) + this.messageId.hashCode()) * 31) + this.eventType.hashCode()) * 31) + a.a(this.timestamp);
        }

        @NotNull
        public String toString() {
            return "IncomingWebSocketChannelFrozenMessage(channelId=" + this.channelId + ", messageId=" + this.messageId + ", eventType=" + this.eventType + ", timestamp=" + this.timestamp + ')';
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000eHÆ\u0003JW\u0010#\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00032\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketConfigMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage;", "messageId", "", "channelId", "eventType", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "timestamp", "", "correlationId", "configs", "", "Lcom/deliveryhero/chatsdk/network/websocket/model/ConfigData;", "metadata", "Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "(Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;JLjava/lang/String;Ljava/util/List;Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;)V", "getChannelId", "()Ljava/lang/String;", "getConfigs", "()Ljava/util/List;", "getCorrelationId", "getEventType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "getMessageId", "getMetadata", "()Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class IncomingWebSocketConfigMessage extends IncomingWebSocketMessage {
        @NotNull
        private final String channelId;
        @NotNull
        private final List<ConfigData> configs;
        @NotNull
        private final String correlationId;
        @NotNull
        private final EventType eventType;
        @NotNull
        private final String messageId;
        @Nullable
        private final MetaDataContent metadata;
        private final long timestamp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncomingWebSocketConfigMessage(@NotNull @Json(name = "message_id") String str, @NotNull @Json(name = "channel_id") String str2, @NotNull @Json(name = "event_type") EventType eventType2, @Json(name = "timestamp") long j11, @NotNull @Json(name = "correlation_id") String str3, @NotNull @Json(name = "configs") List<ConfigData> list, @Nullable @Json(name = "meta") MetaDataContent metaDataContent) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "messageId");
            Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(str3, "correlationId");
            Intrinsics.checkNotNullParameter(list, "configs");
            this.messageId = str;
            this.channelId = str2;
            this.eventType = eventType2;
            this.timestamp = j11;
            this.correlationId = str3;
            this.configs = list;
            this.metadata = metaDataContent;
        }

        public static /* synthetic */ IncomingWebSocketConfigMessage copy$default(IncomingWebSocketConfigMessage incomingWebSocketConfigMessage, String str, String str2, EventType eventType2, long j11, String str3, List list, MetaDataContent metaDataContent, int i11, Object obj) {
            IncomingWebSocketConfigMessage incomingWebSocketConfigMessage2 = incomingWebSocketConfigMessage;
            return incomingWebSocketConfigMessage.copy((i11 & 1) != 0 ? incomingWebSocketConfigMessage2.messageId : str, (i11 & 2) != 0 ? incomingWebSocketConfigMessage2.channelId : str2, (i11 & 4) != 0 ? incomingWebSocketConfigMessage2.eventType : eventType2, (i11 & 8) != 0 ? incomingWebSocketConfigMessage2.timestamp : j11, (i11 & 16) != 0 ? incomingWebSocketConfigMessage2.correlationId : str3, (i11 & 32) != 0 ? incomingWebSocketConfigMessage2.configs : list, (i11 & 64) != 0 ? incomingWebSocketConfigMessage2.metadata : metaDataContent);
        }

        @NotNull
        public final String component1() {
            return this.messageId;
        }

        @NotNull
        public final String component2() {
            return this.channelId;
        }

        @NotNull
        public final EventType component3() {
            return this.eventType;
        }

        public final long component4() {
            return this.timestamp;
        }

        @NotNull
        public final String component5() {
            return this.correlationId;
        }

        @NotNull
        public final List<ConfigData> component6() {
            return this.configs;
        }

        @Nullable
        public final MetaDataContent component7() {
            return this.metadata;
        }

        @NotNull
        public final IncomingWebSocketConfigMessage copy(@NotNull @Json(name = "message_id") String str, @NotNull @Json(name = "channel_id") String str2, @NotNull @Json(name = "event_type") EventType eventType2, @Json(name = "timestamp") long j11, @NotNull @Json(name = "correlation_id") String str3, @NotNull @Json(name = "configs") List<ConfigData> list, @Nullable @Json(name = "meta") MetaDataContent metaDataContent) {
            Intrinsics.checkNotNullParameter(str, "messageId");
            Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            String str4 = str3;
            Intrinsics.checkNotNullParameter(str4, "correlationId");
            List<ConfigData> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "configs");
            return new IncomingWebSocketConfigMessage(str, str2, eventType2, j11, str4, list2, metaDataContent);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IncomingWebSocketConfigMessage)) {
                return false;
            }
            IncomingWebSocketConfigMessage incomingWebSocketConfigMessage = (IncomingWebSocketConfigMessage) obj;
            return Intrinsics.areEqual((Object) this.messageId, (Object) incomingWebSocketConfigMessage.messageId) && Intrinsics.areEqual((Object) this.channelId, (Object) incomingWebSocketConfigMessage.channelId) && this.eventType == incomingWebSocketConfigMessage.eventType && this.timestamp == incomingWebSocketConfigMessage.timestamp && Intrinsics.areEqual((Object) this.correlationId, (Object) incomingWebSocketConfigMessage.correlationId) && Intrinsics.areEqual((Object) this.configs, (Object) incomingWebSocketConfigMessage.configs) && Intrinsics.areEqual((Object) this.metadata, (Object) incomingWebSocketConfigMessage.metadata);
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final List<ConfigData> getConfigs() {
            return this.configs;
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
        public final String getMessageId() {
            return this.messageId;
        }

        @Nullable
        public final MetaDataContent getMetadata() {
            return this.metadata;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            int hashCode = ((((((((((this.messageId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.eventType.hashCode()) * 31) + a.a(this.timestamp)) * 31) + this.correlationId.hashCode()) * 31) + this.configs.hashCode()) * 31;
            MetaDataContent metaDataContent = this.metadata;
            return hashCode + (metaDataContent == null ? 0 : metaDataContent.hashCode());
        }

        @NotNull
        public String toString() {
            return "IncomingWebSocketConfigMessage(messageId=" + this.messageId + ", channelId=" + this.channelId + ", eventType=" + this.eventType + ", timestamp=" + this.timestamp + ", correlationId=" + this.correlationId + ", configs=" + this.configs + ", metadata=" + this.metadata + ')';
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketConfigUpdateMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage;", "channelId", "", "messageId", "eventType", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "timestamp", "", "metadata", "Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "(Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;JLcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;)V", "getChannelId", "()Ljava/lang/String;", "getEventType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "getMessageId", "getMetadata", "()Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class IncomingWebSocketConfigUpdateMessage extends IncomingWebSocketMessage {
        @NotNull
        private final String channelId;
        @NotNull
        private final EventType eventType;
        @NotNull
        private final String messageId;
        @Nullable
        private final MetaDataContent metadata;
        private final long timestamp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncomingWebSocketConfigUpdateMessage(@NotNull @Json(name = "channel_id") String str, @NotNull @Json(name = "message_id") String str2, @NotNull @Json(name = "event_type") EventType eventType2, @Json(name = "timestamp") long j11, @Nullable @Json(name = "meta") MetaDataContent metaDataContent) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(str2, "messageId");
            Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            this.channelId = str;
            this.messageId = str2;
            this.eventType = eventType2;
            this.timestamp = j11;
            this.metadata = metaDataContent;
        }

        public static /* synthetic */ IncomingWebSocketConfigUpdateMessage copy$default(IncomingWebSocketConfigUpdateMessage incomingWebSocketConfigUpdateMessage, String str, String str2, EventType eventType2, long j11, MetaDataContent metaDataContent, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = incomingWebSocketConfigUpdateMessage.channelId;
            }
            if ((i11 & 2) != 0) {
                str2 = incomingWebSocketConfigUpdateMessage.messageId;
            }
            String str3 = str2;
            if ((i11 & 4) != 0) {
                eventType2 = incomingWebSocketConfigUpdateMessage.eventType;
            }
            EventType eventType3 = eventType2;
            if ((i11 & 8) != 0) {
                j11 = incomingWebSocketConfigUpdateMessage.timestamp;
            }
            long j12 = j11;
            if ((i11 & 16) != 0) {
                metaDataContent = incomingWebSocketConfigUpdateMessage.metadata;
            }
            return incomingWebSocketConfigUpdateMessage.copy(str, str3, eventType3, j12, metaDataContent);
        }

        @NotNull
        public final String component1() {
            return this.channelId;
        }

        @NotNull
        public final String component2() {
            return this.messageId;
        }

        @NotNull
        public final EventType component3() {
            return this.eventType;
        }

        public final long component4() {
            return this.timestamp;
        }

        @Nullable
        public final MetaDataContent component5() {
            return this.metadata;
        }

        @NotNull
        public final IncomingWebSocketConfigUpdateMessage copy(@NotNull @Json(name = "channel_id") String str, @NotNull @Json(name = "message_id") String str2, @NotNull @Json(name = "event_type") EventType eventType2, @Json(name = "timestamp") long j11, @Nullable @Json(name = "meta") MetaDataContent metaDataContent) {
            Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(str2, "messageId");
            Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            return new IncomingWebSocketConfigUpdateMessage(str, str2, eventType2, j11, metaDataContent);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IncomingWebSocketConfigUpdateMessage)) {
                return false;
            }
            IncomingWebSocketConfigUpdateMessage incomingWebSocketConfigUpdateMessage = (IncomingWebSocketConfigUpdateMessage) obj;
            return Intrinsics.areEqual((Object) this.channelId, (Object) incomingWebSocketConfigUpdateMessage.channelId) && Intrinsics.areEqual((Object) this.messageId, (Object) incomingWebSocketConfigUpdateMessage.messageId) && this.eventType == incomingWebSocketConfigUpdateMessage.eventType && this.timestamp == incomingWebSocketConfigUpdateMessage.timestamp && Intrinsics.areEqual((Object) this.metadata, (Object) incomingWebSocketConfigUpdateMessage.metadata);
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final EventType getEventType() {
            return this.eventType;
        }

        @NotNull
        public final String getMessageId() {
            return this.messageId;
        }

        @Nullable
        public final MetaDataContent getMetadata() {
            return this.metadata;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            int hashCode = ((((((this.channelId.hashCode() * 31) + this.messageId.hashCode()) * 31) + this.eventType.hashCode()) * 31) + a.a(this.timestamp)) * 31;
            MetaDataContent metaDataContent = this.metadata;
            return hashCode + (metaDataContent == null ? 0 : metaDataContent.hashCode());
        }

        @NotNull
        public String toString() {
            return "IncomingWebSocketConfigUpdateMessage(channelId=" + this.channelId + ", messageId=" + this.messageId + ", eventType=" + this.eventType + ", timestamp=" + this.timestamp + ", metadata=" + this.metadata + ')';
        }
    }

    private IncomingWebSocketMessage() {
    }

    public /* synthetic */ IncomingWebSocketMessage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
