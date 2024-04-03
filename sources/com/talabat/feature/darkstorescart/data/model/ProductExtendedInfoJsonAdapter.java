package com.talabat.feature.darkstorescart.data.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableContentUnitAdapter", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ContentUnit;", "nullableCountryAdapter", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Country;", "nullableListOfTagAdapter", "", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Tag;", "nullableShelfLifeAdapter", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ShelfLife;", "nullableStoredAtAdapter", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$StoredAt;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductExtendedInfoJsonAdapter extends JsonAdapter<ProductExtendedInfo> {
    @NotNull
    private final JsonAdapter<ProductExtendedInfo.ContentUnit> nullableContentUnitAdapter;
    @NotNull
    private final JsonAdapter<ProductExtendedInfo.Country> nullableCountryAdapter;
    @NotNull
    private final JsonAdapter<List<ProductExtendedInfo.Tag>> nullableListOfTagAdapter;
    @NotNull
    private final JsonAdapter<ProductExtendedInfo.ShelfLife> nullableShelfLifeAdapter;
    @NotNull
    private final JsonAdapter<ProductExtendedInfo.StoredAt> nullableStoredAtAdapter;
    @NotNull
    private final JsonReader.Options options;

    public ProductExtendedInfoJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("tags", "content_unit", "stored_at", "country", "shelf_life");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"tags\", \"content_unit… \"country\", \"shelf_life\")");
        this.options = of2;
        JsonAdapter<List<ProductExtendedInfo.Tag>> adapter = moshi.adapter(Types.newParameterizedType(List.class, ProductExtendedInfo.Tag.class), SetsKt__SetsKt.emptySet(), "tags");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…ava), emptySet(), \"tags\")");
        this.nullableListOfTagAdapter = adapter;
        JsonAdapter<ProductExtendedInfo.ContentUnit> adapter2 = moshi.adapter(ProductExtendedInfo.ContentUnit.class, SetsKt__SetsKt.emptySet(), "contentUnit");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(ProductExt…mptySet(), \"contentUnit\")");
        this.nullableContentUnitAdapter = adapter2;
        JsonAdapter<ProductExtendedInfo.StoredAt> adapter3 = moshi.adapter(ProductExtendedInfo.StoredAt.class, SetsKt__SetsKt.emptySet(), "storedAt");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(ProductExt…, emptySet(), \"storedAt\")");
        this.nullableStoredAtAdapter = adapter3;
        JsonAdapter<ProductExtendedInfo.Country> adapter4 = moshi.adapter(ProductExtendedInfo.Country.class, SetsKt__SetsKt.emptySet(), "country");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(ProductExt…a, emptySet(), \"country\")");
        this.nullableCountryAdapter = adapter4;
        JsonAdapter<ProductExtendedInfo.ShelfLife> adapter5 = moshi.adapter(ProductExtendedInfo.ShelfLife.class, SetsKt__SetsKt.emptySet(), "shelfLife");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(ProductExt… emptySet(), \"shelfLife\")");
        this.nullableShelfLifeAdapter = adapter5;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ProductExtendedInfo");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public ProductExtendedInfo fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        ProductExtendedInfo.ContentUnit contentUnit = null;
        ProductExtendedInfo.StoredAt storedAt = null;
        ProductExtendedInfo.Country country = null;
        ProductExtendedInfo.ShelfLife shelfLife = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                list = this.nullableListOfTagAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                contentUnit = this.nullableContentUnitAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                storedAt = this.nullableStoredAtAdapter.fromJson(jsonReader);
            } else if (selectName == 3) {
                country = this.nullableCountryAdapter.fromJson(jsonReader);
            } else if (selectName == 4) {
                shelfLife = this.nullableShelfLifeAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        return new ProductExtendedInfo(list, contentUnit, storedAt, country, shelfLife);
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable ProductExtendedInfo productExtendedInfo) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (productExtendedInfo != null) {
            jsonWriter.beginObject();
            jsonWriter.name("tags");
            this.nullableListOfTagAdapter.toJson(jsonWriter, productExtendedInfo.getTags());
            jsonWriter.name("content_unit");
            this.nullableContentUnitAdapter.toJson(jsonWriter, productExtendedInfo.getContentUnit());
            jsonWriter.name("stored_at");
            this.nullableStoredAtAdapter.toJson(jsonWriter, productExtendedInfo.getStoredAt());
            jsonWriter.name("country");
            this.nullableCountryAdapter.toJson(jsonWriter, productExtendedInfo.getCountry());
            jsonWriter.name("shelf_life");
            this.nullableShelfLifeAdapter.toJson(jsonWriter, productExtendedInfo.getShelfLife());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
