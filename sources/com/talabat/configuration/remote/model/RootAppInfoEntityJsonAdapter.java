package com.talabat.configuration.remote.model;

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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/configuration/remote/model/RootAppInfoEntityJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/configuration/remote/model/RootAppInfoEntity;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableAppInfoEntityAdapter", "Lcom/talabat/configuration/remote/model/AppInfoEntity;", "nullableAppInfoScreenTypeAdapter", "Lcom/talabat/configuration/remote/model/AppInfoScreenType;", "nullableBooleanAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RootAppInfoEntityJsonAdapter extends JsonAdapter<RootAppInfoEntity> {
    @Nullable
    private volatile Constructor<RootAppInfoEntity> constructorRef;
    @NotNull
    private final JsonAdapter<AppInfoEntity> nullableAppInfoEntityAdapter;
    @NotNull
    private final JsonAdapter<AppInfoScreenType> nullableAppInfoScreenTypeAdapter;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public RootAppInfoEntityJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("appInfoResponse", "isFirstInstall", "isLoggedIn", "screenType", "isForceUpdate", "forceUpdateMsg", "isCountryDetected", "isShowAd");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"appInfoResponse\",\n  …tryDetected\", \"isShowAd\")");
        this.options = of2;
        JsonAdapter<AppInfoEntity> adapter = moshi.adapter(AppInfoEntity.class, SetsKt__SetsKt.emptySet(), "appInfoEntity");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(AppInfoEnt…tySet(), \"appInfoEntity\")");
        this.nullableAppInfoEntityAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "isFirstInstall");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…ySet(), \"isFirstInstall\")");
        this.nullableBooleanAdapter = adapter2;
        JsonAdapter<AppInfoScreenType> adapter3 = moshi.adapter(AppInfoScreenType.class, SetsKt__SetsKt.emptySet(), "screenType");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(AppInfoScr…emptySet(), \"screenType\")");
        this.nullableAppInfoScreenTypeAdapter = adapter3;
        JsonAdapter<String> adapter4 = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "forceUpdateMsg");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(String::cl…ySet(), \"forceUpdateMsg\")");
        this.nullableStringAdapter = adapter4;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(39);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("RootAppInfoEntity");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public RootAppInfoEntity fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        AppInfoEntity appInfoEntity = null;
        Boolean bool = null;
        Boolean bool2 = null;
        AppInfoScreenType appInfoScreenType = null;
        Boolean bool3 = null;
        String str = null;
        Boolean bool4 = null;
        Boolean bool5 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    appInfoEntity = this.nullableAppInfoEntityAdapter.fromJson(jsonReader2);
                    i11 &= -2;
                    break;
                case 1:
                    bool = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -3;
                    break;
                case 2:
                    bool2 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -5;
                    break;
                case 3:
                    appInfoScreenType = this.nullableAppInfoScreenTypeAdapter.fromJson(jsonReader2);
                    i11 &= -9;
                    break;
                case 4:
                    bool3 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -17;
                    break;
                case 5:
                    str = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -33;
                    break;
                case 6:
                    bool4 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -65;
                    break;
                case 7:
                    bool5 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -129;
                    break;
            }
        }
        jsonReader.endObject();
        if (i11 == -256) {
            return new RootAppInfoEntity(appInfoEntity, bool, bool2, appInfoScreenType, bool3, str, bool4, bool5);
        }
        Constructor<RootAppInfoEntity> constructor = this.constructorRef;
        if (constructor == null) {
            Class<Boolean> cls = Boolean.class;
            constructor = RootAppInfoEntity.class.getDeclaredConstructor(new Class[]{AppInfoEntity.class, cls, cls, AppInfoScreenType.class, cls, String.class, cls, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "RootAppInfoEntity::class…his.constructorRef = it }");
        }
        RootAppInfoEntity newInstance = constructor.newInstance(new Object[]{appInfoEntity, bool, bool2, appInfoScreenType, bool3, str, bool4, bool5, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable RootAppInfoEntity rootAppInfoEntity) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (rootAppInfoEntity != null) {
            jsonWriter.beginObject();
            jsonWriter.name("appInfoResponse");
            this.nullableAppInfoEntityAdapter.toJson(jsonWriter, rootAppInfoEntity.getAppInfoEntity());
            jsonWriter.name("isFirstInstall");
            this.nullableBooleanAdapter.toJson(jsonWriter, rootAppInfoEntity.isFirstInstall());
            jsonWriter.name("isLoggedIn");
            this.nullableBooleanAdapter.toJson(jsonWriter, rootAppInfoEntity.isLoggedIn());
            jsonWriter.name("screenType");
            this.nullableAppInfoScreenTypeAdapter.toJson(jsonWriter, rootAppInfoEntity.getScreenType());
            jsonWriter.name("isForceUpdate");
            this.nullableBooleanAdapter.toJson(jsonWriter, rootAppInfoEntity.isForceUpdate());
            jsonWriter.name("forceUpdateMsg");
            this.nullableStringAdapter.toJson(jsonWriter, rootAppInfoEntity.getForceUpdateMsg());
            jsonWriter.name("isCountryDetected");
            this.nullableBooleanAdapter.toJson(jsonWriter, rootAppInfoEntity.isCountryDetected());
            jsonWriter.name("isShowAd");
            this.nullableBooleanAdapter.toJson(jsonWriter, rootAppInfoEntity.isShowAd());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
