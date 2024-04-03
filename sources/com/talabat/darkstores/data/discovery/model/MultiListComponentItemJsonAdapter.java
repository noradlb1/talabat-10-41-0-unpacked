package com.talabat.darkstores.data.discovery.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/MultiListComponentItemJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/discovery/model/MultiListComponentItem;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfSwimlaneAdapter", "", "Lcom/talabat/darkstores/model/Swimlane;", "nullableListOfNetworkSortOptionAdapter", "Lcom/talabat/darkstores/data/discovery/model/NetworkSortOption;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultiListComponentItemJsonAdapter extends JsonAdapter<MultiListComponentItem> {
    @Nullable
    private volatile Constructor<MultiListComponentItem> constructorRef;
    @NotNull
    private final JsonAdapter<List<Swimlane>> listOfSwimlaneAdapter;
    @NotNull
    private final JsonAdapter<List<NetworkSortOption>> nullableListOfNetworkSortOptionAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public MultiListComponentItemJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("headline", FirebaseAnalytics.Param.ITEMS, FluidHomeScreenViewModel.METADATA_COMPONENT_KEY, "sort_options");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"headline\", \"items\", …t\",\n      \"sort_options\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "headline");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…  emptySet(), \"headline\")");
        this.nullableStringAdapter = adapter;
        Class<List> cls = List.class;
        JsonAdapter<List<Swimlane>> adapter2 = moshi.adapter(Types.newParameterizedType(cls, Swimlane.class), SetsKt__SetsKt.emptySet(), "swimlanes");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…Set(),\n      \"swimlanes\")");
        this.listOfSwimlaneAdapter = adapter2;
        JsonAdapter<List<NetworkSortOption>> adapter3 = moshi.adapter(Types.newParameterizedType(cls, NetworkSortOption.class), SetsKt__SetsKt.emptySet(), "sortOptions");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…mptySet(), \"sortOptions\")");
        this.nullableListOfNetworkSortOptionAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("MultiListComponentItem");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public MultiListComponentItem fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        String str = null;
        List list = null;
        String str2 = null;
        List list2 = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(jsonReader2);
                i11 &= -2;
            } else if (selectName == 1) {
                list = this.listOfSwimlaneAdapter.fromJson(jsonReader2);
                if (list != null) {
                    i11 &= -3;
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull("swimlanes", FirebaseAnalytics.Param.ITEMS, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"swimlanes\", \"items\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 2) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                i11 &= -5;
            } else if (selectName == 3) {
                list2 = this.nullableListOfNetworkSortOptionAdapter.fromJson(jsonReader2);
                i11 &= -9;
            }
        }
        jsonReader.endObject();
        if (i11 != -16) {
            Constructor<MultiListComponentItem> constructor = this.constructorRef;
            if (constructor == null) {
                Class<String> cls = String.class;
                Class<List> cls2 = List.class;
                constructor = MultiListComponentItem.class.getDeclaredConstructor(new Class[]{cls, cls2, cls, cls2, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "MultiListComponentItem::…his.constructorRef = it }");
            }
            MultiListComponentItem newInstance = constructor.newInstance(new Object[]{str, list, str2, list2, Integer.valueOf(i11), null});
            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
            return newInstance;
        } else if (list != null) {
            return new MultiListComponentItem(str, list, str2, list2);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.talabat.darkstores.model.Swimlane>");
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable MultiListComponentItem multiListComponentItem) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (multiListComponentItem != null) {
            jsonWriter.beginObject();
            jsonWriter.name("headline");
            this.nullableStringAdapter.toJson(jsonWriter, multiListComponentItem.getHeadline());
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.listOfSwimlaneAdapter.toJson(jsonWriter, multiListComponentItem.getSwimlanes());
            jsonWriter.name(FluidHomeScreenViewModel.METADATA_COMPONENT_KEY);
            this.nullableStringAdapter.toJson(jsonWriter, multiListComponentItem.getComponent());
            jsonWriter.name("sort_options");
            this.nullableListOfNetworkSortOptionAdapter.toJson(jsonWriter, multiListComponentItem.getSortOptions());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
