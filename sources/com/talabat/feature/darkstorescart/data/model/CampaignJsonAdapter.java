package com.talabat.feature.darkstorescart.data.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/CampaignJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "campaignTypeAdapter", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;", "constructorRef", "Ljava/lang/reflect/Constructor;", "floatAdapter", "", "nullableBooleanAdapter", "", "nullableFloatAdapter", "nullableIntAdapter", "", "nullableListOfBenefitAdapter", "", "Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "nullableListOfProductTriggerAdapter", "Lcom/talabat/feature/darkstorescart/data/model/ProductTrigger;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "typeAdapter", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignJsonAdapter extends JsonAdapter<Campaign> {
    @NotNull
    private final JsonAdapter<Campaign.CampaignType> campaignTypeAdapter;
    @Nullable
    private volatile Constructor<Campaign> constructorRef;
    @NotNull
    private final JsonAdapter<Float> floatAdapter;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<Float> nullableFloatAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<List<Benefit>> nullableListOfBenefitAdapter;
    @NotNull
    private final JsonAdapter<List<ProductTrigger>> nullableListOfProductTriggerAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;
    @NotNull
    private final JsonAdapter<Campaign.Type> typeAdapter;

    public CampaignJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("global_id", "name", "description", "total_trigger_threshold", "campaign_applies_to", "discount_type", "discount_value", "campaign_type", "product_triggers", TproBenefitsViewModel.TPRO_BENEFITS_SCREEN_TYPE, "cart_item_usage_limit", "campaign_is_auto_addable");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"global_id\", \"name\",\n…ampaign_is_auto_addable\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "globalId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ySet(),\n      \"globalId\")");
        this.stringAdapter = adapter;
        JsonAdapter<Float> adapter2 = moshi.adapter(Float.class, SetsKt__SetsKt.emptySet(), "totalTriggerThreshold");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Float::cla… \"totalTriggerThreshold\")");
        this.nullableFloatAdapter = adapter2;
        JsonAdapter<Campaign.Type> adapter3 = moshi.adapter(Campaign.Type.class, SetsKt__SetsKt.emptySet(), "discountType");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Campaign.T…ptySet(), \"discountType\")");
        this.typeAdapter = adapter3;
        JsonAdapter<Float> adapter4 = moshi.adapter(Float.TYPE, SetsKt__SetsKt.emptySet(), "discountValue");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Float::cla…),\n      \"discountValue\")");
        this.floatAdapter = adapter4;
        JsonAdapter<Campaign.CampaignType> adapter5 = moshi.adapter(Campaign.CampaignType.class, SetsKt__SetsKt.emptySet(), "campaignType");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Campaign.C…ptySet(), \"campaignType\")");
        this.campaignTypeAdapter = adapter5;
        Class<List> cls = List.class;
        JsonAdapter<List<ProductTrigger>> adapter6 = moshi.adapter(Types.newParameterizedType(cls, ProductTrigger.class), SetsKt__SetsKt.emptySet(), "productTriggers");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Types.newP…Set(), \"productTriggers\")");
        this.nullableListOfProductTriggerAdapter = adapter6;
        JsonAdapter<List<Benefit>> adapter7 = moshi.adapter(Types.newParameterizedType(cls, Benefit.class), SetsKt__SetsKt.emptySet(), TproBenefitsViewModel.TPRO_BENEFITS_SCREEN_TYPE);
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Types.newP…ySet(),\n      \"benefits\")");
        this.nullableListOfBenefitAdapter = adapter7;
        JsonAdapter<Integer> adapter8 = moshi.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "usageLimit");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Int::class…emptySet(), \"usageLimit\")");
        this.nullableIntAdapter = adapter8;
        JsonAdapter<Boolean> adapter9 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "isAutoAddable");
        Intrinsics.checkNotNullExpressionValue(adapter9, "moshi.adapter(Boolean::c…tySet(), \"isAutoAddable\")");
        this.nullableBooleanAdapter = adapter9;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Campaign");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0185, code lost:
        r15 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0187, code lost:
        r14 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0189, code lost:
        r13 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x018b, code lost:
        r8 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x018d, code lost:
        r12 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x018f, code lost:
        r4 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0191, code lost:
        r10 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0193, code lost:
        r9 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0195, code lost:
        r7 = r25;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.darkstorescart.data.model.Campaign fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r39) {
        /*
            r38 = this;
            r0 = r38
            r1 = r39
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r39.beginObject()
            r3 = -1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x001a:
            boolean r11 = r39.hasNext()
            java.lang.String r2 = "discount_value"
            r17 = r15
            java.lang.String r15 = "discountValue"
            r18 = r14
            java.lang.String r14 = "discount_type"
            r19 = r13
            java.lang.String r13 = "discountType"
            r20 = r8
            java.lang.String r8 = "campaign_applies_to"
            r21 = r12
            java.lang.String r12 = "appliesTo"
            r22 = r4
            java.lang.String r4 = "global_id"
            r23 = r10
            java.lang.String r10 = "globalId"
            r24 = r9
            java.lang.String r9 = "description"
            r25 = r7
            java.lang.String r7 = "name"
            if (r11 == 0) goto L_0x0199
            com.squareup.moshi.JsonReader$Options r11 = r0.options
            int r11 = r1.selectName(r11)
            switch(r11) {
                case -1: goto L_0x017f;
                case 0: goto L_0x0168;
                case 1: goto L_0x0151;
                case 2: goto L_0x0129;
                case 3: goto L_0x0119;
                case 4: goto L_0x00f3;
                case 5: goto L_0x00cf;
                case 6: goto L_0x00ae;
                case 7: goto L_0x0088;
                case 8: goto L_0x0079;
                case 9: goto L_0x006c;
                case 10: goto L_0x005f;
                case 11: goto L_0x0051;
                default: goto L_0x004f;
            }
        L_0x004f:
            goto L_0x0185
        L_0x0051:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.nullableBooleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r2
            java.lang.Boolean r16 = (java.lang.Boolean) r16
            r3 = r3 & -2049(0xfffffffffffff7ff, float:NaN)
            goto L_0x0185
        L_0x005f:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.nullableIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.lang.Integer r15 = (java.lang.Integer) r15
            r3 = r3 & -1025(0xfffffffffffffbff, float:NaN)
            goto L_0x0187
        L_0x006c:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.feature.darkstorescart.data.model.Benefit>> r2 = r0.nullableListOfBenefitAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            java.util.List r14 = (java.util.List) r14
            r15 = r17
            goto L_0x0189
        L_0x0079:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.feature.darkstorescart.data.model.ProductTrigger>> r2 = r0.nullableListOfProductTriggerAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            java.util.List r13 = (java.util.List) r13
            r15 = r17
            r14 = r18
            goto L_0x018b
        L_0x0088:
            com.squareup.moshi.JsonAdapter<com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType> r2 = r0.campaignTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType r12 = (com.talabat.feature.darkstorescart.data.model.Campaign.CampaignType) r12
            if (r12 == 0) goto L_0x009f
            r3 = r3 & -129(0xffffffffffffff7f, float:NaN)
            r15 = r17
            r14 = r18
            r13 = r19
            r8 = r20
            goto L_0x018f
        L_0x009f:
            java.lang.String r2 = "campaignType"
            java.lang.String r3 = "campaign_type"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"campaign… \"campaign_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00ae:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r4 = r0.floatAdapter
            java.lang.Object r4 = r4.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Float r4 = (java.lang.Float) r4
            if (r4 == 0) goto L_0x00c4
            r15 = r17
            r14 = r18
            r13 = r19
            r8 = r20
            r12 = r21
            goto L_0x0191
        L_0x00c4:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"discount…\"discount_value\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00cf:
            com.squareup.moshi.JsonAdapter<com.talabat.feature.darkstorescart.data.model.Campaign$Type> r2 = r0.typeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            com.talabat.feature.darkstorescart.data.model.Campaign$Type r10 = (com.talabat.feature.darkstorescart.data.model.Campaign.Type) r10
            if (r10 == 0) goto L_0x00e8
            r15 = r17
            r14 = r18
            r13 = r19
            r8 = r20
            r12 = r21
            r4 = r22
            goto L_0x0193
        L_0x00e8:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"discount… \"discount_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00f3:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x010e
            r15 = r17
            r14 = r18
            r13 = r19
            r8 = r20
            r12 = r21
            r4 = r22
            r10 = r23
            goto L_0x0195
        L_0x010e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r8, r1)
            java.lang.String r2 = "unexpectedNull(\"appliesT…aign_applies_to\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0119:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.nullableFloatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.Float r8 = (java.lang.Float) r8
            r15 = r17
            r14 = r18
            r13 = r19
            goto L_0x018d
        L_0x0129:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0146
            r15 = r17
            r14 = r18
            r13 = r19
            r8 = r20
            r12 = r21
            r4 = r22
            r10 = r23
            r9 = r24
            goto L_0x001a
        L_0x0146:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"descript…\", \"description\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0151:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x015d
            goto L_0x0185
        L_0x015d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"name\", \"name\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0168:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0174
            goto L_0x0185
        L_0x0174:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r4, r1)
            java.lang.String r2 = "unexpectedNull(\"globalId…     \"global_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x017f:
            r39.skipName()
            r39.skipValue()
        L_0x0185:
            r15 = r17
        L_0x0187:
            r14 = r18
        L_0x0189:
            r13 = r19
        L_0x018b:
            r8 = r20
        L_0x018d:
            r12 = r21
        L_0x018f:
            r4 = r22
        L_0x0191:
            r10 = r23
        L_0x0193:
            r9 = r24
        L_0x0195:
            r7 = r25
            goto L_0x001a
        L_0x0199:
            r39.endObject()
            r11 = -3201(0xfffffffffffff37f, float:NaN)
            if (r3 != r11) goto L_0x020d
            com.talabat.feature.darkstorescart.data.model.Campaign r3 = new com.talabat.feature.darkstorescart.data.model.Campaign
            if (r5 == 0) goto L_0x0203
            if (r6 == 0) goto L_0x01f9
            if (r25 == 0) goto L_0x01ef
            if (r24 == 0) goto L_0x01e5
            if (r23 == 0) goto L_0x01db
            if (r22 == 0) goto L_0x01d1
            float r11 = r22.floatValue()
            if (r21 == 0) goto L_0x01c9
            r4 = r3
            r7 = r25
            r8 = r20
            r9 = r24
            r10 = r23
            r12 = r21
            r13 = r19
            r14 = r18
            r15 = r17
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r3
        L_0x01c9:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type com.talabat.feature.darkstorescart.data.model.Campaign.CampaignType"
            r1.<init>(r2)
            throw r1
        L_0x01d1:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r2, r1)
            java.lang.String r2 = "missingProperty(\"discoun…\"discount_value\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01db:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r14, r1)
            java.lang.String r2 = "missingProperty(\"discoun…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01e5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r8, r1)
            java.lang.String r2 = "missingProperty(\"applies…o\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01ef:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r9, r1)
            java.lang.String r2 = "missingProperty(\"descrip…n\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01f9:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r2 = "missingProperty(\"name\", \"name\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0203:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r4, r1)
            java.lang.String r2 = "missingProperty(\"globalId\", \"global_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x020d:
            java.lang.reflect.Constructor<com.talabat.feature.darkstorescart.data.model.Campaign> r11 = r0.constructorRef
            r26 = 8
            r27 = 7
            r28 = 6
            r29 = 5
            r30 = 4
            r31 = 3
            r32 = 2
            r33 = 1
            r34 = 0
            r35 = r4
            r4 = 14
            if (r11 != 0) goto L_0x0274
            java.lang.Class[] r11 = new java.lang.Class[r4]
            java.lang.Class<java.lang.String> r36 = java.lang.String.class
            r11[r34] = r36
            r11[r33] = r36
            r11[r32] = r36
            java.lang.Class<java.lang.Float> r37 = java.lang.Float.class
            r11[r31] = r37
            r11[r30] = r36
            java.lang.Class<com.talabat.feature.darkstorescart.data.model.Campaign$Type> r36 = com.talabat.feature.darkstorescart.data.model.Campaign.Type.class
            r11[r29] = r36
            java.lang.Class r36 = java.lang.Float.TYPE
            r11[r28] = r36
            java.lang.Class<com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType> r36 = com.talabat.feature.darkstorescart.data.model.Campaign.CampaignType.class
            r11[r27] = r36
            java.lang.Class<java.util.List> r36 = java.util.List.class
            r11[r26] = r36
            r36 = 9
            java.lang.Class<java.util.List> r37 = java.util.List.class
            r11[r36] = r37
            r36 = 10
            java.lang.Class<java.lang.Integer> r37 = java.lang.Integer.class
            r11[r36] = r37
            r36 = 11
            java.lang.Class<java.lang.Boolean> r37 = java.lang.Boolean.class
            r11[r36] = r37
            r36 = 12
            java.lang.Class r37 = java.lang.Integer.TYPE
            r11[r36] = r37
            r36 = 13
            java.lang.Class<?> r37 = com.squareup.moshi.internal.Util.DEFAULT_CONSTRUCTOR_MARKER
            r11[r36] = r37
            java.lang.Class<com.talabat.feature.darkstorescart.data.model.Campaign> r4 = com.talabat.feature.darkstorescart.data.model.Campaign.class
            java.lang.reflect.Constructor r11 = r4.getDeclaredConstructor(r11)
            r0.constructorRef = r11
            java.lang.String r4 = "Campaign::class.java.get…his.constructorRef = it }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)
            r4 = 14
        L_0x0274:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            if (r5 == 0) goto L_0x02f3
            r4[r34] = r5
            if (r6 == 0) goto L_0x02e9
            r4[r33] = r6
            if (r25 == 0) goto L_0x02df
            r4[r32] = r25
            r4[r31] = r20
            if (r24 == 0) goto L_0x02d5
            r4[r30] = r24
            if (r23 == 0) goto L_0x02cb
            r4[r29] = r23
            if (r22 == 0) goto L_0x02c1
            float r1 = r22.floatValue()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r4[r28] = r1
            r4[r27] = r21
            r4[r26] = r19
            r1 = 9
            r4[r1] = r18
            r1 = 10
            r4[r1] = r17
            r1 = 11
            r4[r1] = r16
            r1 = 12
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r4[r1] = r2
            r1 = 13
            r2 = 0
            r4[r1] = r2
            java.lang.Object r1 = r11.newInstance(r4)
            java.lang.String r2 = "localConstructor.newInst…torMarker */ null\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.talabat.feature.darkstorescart.data.model.Campaign r1 = (com.talabat.feature.darkstorescart.data.model.Campaign) r1
            return r1
        L_0x02c1:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r2, r1)
            java.lang.String r2 = "missingProperty(\"discoun…\"discount_value\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02cb:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r14, r1)
            java.lang.String r2 = "missingProperty(\"discoun… \"discount_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02d5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r8, r1)
            java.lang.String r2 = "missingProperty(\"applies…aign_applies_to\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02df:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r9, r1)
            java.lang.String r2 = "missingProperty(\"descrip…\", \"description\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02e9:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r2 = "missingProperty(\"name\", \"name\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02f3:
            r2 = r35
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r2, r1)
            java.lang.String r2 = "missingProperty(\"globalId\", \"global_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstorescart.data.model.CampaignJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.feature.darkstorescart.data.model.Campaign");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Campaign campaign) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (campaign != null) {
            jsonWriter.beginObject();
            jsonWriter.name("global_id");
            this.stringAdapter.toJson(jsonWriter, campaign.getGlobalId());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, campaign.getName());
            jsonWriter.name("description");
            this.stringAdapter.toJson(jsonWriter, campaign.getDescription());
            jsonWriter.name("total_trigger_threshold");
            this.nullableFloatAdapter.toJson(jsonWriter, campaign.getTotalTriggerThreshold());
            jsonWriter.name("campaign_applies_to");
            this.stringAdapter.toJson(jsonWriter, campaign.getAppliesTo());
            jsonWriter.name("discount_type");
            this.typeAdapter.toJson(jsonWriter, campaign.getDiscountType());
            jsonWriter.name("discount_value");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(campaign.getDiscountValue()));
            jsonWriter.name("campaign_type");
            this.campaignTypeAdapter.toJson(jsonWriter, campaign.getCampaignType());
            jsonWriter.name("product_triggers");
            this.nullableListOfProductTriggerAdapter.toJson(jsonWriter, campaign.getProductTriggers());
            jsonWriter.name(TproBenefitsViewModel.TPRO_BENEFITS_SCREEN_TYPE);
            this.nullableListOfBenefitAdapter.toJson(jsonWriter, campaign.getBenefits());
            jsonWriter.name("cart_item_usage_limit");
            this.nullableIntAdapter.toJson(jsonWriter, campaign.getUsageLimit());
            jsonWriter.name("campaign_is_auto_addable");
            this.nullableBooleanAdapter.toJson(jsonWriter, campaign.isAutoAddable());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
