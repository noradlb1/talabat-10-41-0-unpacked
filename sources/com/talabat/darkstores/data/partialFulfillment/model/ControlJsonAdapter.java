package com.talabat.darkstores.data.partialFulfillment.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.tekartik.sqflite.Constant;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/data/partialFulfillment/model/ControlJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/partialFulfillment/model/Control;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ControlJsonAdapter extends JsonAdapter<Control> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @Nullable
    private volatile Constructor<Control> constructorRef;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public ControlJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(Constant.PARAM_ERROR_CODE, "description", "image_url", "name", "type", "value");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"code\", \"description\"… \"name\", \"type\", \"value\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"code\")");
        this.stringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "value");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…mptySet(),\n      \"value\")");
        this.booleanAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Control");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public Control fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        Boolean bool = Boolean.FALSE;
        jsonReader.beginObject();
        int i11 = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.stringAdapter.fromJson(jsonReader2);
                    if (str != null) {
                        i11 &= -2;
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull(Constant.PARAM_ERROR_CODE, Constant.PARAM_ERROR_CODE, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"code\", \"code\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    str2 = this.stringAdapter.fromJson(jsonReader2);
                    if (str2 != null) {
                        i11 &= -3;
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("description", "description", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"descript…   \"description\", reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    str3 = this.stringAdapter.fromJson(jsonReader2);
                    if (str3 != null) {
                        i11 &= -5;
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull(ObservableAttributesNames.IMAGE_URL_V2, "image_url", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"imageUrl…     \"image_url\", reader)");
                        throw unexpectedNull3;
                    }
                case 3:
                    str4 = this.stringAdapter.fromJson(jsonReader2);
                    if (str4 != null) {
                        i11 &= -9;
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("name", "name", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"name\", \"name\", reader)");
                        throw unexpectedNull4;
                    }
                case 4:
                    str5 = this.stringAdapter.fromJson(jsonReader2);
                    if (str5 != null) {
                        i11 &= -17;
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("type", "type", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"type\", \"type\", reader)");
                        throw unexpectedNull5;
                    }
                case 5:
                    bool = this.booleanAdapter.fromJson(jsonReader2);
                    if (bool != null) {
                        i11 &= -33;
                        break;
                    } else {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("value__", "value", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"value__\"…e\",\n              reader)");
                        throw unexpectedNull6;
                    }
            }
        }
        jsonReader.endObject();
        if (i11 != -64) {
            Constructor<Control> constructor = this.constructorRef;
            if (constructor == null) {
                Class<String> cls = String.class;
                constructor = Control.class.getDeclaredConstructor(new Class[]{cls, cls, cls, cls, cls, Boolean.TYPE, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "Control::class.java.getD…his.constructorRef = it }");
            }
            Control newInstance = constructor.newInstance(new Object[]{str, str2, str3, str4, str5, bool, Integer.valueOf(i11), null});
            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
            return newInstance;
        } else if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str5 != null) {
            return new Control(str, str2, str3, str4, str5, bool.booleanValue());
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Control control) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (control != null) {
            jsonWriter.beginObject();
            jsonWriter.name(Constant.PARAM_ERROR_CODE);
            this.stringAdapter.toJson(jsonWriter, control.getCode());
            jsonWriter.name("description");
            this.stringAdapter.toJson(jsonWriter, control.getDescription());
            jsonWriter.name("image_url");
            this.stringAdapter.toJson(jsonWriter, control.getImageUrl());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, control.getName());
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, control.getType());
            jsonWriter.name("value");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(control.getValue()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
