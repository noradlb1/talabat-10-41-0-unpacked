package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.deliveryhero.customerchat.eventTracking.constants.EventDetailsKeys;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.lang.reflect.Constructor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage_IncomingWebSocketTextMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage$IncomingWebSocketTextMessage;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "contentTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "eventTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "longAdapter", "", "mapOfStringStringAdapter", "", "", "messageTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;", "nullableMetaDataContentAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IncomingWebSocketSubMessage_IncomingWebSocketTextMessageJsonAdapter extends JsonAdapter<IncomingWebSocketSubMessage.IncomingWebSocketTextMessage> {
    @Nullable
    private volatile Constructor<IncomingWebSocketSubMessage.IncomingWebSocketTextMessage> constructorRef;
    @NotNull
    private final JsonAdapter<ContentType> contentTypeAdapter;
    @NotNull
    private final JsonAdapter<EventType> eventTypeAdapter;
    @NotNull
    private final JsonAdapter<Long> longAdapter;
    @NotNull
    private final JsonAdapter<Map<String, String>> mapOfStringStringAdapter;
    @NotNull
    private final JsonAdapter<MessageType> messageTypeAdapter;
    @NotNull
    private final JsonAdapter<MetaDataContent> nullableMetaDataContentAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public IncomingWebSocketSubMessage_IncomingWebSocketTextMessageJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("message_id", PushNotificationParser.CHANNEL_ID_KEY, "content", "event_type", "message_type", "content_type", "sender_id", "sender_nickname", "timestamp", "translations", "meta", EventDetailsKeys.CORRELATION_ID);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"message_id\", \"channe…\"meta\", \"correlation_id\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "messageId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"messageId\")");
        this.stringAdapter = adapter;
        JsonAdapter<EventType> adapter2 = moshi.adapter(EventType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(EventType:… emptySet(), \"eventType\")");
        this.eventTypeAdapter = adapter2;
        JsonAdapter<MessageType> adapter3 = moshi.adapter(MessageType.class, SetsKt__SetsKt.emptySet(), "messageType");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(MessageTyp…mptySet(), \"messageType\")");
        this.messageTypeAdapter = adapter3;
        JsonAdapter<ContentType> adapter4 = moshi.adapter(ContentType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(ContentTyp…mptySet(), \"contentType\")");
        this.contentTypeAdapter = adapter4;
        JsonAdapter<Long> adapter5 = moshi.adapter(Long.TYPE, SetsKt__SetsKt.emptySet(), "timestamp");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Long::clas…Set(),\n      \"timestamp\")");
        this.longAdapter = adapter5;
        JsonAdapter<Map<String, String>> adapter6 = moshi.adapter(Types.newParameterizedType(Map.class, cls, cls), SetsKt__SetsKt.emptySet(), "translations");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Types.newP…ptySet(), \"translations\")");
        this.mapOfStringStringAdapter = adapter6;
        JsonAdapter<MetaDataContent> adapter7 = moshi.adapter(MetaDataContent.class, SetsKt__SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(MetaDataCo…, emptySet(), \"metadata\")");
        this.nullableMetaDataContentAdapter = adapter7;
        JsonAdapter<String> adapter8 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "correlationId");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(String::cl…tySet(), \"correlationId\")");
        this.nullableStringAdapter = adapter8;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(78);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("IncomingWebSocketSubMessage.IncomingWebSocketTextMessage");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01d3, code lost:
        r15 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01d5, code lost:
        r4 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d7, code lost:
        r12 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01d9, code lost:
        r11 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01db, code lost:
        r10 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01dd, code lost:
        r9 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01df, code lost:
        r8 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e1, code lost:
        r7 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01e3, code lost:
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01e5, code lost:
        r5 = r27;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage.IncomingWebSocketTextMessage fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r39) {
        /*
            r38 = this;
            r0 = r38
            r1 = r39
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r39.beginObject()
            r3 = -1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x001b:
            boolean r13 = r39.hasNext()
            java.lang.String r14 = "sender_nickname"
            java.lang.String r2 = "senderNickname"
            r18 = r15
            java.lang.String r15 = "sender_id"
            r19 = r4
            java.lang.String r4 = "senderId"
            r20 = r12
            java.lang.String r12 = "content_type"
            r21 = r11
            java.lang.String r11 = "contentType"
            r22 = r10
            java.lang.String r10 = "message_type"
            r23 = r9
            java.lang.String r9 = "messageType"
            r24 = r8
            java.lang.String r8 = "event_type"
            r25 = r7
            java.lang.String r7 = "eventType"
            r26 = r6
            java.lang.String r6 = "channel_id"
            r27 = r5
            java.lang.String r5 = "channelId"
            r28 = r5
            java.lang.String r5 = "message_id"
            r29 = r5
            java.lang.String r5 = "messageId"
            r30 = r5
            java.lang.String r5 = "timestamp"
            r31 = r6
            java.lang.String r6 = "content"
            if (r13 == 0) goto L_0x01e9
            com.squareup.moshi.JsonReader$Options r13 = r0.options
            int r13 = r1.selectName(r13)
            switch(r13) {
                case -1: goto L_0x01cd;
                case 0: goto L_0x01a0;
                case 1: goto L_0x0176;
                case 2: goto L_0x0151;
                case 3: goto L_0x012e;
                case 4: goto L_0x010d;
                case 5: goto L_0x00ee;
                case 6: goto L_0x00d1;
                case 7: goto L_0x00b6;
                case 8: goto L_0x009d;
                case 9: goto L_0x0080;
                case 10: goto L_0x0074;
                case 11: goto L_0x0068;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x01d3
        L_0x0068:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r17 = r2
            java.lang.String r17 = (java.lang.String) r17
            goto L_0x01d3
        L_0x0074:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent> r2 = r0.nullableMetaDataContentAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r2
            com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent r16 = (com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent) r16
            goto L_0x01d3
        L_0x0080:
            com.squareup.moshi.JsonAdapter<java.util.Map<java.lang.String, java.lang.String>> r2 = r0.mapOfStringStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.util.Map r15 = (java.util.Map) r15
            if (r15 == 0) goto L_0x008f
            r3 = r3 & -513(0xfffffffffffffdff, float:NaN)
            goto L_0x01d5
        L_0x008f:
            java.lang.String r2 = "translations"
            java.lang.String r3 = "translations"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"translat…, \"translations\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x009d:
            com.squareup.moshi.JsonAdapter<java.lang.Long> r2 = r0.longAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.Long r4 = (java.lang.Long) r4
            if (r4 == 0) goto L_0x00ac
            r15 = r18
            goto L_0x01d7
        L_0x00ac:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r5, r5, r1)
            java.lang.String r2 = "unexpectedNull(\"timestam…     \"timestamp\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00b6:
            com.squareup.moshi.JsonAdapter<java.lang.String> r4 = r0.stringAdapter
            java.lang.Object r4 = r4.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r4
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x00c7
            r15 = r18
            r4 = r19
            goto L_0x01d9
        L_0x00c7:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"senderNi…sender_nickname\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00d1:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x00e4
            r15 = r18
            r4 = r19
            r12 = r20
            goto L_0x01db
        L_0x00e4:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"senderId…     \"sender_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00ee:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.ContentType> r2 = r0.contentTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            com.deliveryhero.chatsdk.network.websocket.model.ContentType r10 = (com.deliveryhero.chatsdk.network.websocket.model.ContentType) r10
            if (r10 == 0) goto L_0x0103
            r15 = r18
            r4 = r19
            r12 = r20
            r11 = r21
            goto L_0x01dd
        L_0x0103:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"contentT…, \"content_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x010d:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.MessageType> r2 = r0.messageTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            com.deliveryhero.chatsdk.network.websocket.model.MessageType r2 = (com.deliveryhero.chatsdk.network.websocket.model.MessageType) r2
            if (r2 == 0) goto L_0x0124
            r9 = r2
            r15 = r18
            r4 = r19
            r12 = r20
            r11 = r21
            r10 = r22
            goto L_0x01df
        L_0x0124:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"messageT…, \"message_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x012e:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.EventType> r2 = r0.eventTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            com.deliveryhero.chatsdk.network.websocket.model.EventType r2 = (com.deliveryhero.chatsdk.network.websocket.model.EventType) r2
            if (r2 == 0) goto L_0x0147
            r8 = r2
            r15 = r18
            r4 = r19
            r12 = r20
            r11 = r21
            r10 = r22
            r9 = r23
            goto L_0x01e1
        L_0x0147:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r8, r1)
            java.lang.String r2 = "unexpectedNull(\"eventTyp…    \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0151:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x016c
            r15 = r18
            r4 = r19
            r12 = r20
            r11 = r21
            r10 = r22
            r9 = r23
            r8 = r24
            goto L_0x01e3
        L_0x016c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r6, r1)
            java.lang.String r2 = "unexpectedNull(\"content\"…       \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0176:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0192
            r15 = r18
            r4 = r19
            r12 = r20
            r11 = r21
            r10 = r22
            r9 = r23
            r8 = r24
            r7 = r25
            goto L_0x01e5
        L_0x0192:
            r2 = r28
            r13 = r31
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"channelI…    \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01a0:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x01bf
            r15 = r18
            r4 = r19
            r12 = r20
            r11 = r21
            r10 = r22
            r9 = r23
            r8 = r24
            r7 = r25
            r6 = r26
            goto L_0x001b
        L_0x01bf:
            r2 = r29
            r4 = r30
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"messageI…    \"message_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01cd:
            r39.skipName()
            r39.skipValue()
        L_0x01d3:
            r15 = r18
        L_0x01d5:
            r4 = r19
        L_0x01d7:
            r12 = r20
        L_0x01d9:
            r11 = r21
        L_0x01db:
            r10 = r22
        L_0x01dd:
            r9 = r23
        L_0x01df:
            r8 = r24
        L_0x01e1:
            r7 = r25
        L_0x01e3:
            r6 = r26
        L_0x01e5:
            r5 = r27
            goto L_0x001b
        L_0x01e9:
            r0 = r28
            r32 = r29
            r33 = r30
            r13 = r31
            r39.endObject()
            r0 = -513(0xfffffffffffffdff, float:NaN)
            if (r3 != r0) goto L_0x0291
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketTextMessage r0 = new com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketTextMessage
            if (r27 == 0) goto L_0x0283
            if (r26 == 0) goto L_0x0277
            if (r25 == 0) goto L_0x026d
            if (r24 == 0) goto L_0x0263
            if (r23 == 0) goto L_0x0259
            if (r22 == 0) goto L_0x024f
            if (r21 == 0) goto L_0x0245
            if (r20 == 0) goto L_0x023b
            if (r19 == 0) goto L_0x0231
            long r13 = r19.longValue()
            if (r18 == 0) goto L_0x0229
            r4 = r0
            r5 = r27
            r6 = r26
            r7 = r25
            r8 = r24
            r9 = r23
            r10 = r22
            r11 = r21
            r12 = r20
            r15 = r18
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17)
            return r0
        L_0x0229:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>"
            r0.<init>(r1)
            throw r0
        L_0x0231:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r5, r5, r1)
            java.lang.String r1 = "missingProperty(\"timestamp\", \"timestamp\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x023b:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r14, r1)
            java.lang.String r1 = "missingProperty(\"senderN…sender_nickname\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0245:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r4, r15, r1)
            java.lang.String r1 = "missingProperty(\"senderId\", \"sender_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x024f:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r11, r12, r1)
            java.lang.String r1 = "missingProperty(\"content…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0259:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r9, r10, r1)
            java.lang.String r1 = "missingProperty(\"message…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0263:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r7, r8, r1)
            java.lang.String r1 = "missingProperty(\"eventType\", \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x026d:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r1 = "missingProperty(\"content\", \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0277:
            r0 = r28
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r13, r1)
            java.lang.String r1 = "missingProperty(\"channelId\", \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0283:
            r0 = r32
            r2 = r33
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r0, r1)
            java.lang.String r1 = "missingProperty(\"messageId\", \"message_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0291:
            r0 = r38
            r31 = r13
            r34 = r28
            r29 = r32
            r35 = r33
            java.lang.reflect.Constructor<com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketTextMessage> r13 = r0.constructorRef
            r28 = 1
            r30 = 0
            r32 = r6
            r6 = 14
            if (r13 != 0) goto L_0x02fe
            java.lang.Class[] r13 = new java.lang.Class[r6]
            java.lang.Class<java.lang.String> r33 = java.lang.String.class
            r13[r30] = r33
            r13[r28] = r33
            r36 = 2
            r13[r36] = r33
            r36 = 3
            java.lang.Class<com.deliveryhero.chatsdk.network.websocket.model.EventType> r37 = com.deliveryhero.chatsdk.network.websocket.model.EventType.class
            r13[r36] = r37
            r36 = 4
            java.lang.Class<com.deliveryhero.chatsdk.network.websocket.model.MessageType> r37 = com.deliveryhero.chatsdk.network.websocket.model.MessageType.class
            r13[r36] = r37
            r36 = 5
            java.lang.Class<com.deliveryhero.chatsdk.network.websocket.model.ContentType> r37 = com.deliveryhero.chatsdk.network.websocket.model.ContentType.class
            r13[r36] = r37
            r36 = 6
            r13[r36] = r33
            r36 = 7
            r13[r36] = r33
            r36 = 8
            java.lang.Class r37 = java.lang.Long.TYPE
            r13[r36] = r37
            r36 = 9
            java.lang.Class<java.util.Map> r37 = java.util.Map.class
            r13[r36] = r37
            r36 = 10
            java.lang.Class<com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent> r37 = com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent.class
            r13[r36] = r37
            r36 = 11
            r13[r36] = r33
            r33 = 12
            java.lang.Class r36 = java.lang.Integer.TYPE
            r13[r33] = r36
            r33 = 13
            java.lang.Class<?> r36 = com.squareup.moshi.internal.Util.DEFAULT_CONSTRUCTOR_MARKER
            r13[r33] = r36
            java.lang.Class<com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketTextMessage> r6 = com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage.IncomingWebSocketTextMessage.class
            java.lang.reflect.Constructor r13 = r6.getDeclaredConstructor(r13)
            r0.constructorRef = r13
            java.lang.String r6 = "IncomingWebSocketSubMess…his.constructorRef = it }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r6)
            r6 = 14
        L_0x02fe:
            java.lang.Object[] r6 = new java.lang.Object[r6]
            if (r27 == 0) goto L_0x03b0
            r6[r30] = r27
            if (r26 == 0) goto L_0x03a2
            r6[r28] = r26
            if (r25 == 0) goto L_0x0396
            r26 = 2
            r6[r26] = r25
            if (r24 == 0) goto L_0x038c
            r7 = 3
            r6[r7] = r24
            if (r23 == 0) goto L_0x0382
            r7 = 4
            r6[r7] = r23
            if (r22 == 0) goto L_0x0378
            r7 = 5
            r6[r7] = r22
            if (r21 == 0) goto L_0x036e
            r4 = 6
            r6[r4] = r21
            if (r20 == 0) goto L_0x0364
            r2 = 7
            r6[r2] = r20
            if (r19 == 0) goto L_0x035a
            long r1 = r19.longValue()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r2 = 8
            r6[r2] = r1
            r1 = 9
            r6[r1] = r18
            r1 = 10
            r6[r1] = r16
            r1 = 11
            r6[r1] = r17
            r1 = 12
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r6[r1] = r2
            r1 = 13
            r2 = 0
            r6[r1] = r2
            java.lang.Object r1 = r13.newInstance(r6)
            java.lang.String r2 = "localConstructor.newInst…torMarker */ null\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketTextMessage r1 = (com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage.IncomingWebSocketTextMessage) r1
            return r1
        L_0x035a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r5, r5, r1)
            java.lang.String r2 = "missingProperty(\"timestamp\", \"timestamp\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0364:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r14, r1)
            java.lang.String r2 = "missingProperty(\"senderN…sender_nickname\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x036e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r4, r15, r1)
            java.lang.String r2 = "missingProperty(\"senderId\", \"sender_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0378:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r12, r1)
            java.lang.String r2 = "missingProperty(\"content…, \"content_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0382:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r10, r1)
            java.lang.String r2 = "missingProperty(\"message…, \"message_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x038c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r8, r1)
            java.lang.String r2 = "missingProperty(\"eventType\", \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0396:
            r2 = r32
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r2 = "missingProperty(\"content\", \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x03a2:
            r2 = r31
            r3 = r34
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r3, r2, r1)
            java.lang.String r2 = "missingProperty(\"channelId\", \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x03b0:
            r2 = r29
            r3 = r35
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r3, r2, r1)
            java.lang.String r2 = "missingProperty(\"messageId\", \"message_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage_IncomingWebSocketTextMessageJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketTextMessage");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable IncomingWebSocketSubMessage.IncomingWebSocketTextMessage incomingWebSocketTextMessage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (incomingWebSocketTextMessage != null) {
            jsonWriter.beginObject();
            jsonWriter.name("message_id");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketTextMessage.getMessageId());
            jsonWriter.name(PushNotificationParser.CHANNEL_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketTextMessage.getChannelId());
            jsonWriter.name("content");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketTextMessage.getContent());
            jsonWriter.name("event_type");
            this.eventTypeAdapter.toJson(jsonWriter, incomingWebSocketTextMessage.getEventType());
            jsonWriter.name("message_type");
            this.messageTypeAdapter.toJson(jsonWriter, incomingWebSocketTextMessage.getMessageType());
            jsonWriter.name("content_type");
            this.contentTypeAdapter.toJson(jsonWriter, incomingWebSocketTextMessage.getContentType());
            jsonWriter.name("sender_id");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketTextMessage.getSenderId());
            jsonWriter.name("sender_nickname");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketTextMessage.getSenderNickname());
            jsonWriter.name("timestamp");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(incomingWebSocketTextMessage.getTimestamp()));
            jsonWriter.name("translations");
            this.mapOfStringStringAdapter.toJson(jsonWriter, incomingWebSocketTextMessage.getTranslations());
            jsonWriter.name("meta");
            this.nullableMetaDataContentAdapter.toJson(jsonWriter, incomingWebSocketTextMessage.getMetadata());
            jsonWriter.name(EventDetailsKeys.CORRELATION_ID);
            this.nullableStringAdapter.toJson(jsonWriter, incomingWebSocketTextMessage.getCorrelationId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
