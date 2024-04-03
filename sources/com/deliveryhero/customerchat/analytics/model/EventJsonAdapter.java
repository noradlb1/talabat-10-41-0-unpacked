package com.deliveryhero.customerchat.analytics.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R$\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/model/EventJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/customerchat/analytics/model/Event;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableMapOfStringNullableStringAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventJsonAdapter extends JsonAdapter<Event> {
    @NotNull
    private final JsonAdapter<Map<String, String>> nullableMapOfStringNullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public EventJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("id", "name", "details");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"id\", \"name\", \"details\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Map<String, String>> adapter2 = moshi.adapter(Types.newParameterizedType(Map.class, cls, cls), SetsKt__SetsKt.emptySet(), "details");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…), emptySet(), \"details\")");
        this.nullableMapOfStringNullableStringAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(27);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Event");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public Event fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        Map map = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("name", "name", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                map = this.nullableMapOfStringNullableStringAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (str2 != null) {
            return new Event(str, str2, map);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("name", "name", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Event event) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (event != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, event.getId());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, event.getName());
            jsonWriter.name("details");
            this.nullableMapOfStringNullableStringAdapter.toJson(jsonWriter, event.getDetails());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
