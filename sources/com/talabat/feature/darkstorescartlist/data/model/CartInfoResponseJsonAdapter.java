package com.talabat.feature.darkstorescartlist.data.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import com.talabat.fragments.StringBottomsheetDialogFragmentKt;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableFloatAdapter", "", "nullableIntAdapter", "", "nullableRestaurantAdapter", "Ldatamodels/Restaurant;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartInfoResponseJsonAdapter extends JsonAdapter<CartInfoResponse> {
    @NotNull
    private final JsonAdapter<Float> nullableFloatAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<Restaurant> nullableRestaurantAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public CartInfoResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("cart_id", StringBottomsheetDialogFragmentKt.ARG_ITEM_COUNT, "total_price", "global_vendor_id", "vendor");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"cart_id\", \"item_coun…bal_vendor_id\", \"vendor\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…    emptySet(), \"cartId\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "itemCount");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class… emptySet(), \"itemCount\")");
        this.nullableIntAdapter = adapter2;
        JsonAdapter<Float> adapter3 = moshi.adapter(Float.class, SetsKt__SetsKt.emptySet(), "totalPrice");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Float::cla…emptySet(), \"totalPrice\")");
        this.nullableFloatAdapter = adapter3;
        JsonAdapter<Restaurant> adapter4 = moshi.adapter(Restaurant.class, SetsKt__SetsKt.emptySet(), "restaurant");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Restaurant…emptySet(), \"restaurant\")");
        this.nullableRestaurantAdapter = adapter4;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CartInfoResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public CartInfoResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Integer num = null;
        Float f11 = null;
        String str2 = null;
        Restaurant restaurant = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                num = this.nullableIntAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                f11 = this.nullableFloatAdapter.fromJson(jsonReader);
            } else if (selectName == 3) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 4) {
                restaurant = this.nullableRestaurantAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        return new CartInfoResponse(str, num, f11, str2, restaurant);
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CartInfoResponse cartInfoResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (cartInfoResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("cart_id");
            this.nullableStringAdapter.toJson(jsonWriter, cartInfoResponse.getCartId());
            jsonWriter.name(StringBottomsheetDialogFragmentKt.ARG_ITEM_COUNT);
            this.nullableIntAdapter.toJson(jsonWriter, cartInfoResponse.getItemCount());
            jsonWriter.name("total_price");
            this.nullableFloatAdapter.toJson(jsonWriter, cartInfoResponse.getTotalPrice());
            jsonWriter.name("global_vendor_id");
            this.nullableStringAdapter.toJson(jsonWriter, cartInfoResponse.getGlobalVendorId());
            jsonWriter.name("vendor");
            this.nullableRestaurantAdapter.toJson(jsonWriter, cartInfoResponse.getRestaurant());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
