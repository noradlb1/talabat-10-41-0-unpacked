package com.talabat.feature.darkstoresflutter.data.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010#\u001a\u00020\u001aH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCartJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCart;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "floatAdapter", "", "flutterPriceSummaryAdapter", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterPriceSummary;", "listOfFlutterCampaignAdapter", "", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaign;", "listOfFlutterCartItemAdapter", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCartItem;", "nullableFlutterCampaignProgressWrapperAdapter", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgressWrapper;", "nullableListOfFlutterFeeDescriptionAdapter", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterFeeDescription;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCartJsonAdapter extends JsonAdapter<FlutterCart> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @Nullable
    private volatile Constructor<FlutterCart> constructorRef;
    @NotNull
    private final JsonAdapter<Float> floatAdapter;
    @NotNull
    private final JsonAdapter<FlutterPriceSummary> flutterPriceSummaryAdapter;
    @NotNull
    private final JsonAdapter<List<FlutterCampaign>> listOfFlutterCampaignAdapter;
    @NotNull
    private final JsonAdapter<List<FlutterCartItem>> listOfFlutterCartItemAdapter;
    @NotNull
    private final JsonAdapter<FlutterCampaignProgressWrapper> nullableFlutterCampaignProgressWrapperAdapter;
    @NotNull
    private final JsonAdapter<List<FlutterFeeDescription>> nullableListOfFlutterFeeDescriptionAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public FlutterCartJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("cartIdentifier", "vendorId", TProChannelCallbackImpl.MINIMUM_ORDER_VALUE_KEY, FirebaseAnalytics.Param.ITEMS, "priceSummary", "campaigns", "feeDescriptions", "isCartUploadInProgress", "campaignProgress");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"cartIdentifier\", \"ve…ess\", \"campaignProgress\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(),\n      \"cartId\")");
        this.stringAdapter = adapter;
        JsonAdapter<Float> adapter2 = moshi.adapter(Float.TYPE, SetsKt__SetsKt.emptySet(), TProChannelCallbackImpl.MINIMUM_ORDER_VALUE_KEY);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Float::cla…     \"minimumOrderValue\")");
        this.floatAdapter = adapter2;
        Class<List> cls = List.class;
        JsonAdapter<List<FlutterCartItem>> adapter3 = moshi.adapter(Types.newParameterizedType(cls, FlutterCartItem.class), SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…     emptySet(), \"items\")");
        this.listOfFlutterCartItemAdapter = adapter3;
        JsonAdapter<FlutterPriceSummary> adapter4 = moshi.adapter(FlutterPriceSummary.class, SetsKt__SetsKt.emptySet(), "priceSummary");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(FlutterPri…ptySet(), \"priceSummary\")");
        this.flutterPriceSummaryAdapter = adapter4;
        JsonAdapter<List<FlutterCampaign>> adapter5 = moshi.adapter(Types.newParameterizedType(cls, FlutterCampaign.class), SetsKt__SetsKt.emptySet(), "campaigns");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP… emptySet(), \"campaigns\")");
        this.listOfFlutterCampaignAdapter = adapter5;
        JsonAdapter<List<FlutterFeeDescription>> adapter6 = moshi.adapter(Types.newParameterizedType(cls, FlutterFeeDescription.class), SetsKt__SetsKt.emptySet(), "feeDescriptions");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Types.newP…Set(), \"feeDescriptions\")");
        this.nullableListOfFlutterFeeDescriptionAdapter = adapter6;
        JsonAdapter<Boolean> adapter7 = moshi.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "isCartUploadInProgress");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Boolean::c…\"isCartUploadInProgress\")");
        this.booleanAdapter = adapter7;
        JsonAdapter<FlutterCampaignProgressWrapper> adapter8 = moshi.adapter(FlutterCampaignProgressWrapper.class, SetsKt__SetsKt.emptySet(), "campaignProgress");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(FlutterCam…et(), \"campaignProgress\")");
        this.nullableFlutterCampaignProgressWrapperAdapter = adapter8;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FlutterCart");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010d, code lost:
        r13 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010f, code lost:
        r11 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0111, code lost:
        r7 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0113, code lost:
        r10 = r19;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.darkstoresflutter.data.model.FlutterCart fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r34) {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r34.beginObject()
            r3 = -1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
        L_0x0016:
            boolean r12 = r34.hasNext()
            java.lang.String r14 = "cartIdentifier"
            java.lang.String r15 = "cartId"
            java.lang.String r2 = "isCartUploadInProgress"
            r16 = r13
            java.lang.String r13 = "campaigns"
            r17 = r11
            java.lang.String r11 = "priceSummary"
            r18 = r7
            java.lang.String r7 = "minimumOrderValue"
            r19 = r10
            java.lang.String r10 = "vendorId"
            if (r12 == 0) goto L_0x0117
            com.squareup.moshi.JsonReader$Options r12 = r0.options
            int r12 = r1.selectName(r12)
            switch(r12) {
                case -1: goto L_0x0107;
                case 0: goto L_0x00f0;
                case 1: goto L_0x00d9;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00a5;
                case 4: goto L_0x008e;
                case 5: goto L_0x0071;
                case 6: goto L_0x0064;
                case 7: goto L_0x0049;
                case 8: goto L_0x003e;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x010d
        L_0x003e:
            com.squareup.moshi.JsonAdapter<com.talabat.feature.darkstoresflutter.data.model.FlutterCampaignProgressWrapper> r2 = r0.nullableFlutterCampaignProgressWrapperAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            com.talabat.feature.darkstoresflutter.data.model.FlutterCampaignProgressWrapper r13 = (com.talabat.feature.darkstoresflutter.data.model.FlutterCampaignProgressWrapper) r13
            goto L_0x010f
        L_0x0049:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r7 = r0.booleanAdapter
            java.lang.Object r7 = r7.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            if (r7 == 0) goto L_0x0059
            r13 = r16
            r11 = r17
            goto L_0x0113
        L_0x0059:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"isCartUp…ploadInProgress\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0064:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.feature.darkstoresflutter.data.model.FlutterFeeDescription>> r2 = r0.nullableListOfFlutterFeeDescriptionAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.util.List r11 = (java.util.List) r11
            r13 = r16
            goto L_0x0111
        L_0x0071:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.feature.darkstoresflutter.data.model.FlutterCampaign>> r2 = r0.listOfFlutterCampaignAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.util.List r10 = (java.util.List) r10
            if (r10 == 0) goto L_0x0083
            r13 = r16
            r11 = r17
            r7 = r18
            goto L_0x0016
        L_0x0083:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"campaigns\", \"campaigns\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x008e:
            com.squareup.moshi.JsonAdapter<com.talabat.feature.darkstoresflutter.data.model.FlutterPriceSummary> r2 = r0.flutterPriceSummaryAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            com.talabat.feature.darkstoresflutter.data.model.FlutterPriceSummary r9 = (com.talabat.feature.darkstoresflutter.data.model.FlutterPriceSummary) r9
            if (r9 == 0) goto L_0x009a
            goto L_0x010d
        L_0x009a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"priceSum…, \"priceSummary\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00a5:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.feature.darkstoresflutter.data.model.FlutterCartItem>> r2 = r0.listOfFlutterCartItemAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L_0x00b3
            r3 = r3 & -9
            goto L_0x010d
        L_0x00b3:
            java.lang.String r2 = "items"
            java.lang.String r3 = "items"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"items\", \"items\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00c2:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.Float r4 = (java.lang.Float) r4
            if (r4 == 0) goto L_0x00ce
            goto L_0x010d
        L_0x00ce:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"minimumO…nimumOrderValue\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00d9:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x00e5
            goto L_0x010d
        L_0x00e5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"vendorId…      \"vendorId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00f0:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x00fc
            goto L_0x010d
        L_0x00fc:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"cartId\",…\"cartIdentifier\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0107:
            r34.skipName()
            r34.skipValue()
        L_0x010d:
            r13 = r16
        L_0x010f:
            r11 = r17
        L_0x0111:
            r7 = r18
        L_0x0113:
            r10 = r19
            goto L_0x0016
        L_0x0117:
            r34.endObject()
            r12 = -9
            if (r3 != r12) goto L_0x0185
            com.talabat.feature.darkstoresflutter.data.model.FlutterCart r3 = new com.talabat.feature.darkstoresflutter.data.model.FlutterCart
            if (r5 == 0) goto L_0x017b
            if (r6 == 0) goto L_0x0171
            if (r4 == 0) goto L_0x0167
            float r7 = r4.floatValue()
            if (r8 == 0) goto L_0x015f
            if (r9 == 0) goto L_0x0155
            if (r19 == 0) goto L_0x014b
            if (r18 == 0) goto L_0x0141
            boolean r12 = r18.booleanValue()
            r4 = r3
            r10 = r19
            r11 = r17
            r13 = r16
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r3
        L_0x0141:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r2 = "missingProperty(\"isCartU…s\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x014b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r2 = "missingProperty(\"campaigns\", \"campaigns\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0155:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r2 = "missingProperty(\"priceSu…y\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x015f:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<com.talabat.feature.darkstoresflutter.data.model.FlutterCartItem>"
            r1.<init>(r2)
            throw r1
        L_0x0167:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r2 = "missingProperty(\"minimum…nimumOrderValue\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0171:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"vendorId\", \"vendorId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x017b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r14, r1)
            java.lang.String r2 = "missingProperty(\"cartId\"…\"cartIdentifier\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0185:
            java.lang.reflect.Constructor<com.talabat.feature.darkstoresflutter.data.model.FlutterCart> r12 = r0.constructorRef
            r20 = 9
            r21 = 8
            r22 = 7
            r23 = 6
            r24 = 5
            r25 = 4
            r26 = 3
            r27 = 2
            r28 = 1
            r29 = 0
            r30 = r14
            r14 = 11
            if (r12 != 0) goto L_0x01da
            java.lang.Class[] r12 = new java.lang.Class[r14]
            java.lang.Class<java.lang.String> r31 = java.lang.String.class
            r12[r29] = r31
            r12[r28] = r31
            java.lang.Class r31 = java.lang.Float.TYPE
            r12[r27] = r31
            java.lang.Class<java.util.List> r31 = java.util.List.class
            r12[r26] = r31
            java.lang.Class<com.talabat.feature.darkstoresflutter.data.model.FlutterPriceSummary> r32 = com.talabat.feature.darkstoresflutter.data.model.FlutterPriceSummary.class
            r12[r25] = r32
            r12[r24] = r31
            r12[r23] = r31
            java.lang.Class r31 = java.lang.Boolean.TYPE
            r12[r22] = r31
            java.lang.Class<com.talabat.feature.darkstoresflutter.data.model.FlutterCampaignProgressWrapper> r31 = com.talabat.feature.darkstoresflutter.data.model.FlutterCampaignProgressWrapper.class
            r12[r21] = r31
            java.lang.Class r31 = java.lang.Integer.TYPE
            r12[r20] = r31
            r31 = 10
            java.lang.Class<?> r32 = com.squareup.moshi.internal.Util.DEFAULT_CONSTRUCTOR_MARKER
            r12[r31] = r32
            java.lang.Class<com.talabat.feature.darkstoresflutter.data.model.FlutterCart> r14 = com.talabat.feature.darkstoresflutter.data.model.FlutterCart.class
            java.lang.reflect.Constructor r12 = r14.getDeclaredConstructor(r12)
            r0.constructorRef = r12
            java.lang.String r14 = "FlutterCart::class.java.…his.constructorRef = it }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r14)
            r14 = 11
        L_0x01da:
            java.lang.Object[] r14 = new java.lang.Object[r14]
            if (r5 == 0) goto L_0x0253
            r14[r29] = r5
            if (r6 == 0) goto L_0x0249
            r14[r28] = r6
            if (r4 == 0) goto L_0x023f
            float r4 = r4.floatValue()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r14[r27] = r4
            r14[r26] = r8
            if (r9 == 0) goto L_0x0235
            r14[r25] = r9
            if (r19 == 0) goto L_0x022b
            r14[r24] = r19
            r14[r23] = r17
            if (r18 == 0) goto L_0x0221
            boolean r1 = r18.booleanValue()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r14[r22] = r1
            r14[r21] = r16
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r14[r20] = r1
            r1 = 10
            r2 = 0
            r14[r1] = r2
            java.lang.Object r1 = r12.newInstance(r14)
            java.lang.String r2 = "localConstructor.newInst…torMarker */ null\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.talabat.feature.darkstoresflutter.data.model.FlutterCart r1 = (com.talabat.feature.darkstoresflutter.data.model.FlutterCart) r1
            return r1
        L_0x0221:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r2 = "missingProperty(\"isCartU…ploadInProgress\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x022b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r2 = "missingProperty(\"campaigns\", \"campaigns\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0235:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r2 = "missingProperty(\"priceSu…, \"priceSummary\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x023f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r2 = "missingProperty(\"minimum…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0249:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"vendorId\", \"vendorId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0253:
            r2 = r30
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r2, r1)
            java.lang.String r2 = "missingProperty(\"cartId\"…\"cartIdentifier\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstoresflutter.data.model.FlutterCartJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.feature.darkstoresflutter.data.model.FlutterCart");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable FlutterCart flutterCart) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (flutterCart != null) {
            jsonWriter.beginObject();
            jsonWriter.name("cartIdentifier");
            this.stringAdapter.toJson(jsonWriter, flutterCart.getCartId());
            jsonWriter.name("vendorId");
            this.stringAdapter.toJson(jsonWriter, flutterCart.getVendorId());
            jsonWriter.name(TProChannelCallbackImpl.MINIMUM_ORDER_VALUE_KEY);
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(flutterCart.getMinimumOrderValue()));
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.listOfFlutterCartItemAdapter.toJson(jsonWriter, flutterCart.getItems());
            jsonWriter.name("priceSummary");
            this.flutterPriceSummaryAdapter.toJson(jsonWriter, flutterCart.getPriceSummary());
            jsonWriter.name("campaigns");
            this.listOfFlutterCampaignAdapter.toJson(jsonWriter, flutterCart.getCampaigns());
            jsonWriter.name("feeDescriptions");
            this.nullableListOfFlutterFeeDescriptionAdapter.toJson(jsonWriter, flutterCart.getFeeDescriptions());
            jsonWriter.name("isCartUploadInProgress");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(flutterCart.isCartUploadInProgress()));
            jsonWriter.name("campaignProgress");
            this.nullableFlutterCampaignProgressWrapperAdapter.toJson(jsonWriter, flutterCart.getCampaignProgress());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
