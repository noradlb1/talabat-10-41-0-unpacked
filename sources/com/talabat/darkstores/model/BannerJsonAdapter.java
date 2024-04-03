package com.talabat.darkstores.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/model/BannerJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/model/Banner;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "intAdapter", "", "nullableBooleanAdapter", "nullableStringAdapter", "", "nullableTrackingAdapter", "Lcom/talabat/feature/darkstorescart/data/model/Tracking;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "targetAudienceTypeAdapter", "Lcom/talabat/darkstores/model/TargetAudienceType;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerJsonAdapter extends JsonAdapter<Banner> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @Nullable
    private volatile Constructor<Banner> constructorRef;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonAdapter<Tracking> nullableTrackingAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;
    @NotNull
    private final JsonAdapter<TargetAudienceType> targetAudienceTypeAdapter;

    public BannerJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("global_id", "name", "banner_url", "position", "target_audience", "is_static", "description", "tracking", "campaign_end_time", "is_sponsored");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"global_id\", \"name\", …e\",\n      \"is_sponsored\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "globalId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ySet(),\n      \"globalId\")");
        this.stringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "position");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…, emptySet(), \"position\")");
        this.intAdapter = adapter2;
        JsonAdapter<TargetAudienceType> adapter3 = moshi.adapter(TargetAudienceType.class, SetsKt__SetsKt.emptySet(), "targetAudience");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(TargetAudi…ySet(), \"targetAudience\")");
        this.targetAudienceTypeAdapter = adapter3;
        JsonAdapter<Boolean> adapter4 = moshi.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "isStatic");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Boolean::c…ySet(),\n      \"isStatic\")");
        this.booleanAdapter = adapter4;
        JsonAdapter<String> adapter5 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "description");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(String::cl…mptySet(), \"description\")");
        this.nullableStringAdapter = adapter5;
        JsonAdapter<Tracking> adapter6 = moshi.adapter(Tracking.class, SetsKt__SetsKt.emptySet(), "tracking");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Tracking::…  emptySet(), \"tracking\")");
        this.nullableTrackingAdapter = adapter6;
        JsonAdapter<Boolean> adapter7 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "isSponsored");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Boolean::c…mptySet(), \"isSponsored\")");
        this.nullableBooleanAdapter = adapter7;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(28);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Banner");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0130, code lost:
        r15 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0132, code lost:
        r14 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0134, code lost:
        r13 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0136, code lost:
        r12 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0138, code lost:
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x013a, code lost:
        r10 = r21;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.darkstores.model.Banner fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r38) {
        /*
            r37 = this;
            r0 = r37
            r1 = r38
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r38.beginObject()
            r4 = -1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0018:
            boolean r9 = r38.hasNext()
            java.lang.String r11 = "target_audience"
            java.lang.String r3 = "targetAudience"
            r16 = r15
            java.lang.String r15 = "banner_url"
            r17 = r14
            java.lang.String r14 = "bannerUrl"
            r18 = r13
            java.lang.String r13 = "global_id"
            r19 = r12
            java.lang.String r12 = "globalId"
            r20 = r2
            java.lang.String r2 = "position"
            r21 = r10
            java.lang.String r10 = "name"
            if (r9 == 0) goto L_0x013e
            com.squareup.moshi.JsonReader$Options r9 = r0.options
            int r9 = r1.selectName(r9)
            switch(r9) {
                case -1: goto L_0x012a;
                case 0: goto L_0x0113;
                case 1: goto L_0x00fc;
                case 2: goto L_0x00e5;
                case 3: goto L_0x00ce;
                case 4: goto L_0x00ac;
                case 5: goto L_0x0087;
                case 6: goto L_0x0074;
                case 7: goto L_0x0063;
                case 8: goto L_0x0054;
                case 9: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x0130
        L_0x0047:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.nullableBooleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            r4 = r4 & -513(0xfffffffffffffdff, float:NaN)
            goto L_0x0132
        L_0x0054:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            java.lang.String r14 = (java.lang.String) r14
            r4 = r4 & -257(0xfffffffffffffeff, float:NaN)
            r15 = r16
            goto L_0x0134
        L_0x0063:
            com.squareup.moshi.JsonAdapter<com.talabat.feature.darkstorescart.data.model.Tracking> r2 = r0.nullableTrackingAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            com.talabat.feature.darkstorescart.data.model.Tracking r13 = (com.talabat.feature.darkstorescart.data.model.Tracking) r13
            r4 = r4 & -129(0xffffffffffffff7f, float:NaN)
            r15 = r16
            r14 = r17
            goto L_0x0136
        L_0x0074:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12
            r4 = r4 & -65
            r15 = r16
            r14 = r17
            r13 = r18
            goto L_0x0138
        L_0x0087:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x009d
            r4 = r4 & -33
            r15 = r16
            r14 = r17
            r13 = r18
            r12 = r19
            goto L_0x013a
        L_0x009d:
            java.lang.String r2 = "isStatic"
            java.lang.String r3 = "is_static"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"isStatic…     \"is_static\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00ac:
            com.squareup.moshi.JsonAdapter<com.talabat.darkstores.model.TargetAudienceType> r2 = r0.targetAudienceTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            com.talabat.darkstores.model.TargetAudienceType r10 = (com.talabat.darkstores.model.TargetAudienceType) r10
            if (r10 == 0) goto L_0x00c3
            r15 = r16
            r14 = r17
            r13 = r18
            r12 = r19
            r2 = r20
            goto L_0x0018
        L_0x00c3:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"targetAu…target_audience\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00ce:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r3 = r0.intAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r3
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x00da
            goto L_0x0130
        L_0x00da:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"position…      \"position\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00e5:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x00f1
            goto L_0x0130
        L_0x00f1:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"bannerUr…    \"banner_url\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00fc:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0108
            goto L_0x0130
        L_0x0108:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"name\", \"name\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0113:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x011f
            goto L_0x0130
        L_0x011f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"globalId…     \"global_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x012a:
            r38.skipName()
            r38.skipValue()
        L_0x0130:
            r15 = r16
        L_0x0132:
            r14 = r17
        L_0x0134:
            r13 = r18
        L_0x0136:
            r12 = r19
        L_0x0138:
            r2 = r20
        L_0x013a:
            r10 = r21
            goto L_0x0018
        L_0x013e:
            r38.endObject()
            r9 = -993(0xfffffffffffffc1f, float:NaN)
            if (r4 != r9) goto L_0x019a
            com.talabat.darkstores.model.Banner r4 = new com.talabat.darkstores.model.Banner
            if (r6 == 0) goto L_0x0190
            if (r7 == 0) goto L_0x0186
            if (r8 == 0) goto L_0x017c
            if (r5 == 0) goto L_0x0172
            int r9 = r5.intValue()
            if (r21 == 0) goto L_0x0168
            boolean r11 = r20.booleanValue()
            r5 = r4
            r10 = r21
            r12 = r19
            r13 = r18
            r14 = r17
            r15 = r16
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r4
        L_0x0168:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r3, r11, r1)
            java.lang.String r2 = "missingProperty(\"targetA…target_audience\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0172:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r2 = "missingProperty(\"position\", \"position\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x017c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r15, r1)
            java.lang.String r2 = "missingProperty(\"bannerUrl\", \"banner_url\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0186:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"name\", \"name\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0190:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r13, r1)
            java.lang.String r2 = "missingProperty(\"globalId\", \"global_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x019a:
            java.lang.reflect.Constructor<com.talabat.darkstores.model.Banner> r9 = r0.constructorRef
            r22 = 10
            r23 = 9
            r24 = 8
            r25 = 7
            r26 = 6
            r27 = 5
            r28 = 4
            r29 = 3
            r30 = 2
            r31 = 1
            r32 = 0
            r33 = r12
            r12 = 12
            if (r9 != 0) goto L_0x01f1
            java.lang.Class[] r9 = new java.lang.Class[r12]
            java.lang.Class<java.lang.String> r34 = java.lang.String.class
            r9[r32] = r34
            r9[r31] = r34
            r9[r30] = r34
            java.lang.Class r35 = java.lang.Integer.TYPE
            r9[r29] = r35
            java.lang.Class<com.talabat.darkstores.model.TargetAudienceType> r36 = com.talabat.darkstores.model.TargetAudienceType.class
            r9[r28] = r36
            java.lang.Class r36 = java.lang.Boolean.TYPE
            r9[r27] = r36
            r9[r26] = r34
            java.lang.Class<com.talabat.feature.darkstorescart.data.model.Tracking> r36 = com.talabat.feature.darkstorescart.data.model.Tracking.class
            r9[r25] = r36
            r9[r24] = r34
            java.lang.Class<java.lang.Boolean> r34 = java.lang.Boolean.class
            r9[r23] = r34
            r9[r22] = r35
            r34 = 11
            java.lang.Class<?> r35 = com.squareup.moshi.internal.Util.DEFAULT_CONSTRUCTOR_MARKER
            r9[r34] = r35
            java.lang.Class<com.talabat.darkstores.model.Banner> r12 = com.talabat.darkstores.model.Banner.class
            java.lang.reflect.Constructor r9 = r12.getDeclaredConstructor(r9)
            r0.constructorRef = r9
            java.lang.String r12 = "Banner::class.java.getDe…his.constructorRef = it }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)
            r12 = 12
        L_0x01f1:
            java.lang.Object[] r12 = new java.lang.Object[r12]
            if (r6 == 0) goto L_0x0258
            r12[r32] = r6
            if (r7 == 0) goto L_0x024e
            r12[r31] = r7
            if (r8 == 0) goto L_0x0244
            r12[r30] = r8
            if (r5 == 0) goto L_0x023a
            int r2 = r5.intValue()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12[r29] = r2
            if (r21 == 0) goto L_0x0230
            r12[r28] = r21
            r12[r27] = r20
            r12[r26] = r19
            r12[r25] = r18
            r12[r24] = r17
            r12[r23] = r16
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r12[r22] = r1
            r1 = 11
            r2 = 0
            r12[r1] = r2
            java.lang.Object r1 = r9.newInstance(r12)
            java.lang.String r2 = "localConstructor.newInst…torMarker */ null\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.talabat.darkstores.model.Banner r1 = (com.talabat.darkstores.model.Banner) r1
            return r1
        L_0x0230:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r3, r11, r1)
            java.lang.String r2 = "missingProperty(\"targetA…target_audience\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x023a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r2 = "missingProperty(\"position\", \"position\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0244:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r15, r1)
            java.lang.String r2 = "missingProperty(\"bannerUrl\", \"banner_url\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x024e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"name\", \"name\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0258:
            r2 = r33
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r13, r1)
            java.lang.String r2 = "missingProperty(\"globalId\", \"global_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.model.BannerJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.darkstores.model.Banner");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Banner banner) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (banner != null) {
            jsonWriter.beginObject();
            jsonWriter.name("global_id");
            this.stringAdapter.toJson(jsonWriter, banner.getGlobalId());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, banner.getName());
            jsonWriter.name("banner_url");
            this.stringAdapter.toJson(jsonWriter, banner.getBannerUrl());
            jsonWriter.name("position");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(banner.getPosition()));
            jsonWriter.name("target_audience");
            this.targetAudienceTypeAdapter.toJson(jsonWriter, banner.getTargetAudience());
            jsonWriter.name("is_static");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(banner.isStatic()));
            jsonWriter.name("description");
            this.nullableStringAdapter.toJson(jsonWriter, banner.getDescription());
            jsonWriter.name("tracking");
            this.nullableTrackingAdapter.toJson(jsonWriter, banner.getTracking());
            jsonWriter.name("campaign_end_time");
            this.nullableStringAdapter.toJson(jsonWriter, banner.getCampaignEndTime());
            jsonWriter.name("is_sponsored");
            this.nullableBooleanAdapter.toJson(jsonWriter, banner.isSponsored());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
