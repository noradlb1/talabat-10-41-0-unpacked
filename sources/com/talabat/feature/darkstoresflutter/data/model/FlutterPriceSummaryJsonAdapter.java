package com.talabat.feature.darkstoresflutter.data.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.visa.checkout.PurchaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/model/FlutterPriceSummaryJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterPriceSummary;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "floatAdapter", "", "nullableFloatAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterPriceSummaryJsonAdapter extends JsonAdapter<FlutterPriceSummary> {
    @NotNull
    private final JsonAdapter<Float> floatAdapter;
    @NotNull
    private final JsonAdapter<Float> nullableFloatAdapter;
    @NotNull
    private final JsonReader.Options options;

    public FlutterPriceSummaryJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("subtotal", "deliveryFee", PurchaseInfo.TOTAL, "absoluteDiscount", "deliveryAbsoluteDiscount", "serviceFee", "subtotalAfterDiscount", "deliveryTotal");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"subtotal\", \"delivery…scount\", \"deliveryTotal\")");
        this.options = of2;
        JsonAdapter<Float> adapter = moshi.adapter(Float.TYPE, SetsKt__SetsKt.emptySet(), "subtotal");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Float::cla…ySet(),\n      \"subtotal\")");
        this.floatAdapter = adapter;
        JsonAdapter<Float> adapter2 = moshi.adapter(Float.class, SetsKt__SetsKt.emptySet(), "serviceFee");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Float::cla…emptySet(), \"serviceFee\")");
        this.nullableFloatAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FlutterPriceSummary");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public FlutterPriceSummary fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        Float f11 = null;
        Float f12 = null;
        Float f13 = null;
        Float f14 = null;
        Float f15 = null;
        Float f16 = null;
        Float f17 = null;
        Float f18 = null;
        while (true) {
            Float f19 = f18;
            if (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(this.options)) {
                    case -1:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                    case 0:
                        f11 = this.floatAdapter.fromJson(jsonReader2);
                        if (f11 == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("subtotal", "subtotal", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"subtotal…      \"subtotal\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        f12 = this.floatAdapter.fromJson(jsonReader2);
                        if (f12 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("deliveryFee", "deliveryFee", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"delivery…   \"deliveryFee\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        f13 = this.floatAdapter.fromJson(jsonReader2);
                        if (f13 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull(PurchaseInfo.TOTAL, PurchaseInfo.TOTAL, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"total\", …tal\",\n            reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        f14 = this.floatAdapter.fromJson(jsonReader2);
                        if (f14 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("absoluteDiscount", "absoluteDiscount", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"absolute…bsoluteDiscount\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        f15 = this.floatAdapter.fromJson(jsonReader2);
                        if (f15 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("deliveryAbsoluteDiscount", "deliveryAbsoluteDiscount", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"delivery…unt\",\n            reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        f17 = this.nullableFloatAdapter.fromJson(jsonReader2);
                        break;
                    case 6:
                        f18 = this.nullableFloatAdapter.fromJson(jsonReader2);
                        continue;
                    case 7:
                        f16 = this.floatAdapter.fromJson(jsonReader2);
                        if (f16 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("deliveryTotal", "deliveryTotal", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"delivery… \"deliveryTotal\", reader)");
                            throw unexpectedNull6;
                        }
                        break;
                }
                f18 = f19;
            } else {
                jsonReader.endObject();
                if (f11 != null) {
                    float floatValue = f11.floatValue();
                    if (f12 != null) {
                        float floatValue2 = f12.floatValue();
                        if (f13 != null) {
                            float floatValue3 = f13.floatValue();
                            if (f14 != null) {
                                float floatValue4 = f14.floatValue();
                                if (f15 != null) {
                                    float floatValue5 = f15.floatValue();
                                    if (f16 != null) {
                                        return new FlutterPriceSummary(floatValue, floatValue2, floatValue3, floatValue4, floatValue5, f17, f19, f16.floatValue());
                                    }
                                    JsonDataException missingProperty = Util.missingProperty("deliveryTotal", "deliveryTotal", jsonReader2);
                                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"deliver… \"deliveryTotal\", reader)");
                                    throw missingProperty;
                                }
                                JsonDataException missingProperty2 = Util.missingProperty("deliveryAbsoluteDiscount", "deliveryAbsoluteDiscount", jsonReader2);
                                Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"deliver…unt\",\n            reader)");
                                throw missingProperty2;
                            }
                            JsonDataException missingProperty3 = Util.missingProperty("absoluteDiscount", "absoluteDiscount", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"absolut…bsoluteDiscount\", reader)");
                            throw missingProperty3;
                        }
                        JsonDataException missingProperty4 = Util.missingProperty(PurchaseInfo.TOTAL, PurchaseInfo.TOTAL, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"total\", \"total\", reader)");
                        throw missingProperty4;
                    }
                    JsonDataException missingProperty5 = Util.missingProperty("deliveryFee", "deliveryFee", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"deliver…Fee\",\n            reader)");
                    throw missingProperty5;
                }
                JsonDataException missingProperty6 = Util.missingProperty("subtotal", "subtotal", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"subtotal\", \"subtotal\", reader)");
                throw missingProperty6;
            }
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable FlutterPriceSummary flutterPriceSummary) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (flutterPriceSummary != null) {
            jsonWriter.beginObject();
            jsonWriter.name("subtotal");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(flutterPriceSummary.getSubtotal()));
            jsonWriter.name("deliveryFee");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(flutterPriceSummary.getDeliveryFee()));
            jsonWriter.name(PurchaseInfo.TOTAL);
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(flutterPriceSummary.getTotal()));
            jsonWriter.name("absoluteDiscount");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(flutterPriceSummary.getAbsoluteDiscount()));
            jsonWriter.name("deliveryAbsoluteDiscount");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(flutterPriceSummary.getDeliveryAbsoluteDiscount()));
            jsonWriter.name("serviceFee");
            this.nullableFloatAdapter.toJson(jsonWriter, flutterPriceSummary.getServiceFee());
            jsonWriter.name("subtotalAfterDiscount");
            this.nullableFloatAdapter.toJson(jsonWriter, flutterPriceSummary.getSubtotalAfterDiscount());
            jsonWriter.name("deliveryTotal");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(flutterPriceSummary.getDeliveryTotal()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
