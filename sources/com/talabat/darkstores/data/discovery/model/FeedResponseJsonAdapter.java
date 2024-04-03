package com.talabat.darkstores.data.discovery.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/FeedResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/discovery/model/FeedResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "listOfProductsComponentItemAdapter", "", "Lcom/talabat/darkstores/data/discovery/model/ProductsComponentItem;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeedResponseJsonAdapter extends JsonAdapter<FeedResponse> {
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<List<ProductsComponentItem>> listOfProductsComponentItemAdapter;
    @NotNull
    private final JsonReader.Options options;

    public FeedResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("count", FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"count\", \"items\")");
        this.options = of2;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "count");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…ava, emptySet(), \"count\")");
        this.intAdapter = adapter;
        JsonAdapter<List<ProductsComponentItem>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, ProductsComponentItem.class), SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…     emptySet(), \"items\")");
        this.listOfProductsComponentItemAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(34);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FeedResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public FeedResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Integer num = null;
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                num = this.intAdapter.fromJson(jsonReader);
                if (num == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("count", "count", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"count\", …unt\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (list = this.listOfProductsComponentItemAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull(FirebaseAnalytics.Param.ITEMS, FirebaseAnalytics.Param.ITEMS, jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"items\", \"items\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (list != null) {
                return new FeedResponse(intValue, list);
            }
            JsonDataException missingProperty = Util.missingProperty(FirebaseAnalytics.Param.ITEMS, FirebaseAnalytics.Param.ITEMS, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"items\", \"items\", reader)");
            throw missingProperty;
        }
        JsonDataException missingProperty2 = Util.missingProperty("count", "count", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"count\", \"count\", reader)");
        throw missingProperty2;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable FeedResponse feedResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (feedResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("count");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(feedResponse.getCount()));
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.listOfProductsComponentItemAdapter.toJson(jsonWriter, feedResponse.getItems());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
