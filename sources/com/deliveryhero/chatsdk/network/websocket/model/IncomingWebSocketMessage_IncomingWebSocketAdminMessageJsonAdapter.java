package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage_IncomingWebSocketAdminMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketAdminMessage;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "contentAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketAdminMessage$Content;", "eventTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "longAdapter", "", "nullableMetaDataContentAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IncomingWebSocketMessage_IncomingWebSocketAdminMessageJsonAdapter extends JsonAdapter<IncomingWebSocketMessage.IncomingWebSocketAdminMessage> {
    @NotNull
    private final JsonAdapter<IncomingWebSocketMessage.IncomingWebSocketAdminMessage.Content> contentAdapter;
    @NotNull
    private final JsonAdapter<EventType> eventTypeAdapter;
    @NotNull
    private final JsonAdapter<Long> longAdapter;
    @NotNull
    private final JsonAdapter<MetaDataContent> nullableMetaDataContentAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public IncomingWebSocketMessage_IncomingWebSocketAdminMessageJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("content", "event_type", "timestamp", "message_id", PushNotificationParser.CHANNEL_ID_KEY, "meta");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"content\", \"event_typ…d\", \"channel_id\", \"meta\")");
        this.options = of2;
        JsonAdapter<IncomingWebSocketMessage.IncomingWebSocketAdminMessage.Content> adapter = moshi.adapter(IncomingWebSocketMessage.IncomingWebSocketAdminMessage.Content.class, SetsKt__SetsKt.emptySet(), "content");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(IncomingWe…   emptySet(), \"content\")");
        this.contentAdapter = adapter;
        JsonAdapter<EventType> adapter2 = moshi.adapter(EventType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(EventType:… emptySet(), \"eventType\")");
        this.eventTypeAdapter = adapter2;
        JsonAdapter<Long> adapter3 = moshi.adapter(Long.TYPE, SetsKt__SetsKt.emptySet(), "timestamp");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Long::clas…Set(),\n      \"timestamp\")");
        this.longAdapter = adapter3;
        JsonAdapter<String> adapter4 = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "messageId");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(String::cl…Set(),\n      \"messageId\")");
        this.stringAdapter = adapter4;
        JsonAdapter<MetaDataContent> adapter5 = moshi.adapter(MetaDataContent.class, SetsKt__SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(MetaDataCo…, emptySet(), \"metadata\")");
        this.nullableMetaDataContentAdapter = adapter5;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(76);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("IncomingWebSocketMessage.IncomingWebSocketAdminMessage");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public IncomingWebSocketMessage.IncomingWebSocketAdminMessage fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        Long l11 = null;
        IncomingWebSocketMessage.IncomingWebSocketAdminMessage.Content content = null;
        EventType eventType = null;
        String str = null;
        String str2 = null;
        MetaDataContent metaDataContent = null;
        while (true) {
            MetaDataContent metaDataContent2 = metaDataContent;
            if (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(this.options)) {
                    case -1:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                    case 0:
                        content = this.contentAdapter.fromJson(jsonReader2);
                        if (content == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("content", "content", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"content\"…       \"content\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        eventType = this.eventTypeAdapter.fromJson(jsonReader2);
                        if (eventType == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, "event_type", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"eventTyp…    \"event_type\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        l11 = this.longAdapter.fromJson(jsonReader2);
                        if (l11 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("timestamp", "timestamp", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"timestam…     \"timestamp\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        str = this.stringAdapter.fromJson(jsonReader2);
                        if (str == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("messageId", "message_id", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"messageI…    \"message_id\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        str2 = this.stringAdapter.fromJson(jsonReader2);
                        if (str2 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull(RemoteMessageConst.Notification.CHANNEL_ID, PushNotificationParser.CHANNEL_ID_KEY, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"channelI…    \"channel_id\", reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        metaDataContent = this.nullableMetaDataContentAdapter.fromJson(jsonReader2);
                        continue;
                }
                metaDataContent = metaDataContent2;
            } else {
                jsonReader.endObject();
                if (content == null) {
                    JsonDataException missingProperty = Util.missingProperty("content", "content", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"content\", \"content\", reader)");
                    throw missingProperty;
                } else if (eventType == null) {
                    JsonDataException missingProperty2 = Util.missingProperty(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, "event_type", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"eventType\", \"event_type\", reader)");
                    throw missingProperty2;
                } else if (l11 != null) {
                    long longValue = l11.longValue();
                    if (str == null) {
                        JsonDataException missingProperty3 = Util.missingProperty("messageId", "message_id", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"messageId\", \"message_id\", reader)");
                        throw missingProperty3;
                    } else if (str2 != null) {
                        return new IncomingWebSocketMessage.IncomingWebSocketAdminMessage(content, eventType, longValue, str, str2, metaDataContent2);
                    } else {
                        JsonDataException missingProperty4 = Util.missingProperty(RemoteMessageConst.Notification.CHANNEL_ID, PushNotificationParser.CHANNEL_ID_KEY, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"channelId\", \"channel_id\", reader)");
                        throw missingProperty4;
                    }
                } else {
                    JsonDataException missingProperty5 = Util.missingProperty("timestamp", "timestamp", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"timestamp\", \"timestamp\", reader)");
                    throw missingProperty5;
                }
            }
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable IncomingWebSocketMessage.IncomingWebSocketAdminMessage incomingWebSocketAdminMessage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (incomingWebSocketAdminMessage != null) {
            jsonWriter.beginObject();
            jsonWriter.name("content");
            this.contentAdapter.toJson(jsonWriter, incomingWebSocketAdminMessage.getContent());
            jsonWriter.name("event_type");
            this.eventTypeAdapter.toJson(jsonWriter, incomingWebSocketAdminMessage.getEventType());
            jsonWriter.name("timestamp");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(incomingWebSocketAdminMessage.getTimestamp()));
            jsonWriter.name("message_id");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketAdminMessage.getMessageId());
            jsonWriter.name(PushNotificationParser.CHANNEL_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketAdminMessage.getChannelId());
            jsonWriter.name("meta");
            this.nullableMetaDataContentAdapter.toJson(jsonWriter, incomingWebSocketAdminMessage.getMetadata());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
