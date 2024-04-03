package com.talabat.feature.darkstorescart.data.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import com.visa.checkout.PurchaseInfo;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/CartResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "floatAdapter", "", "listOfCampaignLabelAdapter", "", "Lcom/talabat/feature/darkstorescart/data/model/CampaignLabel;", "listOfCartResponseProductAdapter", "Lcom/talabat/feature/darkstorescart/data/model/CartResponseProduct;", "nullableFloatAdapter", "nullableListOfFeeDescriptionAdapter", "Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;", "nullableNetworkCampaignProgressResponseAdapter", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartResponseJsonAdapter extends JsonAdapter<CartResponse> {
    @Nullable
    private volatile Constructor<CartResponse> constructorRef;
    @NotNull
    private final JsonAdapter<Float> floatAdapter;
    @NotNull
    private final JsonAdapter<List<CampaignLabel>> listOfCampaignLabelAdapter;
    @NotNull
    private final JsonAdapter<List<CartResponseProduct>> listOfCartResponseProductAdapter;
    @NotNull
    private final JsonAdapter<Float> nullableFloatAdapter;
    @NotNull
    private final JsonAdapter<List<FeeDescription>> nullableListOfFeeDescriptionAdapter;
    @NotNull
    private final JsonAdapter<NetworkCampaignProgressResponse> nullableNetworkCampaignProgressResponseAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public CartResponseJsonAdapter(@NotNull Moshi moshi) {
        Moshi moshi2 = moshi;
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(FirebaseAnalytics.Param.ITEMS, "applied_campaigns", PurchaseInfo.TOTAL, "subtotal", "absolute_discount", "delivery_fee", "service_fee", "subtotal_after_discount", "delivery_total", "target_audience", "delivery_absolute_discount", "vendor_id", "fees_desc", "cart_id", "campaign_progress");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"items\", \"applied_cam…id\", \"campaign_progress\")");
        this.options = of2;
        Class<List> cls = List.class;
        JsonAdapter<List<CartResponseProduct>> adapter = moshi2.adapter(Types.newParameterizedType(cls, CartResponseProduct.class), SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…     emptySet(), \"items\")");
        this.listOfCartResponseProductAdapter = adapter;
        JsonAdapter<List<CampaignLabel>> adapter2 = moshi2.adapter(Types.newParameterizedType(cls, CampaignLabel.class), SetsKt__SetsKt.emptySet(), "appliedCampaigns");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…et(), \"appliedCampaigns\")");
        this.listOfCampaignLabelAdapter = adapter2;
        JsonAdapter<Float> adapter3 = moshi2.adapter(Float.TYPE, SetsKt__SetsKt.emptySet(), PurchaseInfo.TOTAL);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Float::cla…mptySet(),\n      \"total\")");
        this.floatAdapter = adapter3;
        JsonAdapter<Float> adapter4 = moshi2.adapter(Float.class, SetsKt__SetsKt.emptySet(), "serviceFee");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Float::cla…emptySet(), \"serviceFee\")");
        this.nullableFloatAdapter = adapter4;
        Class<String> cls2 = String.class;
        JsonAdapter<String> adapter5 = moshi2.adapter(cls2, SetsKt__SetsKt.emptySet(), "targetAudience");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(String::cl…,\n      \"targetAudience\")");
        this.stringAdapter = adapter5;
        JsonAdapter<List<FeeDescription>> adapter6 = moshi2.adapter(Types.newParameterizedType(cls, FeeDescription.class), SetsKt__SetsKt.emptySet(), "feeDescriptions");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Types.newP…Set(), \"feeDescriptions\")");
        this.nullableListOfFeeDescriptionAdapter = adapter6;
        JsonAdapter<String> adapter7 = moshi2.adapter(cls2, SetsKt__SetsKt.emptySet(), FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(String::cl…    emptySet(), \"cartId\")");
        this.nullableStringAdapter = adapter7;
        JsonAdapter<NetworkCampaignProgressResponse> adapter8 = moshi2.adapter(NetworkCampaignProgressResponse.class, SetsKt__SetsKt.emptySet(), "campaignProgress");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(NetworkCam…et(), \"campaignProgress\")");
        this.nullableNetworkCampaignProgressResponseAdapter = adapter8;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(34);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CartResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0224, code lost:
        r13 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0226, code lost:
        r10 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0228, code lost:
        r12 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x022a, code lost:
        r11 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x022c, code lost:
        r14 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x022e, code lost:
        r9 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0230, code lost:
        r8 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0232, code lost:
        r7 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0234, code lost:
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0236, code lost:
        r6 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0238, code lost:
        r5 = r31;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.darkstorescart.data.model.CartResponse fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r44) {
        /*
            r43 = this;
            r0 = r43
            r1 = r44
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r44.beginObject()
            r3 = -1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
        L_0x0020:
            boolean r15 = r44.hasNext()
            java.lang.String r2 = "vendor_id"
            r23 = r12
            java.lang.String r12 = "vendorId"
            r24 = r11
            java.lang.String r11 = "delivery_absolute_discount"
            r21 = r13
            java.lang.String r13 = "deliveryAbsoluteDiscount"
            r25 = r14
            java.lang.String r14 = "target_audience"
            r22 = r10
            java.lang.String r10 = "targetAudience"
            r26 = r9
            java.lang.String r9 = "delivery_total"
            r27 = r8
            java.lang.String r8 = "deliveryTotal"
            r28 = r7
            java.lang.String r7 = "delivery_fee"
            r29 = r4
            java.lang.String r4 = "deliveryFee"
            r30 = r6
            java.lang.String r6 = "absolute_discount"
            r31 = r5
            java.lang.String r5 = "absoluteDiscount"
            r32 = r5
            java.lang.String r5 = "applied_campaigns"
            r33 = r5
            java.lang.String r5 = "appliedCampaigns"
            r34 = r5
            java.lang.String r5 = "subtotal"
            r35 = r5
            java.lang.String r5 = "total"
            r36 = r5
            java.lang.String r5 = "items"
            if (r15 == 0) goto L_0x023c
            com.squareup.moshi.JsonReader$Options r15 = r0.options
            int r15 = r1.selectName(r15)
            switch(r15) {
                case -1: goto L_0x021e;
                case 0: goto L_0x01f2;
                case 1: goto L_0x01c5;
                case 2: goto L_0x019b;
                case 3: goto L_0x0173;
                case 4: goto L_0x014d;
                case 5: goto L_0x012b;
                case 6: goto L_0x011a;
                case 7: goto L_0x010b;
                case 8: goto L_0x00f1;
                case 9: goto L_0x00d1;
                case 10: goto L_0x00b9;
                case 11: goto L_0x00a0;
                case 12: goto L_0x0094;
                case 13: goto L_0x0086;
                case 14: goto L_0x0076;
                default: goto L_0x0074;
            }
        L_0x0074:
            goto L_0x0224
        L_0x0076:
            com.squareup.moshi.JsonAdapter<com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse> r2 = r0.nullableNetworkCampaignProgressResponseAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r20 = r2
            com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse r20 = (com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse) r20
            r2 = -32769(0xffffffffffff7fff, float:NaN)
            r3 = r3 & r2
            goto L_0x0224
        L_0x0086:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r18 = r2
            java.lang.String r18 = (java.lang.String) r18
            r3 = r3 & -8193(0xffffffffffffdfff, float:NaN)
            goto L_0x0224
        L_0x0094:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.feature.darkstorescart.data.model.FeeDescription>> r2 = r0.nullableListOfFeeDescriptionAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r17 = r2
            java.util.List r17 = (java.util.List) r17
            goto L_0x0224
        L_0x00a0:
            com.squareup.moshi.JsonAdapter<java.lang.String> r4 = r0.stringAdapter
            java.lang.Object r4 = r4.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r4
            java.lang.String r16 = (java.lang.String) r16
            if (r16 == 0) goto L_0x00ae
            goto L_0x0224
        L_0x00ae:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"vendorId…     \"vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00b9:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Float r2 = (java.lang.Float) r2
            if (r2 == 0) goto L_0x00c6
            r13 = r2
            goto L_0x0226
        L_0x00c6:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"delivery…unt\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00d1:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00e6
            r14 = r2
            r13 = r21
            r10 = r22
            r12 = r23
            r11 = r24
            goto L_0x022e
        L_0x00e6:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"targetAu…target_audience\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00f1:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.Float r10 = (java.lang.Float) r10
            if (r10 == 0) goto L_0x0100
            r13 = r21
            goto L_0x0228
        L_0x0100:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r8, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"delivery…\"delivery_total\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x010b:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.nullableFloatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.Float r12 = (java.lang.Float) r12
            r13 = r21
            r10 = r22
            goto L_0x022a
        L_0x011a:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.nullableFloatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.Float r11 = (java.lang.Float) r11
            r13 = r21
            r10 = r22
            r12 = r23
            goto L_0x022c
        L_0x012b:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.Float r9 = (java.lang.Float) r9
            if (r9 == 0) goto L_0x0142
            r13 = r21
            r10 = r22
            r12 = r23
            r11 = r24
            r14 = r25
            goto L_0x0230
        L_0x0142:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"delivery…  \"delivery_fee\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x014d:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.Float r8 = (java.lang.Float) r8
            if (r8 == 0) goto L_0x0166
            r13 = r21
            r10 = r22
            r12 = r23
            r11 = r24
            r14 = r25
            r9 = r26
            goto L_0x0232
        L_0x0166:
            r15 = r32
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r6, r1)
            java.lang.String r2 = "unexpectedNull(\"absolute…solute_discount\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0173:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.Float r7 = (java.lang.Float) r7
            if (r7 == 0) goto L_0x018e
            r13 = r21
            r10 = r22
            r12 = r23
            r11 = r24
            r14 = r25
            r9 = r26
            r8 = r27
            goto L_0x0234
        L_0x018e:
            r2 = r35
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"subtotal…      \"subtotal\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x019b:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.Float r4 = (java.lang.Float) r4
            if (r4 == 0) goto L_0x01b8
            r13 = r21
            r10 = r22
            r12 = r23
            r11 = r24
            r14 = r25
            r9 = r26
            r8 = r27
            r7 = r28
            goto L_0x0236
        L_0x01b8:
            r2 = r36
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"total\", …tal\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01c5:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.feature.darkstorescart.data.model.CampaignLabel>> r2 = r0.listOfCampaignLabelAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x01e3
            r13 = r21
            r10 = r22
            r12 = r23
            r11 = r24
            r14 = r25
            r9 = r26
            r8 = r27
            r7 = r28
            r4 = r29
            goto L_0x0238
        L_0x01e3:
            r2 = r33
            r4 = r34
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"appliedC…plied_campaigns\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01f2:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.feature.darkstorescart.data.model.CartResponseProduct>> r2 = r0.listOfCartResponseProductAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0213
            r5 = r2
            r13 = r21
            r10 = r22
            r12 = r23
            r11 = r24
            r14 = r25
            r9 = r26
            r8 = r27
            r7 = r28
            r4 = r29
            r6 = r30
            goto L_0x0020
        L_0x0213:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r5, r5, r1)
            java.lang.String r2 = "unexpectedNull(\"items\", \"items\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x021e:
            r44.skipName()
            r44.skipValue()
        L_0x0224:
            r13 = r21
        L_0x0226:
            r10 = r22
        L_0x0228:
            r12 = r23
        L_0x022a:
            r11 = r24
        L_0x022c:
            r14 = r25
        L_0x022e:
            r9 = r26
        L_0x0230:
            r8 = r27
        L_0x0232:
            r7 = r28
        L_0x0234:
            r4 = r29
        L_0x0236:
            r6 = r30
        L_0x0238:
            r5 = r31
            goto L_0x0020
        L_0x023c:
            r15 = r32
            r0 = r35
            r32 = r5
            r5 = r36
            r44.endObject()
            r5 = -40961(0xffffffffffff5fff, float:NaN)
            if (r3 != r5) goto L_0x0305
            com.talabat.feature.darkstorescart.data.model.CartResponse r3 = new com.talabat.feature.darkstorescart.data.model.CartResponse
            if (r31 == 0) goto L_0x02f9
            if (r30 == 0) goto L_0x02eb
            if (r29 == 0) goto L_0x02df
            float r29 = r29.floatValue()
            if (r28 == 0) goto L_0x02d5
            float r0 = r28.floatValue()
            if (r27 == 0) goto L_0x02cb
            float r15 = r27.floatValue()
            if (r26 == 0) goto L_0x02c1
            float r26 = r26.floatValue()
            if (r22 == 0) goto L_0x02b7
            float r27 = r22.floatValue()
            if (r25 == 0) goto L_0x02ad
            if (r21 == 0) goto L_0x02a3
            float r28 = r21.floatValue()
            if (r16 == 0) goto L_0x0299
            r19 = 0
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 0
            r4 = r3
            r5 = r31
            r6 = r30
            r7 = r29
            r8 = r0
            r9 = r15
            r10 = r26
            r11 = r24
            r12 = r23
            r13 = r27
            r14 = r25
            r15 = r28
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r3
        L_0x0299:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r12, r2, r1)
            java.lang.String r1 = "missingProperty(\"vendorId\", \"vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x02a3:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r13, r11, r1)
            java.lang.String r1 = "missingProperty(\"deliver…t\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x02ad:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r10, r14, r1)
            java.lang.String r1 = "missingProperty(\"targetA…target_audience\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x02b7:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r8, r9, r1)
            java.lang.String r1 = "missingProperty(\"deliver…\"delivery_total\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x02c1:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r4, r7, r1)
            java.lang.String r1 = "missingProperty(\"deliver…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x02cb:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r15, r6, r1)
            java.lang.String r1 = "missingProperty(\"absolut…solute_discount\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x02d5:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "missingProperty(\"subtotal\", \"subtotal\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x02df:
            r5 = r36
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r5, r5, r1)
            java.lang.String r1 = "missingProperty(\"total\", \"total\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x02eb:
            r0 = r33
            r2 = r34
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r0, r1)
            java.lang.String r1 = "missingProperty(\"applied…plied_campaigns\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x02f9:
            r0 = r32
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "missingProperty(\"items\", \"items\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0305:
            r5 = r43
            r35 = r0
            r39 = r32
            r37 = r33
            r38 = r34
            java.lang.reflect.Constructor<com.talabat.feature.darkstorescart.data.model.CartResponse> r0 = r5.constructorRef
            r32 = r6
            r6 = 18
            if (r0 != 0) goto L_0x0380
            java.lang.Class[] r0 = new java.lang.Class[r6]
            r33 = 0
            java.lang.Class<java.util.List> r34 = java.util.List.class
            r0[r33] = r34
            r33 = 1
            r0[r33] = r34
            java.lang.Class r33 = java.lang.Float.TYPE
            r40 = 2
            r0[r40] = r33
            r40 = 3
            r0[r40] = r33
            r40 = 4
            r0[r40] = r33
            r40 = 5
            r0[r40] = r33
            r40 = 6
            java.lang.Class<java.lang.Float> r41 = java.lang.Float.class
            r0[r40] = r41
            r40 = 7
            r0[r40] = r41
            r40 = 8
            r0[r40] = r33
            r40 = 9
            java.lang.Class<java.lang.String> r42 = java.lang.String.class
            r0[r40] = r42
            r40 = 10
            r0[r40] = r33
            r33 = 11
            r0[r33] = r42
            r33 = 12
            r0[r33] = r34
            r33 = 13
            r0[r33] = r42
            r33 = 14
            r0[r33] = r41
            r33 = 15
            java.lang.Class<com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse> r34 = com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse.class
            r0[r33] = r34
            r33 = 16
            java.lang.Class r34 = java.lang.Integer.TYPE
            r0[r33] = r34
            r33 = 17
            java.lang.Class<?> r34 = com.squareup.moshi.internal.Util.DEFAULT_CONSTRUCTOR_MARKER
            r0[r33] = r34
            java.lang.Class<com.talabat.feature.darkstorescart.data.model.CartResponse> r6 = com.talabat.feature.darkstorescart.data.model.CartResponse.class
            java.lang.reflect.Constructor r0 = r6.getDeclaredConstructor(r0)
            r5.constructorRef = r0
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            java.lang.String r6 = "CartResponse::class.java…his.constructorRef = it }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            r6 = 18
        L_0x0380:
            java.lang.Object[] r6 = new java.lang.Object[r6]
            if (r31 == 0) goto L_0x0480
            r33 = 0
            r6[r33] = r31
            if (r30 == 0) goto L_0x0472
            r31 = 1
            r6[r31] = r30
            if (r29 == 0) goto L_0x0466
            float r29 = r29.floatValue()
            java.lang.Float r29 = java.lang.Float.valueOf(r29)
            r30 = 2
            r6[r30] = r29
            if (r28 == 0) goto L_0x045a
            float r28 = r28.floatValue()
            java.lang.Float r28 = java.lang.Float.valueOf(r28)
            r29 = 3
            r6[r29] = r28
            if (r27 == 0) goto L_0x044e
            float r15 = r27.floatValue()
            java.lang.Float r15 = java.lang.Float.valueOf(r15)
            r27 = 4
            r6[r27] = r15
            if (r26 == 0) goto L_0x0444
            float r4 = r26.floatValue()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r7 = 5
            r6[r7] = r4
            r4 = 6
            r6[r4] = r24
            r4 = 7
            r6[r4] = r23
            if (r22 == 0) goto L_0x043a
            float r4 = r22.floatValue()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r7 = 8
            r6[r7] = r4
            if (r25 == 0) goto L_0x0430
            r4 = 9
            r6[r4] = r25
            if (r21 == 0) goto L_0x0426
            float r4 = r21.floatValue()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r7 = 10
            r6[r7] = r4
            if (r16 == 0) goto L_0x041c
            r1 = 11
            r6[r1] = r16
            r1 = 12
            r6[r1] = r17
            r1 = 13
            r6[r1] = r18
            r1 = 14
            r2 = 0
            r6[r1] = r2
            r1 = 15
            r6[r1] = r20
            r1 = 16
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6[r1] = r3
            r1 = 17
            r6[r1] = r2
            java.lang.Object r0 = r0.newInstance(r6)
            java.lang.String r1 = "localConstructor.newInst…torMarker */ null\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.talabat.feature.darkstorescart.data.model.CartResponse r0 = (com.talabat.feature.darkstorescart.data.model.CartResponse) r0
            return r0
        L_0x041c:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r12, r2, r1)
            java.lang.String r1 = "missingProperty(\"vendorId\", \"vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0426:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r13, r11, r1)
            java.lang.String r1 = "missingProperty(\"deliver…solute_discount\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0430:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r10, r14, r1)
            java.lang.String r1 = "missingProperty(\"targetA…target_audience\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x043a:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r8, r9, r1)
            java.lang.String r1 = "missingProperty(\"deliver…\"delivery_total\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0444:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r4, r7, r1)
            java.lang.String r1 = "missingProperty(\"deliver…, \"delivery_fee\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x044e:
            r0 = r32
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r15, r0, r1)
            java.lang.String r1 = "missingProperty(\"absolut…t\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x045a:
            r0 = r35
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "missingProperty(\"subtotal\", \"subtotal\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0466:
            r0 = r36
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "missingProperty(\"total\", \"total\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0472:
            r0 = r37
            r2 = r38
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r0, r1)
            java.lang.String r1 = "missingProperty(\"applied…s\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0480:
            r0 = r39
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "missingProperty(\"items\", \"items\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstorescart.data.model.CartResponseJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.feature.darkstorescart.data.model.CartResponse");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CartResponse cartResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (cartResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.listOfCartResponseProductAdapter.toJson(jsonWriter, cartResponse.getItems());
            jsonWriter.name("applied_campaigns");
            this.listOfCampaignLabelAdapter.toJson(jsonWriter, cartResponse.getAppliedCampaigns());
            jsonWriter.name(PurchaseInfo.TOTAL);
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartResponse.getTotal()));
            jsonWriter.name("subtotal");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartResponse.getSubtotal()));
            jsonWriter.name("absolute_discount");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartResponse.getAbsoluteDiscount()));
            jsonWriter.name("delivery_fee");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartResponse.getDeliveryFee()));
            jsonWriter.name("service_fee");
            this.nullableFloatAdapter.toJson(jsonWriter, cartResponse.getServiceFee());
            jsonWriter.name("subtotal_after_discount");
            this.nullableFloatAdapter.toJson(jsonWriter, cartResponse.getSubtotalAfterDiscount());
            jsonWriter.name("delivery_total");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartResponse.getDeliveryTotal()));
            jsonWriter.name("target_audience");
            this.stringAdapter.toJson(jsonWriter, cartResponse.getTargetAudience());
            jsonWriter.name("delivery_absolute_discount");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartResponse.getDeliveryAbsoluteDiscount()));
            jsonWriter.name("vendor_id");
            this.stringAdapter.toJson(jsonWriter, cartResponse.getVendorId());
            jsonWriter.name("fees_desc");
            this.nullableListOfFeeDescriptionAdapter.toJson(jsonWriter, cartResponse.getFeeDescriptions());
            jsonWriter.name("cart_id");
            this.nullableStringAdapter.toJson(jsonWriter, cartResponse.getCartId());
            jsonWriter.name("campaign_progress");
            this.nullableNetworkCampaignProgressResponseAdapter.toJson(jsonWriter, cartResponse.getCampaignProgress());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
