package com.talabat.darkstores.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/model/CategorySuggestionJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/model/CategorySuggestion;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "categoryAdapter", "Lcom/talabat/darkstores/model/Category;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategorySuggestionJsonAdapter extends JsonAdapter<CategorySuggestion> {
    @NotNull
    private final JsonAdapter<Category> categoryAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public CategorySuggestionJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("data", "originalSearchQuery");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"data\", \"originalSearchQuery\")");
        this.options = of2;
        JsonAdapter<Category> adapter = moshi.adapter(Category.class, SetsKt__SetsKt.emptySet(), "category");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Category::…  emptySet(), \"category\")");
        this.categoryAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "originalSearchQuery");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…), \"originalSearchQuery\")");
        this.nullableStringAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CategorySuggestion");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public CategorySuggestion fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Category category = null;
        boolean z11 = false;
        String str = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                category = this.categoryAdapter.fromJson(jsonReader);
                if (category == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("category", "data", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"category…          \"data\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
                z11 = true;
            }
        }
        jsonReader.endObject();
        if (category != null) {
            CategorySuggestion categorySuggestion = new CategorySuggestion(category);
            if (z11) {
                categorySuggestion.setOriginalSearchQuery(str);
            }
            return categorySuggestion;
        }
        JsonDataException missingProperty = Util.missingProperty("category", "data", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"category\", \"data\", reader)");
        throw missingProperty;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CategorySuggestion categorySuggestion) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (categorySuggestion != null) {
            jsonWriter.beginObject();
            jsonWriter.name("data");
            this.categoryAdapter.toJson(jsonWriter, categorySuggestion.getCategory());
            jsonWriter.name("originalSearchQuery");
            this.nullableStringAdapter.toJson(jsonWriter, categorySuggestion.getOriginalSearchQuery());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
