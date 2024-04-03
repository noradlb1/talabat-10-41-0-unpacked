package com.talabat.darkstores.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.visa.checkout.PurchaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/model/SearchSuggestionsResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/model/SearchSuggestionsResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "suggestionsListAdapter", "Lcom/talabat/darkstores/model/SuggestionsList;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchSuggestionsResponseJsonAdapter extends JsonAdapter<SearchSuggestionsResponse> {
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;
    @NotNull
    private final JsonAdapter<SuggestionsList> suggestionsListAdapter;

    public SearchSuggestionsResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("request_id", "suggestions");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"request_id\", \"suggestions\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), PurchaseInfo.REQUEST_ID);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"requestId\")");
        this.stringAdapter = adapter;
        JsonAdapter<SuggestionsList> adapter2 = moshi.adapter(SuggestionsList.class, SetsKt__SetsKt.emptySet(), "suggestions");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Suggestion…mptySet(), \"suggestions\")");
        this.suggestionsListAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SearchSuggestionsResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public SearchSuggestionsResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        SuggestionsList suggestionsList = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(PurchaseInfo.REQUEST_ID, "request_id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"requestI…    \"request_id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (suggestionsList = this.suggestionsListAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("suggestions", "suggestions", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"suggesti…\", \"suggestions\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(PurchaseInfo.REQUEST_ID, "request_id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"requestId\", \"request_id\", reader)");
            throw missingProperty;
        } else if (suggestionsList != null) {
            return new SearchSuggestionsResponse(str, suggestionsList);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("suggestions", "suggestions", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"suggest…ons\",\n            reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable SearchSuggestionsResponse searchSuggestionsResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (searchSuggestionsResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("request_id");
            this.stringAdapter.toJson(jsonWriter, searchSuggestionsResponse.getRequestId());
            jsonWriter.name("suggestions");
            this.suggestionsListAdapter.toJson(jsonWriter, searchSuggestionsResponse.getSuggestions());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
