package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.deliveryhero.customerchat.eventTracking.constants.EventDetailsKeys;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReadEventJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReadEvent;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "longAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessageReadEventJsonAdapter extends JsonAdapter<MessageReadEvent> {
    @Nullable
    private volatile Constructor<MessageReadEvent> constructorRef;
    @NotNull
    private final JsonAdapter<Long> longAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public MessageReadEventJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(PushNotificationParser.CHANNEL_ID_KEY, "timestamp", "event_type", EventDetailsKeys.CORRELATION_ID);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"channel_id\", \"timest…_type\", \"correlation_id\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"channelId\")");
        this.stringAdapter = adapter;
        JsonAdapter<Long> adapter2 = moshi.adapter(Long.TYPE, SetsKt__SetsKt.emptySet(), "timestamp");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Long::clas…Set(),\n      \"timestamp\")");
        this.longAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("MessageReadEvent");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public MessageReadEvent fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        Long l11 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(RemoteMessageConst.Notification.CHANNEL_ID, PushNotificationParser.CHANNEL_ID_KEY, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"channelI…    \"channel_id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                l11 = this.longAdapter.fromJson(jsonReader2);
                if (l11 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("timestamp", "timestamp", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"timestam…     \"timestamp\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(jsonReader2);
                if (str2 != null) {
                    i11 &= -5;
                } else {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, "event_type", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"eventTyp…    \"event_type\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (str3 = this.stringAdapter.fromJson(jsonReader2)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("correlationId", EventDetailsKeys.CORRELATION_ID, jsonReader2);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"correlat…\"correlation_id\", reader)");
                throw unexpectedNull4;
            }
        }
        jsonReader.endObject();
        if (i11 != -5) {
            Constructor<MessageReadEvent> constructor = this.constructorRef;
            String str4 = "missingProperty(\"channelId\", \"channel_id\", reader)";
            int i12 = 6;
            if (constructor == null) {
                Class<String> cls = String.class;
                constructor = MessageReadEvent.class.getDeclaredConstructor(new Class[]{cls, Long.TYPE, cls, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "MessageReadEvent::class.…his.constructorRef = it }");
                i12 = 6;
            }
            Object[] objArr = new Object[i12];
            if (str != null) {
                objArr[0] = str;
                if (l11 != null) {
                    objArr[1] = Long.valueOf(l11.longValue());
                    objArr[2] = str2;
                    if (str3 != null) {
                        objArr[3] = str3;
                        objArr[4] = Integer.valueOf(i11);
                        objArr[5] = null;
                        MessageReadEvent newInstance = constructor.newInstance(objArr);
                        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                        return newInstance;
                    }
                    JsonDataException missingProperty = Util.missingProperty("correlationId", EventDetailsKeys.CORRELATION_ID, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"correla…\"correlation_id\", reader)");
                    throw missingProperty;
                }
                JsonDataException missingProperty2 = Util.missingProperty("timestamp", "timestamp", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"timestamp\", \"timestamp\", reader)");
                throw missingProperty2;
            }
            JsonDataException missingProperty3 = Util.missingProperty(RemoteMessageConst.Notification.CHANNEL_ID, PushNotificationParser.CHANNEL_ID_KEY, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, str4);
            throw missingProperty3;
        } else if (str == null) {
            JsonDataException missingProperty4 = Util.missingProperty(RemoteMessageConst.Notification.CHANNEL_ID, PushNotificationParser.CHANNEL_ID_KEY, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"channelId\", \"channel_id\", reader)");
            throw missingProperty4;
        } else if (l11 != null) {
            long longValue = l11.longValue();
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            } else if (str3 != null) {
                return new MessageReadEvent(str, longValue, str2, str3);
            } else {
                JsonDataException missingProperty5 = Util.missingProperty("correlationId", EventDetailsKeys.CORRELATION_ID, jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"correla…\"correlation_id\", reader)");
                throw missingProperty5;
            }
        } else {
            JsonDataException missingProperty6 = Util.missingProperty("timestamp", "timestamp", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"timestamp\", \"timestamp\", reader)");
            throw missingProperty6;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable MessageReadEvent messageReadEvent) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messageReadEvent != null) {
            jsonWriter.beginObject();
            jsonWriter.name(PushNotificationParser.CHANNEL_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, messageReadEvent.getChannelId());
            jsonWriter.name("timestamp");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(messageReadEvent.getTimestamp()));
            jsonWriter.name("event_type");
            this.stringAdapter.toJson(jsonWriter, messageReadEvent.getEventType());
            jsonWriter.name(EventDetailsKeys.CORRELATION_ID);
            this.stringAdapter.toJson(jsonWriter, messageReadEvent.getCorrelationId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
