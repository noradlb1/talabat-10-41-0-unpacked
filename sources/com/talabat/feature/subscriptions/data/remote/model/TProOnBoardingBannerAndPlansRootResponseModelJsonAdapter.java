package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.JsonAdapter;
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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingBannerAndPlansRootResponseModelJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingBannerAndPlansRootResponseModel;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableListOfStringAdapter", "", "", "nullableStringAdapter", "nullableTProOnBoardingBannerAndPlanResponseModelAdapter", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingBannerAndPlanResponseModel;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingBannerAndPlansRootResponseModelJsonAdapter extends JsonAdapter<TProOnBoardingBannerAndPlansRootResponseModel> {
    @Nullable
    private volatile Constructor<TProOnBoardingBannerAndPlansRootResponseModel> constructorRef;
    @NotNull
    private final JsonAdapter<List<String>> nullableListOfStringAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonAdapter<TProOnBoardingBannerAndPlanResponseModel> nullableTProOnBoardingBannerAndPlanResponseModelAdapter;
    @NotNull
    private final JsonReader.Options options;

    public TProOnBoardingBannerAndPlansRootResponseModelJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("result", "errorCode", "errors");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"result\", \"errorCode\", \"errors\")");
        this.options = of2;
        JsonAdapter<TProOnBoardingBannerAndPlanResponseModel> adapter = moshi.adapter(TProOnBoardingBannerAndPlanResponseModel.class, SetsKt__SetsKt.emptySet(), "result");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(TProOnBoar…va, emptySet(), \"result\")");
        this.nullableTProOnBoardingBannerAndPlanResponseModelAdapter = adapter;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter2 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "errorCode");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl… emptySet(), \"errorCode\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<List<String>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, cls), SetsKt__SetsKt.emptySet(), "errors");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…ptySet(),\n      \"errors\")");
        this.nullableListOfStringAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(67);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TProOnBoardingBannerAndPlansRootResponseModel");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public TProOnBoardingBannerAndPlansRootResponseModel fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        TProOnBoardingBannerAndPlanResponseModel tProOnBoardingBannerAndPlanResponseModel = null;
        String str = null;
        List list = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                tProOnBoardingBannerAndPlanResponseModel = this.nullableTProOnBoardingBannerAndPlanResponseModelAdapter.fromJson(jsonReader);
                i11 &= -2;
            } else if (selectName == 1) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
                i11 &= -3;
            } else if (selectName == 2) {
                list = this.nullableListOfStringAdapter.fromJson(jsonReader);
                i11 &= -5;
            }
        }
        jsonReader.endObject();
        if (i11 == -8) {
            return new TProOnBoardingBannerAndPlansRootResponseModel(tProOnBoardingBannerAndPlanResponseModel, str, list);
        }
        Constructor<TProOnBoardingBannerAndPlansRootResponseModel> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = TProOnBoardingBannerAndPlansRootResponseModel.class.getDeclaredConstructor(new Class[]{TProOnBoardingBannerAndPlanResponseModel.class, String.class, List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "TProOnBoardingBannerAndP…his.constructorRef = it }");
        }
        TProOnBoardingBannerAndPlansRootResponseModel newInstance = constructor.newInstance(new Object[]{tProOnBoardingBannerAndPlanResponseModel, str, list, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable TProOnBoardingBannerAndPlansRootResponseModel tProOnBoardingBannerAndPlansRootResponseModel) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (tProOnBoardingBannerAndPlansRootResponseModel != null) {
            jsonWriter.beginObject();
            jsonWriter.name("result");
            this.nullableTProOnBoardingBannerAndPlanResponseModelAdapter.toJson(jsonWriter, tProOnBoardingBannerAndPlansRootResponseModel.getResult());
            jsonWriter.name("errorCode");
            this.nullableStringAdapter.toJson(jsonWriter, tProOnBoardingBannerAndPlansRootResponseModel.getErrorCode());
            jsonWriter.name("errors");
            this.nullableListOfStringAdapter.toJson(jsonWriter, tProOnBoardingBannerAndPlansRootResponseModel.getErrors());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
