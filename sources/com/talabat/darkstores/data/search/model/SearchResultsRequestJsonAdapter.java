package com.talabat.darkstores.data.search.model;

import com.facebook.share.internal.ShareConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.darkstores.data.search.model.SearchResultsRequest;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.homescreen.network.UrlConstantsKt;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchResultsRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/search/model/SearchResultsRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfVendorAdapter", "", "Lcom/talabat/darkstores/data/search/model/SearchResultsRequest$Vendor;", "nullableFiltersAdapter", "Lcom/talabat/darkstores/data/search/model/SearchResultsRequest$Filters;", "nullableIntAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsRequestJsonAdapter extends JsonAdapter<SearchResultsRequest> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @Nullable
    private volatile Constructor<SearchResultsRequest> constructorRef;
    @NotNull
    private final JsonAdapter<List<SearchResultsRequest.Vendor>> listOfVendorAdapter;
    @NotNull
    private final JsonAdapter<SearchResultsRequest.Filters> nullableFiltersAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public SearchResultsRequestJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(ScreenNames.SCREEN_TYPE_BRAND, DarkstoresMainActivity.CONFIG_EXTRA_KEY, UrlConstantsKt.PATH_COUNTRY_CODE, "is_darkstore", "language_code", "vendors", ShareConstants.WEB_DIALOG_PARAM_FILTERS, com.talabat.talabatcommon.feature.darkstores.lookingGlass.UrlConstantsKt.LIMIT, "offset", "query", "customer_id", "talabatBranchId");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"brand\", \"config\", \"c…r_id\", \"talabatBranchId\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), ScreenNames.SCREEN_TYPE_BRAND);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…mptySet(),\n      \"brand\")");
        this.stringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "isDarkstore");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…t(),\n      \"isDarkstore\")");
        this.booleanAdapter = adapter2;
        JsonAdapter<List<SearchResultsRequest.Vendor>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, SearchResultsRequest.Vendor.class), SetsKt__SetsKt.emptySet(), "vendors");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…), emptySet(), \"vendors\")");
        this.listOfVendorAdapter = adapter3;
        JsonAdapter<SearchResultsRequest.Filters> adapter4 = moshi.adapter(SearchResultsRequest.Filters.class, SetsKt__SetsKt.emptySet(), ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(SearchResu…a, emptySet(), \"filters\")");
        this.nullableFiltersAdapter = adapter4;
        JsonAdapter<Integer> adapter5 = moshi.adapter(Integer.class, SetsKt__SetsKt.emptySet(), com.talabat.talabatcommon.feature.darkstores.lookingGlass.UrlConstantsKt.LIMIT);
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Int::class…     emptySet(), \"limit\")");
        this.nullableIntAdapter = adapter5;
        JsonAdapter<String> adapter6 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "query");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(String::cl…     emptySet(), \"query\")");
        this.nullableStringAdapter = adapter6;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(42);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SearchResultsRequest");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x018f, code lost:
        r14 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0191, code lost:
        r13 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0193, code lost:
        r12 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0195, code lost:
        r11 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0197, code lost:
        r15 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0199, code lost:
        r10 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x019b, code lost:
        r9 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x019d, code lost:
        r4 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x019f, code lost:
        r7 = r25;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.darkstores.data.search.model.SearchResultsRequest fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r39) {
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
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x001a:
            boolean r8 = r39.hasNext()
            java.lang.String r2 = "customer_id"
            r17 = r14
            java.lang.String r14 = "customerId"
            r18 = r13
            java.lang.String r13 = "language_code"
            r19 = r12
            java.lang.String r12 = "languageCode"
            r20 = r11
            java.lang.String r11 = "is_darkstore"
            r21 = r15
            java.lang.String r15 = "isDarkstore"
            r22 = r10
            java.lang.String r10 = "country_code"
            r23 = r9
            java.lang.String r9 = "countryCode"
            r24 = r4
            java.lang.String r4 = "config"
            r25 = r7
            java.lang.String r7 = "brand"
            if (r8 == 0) goto L_0x01a3
            com.squareup.moshi.JsonReader$Options r8 = r0.options
            int r8 = r1.selectName(r8)
            switch(r8) {
                case -1: goto L_0x0189;
                case 0: goto L_0x0172;
                case 1: goto L_0x015b;
                case 2: goto L_0x0133;
                case 3: goto L_0x010d;
                case 4: goto L_0x00e9;
                case 5: goto L_0x00bf;
                case 6: goto L_0x00ac;
                case 7: goto L_0x009b;
                case 8: goto L_0x008c;
                case 9: goto L_0x007f;
                case 10: goto L_0x005f;
                case 11: goto L_0x0051;
                default: goto L_0x004f;
            }
        L_0x004f:
            goto L_0x018f
        L_0x0051:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r2
            java.lang.String r16 = (java.lang.String) r16
            r3 = r3 & -2049(0xfffffffffffff7ff, float:NaN)
            goto L_0x018f
        L_0x005f:
            com.squareup.moshi.JsonAdapter<java.lang.String> r4 = r0.stringAdapter
            java.lang.Object r4 = r4.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r4
            java.lang.String r15 = (java.lang.String) r15
            if (r15 == 0) goto L_0x0074
            r14 = r17
            r13 = r18
            r12 = r19
            r11 = r20
            goto L_0x0199
        L_0x0074:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"customer…   \"customer_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x007f:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            java.lang.String r14 = (java.lang.String) r14
            r3 = r3 & -513(0xfffffffffffffdff, float:NaN)
            goto L_0x0191
        L_0x008c:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.nullableIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            java.lang.Integer r13 = (java.lang.Integer) r13
            r3 = r3 & -257(0xfffffffffffffeff, float:NaN)
            r14 = r17
            goto L_0x0193
        L_0x009b:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.nullableIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.Integer r12 = (java.lang.Integer) r12
            r3 = r3 & -129(0xffffffffffffff7f, float:NaN)
            r14 = r17
            r13 = r18
            goto L_0x0195
        L_0x00ac:
            com.squareup.moshi.JsonAdapter<com.talabat.darkstores.data.search.model.SearchResultsRequest$Filters> r2 = r0.nullableFiltersAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            com.talabat.darkstores.data.search.model.SearchResultsRequest$Filters r11 = (com.talabat.darkstores.data.search.model.SearchResultsRequest.Filters) r11
            r3 = r3 & -65
            r14 = r17
            r13 = r18
            r12 = r19
            goto L_0x0197
        L_0x00bf:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.darkstores.data.search.model.SearchResultsRequest$Vendor>> r2 = r0.listOfVendorAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.util.List r10 = (java.util.List) r10
            if (r10 == 0) goto L_0x00d8
            r3 = r3 & -33
            r14 = r17
            r13 = r18
            r12 = r19
            r11 = r20
            r15 = r21
            goto L_0x019b
        L_0x00d8:
            java.lang.String r2 = "vendors"
            java.lang.String r3 = "vendors"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"vendors\"…       \"vendors\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00e9:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x0102
            r14 = r17
            r13 = r18
            r12 = r19
            r11 = r20
            r15 = r21
            r10 = r22
            goto L_0x019d
        L_0x0102:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"language… \"language_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x010d:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            if (r4 == 0) goto L_0x0128
            r14 = r17
            r13 = r18
            r12 = r19
            r11 = r20
            r15 = r21
            r10 = r22
            r9 = r23
            goto L_0x019f
        L_0x0128:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"isDarkst…, \"is_darkstore\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0133:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0150
            r14 = r17
            r13 = r18
            r12 = r19
            r11 = r20
            r15 = r21
            r10 = r22
            r9 = r23
            r4 = r24
            goto L_0x001a
        L_0x0150:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"countryC…, \"country_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x015b:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0167
            goto L_0x018f
        L_0x0167:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r4, r1)
            java.lang.String r2 = "unexpectedNull(\"config\",…        \"config\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0172:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x017e
            goto L_0x018f
        L_0x017e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"brand\", …and\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0189:
            r39.skipName()
            r39.skipValue()
        L_0x018f:
            r14 = r17
        L_0x0191:
            r13 = r18
        L_0x0193:
            r12 = r19
        L_0x0195:
            r11 = r20
        L_0x0197:
            r15 = r21
        L_0x0199:
            r10 = r22
        L_0x019b:
            r9 = r23
        L_0x019d:
            r4 = r24
        L_0x019f:
            r7 = r25
            goto L_0x001a
        L_0x01a3:
            r39.endObject()
            r8 = -3041(0xfffffffffffff41f, float:NaN)
            if (r3 != r8) goto L_0x0217
            com.talabat.darkstores.data.search.model.SearchResultsRequest r3 = new com.talabat.darkstores.data.search.model.SearchResultsRequest
            if (r5 == 0) goto L_0x020d
            if (r6 == 0) goto L_0x0203
            if (r25 == 0) goto L_0x01f9
            if (r24 == 0) goto L_0x01ef
            boolean r8 = r24.booleanValue()
            if (r23 == 0) goto L_0x01e5
            if (r22 == 0) goto L_0x01dd
            if (r21 == 0) goto L_0x01d3
            r4 = r3
            r7 = r25
            r9 = r23
            r10 = r22
            r11 = r20
            r12 = r19
            r13 = r18
            r14 = r17
            r15 = r21
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r3
        L_0x01d3:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r2, r1)
            java.lang.String r2 = "missingProperty(\"custome…d\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01dd:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<com.talabat.darkstores.data.search.model.SearchResultsRequest.Vendor>"
            r1.<init>(r2)
            throw r1
        L_0x01e5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r13, r1)
            java.lang.String r2 = "missingProperty(\"languag…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01ef:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r11, r1)
            java.lang.String r2 = "missingProperty(\"isDarks…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01f9:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r10, r1)
            java.lang.String r2 = "missingProperty(\"country…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0203:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r4, r4, r1)
            java.lang.String r2 = "missingProperty(\"config\", \"config\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x020d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r2 = "missingProperty(\"brand\", \"brand\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0217:
            java.lang.reflect.Constructor<com.talabat.darkstores.data.search.model.SearchResultsRequest> r8 = r0.constructorRef
            r26 = 7
            r27 = 6
            r28 = 5
            r29 = 4
            r30 = 3
            r31 = 2
            r32 = 1
            r33 = 0
            r34 = r7
            r7 = 14
            if (r8 != 0) goto L_0x0276
            java.lang.Class[] r8 = new java.lang.Class[r7]
            java.lang.Class<java.lang.String> r35 = java.lang.String.class
            r8[r33] = r35
            r8[r32] = r35
            r8[r31] = r35
            java.lang.Class r36 = java.lang.Boolean.TYPE
            r8[r30] = r36
            r8[r29] = r35
            java.lang.Class<java.util.List> r36 = java.util.List.class
            r8[r28] = r36
            java.lang.Class<com.talabat.darkstores.data.search.model.SearchResultsRequest$Filters> r36 = com.talabat.darkstores.data.search.model.SearchResultsRequest.Filters.class
            r8[r27] = r36
            java.lang.Class<java.lang.Integer> r36 = java.lang.Integer.class
            r8[r26] = r36
            r37 = 8
            r8[r37] = r36
            r36 = 9
            r8[r36] = r35
            r36 = 10
            r8[r36] = r35
            r36 = 11
            r8[r36] = r35
            r35 = 12
            java.lang.Class r36 = java.lang.Integer.TYPE
            r8[r35] = r36
            r35 = 13
            java.lang.Class<?> r36 = com.squareup.moshi.internal.Util.DEFAULT_CONSTRUCTOR_MARKER
            r8[r35] = r36
            java.lang.Class<com.talabat.darkstores.data.search.model.SearchResultsRequest> r7 = com.talabat.darkstores.data.search.model.SearchResultsRequest.class
            java.lang.reflect.Constructor r8 = r7.getDeclaredConstructor(r8)
            r0.constructorRef = r8
            java.lang.String r7 = "SearchResultsRequest::cl…his.constructorRef = it }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            r7 = 14
        L_0x0276:
            java.lang.Object[] r7 = new java.lang.Object[r7]
            if (r5 == 0) goto L_0x02f7
            r7[r33] = r5
            if (r6 == 0) goto L_0x02ed
            r7[r32] = r6
            if (r25 == 0) goto L_0x02e3
            r7[r31] = r25
            if (r24 == 0) goto L_0x02d9
            boolean r4 = r24.booleanValue()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r7[r30] = r4
            if (r23 == 0) goto L_0x02cf
            r7[r29] = r23
            r7[r28] = r22
            r7[r27] = r20
            r7[r26] = r19
            r4 = 8
            r7[r4] = r18
            r4 = 9
            r7[r4] = r17
            if (r21 == 0) goto L_0x02c5
            r1 = 10
            r7[r1] = r21
            r1 = 11
            r7[r1] = r16
            r1 = 12
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r7[r1] = r2
            r1 = 13
            r2 = 0
            r7[r1] = r2
            java.lang.Object r1 = r8.newInstance(r7)
            java.lang.String r2 = "localConstructor.newInst…torMarker */ null\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.talabat.darkstores.data.search.model.SearchResultsRequest r1 = (com.talabat.darkstores.data.search.model.SearchResultsRequest) r1
            return r1
        L_0x02c5:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r2, r1)
            java.lang.String r2 = "missingProperty(\"custome…\", \"customer_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02cf:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r13, r1)
            java.lang.String r2 = "missingProperty(\"languag… \"language_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02d9:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r11, r1)
            java.lang.String r2 = "missingProperty(\"isDarks…, \"is_darkstore\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02e3:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r10, r1)
            java.lang.String r2 = "missingProperty(\"country…, \"country_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02ed:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r4, r4, r1)
            java.lang.String r2 = "missingProperty(\"config\", \"config\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x02f7:
            r2 = r34
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r2 = "missingProperty(\"brand\", \"brand\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.search.model.SearchResultsRequestJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.darkstores.data.search.model.SearchResultsRequest");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable SearchResultsRequest searchResultsRequest) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (searchResultsRequest != null) {
            jsonWriter.beginObject();
            jsonWriter.name(ScreenNames.SCREEN_TYPE_BRAND);
            this.stringAdapter.toJson(jsonWriter, searchResultsRequest.getBrand());
            jsonWriter.name(DarkstoresMainActivity.CONFIG_EXTRA_KEY);
            this.stringAdapter.toJson(jsonWriter, searchResultsRequest.getConfig());
            jsonWriter.name(UrlConstantsKt.PATH_COUNTRY_CODE);
            this.stringAdapter.toJson(jsonWriter, searchResultsRequest.getCountryCode());
            jsonWriter.name("is_darkstore");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(searchResultsRequest.isDarkstore()));
            jsonWriter.name("language_code");
            this.stringAdapter.toJson(jsonWriter, searchResultsRequest.getLanguageCode());
            jsonWriter.name("vendors");
            this.listOfVendorAdapter.toJson(jsonWriter, searchResultsRequest.getVendors());
            jsonWriter.name(ShareConstants.WEB_DIALOG_PARAM_FILTERS);
            this.nullableFiltersAdapter.toJson(jsonWriter, searchResultsRequest.getFilters());
            jsonWriter.name(com.talabat.talabatcommon.feature.darkstores.lookingGlass.UrlConstantsKt.LIMIT);
            this.nullableIntAdapter.toJson(jsonWriter, searchResultsRequest.getLimit());
            jsonWriter.name("offset");
            this.nullableIntAdapter.toJson(jsonWriter, searchResultsRequest.getOffset());
            jsonWriter.name("query");
            this.nullableStringAdapter.toJson(jsonWriter, searchResultsRequest.getQuery());
            jsonWriter.name("customer_id");
            this.stringAdapter.toJson(jsonWriter, searchResultsRequest.getCustomerId());
            jsonWriter.name("talabatBranchId");
            this.nullableStringAdapter.toJson(jsonWriter, searchResultsRequest.getTalabatBranchId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
