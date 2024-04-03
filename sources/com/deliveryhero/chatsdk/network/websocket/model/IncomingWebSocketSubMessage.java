package com.deliveryhero.chatsdk.network.websocket.model;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage;", "()V", "IncomingWebSocketFileMessage", "IncomingWebSocketLocationMessage", "IncomingWebSocketTextMessage", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage$IncomingWebSocketTextMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage$IncomingWebSocketFileMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage$IncomingWebSocketLocationMessage;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class IncomingWebSocketSubMessage extends IncomingWebSocketMessage {

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0011HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\u000bHÆ\u0003J\t\u00102\u001a\u00020\rHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u0001\u00105\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\u00032\b\b\u0003\u0010\u000f\u001a\u00020\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006="}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage$IncomingWebSocketFileMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage;", "messageId", "", "channelId", "content", "messageType", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;", "image", "Lcom/deliveryhero/chatsdk/network/websocket/model/FileContent;", "eventType", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "contentType", "Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "senderId", "senderNickname", "timestamp", "", "metadata", "Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;Lcom/deliveryhero/chatsdk/network/websocket/model/FileContent;Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;Ljava/lang/String;Ljava/lang/String;JLcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getContent", "getContentType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "getCorrelationId", "getEventType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "getImage", "()Lcom/deliveryhero/chatsdk/network/websocket/model/FileContent;", "getMessageId", "getMessageType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;", "getMetadata", "()Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "getSenderId", "getSenderNickname", "getTimestamp", "()J", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class IncomingWebSocketFileMessage extends IncomingWebSocketSubMessage {
        @NotNull
        private final String channelId;
        @NotNull
        private final String content;
        @NotNull
        private final ContentType contentType;
        @Nullable
        private final String correlationId;
        @NotNull
        private final EventType eventType;
        @NotNull
        private final FileContent image;
        @NotNull
        private final String messageId;
        @NotNull
        private final MessageType messageType;
        @Nullable
        private final MetaDataContent metadata;
        @NotNull
        private final String senderId;
        @NotNull
        private final String senderNickname;
        private final long timestamp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncomingWebSocketFileMessage(@NotNull @Json(name = "message_id") String str, @NotNull @Json(name = "channel_id") String str2, @NotNull @Json(name = "content") String str3, @NotNull @Json(name = "message_type") MessageType messageType2, @NotNull @Json(name = "image") FileContent fileContent, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "content_type") ContentType contentType2, @NotNull @Json(name = "sender_id") String str4, @NotNull @Json(name = "sender_nickname") String str5, @Json(name = "timestamp") long j11, @Nullable @Json(name = "meta") MetaDataContent metaDataContent, @Nullable @Json(name = "correlation_id") String str6) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "messageId");
            Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(str3, "content");
            Intrinsics.checkNotNullParameter(messageType2, "messageType");
            Intrinsics.checkNotNullParameter(fileContent, "image");
            Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(contentType2, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(str4, "senderId");
            Intrinsics.checkNotNullParameter(str5, "senderNickname");
            this.messageId = str;
            this.channelId = str2;
            this.content = str3;
            this.messageType = messageType2;
            this.image = fileContent;
            this.eventType = eventType2;
            this.contentType = contentType2;
            this.senderId = str4;
            this.senderNickname = str5;
            this.timestamp = j11;
            this.metadata = metaDataContent;
            this.correlationId = str6;
        }

        public static /* synthetic */ IncomingWebSocketFileMessage copy$default(IncomingWebSocketFileMessage incomingWebSocketFileMessage, String str, String str2, String str3, MessageType messageType2, FileContent fileContent, EventType eventType2, ContentType contentType2, String str4, String str5, long j11, MetaDataContent metaDataContent, String str6, int i11, Object obj) {
            IncomingWebSocketFileMessage incomingWebSocketFileMessage2 = incomingWebSocketFileMessage;
            int i12 = i11;
            return incomingWebSocketFileMessage.copy((i12 & 1) != 0 ? incomingWebSocketFileMessage2.messageId : str, (i12 & 2) != 0 ? incomingWebSocketFileMessage2.channelId : str2, (i12 & 4) != 0 ? incomingWebSocketFileMessage2.content : str3, (i12 & 8) != 0 ? incomingWebSocketFileMessage2.messageType : messageType2, (i12 & 16) != 0 ? incomingWebSocketFileMessage2.image : fileContent, (i12 & 32) != 0 ? incomingWebSocketFileMessage2.eventType : eventType2, (i12 & 64) != 0 ? incomingWebSocketFileMessage2.contentType : contentType2, (i12 & 128) != 0 ? incomingWebSocketFileMessage2.senderId : str4, (i12 & 256) != 0 ? incomingWebSocketFileMessage2.senderNickname : str5, (i12 & 512) != 0 ? incomingWebSocketFileMessage2.timestamp : j11, (i12 & 1024) != 0 ? incomingWebSocketFileMessage2.metadata : metaDataContent, (i12 & 2048) != 0 ? incomingWebSocketFileMessage2.correlationId : str6);
        }

        @NotNull
        public final String component1() {
            return this.messageId;
        }

        public final long component10() {
            return this.timestamp;
        }

        @Nullable
        public final MetaDataContent component11() {
            return this.metadata;
        }

        @Nullable
        public final String component12() {
            return this.correlationId;
        }

        @NotNull
        public final String component2() {
            return this.channelId;
        }

        @NotNull
        public final String component3() {
            return this.content;
        }

        @NotNull
        public final MessageType component4() {
            return this.messageType;
        }

        @NotNull
        public final FileContent component5() {
            return this.image;
        }

        @NotNull
        public final EventType component6() {
            return this.eventType;
        }

        @NotNull
        public final ContentType component7() {
            return this.contentType;
        }

        @NotNull
        public final String component8() {
            return this.senderId;
        }

        @NotNull
        public final String component9() {
            return this.senderNickname;
        }

        @NotNull
        public final IncomingWebSocketFileMessage copy(@NotNull @Json(name = "message_id") String str, @NotNull @Json(name = "channel_id") String str2, @NotNull @Json(name = "content") String str3, @NotNull @Json(name = "message_type") MessageType messageType2, @NotNull @Json(name = "image") FileContent fileContent, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "content_type") ContentType contentType2, @NotNull @Json(name = "sender_id") String str4, @NotNull @Json(name = "sender_nickname") String str5, @Json(name = "timestamp") long j11, @Nullable @Json(name = "meta") MetaDataContent metaDataContent, @Nullable @Json(name = "correlation_id") String str6) {
            String str7 = str;
            Intrinsics.checkNotNullParameter(str7, "messageId");
            String str8 = str2;
            Intrinsics.checkNotNullParameter(str8, RemoteMessageConst.Notification.CHANNEL_ID);
            String str9 = str3;
            Intrinsics.checkNotNullParameter(str9, "content");
            MessageType messageType3 = messageType2;
            Intrinsics.checkNotNullParameter(messageType3, "messageType");
            FileContent fileContent2 = fileContent;
            Intrinsics.checkNotNullParameter(fileContent2, "image");
            EventType eventType3 = eventType2;
            Intrinsics.checkNotNullParameter(eventType3, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            ContentType contentType3 = contentType2;
            Intrinsics.checkNotNullParameter(contentType3, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
            String str10 = str4;
            Intrinsics.checkNotNullParameter(str10, "senderId");
            String str11 = str5;
            Intrinsics.checkNotNullParameter(str11, "senderNickname");
            return new IncomingWebSocketFileMessage(str7, str8, str9, messageType3, fileContent2, eventType3, contentType3, str10, str11, j11, metaDataContent, str6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IncomingWebSocketFileMessage)) {
                return false;
            }
            IncomingWebSocketFileMessage incomingWebSocketFileMessage = (IncomingWebSocketFileMessage) obj;
            return Intrinsics.areEqual((Object) this.messageId, (Object) incomingWebSocketFileMessage.messageId) && Intrinsics.areEqual((Object) this.channelId, (Object) incomingWebSocketFileMessage.channelId) && Intrinsics.areEqual((Object) this.content, (Object) incomingWebSocketFileMessage.content) && this.messageType == incomingWebSocketFileMessage.messageType && Intrinsics.areEqual((Object) this.image, (Object) incomingWebSocketFileMessage.image) && this.eventType == incomingWebSocketFileMessage.eventType && this.contentType == incomingWebSocketFileMessage.contentType && Intrinsics.areEqual((Object) this.senderId, (Object) incomingWebSocketFileMessage.senderId) && Intrinsics.areEqual((Object) this.senderNickname, (Object) incomingWebSocketFileMessage.senderNickname) && this.timestamp == incomingWebSocketFileMessage.timestamp && Intrinsics.areEqual((Object) this.metadata, (Object) incomingWebSocketFileMessage.metadata) && Intrinsics.areEqual((Object) this.correlationId, (Object) incomingWebSocketFileMessage.correlationId);
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

        @Nullable
        public final String getCorrelationId() {
            return this.correlationId;
        }

        @NotNull
        public final EventType getEventType() {
            return this.eventType;
        }

        @NotNull
        public final FileContent getImage() {
            return this.image;
        }

        @NotNull
        public final String getMessageId() {
            return this.messageId;
        }

        @NotNull
        public final MessageType getMessageType() {
            return this.messageType;
        }

        @Nullable
        public final MetaDataContent getMetadata() {
            return this.metadata;
        }

        @NotNull
        public final String getSenderId() {
            return this.senderId;
        }

        @NotNull
        public final String getSenderNickname() {
            return this.senderNickname;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((((((this.messageId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.content.hashCode()) * 31) + this.messageType.hashCode()) * 31) + this.image.hashCode()) * 31) + this.eventType.hashCode()) * 31) + this.contentType.hashCode()) * 31) + this.senderId.hashCode()) * 31) + this.senderNickname.hashCode()) * 31) + a.a(this.timestamp)) * 31;
            MetaDataContent metaDataContent = this.metadata;
            int i11 = 0;
            int hashCode2 = (hashCode + (metaDataContent == null ? 0 : metaDataContent.hashCode())) * 31;
            String str = this.correlationId;
            if (str != null) {
                i11 = str.hashCode();
            }
            return hashCode2 + i11;
        }

        @NotNull
        public String toString() {
            return "IncomingWebSocketFileMessage(messageId=" + this.messageId + ", channelId=" + this.channelId + ", content=" + this.content + ", messageType=" + this.messageType + ", image=" + this.image + ", eventType=" + this.eventType + ", contentType=" + this.contentType + ", senderId=" + this.senderId + ", senderNickname=" + this.senderNickname + ", timestamp=" + this.timestamp + ", metadata=" + this.metadata + ", correlationId=" + this.correlationId + ')';
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J{\u00100\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00068"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage$IncomingWebSocketLocationMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage;", "messageId", "", "channelId", "content", "messageType", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;", "location", "Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContent;", "eventType", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "senderId", "senderNickname", "timestamp", "", "metadata", "Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContent;Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;Ljava/lang/String;Ljava/lang/String;JLcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getContent", "getCorrelationId", "getEventType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "getLocation", "()Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContent;", "getMessageId", "getMessageType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;", "getMetadata", "()Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "getSenderId", "getSenderNickname", "getTimestamp", "()J", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class IncomingWebSocketLocationMessage extends IncomingWebSocketSubMessage {
        @NotNull
        private final String channelId;
        @NotNull
        private final String content;
        @Nullable
        private final String correlationId;
        @NotNull
        private final EventType eventType;
        @NotNull
        private final LocationContent location;
        @NotNull
        private final String messageId;
        @NotNull
        private final MessageType messageType;
        @Nullable
        private final MetaDataContent metadata;
        @NotNull
        private final String senderId;
        @NotNull
        private final String senderNickname;
        private final long timestamp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncomingWebSocketLocationMessage(@NotNull @Json(name = "message_id") String str, @NotNull @Json(name = "channel_id") String str2, @NotNull @Json(name = "content") String str3, @NotNull @Json(name = "message_type") MessageType messageType2, @NotNull @Json(name = "location") LocationContent locationContent, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "sender_id") String str4, @NotNull @Json(name = "sender_nickname") String str5, @Json(name = "timestamp") long j11, @Nullable @Json(name = "meta") MetaDataContent metaDataContent, @Nullable @Json(name = "correlation_id") String str6) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "messageId");
            Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(str3, "content");
            Intrinsics.checkNotNullParameter(messageType2, "messageType");
            Intrinsics.checkNotNullParameter(locationContent, "location");
            Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(str4, "senderId");
            Intrinsics.checkNotNullParameter(str5, "senderNickname");
            this.messageId = str;
            this.channelId = str2;
            this.content = str3;
            this.messageType = messageType2;
            this.location = locationContent;
            this.eventType = eventType2;
            this.senderId = str4;
            this.senderNickname = str5;
            this.timestamp = j11;
            this.metadata = metaDataContent;
            this.correlationId = str6;
        }

        public static /* synthetic */ IncomingWebSocketLocationMessage copy$default(IncomingWebSocketLocationMessage incomingWebSocketLocationMessage, String str, String str2, String str3, MessageType messageType2, LocationContent locationContent, EventType eventType2, String str4, String str5, long j11, MetaDataContent metaDataContent, String str6, int i11, Object obj) {
            IncomingWebSocketLocationMessage incomingWebSocketLocationMessage2 = incomingWebSocketLocationMessage;
            int i12 = i11;
            return incomingWebSocketLocationMessage.copy((i12 & 1) != 0 ? incomingWebSocketLocationMessage2.messageId : str, (i12 & 2) != 0 ? incomingWebSocketLocationMessage2.channelId : str2, (i12 & 4) != 0 ? incomingWebSocketLocationMessage2.content : str3, (i12 & 8) != 0 ? incomingWebSocketLocationMessage2.messageType : messageType2, (i12 & 16) != 0 ? incomingWebSocketLocationMessage2.location : locationContent, (i12 & 32) != 0 ? incomingWebSocketLocationMessage2.eventType : eventType2, (i12 & 64) != 0 ? incomingWebSocketLocationMessage2.senderId : str4, (i12 & 128) != 0 ? incomingWebSocketLocationMessage2.senderNickname : str5, (i12 & 256) != 0 ? incomingWebSocketLocationMessage2.timestamp : j11, (i12 & 512) != 0 ? incomingWebSocketLocationMessage2.metadata : metaDataContent, (i12 & 1024) != 0 ? incomingWebSocketLocationMessage2.correlationId : str6);
        }

        @NotNull
        public final String component1() {
            return this.messageId;
        }

        @Nullable
        public final MetaDataContent component10() {
            return this.metadata;
        }

        @Nullable
        public final String component11() {
            return this.correlationId;
        }

        @NotNull
        public final String component2() {
            return this.channelId;
        }

        @NotNull
        public final String component3() {
            return this.content;
        }

        @NotNull
        public final MessageType component4() {
            return this.messageType;
        }

        @NotNull
        public final LocationContent component5() {
            return this.location;
        }

        @NotNull
        public final EventType component6() {
            return this.eventType;
        }

        @NotNull
        public final String component7() {
            return this.senderId;
        }

        @NotNull
        public final String component8() {
            return this.senderNickname;
        }

        public final long component9() {
            return this.timestamp;
        }

        @NotNull
        public final IncomingWebSocketLocationMessage copy(@NotNull @Json(name = "message_id") String str, @NotNull @Json(name = "channel_id") String str2, @NotNull @Json(name = "content") String str3, @NotNull @Json(name = "message_type") MessageType messageType2, @NotNull @Json(name = "location") LocationContent locationContent, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "sender_id") String str4, @NotNull @Json(name = "sender_nickname") String str5, @Json(name = "timestamp") long j11, @Nullable @Json(name = "meta") MetaDataContent metaDataContent, @Nullable @Json(name = "correlation_id") String str6) {
            Intrinsics.checkNotNullParameter(str, "messageId");
            String str7 = str2;
            Intrinsics.checkNotNullParameter(str7, RemoteMessageConst.Notification.CHANNEL_ID);
            String str8 = str3;
            Intrinsics.checkNotNullParameter(str8, "content");
            MessageType messageType3 = messageType2;
            Intrinsics.checkNotNullParameter(messageType3, "messageType");
            LocationContent locationContent2 = locationContent;
            Intrinsics.checkNotNullParameter(locationContent2, "location");
            EventType eventType3 = eventType2;
            Intrinsics.checkNotNullParameter(eventType3, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            String str9 = str4;
            Intrinsics.checkNotNullParameter(str9, "senderId");
            String str10 = str5;
            Intrinsics.checkNotNullParameter(str10, "senderNickname");
            return new IncomingWebSocketLocationMessage(str, str7, str8, messageType3, locationContent2, eventType3, str9, str10, j11, metaDataContent, str6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IncomingWebSocketLocationMessage)) {
                return false;
            }
            IncomingWebSocketLocationMessage incomingWebSocketLocationMessage = (IncomingWebSocketLocationMessage) obj;
            return Intrinsics.areEqual((Object) this.messageId, (Object) incomingWebSocketLocationMessage.messageId) && Intrinsics.areEqual((Object) this.channelId, (Object) incomingWebSocketLocationMessage.channelId) && Intrinsics.areEqual((Object) this.content, (Object) incomingWebSocketLocationMessage.content) && this.messageType == incomingWebSocketLocationMessage.messageType && Intrinsics.areEqual((Object) this.location, (Object) incomingWebSocketLocationMessage.location) && this.eventType == incomingWebSocketLocationMessage.eventType && Intrinsics.areEqual((Object) this.senderId, (Object) incomingWebSocketLocationMessage.senderId) && Intrinsics.areEqual((Object) this.senderNickname, (Object) incomingWebSocketLocationMessage.senderNickname) && this.timestamp == incomingWebSocketLocationMessage.timestamp && Intrinsics.areEqual((Object) this.metadata, (Object) incomingWebSocketLocationMessage.metadata) && Intrinsics.areEqual((Object) this.correlationId, (Object) incomingWebSocketLocationMessage.correlationId);
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final String getContent() {
            return this.content;
        }

        @Nullable
        public final String getCorrelationId() {
            return this.correlationId;
        }

        @NotNull
        public final EventType getEventType() {
            return this.eventType;
        }

        @NotNull
        public final LocationContent getLocation() {
            return this.location;
        }

        @NotNull
        public final String getMessageId() {
            return this.messageId;
        }

        @NotNull
        public final MessageType getMessageType() {
            return this.messageType;
        }

        @Nullable
        public final MetaDataContent getMetadata() {
            return this.metadata;
        }

        @NotNull
        public final String getSenderId() {
            return this.senderId;
        }

        @NotNull
        public final String getSenderNickname() {
            return this.senderNickname;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((((this.messageId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.content.hashCode()) * 31) + this.messageType.hashCode()) * 31) + this.location.hashCode()) * 31) + this.eventType.hashCode()) * 31) + this.senderId.hashCode()) * 31) + this.senderNickname.hashCode()) * 31) + a.a(this.timestamp)) * 31;
            MetaDataContent metaDataContent = this.metadata;
            int i11 = 0;
            int hashCode2 = (hashCode + (metaDataContent == null ? 0 : metaDataContent.hashCode())) * 31;
            String str = this.correlationId;
            if (str != null) {
                i11 = str.hashCode();
            }
            return hashCode2 + i11;
        }

        @NotNull
        public String toString() {
            return "IncomingWebSocketLocationMessage(messageId=" + this.messageId + ", channelId=" + this.channelId + ", content=" + this.content + ", messageType=" + this.messageType + ", location=" + this.location + ", eventType=" + this.eventType + ", senderId=" + this.senderId + ", senderNickname=" + this.senderNickname + ", timestamp=" + this.timestamp + ", metadata=" + this.metadata + ", correlationId=" + this.correlationId + ')';
        }
    }

    private IncomingWebSocketSubMessage() {
        super((DefaultConstructorMarker) null);
    }

    public /* synthetic */ IncomingWebSocketSubMessage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f\u0012\u0014\b\u0003\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\u000bHÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003J\u0001\u00105\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u000f2\u0014\b\u0003\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006="}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage$IncomingWebSocketTextMessage;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage;", "messageId", "", "channelId", "content", "eventType", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "messageType", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;", "contentType", "Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "senderId", "senderNickname", "timestamp", "", "translations", "", "metadata", "Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getContent", "getContentType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "getCorrelationId", "getEventType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "getMessageId", "getMessageType", "()Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;", "getMetadata", "()Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "getSenderId", "getSenderNickname", "getTimestamp", "()J", "getTranslations", "()Ljava/util/Map;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class IncomingWebSocketTextMessage extends IncomingWebSocketSubMessage {
        @NotNull
        private final String channelId;
        @NotNull
        private final String content;
        @NotNull
        private final ContentType contentType;
        @Nullable
        private final String correlationId;
        @NotNull
        private final EventType eventType;
        @NotNull
        private final String messageId;
        @NotNull
        private final MessageType messageType;
        @Nullable
        private final MetaDataContent metadata;
        @NotNull
        private final String senderId;
        @NotNull
        private final String senderNickname;
        private final long timestamp;
        @NotNull
        private final Map<String, String> translations;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ IncomingWebSocketTextMessage(String str, String str2, String str3, EventType eventType2, MessageType messageType2, ContentType contentType2, String str4, String str5, long j11, Map map, MetaDataContent metaDataContent, String str6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, eventType2, messageType2, contentType2, str4, str5, j11, (i11 & 512) != 0 ? MapsKt__MapsKt.emptyMap() : map, metaDataContent, str6);
        }

        public static /* synthetic */ IncomingWebSocketTextMessage copy$default(IncomingWebSocketTextMessage incomingWebSocketTextMessage, String str, String str2, String str3, EventType eventType2, MessageType messageType2, ContentType contentType2, String str4, String str5, long j11, Map map, MetaDataContent metaDataContent, String str6, int i11, Object obj) {
            IncomingWebSocketTextMessage incomingWebSocketTextMessage2 = incomingWebSocketTextMessage;
            int i12 = i11;
            return incomingWebSocketTextMessage.copy((i12 & 1) != 0 ? incomingWebSocketTextMessage2.messageId : str, (i12 & 2) != 0 ? incomingWebSocketTextMessage2.channelId : str2, (i12 & 4) != 0 ? incomingWebSocketTextMessage2.content : str3, (i12 & 8) != 0 ? incomingWebSocketTextMessage2.eventType : eventType2, (i12 & 16) != 0 ? incomingWebSocketTextMessage2.messageType : messageType2, (i12 & 32) != 0 ? incomingWebSocketTextMessage2.contentType : contentType2, (i12 & 64) != 0 ? incomingWebSocketTextMessage2.senderId : str4, (i12 & 128) != 0 ? incomingWebSocketTextMessage2.senderNickname : str5, (i12 & 256) != 0 ? incomingWebSocketTextMessage2.timestamp : j11, (i12 & 512) != 0 ? incomingWebSocketTextMessage2.translations : map, (i12 & 1024) != 0 ? incomingWebSocketTextMessage2.metadata : metaDataContent, (i12 & 2048) != 0 ? incomingWebSocketTextMessage2.correlationId : str6);
        }

        @NotNull
        public final String component1() {
            return this.messageId;
        }

        @NotNull
        public final Map<String, String> component10() {
            return this.translations;
        }

        @Nullable
        public final MetaDataContent component11() {
            return this.metadata;
        }

        @Nullable
        public final String component12() {
            return this.correlationId;
        }

        @NotNull
        public final String component2() {
            return this.channelId;
        }

        @NotNull
        public final String component3() {
            return this.content;
        }

        @NotNull
        public final EventType component4() {
            return this.eventType;
        }

        @NotNull
        public final MessageType component5() {
            return this.messageType;
        }

        @NotNull
        public final ContentType component6() {
            return this.contentType;
        }

        @NotNull
        public final String component7() {
            return this.senderId;
        }

        @NotNull
        public final String component8() {
            return this.senderNickname;
        }

        public final long component9() {
            return this.timestamp;
        }

        @NotNull
        public final IncomingWebSocketTextMessage copy(@NotNull @Json(name = "message_id") String str, @NotNull @Json(name = "channel_id") String str2, @NotNull @Json(name = "content") String str3, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "message_type") MessageType messageType2, @NotNull @Json(name = "content_type") ContentType contentType2, @NotNull @Json(name = "sender_id") String str4, @NotNull @Json(name = "sender_nickname") String str5, @Json(name = "timestamp") long j11, @NotNull @Json(name = "translations") Map<String, String> map, @Nullable @Json(name = "meta") MetaDataContent metaDataContent, @Nullable @Json(name = "correlation_id") String str6) {
            String str7 = str;
            Intrinsics.checkNotNullParameter(str7, "messageId");
            String str8 = str2;
            Intrinsics.checkNotNullParameter(str8, RemoteMessageConst.Notification.CHANNEL_ID);
            String str9 = str3;
            Intrinsics.checkNotNullParameter(str9, "content");
            EventType eventType3 = eventType2;
            Intrinsics.checkNotNullParameter(eventType3, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            MessageType messageType3 = messageType2;
            Intrinsics.checkNotNullParameter(messageType3, "messageType");
            ContentType contentType3 = contentType2;
            Intrinsics.checkNotNullParameter(contentType3, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
            String str10 = str4;
            Intrinsics.checkNotNullParameter(str10, "senderId");
            String str11 = str5;
            Intrinsics.checkNotNullParameter(str11, "senderNickname");
            Map<String, String> map2 = map;
            Intrinsics.checkNotNullParameter(map2, "translations");
            return new IncomingWebSocketTextMessage(str7, str8, str9, eventType3, messageType3, contentType3, str10, str11, j11, map2, metaDataContent, str6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IncomingWebSocketTextMessage)) {
                return false;
            }
            IncomingWebSocketTextMessage incomingWebSocketTextMessage = (IncomingWebSocketTextMessage) obj;
            return Intrinsics.areEqual((Object) this.messageId, (Object) incomingWebSocketTextMessage.messageId) && Intrinsics.areEqual((Object) this.channelId, (Object) incomingWebSocketTextMessage.channelId) && Intrinsics.areEqual((Object) this.content, (Object) incomingWebSocketTextMessage.content) && this.eventType == incomingWebSocketTextMessage.eventType && this.messageType == incomingWebSocketTextMessage.messageType && this.contentType == incomingWebSocketTextMessage.contentType && Intrinsics.areEqual((Object) this.senderId, (Object) incomingWebSocketTextMessage.senderId) && Intrinsics.areEqual((Object) this.senderNickname, (Object) incomingWebSocketTextMessage.senderNickname) && this.timestamp == incomingWebSocketTextMessage.timestamp && Intrinsics.areEqual((Object) this.translations, (Object) incomingWebSocketTextMessage.translations) && Intrinsics.areEqual((Object) this.metadata, (Object) incomingWebSocketTextMessage.metadata) && Intrinsics.areEqual((Object) this.correlationId, (Object) incomingWebSocketTextMessage.correlationId);
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

        @Nullable
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

        @NotNull
        public final MessageType getMessageType() {
            return this.messageType;
        }

        @Nullable
        public final MetaDataContent getMetadata() {
            return this.metadata;
        }

        @NotNull
        public final String getSenderId() {
            return this.senderId;
        }

        @NotNull
        public final String getSenderNickname() {
            return this.senderNickname;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        @NotNull
        public final Map<String, String> getTranslations() {
            return this.translations;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((((((this.messageId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.content.hashCode()) * 31) + this.eventType.hashCode()) * 31) + this.messageType.hashCode()) * 31) + this.contentType.hashCode()) * 31) + this.senderId.hashCode()) * 31) + this.senderNickname.hashCode()) * 31) + a.a(this.timestamp)) * 31) + this.translations.hashCode()) * 31;
            MetaDataContent metaDataContent = this.metadata;
            int i11 = 0;
            int hashCode2 = (hashCode + (metaDataContent == null ? 0 : metaDataContent.hashCode())) * 31;
            String str = this.correlationId;
            if (str != null) {
                i11 = str.hashCode();
            }
            return hashCode2 + i11;
        }

        @NotNull
        public String toString() {
            return "IncomingWebSocketTextMessage(messageId=" + this.messageId + ", channelId=" + this.channelId + ", content=" + this.content + ", eventType=" + this.eventType + ", messageType=" + this.messageType + ", contentType=" + this.contentType + ", senderId=" + this.senderId + ", senderNickname=" + this.senderNickname + ", timestamp=" + this.timestamp + ", translations=" + this.translations + ", metadata=" + this.metadata + ", correlationId=" + this.correlationId + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncomingWebSocketTextMessage(@NotNull @Json(name = "message_id") String str, @NotNull @Json(name = "channel_id") String str2, @NotNull @Json(name = "content") String str3, @NotNull @Json(name = "event_type") EventType eventType2, @NotNull @Json(name = "message_type") MessageType messageType2, @NotNull @Json(name = "content_type") ContentType contentType2, @NotNull @Json(name = "sender_id") String str4, @NotNull @Json(name = "sender_nickname") String str5, @Json(name = "timestamp") long j11, @NotNull @Json(name = "translations") Map<String, String> map, @Nullable @Json(name = "meta") MetaDataContent metaDataContent, @Nullable @Json(name = "correlation_id") String str6) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "messageId");
            Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(str3, "content");
            Intrinsics.checkNotNullParameter(eventType2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(messageType2, "messageType");
            Intrinsics.checkNotNullParameter(contentType2, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(str4, "senderId");
            Intrinsics.checkNotNullParameter(str5, "senderNickname");
            Intrinsics.checkNotNullParameter(map, "translations");
            this.messageId = str;
            this.channelId = str2;
            this.content = str3;
            this.eventType = eventType2;
            this.messageType = messageType2;
            this.contentType = contentType2;
            this.senderId = str4;
            this.senderNickname = str5;
            this.timestamp = j11;
            this.translations = map;
            this.metadata = metaDataContent;
            this.correlationId = str6;
        }
    }
}
