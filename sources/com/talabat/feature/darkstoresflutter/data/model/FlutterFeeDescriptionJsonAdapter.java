package com.talabat.feature.darkstoresflutter.data.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/model/FlutterFeeDescriptionJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterFeeDescription;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterFeeDescriptionJsonAdapter extends JsonAdapter<FlutterFeeDescription> {
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public FlutterFeeDescriptionJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("type", "name", "description", "url", "urlText");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"type\", \"name\", \"desc…,\n      \"url\", \"urlText\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…      emptySet(), \"name\")");
        this.nullableStringAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FlutterFeeDescription");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public FlutterFeeDescription fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"type\", \"type\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                str3 = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 3) {
                str4 = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 4) {
                str5 = this.nullableStringAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        if (str != null) {
            return new FlutterFeeDescription(str, str2, str3, str4, str5);
        }
        JsonDataException missingProperty = Util.missingProperty("type", "type", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"type\", \"type\", reader)");
        throw missingProperty;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable FlutterFeeDescription flutterFeeDescription) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (flutterFeeDescription != null) {
            jsonWriter.beginObject();
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, flutterFeeDescription.getType());
            jsonWriter.name("name");
            this.nullableStringAdapter.toJson(jsonWriter, flutterFeeDescription.getName());
            jsonWriter.name("description");
            this.nullableStringAdapter.toJson(jsonWriter, flutterFeeDescription.getDescription());
            jsonWriter.name("url");
            this.nullableStringAdapter.toJson(jsonWriter, flutterFeeDescription.getUrl());
            jsonWriter.name("urlText");
            this.nullableStringAdapter.toJson(jsonWriter, flutterFeeDescription.getUrlText());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
