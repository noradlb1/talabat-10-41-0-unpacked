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

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage_IncomingWebSocketFileMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketSubMessage$IncomingWebSocketFileMessage;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "contentTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "eventTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "fileContentAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/FileContent;", "longAdapter", "", "messageTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageType;", "nullableMetaDataContentAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IncomingWebSocketSubMessage_IncomingWebSocketFileMessageJsonAdapter extends JsonAdapter<IncomingWebSocketSubMessage.IncomingWebSocketFileMessage> {
    @NotNull
    private final JsonAdapter<ContentType> contentTypeAdapter;
    @NotNull
    private final JsonAdapter<EventType> eventTypeAdapter;
    @NotNull
    private final JsonAdapter<FileContent> fileContentAdapter;
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

    public IncomingWebSocketSubMessage_IncomingWebSocketFileMessageJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("message_id", PushNotificationParser.CHANNEL_ID_KEY, "content", "message_type", "image", "event_type", "content_type", "sender_id", "sender_nickname", "timestamp", "meta", EventDetailsKeys.CORRELATION_ID);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"message_id\", \"channe…\"meta\", \"correlation_id\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "messageId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"messageId\")");
        this.stringAdapter = adapter;
        JsonAdapter<MessageType> adapter2 = moshi.adapter(MessageType.class, SetsKt__SetsKt.emptySet(), "messageType");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(MessageTyp…mptySet(), \"messageType\")");
        this.messageTypeAdapter = adapter2;
        JsonAdapter<FileContent> adapter3 = moshi.adapter(FileContent.class, SetsKt__SetsKt.emptySet(), "image");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(FileConten…     emptySet(), \"image\")");
        this.fileContentAdapter = adapter3;
        JsonAdapter<EventType> adapter4 = moshi.adapter(EventType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(EventType:… emptySet(), \"eventType\")");
        this.eventTypeAdapter = adapter4;
        JsonAdapter<ContentType> adapter5 = moshi.adapter(ContentType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(ContentTyp…mptySet(), \"contentType\")");
        this.contentTypeAdapter = adapter5;
        JsonAdapter<Long> adapter6 = moshi.adapter(Long.TYPE, SetsKt__SetsKt.emptySet(), "timestamp");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Long::clas…Set(),\n      \"timestamp\")");
        this.longAdapter = adapter6;
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
        sb2.append("IncomingWebSocketSubMessage.IncomingWebSocketFileMessage");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01e1, code lost:
        r15 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01e3, code lost:
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e5, code lost:
        r12 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01e7, code lost:
        r11 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01e9, code lost:
        r10 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01eb, code lost:
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01ed, code lost:
        r8 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01ef, code lost:
        r7 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01f1, code lost:
        r6 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01f3, code lost:
        r5 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01f5, code lost:
        r4 = r27;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage.IncomingWebSocketFileMessage fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r35) {
        /*
            r34 = this;
            r0 = r34
            r1 = r35
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r35.beginObject()
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r15 = r12
            r16 = r15
        L_0x0019:
            boolean r3 = r35.hasNext()
            java.lang.String r13 = "sender_nickname"
            java.lang.String r14 = "senderNickname"
            r17 = r15
            java.lang.String r15 = "sender_id"
            r18 = r2
            java.lang.String r2 = "senderId"
            r19 = r12
            java.lang.String r12 = "content_type"
            r20 = r11
            java.lang.String r11 = "contentType"
            r21 = r10
            java.lang.String r10 = "event_type"
            r22 = r9
            java.lang.String r9 = "eventType"
            r23 = r8
            java.lang.String r8 = "message_type"
            r24 = r7
            java.lang.String r7 = "messageType"
            r25 = r6
            java.lang.String r6 = "channel_id"
            r26 = r5
            java.lang.String r5 = "channelId"
            r27 = r4
            java.lang.String r4 = "message_id"
            r28 = r4
            java.lang.String r4 = "messageId"
            r29 = r4
            java.lang.String r4 = "timestamp"
            r30 = r5
            java.lang.String r5 = "image"
            r31 = r6
            java.lang.String r6 = "content"
            if (r3 == 0) goto L_0x01f9
            com.squareup.moshi.JsonReader$Options r3 = r0.options
            int r3 = r1.selectName(r3)
            switch(r3) {
                case -1: goto L_0x01db;
                case 0: goto L_0x01ac;
                case 1: goto L_0x0180;
                case 2: goto L_0x0159;
                case 3: goto L_0x0134;
                case 4: goto L_0x0111;
                case 5: goto L_0x00f0;
                case 6: goto L_0x00d1;
                case 7: goto L_0x00b4;
                case 8: goto L_0x0099;
                case 9: goto L_0x0081;
                case 10: goto L_0x0076;
                case 11: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x01e1
        L_0x006a:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r2
            java.lang.String r16 = (java.lang.String) r16
            goto L_0x01e1
        L_0x0076:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent> r2 = r0.nullableMetaDataContentAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent r15 = (com.deliveryhero.chatsdk.network.websocket.model.MetaDataContent) r15
            goto L_0x01e3
        L_0x0081:
            com.squareup.moshi.JsonAdapter<java.lang.Long> r2 = r0.longAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 == 0) goto L_0x008f
            r15 = r17
            goto L_0x01e5
        L_0x008f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r4, r1)
            java.lang.String r2 = "unexpectedNull(\"timestam…     \"timestamp\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0099:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x00aa
            r15 = r17
            r2 = r18
            goto L_0x01e7
        L_0x00aa:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"senderNi…sender_nickname\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00b4:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r3
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x00c7
            r15 = r17
            r2 = r18
            r12 = r19
            goto L_0x01e9
        L_0x00c7:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"senderId…     \"sender_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00d1:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.ContentType> r2 = r0.contentTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            com.deliveryhero.chatsdk.network.websocket.model.ContentType r10 = (com.deliveryhero.chatsdk.network.websocket.model.ContentType) r10
            if (r10 == 0) goto L_0x00e6
            r15 = r17
            r2 = r18
            r12 = r19
            r11 = r20
            goto L_0x01eb
        L_0x00e6:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"contentT…, \"content_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00f0:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.EventType> r2 = r0.eventTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            com.deliveryhero.chatsdk.network.websocket.model.EventType r2 = (com.deliveryhero.chatsdk.network.websocket.model.EventType) r2
            if (r2 == 0) goto L_0x0107
            r9 = r2
            r15 = r17
            r2 = r18
            r12 = r19
            r11 = r20
            r10 = r21
            goto L_0x01ed
        L_0x0107:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"eventTyp…    \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0111:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.FileContent> r2 = r0.fileContentAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            com.deliveryhero.chatsdk.network.websocket.model.FileContent r8 = (com.deliveryhero.chatsdk.network.websocket.model.FileContent) r8
            if (r8 == 0) goto L_0x012a
            r15 = r17
            r2 = r18
            r12 = r19
            r11 = r20
            r10 = r21
            r9 = r22
            goto L_0x01ef
        L_0x012a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r5, r5, r1)
            java.lang.String r2 = "unexpectedNull(\"image\",\n…         \"image\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0134:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.MessageType> r2 = r0.messageTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            com.deliveryhero.chatsdk.network.websocket.model.MessageType r2 = (com.deliveryhero.chatsdk.network.websocket.model.MessageType) r2
            if (r2 == 0) goto L_0x014f
            r7 = r2
            r15 = r17
            r2 = r18
            r12 = r19
            r11 = r20
            r10 = r21
            r9 = r22
            r8 = r23
            goto L_0x01f1
        L_0x014f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r8, r1)
            java.lang.String r2 = "unexpectedNull(\"messageT…, \"message_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0159:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0176
            r6 = r2
            r15 = r17
            r2 = r18
            r12 = r19
            r11 = r20
            r10 = r21
            r9 = r22
            r8 = r23
            r7 = r24
            goto L_0x01f3
        L_0x0176:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r6, r1)
            java.lang.String r2 = "unexpectedNull(\"content\"…       \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0180:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x019e
            r15 = r17
            r2 = r18
            r12 = r19
            r11 = r20
            r10 = r21
            r9 = r22
            r8 = r23
            r7 = r24
            r6 = r25
            goto L_0x01f5
        L_0x019e:
            r2 = r30
            r3 = r31
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"channelI…    \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01ac:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x01cd
            r15 = r17
            r2 = r18
            r12 = r19
            r11 = r20
            r10 = r21
            r9 = r22
            r8 = r23
            r7 = r24
            r6 = r25
            r5 = r26
            goto L_0x0019
        L_0x01cd:
            r2 = r28
            r3 = r29
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"messageI…    \"message_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01db:
            r35.skipName()
            r35.skipValue()
        L_0x01e1:
            r15 = r17
        L_0x01e3:
            r2 = r18
        L_0x01e5:
            r12 = r19
        L_0x01e7:
            r11 = r20
        L_0x01e9:
            r10 = r21
        L_0x01eb:
            r9 = r22
        L_0x01ed:
            r8 = r23
        L_0x01ef:
            r7 = r24
        L_0x01f1:
            r6 = r25
        L_0x01f3:
            r5 = r26
        L_0x01f5:
            r4 = r27
            goto L_0x0019
        L_0x01f9:
            r32 = r28
            r33 = r29
            r0 = r30
            r3 = r31
            r35.endObject()
            com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketFileMessage r28 = new com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketFileMessage
            if (r27 == 0) goto L_0x0292
            if (r26 == 0) goto L_0x0288
            if (r25 == 0) goto L_0x027e
            if (r24 == 0) goto L_0x0274
            if (r23 == 0) goto L_0x026a
            if (r22 == 0) goto L_0x0260
            if (r21 == 0) goto L_0x0256
            if (r20 == 0) goto L_0x024c
            if (r19 == 0) goto L_0x0242
            if (r18 == 0) goto L_0x0238
            long r13 = r18.longValue()
            r3 = r28
            r4 = r27
            r5 = r26
            r6 = r25
            r7 = r24
            r8 = r23
            r9 = r22
            r10 = r21
            r11 = r20
            r12 = r19
            r15 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16)
            return r28
        L_0x0238:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r4, r4, r1)
            java.lang.String r1 = "missingProperty(\"timestamp\", \"timestamp\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0242:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r14, r13, r1)
            java.lang.String r1 = "missingProperty(\"senderN…sender_nickname\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x024c:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r15, r1)
            java.lang.String r1 = "missingProperty(\"senderId\", \"sender_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0256:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r11, r12, r1)
            java.lang.String r1 = "missingProperty(\"content…ype\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0260:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r9, r10, r1)
            java.lang.String r1 = "missingProperty(\"eventType\", \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x026a:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r5, r5, r1)
            java.lang.String r1 = "missingProperty(\"image\", \"image\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0274:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r7, r8, r1)
            java.lang.String r1 = "missingProperty(\"message…ype\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x027e:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r1 = "missingProperty(\"content\", \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0288:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r3, r1)
            java.lang.String r1 = "missingProperty(\"channelId\", \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0292:
            r0 = r32
            r2 = r33
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r0, r1)
            java.lang.String r1 = "missingProperty(\"messageId\", \"message_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage_IncomingWebSocketFileMessageJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketSubMessage$IncomingWebSocketFileMessage");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable IncomingWebSocketSubMessage.IncomingWebSocketFileMessage incomingWebSocketFileMessage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (incomingWebSocketFileMessage != null) {
            jsonWriter.beginObject();
            jsonWriter.name("message_id");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketFileMessage.getMessageId());
            jsonWriter.name(PushNotificationParser.CHANNEL_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketFileMessage.getChannelId());
            jsonWriter.name("content");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketFileMessage.getContent());
            jsonWriter.name("message_type");
            this.messageTypeAdapter.toJson(jsonWriter, incomingWebSocketFileMessage.getMessageType());
            jsonWriter.name("image");
            this.fileContentAdapter.toJson(jsonWriter, incomingWebSocketFileMessage.getImage());
            jsonWriter.name("event_type");
            this.eventTypeAdapter.toJson(jsonWriter, incomingWebSocketFileMessage.getEventType());
            jsonWriter.name("content_type");
            this.contentTypeAdapter.toJson(jsonWriter, incomingWebSocketFileMessage.getContentType());
            jsonWriter.name("sender_id");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketFileMessage.getSenderId());
            jsonWriter.name("sender_nickname");
            this.stringAdapter.toJson(jsonWriter, incomingWebSocketFileMessage.getSenderNickname());
            jsonWriter.name("timestamp");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(incomingWebSocketFileMessage.getTimestamp()));
            jsonWriter.name("meta");
            this.nullableMetaDataContentAdapter.toJson(jsonWriter, incomingWebSocketFileMessage.getMetadata());
            jsonWriter.name(EventDetailsKeys.CORRELATION_ID);
            this.nullableStringAdapter.toJson(jsonWriter, incomingWebSocketFileMessage.getCorrelationId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
