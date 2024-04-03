package com.deliveryhero.customerchat.fwf;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/FWFRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/customerchat/fwf/FWFRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfStringAdapter", "", "", "nullableCustomAdapter", "Lcom/deliveryhero/customerchat/fwf/Custom;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FWFRequestJsonAdapter extends JsonAdapter<FWFRequest> {
    @NotNull
    private final JsonAdapter<List<String>> listOfStringAdapter;
    @NotNull
    private final JsonAdapter<Custom> nullableCustomAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public FWFRequestJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("custom", "featureList", "userId");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"custom\", \"featureList\", \"userId\")");
        this.options = of2;
        JsonAdapter<Custom> adapter = moshi.adapter(Custom.class, SetsKt__SetsKt.emptySet(), "custom");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Custom::cl…    emptySet(), \"custom\")");
        this.nullableCustomAdapter = adapter;
        Class<String> cls = String.class;
        JsonAdapter<List<String>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, cls), SetsKt__SetsKt.emptySet(), "featureList");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…t(),\n      \"featureList\")");
        this.listOfStringAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "userId");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl…ptySet(),\n      \"userId\")");
        this.stringAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FWFRequest");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public FWFRequest fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Custom custom = null;
        List list = null;
        String str = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                custom = this.nullableCustomAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                list = this.listOfStringAdapter.fromJson(jsonReader);
                if (list == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("featureList", "featureList", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"featureL…\", \"featureList\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 2 && (str = this.stringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("userId", "userId", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"userId\",…        \"userId\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (list == null) {
            JsonDataException missingProperty = Util.missingProperty("featureList", "featureList", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"feature…ist\",\n            reader)");
            throw missingProperty;
        } else if (str != null) {
            return new FWFRequest(custom, list, str);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("userId", "userId", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"userId\", \"userId\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable FWFRequest fWFRequest) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (fWFRequest != null) {
            jsonWriter.beginObject();
            jsonWriter.name("custom");
            this.nullableCustomAdapter.toJson(jsonWriter, fWFRequest.getCustom());
            jsonWriter.name("featureList");
            this.listOfStringAdapter.toJson(jsonWriter, fWFRequest.getFeatureList());
            jsonWriter.name("userId");
            this.stringAdapter.toJson(jsonWriter, fWFRequest.getUserId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
