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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/configuration/remote/model/NewAppVersionEntityJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/configuration/remote/model/NewAppVersionEntity;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBooleanAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewAppVersionEntityJsonAdapter extends JsonAdapter<NewAppVersionEntity> {
    @Nullable
    private volatile Constructor<NewAppVersionEntity> constructorRef;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public NewAppVersionEntityJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("msg", "message", "ver", "version", "forc");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"msg\", \"message\", \"ve…\n      \"version\", \"forc\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "msg");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…\n      emptySet(), \"msg\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "shouldForceUpdate");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…t(), \"shouldForceUpdate\")");
        this.nullableBooleanAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NewAppVersionEntity");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public NewAppVersionEntity fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Boolean bool = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(jsonReader2);
                i11 &= -2;
            } else if (selectName == 1) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                i11 &= -3;
            } else if (selectName == 2) {
                str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                i11 &= -5;
            } else if (selectName == 3) {
                str4 = this.nullableStringAdapter.fromJson(jsonReader2);
                i11 &= -9;
            } else if (selectName == 4) {
                bool = this.nullableBooleanAdapter.fromJson(jsonReader2);
                i11 &= -17;
            }
        }
        jsonReader.endObject();
        if (i11 == -32) {
            return new NewAppVersionEntity(str, str2, str3, str4, bool);
        }
        Constructor<NewAppVersionEntity> constructor = this.constructorRef;
        if (constructor == null) {
            Class<String> cls = String.class;
            constructor = NewAppVersionEntity.class.getDeclaredConstructor(new Class[]{cls, cls, cls, cls, Boolean.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "NewAppVersionEntity::cla…his.constructorRef = it }");
        }
        NewAppVersionEntity newInstance = constructor.newInstance(new Object[]{str, str2, str3, str4, bool, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable NewAppVersionEntity newAppVersionEntity) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (newAppVersionEntity != null) {
            jsonWriter.beginObject();
            jsonWriter.name("msg");
            this.nullableStringAdapter.toJson(jsonWriter, newAppVersionEntity.getMsg());
            jsonWriter.name("message");
            this.nullableStringAdapter.toJson(jsonWriter, newAppVersionEntity.getMessage());
            jsonWriter.name("ver");
            this.nullableStringAdapter.toJson(jsonWriter, newAppVersionEntity.getVer());
            jsonWriter.name("version");
            this.nullableStringAdapter.toJson(jsonWriter, newAppVersionEntity.getVersion());
            jsonWriter.name("forc");
            this.nullableBooleanAdapter.toJson(jsonWriter, newAppVersionEntity.getShouldForceUpdate());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
