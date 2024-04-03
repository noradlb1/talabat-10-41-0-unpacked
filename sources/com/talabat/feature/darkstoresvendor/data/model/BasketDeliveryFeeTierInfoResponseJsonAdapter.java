package com.talabat.feature.darkstoresvendor.data.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/model/BasketDeliveryFeeTierInfoResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstoresvendor/data/model/BasketDeliveryFeeTierInfoResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBasketTagsResponseAdapter", "Lcom/talabat/feature/darkstoresvendor/data/model/BasketTagsResponse;", "nullableListOfDeliveryFeeTierResponseAdapter", "", "Lcom/talabat/feature/darkstoresvendor/data/model/DeliveryFeeTierResponse;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasketDeliveryFeeTierInfoResponseJsonAdapter extends JsonAdapter<BasketDeliveryFeeTierInfoResponse> {
    @Nullable
    private volatile Constructor<BasketDeliveryFeeTierInfoResponse> constructorRef;
    @NotNull
    private final JsonAdapter<BasketTagsResponse> nullableBasketTagsResponseAdapter;
    @NotNull
    private final JsonAdapter<List<DeliveryFeeTierResponse>> nullableListOfDeliveryFeeTierResponseAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public BasketDeliveryFeeTierInfoResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(BasketDeliveryFeeTiersInfoKeys.KEY_RANGE, BasketDeliveryFeeTiersInfoKeys.KEY_BASKET_DELIVERY_FREE_TIERS, "tags");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"range\", \"tiers\", \"tags\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…     emptySet(), \"range\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<List<DeliveryFeeTierResponse>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, DeliveryFeeTierResponse.class), SetsKt__SetsKt.emptySet(), BasketDeliveryFeeTiersInfoKeys.KEY_BASKET_DELIVERY_FREE_TIERS);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…va), emptySet(), \"tiers\")");
        this.nullableListOfDeliveryFeeTierResponseAdapter = adapter2;
        JsonAdapter<BasketTagsResponse> adapter3 = moshi.adapter(BasketTagsResponse.class, SetsKt__SetsKt.emptySet(), "tags");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(BasketTags…java, emptySet(), \"tags\")");
        this.nullableBasketTagsResponseAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("BasketDeliveryFeeTierInfoResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public BasketDeliveryFeeTierInfoResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        List list = null;
        BasketTagsResponse basketTagsResponse = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
                i11 &= -2;
            } else if (selectName == 1) {
                list = this.nullableListOfDeliveryFeeTierResponseAdapter.fromJson(jsonReader);
                i11 &= -3;
            } else if (selectName == 2) {
                basketTagsResponse = this.nullableBasketTagsResponseAdapter.fromJson(jsonReader);
                i11 &= -5;
            }
        }
        jsonReader.endObject();
        if (i11 == -8) {
            return new BasketDeliveryFeeTierInfoResponse(str, list, basketTagsResponse);
        }
        Constructor<BasketDeliveryFeeTierInfoResponse> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = BasketDeliveryFeeTierInfoResponse.class.getDeclaredConstructor(new Class[]{String.class, List.class, BasketTagsResponse.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "BasketDeliveryFeeTierInf…his.constructorRef = it }");
        }
        BasketDeliveryFeeTierInfoResponse newInstance = constructor.newInstance(new Object[]{str, list, basketTagsResponse, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTierInfoResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (basketDeliveryFeeTierInfoResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name(BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
            this.nullableStringAdapter.toJson(jsonWriter, basketDeliveryFeeTierInfoResponse.getRange());
            jsonWriter.name(BasketDeliveryFeeTiersInfoKeys.KEY_BASKET_DELIVERY_FREE_TIERS);
            this.nullableListOfDeliveryFeeTierResponseAdapter.toJson(jsonWriter, basketDeliveryFeeTierInfoResponse.getTiers());
            jsonWriter.name("tags");
            this.nullableBasketTagsResponseAdapter.toJson(jsonWriter, basketDeliveryFeeTierInfoResponse.getTags());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
