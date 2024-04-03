package com.talabat.darkstores.data.search.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.talabat.darkstores.data.search.model.Filters;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/data/search/model/FiltersJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/search/model/Filters;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableListOfCategoryAdapter", "", "Lcom/talabat/darkstores/data/search/model/Filters$Category;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersJsonAdapter extends JsonAdapter<Filters> {
    @NotNull
    private final JsonAdapter<List<Filters.Category>> nullableListOfCategoryAdapter;
    @NotNull
    private final JsonReader.Options options;

    public FiltersJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("categories");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"categories\")");
        this.options = of2;
        JsonAdapter<List<Filters.Category>> adapter = moshi.adapter(Types.newParameterizedType(List.class, Filters.Category.class), SetsKt__SetsKt.emptySet(), "categories");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…emptySet(), \"categories\")");
        this.nullableListOfCategoryAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Filters");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public Filters fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                list = this.nullableListOfCategoryAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        return new Filters(list);
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Filters filters) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (filters != null) {
            jsonWriter.beginObject();
            jsonWriter.name("categories");
            this.nullableListOfCategoryAdapter.toJson(jsonWriter, filters.getCategories());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
