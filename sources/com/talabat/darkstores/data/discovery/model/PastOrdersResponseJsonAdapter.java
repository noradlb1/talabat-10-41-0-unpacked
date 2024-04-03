package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/PastOrdersResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/discovery/model/PastOrdersResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableListOfProductAdapter", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PastOrdersResponseJsonAdapter extends JsonAdapter<PastOrdersResponse> {
    @Nullable
    private volatile Constructor<PastOrdersResponse> constructorRef;
    @NotNull
    private final JsonAdapter<List<Product>> nullableListOfProductAdapter;
    @NotNull
    private final JsonReader.Options options;

    public PastOrdersResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("data");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"data\")");
        this.options = of2;
        JsonAdapter<List<Product>> adapter = moshi.adapter(Types.newParameterizedType(List.class, Product.class), SetsKt__SetsKt.emptySet(), "products");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…ySet(),\n      \"products\")");
        this.nullableListOfProductAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("PastOrdersResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public PastOrdersResponse fromJson(@NotNull JsonReader jsonReader) {
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
                list = this.nullableListOfProductAdapter.fromJson(jsonReader);
                i11 &= -2;
            }
        }
        jsonReader.endObject();
        if (i11 == -2) {
            return new PastOrdersResponse(list);
        }
        Constructor<PastOrdersResponse> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = PastOrdersResponse.class.getDeclaredConstructor(new Class[]{List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "PastOrdersResponse::clas…his.constructorRef = it }");
        }
        PastOrdersResponse newInstance = constructor.newInstance(new Object[]{list, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable PastOrdersResponse pastOrdersResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (pastOrdersResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("data");
            this.nullableListOfProductAdapter.toJson(jsonWriter, pastOrdersResponse.getProducts());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
