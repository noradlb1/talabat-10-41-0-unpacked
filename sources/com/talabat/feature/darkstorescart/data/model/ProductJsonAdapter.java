package com.talabat.feature.darkstorescart.data.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010)\u001a\u00020\u0012H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/ProductJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "floatAdapter", "", "intAdapter", "", "listOfProductUrlAdapter", "", "Lcom/talabat/feature/darkstorescart/data/model/ProductUrl;", "listOfStringAdapter", "", "nullableBooleanAdapter", "nullableCampaignTriggerAdapter", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "nullableFloatAdapter", "nullableIntAdapter", "nullableListOfStringAdapter", "nullableProductExtendedInfoAdapter", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;", "nullableStringAdapter", "nullableTrackingAdapter", "Lcom/talabat/feature/darkstorescart/data/model/Tracking;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductJsonAdapter extends JsonAdapter<Product> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @Nullable
    private volatile Constructor<Product> constructorRef;
    @NotNull
    private final JsonAdapter<Float> floatAdapter;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<List<ProductUrl>> listOfProductUrlAdapter;
    @NotNull
    private final JsonAdapter<List<String>> listOfStringAdapter;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<CampaignTrigger> nullableCampaignTriggerAdapter;
    @NotNull
    private final JsonAdapter<Float> nullableFloatAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<List<String>> nullableListOfStringAdapter;
    @NotNull
    private final JsonAdapter<ProductExtendedInfo> nullableProductExtendedInfoAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonAdapter<Tracking> nullableTrackingAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public ProductJsonAdapter(@NotNull Moshi moshi) {
        Moshi moshi2 = moshi;
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("id", "name", "image_url", FirebaseAnalytics.Param.PRICE, "previousPrice", "cartCount", "syncedCount", "freeCount", "absoluteDiscount", "tracking", "vendor_id", "stock_amount", "is_available", "image_urls", "tags", "description", "category_id", ProductTrackingProvider.FAVOURITE, "sku", "is_sponsored", "campaignTrigger", "age_limit", "extended_info", "category_ids", "hasBeenMarkedOOS", "predictedToBeOOS", "hasPriceChanged", "hasQuantityChanged", "offerText", "tooltipAlertText");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"id\", \"name\", \"image_…ext\", \"tooltipAlertText\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi2.adapter(cls, SetsKt__SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi2.adapter(cls, SetsKt__SetsKt.emptySet(), ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…  emptySet(), \"imageUrl\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Float> adapter3 = moshi2.adapter(Float.TYPE, SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.PRICE);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Float::cla…mptySet(),\n      \"price\")");
        this.floatAdapter = adapter3;
        JsonAdapter<Float> adapter4 = moshi2.adapter(Float.class, SetsKt__SetsKt.emptySet(), "previousPrice");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Float::cla…tySet(), \"previousPrice\")");
        this.nullableFloatAdapter = adapter4;
        JsonAdapter<Integer> adapter5 = moshi2.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "cartCount");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Int::class… emptySet(), \"cartCount\")");
        this.intAdapter = adapter5;
        JsonAdapter<Integer> adapter6 = moshi2.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "freeCount");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Int::class… emptySet(), \"freeCount\")");
        this.nullableIntAdapter = adapter6;
        JsonAdapter<Tracking> adapter7 = moshi2.adapter(Tracking.class, SetsKt__SetsKt.emptySet(), "tracking");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Tracking::…  emptySet(), \"tracking\")");
        this.nullableTrackingAdapter = adapter7;
        JsonAdapter<Boolean> adapter8 = moshi2.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "isAvailable");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Boolean::c…t(),\n      \"isAvailable\")");
        this.booleanAdapter = adapter8;
        Class<List> cls2 = List.class;
        JsonAdapter<List<ProductUrl>> adapter9 = moshi2.adapter(Types.newParameterizedType(cls2, ProductUrl.class), SetsKt__SetsKt.emptySet(), "imageUrls");
        Intrinsics.checkNotNullExpressionValue(adapter9, "moshi.adapter(Types.newP… emptySet(), \"imageUrls\")");
        this.listOfProductUrlAdapter = adapter9;
        JsonAdapter<List<String>> adapter10 = moshi2.adapter(Types.newParameterizedType(cls2, cls), SetsKt__SetsKt.emptySet(), "tags");
        Intrinsics.checkNotNullExpressionValue(adapter10, "moshi.adapter(Types.newP…emptySet(),\n      \"tags\")");
        this.listOfStringAdapter = adapter10;
        JsonAdapter<CampaignTrigger> adapter11 = moshi2.adapter(CampaignTrigger.class, SetsKt__SetsKt.emptySet(), "campaignTrigger");
        Intrinsics.checkNotNullExpressionValue(adapter11, "moshi.adapter(CampaignTr…Set(), \"campaignTrigger\")");
        this.nullableCampaignTriggerAdapter = adapter11;
        JsonAdapter<ProductExtendedInfo> adapter12 = moshi2.adapter(ProductExtendedInfo.class, SetsKt__SetsKt.emptySet(), "extendedInfo");
        Intrinsics.checkNotNullExpressionValue(adapter12, "moshi.adapter(ProductExt…ptySet(), \"extendedInfo\")");
        this.nullableProductExtendedInfoAdapter = adapter12;
        JsonAdapter<List<String>> adapter13 = moshi2.adapter(Types.newParameterizedType(cls2, cls), SetsKt__SetsKt.emptySet(), "categoryIds");
        Intrinsics.checkNotNullExpressionValue(adapter13, "moshi.adapter(Types.newP…t(),\n      \"categoryIds\")");
        this.nullableListOfStringAdapter = adapter13;
        JsonAdapter<Boolean> adapter14 = moshi2.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "hasBeenMarkedOOS");
        Intrinsics.checkNotNullExpressionValue(adapter14, "moshi.adapter(Boolean::c…et(), \"hasBeenMarkedOOS\")");
        this.nullableBooleanAdapter = adapter14;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Product");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public Product fromJson(@NotNull JsonReader jsonReader) {
        int i11;
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        Float valueOf = Float.valueOf(0.0f);
        Integer num = 0;
        Boolean bool = Boolean.FALSE;
        jsonReader.beginObject();
        Integer num2 = num;
        Boolean bool2 = bool;
        Boolean bool3 = bool2;
        Boolean bool4 = bool3;
        int i12 = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        Float f11 = null;
        Integer num3 = null;
        Float f12 = null;
        Tracking tracking2 = null;
        String str4 = null;
        List list = null;
        List list2 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        CampaignTrigger campaignTrigger = null;
        ProductExtendedInfo productExtendedInfo = null;
        List list3 = null;
        Boolean bool5 = null;
        Boolean bool6 = null;
        Boolean bool7 = null;
        Boolean bool8 = null;
        String str8 = null;
        String str9 = null;
        Integer num4 = num2;
        Integer num5 = num4;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
                case 0:
                    str = this.stringAdapter.fromJson(jsonReader2);
                    if (str != null) {
                        i12 &= -2;
                        continue;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    str2 = this.stringAdapter.fromJson(jsonReader2);
                    if (str2 != null) {
                        i12 &= -3;
                        continue;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("name", "name", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"name\", \"name\", reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i12 &= -5;
                    continue;
                case 3:
                    valueOf = this.floatAdapter.fromJson(jsonReader2);
                    if (valueOf != null) {
                        i12 &= -9;
                        continue;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull(FirebaseAnalytics.Param.PRICE, FirebaseAnalytics.Param.PRICE, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"price\", …e\",\n              reader)");
                        throw unexpectedNull3;
                    }
                case 4:
                    f11 = this.nullableFloatAdapter.fromJson(jsonReader2);
                    i12 &= -17;
                    continue;
                case 5:
                    num = this.intAdapter.fromJson(jsonReader2);
                    if (num != null) {
                        i12 &= -33;
                        continue;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("cartCount", "cartCount", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"cartCoun…     \"cartCount\", reader)");
                        throw unexpectedNull4;
                    }
                case 6:
                    num4 = this.intAdapter.fromJson(jsonReader2);
                    if (num4 != null) {
                        i12 &= -65;
                        continue;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("syncedCount", "syncedCount", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"syncedCo…   \"syncedCount\", reader)");
                        throw unexpectedNull5;
                    }
                case 7:
                    num3 = this.nullableIntAdapter.fromJson(jsonReader2);
                    i12 &= -129;
                    continue;
                case 8:
                    f12 = this.nullableFloatAdapter.fromJson(jsonReader2);
                    i12 &= -257;
                    continue;
                case 9:
                    tracking2 = this.nullableTrackingAdapter.fromJson(jsonReader2);
                    i12 &= -513;
                    continue;
                case 10:
                    str4 = this.stringAdapter.fromJson(jsonReader2);
                    if (str4 != null) {
                        i12 &= -1025;
                        continue;
                    } else {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("vendorId", "vendor_id", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"vendorId…     \"vendor_id\", reader)");
                        throw unexpectedNull6;
                    }
                case 11:
                    num5 = this.intAdapter.fromJson(jsonReader2);
                    if (num5 != null) {
                        i12 &= -2049;
                        continue;
                    } else {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("stock", "stock_amount", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"stock\", …t\",\n              reader)");
                        throw unexpectedNull7;
                    }
                case 12:
                    bool2 = this.booleanAdapter.fromJson(jsonReader2);
                    if (bool2 != null) {
                        i12 &= -4097;
                        continue;
                    } else {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("isAvailable", "is_available", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "unexpectedNull(\"isAvaila…  \"is_available\", reader)");
                        throw unexpectedNull8;
                    }
                case 13:
                    list = this.listOfProductUrlAdapter.fromJson(jsonReader2);
                    if (list != null) {
                        i12 &= -8193;
                        continue;
                    } else {
                        JsonDataException unexpectedNull9 = Util.unexpectedNull("imageUrls", "image_urls", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull9, "unexpectedNull(\"imageUrls\", \"image_urls\", reader)");
                        throw unexpectedNull9;
                    }
                case 14:
                    list2 = this.listOfStringAdapter.fromJson(jsonReader2);
                    if (list2 != null) {
                        i12 &= -16385;
                        continue;
                    } else {
                        JsonDataException unexpectedNull10 = Util.unexpectedNull("tags", "tags", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull10, "unexpectedNull(\"tags\", \"…s\",\n              reader)");
                        throw unexpectedNull10;
                    }
                case 15:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 = -32769;
                    break;
                case 16:
                    str6 = this.stringAdapter.fromJson(jsonReader2);
                    if (str6 != null) {
                        i11 = -131073;
                        break;
                    } else {
                        JsonDataException unexpectedNull11 = Util.unexpectedNull("categoryId", "category_id", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull11, "unexpectedNull(\"category…   \"category_id\", reader)");
                        throw unexpectedNull11;
                    }
                case 17:
                    bool3 = this.booleanAdapter.fromJson(jsonReader2);
                    if (bool3 != null) {
                        i11 = -262145;
                        break;
                    } else {
                        JsonDataException unexpectedNull12 = Util.unexpectedNull(ProductTrackingProvider.FAVOURITE, ProductTrackingProvider.FAVOURITE, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull12, "unexpectedNull(\"isFavori…    \"isFavorite\", reader)");
                        throw unexpectedNull12;
                    }
                case 18:
                    str7 = this.stringAdapter.fromJson(jsonReader2);
                    if (str7 != null) {
                        i11 = -524289;
                        break;
                    } else {
                        JsonDataException unexpectedNull13 = Util.unexpectedNull("sku", "sku", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull13, "unexpectedNull(\"sku\", \"sku\", reader)");
                        throw unexpectedNull13;
                    }
                case 19:
                    bool4 = this.booleanAdapter.fromJson(jsonReader2);
                    if (bool4 != null) {
                        i11 = -1048577;
                        break;
                    } else {
                        JsonDataException unexpectedNull14 = Util.unexpectedNull("isSponsored", "is_sponsored", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull14, "unexpectedNull(\"isSponso…  \"is_sponsored\", reader)");
                        throw unexpectedNull14;
                    }
                case 20:
                    campaignTrigger = this.nullableCampaignTriggerAdapter.fromJson(jsonReader2);
                    i11 = -2097153;
                    break;
                case 21:
                    num2 = this.intAdapter.fromJson(jsonReader2);
                    if (num2 != null) {
                        i11 = -4194305;
                        break;
                    } else {
                        JsonDataException unexpectedNull15 = Util.unexpectedNull("ageLimit", "age_limit", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull15, "unexpectedNull(\"ageLimit…     \"age_limit\", reader)");
                        throw unexpectedNull15;
                    }
                case 22:
                    productExtendedInfo = this.nullableProductExtendedInfoAdapter.fromJson(jsonReader2);
                    i11 = -8388609;
                    break;
                case 23:
                    list3 = this.nullableListOfStringAdapter.fromJson(jsonReader2);
                    i11 = -16777217;
                    break;
                case 24:
                    bool5 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -33554433;
                    break;
                case 25:
                    bool6 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -67108865;
                    break;
                case 26:
                    bool7 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -134217729;
                    break;
                case 27:
                    bool8 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -268435457;
                    break;
                case 28:
                    str8 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 = -536870913;
                    break;
                case 29:
                    str9 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 = -1073741825;
                    break;
            }
            i12 &= i11;
        }
        jsonReader.endObject();
        if (i12 != -2147418112) {
            Constructor<Product> constructor = this.constructorRef;
            if (constructor == null) {
                Class<String> cls = String.class;
                Class cls2 = Integer.TYPE;
                Class cls3 = Boolean.TYPE;
                Class<List> cls4 = List.class;
                Class<Boolean> cls5 = Boolean.class;
                constructor = Product.class.getDeclaredConstructor(new Class[]{cls, cls, cls, Float.TYPE, Float.class, cls2, cls2, Integer.class, Float.class, Tracking.class, cls, cls2, cls3, cls4, cls4, cls, cls4, cls, cls3, cls, cls3, CampaignTrigger.class, cls2, ProductExtendedInfo.class, cls4, cls5, cls5, cls5, cls5, cls, cls, cls2, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Unit unit = Unit.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(constructor, "Product::class.java.getD…his.constructorRef = it }");
            }
            Product newInstance = constructor.newInstance(new Object[]{str, str2, str3, valueOf, f11, num, num4, num3, f12, tracking2, str4, num5, bool2, list, list2, str5, null, str6, bool3, str7, bool4, campaignTrigger, num2, productExtendedInfo, list3, bool5, bool6, bool7, bool8, str8, str9, Integer.valueOf(i12), null});
            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
            return newInstance;
        } else if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str2 != null) {
            float floatValue = valueOf.floatValue();
            int intValue = num.intValue();
            int intValue2 = num4.intValue();
            if (str4 != null) {
                int intValue3 = num5.intValue();
                boolean booleanValue = bool2.booleanValue();
                if (list == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.talabat.feature.darkstorescart.data.model.ProductUrl>");
                } else if (list2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                } else if (str6 != null) {
                    boolean booleanValue2 = bool3.booleanValue();
                    if (str7 != null) {
                        return new Product(str, str2, str3, floatValue, f11, intValue, intValue2, num3, f12, tracking2, str4, intValue3, booleanValue, list, list2, str5, (List) null, str6, booleanValue2, str7, bool4.booleanValue(), campaignTrigger, num2.intValue(), productExtendedInfo, list3, bool5, bool6, bool7, bool8, str8, str9, 65536, (DefaultConstructorMarker) null);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Product product) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (product != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, product.getId());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, product.getName());
            jsonWriter.name("image_url");
            this.nullableStringAdapter.toJson(jsonWriter, product.getImageUrl());
            jsonWriter.name(FirebaseAnalytics.Param.PRICE);
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(product.getPrice()));
            jsonWriter.name("previousPrice");
            this.nullableFloatAdapter.toJson(jsonWriter, product.getPreviousPrice());
            jsonWriter.name("cartCount");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(product.getCartCount()));
            jsonWriter.name("syncedCount");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(product.getSyncedCount()));
            jsonWriter.name("freeCount");
            this.nullableIntAdapter.toJson(jsonWriter, product.getFreeCount());
            jsonWriter.name("absoluteDiscount");
            this.nullableFloatAdapter.toJson(jsonWriter, product.getAbsoluteDiscount());
            jsonWriter.name("tracking");
            this.nullableTrackingAdapter.toJson(jsonWriter, product.getTracking());
            jsonWriter.name("vendor_id");
            this.stringAdapter.toJson(jsonWriter, product.getVendorId());
            jsonWriter.name("stock_amount");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(product.getStock()));
            jsonWriter.name("is_available");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(product.isAvailable()));
            jsonWriter.name("image_urls");
            this.listOfProductUrlAdapter.toJson(jsonWriter, product.getImageUrls());
            jsonWriter.name("tags");
            this.listOfStringAdapter.toJson(jsonWriter, product.getTags());
            jsonWriter.name("description");
            this.nullableStringAdapter.toJson(jsonWriter, product.getDescription());
            jsonWriter.name("category_id");
            this.stringAdapter.toJson(jsonWriter, product.getCategoryId());
            jsonWriter.name(ProductTrackingProvider.FAVOURITE);
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(product.isFavorite()));
            jsonWriter.name("sku");
            this.stringAdapter.toJson(jsonWriter, product.getSku());
            jsonWriter.name("is_sponsored");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(product.isSponsored()));
            jsonWriter.name("campaignTrigger");
            this.nullableCampaignTriggerAdapter.toJson(jsonWriter, product.getCampaignTrigger());
            jsonWriter.name("age_limit");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(product.getAgeLimit()));
            jsonWriter.name("extended_info");
            this.nullableProductExtendedInfoAdapter.toJson(jsonWriter, product.getExtendedInfo());
            jsonWriter.name("category_ids");
            this.nullableListOfStringAdapter.toJson(jsonWriter, product.getCategoryIds());
            jsonWriter.name("hasBeenMarkedOOS");
            this.nullableBooleanAdapter.toJson(jsonWriter, product.getHasBeenMarkedOOS());
            jsonWriter.name("predictedToBeOOS");
            this.nullableBooleanAdapter.toJson(jsonWriter, product.getPredictedToBeOOS());
            jsonWriter.name("hasPriceChanged");
            this.nullableBooleanAdapter.toJson(jsonWriter, product.getHasPriceChanged());
            jsonWriter.name("hasQuantityChanged");
            this.nullableBooleanAdapter.toJson(jsonWriter, product.getHasQuantityChanged());
            jsonWriter.name("offerText");
            this.nullableStringAdapter.toJson(jsonWriter, product.getOfferText());
            jsonWriter.name("tooltipAlertText");
            this.nullableStringAdapter.toJson(jsonWriter, product.getTooltipAlertText());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
