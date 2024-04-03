package com.talabat.feature.subscriptions.data.remote.model;

import buisnessmodels.FilterEngine;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/ProVendorMovResponseModelJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/subscriptions/data/remote/model/ProVendorMovResponseModel;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBooleanAdapter", "", "nullableFloatAdapter", "", "nullableIntAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProVendorMovResponseModelJsonAdapter extends JsonAdapter<ProVendorMovResponseModel> {
    @Nullable
    private volatile Constructor<ProVendorMovResponseModel> constructorRef;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<Float> nullableFloatAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonReader.Options options;

    public ProVendorMovResponseModelJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(FilterEngine.DEEPLINKSORT.MINIMUMORDERAMOUNT, "branchId", "isTalabatPro");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"mov\", \"branchId\", \"isTalabatPro\")");
        this.options = of2;
        JsonAdapter<Float> adapter = moshi.adapter(Float.class, SetsKt__SetsKt.emptySet(), FilterEngine.DEEPLINKSORT.MINIMUMORDERAMOUNT);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Float::cla…\n      emptySet(), \"mov\")");
        this.nullableFloatAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "branchId");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…  emptySet(), \"branchId\")");
        this.nullableIntAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "isTalabatPro");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…ptySet(), \"isTalabatPro\")");
        this.nullableBooleanAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ProVendorMovResponseModel");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public ProVendorMovResponseModel fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Float f11 = null;
        Integer num = null;
        Boolean bool = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                f11 = this.nullableFloatAdapter.fromJson(jsonReader);
                i11 &= -2;
            } else if (selectName == 1) {
                num = this.nullableIntAdapter.fromJson(jsonReader);
                i11 &= -3;
            } else if (selectName == 2) {
                bool = this.nullableBooleanAdapter.fromJson(jsonReader);
                i11 &= -5;
            }
        }
        jsonReader.endObject();
        if (i11 == -8) {
            return new ProVendorMovResponseModel(f11, num, bool);
        }
        Constructor<ProVendorMovResponseModel> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = ProVendorMovResponseModel.class.getDeclaredConstructor(new Class[]{Float.class, Integer.class, Boolean.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "ProVendorMovResponseMode…his.constructorRef = it }");
        }
        ProVendorMovResponseModel newInstance = constructor.newInstance(new Object[]{f11, num, bool, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable ProVendorMovResponseModel proVendorMovResponseModel) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (proVendorMovResponseModel != null) {
            jsonWriter.beginObject();
            jsonWriter.name(FilterEngine.DEEPLINKSORT.MINIMUMORDERAMOUNT);
            this.nullableFloatAdapter.toJson(jsonWriter, proVendorMovResponseModel.getMov());
            jsonWriter.name("branchId");
            this.nullableIntAdapter.toJson(jsonWriter, proVendorMovResponseModel.getBranchId());
            jsonWriter.name("isTalabatPro");
            this.nullableBooleanAdapter.toJson(jsonWriter, proVendorMovResponseModel.isTalabatPro());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
