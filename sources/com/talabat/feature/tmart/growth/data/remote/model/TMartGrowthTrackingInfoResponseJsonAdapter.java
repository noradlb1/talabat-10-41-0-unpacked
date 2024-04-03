package com.talabat.feature.tmart.growth.data.remote.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "intAdapter", "", "listOfStringAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthTrackingInfoResponseJsonAdapter extends JsonAdapter<TMartGrowthTrackingInfoResponse> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<List<String>> listOfStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public TMartGrowthTrackingInfoResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(OPNavigatorActions.ARG_BRANCH_ID, "branch_name", "cuisines", "delivery_time", "is_darkstore", "name", "status", "status_type", "vendor_id", "vertical_type");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"branch_id\", \"branch_…\",\n      \"vertical_type\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "branchId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ySet(),\n      \"branchId\")");
        this.stringAdapter = adapter;
        JsonAdapter<List<String>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, cls), SetsKt__SetsKt.emptySet(), "cuisines");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…ySet(),\n      \"cuisines\")");
        this.listOfStringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "isDarkstore");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…t(),\n      \"isDarkstore\")");
        this.booleanAdapter = adapter3;
        JsonAdapter<Integer> adapter4 = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "verticalType");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Int::class…(),\n      \"verticalType\")");
        this.intAdapter = adapter4;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TMartGrowthTrackingInfoResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01ce, code lost:
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01d0, code lost:
        r12 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01d2, code lost:
        r11 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01d4, code lost:
        r10 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01d6, code lost:
        r9 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d8, code lost:
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01da, code lost:
        r7 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01dc, code lost:
        r6 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01de, code lost:
        r5 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01e0, code lost:
        r4 = r25;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthTrackingInfoResponse fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r37) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r37.beginObject()
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r9 = r7
            r10 = r9
            r11 = r10
            r12 = r11
        L_0x0016:
            boolean r8 = r37.hasNext()
            java.lang.String r13 = "vertical_type"
            java.lang.String r14 = "verticalType"
            java.lang.String r15 = "vendor_id"
            r16 = r3
            java.lang.String r3 = "vendorId"
            r17 = r12
            java.lang.String r12 = "status_type"
            r18 = r11
            java.lang.String r11 = "vendorStatusType"
            r19 = r10
            java.lang.String r10 = "status"
            r20 = r9
            java.lang.String r9 = "vendorStatus"
            r21 = r2
            java.lang.String r2 = "name"
            r22 = r7
            java.lang.String r7 = "vendorName"
            r23 = r6
            java.lang.String r6 = "is_darkstore"
            r24 = r5
            java.lang.String r5 = "isDarkstore"
            r25 = r4
            java.lang.String r4 = "delivery_time"
            r26 = r4
            java.lang.String r4 = "deliveryTime"
            r27 = r4
            java.lang.String r4 = "branch_name"
            r28 = r4
            java.lang.String r4 = "branchName"
            r29 = r4
            java.lang.String r4 = "branch_id"
            r30 = r4
            java.lang.String r4 = "branchId"
            r31 = r4
            java.lang.String r4 = "cuisines"
            if (r8 == 0) goto L_0x01e4
            com.squareup.moshi.JsonReader$Options r8 = r0.options
            int r8 = r1.selectName(r8)
            switch(r8) {
                case -1: goto L_0x01c8;
                case 0: goto L_0x019a;
                case 1: goto L_0x016f;
                case 2: goto L_0x0149;
                case 3: goto L_0x0121;
                case 4: goto L_0x0100;
                case 5: goto L_0x00e0;
                case 6: goto L_0x00c2;
                case 7: goto L_0x00a6;
                case 8: goto L_0x008c;
                case 9: goto L_0x0074;
                default: goto L_0x0072;
            }
        L_0x0072:
            goto L_0x01ce
        L_0x0074:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r3 = r2
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x0081
            goto L_0x01d0
        L_0x0081:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"vertical… \"vertical_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x008c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x009b
            r3 = r16
            goto L_0x01d2
        L_0x009b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"vendorId…     \"vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00a6:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00b7
            r11 = r2
            r3 = r16
            r12 = r17
            goto L_0x01d4
        L_0x00b7:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"vendorSt…\", \"status_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00c2:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00d5
            r10 = r2
            r3 = r16
            r12 = r17
            r11 = r18
            goto L_0x01d6
        L_0x00d5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"vendorStatus\", \"status\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00e0:
            com.squareup.moshi.JsonAdapter<java.lang.String> r3 = r0.stringAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r3
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x00f5
            r3 = r16
            r12 = r17
            r11 = r18
            r10 = r19
            goto L_0x01d8
        L_0x00f5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"vendorNa…          \"name\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0100:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x0116
            r3 = r16
            r12 = r17
            r11 = r18
            r10 = r19
            r9 = r20
            goto L_0x01da
        L_0x0116:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r5, r6, r1)
            java.lang.String r2 = "unexpectedNull(\"isDarkst…, \"is_darkstore\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0121:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x013a
            r3 = r16
            r12 = r17
            r11 = r18
            r10 = r19
            r9 = r20
            r2 = r21
            goto L_0x01dc
        L_0x013a:
            r8 = r26
            r2 = r27
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r8, r1)
            java.lang.String r2 = "unexpectedNull(\"delivery… \"delivery_time\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0149:
            com.squareup.moshi.JsonAdapter<java.util.List<java.lang.String>> r2 = r0.listOfStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x0164
            r3 = r16
            r12 = r17
            r11 = r18
            r10 = r19
            r9 = r20
            r2 = r21
            r7 = r22
            goto L_0x01de
        L_0x0164:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r4, r1)
            java.lang.String r2 = "unexpectedNull(\"cuisines\", \"cuisines\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x016f:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x018b
            r3 = r16
            r12 = r17
            r11 = r18
            r10 = r19
            r9 = r20
            r2 = r21
            r7 = r22
            r6 = r23
            goto L_0x01e0
        L_0x018b:
            r2 = r28
            r3 = r29
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"branchNa…   \"branch_name\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x019a:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x01b9
            r3 = r16
            r12 = r17
            r11 = r18
            r10 = r19
            r9 = r20
            r2 = r21
            r7 = r22
            r6 = r23
            r5 = r24
            goto L_0x0016
        L_0x01b9:
            r2 = r30
            r3 = r31
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"branchId…     \"branch_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01c8:
            r37.skipName()
            r37.skipValue()
        L_0x01ce:
            r3 = r16
        L_0x01d0:
            r12 = r17
        L_0x01d2:
            r11 = r18
        L_0x01d4:
            r10 = r19
        L_0x01d6:
            r9 = r20
        L_0x01d8:
            r2 = r21
        L_0x01da:
            r7 = r22
        L_0x01dc:
            r6 = r23
        L_0x01de:
            r5 = r24
        L_0x01e0:
            r4 = r25
            goto L_0x0016
        L_0x01e4:
            r8 = r26
            r0 = r27
            r32 = r28
            r33 = r29
            r34 = r30
            r35 = r31
            r37.endObject()
            com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthTrackingInfoResponse r26 = new com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthTrackingInfoResponse
            if (r25 == 0) goto L_0x0285
            if (r24 == 0) goto L_0x0277
            if (r23 == 0) goto L_0x026d
            if (r22 == 0) goto L_0x0263
            if (r21 == 0) goto L_0x0259
            boolean r8 = r21.booleanValue()
            if (r20 == 0) goto L_0x024f
            if (r19 == 0) goto L_0x0245
            if (r18 == 0) goto L_0x023b
            if (r17 == 0) goto L_0x0231
            if (r16 == 0) goto L_0x0227
            int r13 = r16.intValue()
            r3 = r26
            r4 = r25
            r5 = r24
            r6 = r23
            r7 = r22
            r9 = r20
            r10 = r19
            r11 = r18
            r12 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r26
        L_0x0227:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r14, r13, r1)
            java.lang.String r1 = "missingProperty(\"vertica…ype\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0231:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r3, r15, r1)
            java.lang.String r1 = "missingProperty(\"vendorId\", \"vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x023b:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r11, r12, r1)
            java.lang.String r1 = "missingProperty(\"vendorS…   \"status_type\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0245:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r9, r10, r1)
            java.lang.String r1 = "missingProperty(\"vendorStatus\", \"status\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x024f:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r7, r2, r1)
            java.lang.String r1 = "missingProperty(\"vendorName\", \"name\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0259:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r5, r6, r1)
            java.lang.String r1 = "missingProperty(\"isDarks…ore\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0263:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r0, r8, r1)
            java.lang.String r1 = "missingProperty(\"deliver…ime\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x026d:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r4, r4, r1)
            java.lang.String r1 = "missingProperty(\"cuisines\", \"cuisines\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0277:
            r0 = r32
            r2 = r33
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r0, r1)
            java.lang.String r1 = "missingProperty(\"branchN…\", \"branch_name\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0285:
            r0 = r34
            r2 = r35
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r2, r0, r1)
            java.lang.String r1 = "missingProperty(\"branchId\", \"branch_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthTrackingInfoResponseJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthTrackingInfoResponse");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (tMartGrowthTrackingInfoResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name(OPNavigatorActions.ARG_BRANCH_ID);
            this.stringAdapter.toJson(jsonWriter, tMartGrowthTrackingInfoResponse.getBranchId());
            jsonWriter.name("branch_name");
            this.stringAdapter.toJson(jsonWriter, tMartGrowthTrackingInfoResponse.getBranchName());
            jsonWriter.name("cuisines");
            this.listOfStringAdapter.toJson(jsonWriter, tMartGrowthTrackingInfoResponse.getCuisines());
            jsonWriter.name("delivery_time");
            this.stringAdapter.toJson(jsonWriter, tMartGrowthTrackingInfoResponse.getDeliveryTime());
            jsonWriter.name("is_darkstore");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(tMartGrowthTrackingInfoResponse.isDarkstore()));
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, tMartGrowthTrackingInfoResponse.getVendorName());
            jsonWriter.name("status");
            this.stringAdapter.toJson(jsonWriter, tMartGrowthTrackingInfoResponse.getVendorStatus());
            jsonWriter.name("status_type");
            this.stringAdapter.toJson(jsonWriter, tMartGrowthTrackingInfoResponse.getVendorStatusType());
            jsonWriter.name("vendor_id");
            this.stringAdapter.toJson(jsonWriter, tMartGrowthTrackingInfoResponse.getVendorId());
            jsonWriter.name("vertical_type");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(tMartGrowthTrackingInfoResponse.getVerticalType()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
