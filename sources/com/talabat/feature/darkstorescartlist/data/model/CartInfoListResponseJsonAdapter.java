package com.talabat.feature.darkstorescartlist.data.model;

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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoListResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoListResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfCartInfoResponseAdapter", "", "Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoResponse;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartInfoListResponseJsonAdapter extends JsonAdapter<CartInfoListResponse> {
    @NotNull
    private final JsonAdapter<List<CartInfoResponse>> listOfCartInfoResponseAdapter;
    @NotNull
    private final JsonReader.Options options;

    public CartInfoListResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("carts");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"carts\")");
        this.options = of2;
        JsonAdapter<List<CartInfoResponse>> adapter = moshi.adapter(Types.newParameterizedType(List.class, CartInfoResponse.class), SetsKt__SetsKt.emptySet(), "carts");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…     emptySet(), \"carts\")");
        this.listOfCartInfoResponseAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(42);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CartInfoListResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public CartInfoListResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (list = this.listOfCartInfoResponseAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("carts", "carts", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"carts\", \"carts\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (list != null) {
            return new CartInfoListResponse(list);
        }
        JsonDataException missingProperty = Util.missingProperty("carts", "carts", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"carts\", \"carts\", reader)");
        throw missingProperty;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CartInfoListResponse cartInfoListResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (cartInfoListResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("carts");
            this.listOfCartInfoResponseAdapter.toJson(jsonWriter, cartInfoListResponse.getCarts());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
