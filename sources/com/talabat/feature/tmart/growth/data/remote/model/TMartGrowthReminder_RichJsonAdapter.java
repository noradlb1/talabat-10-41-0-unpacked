package com.talabat.feature.tmart.growth.data.remote.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder_RichJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Rich;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthReminder_RichJsonAdapter extends JsonAdapter<TMartGrowthReminder.Rich> {
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public TMartGrowthReminder_RichJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("background_image_url", "cta_text", "deep_link", "logo_url", "main_image_url", "subtext", "text");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"background_image_url…_url\", \"subtext\", \"text\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "backgroundUrl");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…),\n      \"backgroundUrl\")");
        this.stringAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TMartGrowthReminder.Rich");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x012a, code lost:
        r10 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x012c, code lost:
        r9 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x012e, code lost:
        r8 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0130, code lost:
        r7 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0132, code lost:
        r6 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0134, code lost:
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0136, code lost:
        r4 = r22;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder.Rich fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r25.beginObject()
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
        L_0x0014:
            boolean r2 = r25.hasNext()
            java.lang.String r3 = "text"
            java.lang.String r11 = "title"
            java.lang.String r12 = "subtext"
            java.lang.String r13 = "subtitle"
            java.lang.String r14 = "main_image_url"
            java.lang.String r15 = "imageUrl"
            r16 = r10
            java.lang.String r10 = "logo_url"
            r17 = r9
            java.lang.String r9 = "logoUrl"
            r18 = r8
            java.lang.String r8 = "deep_link"
            r19 = r7
            java.lang.String r7 = "deeplink"
            r20 = r6
            java.lang.String r6 = "cta_text"
            r21 = r5
            java.lang.String r5 = "buttonText"
            r22 = r4
            java.lang.String r4 = "background_image_url"
            r23 = r4
            java.lang.String r4 = "backgroundUrl"
            if (r2 == 0) goto L_0x013a
            com.squareup.moshi.JsonReader$Options r2 = r0.options
            int r2 = r1.selectName(r2)
            switch(r2) {
                case -1: goto L_0x0124;
                case 0: goto L_0x00fe;
                case 1: goto L_0x00dd;
                case 2: goto L_0x00be;
                case 3: goto L_0x00a0;
                case 4: goto L_0x0084;
                case 5: goto L_0x006a;
                case 6: goto L_0x0052;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x012a
        L_0x0052:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x005f
            goto L_0x012c
        L_0x005f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"title\", …ext\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x006a:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x0079
            r10 = r16
            goto L_0x012e
        L_0x0079:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"subtitle…       \"subtext\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0084:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x0095
            r10 = r16
            r9 = r17
            goto L_0x0130
        L_0x0095:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"imageUrl…\"main_image_url\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00a0:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x00b3
            r10 = r16
            r9 = r17
            r8 = r18
            goto L_0x0132
        L_0x00b3:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"logoUrl\"…      \"logo_url\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00be:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x00d2
            r10 = r16
            r9 = r17
            r8 = r18
            r7 = r19
            goto L_0x0134
        L_0x00d2:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r8, r1)
            java.lang.String r2 = "unexpectedNull(\"deeplink…     \"deep_link\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00dd:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00f3
            r5 = r2
            r10 = r16
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            goto L_0x0136
        L_0x00f3:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r5, r6, r1)
            java.lang.String r2 = "unexpectedNull(\"buttonTe…      \"cta_text\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00fe:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0117
            r4 = r2
            r10 = r16
            r9 = r17
            r8 = r18
            r7 = r19
            r6 = r20
            r5 = r21
            goto L_0x0014
        L_0x0117:
            r2 = r23
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"backgrou…round_image_url\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0124:
            r25.skipName()
            r25.skipValue()
        L_0x012a:
            r10 = r16
        L_0x012c:
            r9 = r17
        L_0x012e:
            r8 = r18
        L_0x0130:
            r7 = r19
        L_0x0132:
            r6 = r20
        L_0x0134:
            r5 = r21
        L_0x0136:
            r4 = r22
            goto L_0x0014
        L_0x013a:
            r2 = r23
            r25.endObject()
            com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder$Rich r23 = new com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder$Rich
            if (r22 == 0) goto L_0x019f
            if (r21 == 0) goto L_0x0195
            if (r20 == 0) goto L_0x018b
            if (r19 == 0) goto L_0x0181
            if (r18 == 0) goto L_0x0177
            if (r17 == 0) goto L_0x016d
            if (r16 == 0) goto L_0x0163
            r3 = r23
            r4 = r22
            r5 = r21
            r6 = r20
            r7 = r19
            r8 = r18
            r9 = r17
            r10 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r23
        L_0x0163:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r3, r1)
            java.lang.String r2 = "missingProperty(\"title\", \"text\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x016d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r12, r1)
            java.lang.String r2 = "missingProperty(\"subtitle\", \"subtext\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0177:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r14, r1)
            java.lang.String r2 = "missingProperty(\"imageUr…\"main_image_url\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0181:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r10, r1)
            java.lang.String r2 = "missingProperty(\"logoUrl\", \"logo_url\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x018b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r8, r1)
            java.lang.String r2 = "missingProperty(\"deeplink\", \"deep_link\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0195:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r5, r6, r1)
            java.lang.String r2 = "missingProperty(\"buttonText\", \"cta_text\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x019f:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r4, r2, r1)
            java.lang.String r2 = "missingProperty(\"backgro…round_image_url\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder_RichJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder$Rich");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable TMartGrowthReminder.Rich rich) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (rich != null) {
            jsonWriter.beginObject();
            jsonWriter.name("background_image_url");
            this.stringAdapter.toJson(jsonWriter, rich.getBackgroundUrl());
            jsonWriter.name("cta_text");
            this.stringAdapter.toJson(jsonWriter, rich.getButtonText());
            jsonWriter.name("deep_link");
            this.stringAdapter.toJson(jsonWriter, rich.getDeeplink());
            jsonWriter.name("logo_url");
            this.stringAdapter.toJson(jsonWriter, rich.getLogoUrl());
            jsonWriter.name("main_image_url");
            this.stringAdapter.toJson(jsonWriter, rich.getImageUrl());
            jsonWriter.name("subtext");
            this.stringAdapter.toJson(jsonWriter, rich.getSubtitle());
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, rich.getTitle());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
