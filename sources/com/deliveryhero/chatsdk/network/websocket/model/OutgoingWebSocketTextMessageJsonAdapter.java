package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.deliveryhero.customerchat.eventTracking.constants.EventDetailsKeys;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketTextMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketTextMessage;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "contentTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "eventTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "nullableListOfStringAdapter", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OutgoingWebSocketTextMessageJsonAdapter extends JsonAdapter<OutgoingWebSocketTextMessage> {
    @NotNull
    private final JsonAdapter<ContentType> contentTypeAdapter;
    @NotNull
    private final JsonAdapter<EventType> eventTypeAdapter;
    @NotNull
    private final JsonAdapter<List<String>> nullableListOfStringAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public OutgoingWebSocketTextMessageJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("content", "event_type", "content_type", PushNotificationParser.CHANNEL_ID_KEY, ConstantsKt.ADJUST_LANGUAGE, EventDetailsKeys.SUPPORTED_LANGUAGES, EventDetailsKeys.CORRELATION_ID);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"content\", \"event_typ…uages\", \"correlation_id\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "content");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…tySet(),\n      \"content\")");
        this.stringAdapter = adapter;
        JsonAdapter<EventType> adapter2 = moshi.adapter(EventType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(EventType:… emptySet(), \"eventType\")");
        this.eventTypeAdapter = adapter2;
        JsonAdapter<ContentType> adapter3 = moshi.adapter(ContentType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(ContentTyp…mptySet(), \"contentType\")");
        this.contentTypeAdapter = adapter3;
        JsonAdapter<String> adapter4 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), ConstantsKt.ADJUST_LANGUAGE);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(String::cl…  emptySet(), \"language\")");
        this.nullableStringAdapter = adapter4;
        JsonAdapter<List<String>> adapter5 = moshi.adapter(Types.newParameterizedType(List.class, cls), SetsKt__SetsKt.emptySet(), "supportedLanguages");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP…    \"supportedLanguages\")");
        this.nullableListOfStringAdapter = adapter5;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("OutgoingWebSocketTextMessage");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cb, code lost:
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cd, code lost:
        r8 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cf, code lost:
        r10 = r18;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketTextMessage fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r20.beginObject()
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
        L_0x0014:
            boolean r2 = r20.hasNext()
            java.lang.String r3 = "correlation_id"
            java.lang.String r11 = "correlationId"
            java.lang.String r12 = "channel_id"
            java.lang.String r13 = "channelId"
            java.lang.String r14 = "content_type"
            java.lang.String r15 = "contentType"
            r16 = r9
            java.lang.String r9 = "event_type"
            r17 = r8
            java.lang.String r8 = "eventType"
            r18 = r10
            java.lang.String r10 = "content"
            if (r2 == 0) goto L_0x00d3
            com.squareup.moshi.JsonReader$Options r2 = r0.options
            int r2 = r1.selectName(r2)
            switch(r2) {
                case -1: goto L_0x00c5;
                case 0: goto L_0x00af;
                case 1: goto L_0x0099;
                case 2: goto L_0x0083;
                case 3: goto L_0x006d;
                case 4: goto L_0x0061;
                case 5: goto L_0x0057;
                case 6: goto L_0x003d;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x00cb
        L_0x003d:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x004d
            r9 = r16
            r8 = r17
            goto L_0x0014
        L_0x004d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"correlat…\"correlation_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0057:
            com.squareup.moshi.JsonAdapter<java.util.List<java.lang.String>> r2 = r0.nullableListOfStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.util.List r9 = (java.util.List) r9
            goto L_0x00cd
        L_0x0061:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            r9 = r16
            goto L_0x00cf
        L_0x006d:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0079
            goto L_0x00cb
        L_0x0079:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"channelI…    \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0083:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.ContentType> r2 = r0.contentTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            com.deliveryhero.chatsdk.network.websocket.model.ContentType r6 = (com.deliveryhero.chatsdk.network.websocket.model.ContentType) r6
            if (r6 == 0) goto L_0x008f
            goto L_0x00cb
        L_0x008f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"contentT…, \"content_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0099:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.EventType> r2 = r0.eventTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            com.deliveryhero.chatsdk.network.websocket.model.EventType r5 = (com.deliveryhero.chatsdk.network.websocket.model.EventType) r5
            if (r5 == 0) goto L_0x00a5
            goto L_0x00cb
        L_0x00a5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r8, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"eventTyp…    \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00af:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00bb
            goto L_0x00cb
        L_0x00bb:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"content\"…       \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00c5:
            r20.skipName()
            r20.skipValue()
        L_0x00cb:
            r9 = r16
        L_0x00cd:
            r8 = r17
        L_0x00cf:
            r10 = r18
            goto L_0x0014
        L_0x00d3:
            r20.endObject()
            com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketTextMessage r2 = new com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketTextMessage
            if (r4 == 0) goto L_0x0115
            if (r5 == 0) goto L_0x010b
            if (r6 == 0) goto L_0x0101
            if (r7 == 0) goto L_0x00f7
            if (r18 == 0) goto L_0x00ed
            r3 = r2
            r8 = r17
            r9 = r16
            r10 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r2
        L_0x00ed:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r3, r1)
            java.lang.String r2 = "missingProperty(\"correla…\"correlation_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00f7:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r12, r1)
            java.lang.String r2 = "missingProperty(\"channelId\", \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0101:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r14, r1)
            java.lang.String r2 = "missingProperty(\"content…ype\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x010b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r8, r9, r1)
            java.lang.String r2 = "missingProperty(\"eventType\", \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0115:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"content\", \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketTextMessageJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketTextMessage");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable OutgoingWebSocketTextMessage outgoingWebSocketTextMessage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (outgoingWebSocketTextMessage != null) {
            jsonWriter.beginObject();
            jsonWriter.name("content");
            this.stringAdapter.toJson(jsonWriter, outgoingWebSocketTextMessage.getContent());
            jsonWriter.name("event_type");
            this.eventTypeAdapter.toJson(jsonWriter, outgoingWebSocketTextMessage.getEventType());
            jsonWriter.name("content_type");
            this.contentTypeAdapter.toJson(jsonWriter, outgoingWebSocketTextMessage.getContentType());
            jsonWriter.name(PushNotificationParser.CHANNEL_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, outgoingWebSocketTextMessage.getChannelId());
            jsonWriter.name(ConstantsKt.ADJUST_LANGUAGE);
            this.nullableStringAdapter.toJson(jsonWriter, outgoingWebSocketTextMessage.getLanguage());
            jsonWriter.name(EventDetailsKeys.SUPPORTED_LANGUAGES);
            this.nullableListOfStringAdapter.toJson(jsonWriter, outgoingWebSocketTextMessage.getSupportedLanguages());
            jsonWriter.name(EventDetailsKeys.CORRELATION_ID);
            this.stringAdapter.toJson(jsonWriter, outgoingWebSocketTextMessage.getCorrelationId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
