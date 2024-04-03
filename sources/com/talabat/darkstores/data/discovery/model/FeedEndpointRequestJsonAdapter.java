package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTrackerKt;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.homescreen.network.UrlConstantsKt;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplOrderPaymentFailureEventKt;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010*\u001a\u00020\u001cH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00130\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "intAdapter", "", "locationAdapter", "Lcom/talabat/darkstores/data/discovery/model/Location;", "nullableBooleanAdapter", "nullableExpeditionTypesAdapter", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$ExpeditionTypes;", "nullableIntAdapter", "nullableListOfComponentTypesAdapter", "", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$ComponentTypes;", "nullableListOfFieldsTypesAdapter", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$FieldsTypes;", "nullablePageTypeAdapter", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$PageType;", "nullablePlatformAdapter", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$Platform;", "nullableStringAdapter", "", "nullableVerticalTypesAdapter", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$VerticalTypes;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeedEndpointRequestJsonAdapter extends JsonAdapter<FeedEndpointRequest> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @Nullable
    private volatile Constructor<FeedEndpointRequest> constructorRef;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<Location> locationAdapter;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<FeedEndpointRequest.ExpeditionTypes> nullableExpeditionTypesAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<List<FeedEndpointRequest.ComponentTypes>> nullableListOfComponentTypesAdapter;
    @NotNull
    private final JsonAdapter<List<FeedEndpointRequest.FieldsTypes>> nullableListOfFieldsTypesAdapter;
    @NotNull
    private final JsonAdapter<FeedEndpointRequest.PageType> nullablePageTypeAdapter;
    @NotNull
    private final JsonAdapter<FeedEndpointRequest.Platform> nullablePlatformAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonAdapter<FeedEndpointRequest.VerticalTypes> nullableVerticalTypesAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public FeedEndpointRequestJsonAdapter(@NotNull Moshi moshi) {
        Moshi moshi2 = moshi;
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("q", "oq", "save_query", UrlConstantsKt.PATH_COUNTRY_CODE, "language_code", "language_id", ScreenNames.SCREEN_TYPE_BRAND, "vendor_id", OPNavigatorActions.ARG_BRANCH_ID, "customer_id", "session_id", "category_id", DarkstoresMainActivity.CONFIG_EXTRA_KEY, com.talabat.talabatcommon.feature.darkstores.lookingGlass.UrlConstantsKt.LIMIT, "offset", "location", "include_fields", "include_component_types", "platform", "vertical_type", "expedition_type", "is_darkstore", "product_tag", "complete_query", "page_name", "design_variant", "search_variant", "sorting_strategy", "show_age_restricted_items", "chain_id", "mission_control", "sort");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"q\", \"oq\", \"save_quer…mission_control\", \"sort\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi2.adapter(cls, SetsKt__SetsKt.emptySet(), "query");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…     emptySet(), \"query\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi2.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "saveQuery");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c… emptySet(), \"saveQuery\")");
        this.nullableBooleanAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi2.adapter(cls, SetsKt__SetsKt.emptySet(), "countryCode");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl…t(),\n      \"countryCode\")");
        this.stringAdapter = adapter3;
        JsonAdapter<Integer> adapter4 = moshi2.adapter(Integer.class, SetsKt__SetsKt.emptySet(), com.talabat.talabatcommon.feature.darkstores.lookingGlass.UrlConstantsKt.LIMIT);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Int::class…     emptySet(), \"limit\")");
        this.nullableIntAdapter = adapter4;
        JsonAdapter<Location> adapter5 = moshi2.adapter(Location.class, SetsKt__SetsKt.emptySet(), "location");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Location::…  emptySet(), \"location\")");
        this.locationAdapter = adapter5;
        Class<List> cls2 = List.class;
        JsonAdapter<List<FeedEndpointRequest.FieldsTypes>> adapter6 = moshi2.adapter(Types.newParameterizedType(cls2, FeedEndpointRequest.FieldsTypes.class), SetsKt__SetsKt.emptySet(), "includeFields");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Types.newP…tySet(), \"includeFields\")");
        this.nullableListOfFieldsTypesAdapter = adapter6;
        JsonAdapter<List<FeedEndpointRequest.ComponentTypes>> adapter7 = moshi2.adapter(Types.newParameterizedType(cls2, FeedEndpointRequest.ComponentTypes.class), SetsKt__SetsKt.emptySet(), "includeComponentTypes");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Types.newP… \"includeComponentTypes\")");
        this.nullableListOfComponentTypesAdapter = adapter7;
        JsonAdapter<FeedEndpointRequest.Platform> adapter8 = moshi2.adapter(FeedEndpointRequest.Platform.class, SetsKt__SetsKt.emptySet(), "platform");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(FeedEndpoi…, emptySet(), \"platform\")");
        this.nullablePlatformAdapter = adapter8;
        JsonAdapter<FeedEndpointRequest.VerticalTypes> adapter9 = moshi2.adapter(FeedEndpointRequest.VerticalTypes.class, SetsKt__SetsKt.emptySet(), "verticalType");
        Intrinsics.checkNotNullExpressionValue(adapter9, "moshi.adapter(FeedEndpoi…ptySet(), \"verticalType\")");
        this.nullableVerticalTypesAdapter = adapter9;
        JsonAdapter<FeedEndpointRequest.ExpeditionTypes> adapter10 = moshi2.adapter(FeedEndpointRequest.ExpeditionTypes.class, SetsKt__SetsKt.emptySet(), BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_EXPEDITION_TYPE);
        Intrinsics.checkNotNullExpressionValue(adapter10, "moshi.adapter(FeedEndpoi…ySet(), \"expeditionType\")");
        this.nullableExpeditionTypesAdapter = adapter10;
        JsonAdapter<FeedEndpointRequest.PageType> adapter11 = moshi2.adapter(FeedEndpointRequest.PageType.class, SetsKt__SetsKt.emptySet(), SwimlanesTrackerKt.PAGE_TYPE);
        Intrinsics.checkNotNullExpressionValue(adapter11, "moshi.adapter(FeedEndpoi…, emptySet(), \"pageType\")");
        this.nullablePageTypeAdapter = adapter11;
        JsonAdapter<Integer> adapter12 = moshi2.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "designVariant");
        Intrinsics.checkNotNullExpressionValue(adapter12, "moshi.adapter(Int::class…),\n      \"designVariant\")");
        this.intAdapter = adapter12;
        JsonAdapter<Boolean> adapter13 = moshi2.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "showAgeRestrictedItems");
        Intrinsics.checkNotNullExpressionValue(adapter13, "moshi.adapter(Boolean::c…\"showAgeRestrictedItems\")");
        this.booleanAdapter = adapter13;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FeedEndpointRequest");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01a8, code lost:
        r8 = r8 & r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02d9, code lost:
        r6 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02db, code lost:
        r7 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x02dd, code lost:
        r15 = r42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x02df, code lost:
        r12 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02e1, code lost:
        r11 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02e3, code lost:
        r10 = r45;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.darkstores.data.discovery.model.FeedEndpointRequest fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r61) {
        /*
            r60 = this;
            r0 = r60
            r1 = r61
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r61.beginObject()
            r6 = -1
            r7 = r4
            r8 = r6
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r4 = r3
            r6 = r4
        L_0x004a:
            boolean r9 = r61.hasNext()
            java.lang.String r5 = "vendor_id"
            java.lang.String r2 = "vendorId"
            r42 = r15
            java.lang.String r15 = "language_code"
            r43 = r12
            java.lang.String r12 = "languageCode"
            r44 = r11
            java.lang.String r11 = "country_code"
            r45 = r10
            java.lang.String r10 = "countryCode"
            r38 = r7
            java.lang.String r7 = "location"
            r37 = r6
            java.lang.String r6 = "brand"
            if (r9 == 0) goto L_0x02e8
            com.squareup.moshi.JsonReader$Options r9 = r0.options
            int r9 = r1.selectName(r9)
            switch(r9) {
                case -1: goto L_0x02d3;
                case 0: goto L_0x02bd;
                case 1: goto L_0x02a9;
                case 2: goto L_0x0297;
                case 3: goto L_0x0280;
                case 4: goto L_0x0269;
                case 5: goto L_0x0258;
                case 6: goto L_0x023f;
                case 7: goto L_0x0226;
                case 8: goto L_0x0218;
                case 9: goto L_0x020a;
                case 10: goto L_0x01fc;
                case 11: goto L_0x01ee;
                case 12: goto L_0x01e0;
                case 13: goto L_0x01d2;
                case 14: goto L_0x01c4;
                case 15: goto L_0x01ab;
                case 16: goto L_0x019b;
                case 17: goto L_0x018d;
                case 18: goto L_0x017f;
                case 19: goto L_0x0171;
                case 20: goto L_0x0163;
                case 21: goto L_0x0155;
                case 22: goto L_0x0147;
                case 23: goto L_0x0139;
                case 24: goto L_0x012a;
                case 25: goto L_0x010b;
                case 26: goto L_0x00ec;
                case 27: goto L_0x00ca;
                case 28: goto L_0x00a6;
                case 29: goto L_0x0097;
                case 30: goto L_0x0088;
                case 31: goto L_0x0079;
                default: goto L_0x0077;
            }
        L_0x0077:
            goto L_0x02d9
        L_0x0079:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r41 = r2
            java.lang.String r41 = (java.lang.String) r41
            r2 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x01a8
        L_0x0088:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r40 = r2
            java.lang.String r40 = (java.lang.String) r40
            r2 = -1073741825(0xffffffffbfffffff, float:-1.9999999)
            goto L_0x01a8
        L_0x0097:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.nullableIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r39 = r2
            java.lang.Integer r39 = (java.lang.Integer) r39
            r2 = -536870913(0xffffffffdfffffff, float:-3.6893486E19)
            goto L_0x01a8
        L_0x00a6:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.booleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            if (r7 == 0) goto L_0x00b9
            r2 = -268435457(0xffffffffefffffff, float:-1.5845632E29)
            r8 = r8 & r2
            r6 = r37
            goto L_0x02dd
        L_0x00b9:
            java.lang.String r2 = "showAgeRestrictedItems"
            java.lang.String r3 = "show_age_restricted_items"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"showAgeR…s\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00ca:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L_0x00db
            r2 = -134217729(0xfffffffff7ffffff, float:-1.0384593E34)
            r8 = r8 & r2
            goto L_0x02db
        L_0x00db:
            java.lang.String r2 = "sortingStrategy"
            java.lang.String r3 = "sorting_strategy"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"sortingS…orting_strategy\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00ec:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 == 0) goto L_0x00fc
            r2 = -67108865(0xfffffffffbffffff, float:-2.6584558E36)
            goto L_0x01a8
        L_0x00fc:
            java.lang.String r2 = "searchVariant"
            java.lang.String r3 = "search_variant"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"searchVa…\"search_variant\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x010b:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r3 = r2
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x011b
            r2 = -33554433(0xfffffffffdffffff, float:-4.2535293E37)
            goto L_0x01a8
        L_0x011b:
            java.lang.String r2 = "designVariant"
            java.lang.String r3 = "design_variant"
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"designVa…\"design_variant\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x012a:
            com.squareup.moshi.JsonAdapter<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$PageType> r2 = r0.nullablePageTypeAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r34 = r2
            com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$PageType r34 = (com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.PageType) r34
            r2 = -16777217(0xfffffffffeffffff, float:-1.7014117E38)
            goto L_0x01a8
        L_0x0139:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.nullableBooleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r33 = r2
            java.lang.Boolean r33 = (java.lang.Boolean) r33
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            goto L_0x01a8
        L_0x0147:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r32 = r2
            java.lang.String r32 = (java.lang.String) r32
            r2 = -4194305(0xffffffffffbfffff, float:NaN)
            goto L_0x01a8
        L_0x0155:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.nullableBooleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r31 = r2
            java.lang.Boolean r31 = (java.lang.Boolean) r31
            r2 = -2097153(0xffffffffffdfffff, float:NaN)
            goto L_0x01a8
        L_0x0163:
            com.squareup.moshi.JsonAdapter<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$ExpeditionTypes> r2 = r0.nullableExpeditionTypesAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r30 = r2
            com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$ExpeditionTypes r30 = (com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.ExpeditionTypes) r30
            r2 = -1048577(0xffffffffffefffff, float:NaN)
            goto L_0x01a8
        L_0x0171:
            com.squareup.moshi.JsonAdapter<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$VerticalTypes> r2 = r0.nullableVerticalTypesAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r29 = r2
            com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$VerticalTypes r29 = (com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.VerticalTypes) r29
            r2 = -524289(0xfffffffffff7ffff, float:NaN)
            goto L_0x01a8
        L_0x017f:
            com.squareup.moshi.JsonAdapter<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$Platform> r2 = r0.nullablePlatformAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r28 = r2
            com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$Platform r28 = (com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.Platform) r28
            r2 = -262145(0xfffffffffffbffff, float:NaN)
            goto L_0x01a8
        L_0x018d:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$ComponentTypes>> r2 = r0.nullableListOfComponentTypesAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r27 = r2
            java.util.List r27 = (java.util.List) r27
            r2 = -131073(0xfffffffffffdffff, float:NaN)
            goto L_0x01a8
        L_0x019b:
            com.squareup.moshi.JsonAdapter<java.util.List<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$FieldsTypes>> r2 = r0.nullableListOfFieldsTypesAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r26 = r2
            java.util.List r26 = (java.util.List) r26
            r2 = -65537(0xfffffffffffeffff, float:NaN)
        L_0x01a8:
            r8 = r8 & r2
            goto L_0x02d9
        L_0x01ab:
            com.squareup.moshi.JsonAdapter<com.talabat.darkstores.data.discovery.model.Location> r2 = r0.locationAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r25 = r2
            com.talabat.darkstores.data.discovery.model.Location r25 = (com.talabat.darkstores.data.discovery.model.Location) r25
            if (r25 == 0) goto L_0x01b9
            goto L_0x02d9
        L_0x01b9:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r7, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"location…      \"location\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x01c4:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.nullableIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r24 = r2
            java.lang.Integer r24 = (java.lang.Integer) r24
            r8 = r8 & -16385(0xffffffffffffbfff, float:NaN)
            goto L_0x02d9
        L_0x01d2:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.nullableIntAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r23 = r2
            java.lang.Integer r23 = (java.lang.Integer) r23
            r8 = r8 & -8193(0xffffffffffffdfff, float:NaN)
            goto L_0x02d9
        L_0x01e0:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r22 = r2
            java.lang.String r22 = (java.lang.String) r22
            r8 = r8 & -4097(0xffffffffffffefff, float:NaN)
            goto L_0x02d9
        L_0x01ee:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r21 = r2
            java.lang.String r21 = (java.lang.String) r21
            r8 = r8 & -2049(0xfffffffffffff7ff, float:NaN)
            goto L_0x02d9
        L_0x01fc:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r20 = r2
            java.lang.String r20 = (java.lang.String) r20
            r8 = r8 & -1025(0xfffffffffffffbff, float:NaN)
            goto L_0x02d9
        L_0x020a:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r19 = r2
            java.lang.String r19 = (java.lang.String) r19
            r8 = r8 & -513(0xfffffffffffffdff, float:NaN)
            goto L_0x02d9
        L_0x0218:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r18 = r2
            java.lang.String r18 = (java.lang.String) r18
            r8 = r8 & -257(0xfffffffffffffeff, float:NaN)
            goto L_0x02d9
        L_0x0226:
            com.squareup.moshi.JsonAdapter<java.lang.String> r6 = r0.stringAdapter
            java.lang.Object r6 = r6.fromJson((com.squareup.moshi.JsonReader) r1)
            r17 = r6
            java.lang.String r17 = (java.lang.String) r17
            if (r17 == 0) goto L_0x0234
            goto L_0x02d9
        L_0x0234:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r5, r1)
            java.lang.String r2 = "unexpectedNull(\"vendorId…     \"vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x023f:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r2
            java.lang.String r16 = (java.lang.String) r16
            if (r16 == 0) goto L_0x024d
            goto L_0x02d9
        L_0x024d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r6, r6, r1)
            java.lang.String r2 = "unexpectedNull(\"brand\", …and\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0258:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
            r8 = r8 & -33
            r6 = r37
            r7 = r38
            goto L_0x02df
        L_0x0269:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            java.lang.String r14 = (java.lang.String) r14
            if (r14 == 0) goto L_0x0275
            goto L_0x02d9
        L_0x0275:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"language… \"language_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0280:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            java.lang.String r13 = (java.lang.String) r13
            if (r13 == 0) goto L_0x028c
            goto L_0x02d9
        L_0x028c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"countryC…, \"country_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0297:
            com.squareup.moshi.JsonAdapter<java.lang.Boolean> r2 = r0.nullableBooleanAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            r8 = r8 & -5
            r6 = r37
            r7 = r38
            r15 = r42
            goto L_0x02e1
        L_0x02a9:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            r8 = r8 & -3
            r6 = r37
            r7 = r38
            r15 = r42
            r12 = r43
            goto L_0x02e3
        L_0x02bd:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.nullableStringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            r8 = r8 & -2
            r6 = r37
            r7 = r38
            r15 = r42
            r12 = r43
            r11 = r44
            goto L_0x02e5
        L_0x02d3:
            r61.skipName()
            r61.skipValue()
        L_0x02d9:
            r6 = r37
        L_0x02db:
            r7 = r38
        L_0x02dd:
            r15 = r42
        L_0x02df:
            r12 = r43
        L_0x02e1:
            r11 = r44
        L_0x02e3:
            r10 = r45
        L_0x02e5:
            r2 = 0
            goto L_0x004a
        L_0x02e8:
            r61.endObject()
            r9 = 32984(0x80d8, float:4.622E-41)
            if (r8 != r9) goto L_0x034b
            com.talabat.darkstores.data.discovery.model.FeedEndpointRequest r8 = new com.talabat.darkstores.data.discovery.model.FeedEndpointRequest
            if (r13 == 0) goto L_0x0341
            if (r14 == 0) goto L_0x0337
            if (r16 == 0) goto L_0x032d
            if (r17 == 0) goto L_0x0323
            if (r25 == 0) goto L_0x0319
            int r35 = r3.intValue()
            int r36 = r4.intValue()
            int r37 = r37.intValue()
            boolean r38 = r38.booleanValue()
            r9 = r8
            r10 = r45
            r11 = r44
            r12 = r43
            r15 = r42
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
            return r8
        L_0x0319:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r2 = "missingProperty(\"location\", \"location\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0323:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r5, r1)
            java.lang.String r2 = "missingProperty(\"vendorId\", \"vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x032d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r2 = "missingProperty(\"brand\", \"brand\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0337:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r15, r1)
            java.lang.String r2 = "missingProperty(\"languag…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0341:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r11, r1)
            java.lang.String r2 = "missingProperty(\"country…e\",\n              reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x034b:
            java.lang.reflect.Constructor<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest> r9 = r0.constructorRef
            r46 = 8
            r47 = 7
            r48 = 6
            r49 = 5
            r50 = 4
            r51 = 3
            r52 = 2
            r53 = 1
            r54 = r10
            r10 = 34
            if (r9 != 0) goto L_0x0408
            java.lang.Class[] r9 = new java.lang.Class[r10]
            java.lang.Class<java.lang.String> r55 = java.lang.String.class
            r36 = 0
            r9[r36] = r55
            r9[r53] = r55
            java.lang.Class<java.lang.Boolean> r56 = java.lang.Boolean.class
            r9[r52] = r56
            r9[r51] = r55
            r9[r50] = r55
            r9[r49] = r55
            r9[r48] = r55
            r9[r47] = r55
            r9[r46] = r55
            r57 = 9
            r9[r57] = r55
            r57 = 10
            r9[r57] = r55
            r57 = 11
            r9[r57] = r55
            r57 = 12
            r9[r57] = r55
            r57 = 13
            java.lang.Class<java.lang.Integer> r58 = java.lang.Integer.class
            r9[r57] = r58
            r57 = 14
            r9[r57] = r58
            r57 = 15
            java.lang.Class<com.talabat.darkstores.data.discovery.model.Location> r59 = com.talabat.darkstores.data.discovery.model.Location.class
            r9[r57] = r59
            r57 = 16
            java.lang.Class<java.util.List> r59 = java.util.List.class
            r9[r57] = r59
            r57 = 17
            java.lang.Class<java.util.List> r59 = java.util.List.class
            r9[r57] = r59
            r57 = 18
            java.lang.Class<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$Platform> r59 = com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.Platform.class
            r9[r57] = r59
            r57 = 19
            java.lang.Class<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$VerticalTypes> r59 = com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.VerticalTypes.class
            r9[r57] = r59
            r57 = 20
            java.lang.Class<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$ExpeditionTypes> r59 = com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.ExpeditionTypes.class
            r9[r57] = r59
            r57 = 21
            r9[r57] = r56
            r57 = 22
            r9[r57] = r55
            r57 = 23
            r9[r57] = r56
            r56 = 24
            java.lang.Class<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$PageType> r57 = com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.PageType.class
            r9[r56] = r57
            java.lang.Class r56 = java.lang.Integer.TYPE
            r57 = 25
            r9[r57] = r56
            r57 = 26
            r9[r57] = r56
            r57 = 27
            r9[r57] = r56
            r57 = 28
            java.lang.Class r59 = java.lang.Boolean.TYPE
            r9[r57] = r59
            r57 = 29
            r9[r57] = r58
            r57 = 30
            r9[r57] = r55
            r57 = 31
            r9[r57] = r55
            r55 = 32
            r9[r55] = r56
            r55 = 33
            java.lang.Class<?> r56 = com.squareup.moshi.internal.Util.DEFAULT_CONSTRUCTOR_MARKER
            r9[r55] = r56
            java.lang.Class<com.talabat.darkstores.data.discovery.model.FeedEndpointRequest> r10 = com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.class
            java.lang.reflect.Constructor r9 = r10.getDeclaredConstructor(r9)
            r0.constructorRef = r9
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            java.lang.String r10 = "FeedEndpointRequest::cla…his.constructorRef = it }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            r10 = 34
        L_0x0408:
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r36 = 0
            r10[r36] = r45
            r10[r53] = r44
            r10[r52] = r43
            if (r13 == 0) goto L_0x04c5
            r10[r51] = r13
            if (r14 == 0) goto L_0x04bb
            r10[r50] = r14
            r10[r49] = r42
            if (r16 == 0) goto L_0x04b1
            r10[r48] = r16
            if (r17 == 0) goto L_0x04a7
            r10[r47] = r17
            r10[r46] = r18
            r2 = 9
            r10[r2] = r19
            r2 = 10
            r10[r2] = r20
            r2 = 11
            r10[r2] = r21
            r2 = 12
            r10[r2] = r22
            r2 = 13
            r10[r2] = r23
            r2 = 14
            r10[r2] = r24
            if (r25 == 0) goto L_0x049d
            r1 = 15
            r10[r1] = r25
            r1 = 16
            r10[r1] = r26
            r1 = 17
            r10[r1] = r27
            r1 = 18
            r10[r1] = r28
            r1 = 19
            r10[r1] = r29
            r1 = 20
            r10[r1] = r30
            r1 = 21
            r10[r1] = r31
            r1 = 22
            r10[r1] = r32
            r1 = 23
            r10[r1] = r33
            r1 = 24
            r10[r1] = r34
            r1 = 25
            r10[r1] = r3
            r1 = 26
            r10[r1] = r4
            r1 = 27
            r10[r1] = r37
            r1 = 28
            r10[r1] = r38
            r1 = 29
            r10[r1] = r39
            r1 = 30
            r10[r1] = r40
            r1 = 31
            r10[r1] = r41
            r1 = 32
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            r10[r1] = r2
            r1 = 33
            r2 = 0
            r10[r1] = r2
            java.lang.Object r1 = r9.newInstance(r10)
            java.lang.String r2 = "localConstructor.newInst…torMarker */ null\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.talabat.darkstores.data.discovery.model.FeedEndpointRequest r1 = (com.talabat.darkstores.data.discovery.model.FeedEndpointRequest) r1
            return r1
        L_0x049d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r7, r7, r1)
            java.lang.String r2 = "missingProperty(\"location\", \"location\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x04a7:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r5, r1)
            java.lang.String r2 = "missingProperty(\"vendorId\", \"vendor_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x04b1:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r6, r6, r1)
            java.lang.String r2 = "missingProperty(\"brand\", \"brand\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x04bb:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r15, r1)
            java.lang.String r2 = "missingProperty(\"languag… \"language_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x04c5:
            r2 = r54
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r11, r1)
            java.lang.String r2 = "missingProperty(\"country…, \"country_code\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.discovery.model.FeedEndpointRequestJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.talabat.darkstores.data.discovery.model.FeedEndpointRequest");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable FeedEndpointRequest feedEndpointRequest) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (feedEndpointRequest != null) {
            jsonWriter.beginObject();
            jsonWriter.name("q");
            this.nullableStringAdapter.toJson(jsonWriter, feedEndpointRequest.getQuery());
            jsonWriter.name("oq");
            this.nullableStringAdapter.toJson(jsonWriter, feedEndpointRequest.getOriginalQuery());
            jsonWriter.name("save_query");
            this.nullableBooleanAdapter.toJson(jsonWriter, feedEndpointRequest.getSaveQuery());
            jsonWriter.name(UrlConstantsKt.PATH_COUNTRY_CODE);
            this.stringAdapter.toJson(jsonWriter, feedEndpointRequest.getCountryCode());
            jsonWriter.name("language_code");
            this.stringAdapter.toJson(jsonWriter, feedEndpointRequest.getLanguageCode());
            jsonWriter.name("language_id");
            this.nullableStringAdapter.toJson(jsonWriter, feedEndpointRequest.getLanguageId());
            jsonWriter.name(ScreenNames.SCREEN_TYPE_BRAND);
            this.stringAdapter.toJson(jsonWriter, feedEndpointRequest.getBrand());
            jsonWriter.name("vendor_id");
            this.stringAdapter.toJson(jsonWriter, feedEndpointRequest.getVendorId());
            jsonWriter.name(OPNavigatorActions.ARG_BRANCH_ID);
            this.nullableStringAdapter.toJson(jsonWriter, feedEndpointRequest.getBranchId());
            jsonWriter.name("customer_id");
            this.nullableStringAdapter.toJson(jsonWriter, feedEndpointRequest.getCustomerId());
            jsonWriter.name("session_id");
            this.nullableStringAdapter.toJson(jsonWriter, feedEndpointRequest.getSessionId());
            jsonWriter.name("category_id");
            this.nullableStringAdapter.toJson(jsonWriter, feedEndpointRequest.getCategoryId());
            jsonWriter.name(DarkstoresMainActivity.CONFIG_EXTRA_KEY);
            this.nullableStringAdapter.toJson(jsonWriter, feedEndpointRequest.getConfig());
            jsonWriter.name(com.talabat.talabatcommon.feature.darkstores.lookingGlass.UrlConstantsKt.LIMIT);
            this.nullableIntAdapter.toJson(jsonWriter, feedEndpointRequest.getLimit());
            jsonWriter.name("offset");
            this.nullableIntAdapter.toJson(jsonWriter, feedEndpointRequest.getOffset());
            jsonWriter.name("location");
            this.locationAdapter.toJson(jsonWriter, feedEndpointRequest.getLocation());
            jsonWriter.name("include_fields");
            this.nullableListOfFieldsTypesAdapter.toJson(jsonWriter, feedEndpointRequest.getIncludeFields());
            jsonWriter.name("include_component_types");
            this.nullableListOfComponentTypesAdapter.toJson(jsonWriter, feedEndpointRequest.getIncludeComponentTypes());
            jsonWriter.name("platform");
            this.nullablePlatformAdapter.toJson(jsonWriter, feedEndpointRequest.getPlatform());
            jsonWriter.name("vertical_type");
            this.nullableVerticalTypesAdapter.toJson(jsonWriter, feedEndpointRequest.getVerticalType());
            jsonWriter.name("expedition_type");
            this.nullableExpeditionTypesAdapter.toJson(jsonWriter, feedEndpointRequest.getExpeditionType());
            jsonWriter.name("is_darkstore");
            this.nullableBooleanAdapter.toJson(jsonWriter, feedEndpointRequest.isDarkstore());
            jsonWriter.name("product_tag");
            this.nullableStringAdapter.toJson(jsonWriter, feedEndpointRequest.getProductTag());
            jsonWriter.name("complete_query");
            this.nullableBooleanAdapter.toJson(jsonWriter, feedEndpointRequest.getCompleteQuery());
            jsonWriter.name("page_name");
            this.nullablePageTypeAdapter.toJson(jsonWriter, feedEndpointRequest.getPageType());
            jsonWriter.name("design_variant");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(feedEndpointRequest.getDesignVariant()));
            jsonWriter.name("search_variant");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(feedEndpointRequest.getSearchVariant()));
            jsonWriter.name("sorting_strategy");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(feedEndpointRequest.getSortingStrategy()));
            jsonWriter.name("show_age_restricted_items");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(feedEndpointRequest.getShowAgeRestrictedItems()));
            jsonWriter.name("chain_id");
            this.nullableIntAdapter.toJson(jsonWriter, feedEndpointRequest.getChainId());
            jsonWriter.name("mission_control");
            this.nullableStringAdapter.toJson(jsonWriter, feedEndpointRequest.getMissionControl());
            jsonWriter.name("sort");
            this.nullableStringAdapter.toJson(jsonWriter, feedEndpointRequest.getSort());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
