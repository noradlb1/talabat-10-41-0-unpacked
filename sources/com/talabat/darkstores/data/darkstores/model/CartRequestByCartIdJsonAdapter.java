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

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/model/CartRequestByCartIdJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/darkstores/model/CartRequestByCartId;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "floatAdapter", "", "intAdapter", "", "listOfCartProductAdapter", "", "Lcom/talabat/darkstores/data/darkstores/model/CartProduct;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "targetAudienceTypeAdapter", "Lcom/talabat/darkstores/model/TargetAudienceType;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartRequestByCartIdJsonAdapter extends JsonAdapter<CartRequestByCartId> {
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

    public CartRequestByCartIdJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(FirebaseAnalytics.Param.ITEMS, "vendor_id", "target_audience", "global_entity_id", "delivery_fee", "minimum_order_value", "chain_id");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"items\", \"vendor_id\",…order_value\", \"chain_id\")");
        this.options = of2;
        JsonAdapter<List<CartProduct>> adapter = moshi.adapter(Types.newParameterizedType(List.class, CartProduct.class), SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…     emptySet(), \"items\")");
        this.listOfCartProductAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "vendorId");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…ySet(),\n      \"vendorId\")");
        this.stringAdapter = adapter2;
        JsonAdapter<TargetAudienceType> adapter3 = moshi.adapter(TargetAudienceType.class, SetsKt__SetsKt.emptySet(), "targetAudience");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(TargetAudi…ySet(), \"targetAudience\")");
        this.targetAudienceTypeAdapter = adapter3;
        JsonAdapter<Float> adapter4 = moshi.adapter(Float.TYPE, SetsKt__SetsKt.emptySet(), "deliveryFee");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Float::cla…t(),\n      \"deliveryFee\")");
        this.floatAdapter = adapter4;
        JsonAdapter<Integer> adapter5 = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "chainId");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Int::class…a, emptySet(), \"chainId\")");
        this.intAdapter = adapter5;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CartRequestByCartId");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0125, code lost:
        r5 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0127, code lost:
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0129, code lost:
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x012b, code lost:
        r8 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012d, code lost:
        r7 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012f, code lost:
        r6 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0131, code lost:
        r4 = r22;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.darkstores.data.darkstores.model.CartRequestByCartId fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r25.beginObject()
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
        L_0x0013:
            boolean r9 = r25.hasNext()
            java.lang.String r10 = "chain_id"
            java.lang.String r11 = "chainId"
            java.lang.String r12 = "minimum_order_value"
            java.lang.String r13 = "minOrderValue"
            java.lang.String r14 = "delivery_fee"
            java.lang.String r15 = "deliveryFee"
            r16 = r5
            java.lang.String r5 = "global_entity_id"
            r17 = r3
            java.lang.String r3 = "globalEntityId"
            r18 = r2
            java.lang.String r2 = "target_audience"
            r19 = r8
            java.lang.String r8 = "targetAudience"
            r20 = r7
            java.lang.String r7 = "vendor_id"
            r21 = r6
            java.lang.String r6 = "vendorId"
            r22 = r4
            java.lang.String r4 = "items"
            if (r9 == 0) goto L_0x0135
            com.squareup.moshi.JsonReader$Options r9 = r0.options
            int r9 = r1.selectName(r9)
            switch(r9) {
                case -1: goto L_0x011f;
                case 0: goto L_0x00fb;
                case 1: goto L_0x00da;
                case 2: goto L_0x00bb;
                case 3: goto L_0x009d;
                case 4: goto L_0x0082;
                case 5: goto L_0x0068;
                case 6: goto L_0x0050;
                default: goto L_0x004e;
            }
        L_0x004e:
            goto L_0x0125
        L_0x0050:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x005d
            goto L_0x0127
        L_0x005d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"chainId\"…      \"chain_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0068:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r3 = r2
            java.lang.Float r3 = (java.lang.Float) r3
            if (r3 == 0) goto L_0x0077
            r5 = r16
            goto L_0x0129
        L_0x0077:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"minOrder…mum_order_value\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0082:
            com.squareup.moshi.JsonAdapter<java.lang.Float> r2 = r0.floatAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Float r2 = (java.lang.Float) r2
            if (r2 == 0) goto L_0x0092
            r5 = r16
            r3 = r17
            goto L_0x012b
        L_0x0092:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"delivery…  \"delivery_fee\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x009d:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x00b0
            r5 = r16
            r3 = r17
            r2 = r18
            goto L_0x012d
        L_0x00b0:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r5, r1)
            java.lang.String r2 = "unexpectedNull(\"globalEn…lobal_entity_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00bb:
            com.squareup.moshi.JsonAdapter<com.talabat.darkstores.model.TargetAudienceType> r3 = r0.targetAudienceTypeAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r3
            com.talabat.darkstores.model.TargetAudienceType r7 = (com.talabat.darkstores.model.TargetAudienceType) r7
            if (r7 == 0) goto L_0x00cf
            r5 = r16
            r3 = r17
            r2 = r18
            r8 = r19
            goto L_0x012f
        L_0x00cf:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r8, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"targetAu…target_audience\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00da:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00f0
            r6 = r2
            r5 = r16
            r3 = r17
            r2 = r18
            r8 = r19
            r7 = r20
            goto L_0x0131
        L_0x00f0:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"vendorId…     \"vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00fb:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.darkstores.data.darkstores.model.CartProduct>> r2 = r0.listOfCartProductAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0114
            r4 = r2
            r5 = r16
            r3 = r17
            r2 = r18
            r8 = r19
            r7 = r20
            r6 = r21
            goto L_0x0013
        L_0x0114:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r4, r1)
            java.lang.String r2 = "unexpectedNull(\"items\",\n…         \"items\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x011f:
            r25.skipName()
            r25.skipValue()
        L_0x0125:
            r5 = r16
        L_0x0127:
            r3 = r17
        L_0x0129:
            r2 = r18
        L_0x012b:
            r8 = r19
        L_0x012d:
            r7 = r20
        L_0x012f:
            r6 = r21
        L_0x0131:
            r4 = r22
            goto L_0x0013
        L_0x0135:
            r25.endObject()
            com.talabat.darkstores.data.darkstores.model.CartRequestByCartId r23 = new com.talabat.darkstores.data.darkstores.model.CartRequestByCartId
            if (r22 == 0) goto L_0x019e
            if (r21 == 0) goto L_0x0194
            if (r20 == 0) goto L_0x018a
            if (r19 == 0) goto L_0x0180
            if (r18 == 0) goto L_0x0176
            float r8 = r18.floatValue()
            if (r17 == 0) goto L_0x016c
            float r9 = r17.floatValue()
            if (r16 == 0) goto L_0x0162
            int r10 = r16.intValue()
            r3 = r23
            r4 = r22
            r5 = r21
            r6 = r20
            r7 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r23
        L_0x0162:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r10, r1)
            java.lang.String r2 = "missingProperty(\"chainId\", \"chain_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x016c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r12, r1)
            java.lang.String r2 = "missingProperty(\"minOrde…mum_order_value\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0176:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r14, r1)
            java.lang.String r2 = "missingProperty(\"deliver…fee\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0180:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r3, r5, r1)
            java.lang.String r2 = "missingProperty(\"globalE…lobal_entity_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x018a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r8, r2, r1)
            java.lang.String r2 = "missingProperty(\"targetA…target_audience\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0194:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r6, r7, r1)
            java.lang.String r2 = "missingProperty(\"vendorId\", \"vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x019e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r4, r4, r1)
            java.lang.String r2 = "missingProperty(\"items\", \"items\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.darkstores.model.CartRequestByCartIdJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.darkstores.data.darkstores.model.CartRequestByCartId");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CartRequestByCartId cartRequestByCartId) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (cartRequestByCartId != null) {
            jsonWriter.beginObject();
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.listOfCartProductAdapter.toJson(jsonWriter, cartRequestByCartId.getItems());
            jsonWriter.name("vendor_id");
            this.stringAdapter.toJson(jsonWriter, cartRequestByCartId.getVendorId());
            jsonWriter.name("target_audience");
            this.targetAudienceTypeAdapter.toJson(jsonWriter, cartRequestByCartId.getTargetAudience());
            jsonWriter.name("global_entity_id");
            this.stringAdapter.toJson(jsonWriter, cartRequestByCartId.getGlobalEntityId());
            jsonWriter.name("delivery_fee");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartRequestByCartId.getDeliveryFee()));
            jsonWriter.name("minimum_order_value");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(cartRequestByCartId.getMinOrderValue()));
            jsonWriter.name("chain_id");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(cartRequestByCartId.getChainId()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
