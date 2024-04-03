package com.talabat.darkstores.data.search.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import com.visa.checkout.PurchaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchResultsResponse_ItemCountsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/search/model/SearchResultsResponse$ItemCounts;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsResponse_ItemCountsJsonAdapter extends JsonAdapter<SearchResultsResponse.ItemCounts> {
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonReader.Options options;

    public SearchResultsResponse_ItemCountsJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("returned", PurchaseInfo.TOTAL);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"returned\", \"total\")");
        this.options = of2;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "returned");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…, emptySet(), \"returned\")");
        this.intAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SearchResultsResponse.ItemCounts");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public SearchResultsResponse.ItemCounts fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Integer num = null;
        Integer num2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                num = this.intAdapter.fromJson(jsonReader);
                if (num == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("returned", "returned", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"returned…      \"returned\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (num2 = this.intAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull(PurchaseInfo.TOTAL, PurchaseInfo.TOTAL, jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"total\", …tal\",\n            reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (num2 != null) {
                return new SearchResultsResponse.ItemCounts(intValue, num2.intValue());
            }
            JsonDataException missingProperty = Util.missingProperty(PurchaseInfo.TOTAL, PurchaseInfo.TOTAL, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"total\", \"total\", reader)");
            throw missingProperty;
        }
        JsonDataException missingProperty2 = Util.missingProperty("returned", "returned", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"returned\", \"returned\", reader)");
        throw missingProperty2;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable SearchResultsResponse.ItemCounts itemCounts) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (itemCounts != null) {
            jsonWriter.beginObject();
            jsonWriter.name("returned");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(itemCounts.getReturned()));
            jsonWriter.name(PurchaseInfo.TOTAL);
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(itemCounts.getTotal()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
