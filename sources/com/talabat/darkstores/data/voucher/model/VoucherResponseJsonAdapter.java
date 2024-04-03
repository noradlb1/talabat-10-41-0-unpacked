package com.talabat.darkstores.data.voucher.model;

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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/data/voucher/model/VoucherResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/voucher/model/VoucherResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableStringAdapter", "", "nullableVoucherAdapter", "Lcom/talabat/darkstores/data/voucher/model/Voucher;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherResponseJsonAdapter extends JsonAdapter<VoucherResponse> {
    @Nullable
    private volatile Constructor<VoucherResponse> constructorRef;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonAdapter<Voucher> nullableVoucherAdapter;
    @NotNull
    private final JsonReader.Options options;

    public VoucherResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("type", "data");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"type\", \"data\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…      emptySet(), \"type\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Voucher> adapter2 = moshi.adapter(Voucher.class, SetsKt__SetsKt.emptySet(), "data");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Voucher::c…      emptySet(), \"data\")");
        this.nullableVoucherAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("VoucherResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public VoucherResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Voucher voucher = null;
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
                voucher = this.nullableVoucherAdapter.fromJson(jsonReader);
                i11 &= -3;
            }
        }
        jsonReader.endObject();
        if (i11 == -4) {
            return new VoucherResponse(str, voucher);
        }
        Constructor<VoucherResponse> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = VoucherResponse.class.getDeclaredConstructor(new Class[]{String.class, Voucher.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "VoucherResponse::class.j…his.constructorRef = it }");
        }
        VoucherResponse newInstance = constructor.newInstance(new Object[]{str, voucher, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable VoucherResponse voucherResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (voucherResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("type");
            this.nullableStringAdapter.toJson(jsonWriter, voucherResponse.getType());
            jsonWriter.name("data");
            this.nullableVoucherAdapter.toJson(jsonWriter, voucherResponse.getData());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
