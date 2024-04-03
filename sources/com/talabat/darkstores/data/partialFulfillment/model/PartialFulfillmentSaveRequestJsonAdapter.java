package com.talabat.darkstores.data.partialFulfillment.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.tekartik.sqflite.Constant;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/data/partialFulfillment/model/PartialFulfillmentSaveRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/partialFulfillment/model/PartialFulfillmentSaveRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PartialFulfillmentSaveRequestJsonAdapter extends JsonAdapter<PartialFulfillmentSaveRequest> {
    @Nullable
    private volatile Constructor<PartialFulfillmentSaveRequest> constructorRef;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public PartialFulfillmentSaveRequestJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(Constant.PARAM_ERROR_CODE, "value");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"code\", \"value\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"code\")");
        this.stringAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("PartialFulfillmentSaveRequest");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public PartialFulfillmentSaveRequest fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str != null) {
                    i11 &= -2;
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull(Constant.PARAM_ERROR_CODE, Constant.PARAM_ERROR_CODE, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"code\", \"code\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 != null) {
                    i11 &= -3;
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("value__", "value", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"value__\"…e\",\n              reader)");
                    throw unexpectedNull2;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (i11 != -4) {
            Constructor<PartialFulfillmentSaveRequest> constructor = this.constructorRef;
            if (constructor == null) {
                Class<String> cls = String.class;
                constructor = PartialFulfillmentSaveRequest.class.getDeclaredConstructor(new Class[]{cls, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "PartialFulfillmentSaveRe…his.constructorRef = it }");
            }
            PartialFulfillmentSaveRequest newInstance = constructor.newInstance(new Object[]{str, str2, Integer.valueOf(i11), null});
            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
            return newInstance;
        } else if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str2 != null) {
            return new PartialFulfillmentSaveRequest(str, str2);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable PartialFulfillmentSaveRequest partialFulfillmentSaveRequest) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (partialFulfillmentSaveRequest != null) {
            jsonWriter.beginObject();
            jsonWriter.name(Constant.PARAM_ERROR_CODE);
            this.stringAdapter.toJson(jsonWriter, partialFulfillmentSaveRequest.getCode());
            jsonWriter.name("value");
            this.stringAdapter.toJson(jsonWriter, partialFulfillmentSaveRequest.getValue());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
