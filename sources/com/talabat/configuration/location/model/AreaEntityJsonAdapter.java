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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/configuration/location/model/AreaEntityJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/configuration/location/model/AreaEntity;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBooleanAdapter", "", "nullableIntAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AreaEntityJsonAdapter extends JsonAdapter<AreaEntity> {
    @Nullable
    private volatile Constructor<AreaEntity> constructorRef;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public AreaEntityJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("id", "pol", "polc", "an", "sl", "cid", "cn", "isGemArea", "ipse", "ids", "im", "itg", "rgrl");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"id\", \"pol\", \"polc\", …ds\", \"im\", \"itg\", \"rgrl\")");
        this.options = of2;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…,\n      emptySet(), \"id\")");
        this.nullableIntAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "areaCenterPointName");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…), \"areaCenterPointName\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "isGemArea");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c… emptySet(), \"isGemArea\")");
        this.nullableBooleanAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AreaEntity");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public AreaEntity fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        Integer num = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Integer num2 = null;
        String str5 = null;
        Boolean bool = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        Boolean bool4 = null;
        Boolean bool5 = null;
        Boolean bool6 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    num = this.nullableIntAdapter.fromJson(jsonReader2);
                    i11 &= -2;
                    break;
                case 1:
                    str = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -3;
                    break;
                case 2:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -5;
                    break;
                case 3:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -9;
                    break;
                case 4:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -17;
                    break;
                case 5:
                    num2 = this.nullableIntAdapter.fromJson(jsonReader2);
                    i11 &= -33;
                    break;
                case 6:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -65;
                    break;
                case 7:
                    bool = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -129;
                    break;
                case 8:
                    bool2 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -257;
                    break;
                case 9:
                    bool3 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -513;
                    break;
                case 10:
                    bool4 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -1025;
                    break;
                case 11:
                    bool5 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -2049;
                    break;
                case 12:
                    bool6 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -4097;
                    break;
            }
        }
        jsonReader.endObject();
        if (i11 == -8192) {
            return new AreaEntity(num, str, str2, str3, str4, num2, str5, bool, bool2, bool3, bool4, bool5, bool6);
        }
        Constructor<AreaEntity> constructor = this.constructorRef;
        if (constructor == null) {
            Class<Integer> cls = Integer.class;
            Class<String> cls2 = String.class;
            Class<Boolean> cls3 = Boolean.class;
            constructor = AreaEntity.class.getDeclaredConstructor(new Class[]{cls, cls2, cls2, cls2, cls2, cls, cls2, cls3, cls3, cls3, cls3, cls3, cls3, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "AreaEntity::class.java.g…his.constructorRef = it }");
        }
        AreaEntity newInstance = constructor.newInstance(new Object[]{num, str, str2, str3, str4, num2, str5, bool, bool2, bool3, bool4, bool5, bool6, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable AreaEntity areaEntity) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (areaEntity != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.nullableIntAdapter.toJson(jsonWriter, areaEntity.getId());
            jsonWriter.name("pol");
            this.nullableStringAdapter.toJson(jsonWriter, areaEntity.getAreaCenterPointName());
            jsonWriter.name("polc");
            this.nullableStringAdapter.toJson(jsonWriter, areaEntity.getAreaCenterPointCoordinates());
            jsonWriter.name("an");
            this.nullableStringAdapter.toJson(jsonWriter, areaEntity.getAreaName());
            jsonWriter.name("sl");
            this.nullableStringAdapter.toJson(jsonWriter, areaEntity.getAreaNotation());
            jsonWriter.name("cid");
            this.nullableIntAdapter.toJson(jsonWriter, areaEntity.getCityId());
            jsonWriter.name("cn");
            this.nullableStringAdapter.toJson(jsonWriter, areaEntity.getCityName());
            jsonWriter.name("isGemArea");
            this.nullableBooleanAdapter.toJson(jsonWriter, areaEntity.isGemArea());
            jsonWriter.name("ipse");
            this.nullableBooleanAdapter.toJson(jsonWriter, areaEntity.isPolygonServiceEnabled());
            jsonWriter.name("ids");
            this.nullableBooleanAdapter.toJson(jsonWriter, areaEntity.get_ids());
            jsonWriter.name("im");
            this.nullableBooleanAdapter.toJson(jsonWriter, areaEntity.get_im());
            jsonWriter.name("itg");
            this.nullableBooleanAdapter.toJson(jsonWriter, areaEntity.get_itg());
            jsonWriter.name("rgrl");
            this.nullableBooleanAdapter.toJson(jsonWriter, areaEntity.get_rgrl());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
