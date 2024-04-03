package com.talabat.darkstores.data.mission.control.model;

import com.facebook.share.internal.ShareConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.darkstores.data.search.model.Filters;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResultJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResult;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfProductAdapter", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "nullableFiltersAdapter", "Lcom/talabat/darkstores/data/search/model/Filters;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "pageInfoAdapter", "Lcom/talabat/darkstores/data/mission/control/model/PageInfo;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionControlProductsResultJsonAdapter extends JsonAdapter<MissionControlProductsResult> {
    @NotNull
    private final JsonAdapter<List<Product>> listOfProductAdapter;
    @NotNull
    private final JsonAdapter<Filters> nullableFiltersAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<PageInfo> pageInfoAdapter;

    public MissionControlProductsResultJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("products", "page_info", ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"products\", \"page_info\",\n      \"filters\")");
        this.options = of2;
        JsonAdapter<List<Product>> adapter = moshi.adapter(Types.newParameterizedType(List.class, Product.class), SetsKt__SetsKt.emptySet(), "products");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…ySet(),\n      \"products\")");
        this.listOfProductAdapter = adapter;
        JsonAdapter<PageInfo> adapter2 = moshi.adapter(PageInfo.class, SetsKt__SetsKt.emptySet(), "pageInfo");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(PageInfo::…  emptySet(), \"pageInfo\")");
        this.pageInfoAdapter = adapter2;
        JsonAdapter<Filters> adapter3 = moshi.adapter(Filters.class, SetsKt__SetsKt.emptySet(), ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Filters::c…   emptySet(), \"filters\")");
        this.nullableFiltersAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("MissionControlProductsResult");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public MissionControlProductsResult fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        PageInfo pageInfo = null;
        Filters filters = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                list = this.listOfProductAdapter.fromJson(jsonReader);
                if (list == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("products", "products", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"products\", \"products\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                pageInfo = this.pageInfoAdapter.fromJson(jsonReader);
                if (pageInfo == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("pageInfo", "page_info", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"pageInfo…     \"page_info\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                filters = this.nullableFiltersAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        if (list == null) {
            JsonDataException missingProperty = Util.missingProperty("products", "products", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"products\", \"products\", reader)");
            throw missingProperty;
        } else if (pageInfo != null) {
            return new MissionControlProductsResult(list, pageInfo, filters);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("pageInfo", "page_info", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"pageInfo\", \"page_info\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable MissionControlProductsResult missionControlProductsResult) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (missionControlProductsResult != null) {
            jsonWriter.beginObject();
            jsonWriter.name("products");
            this.listOfProductAdapter.toJson(jsonWriter, missionControlProductsResult.getProducts());
            jsonWriter.name("page_info");
            this.pageInfoAdapter.toJson(jsonWriter, missionControlProductsResult.getPageInfo());
            jsonWriter.name(ShareConstants.WEB_DIALOG_PARAM_FILTERS);
            this.nullableFiltersAdapter.toJson(jsonWriter, missionControlProductsResult.getFilters());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
