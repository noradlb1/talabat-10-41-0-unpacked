package com.talabat.darkstores.data.discovery.model;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/PointJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/discovery/model/Point;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "doubleAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PointJsonAdapter extends JsonAdapter<Point> {
    @NotNull
    private final JsonAdapter<Double> doubleAdapter;
    @NotNull
    private final JsonReader.Options options;

    public PointJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("longitude", "latitude");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"longitude\", \"latitude\")");
        this.options = of2;
        JsonAdapter<Double> adapter = moshi.adapter(Double.TYPE, SetsKt__SetsKt.emptySet(), "longitude");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Double::cl…Set(),\n      \"longitude\")");
        this.doubleAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(27);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Point");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public Point fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Double d11 = null;
        Double d12 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                d11 = this.doubleAdapter.fromJson(jsonReader);
                if (d11 == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("longitude", "longitude", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"longitud…     \"longitude\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (d12 = this.doubleAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("latitude", "latitude", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"latitude…      \"latitude\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (d11 != null) {
            double doubleValue = d11.doubleValue();
            if (d12 != null) {
                return new Point(doubleValue, d12.doubleValue());
            }
            JsonDataException missingProperty = Util.missingProperty("latitude", "latitude", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"latitude\", \"latitude\", reader)");
            throw missingProperty;
        }
        JsonDataException missingProperty2 = Util.missingProperty("longitude", "longitude", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"longitude\", \"longitude\", reader)");
        throw missingProperty2;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Point point) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (point != null) {
            jsonWriter.beginObject();
            jsonWriter.name("longitude");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(point.getLongitude()));
            jsonWriter.name("latitude");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(point.getLatitude()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
