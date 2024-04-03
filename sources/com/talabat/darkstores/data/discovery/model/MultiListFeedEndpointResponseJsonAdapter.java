package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.darkstores.model.Category;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "multiListFeedEndpointResponseExtAdapter", "Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponseExt;", "nullableListOfCategoryAdapter", "", "Lcom/talabat/darkstores/model/Category;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultiListFeedEndpointResponseJsonAdapter extends JsonAdapter<MultiListFeedEndpointResponse> {
    @Nullable
    private volatile Constructor<MultiListFeedEndpointResponse> constructorRef;
    @NotNull
    private final JsonAdapter<MultiListFeedEndpointResponseExt> multiListFeedEndpointResponseExtAdapter;
    @NotNull
    private final JsonAdapter<List<Category>> nullableListOfCategoryAdapter;
    @NotNull
    private final JsonReader.Options options;

    public MultiListFeedEndpointResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("category_tree", "feed");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"category_tree\", \"feed\")");
        this.options = of2;
        JsonAdapter<List<Category>> adapter = moshi.adapter(Types.newParameterizedType(List.class, Category.class), SetsKt__SetsKt.emptySet(), "categories");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…et(),\n      \"categories\")");
        this.nullableListOfCategoryAdapter = adapter;
        JsonAdapter<MultiListFeedEndpointResponseExt> adapter2 = moshi.adapter(MultiListFeedEndpointResponseExt.class, SetsKt__SetsKt.emptySet(), "feedItems");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(MultiListF… emptySet(), \"feedItems\")");
        this.multiListFeedEndpointResponseExtAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("MultiListFeedEndpointResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public MultiListFeedEndpointResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        MultiListFeedEndpointResponseExt multiListFeedEndpointResponseExt = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                list = this.nullableListOfCategoryAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                multiListFeedEndpointResponseExt = this.multiListFeedEndpointResponseExtAdapter.fromJson(jsonReader);
                if (multiListFeedEndpointResponseExt != null) {
                    i11 &= -3;
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull("feedItems", "feed", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"feedItems\", \"feed\", reader)");
                    throw unexpectedNull;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (i11 != -3) {
            Constructor<MultiListFeedEndpointResponse> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = MultiListFeedEndpointResponse.class.getDeclaredConstructor(new Class[]{List.class, MultiListFeedEndpointResponseExt.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "MultiListFeedEndpointRes…his.constructorRef = it }");
            }
            MultiListFeedEndpointResponse newInstance = constructor.newInstance(new Object[]{list, multiListFeedEndpointResponseExt, Integer.valueOf(i11), null});
            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
            return newInstance;
        } else if (multiListFeedEndpointResponseExt != null) {
            return new MultiListFeedEndpointResponse(list, multiListFeedEndpointResponseExt);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.darkstores.data.discovery.model.MultiListFeedEndpointResponseExt");
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable MultiListFeedEndpointResponse multiListFeedEndpointResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (multiListFeedEndpointResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("category_tree");
            this.nullableListOfCategoryAdapter.toJson(jsonWriter, multiListFeedEndpointResponse.getCategories());
            jsonWriter.name("feed");
            this.multiListFeedEndpointResponseExtAdapter.toJson(jsonWriter, multiListFeedEndpointResponse.getFeedItems());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
