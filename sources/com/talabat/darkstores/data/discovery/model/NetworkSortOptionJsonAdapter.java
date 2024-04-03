package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.visa.checkout.Profile;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/NetworkSortOptionJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/discovery/model/NetworkSortOption;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBooleanAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkSortOptionJsonAdapter extends JsonAdapter<NetworkSortOption> {
    @Nullable
    private volatile Constructor<NetworkSortOption> constructorRef;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public NetworkSortOptionJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("display_name", "is_applied", "key");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"display_name\", \"is_applied\",\n      \"key\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), Profile.DISPLAY_NAME);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…mptySet(), \"displayName\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "isApplied");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c… emptySet(), \"isApplied\")");
        this.nullableBooleanAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(39);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NetworkSortOption");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public NetworkSortOption fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Boolean bool = null;
        String str2 = null;
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
                bool = this.nullableBooleanAdapter.fromJson(jsonReader);
                i11 &= -3;
            } else if (selectName == 2) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader);
                i11 &= -5;
            }
        }
        jsonReader.endObject();
        if (i11 == -8) {
            return new NetworkSortOption(str, bool, str2);
        }
        Constructor<NetworkSortOption> constructor = this.constructorRef;
        if (constructor == null) {
            Class<String> cls = String.class;
            constructor = NetworkSortOption.class.getDeclaredConstructor(new Class[]{cls, Boolean.class, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "NetworkSortOption::class…his.constructorRef = it }");
        }
        NetworkSortOption newInstance = constructor.newInstance(new Object[]{str, bool, str2, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable NetworkSortOption networkSortOption) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (networkSortOption != null) {
            jsonWriter.beginObject();
            jsonWriter.name("display_name");
            this.nullableStringAdapter.toJson(jsonWriter, networkSortOption.getDisplayName());
            jsonWriter.name("is_applied");
            this.nullableBooleanAdapter.toJson(jsonWriter, networkSortOption.isApplied());
            jsonWriter.name("key");
            this.nullableStringAdapter.toJson(jsonWriter, networkSortOption.getKey());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
