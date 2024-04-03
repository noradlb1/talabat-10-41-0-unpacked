package com.deliveryhero.customerchat.fwf;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/FeatureInfoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/customerchat/fwf/FeatureInfo;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureInfoJsonAdapter extends JsonAdapter<FeatureInfo> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @NotNull
    private final JsonReader.Options options;

    public FeatureInfoJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("variation");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"variation\")");
        this.options = of2;
        JsonAdapter<Boolean> adapter = moshi.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "variation");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Boolean::c…Set(),\n      \"variation\")");
        this.booleanAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FeatureInfo");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public FeatureInfo fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Boolean bool = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (bool = this.booleanAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("variation", "variation", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"variatio…     \"variation\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (bool != null) {
            return new FeatureInfo(bool.booleanValue());
        }
        JsonDataException missingProperty = Util.missingProperty("variation", "variation", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"variation\", \"variation\", reader)");
        throw missingProperty;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable FeatureInfo featureInfo) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (featureInfo != null) {
            jsonWriter.beginObject();
            jsonWriter.name("variation");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(featureInfo.getVariation()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
