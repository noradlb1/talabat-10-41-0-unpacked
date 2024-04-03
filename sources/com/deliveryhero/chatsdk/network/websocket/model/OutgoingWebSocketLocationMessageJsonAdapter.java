package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.deliveryhero.customerchat.eventTracking.constants.EventDetailsKeys;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketLocationMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/OutgoingWebSocketLocationMessage;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "contentTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/ContentType;", "eventTypeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/EventType;", "locationContentAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContent;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OutgoingWebSocketLocationMessageJsonAdapter extends JsonAdapter<OutgoingWebSocketLocationMessage> {
    @NotNull
    private final JsonAdapter<ContentType> contentTypeAdapter;
    @NotNull
    private final JsonAdapter<EventType> eventTypeAdapter;
    @NotNull
    private final JsonAdapter<LocationContent> locationContentAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public OutgoingWebSocketLocationMessageJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(PushNotificationParser.CHANNEL_ID_KEY, "content", "content_type", EventDetailsKeys.CORRELATION_ID, "event_type", "sender_id");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"channel_id\", \"conten…event_type\", \"sender_id\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"channelId\")");
        this.stringAdapter = adapter;
        JsonAdapter<LocationContent> adapter2 = moshi.adapter(LocationContent.class, SetsKt__SetsKt.emptySet(), "content");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(LocationCo…a, emptySet(), \"content\")");
        this.locationContentAdapter = adapter2;
        JsonAdapter<ContentType> adapter3 = moshi.adapter(ContentType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(ContentTyp…mptySet(), \"contentType\")");
        this.contentTypeAdapter = adapter3;
        JsonAdapter<EventType> adapter4 = moshi.adapter(EventType.class, SetsKt__SetsKt.emptySet(), AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(EventType:… emptySet(), \"eventType\")");
        this.eventTypeAdapter = adapter4;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("OutgoingWebSocketLocationMessage");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00db, code lost:
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00dd, code lost:
        r8 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00df, code lost:
        r7 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e1, code lost:
        r6 = r19;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketLocationMessage fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r21.beginObject()
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
        L_0x0013:
            boolean r2 = r21.hasNext()
            java.lang.String r3 = "sender_id"
            java.lang.String r10 = "senderId"
            java.lang.String r11 = "event_type"
            java.lang.String r12 = "eventType"
            java.lang.String r13 = "correlation_id"
            java.lang.String r14 = "correlationId"
            java.lang.String r15 = "content_type"
            r16 = r9
            java.lang.String r9 = "contentType"
            r17 = r8
            java.lang.String r8 = "channel_id"
            r18 = r7
            java.lang.String r7 = "channelId"
            r19 = r6
            java.lang.String r6 = "content"
            if (r2 == 0) goto L_0x00e5
            com.squareup.moshi.JsonReader$Options r2 = r0.options
            int r2 = r1.selectName(r2)
            switch(r2) {
                case -1: goto L_0x00d5;
                case 0: goto L_0x00bf;
                case 1: goto L_0x00a9;
                case 2: goto L_0x008c;
                case 3: goto L_0x0072;
                case 4: goto L_0x0059;
                case 5: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x00db
        L_0x0042:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x004f
            goto L_0x00dd
        L_0x004f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"senderId…     \"sender_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0059:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.EventType> r2 = r0.eventTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            com.deliveryhero.chatsdk.network.websocket.model.EventType r8 = (com.deliveryhero.chatsdk.network.websocket.model.EventType) r8
            if (r8 == 0) goto L_0x0068
            r9 = r16
            goto L_0x00df
        L_0x0068:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"eventTyp…    \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0072:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0082
            r9 = r16
            r8 = r17
            goto L_0x00e1
        L_0x0082:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"correlat…\"correlation_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x008c:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.ContentType> r2 = r0.contentTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            com.deliveryhero.chatsdk.network.websocket.model.ContentType r6 = (com.deliveryhero.chatsdk.network.websocket.model.ContentType) r6
            if (r6 == 0) goto L_0x009f
            r9 = r16
            r8 = r17
            r7 = r18
            goto L_0x0013
        L_0x009f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"contentT…, \"content_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00a9:
            com.squareup.moshi.JsonAdapter<com.deliveryhero.chatsdk.network.websocket.model.LocationContent> r2 = r0.locationContentAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            com.deliveryhero.chatsdk.network.websocket.model.LocationContent r5 = (com.deliveryhero.chatsdk.network.websocket.model.LocationContent) r5
            if (r5 == 0) goto L_0x00b5
            goto L_0x00db
        L_0x00b5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r6, r1)
            java.lang.String r2 = "unexpectedNull(\"content\", \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00bf:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00cb
            goto L_0x00db
        L_0x00cb:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r8, r1)
            java.lang.String r2 = "unexpectedNull(\"channelI…    \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00d5:
            r21.skipName()
            r21.skipValue()
        L_0x00db:
            r9 = r16
        L_0x00dd:
            r8 = r17
        L_0x00df:
            r7 = r18
        L_0x00e1:
            r6 = r19
            goto L_0x0013
        L_0x00e5:
            r21.endObject()
            com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketLocationMessage r2 = new com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketLocationMessage
            if (r4 == 0) goto L_0x0135
            if (r5 == 0) goto L_0x012b
            if (r19 == 0) goto L_0x0121
            if (r18 == 0) goto L_0x0117
            if (r17 == 0) goto L_0x010d
            if (r16 == 0) goto L_0x0103
            r3 = r2
            r6 = r19
            r7 = r18
            r8 = r17
            r9 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r2
        L_0x0103:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r3, r1)
            java.lang.String r2 = "missingProperty(\"senderId\", \"sender_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x010d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r11, r1)
            java.lang.String r2 = "missingProperty(\"eventType\", \"event_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0117:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r13, r1)
            java.lang.String r2 = "missingProperty(\"correla…\"correlation_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0121:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r15, r1)
            java.lang.String r2 = "missingProperty(\"content…ype\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x012b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r2 = "missingProperty(\"content\", \"content\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0135:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r8, r1)
            java.lang.String r2 = "missingProperty(\"channelId\", \"channel_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketLocationMessageJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.deliveryhero.chatsdk.network.websocket.model.OutgoingWebSocketLocationMessage");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable OutgoingWebSocketLocationMessage outgoingWebSocketLocationMessage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (outgoingWebSocketLocationMessage != null) {
            jsonWriter.beginObject();
            jsonWriter.name(PushNotificationParser.CHANNEL_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, outgoingWebSocketLocationMessage.getChannelId());
            jsonWriter.name("content");
            this.locationContentAdapter.toJson(jsonWriter, outgoingWebSocketLocationMessage.getContent());
            jsonWriter.name("content_type");
            this.contentTypeAdapter.toJson(jsonWriter, outgoingWebSocketLocationMessage.getContentType());
            jsonWriter.name(EventDetailsKeys.CORRELATION_ID);
            this.stringAdapter.toJson(jsonWriter, outgoingWebSocketLocationMessage.getCorrelationId());
            jsonWriter.name("event_type");
            this.eventTypeAdapter.toJson(jsonWriter, outgoingWebSocketLocationMessage.getEventType());
            jsonWriter.name("sender_id");
            this.stringAdapter.toJson(jsonWriter, outgoingWebSocketLocationMessage.getSenderId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
