package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.deliveryhero.customerchat.eventTracking.constants.EventDetailsKeys;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage_IncomingWebSocketLocationMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage$IncomingWebSocketLocationMessage;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "eventTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "locationContentAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContent;", "longAdapter", "", "messageTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;", "nullableMetaDataContentAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IncomingWebSocketSubMessage_IncomingWebSocketLocationMessageJsonAdapter extends JsonAdapter<IncomingWebSocketSubMessage.IncomingWebSocketLocationMessage> {
    @NotNull
    private final JsonAdapter<EventType> eventTypeAdapter;
    @NotNull
    private final JsonAdapter<LocationContent> locationContentAdapter;
    @NotNull
    private final JsonAdapter<Long> longAdapter;
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

    public IncomingWebSocketSubMessage_IncomingWebSocketLocationMessageJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("message_id", PushNotificationParser.CHANNEL_ID_KEY, "content", "message_type", "location", "event_type", "sender_id", "sender_nickname", "timestamp", "meta", EventDetailsKeys.CORRELATION_ID);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"message_id\", \"channe…\"meta\", \"correlation_id\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "messageId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"messageId\")");
        this.stringAdapter = adapter;
        JsonAdapter<MessageType> adapter2 = moshi.adapter(MessageType.class, SetsKt__SetsKt.emptySet(), "messageType");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(MessageTyp…mptySet(), \"messageType\")");
        this.messageTypeAdapter = adapter2;
        JsonAdapter<LocationContent> adapter3 = moshi.adapter(LocationContent.class, SetsKt__SetsKt.emptySet(), "location");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(LocationCo…, emptySet(), \"location\")");
        this.locationContentAdapter = adapter3;
        JsonAdapter<EventType> adapter4 = moshi.adapter(EventType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(EventType:… emptySet(), \"eventType\")");
        this.eventTypeAdapter = adapter4;
        JsonAdapter<Long> adapter5 = moshi.adapter(Long.TYPE, SetsKt__SetsKt.emptySet(), "timestamp");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Long::clas…Set(),\n      \"timestamp\")");
        this.longAdapter = adapter5;
        JsonAdapter<MetaDataContent> adapter6 = moshi.adapter(MetaDataContent.class, SetsKt__SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(MetaDataCo…, emptySet(), \"metadata\")");
        this.nullableMetaDataContentAdapter = adapter6;
        JsonAdapter<String> adapter7 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "correlationId");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(String::cl…tySet(), \"correlationId\")");
        this.nullableStringAdapter = adapter7;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(82);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("IncomingWebSocketSubMessage.IncomingWebSocketLocationMessage");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01bb, code lost:
        r15 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01bd, code lost:
        r14 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01bf, code lost:
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01c1, code lost:
        r11 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01c3, code lost:
        r10 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01c5, code lost:
        r9 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c7, code lost:
        r8 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01c9, code lost:
        r7 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01cb, code lost:
        r6 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01cd, code lost:
        r5 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01cf, code lost:
        r4 = r26;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage.IncomingWebSocketLocationMessage fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r30) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r30.beginObject()
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r14 = r11
            r15 = r14
        L_0x0017:
            boolean r3 = r30.hasNext()
            java.lang.String r12 = "sender_nickname"
            java.lang.String r13 = "senderNickname"
            r16 = r15
            java.lang.String r15 = "sender_id"
            r17 = r14
            java.lang.String r14 = "senderId"
            r18 = r2
            java.lang.String r2 = "event_type"
            r19 = r11
            java.lang.String r11 = "eventType"
            r20 = r10
            java.lang.String r10 = "message_type"
            r21 = r9
            java.lang.String r9 = "messageType"
            r22 = r8
            java.lang.String r8 = "channel_id"
            r23 = r7
            java.lang.String r7 = "channelId"
            r24 = r6
            java.lang.String r6 = "message_id"
            r25 = r5
            java.lang.String r5 = "messageId"
            r26 = r4
            java.lang.String r4 = "timestamp"
            r27 = r5
            java.lang.String r5 = "location"
            r28 = r6
            java.lang.String r6 = "content"
            if (r3 == 0) goto L_0x01d3
            com.squareup.moshi.JsonReader$Options r3 = r0.options
            int r3 = r1.selectName(r3)
            switch(r3) {
                case -1: goto L_0x01b5;
                case 0: goto L_0x0186;
                case 1: goto L_0x015e;
                case 2: goto L_0x0137;
                case 3: goto L_0x0112;
                case 4: goto L_0x00ef;
                case 5: goto L_0x00ce;
                case 6: goto L_0x00af;
                case 7: goto L_0x0092;
                case 8: goto L_0x0078;
                case 9: goto L_0x006b;
                case 10: goto L_0x0060;
                default: goto L_0x005e;
            }
        L_0x005e:
            goto L_0x01bb
        L_0x0060:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x01bd
        L_0x006b:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent> r2 = r0.nullableMetaDataContentAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent r14 = (com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent) r14
            r15 = r16
            goto L_0x01bf
        L_0x0078:
            com.squareup.moshi.JsonAdapter<java.lang.Long> r2 = r0.longAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 == 0) goto L_0x0088
            r15 = r16
            r14 = r17
            goto L_0x01c1
        L_0x0088:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r4, r1)
            java.lang.String r2 = "unexpectedNull(\"timestam…     \"timestamp\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0092:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x00a5
            r15 = r16
            r14 = r17
            r2 = r18
            goto L_0x01c3
        L_0x00a5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"senderNi…sender_nickname\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00af:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x00c4
            r15 = r16
            r14 = r17
            r2 = r18
            r11 = r19
            goto L_0x01c5
        L_0x00c4:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"senderId…     \"sender_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00ce:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.EventType> r3 = r0.eventTypeAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r3
            com.deliveryhero.chatsdk.network.websocket.model.EventType r9 = (com.deliveryhero.chatsdk.network.websocket.model.EventType) r9
            if (r9 == 0) goto L_0x00e5
            r15 = r16
            r14 = r17
            r2 = r18
            r11 = r19
            r10 = r20
            goto L_0x01c7
        L_0x00e5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"eventTyp…    \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00ef:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.LocationContent> r2 = r0.locationContentAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            com.deliveryhero.chatsdk.network.websocket.model.LocationContent r8 = (com.deliveryhero.chatsdk.network.websocket.model.LocationContent) r8
            if (r8 == 0) goto L_0x0108
            r15 = r16
            r14 = r17
            r2 = r18
            r11 = r19
            r10 = r20
            r9 = r21
            goto L_0x01c9
        L_0x0108:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r5, r5, r1)
            java.lang.String r2 = "unexpectedNull(\"location\", \"location\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0112:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.MessageType> r2 = r0.messageTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            com.deliveryhero.chatsdk.network.websocket.model.MessageType r7 = (com.deliveryhero.chatsdk.network.websocket.model.MessageType) r7
            if (r7 == 0) goto L_0x012d
            r15 = r16
            r14 = r17
            r2 = r18
            r11 = r19
            r10 = r20
            r9 = r21
            r8 = r22
            goto L_0x01cb
        L_0x012d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"messageT…, \"message_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0137:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0154
            r6 = r2
            r15 = r16
            r14 = r17
            r2 = r18
            r11 = r19
            r10 = r20
            r9 = r21
            r8 = r22
            r7 = r23
            goto L_0x01cd
        L_0x0154:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r6, r1)
            java.lang.String r2 = "unexpectedNull(\"content\"…       \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x015e:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x017c
            r15 = r16
            r14 = r17
            r2 = r18
            r11 = r19
            r10 = r20
            r9 = r21
            r8 = r22
            r7 = r23
            r6 = r24
            goto L_0x01cf
        L_0x017c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r8, r1)
            java.lang.String r2 = "unexpectedNull(\"channelI…    \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0186:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x01a7
            r15 = r16
            r14 = r17
            r2 = r18
            r11 = r19
            r10 = r20
            r9 = r21
            r8 = r22
            r7 = r23
            r6 = r24
            r5 = r25
            goto L_0x0017
        L_0x01a7:
            r2 = r27
            r3 = r28
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"messageI…    \"message_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01b5:
            r30.skipName()
            r30.skipValue()
        L_0x01bb:
            r15 = r16
        L_0x01bd:
            r14 = r17
        L_0x01bf:
            r2 = r18
        L_0x01c1:
            r11 = r19
        L_0x01c3:
            r10 = r20
        L_0x01c5:
            r9 = r21
        L_0x01c7:
            r8 = r22
        L_0x01c9:
            r7 = r23
        L_0x01cb:
            r6 = r24
        L_0x01cd:
            r5 = r25
        L_0x01cf:
            r4 = r26
            goto L_0x0017
        L_0x01d3:
            r0 = r27
            r3 = r28
            r30.endObject()
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketLocationMessage r27 = new com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketLocationMessage
            if (r26 == 0) goto L_0x025c
            if (r25 == 0) goto L_0x0252
            if (r24 == 0) goto L_0x0248
            if (r23 == 0) goto L_0x023e
            if (r22 == 0) goto L_0x0234
            if (r21 == 0) goto L_0x022a
            if (r20 == 0) goto L_0x0220
            if (r19 == 0) goto L_0x0216
            if (r18 == 0) goto L_0x020c
            long r12 = r18.longValue()
            r3 = r27
            r4 = r26
            r5 = r25
            r6 = r24
            r7 = r23
            r8 = r22
            r9 = r21
            r10 = r20
            r11 = r19
            r14 = r17
            r15 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15)
            return r27
        L_0x020c:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r4, r4, r1)
            java.lang.String r1 = "missingProperty(\"timestamp\", \"timestamp\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0216:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r13, r12, r1)
            java.lang.String r1 = "missingProperty(\"senderN…sender_nickname\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0220:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r14, r15, r1)
            java.lang.String r1 = "missingProperty(\"senderId\", \"sender_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x022a:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r11, r2, r1)
            java.lang.String r1 = "missingProperty(\"eventType\", \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0234:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r5, r5, r1)
            java.lang.String r1 = "missingProperty(\"location\", \"location\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x023e:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r9, r10, r1)
            java.lang.String r1 = "missingProperty(\"message…ype\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0248:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r1 = "missingProperty(\"content\", \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0252:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r7, r8, r1)
            java.lang.String r1 = "missingProperty(\"channelId\", \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x025c:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r3, r1)
            java.lang.String r1 = "missingProperty(\"messageId\", \"message_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage_IncomingWebSocketLocationMessageJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketLocationMessage");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable IncomingWebSocketSubMessage.IncomingWebSocketLocationMessage incomingWebSocketLocationMessage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (incomingWebSocketLocationMessage != null) {
            jsonWriter.beginObject();
            jsonWriter.name("message_id");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketLocationMessage.getMessageId());
            jsonWriter.name(PushNotificationParser.CHANNEL_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketLocationMessage.getChannelId());
            jsonWriter.name("content");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketLocationMessage.getContent());
            jsonWriter.name("message_type");
            this.messageTypeAdapter.toJson(jsonWriter, incomingWebSocketLocationMessage.getMessageType());
            jsonWriter.name("location");
            this.locationContentAdapter.toJson(jsonWriter, incomingWebSocketLocationMessage.getLocation());
            jsonWriter.name("event_type");
            this.eventTypeAdapter.toJson(jsonWriter, incomingWebSocketLocationMessage.getEventType());
            jsonWriter.name("sender_id");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketLocationMessage.getSenderId());
            jsonWriter.name("sender_nickname");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketLocationMessage.getSenderNickname());
            jsonWriter.name("timestamp");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(incomingWebSocketLocationMessage.getTimestamp()));
            jsonWriter.name("meta");
            this.nullableMetaDataContentAdapter.toJson(jsonWriter, incomingWebSocketLocationMessage.getMetadata());
            jsonWriter.name(EventDetailsKeys.CORRELATION_ID);
            this.nullableStringAdapter.toJson(jsonWriter, incomingWebSocketLocationMessage.getCorrelationId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
