package com.talabat.configuration.areas.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/configuration/areas/model/Area2JsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/configuration/areas/model/Area2;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBooleanAdapter", "", "nullableIntAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Area2JsonAdapter extends JsonAdapter<Area2> {
    @Nullable
    private volatile Constructor<Area2> constructorRef;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public Area2JsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("area_id", "area_name", ConstantsKt.ADJUST_CITY_ID, TLifeNavigationActions.EXTRA_VENDOR_FILTER_CURRENT_CITY, "country_id", "polygon_center", "polygon_enabled");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"area_id\", \"area_name…nter\", \"polygon_enabled\")");
        this.options = of2;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "areaId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…    emptySet(), \"areaId\")");
        this.nullableIntAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "areaName");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…  emptySet(), \"areaName\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "polygonEnabled");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…ySet(), \"polygonEnabled\")");
        this.nullableBooleanAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(27);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Area2");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public Area2 fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        Integer num = null;
        String str = null;
        Integer num2 = null;
        String str2 = null;
        Integer num3 = null;
        String str3 = null;
        Boolean bool = null;
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
                    num2 = this.nullableIntAdapter.fromJson(jsonReader2);
                    i11 &= -5;
                    break;
                case 3:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -9;
                    break;
                case 4:
                    num3 = this.nullableIntAdapter.fromJson(jsonReader2);
                    i11 &= -17;
                    break;
                case 5:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -33;
                    break;
                case 6:
                    bool = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -65;
                    break;
            }
        }
        jsonReader.endObject();
        if (i11 == -128) {
            return new Area2(num, str, num2, str2, num3, str3, bool);
        }
        Constructor<Area2> constructor = this.constructorRef;
        if (constructor == null) {
            Class<Integer> cls = Integer.class;
            Class<String> cls2 = String.class;
            constructor = Area2.class.getDeclaredConstructor(new Class[]{cls, cls2, cls, cls2, cls, cls2, Boolean.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "Area2::class.java.getDec…his.constructorRef = it }");
        }
        Area2 newInstance = constructor.newInstance(new Object[]{num, str, num2, str2, num3, str3, bool, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Area2 area2) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (area2 != null) {
            jsonWriter.beginObject();
            jsonWriter.name("area_id");
            this.nullableIntAdapter.toJson(jsonWriter, area2.getAreaId());
            jsonWriter.name("area_name");
            this.nullableStringAdapter.toJson(jsonWriter, area2.getAreaName());
            jsonWriter.name(ConstantsKt.ADJUST_CITY_ID);
            this.nullableIntAdapter.toJson(jsonWriter, area2.getCityId());
            jsonWriter.name(TLifeNavigationActions.EXTRA_VENDOR_FILTER_CURRENT_CITY);
            this.nullableStringAdapter.toJson(jsonWriter, area2.getCityName());
            jsonWriter.name("country_id");
            this.nullableIntAdapter.toJson(jsonWriter, area2.getCountryId());
            jsonWriter.name("polygon_center");
            this.nullableStringAdapter.toJson(jsonWriter, area2.getPolygonCenter());
            jsonWriter.name("polygon_enabled");
            this.nullableBooleanAdapter.toJson(jsonWriter, area2.getPolygonEnabled());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
