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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionCancellationReasonsResponseModelJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionCancellationReasonsResponseModel;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableIntAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationReasonsResponseModelJsonAdapter extends JsonAdapter<SubscriptionCancellationReasonsResponseModel> {
    @Nullable
    private volatile Constructor<SubscriptionCancellationReasonsResponseModel> constructorRef;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public SubscriptionCancellationReasonsResponseModelJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("title", "id", "displayOrder");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"title\", \"id\", \"displayOrder\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "title");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…     emptySet(), \"title\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "displayOrder");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…ptySet(), \"displayOrder\")");
        this.nullableIntAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(66);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SubscriptionCancellationReasonsResponseModel");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public SubscriptionCancellationReasonsResponseModel fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        Integer num = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
                i11 &= -2;
            } else if (selectName == 1) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader);
                i11 &= -3;
            } else if (selectName == 2) {
                num = this.nullableIntAdapter.fromJson(jsonReader);
                i11 &= -5;
            }
        }
        jsonReader.endObject();
        if (i11 == -8) {
            return new SubscriptionCancellationReasonsResponseModel(str, str2, num);
        }
        Constructor<SubscriptionCancellationReasonsResponseModel> constructor = this.constructorRef;
        if (constructor == null) {
            Class<String> cls = String.class;
            constructor = SubscriptionCancellationReasonsResponseModel.class.getDeclaredConstructor(new Class[]{cls, cls, Integer.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "SubscriptionCancellation…his.constructorRef = it }");
        }
        SubscriptionCancellationReasonsResponseModel newInstance = constructor.newInstance(new Object[]{str, str2, num, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable SubscriptionCancellationReasonsResponseModel subscriptionCancellationReasonsResponseModel) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (subscriptionCancellationReasonsResponseModel != null) {
            jsonWriter.beginObject();
            jsonWriter.name("title");
            this.nullableStringAdapter.toJson(jsonWriter, subscriptionCancellationReasonsResponseModel.getTitle());
            jsonWriter.name("id");
            this.nullableStringAdapter.toJson(jsonWriter, subscriptionCancellationReasonsResponseModel.getId());
            jsonWriter.name("displayOrder");
            this.nullableIntAdapter.toJson(jsonWriter, subscriptionCancellationReasonsResponseModel.getDisplayOrder());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
