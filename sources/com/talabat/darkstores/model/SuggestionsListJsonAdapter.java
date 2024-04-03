package com.talabat.darkstores.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/model/SuggestionsListJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/model/SuggestionsList;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfSearchSuggestionAdapter", "", "Lcom/talabat/darkstores/model/SearchSuggestion;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SuggestionsListJsonAdapter extends JsonAdapter<SuggestionsList> {
    @Nullable
    private volatile Constructor<SuggestionsList> constructorRef;
    @NotNull
    private final JsonAdapter<List<SearchSuggestion>> listOfSearchSuggestionAdapter;
    @NotNull
    private final JsonReader.Options options;

    public SuggestionsListJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"items\")");
        this.options = of2;
        JsonAdapter<List<SearchSuggestion>> adapter = moshi.adapter(Types.newParameterizedType(List.class, SearchSuggestion.class), SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…     emptySet(), \"items\")");
        this.listOfSearchSuggestionAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SuggestionsList");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public SuggestionsList fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                list = this.listOfSearchSuggestionAdapter.fromJson(jsonReader);
                if (list != null) {
                    i11 &= -2;
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull(FirebaseAnalytics.Param.ITEMS, FirebaseAnalytics.Param.ITEMS, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"items\", \"items\", reader)");
                    throw unexpectedNull;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (i11 != -2) {
            Constructor<SuggestionsList> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = SuggestionsList.class.getDeclaredConstructor(new Class[]{List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "SuggestionsList::class.j…his.constructorRef = it }");
            }
            SuggestionsList newInstance = constructor.newInstance(new Object[]{list, Integer.valueOf(i11), null});
            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
            return newInstance;
        } else if (list != null) {
            return new SuggestionsList(list);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.talabat.darkstores.model.SearchSuggestion>");
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable SuggestionsList suggestionsList) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (suggestionsList != null) {
            jsonWriter.beginObject();
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.listOfSearchSuggestionAdapter.toJson(jsonWriter, suggestionsList.getItems());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
