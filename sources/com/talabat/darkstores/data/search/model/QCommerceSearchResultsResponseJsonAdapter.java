package com.talabat.darkstores.data.search.model;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/data/search/model/QCommerceSearchResultsResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/search/model/QCommerceSearchResultsResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "searchResultsResponseAdapter", "Lcom/talabat/darkstores/data/search/model/SearchResultsResponse;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceSearchResultsResponseJsonAdapter extends JsonAdapter<QCommerceSearchResultsResponse> {
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<SearchResultsResponse> searchResultsResponseAdapter;

    public QCommerceSearchResultsResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("result");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"result\")");
        this.options = of2;
        JsonAdapter<SearchResultsResponse> adapter = moshi.adapter(SearchResultsResponse.class, SetsKt__SetsKt.emptySet(), "result");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(SearchResu…va, emptySet(), \"result\")");
        this.searchResultsResponseAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("QCommerceSearchResultsResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public QCommerceSearchResultsResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        SearchResultsResponse searchResultsResponse = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (searchResultsResponse = this.searchResultsResponseAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("result", "result", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"result\", \"result\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (searchResultsResponse != null) {
            return new QCommerceSearchResultsResponse(searchResultsResponse);
        }
        JsonDataException missingProperty = Util.missingProperty("result", "result", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"result\", \"result\", reader)");
        throw missingProperty;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable QCommerceSearchResultsResponse qCommerceSearchResultsResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (qCommerceSearchResultsResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("result");
            this.searchResultsResponseAdapter.toJson(jsonWriter, qCommerceSearchResultsResponse.getResult());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
