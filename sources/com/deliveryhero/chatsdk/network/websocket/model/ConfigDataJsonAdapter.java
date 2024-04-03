package com.deliveryhero.chatsdk.network.websocket.model;

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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/ConfigDataJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/ConfigData;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "mapOfStringStringAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfigDataJsonAdapter extends JsonAdapter<ConfigData> {
    @NotNull
    private final JsonAdapter<Map<String, String>> mapOfStringStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public ConfigDataJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("name", "data");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"name\", \"data\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.stringAdapter = adapter;
        JsonAdapter<Map<String, String>> adapter2 = moshi.adapter(Types.newParameterizedType(Map.class, cls, cls), SetsKt__SetsKt.emptySet(), "data");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…ava), emptySet(), \"data\")");
        this.mapOfStringStringAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ConfigData");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public ConfigData fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Map map = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("name", "name", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (map = this.mapOfStringStringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("data_", "data", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"data_\",\n…          \"data\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("name", "name", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty;
        } else if (map != null) {
            return new ConfigData(str, map);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("data_", "data", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"data_\", \"data\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable ConfigData configData) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (configData != null) {
            jsonWriter.beginObject();
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, configData.getName());
            jsonWriter.name("data");
            this.mapOfStringStringAdapter.toJson(jsonWriter, configData.getData());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
