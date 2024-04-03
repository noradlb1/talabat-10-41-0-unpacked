package com.talabat.darkstores.data.search.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.darkstores.data.search.model.SearchCategoryRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchCategoryRequest_VendorJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/search/model/SearchCategoryRequest$Vendor;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchCategoryRequest_VendorJsonAdapter extends JsonAdapter<SearchCategoryRequest.Vendor> {
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public SearchCategoryRequest_VendorJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("id");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"id\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SearchCategoryRequest.Vendor");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public SearchCategoryRequest.Vendor fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (str = this.stringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (str != null) {
            return new SearchCategoryRequest.Vendor(str);
        }
        JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"id\", reader)");
        throw missingProperty;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable SearchCategoryRequest.Vendor vendor) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (vendor != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, vendor.getId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
