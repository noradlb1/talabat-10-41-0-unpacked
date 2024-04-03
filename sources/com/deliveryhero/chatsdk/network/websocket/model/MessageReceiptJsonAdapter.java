package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.deliveryhero.customerchat.eventTracking.constants.EventDetailsKeys;
import com.huawei.hms.push.constant.RemoteMessageConst;
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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReceiptJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReceipt;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "longAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessageReceiptJsonAdapter extends JsonAdapter<MessageReceipt> {
    @NotNull
    private final JsonAdapter<Long> longAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public MessageReceiptJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(PushNotificationParser.CHANNEL_ID_KEY, "timestamp", "message_id", EventDetailsKeys.CORRELATION_ID);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"channel_id\", \"timest…ge_id\", \"correlation_id\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"channelId\")");
        this.stringAdapter = adapter;
        JsonAdapter<Long> adapter2 = moshi.adapter(Long.TYPE, SetsKt__SetsKt.emptySet(), "timestamp");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Long::clas…Set(),\n      \"timestamp\")");
        this.longAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "messageId");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl… emptySet(), \"messageId\")");
        this.nullableStringAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(36);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("MessageReceipt");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public MessageReceipt fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Long l11 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
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
                l11 = this.longAdapter.fromJson(jsonReader);
                if (l11 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("timestamp", "timestamp", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"timestam…     \"timestamp\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 3) {
                str3 = this.nullableStringAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(RemoteMessageConst.Notification.CHANNEL_ID, PushNotificationParser.CHANNEL_ID_KEY, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"channelId\", \"channel_id\", reader)");
            throw missingProperty;
        } else if (l11 != null) {
            return new MessageReceipt(str, l11.longValue(), str2, str3);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("timestamp", "timestamp", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"timestamp\", \"timestamp\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable MessageReceipt messageReceipt) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messageReceipt != null) {
            jsonWriter.beginObject();
            jsonWriter.name(PushNotificationParser.CHANNEL_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, messageReceipt.getChannelId());
            jsonWriter.name("timestamp");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(messageReceipt.getTimestamp()));
            jsonWriter.name("message_id");
            this.nullableStringAdapter.toJson(jsonWriter, messageReceipt.getMessageId());
            jsonWriter.name(EventDetailsKeys.CORRELATION_ID);
            this.nullableStringAdapter.toJson(jsonWriter, messageReceipt.getCorrelationId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
