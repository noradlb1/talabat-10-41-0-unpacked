package com.talabat.darkstores.data.mission.control.model;

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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/data/mission/control/model/PageInfoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/mission/control/model/PageInfo;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PageInfoJsonAdapter extends JsonAdapter<PageInfo> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonReader.Options options;

    public PageInfoJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("page_number", "last");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"page_number\", \"last\")");
        this.options = of2;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "pageNumber");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…et(),\n      \"pageNumber\")");
        this.intAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "isLast");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…ptySet(),\n      \"isLast\")");
        this.booleanAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("PageInfo");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public PageInfo fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Integer num = null;
        Boolean bool = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                num = this.intAdapter.fromJson(jsonReader);
                if (num == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("pageNumber", "page_number", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"pageNumb…   \"page_number\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (bool = this.booleanAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("isLast", "last", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"isLast\",…ast\",\n            reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (bool != null) {
                return new PageInfo(intValue, bool.booleanValue());
            }
            JsonDataException missingProperty = Util.missingProperty("isLast", "last", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"isLast\", \"last\", reader)");
            throw missingProperty;
        }
        JsonDataException missingProperty2 = Util.missingProperty("pageNumber", "page_number", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"pageNum…\", \"page_number\", reader)");
        throw missingProperty2;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable PageInfo pageInfo) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (pageInfo != null) {
            jsonWriter.beginObject();
            jsonWriter.name("page_number");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(pageInfo.getPageNumber()));
            jsonWriter.name("last");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(pageInfo.isLast()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
