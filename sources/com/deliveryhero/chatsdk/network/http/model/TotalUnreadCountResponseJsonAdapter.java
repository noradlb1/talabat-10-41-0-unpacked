package com.deliveryhero.chatsdk.network.http.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.visa.checkout.PurchaseInfo;
import java.lang.reflect.Constructor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/chatsdk/network/http/model/TotalUnreadCountResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/chatsdk/network/http/model/TotalUnreadCountResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "intAdapter", "", "nullableMapOfStringIntAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TotalUnreadCountResponseJsonAdapter extends JsonAdapter<TotalUnreadCountResponse> {
    @Nullable
    private volatile Constructor<TotalUnreadCountResponse> constructorRef;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<Map<String, Integer>> nullableMapOfStringIntAdapter;
    @NotNull
    private final JsonReader.Options options;

    public TotalUnreadCountResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(PurchaseInfo.TOTAL, "channels");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"total\", \"channels\")");
        this.options = of2;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), PurchaseInfo.TOTAL);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…ava, emptySet(), \"total\")");
        this.intAdapter = adapter;
        JsonAdapter<Map<String, Integer>> adapter2 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Integer.class), SetsKt__SetsKt.emptySet(), "channels");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…, emptySet(), \"channels\")");
        this.nullableMapOfStringIntAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TotalUnreadCountResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public TotalUnreadCountResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Integer num = null;
        Map map = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                num = this.intAdapter.fromJson(jsonReader);
                if (num == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(PurchaseInfo.TOTAL, PurchaseInfo.TOTAL, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"total\", …tal\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                map = this.nullableMapOfStringIntAdapter.fromJson(jsonReader);
                i11 &= -3;
            }
        }
        jsonReader.endObject();
        if (i11 != -3) {
            Constructor<TotalUnreadCountResponse> constructor = this.constructorRef;
            if (constructor == null) {
                Class cls = Integer.TYPE;
                constructor = TotalUnreadCountResponse.class.getDeclaredConstructor(new Class[]{cls, Map.class, cls, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "TotalUnreadCountResponse…his.constructorRef = it }");
            }
            Object[] objArr = new Object[4];
            if (num != null) {
                objArr[0] = Integer.valueOf(num.intValue());
                objArr[1] = map;
                objArr[2] = Integer.valueOf(i11);
                objArr[3] = null;
                TotalUnreadCountResponse newInstance = constructor.newInstance(objArr);
                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException missingProperty = Util.missingProperty(PurchaseInfo.TOTAL, PurchaseInfo.TOTAL, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"total\", \"total\", reader)");
            throw missingProperty;
        } else if (num != null) {
            return new TotalUnreadCountResponse(num.intValue(), map);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty(PurchaseInfo.TOTAL, PurchaseInfo.TOTAL, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"total\", \"total\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable TotalUnreadCountResponse totalUnreadCountResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (totalUnreadCountResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name(PurchaseInfo.TOTAL);
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(totalUnreadCountResponse.getTotal()));
            jsonWriter.name("channels");
            this.nullableMapOfStringIntAdapter.toJson(jsonWriter, totalUnreadCountResponse.getChannels());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
