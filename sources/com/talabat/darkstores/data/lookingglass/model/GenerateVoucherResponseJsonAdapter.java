package com.talabat.darkstores.data.lookingglass.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/data/lookingglass/model/GenerateVoucherResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/lookingglass/model/GenerateVoucherResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GenerateVoucherResponseJsonAdapter extends JsonAdapter<GenerateVoucherResponse> {
    @NotNull
    private final JsonReader.Options options;

    public GenerateVoucherResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(new String[0]);
        Intrinsics.checkNotNullExpressionValue(of2, "of()");
        this.options = of2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("GenerateVoucherResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public GenerateVoucherResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(this.options) == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new GenerateVoucherResponse();
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable GenerateVoucherResponse generateVoucherResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (generateVoucherResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
