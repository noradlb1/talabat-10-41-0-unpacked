package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.network.websocket.model.MessagesHistoryRequest;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.deliveryhero.customerchat.eventTracking.constants.EventDetailsKeys;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.UrlConstantsKt;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "intAdapter", "", "longAdapter", "", "modeAdapter", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryRequest$Mode;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessagesHistoryRequestJsonAdapter extends JsonAdapter<MessagesHistoryRequest> {
    @Nullable
    private volatile Constructor<MessagesHistoryRequest> constructorRef;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<Long> longAdapter;
    @NotNull
    private final JsonAdapter<MessagesHistoryRequest.Mode> modeAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public MessagesHistoryRequestJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(PushNotificationParser.CHANNEL_ID_KEY, UrlConstantsKt.LIMIT, "timestamp", SessionsConfigParameter.SYNC_MODE, "event_type", EventDetailsKeys.CORRELATION_ID);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"channel_id\", \"limit\"…_type\", \"correlation_id\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"channelId\")");
        this.stringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), UrlConstantsKt.LIMIT);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…ava, emptySet(), \"limit\")");
        this.intAdapter = adapter2;
        JsonAdapter<Long> adapter3 = moshi.adapter(Long.TYPE, SetsKt__SetsKt.emptySet(), "timestamp");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Long::clas…Set(),\n      \"timestamp\")");
        this.longAdapter = adapter3;
        JsonAdapter<MessagesHistoryRequest.Mode> adapter4 = moshi.adapter(MessagesHistoryRequest.Mode.class, SetsKt__SetsKt.emptySet(), SessionsConfigParameter.SYNC_MODE);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(MessagesHi…java, emptySet(), \"mode\")");
        this.modeAdapter = adapter4;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("MessagesHistoryRequest");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public MessagesHistoryRequest fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        Integer num = null;
        String str = null;
        Long l11 = null;
        MessagesHistoryRequest.Mode mode = null;
        String str2 = null;
        String str3 = null;
        while (true) {
            String str4 = str3;
            if (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(this.options)) {
                    case -1:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(jsonReader2);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull(RemoteMessageConst.Notification.CHANNEL_ID, PushNotificationParser.CHANNEL_ID_KEY, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"channelI…    \"channel_id\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        num = this.intAdapter.fromJson(jsonReader2);
                        if (num == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull(UrlConstantsKt.LIMIT, UrlConstantsKt.LIMIT, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"limit\", …mit\",\n            reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        l11 = this.longAdapter.fromJson(jsonReader2);
                        if (l11 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("timestamp", "timestamp", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"timestam…     \"timestamp\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        mode = this.modeAdapter.fromJson(jsonReader2);
                        if (mode == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull(SessionsConfigParameter.SYNC_MODE, SessionsConfigParameter.SYNC_MODE, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"mode\", \"mode\",\n            reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        str2 = this.stringAdapter.fromJson(jsonReader2);
                        if (str2 != null) {
                            i11 &= -17;
                            break;
                        } else {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, "event_type", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"eventTyp…    \"event_type\", reader)");
                            throw unexpectedNull5;
                        }
                    case 5:
                        str3 = this.stringAdapter.fromJson(jsonReader2);
                        if (str3 != null) {
                            continue;
                        } else {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("correlationId", EventDetailsKeys.CORRELATION_ID, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"correlat…\"correlation_id\", reader)");
                            throw unexpectedNull6;
                        }
                }
                str3 = str4;
            } else {
                jsonReader.endObject();
                String str5 = PushNotificationParser.CHANNEL_ID_KEY;
                String str6 = "missingProperty(\"channelId\", \"channel_id\", reader)";
                if (i11 != -17) {
                    String str7 = RemoteMessageConst.Notification.CHANNEL_ID;
                    Constructor<MessagesHistoryRequest> constructor = this.constructorRef;
                    String str8 = "missingProperty(\"limit\", \"limit\", reader)";
                    int i12 = 8;
                    if (constructor == null) {
                        Class<String> cls = String.class;
                        Class cls2 = Integer.TYPE;
                        constructor = MessagesHistoryRequest.class.getDeclaredConstructor(new Class[]{cls, cls2, Long.TYPE, MessagesHistoryRequest.Mode.class, cls, cls, cls2, Util.DEFAULT_CONSTRUCTOR_MARKER});
                        this.constructorRef = constructor;
                        Intrinsics.checkNotNullExpressionValue(constructor, "MessagesHistoryRequest::…his.constructorRef = it }");
                        i12 = 8;
                    }
                    Object[] objArr = new Object[i12];
                    if (str != null) {
                        objArr[0] = str;
                        if (num != null) {
                            objArr[1] = Integer.valueOf(num.intValue());
                            if (l11 != null) {
                                objArr[2] = Long.valueOf(l11.longValue());
                                if (mode != null) {
                                    objArr[3] = mode;
                                    objArr[4] = str2;
                                    if (str4 != null) {
                                        objArr[5] = str4;
                                        objArr[6] = Integer.valueOf(i11);
                                        objArr[7] = null;
                                        MessagesHistoryRequest newInstance = constructor.newInstance(objArr);
                                        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                                        return newInstance;
                                    }
                                    JsonDataException missingProperty = Util.missingProperty("correlationId", EventDetailsKeys.CORRELATION_ID, jsonReader2);
                                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"correla…\"correlation_id\", reader)");
                                    throw missingProperty;
                                }
                                JsonDataException missingProperty2 = Util.missingProperty(SessionsConfigParameter.SYNC_MODE, SessionsConfigParameter.SYNC_MODE, jsonReader2);
                                Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"mode\", \"mode\", reader)");
                                throw missingProperty2;
                            }
                            JsonDataException missingProperty3 = Util.missingProperty("timestamp", "timestamp", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"timestamp\", \"timestamp\", reader)");
                            throw missingProperty3;
                        }
                        JsonDataException missingProperty4 = Util.missingProperty(UrlConstantsKt.LIMIT, UrlConstantsKt.LIMIT, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(missingProperty4, str8);
                        throw missingProperty4;
                    }
                    JsonDataException missingProperty5 = Util.missingProperty(str7, str5, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, str6);
                    throw missingProperty5;
                } else if (str == null) {
                    JsonDataException missingProperty6 = Util.missingProperty(RemoteMessageConst.Notification.CHANNEL_ID, str5, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, str6);
                    throw missingProperty6;
                } else if (num != null) {
                    int intValue = num.intValue();
                    if (l11 != null) {
                        long longValue = l11.longValue();
                        if (mode == null) {
                            JsonDataException missingProperty7 = Util.missingProperty(SessionsConfigParameter.SYNC_MODE, SessionsConfigParameter.SYNC_MODE, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"mode\", \"mode\", reader)");
                            throw missingProperty7;
                        } else if (str2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        } else if (str4 != null) {
                            return new MessagesHistoryRequest(str, intValue, longValue, mode, str2, str4);
                        } else {
                            JsonDataException missingProperty8 = Util.missingProperty("correlationId", EventDetailsKeys.CORRELATION_ID, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(missingProperty8, "missingProperty(\"correla…\"correlation_id\", reader)");
                            throw missingProperty8;
                        }
                    } else {
                        JsonDataException missingProperty9 = Util.missingProperty("timestamp", "timestamp", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(missingProperty9, "missingProperty(\"timestamp\", \"timestamp\", reader)");
                        throw missingProperty9;
                    }
                } else {
                    JsonDataException missingProperty10 = Util.missingProperty(UrlConstantsKt.LIMIT, UrlConstantsKt.LIMIT, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty10, "missingProperty(\"limit\", \"limit\", reader)");
                    throw missingProperty10;
                }
            }
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable MessagesHistoryRequest messagesHistoryRequest) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messagesHistoryRequest != null) {
            jsonWriter.beginObject();
            jsonWriter.name(PushNotificationParser.CHANNEL_ID_KEY);
            this.stringAdapter.toJson(jsonWriter, messagesHistoryRequest.getChannelId());
            jsonWriter.name(UrlConstantsKt.LIMIT);
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(messagesHistoryRequest.getLimit()));
            jsonWriter.name("timestamp");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(messagesHistoryRequest.getTimestamp()));
            jsonWriter.name(SessionsConfigParameter.SYNC_MODE);
            this.modeAdapter.toJson(jsonWriter, messagesHistoryRequest.getMode());
            jsonWriter.name("event_type");
            this.stringAdapter.toJson(jsonWriter, messagesHistoryRequest.getEventType());
            jsonWriter.name(EventDetailsKeys.CORRELATION_ID);
            this.stringAdapter.toJson(jsonWriter, messagesHistoryRequest.getCorrelationId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
