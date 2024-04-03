package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/ProVendorMovRootResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/subscriptions/data/remote/model/ProVendorMovRootResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableProVendorMovResponseModelAdapter", "Lcom/talabat/feature/subscriptions/data/remote/model/ProVendorMovResponseModel;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProVendorMovRootResponseJsonAdapter extends JsonAdapter<ProVendorMovRootResponse> {
    @Nullable
    private volatile Constructor<ProVendorMovRootResponse> constructorRef;
    @NotNull
    private final JsonAdapter<ProVendorMovResponseModel> nullableProVendorMovResponseModelAdapter;
    @NotNull
    private final JsonReader.Options options;

    public ProVendorMovRootResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("result");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"result\")");
        this.options = of2;
        JsonAdapter<ProVendorMovResponseModel> adapter = moshi.adapter(ProVendorMovResponseModel.class, SetsKt__SetsKt.emptySet(), "result");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(ProVendorM…va, emptySet(), \"result\")");
        this.nullableProVendorMovResponseModelAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ProVendorMovRootResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public ProVendorMovRootResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        ProVendorMovResponseModel proVendorMovResponseModel = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                proVendorMovResponseModel = this.nullableProVendorMovResponseModelAdapter.fromJson(jsonReader);
                i11 &= -2;
            }
        }
        jsonReader.endObject();
        if (i11 == -2) {
            return new ProVendorMovRootResponse(proVendorMovResponseModel);
        }
        Constructor<ProVendorMovRootResponse> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = ProVendorMovRootResponse.class.getDeclaredConstructor(new Class[]{ProVendorMovResponseModel.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "ProVendorMovRootResponse…his.constructorRef = it }");
        }
        ProVendorMovRootResponse newInstance = constructor.newInstance(new Object[]{proVendorMovResponseModel, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable ProVendorMovRootResponse proVendorMovRootResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (proVendorMovRootResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("result");
            this.nullableProVendorMovResponseModelAdapter.toJson(jsonWriter, proVendorMovRootResponse.getResult());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
