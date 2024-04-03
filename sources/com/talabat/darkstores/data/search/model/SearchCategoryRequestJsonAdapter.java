package com.talabat.darkstores.data.search.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.darkstores.data.search.model.SearchCategoryRequest;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.homescreen.network.UrlConstantsKt;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchCategoryRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/search/model/SearchCategoryRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfVendorAdapter", "", "Lcom/talabat/darkstores/data/search/model/SearchCategoryRequest$Vendor;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchCategoryRequestJsonAdapter extends JsonAdapter<SearchCategoryRequest> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @Nullable
    private volatile Constructor<SearchCategoryRequest> constructorRef;
    @NotNull
    private final JsonAdapter<List<SearchCategoryRequest.Vendor>> listOfVendorAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public SearchCategoryRequestJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(DarkstoresMainActivity.CONFIG_EXTRA_KEY, "query", "vendors", UrlConstantsKt.PATH_COUNTRY_CODE, ScreenNames.SCREEN_TYPE_BRAND, "is_darkstore", "language_code");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"config\", \"query\", \"v…kstore\", \"language_code\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(),\n      \"config\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "query");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…     emptySet(), \"query\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<List<SearchCategoryRequest.Vendor>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, SearchCategoryRequest.Vendor.class), SetsKt__SetsKt.emptySet(), "vendors");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…), emptySet(), \"vendors\")");
        this.listOfVendorAdapter = adapter3;
        JsonAdapter<Boolean> adapter4 = moshi.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "isDarkstore");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Boolean::c…t(),\n      \"isDarkstore\")");
        this.booleanAdapter = adapter4;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SearchCategoryRequest");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e3, code lost:
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e5, code lost:
        r11 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e7, code lost:
        r4 = r18;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.darkstores.data.search.model.SearchCategoryRequest fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r33) {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r33.beginObject()
            r3 = -1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
        L_0x0014:
            boolean r10 = r33.hasNext()
            java.lang.String r12 = "language_code"
            java.lang.String r13 = "languageCode"
            java.lang.String r14 = "is_darkstore"
            java.lang.String r15 = "isDarkstore"
            java.lang.String r2 = "country_code"
            r16 = r6
            java.lang.String r6 = "countryCode"
            r17 = r11
            java.lang.String r11 = "brand"
            r18 = r4
            java.lang.String r4 = "config"
            if (r10 == 0) goto L_0x00eb
            com.squareup.moshi.JsonReader$Options r10 = r0.options
            int r10 = r1.selectName(r10)
            switch(r10) {
                case -1: goto L_0x00dd;
                case 0: goto L_0x00c6;
                case 1: goto L_0x00ba;
                case 2: goto L_0x009e;
                case 3: goto L_0x0087;
                case 4: goto L_0x0070;
                case 5: goto L_0x0055;
                case 6: goto L_0x003b;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x00e3
        L_0x003b:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x004a
            r6 = r16
            goto L_0x00e7
        L_0x004a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"language… \"language_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0055:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            if (r4 == 0) goto L_0x0065
            r6 = r16
            r11 = r17
            goto L_0x0014
        L_0x0065:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"isDarkst…, \"is_darkstore\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0070:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x007c
            goto L_0x00e3
        L_0x007c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"brand\", …and\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0087:
            com.squareup.moshi.JsonAdapter<java.lang.String> r4 = r0.stringAdapter
            java.lang.Object r4 = r4.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r4
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x0093
            goto L_0x00e3
        L_0x0093:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"countryC…, \"country_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x009e:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.darkstores.data.search.model.SearchCategoryRequest$Vendor>> r2 = r0.listOfVendorAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x00ac
            r3 = r3 & -5
            goto L_0x00e3
        L_0x00ac:
            java.lang.String r2 = "vendors"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"vendors\"…       \"vendors\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00ba:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            r3 = r3 & -3
            goto L_0x00e5
        L_0x00c6:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x00d2
            goto L_0x00e3
        L_0x00d2:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r4, r4, r1)
            java.lang.String r2 = "unexpectedNull(\"config\",…        \"config\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00dd:
            r33.skipName()
            r33.skipValue()
        L_0x00e3:
            r6 = r16
        L_0x00e5:
            r11 = r17
        L_0x00e7:
            r4 = r18
            goto L_0x0014
        L_0x00eb:
            r33.endObject()
            r10 = -7
            java.lang.String r0 = "missingProperty(\"config\", \"config\", reader)"
            if (r3 != r10) goto L_0x0146
            com.talabat.darkstores.data.search.model.SearchCategoryRequest r3 = new com.talabat.darkstores.data.search.model.SearchCategoryRequest
            if (r5 == 0) goto L_0x013e
            if (r7 == 0) goto L_0x0136
            if (r8 == 0) goto L_0x012c
            if (r9 == 0) goto L_0x0122
            if (r18 == 0) goto L_0x0118
            boolean r10 = r18.booleanValue()
            if (r17 == 0) goto L_0x010e
            r4 = r3
            r6 = r16
            r11 = r17
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            return r3
        L_0x010e:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r13, r12, r1)
            java.lang.String r1 = "missingProperty(\"languag…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0118:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r15, r14, r1)
            java.lang.String r1 = "missingProperty(\"isDarks…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0122:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r1 = "missingProperty(\"brand\", \"brand\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x012c:
            com.squareup.moshi.JsonDataException r0 = com.squareup.moshi.internal.Util.missingProperty(r6, r2, r1)
            java.lang.String r1 = "missingProperty(\"country…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            throw r0
        L_0x0136:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.List<com.talabat.darkstores.data.search.model.SearchCategoryRequest.Vendor>"
            r0.<init>(r1)
            throw r0
        L_0x013e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r4, r4, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            throw r1
        L_0x0146:
            r19 = r0
            r0 = r32
            java.lang.reflect.Constructor<com.talabat.darkstores.data.search.model.SearchCategoryRequest> r10 = r0.constructorRef
            r20 = 8
            r21 = 7
            r22 = 6
            r23 = 5
            r24 = 4
            r25 = 3
            r26 = 2
            r27 = 1
            r28 = 0
            r29 = r4
            r4 = 9
            if (r10 != 0) goto L_0x0191
            java.lang.Class[] r10 = new java.lang.Class[r4]
            java.lang.Class<java.lang.String> r30 = java.lang.String.class
            r10[r28] = r30
            r10[r27] = r30
            java.lang.Class<java.util.List> r31 = java.util.List.class
            r10[r26] = r31
            r10[r25] = r30
            r10[r24] = r30
            java.lang.Class r31 = java.lang.Boolean.TYPE
            r10[r23] = r31
            r10[r22] = r30
            java.lang.Class r30 = java.lang.Integer.TYPE
            r10[r21] = r30
            java.lang.Class<?> r30 = com.squareup.moshi.internal.Util.DEFAULT_CONSTRUCTOR_MARKER
            r10[r20] = r30
            java.lang.Class<com.talabat.darkstores.data.search.model.SearchCategoryRequest> r4 = com.talabat.darkstores.data.search.model.SearchCategoryRequest.class
            java.lang.reflect.Constructor r10 = r4.getDeclaredConstructor(r10)
            r0.constructorRef = r10
            java.lang.String r4 = "SearchCategoryRequest::c…his.constructorRef = it }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)
            r4 = 9
        L_0x0191:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            if (r5 == 0) goto L_0x01f0
            r4[r28] = r5
            r4[r27] = r16
            r4[r26] = r7
            if (r8 == 0) goto L_0x01e6
            r4[r25] = r8
            if (r9 == 0) goto L_0x01dc
            r4[r24] = r9
            if (r18 == 0) goto L_0x01d2
            boolean r2 = r18.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4[r23] = r2
            if (r17 == 0) goto L_0x01c8
            r4[r22] = r17
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r4[r21] = r1
            r1 = 0
            r4[r20] = r1
            java.lang.Object r1 = r10.newInstance(r4)
            java.lang.String r2 = "localConstructor.newInst…torMarker */ null\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.talabat.darkstores.data.search.model.SearchCategoryRequest r1 = (com.talabat.darkstores.data.search.model.SearchCategoryRequest) r1
            return r1
        L_0x01c8:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r12, r1)
            java.lang.String r2 = "missingProperty(\"languag… \"language_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01d2:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r14, r1)
            java.lang.String r2 = "missingProperty(\"isDarks…, \"is_darkstore\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01dc:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r2 = "missingProperty(\"brand\", \"brand\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01e6:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r6, r2, r1)
            java.lang.String r2 = "missingProperty(\"country…, \"country_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01f0:
            r2 = r29
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            r2 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.search.model.SearchCategoryRequestJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.darkstores.data.search.model.SearchCategoryRequest");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable SearchCategoryRequest searchCategoryRequest) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (searchCategoryRequest != null) {
            jsonWriter.beginObject();
            jsonWriter.name(DarkstoresMainActivity.CONFIG_EXTRA_KEY);
            this.stringAdapter.toJson(jsonWriter, searchCategoryRequest.getConfig());
            jsonWriter.name("query");
            this.nullableStringAdapter.toJson(jsonWriter, searchCategoryRequest.getQuery());
            jsonWriter.name("vendors");
            this.listOfVendorAdapter.toJson(jsonWriter, searchCategoryRequest.getVendors());
            jsonWriter.name(UrlConstantsKt.PATH_COUNTRY_CODE);
            this.stringAdapter.toJson(jsonWriter, searchCategoryRequest.getCountryCode());
            jsonWriter.name(ScreenNames.SCREEN_TYPE_BRAND);
            this.stringAdapter.toJson(jsonWriter, searchCategoryRequest.getBrand());
            jsonWriter.name("is_darkstore");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(searchCategoryRequest.isDarkstore()));
            jsonWriter.name("language_code");
            this.stringAdapter.toJson(jsonWriter, searchCategoryRequest.getLanguageCode());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
