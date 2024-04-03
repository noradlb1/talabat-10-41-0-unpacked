package com.deliveryhero.customerchat.analytics.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/model/UserJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/customerchat/analytics/model/User;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableMapOfStringNullableStringAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserJsonAdapter extends JsonAdapter<User> {
    @Nullable
    private volatile Constructor<User> constructorRef;
    @NotNull
    private final JsonAdapter<Map<String, String>> nullableMapOfStringNullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public UserJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("id", "details");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"id\", \"details\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Map<String, String>> adapter2 = moshi.adapter(Types.newParameterizedType(Map.class, cls, cls), SetsKt__SetsKt.emptySet(), "details");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…), emptySet(), \"details\")");
        this.nullableMapOfStringNullableStringAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("User");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public User fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Map map = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                map = this.nullableMapOfStringNullableStringAdapter.fromJson(jsonReader);
                i11 &= -3;
            }
        }
        jsonReader.endObject();
        if (i11 != -3) {
            Constructor<User> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = User.class.getDeclaredConstructor(new Class[]{String.class, Map.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "User::class.java.getDecl…his.constructorRef = it }");
            }
            Object[] objArr = new Object[4];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = map;
                objArr[2] = Integer.valueOf(i11);
                objArr[3] = null;
                User newInstance = constructor.newInstance(objArr);
                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (str != null) {
            return new User(str, map);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("id", "id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable User user) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (user != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, user.getId());
            jsonWriter.name("details");
            this.nullableMapOfStringNullableStringAdapter.toJson(jsonWriter, user.getDetails());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
