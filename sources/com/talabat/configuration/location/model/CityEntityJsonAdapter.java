package com.talabat.configuration.location.model;

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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/configuration/location/model/CityEntityJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/configuration/location/model/CityEntity;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableIntAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CityEntityJsonAdapter extends JsonAdapter<CityEntity> {
    @Nullable
    private volatile Constructor<CityEntity> constructorRef;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public CityEntityJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("id", "cid", "na");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"id\", \"cid\", \"na\")");
        this.options = of2;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…,\n      emptySet(), \"id\")");
        this.nullableIntAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…      emptySet(), \"name\")");
        this.nullableStringAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CityEntity");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public CityEntity fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Integer num = null;
        Integer num2 = null;
        String str = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                num = this.nullableIntAdapter.fromJson(jsonReader);
                i11 &= -2;
            } else if (selectName == 1) {
                num2 = this.nullableIntAdapter.fromJson(jsonReader);
                i11 &= -3;
            } else if (selectName == 2) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
                i11 &= -5;
            }
        }
        jsonReader.endObject();
        if (i11 == -8) {
            return new CityEntity(num, num2, str);
        }
        Constructor<CityEntity> constructor = this.constructorRef;
        if (constructor == null) {
            Class<Integer> cls = Integer.class;
            constructor = CityEntity.class.getDeclaredConstructor(new Class[]{cls, cls, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "CityEntity::class.java.g…his.constructorRef = it }");
        }
        CityEntity newInstance = constructor.newInstance(new Object[]{num, num2, str, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CityEntity cityEntity) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (cityEntity != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.nullableIntAdapter.toJson(jsonWriter, cityEntity.getId());
            jsonWriter.name("cid");
            this.nullableIntAdapter.toJson(jsonWriter, cityEntity.getCountryId());
            jsonWriter.name("na");
            this.nullableStringAdapter.toJson(jsonWriter, cityEntity.getName());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
