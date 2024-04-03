package com.talabat.feature.darkstorescart.data.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import com.visa.checkout.PurchaseInfo;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/CartResponseProductJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstorescart/data/model/CartResponseProduct;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "floatAdapter", "", "intAdapter", "", "listOfCampaignLabelAdapter", "", "Lcom/talabat/feature/darkstorescart/data/model/CampaignLabel;", "listOfStringAdapter", "", "nullableIntAdapter", "nullableListOfStringAdapter", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartResponseProductJsonAdapter extends JsonAdapter<CartResponseProduct> {
    @Nullable
    private volatile Constructor<CartResponseProduct> constructorRef;
    @NotNull
    private final JsonAdapter<Float> floatAdapter;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<List<CampaignLabel>> listOfCampaignLabelAdapter;
    @NotNull
    private final JsonAdapter<List<String>> listOfStringAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<List<String>> nullableListOfStringAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public CartResponseProductJsonAdapter(@NotNull Moshi moshi) {
        Moshi moshi2 = moshi;
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(TalabatCommonUrlConstantsKt.PRODUCT_ID, "product_sku", "product_category_ids", "qty", FirebaseAnalytics.Param.PRICE, "absolute_discount", "applied_campaigns", PurchaseInfo.TOTAL, "subtotal", "free_qty", "tags", "offer_text", "tooltip_alert_text", "product_name", "product_image_url", "age_limit", "stock");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"product_id\", \"produc…l\", \"age_limit\", \"stock\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi2.adapter(cls, SetsKt__SetsKt.emptySet(), "productId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"productId\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi2.adapter(cls, SetsKt__SetsKt.emptySet(), "productSku");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…emptySet(), \"productSku\")");
        this.nullableStringAdapter = adapter2;
        Class<List> cls2 = List.class;
        JsonAdapter<List<String>> adapter3 = moshi2.adapter(Types.newParameterizedType(cls2, cls), SetsKt__SetsKt.emptySet(), "productCategoryIds");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…    \"productCategoryIds\")");
        this.nullableListOfStringAdapter = adapter3;
        JsonAdapter<Integer> adapter4 = moshi2.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.QUANTITY);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Int::class…, emptySet(), \"quantity\")");
        this.intAdapter = adapter4;
        JsonAdapter<Float> adapter5 = moshi2.adapter(Float.TYPE, SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.PRICE);
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Float::cla…mptySet(),\n      \"price\")");
        this.floatAdapter = adapter5;
        JsonAdapter<List<CampaignLabel>> adapter6 = moshi2.adapter(Types.newParameterizedType(cls2, CampaignLabel.class), SetsKt__SetsKt.emptySet(), "appliedCampaigns");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Types.newP…et(), \"appliedCampaigns\")");
        this.listOfCampaignLabelAdapter = adapter6;
        JsonAdapter<List<String>> adapter7 = moshi2.adapter(Types.newParameterizedType(cls2, cls), SetsKt__SetsKt.emptySet(), "tags");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Types.newP…emptySet(),\n      \"tags\")");
        this.listOfStringAdapter = adapter7;
        JsonAdapter<Integer> adapter8 = moshi2.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "ageLimit");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Int::class…  emptySet(), \"ageLimit\")");
        this.nullableIntAdapter = adapter8;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CartResponseProduct");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01fe, code lost:
        r9 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0200, code lost:
        r8 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0202, code lost:
        r3 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0204, code lost:
        r14 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0206, code lost:
        r12 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0208, code lost:
        r13 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x020a, code lost:
        r11 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x020c, code lost:
        r10 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x020e, code lost:
        r6 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x007e, code lost:
        r5 = r5 & r2;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.darkstorescart.data.model.CartResponseProduct fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r47) {
        /*
            r46 = this;
            r0 = r46
            r1 = r47
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r47.beginObject()
            r5 = -1
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
        L_0x0029:
            boolean r15 = r47.hasNext()
            java.lang.String r4 = "applied_campaigns"
            java.lang.String r2 = "appliedCampaigns"
            r25 = r9
            java.lang.String r9 = "absolute_discount"
            r26 = r8
            java.lang.String r8 = "absoluteDiscount"
            r27 = r3
            java.lang.String r3 = "qty"
            r28 = r14
            java.lang.String r14 = "quantity"
            r29 = r12
            java.lang.String r12 = "product_id"
            r30 = r13
            java.lang.String r13 = "productId"
            r31 = r11
            java.lang.String r11 = "subtotal"
            r32 = r10
            java.lang.String r10 = "total"
            r33 = r6
            java.lang.String r6 = "price"
            if (r15 == 0) goto L_0x0213
            com.squareup.moshi.JsonReader$Options r15 = r0.options
            int r15 = r1.selectName(r15)
            switch(r15) {
                case -1: goto L_0x01f8;
                case 0: goto L_0x01e1;
                case 1: goto L_0x01d5;
                case 2: goto L_0x01cb;
                case 3: goto L_0x01a4;
                case 4: goto L_0x017e;
                case 5: goto L_0x015a;
                case 6: goto L_0x0138;
                case 7: goto L_0x0118;
                case 8: goto L_0x00fa;
                case 9: goto L_0x00d8;
                case 10: goto L_0x00b9;
                case 11: goto L_0x00ab;
                case 12: goto L_0x009d;
                case 13: goto L_0x008f;
                case 14: goto L_0x0081;
                case 15: goto L_0x0071;
                case 16: goto L_0x0063;
                default: goto L_0x0061;
            }
        L_0x0061:
            goto L_0x01fe
        L_0x0063:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.nullableIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r23 = r2
            java.lang.Integer r23 = (java.lang.Integer) r23
            r2 = -65537(0xfffffffffffeffff, float:NaN)
            goto L_0x007e
        L_0x0071:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.nullableIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r22 = r2
            java.lang.Integer r22 = (java.lang.Integer) r22
            r2 = -32769(0xffffffffffff7fff, float:NaN)
        L_0x007e:
            r5 = r5 & r2
            goto L_0x01fe
        L_0x0081:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r21 = r2
            java.lang.String r21 = (java.lang.String) r21
            r5 = r5 & -16385(0xffffffffffffbfff, float:NaN)
            goto L_0x01fe
        L_0x008f:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r20 = r2
            java.lang.String r20 = (java.lang.String) r20
            r5 = r5 & -8193(0xffffffffffffdfff, float:NaN)
            goto L_0x01fe
        L_0x009d:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r19 = r2
            java.lang.String r19 = (java.lang.String) r19
            r5 = r5 & -4097(0xffffffffffffefff, float:NaN)
            goto L_0x01fe
        L_0x00ab:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r18 = r2
            java.lang.String r18 = (java.lang.String) r18
            r5 = r5 & -2049(0xfffffffffffff7ff, float:NaN)
            goto L_0x01fe
        L_0x00b9:
            com.squareup.moshi.JsonAdapter<java.util.List<java.lang.String>> r2 = r0.listOfStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r17 = r2
            java.util.List r17 = (java.util.List) r17
            if (r17 == 0) goto L_0x00c9
            r5 = r5 & -1025(0xfffffffffffffbff, float:NaN)
            goto L_0x01fe
        L_0x00c9:
            java.lang.String r2 = "tags"
            java.lang.String r3 = "tags"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"tags\", \"…s\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00d8:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r3 = r2
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x00eb
            r5 = r5 & -513(0xfffffffffffffdff, float:NaN)
            r9 = r25
            r8 = r26
            goto L_0x0204
        L_0x00eb:
            java.lang.String r2 = "freeQuantity"
            java.lang.String r3 = "free_qty"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"freeQuan…      \"free_qty\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00fa:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            java.lang.Float r14 = (java.lang.Float) r14
            if (r14 == 0) goto L_0x010d
            r9 = r25
            r8 = r26
            r3 = r27
            goto L_0x0206
        L_0x010d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"subtotal…      \"subtotal\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0118:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.Float r12 = (java.lang.Float) r12
            if (r12 == 0) goto L_0x012d
            r9 = r25
            r8 = r26
            r3 = r27
            r14 = r28
            goto L_0x0208
        L_0x012d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"total\", …tal\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0138:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.feature.darkstorescart.data.model.CampaignLabel>> r3 = r0.listOfCampaignLabelAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r3
            java.util.List r13 = (java.util.List) r13
            if (r13 == 0) goto L_0x014f
            r9 = r25
            r8 = r26
            r3 = r27
            r14 = r28
            r12 = r29
            goto L_0x020a
        L_0x014f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r4, r1)
            java.lang.String r2 = "unexpectedNull(\"appliedC…plied_campaigns\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x015a:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.Float r11 = (java.lang.Float) r11
            if (r11 == 0) goto L_0x0173
            r9 = r25
            r8 = r26
            r3 = r27
            r14 = r28
            r12 = r29
            r13 = r30
            goto L_0x020c
        L_0x0173:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r8, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"absolute…solute_discount\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x017e:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.Float r10 = (java.lang.Float) r10
            if (r10 == 0) goto L_0x0199
            r9 = r25
            r8 = r26
            r3 = r27
            r14 = r28
            r12 = r29
            r13 = r30
            r11 = r31
            goto L_0x020e
        L_0x0199:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r6, r1)
            java.lang.String r2 = "unexpectedNull(\"price\", …ice\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01a4:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L_0x01c0
            r9 = r25
            r8 = r26
            r3 = r27
            r14 = r28
            r12 = r29
            r13 = r30
            r11 = r31
            r10 = r32
            goto L_0x0210
        L_0x01c0:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"quantity…qty\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01cb:
            com.squareup.moshi.JsonAdapter<java.util.List<java.lang.String>> r2 = r0.nullableListOfStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.util.List r9 = (java.util.List) r9
            goto L_0x0200
        L_0x01d5:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            r9 = r25
            goto L_0x0202
        L_0x01e1:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x01ed
            goto L_0x01fe
        L_0x01ed:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"productI…    \"product_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01f8:
            r47.skipName()
            r47.skipValue()
        L_0x01fe:
            r9 = r25
        L_0x0200:
            r8 = r26
        L_0x0202:
            r3 = r27
        L_0x0204:
            r14 = r28
        L_0x0206:
            r12 = r29
        L_0x0208:
            r13 = r30
        L_0x020a:
            r11 = r31
        L_0x020c:
            r10 = r32
        L_0x020e:
            r6 = r33
        L_0x0210:
            r2 = 0
            goto L_0x0029
        L_0x0213:
            r47.endObject()
            r15 = -130561(0xfffffffffffe01ff, float:NaN)
            if (r5 != r15) goto L_0x02a1
            com.talabat.feature.darkstorescart.data.model.CartResponseProduct r5 = new com.talabat.feature.darkstorescart.data.model.CartResponseProduct
            if (r7 == 0) goto L_0x0297
            if (r33 == 0) goto L_0x028d
            int r3 = r33.intValue()
            if (r32 == 0) goto L_0x0283
            float r12 = r32.floatValue()
            if (r31 == 0) goto L_0x0279
            float r13 = r31.floatValue()
            if (r30 == 0) goto L_0x026f
            if (r29 == 0) goto L_0x0265
            float r14 = r29.floatValue()
            if (r28 == 0) goto L_0x025b
            float r15 = r28.floatValue()
            int r16 = r27.intValue()
            if (r17 == 0) goto L_0x0253
            r6 = r5
            r8 = r26
            r9 = r25
            r10 = r3
            r11 = r12
            r12 = r13
            r13 = r30
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r5
        L_0x0253:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>"
            r1.<init>(r2)
            throw r1
        L_0x025b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r2 = "missingProperty(\"subtotal\", \"subtotal\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0265:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"total\", \"total\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x026f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r4, r1)
            java.lang.String r2 = "missingProperty(\"applied…plied_campaigns\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0279:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r8, r9, r1)
            java.lang.String r2 = "missingProperty(\"absolut…solute_discount\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0283:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r2 = "missingProperty(\"price\", \"price\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x028d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r3, r1)
            java.lang.String r2 = "missingProperty(\"quantity\", \"qty\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0297:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r12, r1)
            java.lang.String r2 = "missingProperty(\"productId\", \"product_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02a1:
            java.lang.reflect.Constructor<com.talabat.feature.darkstorescart.data.model.CartResponseProduct> r15 = r0.constructorRef
            r34 = 6
            r35 = 5
            r36 = 4
            r37 = 3
            r38 = 2
            r39 = 1
            r40 = r12
            r12 = 19
            if (r15 != 0) goto L_0x0316
            java.lang.Class[] r15 = new java.lang.Class[r12]
            java.lang.Class<java.lang.String> r41 = java.lang.String.class
            r24 = 0
            r15[r24] = r41
            r15[r39] = r41
            java.lang.Class<java.util.List> r42 = java.util.List.class
            r15[r38] = r42
            java.lang.Class r43 = java.lang.Integer.TYPE
            r15[r37] = r43
            java.lang.Class r44 = java.lang.Float.TYPE
            r15[r36] = r44
            r15[r35] = r44
            r15[r34] = r42
            r45 = 7
            r15[r45] = r44
            r45 = 8
            r15[r45] = r44
            r44 = 9
            r15[r44] = r43
            r44 = 10
            r15[r44] = r42
            r42 = 11
            r15[r42] = r41
            r42 = 12
            r15[r42] = r41
            r42 = 13
            r15[r42] = r41
            r42 = 14
            r15[r42] = r41
            r41 = 15
            java.lang.Class<java.lang.Integer> r42 = java.lang.Integer.class
            r15[r41] = r42
            r41 = 16
            java.lang.Class<java.lang.Integer> r42 = java.lang.Integer.class
            r15[r41] = r42
            r41 = 17
            r15[r41] = r43
            r41 = 18
            java.lang.Class<?> r42 = com.squareup.moshi.internal.Util.DEFAULT_CONSTRUCTOR_MARKER
            r15[r41] = r42
            java.lang.Class<com.talabat.feature.darkstorescart.data.model.CartResponseProduct> r12 = com.talabat.feature.darkstorescart.data.model.CartResponseProduct.class
            java.lang.reflect.Constructor r15 = r12.getDeclaredConstructor(r15)
            r0.constructorRef = r15
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            java.lang.String r12 = "CartResponseProduct::cla…his.constructorRef = it }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r12)
            r12 = 19
        L_0x0316:
            java.lang.Object[] r12 = new java.lang.Object[r12]
            if (r7 == 0) goto L_0x03da
            r24 = 0
            r12[r24] = r7
            r12[r39] = r26
            r12[r38] = r25
            if (r33 == 0) goto L_0x03d0
            int r3 = r33.intValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12[r37] = r3
            if (r32 == 0) goto L_0x03c6
            float r3 = r32.floatValue()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r12[r36] = r3
            if (r31 == 0) goto L_0x03bc
            float r3 = r31.floatValue()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r12[r35] = r3
            if (r30 == 0) goto L_0x03b2
            r12[r34] = r30
            if (r29 == 0) goto L_0x03a8
            float r2 = r29.floatValue()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r3 = 7
            r12[r3] = r2
            if (r28 == 0) goto L_0x039e
            float r1 = r28.floatValue()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r2 = 8
            r12[r2] = r1
            r1 = 9
            r12[r1] = r27
            r1 = 10
            r12[r1] = r17
            r1 = 11
            r12[r1] = r18
            r1 = 12
            r12[r1] = r19
            r1 = 13
            r12[r1] = r20
            r1 = 14
            r12[r1] = r21
            r1 = 15
            r12[r1] = r22
            r1 = 16
            r12[r1] = r23
            r1 = 17
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r12[r1] = r2
            r1 = 18
            r2 = 0
            r12[r1] = r2
            java.lang.Object r1 = r15.newInstance(r12)
            java.lang.String r2 = "localConstructor.newInst…torMarker */ null\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.talabat.feature.darkstorescart.data.model.CartResponseProduct r1 = (com.talabat.feature.darkstorescart.data.model.CartResponseProduct) r1
            return r1
        L_0x039e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r2 = "missingProperty(\"subtotal\", \"subtotal\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x03a8:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"total\", \"total\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x03b2:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r4, r1)
            java.lang.String r2 = "missingProperty(\"applied…s\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x03bc:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r8, r9, r1)
            java.lang.String r2 = "missingProperty(\"absolut…t\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x03c6:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r2 = "missingProperty(\"price\", \"price\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x03d0:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r3, r1)
            java.lang.String r2 = "missingProperty(\"quantity\", \"qty\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x03da:
            r2 = r40
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r2, r1)
            java.lang.String r2 = "missingProperty(\"productId\", \"product_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstorescart.data.model.CartResponseProductJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.feature.darkstorescart.data.model.CartResponseProduct");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CartResponseProduct cartResponseProduct) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (cartResponseProduct != null) {
            jsonWriter.beginObject();
            jsonWriter.name(TalabatCommonUrlConstantsKt.PRODUCT_ID);
            this.stringAdapter.toJson(jsonWriter, cartResponseProduct.getProductId());
            jsonWriter.name("product_sku");
            this.nullableStringAdapter.toJson(jsonWriter, cartResponseProduct.getProductSku());
            jsonWriter.name("product_category_ids");
            this.nullableListOfStringAdapter.toJson(jsonWriter, cartResponseProduct.getProductCategoryIds());
            jsonWriter.name("qty");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(cartResponseProduct.getQuantity()));
            jsonWriter.name(FirebaseAnalytics.Param.PRICE);
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartResponseProduct.getPrice()));
            jsonWriter.name("absolute_discount");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartResponseProduct.getAbsoluteDiscount()));
            jsonWriter.name("applied_campaigns");
            this.listOfCampaignLabelAdapter.toJson(jsonWriter, cartResponseProduct.getAppliedCampaigns());
            jsonWriter.name(PurchaseInfo.TOTAL);
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartResponseProduct.getTotal()));
            jsonWriter.name("subtotal");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartResponseProduct.getSubtotal()));
            jsonWriter.name("free_qty");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(cartResponseProduct.getFreeQuantity()));
            jsonWriter.name("tags");
            this.listOfStringAdapter.toJson(jsonWriter, cartResponseProduct.getTags());
            jsonWriter.name("offer_text");
            this.nullableStringAdapter.toJson(jsonWriter, cartResponseProduct.getOfferText());
            jsonWriter.name("tooltip_alert_text");
            this.nullableStringAdapter.toJson(jsonWriter, cartResponseProduct.getTooltipAlertText());
            jsonWriter.name("product_name");
            this.nullableStringAdapter.toJson(jsonWriter, cartResponseProduct.getProductName());
            jsonWriter.name("product_image_url");
            this.nullableStringAdapter.toJson(jsonWriter, cartResponseProduct.getImageUrl());
            jsonWriter.name("age_limit");
            this.nullableIntAdapter.toJson(jsonWriter, cartResponseProduct.getAgeLimit());
            jsonWriter.name("stock");
            this.nullableIntAdapter.toJson(jsonWriter, cartResponseProduct.getStock());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
