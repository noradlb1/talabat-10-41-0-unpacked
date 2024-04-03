package com.talabat.darkstores.data.mission.control.model;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "missionControlProductsResultAdapter", "Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResult;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionControlProductsResponseJsonAdapter extends JsonAdapter<MissionControlProductsResponse> {
    @NotNull
    private final JsonAdapter<MissionControlProductsResult> missionControlProductsResultAdapter;
    @NotNull
    private final JsonReader.Options options;

    public MissionControlProductsResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("result");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"result\")");
        this.options = of2;
        JsonAdapter<MissionControlProductsResult> adapter = moshi.adapter(MissionControlProductsResult.class, SetsKt__SetsKt.emptySet(), "result");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(MissionCon…va, emptySet(), \"result\")");
        this.missionControlProductsResultAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("MissionControlProductsResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public MissionControlProductsResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        MissionControlProductsResult missionControlProductsResult = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (missionControlProductsResult = this.missionControlProductsResultAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("result", "result", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"result\", \"result\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (missionControlProductsResult != null) {
            return new MissionControlProductsResponse(missionControlProductsResult);
        }
        JsonDataException missingProperty = Util.missingProperty("result", "result", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"result\", \"result\", reader)");
        throw missingProperty;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable MissionControlProductsResponse missionControlProductsResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (missionControlProductsResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("result");
            this.missionControlProductsResultAdapter.toJson(jsonWriter, missionControlProductsResponse.getResult());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
