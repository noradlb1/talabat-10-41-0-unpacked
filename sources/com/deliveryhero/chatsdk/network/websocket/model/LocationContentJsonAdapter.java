package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.domain.model.Source;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContentJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContent;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "doubleAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "sourceAdapter", "Lcom/deliveryhero/chatsdk/domain/model/Source;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationContentJsonAdapter extends JsonAdapter<LocationContent> {
    @NotNull
    private final JsonAdapter<Double> doubleAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<Source> sourceAdapter;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public LocationContentJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("accuracy", "lat", "lon", "source");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"accuracy\", \"lat\", \"lon\",\n      \"source\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "accuracy");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ySet(),\n      \"accuracy\")");
        this.stringAdapter = adapter;
        JsonAdapter<Double> adapter2 = moshi.adapter(Double.TYPE, SetsKt__SetsKt.emptySet(), "latitude");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Double::cl…ySet(),\n      \"latitude\")");
        this.doubleAdapter = adapter2;
        JsonAdapter<Source> adapter3 = moshi.adapter(Source.class, SetsKt__SetsKt.emptySet(), "source");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Source::cl…ptySet(),\n      \"source\")");
        this.sourceAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("LocationContent");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public LocationContent fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Double d11 = null;
        Double d12 = null;
        String str = null;
        Source source = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("accuracy", "accuracy", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"accuracy…      \"accuracy\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                d11 = this.doubleAdapter.fromJson(jsonReader);
                if (d11 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("latitude", "lat", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"latitude…           \"lat\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                d12 = this.doubleAdapter.fromJson(jsonReader);
                if (d12 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("longitude", "lon", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"longitud…           \"lon\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (source = this.sourceAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("source", "source", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"source\",…        \"source\", reader)");
                throw unexpectedNull4;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("accuracy", "accuracy", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"accuracy\", \"accuracy\", reader)");
            throw missingProperty;
        } else if (d11 != null) {
            double doubleValue = d11.doubleValue();
            if (d12 != null) {
                double doubleValue2 = d12.doubleValue();
                if (source != null) {
                    return new LocationContent(str, doubleValue, doubleValue2, source);
                }
                JsonDataException missingProperty2 = Util.missingProperty("source", "source", jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"source\", \"source\", reader)");
                throw missingProperty2;
            }
            JsonDataException missingProperty3 = Util.missingProperty("longitude", "lon", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"longitude\", \"lon\", reader)");
            throw missingProperty3;
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("latitude", "lat", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"latitude\", \"lat\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable LocationContent locationContent) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (locationContent != null) {
            jsonWriter.beginObject();
            jsonWriter.name("accuracy");
            this.stringAdapter.toJson(jsonWriter, locationContent.getAccuracy());
            jsonWriter.name("lat");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(locationContent.getLatitude()));
            jsonWriter.name("lon");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(locationContent.getLongitude()));
            jsonWriter.name("source");
            this.sourceAdapter.toJson(jsonWriter, locationContent.getSource());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
