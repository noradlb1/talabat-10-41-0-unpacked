package com.talabat.feature.darkstoresflutter.data.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.visa.checkout.PurchaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010 \u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCartItemJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCartItem;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "floatAdapter", "", "intAdapter", "", "listOfFlutterCampaignAdapter", "", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaign;", "listOfStringAdapter", "", "nullableFloatAdapter", "nullableFlutterTrackingAdapter", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterTracking;", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCartItemJsonAdapter extends JsonAdapter<FlutterCartItem> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @NotNull
    private final JsonAdapter<Float> floatAdapter;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<List<FlutterCampaign>> listOfFlutterCampaignAdapter;
    @NotNull
    private final JsonAdapter<List<String>> listOfStringAdapter;
    @NotNull
    private final JsonAdapter<Float> nullableFloatAdapter;
    @NotNull
    private final JsonAdapter<FlutterTracking> nullableFlutterTrackingAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public FlutterCartItemJsonAdapter(@NotNull Moshi moshi) {
        Moshi moshi2 = moshi;
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("productId", FirebaseAnalytics.Param.PRICE, "oldPrice", FirebaseAnalytics.Param.QUANTITY, "freeQuantity", "campaigns", "absoluteDiscount", "ageLimit", "mainImageUrl", "imageURLs", "categoryId", "itemDescription", "name", "tags", "stockAmount", "sku", "isFavourited", "isSponsored", "tracking", "offerText", "subtotal", PurchaseInfo.TOTAL, "tooltipAlertText");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"productId\", \"price\",…      \"tooltipAlertText\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi2.adapter(cls, SetsKt__SetsKt.emptySet(), "productId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"productId\")");
        this.stringAdapter = adapter;
        JsonAdapter<Float> adapter2 = moshi2.adapter(Float.TYPE, SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.PRICE);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Float::cla…mptySet(),\n      \"price\")");
        this.floatAdapter = adapter2;
        JsonAdapter<Float> adapter3 = moshi2.adapter(Float.class, SetsKt__SetsKt.emptySet(), "oldPrice");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Float::cla…  emptySet(), \"oldPrice\")");
        this.nullableFloatAdapter = adapter3;
        JsonAdapter<Integer> adapter4 = moshi2.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.QUANTITY);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Int::class…, emptySet(), \"quantity\")");
        this.intAdapter = adapter4;
        Class<List> cls2 = List.class;
        JsonAdapter<List<FlutterCampaign>> adapter5 = moshi2.adapter(Types.newParameterizedType(cls2, FlutterCampaign.class), SetsKt__SetsKt.emptySet(), "campaigns");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP… emptySet(), \"campaigns\")");
        this.listOfFlutterCampaignAdapter = adapter5;
        JsonAdapter<List<String>> adapter6 = moshi2.adapter(Types.newParameterizedType(cls2, cls), SetsKt__SetsKt.emptySet(), "imageURLs");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Types.newP…Set(),\n      \"imageURLs\")");
        this.listOfStringAdapter = adapter6;
        JsonAdapter<String> adapter7 = moshi2.adapter(cls, SetsKt__SetsKt.emptySet(), "categoryId");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(String::cl…emptySet(), \"categoryId\")");
        this.nullableStringAdapter = adapter7;
        JsonAdapter<Boolean> adapter8 = moshi2.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "isFavourited");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Boolean::c…(),\n      \"isFavourited\")");
        this.booleanAdapter = adapter8;
        JsonAdapter<FlutterTracking> adapter9 = moshi2.adapter(FlutterTracking.class, SetsKt__SetsKt.emptySet(), "tracking");
        Intrinsics.checkNotNullExpressionValue(adapter9, "moshi.adapter(FlutterTra…, emptySet(), \"tracking\")");
        this.nullableFlutterTrackingAdapter = adapter9;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FlutterCartItem");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0302, code lost:
        r15 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0304, code lost:
        r11 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0306, code lost:
        r10 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0308, code lost:
        r9 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x030a, code lost:
        r8 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x030c, code lost:
        r14 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x030e, code lost:
        r13 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0310, code lost:
        r7 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0312, code lost:
        r6 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0314, code lost:
        r12 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0316, code lost:
        r5 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0318, code lost:
        r3 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x031a, code lost:
        r2 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x031c, code lost:
        r4 = r39;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.darkstoresflutter.data.model.FlutterCartItem fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r42) {
        /*
            r41 = this;
            r0 = r41
            r1 = r42
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r42.beginObject()
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
            r16 = r15
            r17 = r16
            r18 = r17
            r19 = r18
            r22 = r19
            r23 = r22
            r24 = r23
            r25 = r24
            r26 = r25
        L_0x002c:
            boolean r20 = r42.hasNext()
            r21 = r15
            java.lang.String r15 = "isSponsored"
            r27 = r11
            java.lang.String r11 = "isFavourited"
            r28 = r10
            java.lang.String r10 = "sku"
            r29 = r9
            java.lang.String r9 = "stockAmount"
            r30 = r8
            java.lang.String r8 = "tags"
            r31 = r14
            java.lang.String r14 = "name"
            r32 = r13
            java.lang.String r13 = "imageURLs"
            r33 = r7
            java.lang.String r7 = "mainImageUrl"
            r34 = r6
            java.lang.String r6 = "ageLimit"
            r35 = r12
            java.lang.String r12 = "absoluteDiscount"
            r36 = r5
            java.lang.String r5 = "campaigns"
            r37 = r3
            java.lang.String r3 = "freeQuantity"
            r38 = r2
            java.lang.String r2 = "quantity"
            r39 = r4
            java.lang.String r4 = "price"
            r40 = r4
            java.lang.String r4 = "productId"
            if (r20 == 0) goto L_0x0320
            r20 = r4
            com.squareup.moshi.JsonReader$Options r4 = r0.options
            int r4 = r1.selectName(r4)
            switch(r4) {
                case -1: goto L_0x02fc;
                case 0: goto L_0x02c8;
                case 1: goto L_0x0297;
                case 2: goto L_0x028a;
                case 3: goto L_0x025d;
                case 4: goto L_0x0231;
                case 5: goto L_0x0207;
                case 6: goto L_0x01df;
                case 7: goto L_0x01b9;
                case 8: goto L_0x0195;
                case 9: goto L_0x0173;
                case 10: goto L_0x0168;
                case 11: goto L_0x015c;
                case 12: goto L_0x0143;
                case 13: goto L_0x012a;
                case 14: goto L_0x010a;
                case 15: goto L_0x00f1;
                case 16: goto L_0x00d3;
                case 17: goto L_0x00b7;
                case 18: goto L_0x00ab;
                case 19: goto L_0x009f;
                case 20: goto L_0x0093;
                case 21: goto L_0x0087;
                case 22: goto L_0x007b;
                default: goto L_0x0079;
            }
        L_0x0079:
            goto L_0x0302
        L_0x007b:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r26 = r2
            java.lang.String r26 = (java.lang.String) r26
            goto L_0x0302
        L_0x0087:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.nullableFloatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r25 = r2
            java.lang.Float r25 = (java.lang.Float) r25
            goto L_0x0302
        L_0x0093:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.nullableFloatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r24 = r2
            java.lang.Float r24 = (java.lang.Float) r24
            goto L_0x0302
        L_0x009f:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r23 = r2
            java.lang.String r23 = (java.lang.String) r23
            goto L_0x0302
        L_0x00ab:
            com.squareup.moshi.JsonAdapter<com.talabat.feature.darkstoresflutter.data.model.FlutterTracking> r2 = r0.nullableFlutterTrackingAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r22 = r2
            com.talabat.feature.darkstoresflutter.data.model.FlutterTracking r22 = (com.talabat.feature.darkstoresflutter.data.model.FlutterTracking) r22
            goto L_0x0302
        L_0x00b7:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            if (r10 == 0) goto L_0x00c8
            r15 = r21
            r11 = r27
            goto L_0x0308
        L_0x00c8:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"isSponso…\", \"isSponsored\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00d3:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            if (r9 == 0) goto L_0x00e6
            r15 = r21
            r11 = r27
            r10 = r28
            goto L_0x030a
        L_0x00e6:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"isFavour…, \"isFavourited\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00f1:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r19 = r2
            java.lang.String r19 = (java.lang.String) r19
            if (r19 == 0) goto L_0x00ff
            goto L_0x0302
        L_0x00ff:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"sku\", \"sku\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x010a:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 == 0) goto L_0x011f
            r15 = r21
            r11 = r27
            r10 = r28
            r9 = r29
            goto L_0x030c
        L_0x011f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"stockAmo…   \"stockAmount\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x012a:
            com.squareup.moshi.JsonAdapter<java.util.List<java.lang.String>> r2 = r0.listOfStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r18 = r2
            java.util.List r18 = (java.util.List) r18
            if (r18 == 0) goto L_0x0138
            goto L_0x0302
        L_0x0138:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r8, r8, r1)
            java.lang.String r2 = "unexpectedNull(\"tags\",\n            \"tags\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0143:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r17 = r2
            java.lang.String r17 = (java.lang.String) r17
            if (r17 == 0) goto L_0x0151
            goto L_0x0302
        L_0x0151:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"name\", \"name\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x015c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r2
            java.lang.String r16 = (java.lang.String) r16
            goto L_0x0302
        L_0x0168:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0304
        L_0x0173:
            com.squareup.moshi.JsonAdapter<java.util.List<java.lang.String>> r2 = r0.listOfStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto L_0x018a
            r15 = r21
            r11 = r27
            r10 = r28
            r9 = r29
            r8 = r30
            goto L_0x030e
        L_0x018a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"imageURLs\", \"imageURLs\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0195:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            java.lang.String r13 = (java.lang.String) r13
            if (r13 == 0) goto L_0x01ae
            r15 = r21
            r11 = r27
            r10 = r28
            r9 = r29
            r8 = r30
            r14 = r31
            goto L_0x0310
        L_0x01ae:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"mainImag…, \"mainImageUrl\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01b9:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L_0x01d4
            r15 = r21
            r11 = r27
            r10 = r28
            r9 = r29
            r8 = r30
            r14 = r31
            r13 = r32
            goto L_0x0312
        L_0x01d4:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r6, r1)
            java.lang.String r2 = "unexpectedNull(\"ageLimit…      \"ageLimit\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01df:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.Float r6 = (java.lang.Float) r6
            if (r6 == 0) goto L_0x01fc
            r15 = r21
            r11 = r27
            r10 = r28
            r9 = r29
            r8 = r30
            r14 = r31
            r13 = r32
            r7 = r33
            goto L_0x0314
        L_0x01fc:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"absolute…bsoluteDiscount\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0207:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.feature.darkstoresflutter.data.model.FlutterCampaign>> r2 = r0.listOfFlutterCampaignAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto L_0x0226
            r15 = r21
            r11 = r27
            r10 = r28
            r9 = r29
            r8 = r30
            r14 = r31
            r13 = r32
            r7 = r33
            r6 = r34
            goto L_0x0316
        L_0x0226:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r5, r5, r1)
            java.lang.String r2 = "unexpectedNull(\"campaigns\", \"campaigns\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0231:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0252
            r15 = r21
            r11 = r27
            r10 = r28
            r9 = r29
            r8 = r30
            r14 = r31
            r13 = r32
            r7 = r33
            r6 = r34
            r12 = r35
            goto L_0x0318
        L_0x0252:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"freeQuan…  \"freeQuantity\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x025d:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r3 = r0.intAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x027f
            r15 = r21
            r11 = r27
            r10 = r28
            r9 = r29
            r8 = r30
            r14 = r31
            r13 = r32
            r7 = r33
            r6 = r34
            r12 = r35
            r5 = r36
            goto L_0x031a
        L_0x027f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"quantity…      \"quantity\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x028a:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.nullableFloatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.Float r11 = (java.lang.Float) r11
            r15 = r21
            goto L_0x0306
        L_0x0297:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Float r2 = (java.lang.Float) r2
            if (r2 == 0) goto L_0x02bb
            r15 = r21
            r11 = r27
            r10 = r28
            r9 = r29
            r8 = r30
            r14 = r31
            r13 = r32
            r7 = r33
            r6 = r34
            r12 = r35
            r5 = r36
            r3 = r37
            goto L_0x031c
        L_0x02bb:
            r4 = r40
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r4, r1)
            java.lang.String r2 = "unexpectedNull(\"price\", …ice\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02c8:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x02ef
            r15 = r21
            r11 = r27
            r10 = r28
            r9 = r29
            r8 = r30
            r14 = r31
            r13 = r32
            r7 = r33
            r6 = r34
            r12 = r35
            r5 = r36
            r3 = r37
            r2 = r38
            goto L_0x002c
        L_0x02ef:
            r2 = r20
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"productI…     \"productId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02fc:
            r42.skipName()
            r42.skipValue()
        L_0x0302:
            r15 = r21
        L_0x0304:
            r11 = r27
        L_0x0306:
            r10 = r28
        L_0x0308:
            r9 = r29
        L_0x030a:
            r8 = r30
        L_0x030c:
            r14 = r31
        L_0x030e:
            r13 = r32
        L_0x0310:
            r7 = r33
        L_0x0312:
            r6 = r34
        L_0x0314:
            r12 = r35
        L_0x0316:
            r5 = r36
        L_0x0318:
            r3 = r37
        L_0x031a:
            r2 = r38
        L_0x031c:
            r4 = r39
            goto L_0x002c
        L_0x0320:
            r0 = r4
            r4 = r40
            r42.endObject()
            com.talabat.feature.darkstoresflutter.data.model.FlutterCartItem r40 = new com.talabat.feature.darkstoresflutter.data.model.FlutterCartItem
            if (r39 == 0) goto L_0x0417
            if (r38 == 0) goto L_0x040d
            float r0 = r38.floatValue()
            if (r37 == 0) goto L_0x0403
            int r2 = r37.intValue()
            if (r36 == 0) goto L_0x03f9
            int r20 = r36.intValue()
            if (r35 == 0) goto L_0x03ef
            if (r34 == 0) goto L_0x03e5
            float r12 = r34.floatValue()
            if (r33 == 0) goto L_0x03db
            int r33 = r33.intValue()
            if (r32 == 0) goto L_0x03d1
            if (r31 == 0) goto L_0x03c7
            if (r17 == 0) goto L_0x03bd
            if (r18 == 0) goto L_0x03b3
            if (r30 == 0) goto L_0x03a9
            int r30 = r30.intValue()
            if (r19 == 0) goto L_0x039f
            if (r29 == 0) goto L_0x0395
            boolean r29 = r29.booleanValue()
            if (r28 == 0) goto L_0x038b
            boolean r1 = r28.booleanValue()
            r3 = r40
            r4 = r39
            r5 = r0
            r6 = r27
            r7 = r2
            r8 = r20
            r9 = r35
            r10 = r12
            r11 = r33
            r12 = r32
            r13 = r31
            r14 = r21
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r30
            r20 = r29
            r21 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return r40
        L_0x038b:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r1 = "missingProperty(\"isSpons…red\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0395:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r1 = "missingProperty(\"isFavou…ted\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x039f:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r1 = "missingProperty(\"sku\", \"sku\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03a9:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r9, r9, r1)
            java.lang.String r1 = "missingProperty(\"stockAm…unt\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03b3:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r8, r8, r1)
            java.lang.String r1 = "missingProperty(\"tags\", \"tags\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03bd:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r14, r14, r1)
            java.lang.String r1 = "missingProperty(\"name\", \"name\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03c7:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r1 = "missingProperty(\"imageURLs\", \"imageURLs\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03d1:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r1 = "missingProperty(\"mainIma…Url\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03db:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r1 = "missingProperty(\"ageLimit\", \"ageLimit\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03e5:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r1 = "missingProperty(\"absolut…bsoluteDiscount\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03ef:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r5, r5, r1)
            java.lang.String r1 = "missingProperty(\"campaigns\", \"campaigns\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x03f9:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r3, r3, r1)
            java.lang.String r1 = "missingProperty(\"freeQua…ity\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0403:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r1 = "missingProperty(\"quantity\", \"quantity\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x040d:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r4, r4, r1)
            java.lang.String r1 = "missingProperty(\"price\", \"price\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0417:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r0, r1)
            java.lang.String r1 = "missingProperty(\"productId\", \"productId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstoresflutter.data.model.FlutterCartItemJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.feature.darkstoresflutter.data.model.FlutterCartItem");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable FlutterCartItem flutterCartItem) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (flutterCartItem != null) {
            jsonWriter.beginObject();
            jsonWriter.name("productId");
            this.stringAdapter.toJson(jsonWriter, flutterCartItem.getProductId());
            jsonWriter.name(FirebaseAnalytics.Param.PRICE);
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(flutterCartItem.getPrice()));
            jsonWriter.name("oldPrice");
            this.nullableFloatAdapter.toJson(jsonWriter, flutterCartItem.getOldPrice());
            jsonWriter.name(FirebaseAnalytics.Param.QUANTITY);
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(flutterCartItem.getQuantity()));
            jsonWriter.name("freeQuantity");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(flutterCartItem.getFreeQuantity()));
            jsonWriter.name("campaigns");
            this.listOfFlutterCampaignAdapter.toJson(jsonWriter, flutterCartItem.getCampaigns());
            jsonWriter.name("absoluteDiscount");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(flutterCartItem.getAbsoluteDiscount()));
            jsonWriter.name("ageLimit");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(flutterCartItem.getAgeLimit()));
            jsonWriter.name("mainImageUrl");
            this.stringAdapter.toJson(jsonWriter, flutterCartItem.getMainImageUrl());
            jsonWriter.name("imageURLs");
            this.listOfStringAdapter.toJson(jsonWriter, flutterCartItem.getImageURLs());
            jsonWriter.name("categoryId");
            this.nullableStringAdapter.toJson(jsonWriter, flutterCartItem.getCategoryId());
            jsonWriter.name("itemDescription");
            this.nullableStringAdapter.toJson(jsonWriter, flutterCartItem.getItemDescription());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, flutterCartItem.getName());
            jsonWriter.name("tags");
            this.listOfStringAdapter.toJson(jsonWriter, flutterCartItem.getTags());
            jsonWriter.name("stockAmount");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(flutterCartItem.getStockAmount()));
            jsonWriter.name("sku");
            this.stringAdapter.toJson(jsonWriter, flutterCartItem.getSku());
            jsonWriter.name("isFavourited");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(flutterCartItem.isFavourited()));
            jsonWriter.name("isSponsored");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(flutterCartItem.isSponsored()));
            jsonWriter.name("tracking");
            this.nullableFlutterTrackingAdapter.toJson(jsonWriter, flutterCartItem.getTracking());
            jsonWriter.name("offerText");
            this.nullableStringAdapter.toJson(jsonWriter, flutterCartItem.getOfferText());
            jsonWriter.name("subtotal");
            this.nullableFloatAdapter.toJson(jsonWriter, flutterCartItem.getSubtotal());
            jsonWriter.name(PurchaseInfo.TOTAL);
            this.nullableFloatAdapter.toJson(jsonWriter, flutterCartItem.getTotal());
            jsonWriter.name("tooltipAlertText");
            this.nullableStringAdapter.toJson(jsonWriter, flutterCartItem.getTooltipAlertText());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
