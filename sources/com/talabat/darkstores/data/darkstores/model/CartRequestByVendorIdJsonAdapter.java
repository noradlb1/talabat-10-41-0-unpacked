package com.talabat.darkstores.data.darkstores.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.darkstores.model.TargetAudienceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/darkstores/data/darkstores/model/CartRequestByVendorIdJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/darkstores/model/CartRequestByVendorId;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "doubleAdapter", "", "floatAdapter", "", "intAdapter", "", "listOfCartProductAdapter", "", "Lcom/talabat/darkstores/data/darkstores/model/CartProduct;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "targetAudienceTypeAdapter", "Lcom/talabat/darkstores/model/TargetAudienceType;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartRequestByVendorIdJsonAdapter extends JsonAdapter<CartRequestByVendorId> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @NotNull
    private final JsonAdapter<Double> doubleAdapter;
    @NotNull
    private final JsonAdapter<Float> floatAdapter;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<List<CartProduct>> listOfCartProductAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;
    @NotNull
    private final JsonAdapter<TargetAudienceType> targetAudienceTypeAdapter;

    public CartRequestByVendorIdJsonAdapter(@NotNull Moshi moshi) {
        Moshi moshi2 = moshi;
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(FirebaseAnalytics.Param.ITEMS, "global_vendor_id", "locale", "auto_add", "platform_vendor_id", "lat", "lon", "delivery_type", "target_audience", "global_entity_id", "delivery_fee", "minimum_order_value", "chain_id", "enableBasketBasedDeliveryFee");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"items\", \"global_vend…eBasketBasedDeliveryFee\")");
        this.options = of2;
        JsonAdapter<List<CartProduct>> adapter = moshi2.adapter(Types.newParameterizedType(List.class, CartProduct.class), SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…     emptySet(), \"items\")");
        this.listOfCartProductAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi2.adapter(String.class, SetsKt__SetsKt.emptySet(), "globalVendorId");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…,\n      \"globalVendorId\")");
        this.stringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi2.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "autoAdd");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…tySet(),\n      \"autoAdd\")");
        this.booleanAdapter = adapter3;
        JsonAdapter<Double> adapter4 = moshi2.adapter(Double.TYPE, SetsKt__SetsKt.emptySet(), "latitude");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Double::cl…ySet(),\n      \"latitude\")");
        this.doubleAdapter = adapter4;
        JsonAdapter<TargetAudienceType> adapter5 = moshi2.adapter(TargetAudienceType.class, SetsKt__SetsKt.emptySet(), "targetAudience");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(TargetAudi…ySet(), \"targetAudience\")");
        this.targetAudienceTypeAdapter = adapter5;
        JsonAdapter<Float> adapter6 = moshi2.adapter(Float.TYPE, SetsKt__SetsKt.emptySet(), "deliveryFee");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Float::cla…t(),\n      \"deliveryFee\")");
        this.floatAdapter = adapter6;
        JsonAdapter<Integer> adapter7 = moshi2.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "chainId");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Int::class…a, emptySet(), \"chainId\")");
        this.intAdapter = adapter7;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CartRequestByVendorId");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02a5, code lost:
        r9 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02a7, code lost:
        r8 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02a9, code lost:
        r7 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02ab, code lost:
        r6 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x02ad, code lost:
        r15 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02af, code lost:
        r14 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02b1, code lost:
        r13 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02b3, code lost:
        r5 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02b5, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02b7, code lost:
        r12 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02b9, code lost:
        r2 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02bb, code lost:
        r11 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02bd, code lost:
        r10 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02bf, code lost:
        r4 = r30;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.darkstores.data.darkstores.model.CartRequestByVendorId fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r45) {
        /*
            r44 = this;
            r0 = r44
            r1 = r45
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r45.beginObject()
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
        L_0x001a:
            boolean r16 = r45.hasNext()
            r17 = r9
            java.lang.String r9 = "delivery_fee"
            r18 = r8
            java.lang.String r8 = "deliveryFee"
            r19 = r7
            java.lang.String r7 = "global_entity_id"
            r20 = r6
            java.lang.String r6 = "globalEntityId"
            r21 = r15
            java.lang.String r15 = "target_audience"
            r22 = r14
            java.lang.String r14 = "targetAudience"
            r23 = r13
            java.lang.String r13 = "delivery_type"
            r24 = r5
            java.lang.String r5 = "deliveryType"
            r25 = r3
            java.lang.String r3 = "lon"
            r26 = r12
            java.lang.String r12 = "longitude"
            r27 = r2
            java.lang.String r2 = "lat"
            r28 = r11
            java.lang.String r11 = "latitude"
            r29 = r10
            java.lang.String r10 = "platform_vendor_id"
            r30 = r4
            java.lang.String r4 = "platformVendorId"
            r31 = r4
            java.lang.String r4 = "auto_add"
            r32 = r4
            java.lang.String r4 = "autoAdd"
            r33 = r4
            java.lang.String r4 = "global_vendor_id"
            r34 = r4
            java.lang.String r4 = "globalVendorId"
            r35 = r4
            java.lang.String r4 = "enableBasketBasedDeliveryFee"
            r36 = r10
            java.lang.String r10 = "locale"
            r37 = r10
            java.lang.String r10 = "items"
            if (r16 == 0) goto L_0x02c3
            r16 = r10
            com.squareup.moshi.JsonReader$Options r10 = r0.options
            int r10 = r1.selectName(r10)
            switch(r10) {
                case -1: goto L_0x029f;
                case 0: goto L_0x026b;
                case 1: goto L_0x0237;
                case 2: goto L_0x0207;
                case 3: goto L_0x01d8;
                case 4: goto L_0x01aa;
                case 5: goto L_0x0183;
                case 6: goto L_0x015d;
                case 7: goto L_0x0139;
                case 8: goto L_0x0117;
                case 9: goto L_0x00f7;
                case 10: goto L_0x00d9;
                case 11: goto L_0x00b9;
                case 12: goto L_0x009b;
                case 13: goto L_0x0083;
                default: goto L_0x0081;
            }
        L_0x0081:
            goto L_0x02a5
        L_0x0083:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            if (r9 == 0) goto L_0x0090
            goto L_0x02a7
        L_0x0090:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r4, r1)
            java.lang.String r2 = "unexpectedNull(\"enableBa…asedDeliveryFee\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x009b:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 == 0) goto L_0x00aa
            r9 = r17
            goto L_0x02a9
        L_0x00aa:
            java.lang.String r2 = "chainId"
            java.lang.String r3 = "chain_id"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"chainId\"…      \"chain_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00b9:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.Float r7 = (java.lang.Float) r7
            if (r7 == 0) goto L_0x00ca
            r9 = r17
            r8 = r18
            goto L_0x02ab
        L_0x00ca:
            java.lang.String r2 = "minOrderValue"
            java.lang.String r3 = "minimum_order_value"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"minOrder…mum_order_value\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00d9:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.Float r6 = (java.lang.Float) r6
            if (r6 == 0) goto L_0x00ec
            r9 = r17
            r8 = r18
            r7 = r19
            goto L_0x02ad
        L_0x00ec:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r8, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"delivery…, \"delivery_fee\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00f7:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
            if (r15 == 0) goto L_0x010c
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            goto L_0x02af
        L_0x010c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"globalEn…lobal_entity_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0117:
            com.squareup.moshi.JsonAdapter<com.talabat.darkstores.model.TargetAudienceType> r2 = r0.targetAudienceTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            com.talabat.darkstores.model.TargetAudienceType r2 = (com.talabat.darkstores.model.TargetAudienceType) r2
            if (r2 == 0) goto L_0x012e
            r14 = r2
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            r15 = r21
            goto L_0x02b1
        L_0x012e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"targetAu…target_audience\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0139:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0152
            r13 = r2
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            r15 = r21
            r14 = r22
            goto L_0x02b3
        L_0x0152:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r5, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"delivery… \"delivery_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x015d:
            com.squareup.moshi.JsonAdapter<java.lang.Double> r2 = r0.doubleAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.Double r5 = (java.lang.Double) r5
            if (r5 == 0) goto L_0x0178
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            r15 = r21
            r14 = r22
            r13 = r23
            goto L_0x02b5
        L_0x0178:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"longitud…           \"lon\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0183:
            com.squareup.moshi.JsonAdapter<java.lang.Double> r3 = r0.doubleAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Double r3 = (java.lang.Double) r3
            if (r3 == 0) goto L_0x019f
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            r15 = r21
            r14 = r22
            r13 = r23
            r5 = r24
            goto L_0x02b7
        L_0x019f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"latitude…           \"lat\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01aa:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x01c9
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            r15 = r21
            r14 = r22
            r13 = r23
            r5 = r24
            r3 = r25
            goto L_0x02b9
        L_0x01c9:
            r2 = r31
            r10 = r36
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"platform…tform_vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01d8:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x01f8
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            r15 = r21
            r14 = r22
            r13 = r23
            r5 = r24
            r3 = r25
            r12 = r26
            goto L_0x02bb
        L_0x01f8:
            r2 = r32
            r3 = r33
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"autoAdd\"…      \"auto_add\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0207:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x022a
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            r15 = r21
            r14 = r22
            r13 = r23
            r5 = r24
            r3 = r25
            r12 = r26
            r2 = r27
            goto L_0x02bd
        L_0x022a:
            r2 = r37
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"locale\",…        \"locale\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0237:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x025c
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            r15 = r21
            r14 = r22
            r13 = r23
            r5 = r24
            r3 = r25
            r12 = r26
            r2 = r27
            r11 = r28
            goto L_0x02bf
        L_0x025c:
            r2 = r34
            r3 = r35
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"globalVe…lobal_vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x026b:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.darkstores.data.darkstores.model.CartProduct>> r2 = r0.listOfCartProductAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L_0x0292
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            r15 = r21
            r14 = r22
            r13 = r23
            r5 = r24
            r3 = r25
            r12 = r26
            r2 = r27
            r11 = r28
            r10 = r29
            goto L_0x001a
        L_0x0292:
            r2 = r16
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"items\",\n…         \"items\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x029f:
            r45.skipName()
            r45.skipValue()
        L_0x02a5:
            r9 = r17
        L_0x02a7:
            r8 = r18
        L_0x02a9:
            r7 = r19
        L_0x02ab:
            r6 = r20
        L_0x02ad:
            r15 = r21
        L_0x02af:
            r14 = r22
        L_0x02b1:
            r13 = r23
        L_0x02b3:
            r5 = r24
        L_0x02b5:
            r3 = r25
        L_0x02b7:
            r12 = r26
        L_0x02b9:
            r2 = r27
        L_0x02bb:
            r11 = r28
        L_0x02bd:
            r10 = r29
        L_0x02bf:
            r4 = r30
            goto L_0x001a
        L_0x02c3:
            r43 = r10
            r0 = r31
            r38 = r32
            r39 = r33
            r40 = r34
            r41 = r35
            r10 = r36
            r42 = r37
            r45.endObject()
            com.talabat.darkstores.data.darkstores.model.CartRequestByVendorId r31 = new com.talabat.darkstores.data.darkstores.model.CartRequestByVendorId
            if (r30 == 0) goto L_0x03c1
            if (r29 == 0) goto L_0x03b3
            if (r28 == 0) goto L_0x03a7
            if (r27 == 0) goto L_0x0399
            boolean r16 = r27.booleanValue()
            if (r26 == 0) goto L_0x038f
            if (r25 == 0) goto L_0x0385
            double r10 = r25.doubleValue()
            if (r24 == 0) goto L_0x037b
            double r24 = r24.doubleValue()
            if (r23 == 0) goto L_0x0371
            if (r22 == 0) goto L_0x0367
            if (r21 == 0) goto L_0x035d
            if (r20 == 0) goto L_0x0353
            float r0 = r20.floatValue()
            if (r19 == 0) goto L_0x0345
            float r2 = r19.floatValue()
            if (r18 == 0) goto L_0x0337
            int r18 = r18.intValue()
            if (r17 == 0) goto L_0x032d
            boolean r19 = r17.booleanValue()
            r3 = r31
            r4 = r30
            r5 = r29
            r6 = r28
            r7 = r16
            r8 = r26
            r9 = r10
            r11 = r24
            r13 = r23
            r14 = r22
            r15 = r21
            r16 = r0
            r17 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16, r17, r18, r19)
            return r31
        L_0x032d:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r4, r4, r1)
            java.lang.String r1 = "missingProperty(\"enableB…asedDeliveryFee\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0337:
            java.lang.String r0 = "chainId"
            java.lang.String r2 = "chain_id"
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r2, r1)
            java.lang.String r1 = "missingProperty(\"chainId\", \"chain_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0345:
            java.lang.String r0 = "minOrderValue"
            java.lang.String r2 = "minimum_order_value"
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r2, r1)
            java.lang.String r1 = "missingProperty(\"minOrde…mum_order_value\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0353:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r8, r9, r1)
            java.lang.String r1 = "missingProperty(\"deliver…fee\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x035d:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r6, r7, r1)
            java.lang.String r1 = "missingProperty(\"globalE…lobal_entity_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0367:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r14, r15, r1)
            java.lang.String r1 = "missingProperty(\"targetA…target_audience\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0371:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r5, r13, r1)
            java.lang.String r1 = "missingProperty(\"deliver…ype\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x037b:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r12, r3, r1)
            java.lang.String r1 = "missingProperty(\"longitude\", \"lon\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0385:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r11, r2, r1)
            java.lang.String r1 = "missingProperty(\"latitude\", \"lat\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x038f:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r10, r1)
            java.lang.String r1 = "missingProperty(\"platfor…tform_vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0399:
            r0 = r38
            r2 = r39
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r0, r1)
            java.lang.String r1 = "missingProperty(\"autoAdd\", \"auto_add\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03a7:
            r0 = r42
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "missingProperty(\"locale\", \"locale\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03b3:
            r0 = r40
            r2 = r41
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r0, r1)
            java.lang.String r1 = "missingProperty(\"globalV…lobal_vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03c1:
            r0 = r43
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "missingProperty(\"items\", \"items\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.darkstores.model.CartRequestByVendorIdJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.darkstores.data.darkstores.model.CartRequestByVendorId");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CartRequestByVendorId cartRequestByVendorId) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (cartRequestByVendorId != null) {
            jsonWriter.beginObject();
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.listOfCartProductAdapter.toJson(jsonWriter, cartRequestByVendorId.getItems());
            jsonWriter.name("global_vendor_id");
            this.stringAdapter.toJson(jsonWriter, cartRequestByVendorId.getGlobalVendorId());
            jsonWriter.name("locale");
            this.stringAdapter.toJson(jsonWriter, cartRequestByVendorId.getLocale());
            jsonWriter.name("auto_add");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(cartRequestByVendorId.getAutoAdd()));
            jsonWriter.name("platform_vendor_id");
            this.stringAdapter.toJson(jsonWriter, cartRequestByVendorId.getPlatformVendorId());
            jsonWriter.name("lat");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(cartRequestByVendorId.getLatitude()));
            jsonWriter.name("lon");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(cartRequestByVendorId.getLongitude()));
            jsonWriter.name("delivery_type");
            this.stringAdapter.toJson(jsonWriter, cartRequestByVendorId.getDeliveryType());
            jsonWriter.name("target_audience");
            this.targetAudienceTypeAdapter.toJson(jsonWriter, cartRequestByVendorId.getTargetAudience());
            jsonWriter.name("global_entity_id");
            this.stringAdapter.toJson(jsonWriter, cartRequestByVendorId.getGlobalEntityId());
            jsonWriter.name("delivery_fee");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartRequestByVendorId.getDeliveryFee()));
            jsonWriter.name("minimum_order_value");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartRequestByVendorId.getMinOrderValue()));
            jsonWriter.name("chain_id");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(cartRequestByVendorId.getChainId()));
            jsonWriter.name("enableBasketBasedDeliveryFee");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(cartRequestByVendorId.getEnableBasketBasedDeliveryFee()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
