package com.talabat.darkstores.data.search.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.darkstores.data.search.model.SearchResultsRequest;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchResultsRequest_FiltersJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/search/model/SearchResultsRequest$Filters;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "intAdapter", "", "nullableListOfStringAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsRequest_FiltersJsonAdapter extends JsonAdapter<SearchResultsRequest.Filters> {
    @Nullable
    private volatile Constructor<SearchResultsRequest.Filters> constructorRef;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<List<String>> nullableListOfStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public SearchResultsRequest_FiltersJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("category_ids", "variant");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"category_ids\", \"variant\")");
        this.options = of2;
        JsonAdapter<List<String>> adapter = moshi.adapter(Types.newParameterizedType(List.class, String.class), SetsKt__SetsKt.emptySet(), "categoryIds");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…t(),\n      \"categoryIds\")");
        this.nullableListOfStringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "variant");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…a, emptySet(), \"variant\")");
        this.intAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SearchResultsRequest.Filters");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public SearchResultsRequest.Filters fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        Integer num = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                list = this.nullableListOfStringAdapter.fromJson(jsonReader);
                i11 &= -2;
            } else if (selectName == 1 && (num = this.intAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("variant", "variant", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"variant\"…       \"variant\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (i11 != -2) {
            Constructor<SearchResultsRequest.Filters> constructor = this.constructorRef;
            if (constructor == null) {
                Class cls = Integer.TYPE;
                constructor = SearchResultsRequest.Filters.class.getDeclaredConstructor(new Class[]{List.class, cls, cls, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "SearchResultsRequest.Fil…his.constructorRef = it }");
            }
            Object[] objArr = new Object[4];
            objArr[0] = list;
            if (num != null) {
                objArr[1] = Integer.valueOf(num.intValue());
                objArr[2] = Integer.valueOf(i11);
                objArr[3] = null;
                SearchResultsRequest.Filters newInstance = constructor.newInstance(objArr);
                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException missingProperty = Util.missingProperty("variant", "variant", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"variant\", \"variant\", reader)");
            throw missingProperty;
        } else if (num != null) {
            return new SearchResultsRequest.Filters(list, num.intValue());
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("variant", "variant", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"variant\", \"variant\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable SearchResultsRequest.Filters filters) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (filters != null) {
            jsonWriter.beginObject();
            jsonWriter.name("category_ids");
            this.nullableListOfStringAdapter.toJson(jsonWriter, filters.getCategoryIds());
            jsonWriter.name("variant");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(filters.getVariant()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
