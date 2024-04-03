package com.talabat.feature.tmart.growth.data.remote.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse_ClaimInfoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse$ClaimInfo;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stateAdapter", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse$ClaimInfo$State;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthVoucherResponse_ClaimInfoJsonAdapter extends JsonAdapter<TMartGrowthVoucherResponse.ClaimInfo> {
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<TMartGrowthVoucherResponse.ClaimInfo.State> stateAdapter;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public TMartGrowthVoucherResponse_ClaimInfoJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("headline", "subtext", "button_text", "icon_url", "image_basic_url", "image_final_url", "loader_gif_basic_url", "loader_gif_final_url", "state", "deeplink", "logo_url", "background_url");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"headline\", \"subtext\"…o_url\", \"background_url\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "title");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…mptySet(),\n      \"title\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "buttonText");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…emptySet(), \"buttonText\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<TMartGrowthVoucherResponse.ClaimInfo.State> adapter3 = moshi.adapter(TMartGrowthVoucherResponse.ClaimInfo.State.class, SetsKt__SetsKt.emptySet(), "state");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(TMartGrowt…ava, emptySet(), \"state\")");
        this.stateAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TMartGrowthVoucherResponse.ClaimInfo");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x010e, code lost:
        r15 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0110, code lost:
        r14 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0112, code lost:
        r11 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0114, code lost:
        r10 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0116, code lost:
        r9 = r20;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse.ClaimInfo fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r22.beginObject()
            r2 = 0
            r4 = r2
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
        L_0x0019:
            boolean r2 = r22.hasNext()
            java.lang.String r3 = "subtext"
            r16 = r15
            java.lang.String r15 = "description"
            r17 = r14
            java.lang.String r14 = "headline"
            r18 = r11
            java.lang.String r11 = "title"
            r19 = r10
            java.lang.String r10 = "deeplink"
            r20 = r9
            java.lang.String r9 = "state"
            if (r2 == 0) goto L_0x011a
            com.squareup.moshi.JsonReader$Options r2 = r0.options
            int r2 = r1.selectName(r2)
            switch(r2) {
                case -1: goto L_0x0108;
                case 0: goto L_0x00f1;
                case 1: goto L_0x00da;
                case 2: goto L_0x00d0;
                case 3: goto L_0x00c6;
                case 4: goto L_0x00bc;
                case 5: goto L_0x00a9;
                case 6: goto L_0x0098;
                case 7: goto L_0x0089;
                case 8: goto L_0x0071;
                case 9: goto L_0x0059;
                case 10: goto L_0x004c;
                case 11: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x010e
        L_0x0041:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0110
        L_0x004c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            java.lang.String r14 = (java.lang.String) r14
            r15 = r16
            goto L_0x0112
        L_0x0059:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            java.lang.String r13 = (java.lang.String) r13
            if (r13 == 0) goto L_0x0066
            goto L_0x010e
        L_0x0066:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"deeplink…      \"deeplink\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0071:
            com.squareup.moshi.JsonAdapter<com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse$ClaimInfo$State> r2 = r0.stateAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse$ClaimInfo$State r12 = (com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse.ClaimInfo.State) r12
            if (r12 == 0) goto L_0x007e
            goto L_0x010e
        L_0x007e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"state\", …ate\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0089:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            r15 = r16
            r14 = r17
            goto L_0x0114
        L_0x0098:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            r15 = r16
            r14 = r17
            r11 = r18
            goto L_0x0116
        L_0x00a9:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            r15 = r16
            r14 = r17
            r11 = r18
            r10 = r19
            goto L_0x0019
        L_0x00bc:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x010e
        L_0x00c6:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x010e
        L_0x00d0:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x010e
        L_0x00da:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x00e6
            goto L_0x010e
        L_0x00e6:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"description\", \"subtext\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00f1:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00fd
            goto L_0x010e
        L_0x00fd:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"title\",\n…      \"headline\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0108:
            r22.skipName()
            r22.skipValue()
        L_0x010e:
            r15 = r16
        L_0x0110:
            r14 = r17
        L_0x0112:
            r11 = r18
        L_0x0114:
            r10 = r19
        L_0x0116:
            r9 = r20
            goto L_0x0019
        L_0x011a:
            r22.endObject()
            com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse$ClaimInfo r2 = new com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse$ClaimInfo
            if (r4 == 0) goto L_0x0154
            if (r5 == 0) goto L_0x014a
            if (r12 == 0) goto L_0x0140
            if (r13 == 0) goto L_0x0136
            r3 = r2
            r9 = r20
            r10 = r19
            r11 = r18
            r14 = r17
            r15 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r2
        L_0x0136:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"deeplink\", \"deeplink\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0140:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r9, r1)
            java.lang.String r2 = "missingProperty(\"state\", \"state\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x014a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r3, r1)
            java.lang.String r2 = "missingProperty(\"description\", \"subtext\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0154:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r14, r1)
            java.lang.String r2 = "missingProperty(\"title\", \"headline\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse_ClaimInfoJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse$ClaimInfo");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable TMartGrowthVoucherResponse.ClaimInfo claimInfo) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (claimInfo != null) {
            jsonWriter.beginObject();
            jsonWriter.name("headline");
            this.stringAdapter.toJson(jsonWriter, claimInfo.getTitle());
            jsonWriter.name("subtext");
            this.stringAdapter.toJson(jsonWriter, claimInfo.getDescription());
            jsonWriter.name("button_text");
            this.nullableStringAdapter.toJson(jsonWriter, claimInfo.getButtonText());
            jsonWriter.name("icon_url");
            this.nullableStringAdapter.toJson(jsonWriter, claimInfo.getIconUrl());
            jsonWriter.name("image_basic_url");
            this.nullableStringAdapter.toJson(jsonWriter, claimInfo.getBasicImageUrl());
            jsonWriter.name("image_final_url");
            this.nullableStringAdapter.toJson(jsonWriter, claimInfo.getFinalImageUrl());
            jsonWriter.name("loader_gif_basic_url");
            this.nullableStringAdapter.toJson(jsonWriter, claimInfo.getBasicLoaderUrl());
            jsonWriter.name("loader_gif_final_url");
            this.nullableStringAdapter.toJson(jsonWriter, claimInfo.getFinalLoaderUrl());
            jsonWriter.name("state");
            this.stateAdapter.toJson(jsonWriter, claimInfo.getState());
            jsonWriter.name("deeplink");
            this.stringAdapter.toJson(jsonWriter, claimInfo.getDeeplink());
            jsonWriter.name("logo_url");
            this.nullableStringAdapter.toJson(jsonWriter, claimInfo.getLogoUrl());
            jsonWriter.name("background_url");
            this.nullableStringAdapter.toJson(jsonWriter, claimInfo.getBackgroundUrl());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
