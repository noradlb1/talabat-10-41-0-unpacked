package com.talabat.feature.darkstorescart.data.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/BenefitJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "nullableFloatAdapter", "", "nullableTypeAdapter", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitJsonAdapter extends JsonAdapter<Benefit> {
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<Float> nullableFloatAdapter;
    @NotNull
    private final JsonAdapter<Campaign.Type> nullableTypeAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public BenefitJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("discount_type", "discount_value", TalabatCommonUrlConstantsKt.PRODUCT_ID, "qty");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"discount_type\", \"dis…     \"product_id\", \"qty\")");
        this.options = of2;
        JsonAdapter<Campaign.Type> adapter = moshi.adapter(Campaign.Type.class, SetsKt__SetsKt.emptySet(), "discountType");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Campaign.T…ptySet(), \"discountType\")");
        this.nullableTypeAdapter = adapter;
        JsonAdapter<Float> adapter2 = moshi.adapter(Float.class, SetsKt__SetsKt.emptySet(), "discountValue");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Float::cla…tySet(), \"discountValue\")");
        this.nullableFloatAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter3;
        JsonAdapter<Integer> adapter4 = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "qty");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Int::class.java, emptySet(), \"qty\")");
        this.intAdapter = adapter4;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Benefit");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public Benefit fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Campaign.Type type = null;
        Float f11 = null;
        String str = null;
        Integer num = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                type = this.nullableTypeAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                f11 = this.nullableFloatAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", TalabatCommonUrlConstantsKt.PRODUCT_ID, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"pr…_id\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 3 && (num = this.intAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("qty", "qty", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"qty\", \"qty\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", TalabatCommonUrlConstantsKt.PRODUCT_ID, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"product_id\", reader)");
            throw missingProperty;
        } else if (num != null) {
            return new Benefit(type, f11, str, num.intValue());
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("qty", "qty", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"qty\", \"qty\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Benefit benefit) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (benefit != null) {
            jsonWriter.beginObject();
            jsonWriter.name("discount_type");
            this.nullableTypeAdapter.toJson(jsonWriter, benefit.getDiscountType());
            jsonWriter.name("discount_value");
            this.nullableFloatAdapter.toJson(jsonWriter, benefit.getDiscountValue());
            jsonWriter.name(TalabatCommonUrlConstantsKt.PRODUCT_ID);
            this.stringAdapter.toJson(jsonWriter, benefit.getId());
            jsonWriter.name("qty");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(benefit.getQty()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
