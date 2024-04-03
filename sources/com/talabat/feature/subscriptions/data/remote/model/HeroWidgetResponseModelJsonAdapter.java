package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/HeroWidgetResponseModelJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/subscriptions/data/remote/model/HeroWidgetResponseModel;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeroWidgetResponseModelJsonAdapter extends JsonAdapter<HeroWidgetResponseModel> {
    @Nullable
    private volatile Constructor<HeroWidgetResponseModel> constructorRef;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public HeroWidgetResponseModelJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("widgetType", "trackingId");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"widgetType\", \"trackingId\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "widgetType");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…et(),\n      \"widgetType\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "trackingId");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…emptySet(), \"trackingId\")");
        this.nullableStringAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("HeroWidgetResponseModel");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public HeroWidgetResponseModel fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("widgetType", "widgetType", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"widgetTy…    \"widgetType\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader);
                i11 &= -3;
            }
        }
        jsonReader.endObject();
        if (i11 != -3) {
            Constructor<HeroWidgetResponseModel> constructor = this.constructorRef;
            if (constructor == null) {
                Class<String> cls = String.class;
                constructor = HeroWidgetResponseModel.class.getDeclaredConstructor(new Class[]{cls, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "HeroWidgetResponseModel:…his.constructorRef = it }");
            }
            Object[] objArr = new Object[4];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = Integer.valueOf(i11);
                objArr[3] = null;
                HeroWidgetResponseModel newInstance = constructor.newInstance(objArr);
                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException missingProperty = Util.missingProperty("widgetType", "widgetType", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"widgetT…e\", \"widgetType\", reader)");
            throw missingProperty;
        } else if (str != null) {
            return new HeroWidgetResponseModel(str, str2);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("widgetType", "widgetType", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"widgetT…e\", \"widgetType\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable HeroWidgetResponseModel heroWidgetResponseModel) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (heroWidgetResponseModel != null) {
            jsonWriter.beginObject();
            jsonWriter.name("widgetType");
            this.stringAdapter.toJson(jsonWriter, heroWidgetResponseModel.getWidgetType());
            jsonWriter.name("trackingId");
            this.nullableStringAdapter.toJson(jsonWriter, heroWidgetResponseModel.getTrackingId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
