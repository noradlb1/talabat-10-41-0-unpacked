package com.talabat.darkstores.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/model/ProductSuggestionJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/model/ProductSuggestion;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "productAdapter", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductSuggestionJsonAdapter extends JsonAdapter<ProductSuggestion> {
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<Product> productAdapter;

    public ProductSuggestionJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("data", "originalSearchQuery");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"data\", \"originalSearchQuery\")");
        this.options = of2;
        JsonAdapter<Product> adapter = moshi.adapter(Product.class, SetsKt__SetsKt.emptySet(), "product");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Product::c…tySet(),\n      \"product\")");
        this.productAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "originalSearchQuery");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…), \"originalSearchQuery\")");
        this.nullableStringAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(39);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ProductSuggestion");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public ProductSuggestion fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Product product = null;
        boolean z11 = false;
        String str = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                product = this.productAdapter.fromJson(jsonReader);
                if (product == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("product", "data", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"product\"…          \"data\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
                z11 = true;
            }
        }
        jsonReader.endObject();
        if (product != null) {
            ProductSuggestion productSuggestion = new ProductSuggestion(product);
            if (z11) {
                productSuggestion.setOriginalSearchQuery(str);
            }
            return productSuggestion;
        }
        JsonDataException missingProperty = Util.missingProperty("product", "data", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"product\", \"data\", reader)");
        throw missingProperty;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable ProductSuggestion productSuggestion) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (productSuggestion != null) {
            jsonWriter.beginObject();
            jsonWriter.name("data");
            this.productAdapter.toJson(jsonWriter, productSuggestion.getProduct());
            jsonWriter.name("originalSearchQuery");
            this.nullableStringAdapter.toJson(jsonWriter, productSuggestion.getOriginalSearchQuery());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
