package com.talabat.darkstores.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.visa.checkout.PurchaseInfo;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/model/SwimlaneJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/model/Swimlane;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfProductAdapter", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "nullableCompactSwimlaneLayoutTypeAdapter", "Lcom/talabat/darkstores/model/CompactSwimlaneLayoutType;", "nullableStringAdapter", "", "nullableSwimlaneTrackingAdapter", "Lcom/talabat/darkstores/model/SwimlaneTracking;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneJsonAdapter extends JsonAdapter<Swimlane> {
    @Nullable
    private volatile Constructor<Swimlane> constructorRef;
    @NotNull
    private final JsonAdapter<List<Product>> listOfProductAdapter;
    @NotNull
    private final JsonAdapter<CompactSwimlaneLayoutType> nullableCompactSwimlaneLayoutTypeAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonAdapter<SwimlaneTracking> nullableSwimlaneTrackingAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public SwimlaneJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("headline", "tag", "compactSwimlaneLayoutType", "id", FirebaseAnalytics.Param.ITEMS, "swimlaneId", PurchaseInfo.REQUEST_ID, "tracking");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"headline\", \"tag\",\n  … \"requestId\", \"tracking\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "headline");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ySet(),\n      \"headline\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "tag");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…\n      emptySet(), \"tag\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<CompactSwimlaneLayoutType> adapter3 = moshi.adapter(CompactSwimlaneLayoutType.class, SetsKt__SetsKt.emptySet(), "compactSwimlaneLayoutType");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(CompactSwi…mpactSwimlaneLayoutType\")");
        this.nullableCompactSwimlaneLayoutTypeAdapter = adapter3;
        JsonAdapter<List<Product>> adapter4 = moshi.adapter(Types.newParameterizedType(List.class, Product.class), SetsKt__SetsKt.emptySet(), "products");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…ySet(),\n      \"products\")");
        this.listOfProductAdapter = adapter4;
        JsonAdapter<SwimlaneTracking> adapter5 = moshi.adapter(SwimlaneTracking.class, SetsKt__SetsKt.emptySet(), "tracking");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(SwimlaneTr…, emptySet(), \"tracking\")");
        this.nullableSwimlaneTrackingAdapter = adapter5;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Swimlane");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public Swimlane fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        String str = null;
        String str2 = null;
        CompactSwimlaneLayoutType compactSwimlaneLayoutType = null;
        String str3 = null;
        List list = null;
        String str4 = null;
        String str5 = null;
        SwimlaneTracking swimlaneTracking = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.stringAdapter.fromJson(jsonReader2);
                    if (str != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("headline", "headline", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"headline…      \"headline\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 2:
                    compactSwimlaneLayoutType = this.nullableCompactSwimlaneLayoutTypeAdapter.fromJson(jsonReader2);
                    i11 &= -5;
                    break;
                case 3:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 4:
                    list = this.listOfProductAdapter.fromJson(jsonReader2);
                    if (list != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("products", FirebaseAnalytics.Param.ITEMS, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"products\", \"items\", reader)");
                        throw unexpectedNull2;
                    }
                case 5:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -33;
                    break;
                case 6:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 7:
                    swimlaneTracking = this.nullableSwimlaneTrackingAdapter.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.endObject();
        if (i11 != -37) {
            String str6 = "missingProperty(\"headline\", \"headline\", reader)";
            Constructor<Swimlane> constructor = this.constructorRef;
            String str7 = "headline";
            int i12 = 10;
            if (constructor == null) {
                Class<String> cls = String.class;
                constructor = Swimlane.class.getDeclaredConstructor(new Class[]{cls, cls, CompactSwimlaneLayoutType.class, cls, List.class, cls, cls, SwimlaneTracking.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "Swimlane::class.java.get…his.constructorRef = it }");
                i12 = 10;
            }
            Object[] objArr = new Object[i12];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = compactSwimlaneLayoutType;
                objArr[3] = str3;
                if (list != null) {
                    objArr[4] = list;
                    objArr[5] = str4;
                    objArr[6] = str5;
                    objArr[7] = swimlaneTracking;
                    objArr[8] = Integer.valueOf(i11);
                    objArr[9] = null;
                    Swimlane newInstance = constructor.newInstance(objArr);
                    Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                    return newInstance;
                }
                JsonDataException missingProperty = Util.missingProperty("products", FirebaseAnalytics.Param.ITEMS, jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"products\", \"items\", reader)");
                throw missingProperty;
            }
            String str8 = str7;
            JsonDataException missingProperty2 = Util.missingProperty(str8, str8, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, str6);
            throw missingProperty2;
        } else if (str == null) {
            JsonDataException missingProperty3 = Util.missingProperty("headline", "headline", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"headline\", \"headline\", reader)");
            throw missingProperty3;
        } else if (list != null) {
            return new Swimlane(str, str2, compactSwimlaneLayoutType, str3, list, str4, str5, swimlaneTracking);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("products", FirebaseAnalytics.Param.ITEMS, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"products\", \"items\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Swimlane swimlane) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (swimlane != null) {
            jsonWriter.beginObject();
            jsonWriter.name("headline");
            this.stringAdapter.toJson(jsonWriter, swimlane.getHeadline());
            jsonWriter.name("tag");
            this.nullableStringAdapter.toJson(jsonWriter, swimlane.getTag());
            jsonWriter.name("compactSwimlaneLayoutType");
            this.nullableCompactSwimlaneLayoutTypeAdapter.toJson(jsonWriter, swimlane.getCompactSwimlaneLayoutType());
            jsonWriter.name("id");
            this.nullableStringAdapter.toJson(jsonWriter, swimlane.getCategoryId());
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.listOfProductAdapter.toJson(jsonWriter, swimlane.getProducts());
            jsonWriter.name("swimlaneId");
            this.nullableStringAdapter.toJson(jsonWriter, swimlane.getSwimlaneId());
            jsonWriter.name(PurchaseInfo.REQUEST_ID);
            this.nullableStringAdapter.toJson(jsonWriter, swimlane.getRequestId());
            jsonWriter.name("tracking");
            this.nullableSwimlaneTrackingAdapter.toJson(jsonWriter, swimlane.getTracking());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
