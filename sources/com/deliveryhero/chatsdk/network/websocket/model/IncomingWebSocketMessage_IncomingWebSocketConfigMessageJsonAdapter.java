package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.deliveryhero.customerchat.eventTracking.constants.EventDetailsKeys;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage_IncomingWebSocketConfigMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage$IncomingWebSocketConfigMessage;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "eventTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "listOfConfigDataAdapter", "", "Lcom/deliveryhero/chatsdk/network/websocket/model/ConfigData;", "longAdapter", "", "nullableMetaDataContentAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IncomingWebSocketMessage_IncomingWebSocketConfigMessageJsonAdapter extends JsonAdapter<IncomingWebSocketMessage.IncomingWebSocketConfigMessage> {
    @NotNull
    private final JsonAdapter<EventType> eventTypeAdapter;
    @NotNull
    private final JsonAdapter<List<ConfigData>> listOfConfigDataAdapter;
    @NotNull
    private final JsonAdapter<Long> longAdapter;
    @NotNull
    private final JsonAdapter<MetaDataContent> nullableMetaDataContentAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public IncomingWebSocketMessage_IncomingWebSocketConfigMessageJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("message_id", PushNotificationParser.CHANNEL_ID_KEY, "event_type", "timestamp", EventDetailsKeys.CORRELATION_ID, "configs", "meta");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"message_id\", \"channe…n_id\", \"configs\", \"meta\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "messageId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"messageId\")");
        this.stringAdapter = adapter;
        JsonAdapter<EventType> adapter2 = moshi.adapter(EventType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(EventType:… emptySet(), \"eventType\")");
        this.eventTypeAdapter = adapter2;
        JsonAdapter<Long> adapter3 = moshi.adapter(Long.TYPE, SetsKt__SetsKt.emptySet(), "timestamp");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Long::clas…Set(),\n      \"timestamp\")");
        this.longAdapter = adapter3;
        JsonAdapter<List<ConfigData>> adapter4 = moshi.adapter(Types.newParameterizedType(List.class, ConfigData.class), SetsKt__SetsKt.emptySet(), "configs");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…   emptySet(), \"configs\")");
        this.listOfConfigDataAdapter = adapter4;
        JsonAdapter<MetaDataContent> adapter5 = moshi.adapter(MetaDataContent.class, SetsKt__SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(MetaDataCo…, emptySet(), \"metadata\")");
        this.nullableMetaDataContentAdapter = adapter5;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("IncomingWebSocketMessage.IncomingWebSocketConfigMessage");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e3, code lost:
        r11 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e5, code lost:
        r10 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e7, code lost:
        r9 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e9, code lost:
        r2 = r19;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage.IncomingWebSocketConfigMessage fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r22.beginObject()
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r9 = r6
            r10 = r9
            r11 = r10
        L_0x0013:
            boolean r3 = r22.hasNext()
            java.lang.String r7 = "correlation_id"
            java.lang.String r8 = "correlationId"
            java.lang.String r12 = "event_type"
            java.lang.String r13 = "eventType"
            java.lang.String r14 = "channel_id"
            java.lang.String r15 = "channelId"
            r16 = r11
            java.lang.String r11 = "message_id"
            r17 = r10
            java.lang.String r10 = "messageId"
            r18 = r9
            java.lang.String r9 = "configs"
            r19 = r2
            java.lang.String r2 = "timestamp"
            if (r3 == 0) goto L_0x00ed
            com.squareup.moshi.JsonReader$Options r3 = r0.options
            int r3 = r1.selectName(r3)
            switch(r3) {
                case -1: goto L_0x00dd;
                case 0: goto L_0x00c7;
                case 1: goto L_0x00b1;
                case 2: goto L_0x009b;
                case 3: goto L_0x007f;
                case 4: goto L_0x0064;
                case 5: goto L_0x004b;
                case 6: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x00e3
        L_0x0040:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent> r2 = r0.nullableMetaDataContentAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent r11 = (com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent) r11
            goto L_0x00e5
        L_0x004b:
            com.squareup.moshi.JsonAdapter<java.util.List<com.deliveryhero.chatsdk.network.websocket.model.ConfigData>> r2 = r0.listOfConfigDataAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.util.List r10 = (java.util.List) r10
            if (r10 == 0) goto L_0x005a
            r11 = r16
            goto L_0x00e7
        L_0x005a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"configs\", \"configs\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0064:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x0075
            r11 = r16
            r10 = r17
            goto L_0x00e9
        L_0x0075:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r8, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"correlat…\"correlation_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x007f:
            com.squareup.moshi.JsonAdapter<java.lang.Long> r3 = r0.longAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Long r3 = (java.lang.Long) r3
            if (r3 == 0) goto L_0x0091
            r2 = r3
            r11 = r16
            r10 = r17
            r9 = r18
            goto L_0x0013
        L_0x0091:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"timestam…     \"timestamp\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x009b:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.EventType> r2 = r0.eventTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            com.deliveryhero.chatsdk.network.websocket.model.EventType r6 = (com.deliveryhero.chatsdk.network.websocket.model.EventType) r6
            if (r6 == 0) goto L_0x00a7
            goto L_0x00e3
        L_0x00a7:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"eventTyp…    \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00b1:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x00bd
            goto L_0x00e3
        L_0x00bd:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"channelI…    \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00c7:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00d3
            goto L_0x00e3
        L_0x00d3:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"messageI…    \"message_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00dd:
            r22.skipName()
            r22.skipValue()
        L_0x00e3:
            r11 = r16
        L_0x00e5:
            r10 = r17
        L_0x00e7:
            r9 = r18
        L_0x00e9:
            r2 = r19
            goto L_0x0013
        L_0x00ed:
            r22.endObject()
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage$IncomingWebSocketConfigMessage r20 = new com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage$IncomingWebSocketConfigMessage
            if (r4 == 0) goto L_0x0141
            if (r5 == 0) goto L_0x0137
            if (r6 == 0) goto L_0x012d
            if (r19 == 0) goto L_0x0123
            long r10 = r19.longValue()
            if (r18 == 0) goto L_0x0119
            if (r17 == 0) goto L_0x010f
            r3 = r20
            r7 = r10
            r9 = r18
            r10 = r17
            r11 = r16
            r3.<init>(r4, r5, r6, r7, r9, r10, r11)
            return r20
        L_0x010f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r9, r1)
            java.lang.String r2 = "missingProperty(\"configs\", \"configs\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0119:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r8, r7, r1)
            java.lang.String r2 = "missingProperty(\"correla…\"correlation_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0123:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r2 = "missingProperty(\"timestamp\", \"timestamp\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x012d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r12, r1)
            java.lang.String r2 = "missingProperty(\"eventType\", \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0137:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r14, r1)
            java.lang.String r2 = "missingProperty(\"channelId\", \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0141:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r11, r1)
            java.lang.String r2 = "missingProperty(\"messageId\", \"message_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage_IncomingWebSocketConfigMessageJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage$IncomingWebSocketConfigMessage");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable IncomingWebSocketMessage.IncomingWebSocketConfigMessage incomingWebSocketConfigMessage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (incomingWebSocketConfigMessage != null) {
            jsonWriter.beginObject();
            jsonWriter.name("message_id");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketConfigMessage.getMessageId());
            jsonWriter.name(PushNotificationParser.CHANNEL_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketConfigMessage.getChannelId());
            jsonWriter.name("event_type");
            this.eventTypeAdapter.toJson(jsonWriter, incomingWebSocketConfigMessage.getEventType());
            jsonWriter.name("timestamp");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(incomingWebSocketConfigMessage.getTimestamp()));
            jsonWriter.name(EventDetailsKeys.CORRELATION_ID);
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketConfigMessage.getCorrelationId());
            jsonWriter.name("configs");
            this.listOfConfigDataAdapter.toJson(jsonWriter, incomingWebSocketConfigMessage.getConfigs());
            jsonWriter.name("meta");
            this.nullableMetaDataContentAdapter.toJson(jsonWriter, incomingWebSocketConfigMessage.getMetadata());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
