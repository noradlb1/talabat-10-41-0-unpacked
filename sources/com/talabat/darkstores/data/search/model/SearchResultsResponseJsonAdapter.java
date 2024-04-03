package com.talabat.darkstores.data.search.model;

import com.facebook.share.internal.ShareConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchResultsResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/search/model/SearchResultsResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "itemCountsAdapter", "Lcom/talabat/darkstores/data/search/model/SearchResultsResponse$ItemCounts;", "listOfProductAdapter", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "nullableFiltersAdapter", "Lcom/talabat/darkstores/data/search/model/Filters;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsResponseJsonAdapter extends JsonAdapter<SearchResultsResponse> {
    @NotNull
    private final JsonAdapter<SearchResultsResponse.ItemCounts> itemCountsAdapter;
    @NotNull
    private final JsonAdapter<List<Product>> listOfProductAdapter;
    @NotNull
    private final JsonAdapter<Filters> nullableFiltersAdapter;
    @NotNull
    private final JsonReader.Options options;

    public SearchResultsResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(ShareConstants.WEB_DIALOG_PARAM_FILTERS, "item_counts", "products");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"filters\", \"item_counts\",\n      \"products\")");
        this.options = of2;
        JsonAdapter<Filters> adapter = moshi.adapter(Filters.class, SetsKt__SetsKt.emptySet(), ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Filters::c…   emptySet(), \"filters\")");
        this.nullableFiltersAdapter = adapter;
        JsonAdapter<SearchResultsResponse.ItemCounts> adapter2 = moshi.adapter(SearchResultsResponse.ItemCounts.class, SetsKt__SetsKt.emptySet(), "itemCounts");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(SearchResu…emptySet(), \"itemCounts\")");
        this.itemCountsAdapter = adapter2;
        JsonAdapter<List<Product>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, Product.class), SetsKt__SetsKt.emptySet(), "products");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…ySet(),\n      \"products\")");
        this.listOfProductAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SearchResultsResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public SearchResultsResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Filters filters = null;
        SearchResultsResponse.ItemCounts itemCounts = null;
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                filters = this.nullableFiltersAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                itemCounts = this.itemCountsAdapter.fromJson(jsonReader);
                if (itemCounts == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("itemCounts", "item_counts", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"itemCoun…\", \"item_counts\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 2 && (list = this.listOfProductAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("products", "products", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"products\", \"products\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (itemCounts == null) {
            JsonDataException missingProperty = Util.missingProperty("itemCounts", "item_counts", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"itemCou…\", \"item_counts\", reader)");
            throw missingProperty;
        } else if (list != null) {
            return new SearchResultsResponse(filters, itemCounts, list);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("products", "products", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"products\", \"products\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable SearchResultsResponse searchResultsResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (searchResultsResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name(ShareConstants.WEB_DIALOG_PARAM_FILTERS);
            this.nullableFiltersAdapter.toJson(jsonWriter, searchResultsResponse.getFilters());
            jsonWriter.name("item_counts");
            this.itemCountsAdapter.toJson(jsonWriter, searchResultsResponse.getItemCounts());
            jsonWriter.name("products");
            this.listOfProductAdapter.toJson(jsonWriter, searchResultsResponse.getProducts());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
