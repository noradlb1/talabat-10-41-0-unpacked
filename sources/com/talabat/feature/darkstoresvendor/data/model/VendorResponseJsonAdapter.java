package com.talabat.feature.darkstoresvendor.data.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.feature.darkstorescarrierbag.presentation.di.DarkstoresCarrierBagComponentKt;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/model/VendorResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstoresvendor/data/model/VendorResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBasketDeliveryFeeTierInfoResponseAdapter", "Lcom/talabat/feature/darkstoresvendor/data/model/BasketDeliveryFeeTierInfoResponse;", "nullableBooleanAdapter", "", "nullableFloatAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorResponseJsonAdapter extends JsonAdapter<VendorResponse> {
    @Nullable
    private volatile Constructor<VendorResponse> constructorRef;
    @NotNull
    private final JsonAdapter<BasketDeliveryFeeTierInfoResponse> nullableBasketDeliveryFeeTierInfoResponseAdapter;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<Float> nullableFloatAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public VendorResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("vendor_id", DarkstoresCarrierBagComponentKt.QUALIFIER_VENDOR_CODE, "delivery_fee", "delivery_time", "minimum_order_value", "is_tpro", "is_vendor_pro", "basket_tiers", "scheduled_delivery_discount");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"vendor_id\", \"vendor_…duled_delivery_discount\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "vendorId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…  emptySet(), \"vendorId\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Float> adapter2 = moshi.adapter(Float.class, SetsKt__SetsKt.emptySet(), "deliveryFee");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Float::cla…mptySet(), \"deliveryFee\")");
        this.nullableFloatAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "isTPro");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…pe, emptySet(), \"isTPro\")");
        this.nullableBooleanAdapter = adapter3;
        JsonAdapter<BasketDeliveryFeeTierInfoResponse> adapter4 = moshi.adapter(BasketDeliveryFeeTierInfoResponse.class, SetsKt__SetsKt.emptySet(), "basketDeliveryFeeTiers");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(BasketDeli…\"basketDeliveryFeeTiers\")");
        this.nullableBasketDeliveryFeeTierInfoResponseAdapter = adapter4;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(36);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("VendorResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public VendorResponse fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        String str = null;
        String str2 = null;
        Float f11 = null;
        String str3 = null;
        Float f12 = null;
        Boolean bool = null;
        Boolean bool2 = null;
        BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTierInfoResponse = null;
        Float f13 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -2;
                    break;
                case 1:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -3;
                    break;
                case 2:
                    f11 = this.nullableFloatAdapter.fromJson(jsonReader2);
                    i11 &= -5;
                    break;
                case 3:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -9;
                    break;
                case 4:
                    f12 = this.nullableFloatAdapter.fromJson(jsonReader2);
                    i11 &= -17;
                    break;
                case 5:
                    bool = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -33;
                    break;
                case 6:
                    bool2 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -65;
                    break;
                case 7:
                    basketDeliveryFeeTierInfoResponse = this.nullableBasketDeliveryFeeTierInfoResponseAdapter.fromJson(jsonReader2);
                    i11 &= -129;
                    break;
                case 8:
                    f13 = this.nullableFloatAdapter.fromJson(jsonReader2);
                    i11 &= -257;
                    break;
            }
        }
        jsonReader.endObject();
        if (i11 == -512) {
            return new VendorResponse(str, str2, f11, str3, f12, bool, bool2, basketDeliveryFeeTierInfoResponse, f13);
        }
        Constructor<VendorResponse> constructor = this.constructorRef;
        if (constructor == null) {
            Class<String> cls = String.class;
            Class<Float> cls2 = Float.class;
            Class<Boolean> cls3 = Boolean.class;
            constructor = VendorResponse.class.getDeclaredConstructor(new Class[]{cls, cls, cls2, cls, cls2, cls3, cls3, BasketDeliveryFeeTierInfoResponse.class, cls2, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "VendorResponse::class.ja…his.constructorRef = it }");
        }
        VendorResponse newInstance = constructor.newInstance(new Object[]{str, str2, f11, str3, f12, bool, bool2, basketDeliveryFeeTierInfoResponse, f13, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable VendorResponse vendorResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (vendorResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("vendor_id");
            this.nullableStringAdapter.toJson(jsonWriter, vendorResponse.getVendorId());
            jsonWriter.name(DarkstoresCarrierBagComponentKt.QUALIFIER_VENDOR_CODE);
            this.nullableStringAdapter.toJson(jsonWriter, vendorResponse.getVendorCode());
            jsonWriter.name("delivery_fee");
            this.nullableFloatAdapter.toJson(jsonWriter, vendorResponse.getDeliveryFee());
            jsonWriter.name("delivery_time");
            this.nullableStringAdapter.toJson(jsonWriter, vendorResponse.getDeliveryTime());
            jsonWriter.name("minimum_order_value");
            this.nullableFloatAdapter.toJson(jsonWriter, vendorResponse.getMinimumOrderValue());
            jsonWriter.name("is_tpro");
            this.nullableBooleanAdapter.toJson(jsonWriter, vendorResponse.isTPro());
            jsonWriter.name("is_vendor_pro");
            this.nullableBooleanAdapter.toJson(jsonWriter, vendorResponse.isVendorPro());
            jsonWriter.name("basket_tiers");
            this.nullableBasketDeliveryFeeTierInfoResponseAdapter.toJson(jsonWriter, vendorResponse.getBasketDeliveryFeeTiers());
            jsonWriter.name("scheduled_delivery_discount");
            this.nullableFloatAdapter.toJson(jsonWriter, vendorResponse.getScheduleDeliveryDiscount());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
