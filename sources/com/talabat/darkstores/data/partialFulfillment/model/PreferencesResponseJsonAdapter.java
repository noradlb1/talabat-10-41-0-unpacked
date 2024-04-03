package com.talabat.darkstores.data.partialFulfillment.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.tekartik.sqflite.Constant;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/data/partialFulfillment/model/PreferencesResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/partialFulfillment/model/PreferencesResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfControlAdapter", "", "Lcom/talabat/darkstores/data/partialFulfillment/model/Control;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreferencesResponseJsonAdapter extends JsonAdapter<PreferencesResponse> {
    @Nullable
    private volatile Constructor<PreferencesResponse> constructorRef;
    @NotNull
    private final JsonAdapter<List<Control>> listOfControlAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public PreferencesResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(Constant.PARAM_ERROR_CODE, "controls", "defaultValue", "description", ObservableAttributesNames.IMAGE_URL_V2, "name", "tag", "type", "value");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"code\", \"controls\",\n …, \"tag\", \"type\", \"value\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"code\")");
        this.stringAdapter = adapter;
        JsonAdapter<List<Control>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, Control.class), SetsKt__SetsKt.emptySet(), "controls");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…ySet(),\n      \"controls\")");
        this.listOfControlAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("PreferencesResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public PreferencesResponse fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        String str = null;
        List list = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
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
                    list = this.listOfControlAdapter.fromJson(jsonReader2);
                    if (list != null) {
                        i11 &= -3;
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("controls", "controls", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"controls…      \"controls\", reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    str2 = this.stringAdapter.fromJson(jsonReader2);
                    if (str2 != null) {
                        i11 &= -5;
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("defaultValue", "defaultValue", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"defaultV…  \"defaultValue\", reader)");
                        throw unexpectedNull3;
                    }
                case 3:
                    str3 = this.stringAdapter.fromJson(jsonReader2);
                    if (str3 != null) {
                        i11 &= -9;
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("description", "description", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"descript…   \"description\", reader)");
                        throw unexpectedNull4;
                    }
                case 4:
                    str4 = this.stringAdapter.fromJson(jsonReader2);
                    if (str4 != null) {
                        i11 &= -17;
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull(ObservableAttributesNames.IMAGE_URL_V2, ObservableAttributesNames.IMAGE_URL_V2, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"imageUrl…      \"imageUrl\", reader)");
                        throw unexpectedNull5;
                    }
                case 5:
                    str5 = this.stringAdapter.fromJson(jsonReader2);
                    if (str5 != null) {
                        i11 &= -33;
                        break;
                    } else {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("name", "name", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"name\", \"name\", reader)");
                        throw unexpectedNull6;
                    }
                case 6:
                    str6 = this.stringAdapter.fromJson(jsonReader2);
                    if (str6 != null) {
                        i11 &= -65;
                        break;
                    } else {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("tag", "tag", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"tag\", \"tag\", reader)");
                        throw unexpectedNull7;
                    }
                case 7:
                    str7 = this.stringAdapter.fromJson(jsonReader2);
                    if (str7 != null) {
                        i11 &= -129;
                        break;
                    } else {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("type", "type", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "unexpectedNull(\"type\", \"type\", reader)");
                        throw unexpectedNull8;
                    }
                case 8:
                    str8 = this.stringAdapter.fromJson(jsonReader2);
                    if (str8 != null) {
                        i11 &= -257;
                        break;
                    } else {
                        JsonDataException unexpectedNull9 = Util.unexpectedNull("value__", "value", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull9, "unexpectedNull(\"value__\"…e\",\n              reader)");
                        throw unexpectedNull9;
                    }
            }
        }
        jsonReader.endObject();
        if (i11 != -512) {
            Constructor<PreferencesResponse> constructor = this.constructorRef;
            if (constructor == null) {
                Class<String> cls = String.class;
                constructor = PreferencesResponse.class.getDeclaredConstructor(new Class[]{cls, List.class, cls, cls, cls, cls, cls, cls, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "PreferencesResponse::cla…his.constructorRef = it }");
            }
            PreferencesResponse newInstance = constructor.newInstance(new Object[]{str, list, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i11), null});
            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
            return newInstance;
        } else if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (list == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.talabat.darkstores.data.partialFulfillment.model.Control>");
        } else if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str6 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str7 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str8 != null) {
            return new PreferencesResponse(str, list, str2, str3, str4, str5, str6, str7, str8);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable PreferencesResponse preferencesResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (preferencesResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name(Constant.PARAM_ERROR_CODE);
            this.stringAdapter.toJson(jsonWriter, preferencesResponse.getCode());
            jsonWriter.name("controls");
            this.listOfControlAdapter.toJson(jsonWriter, preferencesResponse.getControls());
            jsonWriter.name("defaultValue");
            this.stringAdapter.toJson(jsonWriter, preferencesResponse.getDefaultValue());
            jsonWriter.name("description");
            this.stringAdapter.toJson(jsonWriter, preferencesResponse.getDescription());
            jsonWriter.name(ObservableAttributesNames.IMAGE_URL_V2);
            this.stringAdapter.toJson(jsonWriter, preferencesResponse.getImageUrl());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, preferencesResponse.getName());
            jsonWriter.name("tag");
            this.stringAdapter.toJson(jsonWriter, preferencesResponse.getTag());
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, preferencesResponse.getType());
            jsonWriter.name("value");
            this.stringAdapter.toJson(jsonWriter, preferencesResponse.getValue());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
