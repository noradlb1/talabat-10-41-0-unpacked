package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.customerchat.eventTracking.constants.EventDetailsKeys;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfIncomingWebSocketMessageAdapter", "", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessagesHistoryResponseJsonAdapter extends JsonAdapter<MessagesHistoryResponse> {
    @Nullable
    private volatile Constructor<MessagesHistoryResponse> constructorRef;
    @NotNull
    private final JsonAdapter<List<IncomingWebSocketMessage>> listOfIncomingWebSocketMessageAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public MessagesHistoryResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(EventDetailsKeys.CORRELATION_ID, "messages");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"correlation_id\", \"messages\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "correlationId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…),\n      \"correlationId\")");
        this.stringAdapter = adapter;
        JsonAdapter<List<IncomingWebSocketMessage>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, IncomingWebSocketMessage.class), SetsKt__SetsKt.emptySet(), "messages");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…, emptySet(), \"messages\")");
        this.listOfIncomingWebSocketMessageAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("MessagesHistoryResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public MessagesHistoryResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        List list = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("correlationId", EventDetailsKeys.CORRELATION_ID, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"correlat…\"correlation_id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                list = this.listOfIncomingWebSocketMessageAdapter.fromJson(jsonReader);
                if (list != null) {
                    i11 &= -3;
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("messages", "messages", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"messages\", \"messages\", reader)");
                    throw unexpectedNull2;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (i11 != -3) {
            Constructor<MessagesHistoryResponse> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = MessagesHistoryResponse.class.getDeclaredConstructor(new Class[]{String.class, List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "MessagesHistoryResponse:…his.constructorRef = it }");
            }
            Object[] objArr = new Object[4];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = list;
                objArr[2] = Integer.valueOf(i11);
                objArr[3] = null;
                MessagesHistoryResponse newInstance = constructor.newInstance(objArr);
                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException missingProperty = Util.missingProperty("correlationId", EventDetailsKeys.CORRELATION_ID, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"correla…\"correlation_id\", reader)");
            throw missingProperty;
        } else if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty("correlationId", EventDetailsKeys.CORRELATION_ID, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"correla…\"correlation_id\", reader)");
            throw missingProperty2;
        } else if (list != null) {
            return new MessagesHistoryResponse(str, list);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage>");
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable MessagesHistoryResponse messagesHistoryResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messagesHistoryResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name(EventDetailsKeys.CORRELATION_ID);
            this.stringAdapter.toJson(jsonWriter, messagesHistoryResponse.getCorrelationId());
            jsonWriter.name("messages");
            this.listOfIncomingWebSocketMessageAdapter.toJson(jsonWriter, messagesHistoryResponse.getMessages());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
