package com.talabat.darkstores.data.basket.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.darkstores.data.basket.model.SwimlaneResponse;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse_TrackingInfoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse$TrackingInfo;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfStringAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneResponse_TrackingInfoJsonAdapter extends JsonAdapter<SwimlaneResponse.TrackingInfo> {
    @Nullable
    private volatile Constructor<SwimlaneResponse.TrackingInfo> constructorRef;
    @NotNull
    private final JsonAdapter<List<String>> listOfStringAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public SwimlaneResponse_TrackingInfoJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("swimlane_id", "tracking_id", "swimlane_title_list");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"swimlane_id\", \"track…   \"swimlane_title_list\")");
        this.options = of2;
        Class<String> cls = String.class;
        JsonAdapter<String> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "swimlaneId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…et(),\n      \"swimlaneId\")");
        this.stringAdapter = adapter;
        JsonAdapter<List<String>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, cls), SetsKt__SetsKt.emptySet(), "supportedTitleList");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…    \"supportedTitleList\")");
        this.listOfStringAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SwimlaneResponse.TrackingInfo");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public SwimlaneResponse.TrackingInfo fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        List list = null;
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
                    JsonDataException unexpectedNull = Util.unexpectedNull("swimlaneId", "swimlane_id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"swimlane…   \"swimlane_id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 != null) {
                    i11 &= -3;
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("trackingId", "tracking_id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"tracking…   \"tracking_id\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                list = this.listOfStringAdapter.fromJson(jsonReader);
                if (list != null) {
                    i11 &= -5;
                } else {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("supportedTitleList", "swimlane_title_list", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"supporte…lane_title_list\", reader)");
                    throw unexpectedNull3;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (i11 != -8) {
            Constructor<SwimlaneResponse.TrackingInfo> constructor = this.constructorRef;
            if (constructor == null) {
                Class<String> cls = String.class;
                constructor = SwimlaneResponse.TrackingInfo.class.getDeclaredConstructor(new Class[]{cls, cls, List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "SwimlaneResponse.Trackin…his.constructorRef = it }");
            }
            SwimlaneResponse.TrackingInfo newInstance = constructor.newInstance(new Object[]{str, str2, list, Integer.valueOf(i11), null});
            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
            return newInstance;
        } else if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (list != null) {
            return new SwimlaneResponse.TrackingInfo(str, str2, list);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable SwimlaneResponse.TrackingInfo trackingInfo) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (trackingInfo != null) {
            jsonWriter.beginObject();
            jsonWriter.name("swimlane_id");
            this.stringAdapter.toJson(jsonWriter, trackingInfo.getSwimlaneId());
            jsonWriter.name("tracking_id");
            this.stringAdapter.toJson(jsonWriter, trackingInfo.getTrackingId());
            jsonWriter.name("swimlane_title_list");
            this.listOfStringAdapter.toJson(jsonWriter, trackingInfo.getSupportedTitleList());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
