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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage_IncomingWebSocketChannelFrozenMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketChannelFrozenMessage;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "eventTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "longAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IncomingWebSocketMessage_IncomingWebSocketChannelFrozenMessageJsonAdapter extends JsonAdapter<IncomingWebSocketMessage.IncomingWebSocketChannelFrozenMessage> {
    @NotNull
    private final JsonAdapter<EventType> eventTypeAdapter;
    @NotNull
    private final JsonAdapter<Long> longAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public IncomingWebSocketMessage_IncomingWebSocketChannelFrozenMessageJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(PushNotificationParser.CHANNEL_ID_KEY, "message_id", "event_type", "timestamp");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"channel_id\", \"messag…event_type\", \"timestamp\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"channelId\")");
        this.stringAdapter = adapter;
        JsonAdapter<EventType> adapter2 = moshi.adapter(EventType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(EventType:… emptySet(), \"eventType\")");
        this.eventTypeAdapter = adapter2;
        JsonAdapter<Long> adapter3 = moshi.adapter(Long.TYPE, SetsKt__SetsKt.emptySet(), "timestamp");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Long::clas…Set(),\n      \"timestamp\")");
        this.longAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(84);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("IncomingWebSocketMessage.IncomingWebSocketChannelFrozenMessage");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public IncomingWebSocketMessage.IncomingWebSocketChannelFrozenMessage fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Long l11 = null;
        String str = null;
        String str2 = null;
        EventType eventType = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(RemoteMessageConst.Notification.CHANNEL_ID, PushNotificationParser.CHANNEL_ID_KEY, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"channelI…    \"channel_id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("messageId", "message_id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"messageI…    \"message_id\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                eventType = this.eventTypeAdapter.fromJson(jsonReader);
                if (eventType == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, "event_type", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"eventTyp…    \"event_type\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (l11 = this.longAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("timestamp", "timestamp", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"timestam…     \"timestamp\", reader)");
                throw unexpectedNull4;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(RemoteMessageConst.Notification.CHANNEL_ID, PushNotificationParser.CHANNEL_ID_KEY, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"channelId\", \"channel_id\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("messageId", "message_id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"messageId\", \"message_id\", reader)");
            throw missingProperty2;
        } else if (eventType == null) {
            JsonDataException missingProperty3 = Util.missingProperty(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, "event_type", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"eventType\", \"event_type\", reader)");
            throw missingProperty3;
        } else if (l11 != null) {
            return new IncomingWebSocketMessage.IncomingWebSocketChannelFrozenMessage(str, str2, eventType, l11.longValue());
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("timestamp", "timestamp", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"timestamp\", \"timestamp\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable IncomingWebSocketMessage.IncomingWebSocketChannelFrozenMessage incomingWebSocketChannelFrozenMessage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (incomingWebSocketChannelFrozenMessage != null) {
            jsonWriter.beginObject();
            jsonWriter.name(PushNotificationParser.CHANNEL_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketChannelFrozenMessage.getChannelId());
            jsonWriter.name("message_id");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketChannelFrozenMessage.getMessageId());
            jsonWriter.name("event_type");
            this.eventTypeAdapter.toJson(jsonWriter, incomingWebSocketChannelFrozenMessage.getEventType());
            jsonWriter.name("timestamp");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(incomingWebSocketChannelFrozenMessage.getTimestamp()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
