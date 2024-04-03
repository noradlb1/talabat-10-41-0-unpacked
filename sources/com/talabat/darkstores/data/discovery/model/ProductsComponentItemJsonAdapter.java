package com.talabat.darkstores.data.discovery.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/ProductsComponentItemJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/discovery/model/ProductsComponentItem;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfProductAdapter", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductsComponentItemJsonAdapter extends JsonAdapter<ProductsComponentItem> {
    @NotNull
    private final JsonAdapter<List<Product>> listOfProductAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public ProductsComponentItemJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("headline", FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"headline\", \"items\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "headline");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…  emptySet(), \"headline\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<List<Product>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, Product.class), SetsKt__SetsKt.emptySet(), "products");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…ySet(),\n      \"products\")");
        this.listOfProductAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ProductsComponentItem");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public ProductsComponentItem fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        boolean z11 = false;
        List<Product> list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
                z11 = true;
            } else if (selectName == 1 && (list = this.listOfProductAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("products", FirebaseAnalytics.Param.ITEMS, jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"products\", \"items\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        ProductsComponentItem productsComponentItem = new ProductsComponentItem();
        if (z11) {
            productsComponentItem.setHeadline(str);
        }
        if (list == null) {
            list = productsComponentItem.getProducts();
        }
        productsComponentItem.setProducts(list);
        return productsComponentItem;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable ProductsComponentItem productsComponentItem) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (productsComponentItem != null) {
            jsonWriter.beginObject();
            jsonWriter.name("headline");
            this.nullableStringAdapter.toJson(jsonWriter, productsComponentItem.getHeadline());
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.listOfProductAdapter.toJson(jsonWriter, productsComponentItem.getProducts());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
