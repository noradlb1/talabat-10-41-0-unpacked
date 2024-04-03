package com.talabat.darkstores.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/model/ProductDiscountJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/model/ProductDiscount;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "floatAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductDiscountJsonAdapter extends JsonAdapter<ProductDiscount> {
    @NotNull
    private final JsonAdapter<Float> floatAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public ProductDiscountJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(TalabatCommonUrlConstantsKt.PRODUCT_ID, "original_price", "discounted_price");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"product_id\", \"origin…      \"discounted_price\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "productId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"productId\")");
        this.stringAdapter = adapter;
        JsonAdapter<Float> adapter2 = moshi.adapter(Float.TYPE, SetsKt__SetsKt.emptySet(), "originalPrice");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Float::cla…),\n      \"originalPrice\")");
        this.floatAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ProductDiscount");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public ProductDiscount fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Float f11 = null;
        Float f12 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("productId", TalabatCommonUrlConstantsKt.PRODUCT_ID, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"productI…    \"product_id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                f11 = this.floatAdapter.fromJson(jsonReader);
                if (f11 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("originalPrice", "original_price", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"original…\"original_price\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (f12 = this.floatAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("discountedPrice", "discounted_price", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"discount…iscounted_price\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("productId", TalabatCommonUrlConstantsKt.PRODUCT_ID, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"productId\", \"product_id\", reader)");
            throw missingProperty;
        } else if (f11 != null) {
            float floatValue = f11.floatValue();
            if (f12 != null) {
                return new ProductDiscount(str, floatValue, f12.floatValue());
            }
            JsonDataException missingProperty2 = Util.missingProperty("discountedPrice", "discounted_price", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"discoun…iscounted_price\", reader)");
            throw missingProperty2;
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("originalPrice", "original_price", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"origina…\"original_price\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable ProductDiscount productDiscount) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (productDiscount != null) {
            jsonWriter.beginObject();
            jsonWriter.name(TalabatCommonUrlConstantsKt.PRODUCT_ID);
            this.stringAdapter.toJson(jsonWriter, productDiscount.getProductId());
            jsonWriter.name("original_price");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(productDiscount.getOriginalPrice()));
            jsonWriter.name("discounted_price");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(productDiscount.getDiscountedPrice()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
