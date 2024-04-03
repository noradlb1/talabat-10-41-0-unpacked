package com.deliveryhero.customerchat.analytics.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/model/FinancialJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/customerchat/analytics/model/Financial;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "nullableMapOfStringNullableStringAdapter", "", "", "nullableMapOfStringStringAdapter", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FinancialJsonAdapter extends JsonAdapter<Financial> {
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<Map<String, String>> nullableMapOfStringNullableStringAdapter;
    @NotNull
    private final JsonAdapter<Map<String, String>> nullableMapOfStringStringAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public FinancialJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("id", "paymentMedium", "currencyCode", "refundValue", "compensationValue", "details");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"id\", \"paymentMedium\"…nsationValue\", \"details\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        Class<Map> cls2 = Map.class;
        JsonAdapter<Map<String, String>> adapter2 = moshi.adapter(Types.newParameterizedType(cls2, cls, cls), SetsKt__SetsKt.emptySet(), "paymentMedium");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…tySet(), \"paymentMedium\")");
        this.nullableMapOfStringNullableStringAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "currencyCode");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl…ptySet(), \"currencyCode\")");
        this.nullableStringAdapter = adapter3;
        JsonAdapter<Integer> adapter4 = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "refundValue");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Int::class…t(),\n      \"refundValue\")");
        this.intAdapter = adapter4;
        JsonAdapter<Map<String, String>> adapter5 = moshi.adapter(Types.newParameterizedType(cls2, cls, cls), SetsKt__SetsKt.emptySet(), "details");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP…), emptySet(), \"details\")");
        this.nullableMapOfStringStringAdapter = adapter5;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(31);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Financial");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public Financial fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Integer num = null;
        Integer num2 = null;
        String str = null;
        Map map = null;
        String str2 = null;
        Map map2 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.stringAdapter.fromJson(jsonReader);
                    if (str != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    map = this.nullableMapOfStringNullableStringAdapter.fromJson(jsonReader);
                    break;
                case 2:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 3:
                    num = this.intAdapter.fromJson(jsonReader);
                    if (num != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("refundValue", "refundValue", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"refundVa…   \"refundValue\", reader)");
                        throw unexpectedNull2;
                    }
                case 4:
                    num2 = this.intAdapter.fromJson(jsonReader);
                    if (num2 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("compensationValue", "compensationValue", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"compensa…mpensationValue\", reader)");
                        throw unexpectedNull3;
                    }
                case 5:
                    map2 = this.nullableMapOfStringStringAdapter.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (num != null) {
            int intValue = num.intValue();
            if (num2 != null) {
                return new Financial(str, map, str2, intValue, num2.intValue(), map2);
            }
            JsonDataException missingProperty2 = Util.missingProperty("compensationValue", "compensationValue", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"compens…mpensationValue\", reader)");
            throw missingProperty2;
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("refundValue", "refundValue", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"refundV…lue\",\n            reader)");
            throw missingProperty3;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Financial financial) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (financial != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, financial.getId());
            jsonWriter.name("paymentMedium");
            this.nullableMapOfStringNullableStringAdapter.toJson(jsonWriter, financial.getPaymentMedium());
            jsonWriter.name("currencyCode");
            this.nullableStringAdapter.toJson(jsonWriter, financial.getCurrencyCode());
            jsonWriter.name("refundValue");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(financial.getRefundValue()));
            jsonWriter.name("compensationValue");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(financial.getCompensationValue()));
            jsonWriter.name("details");
            this.nullableMapOfStringStringAdapter.toJson(jsonWriter, financial.getDetails());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
