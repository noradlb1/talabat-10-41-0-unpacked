package com.talabat.darkstores.data.basket.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.darkstores.data.basket.model.SwimlaneResponse;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.visa.checkout.PurchaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/data/basket/model/SwimlaneResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfProductAdapter", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "trackingInfoAdapter", "Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse$TrackingInfo;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneResponseJsonAdapter extends JsonAdapter<SwimlaneResponse> {
    @NotNull
    private final JsonAdapter<List<Product>> listOfProductAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;
    @NotNull
    private final JsonAdapter<SwimlaneResponse.TrackingInfo> trackingInfoAdapter;

    public SwimlaneResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(FirebaseAnalytics.Param.ITEMS, "headline", "id", "tracking");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"items\", \"headline\", \"id\",\n      \"tracking\")");
        this.options = of2;
        JsonAdapter<List<Product>> adapter = moshi.adapter(Types.newParameterizedType(List.class, Product.class), SetsKt__SetsKt.emptySet(), FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…mptySet(),\n      \"items\")");
        this.listOfProductAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "headline");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…ySet(),\n      \"headline\")");
        this.stringAdapter = adapter2;
        JsonAdapter<SwimlaneResponse.TrackingInfo> adapter3 = moshi.adapter(SwimlaneResponse.TrackingInfo.class, SetsKt__SetsKt.emptySet(), "tracking");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(SwimlaneRe…, emptySet(), \"tracking\")");
        this.trackingInfoAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SwimlaneResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public SwimlaneResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        String str = null;
        String str2 = null;
        SwimlaneResponse.TrackingInfo trackingInfo = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                list = this.listOfProductAdapter.fromJson(jsonReader);
                if (list == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(FirebaseAnalytics.Param.ITEMS, FirebaseAnalytics.Param.ITEMS, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"items\",\n…         \"items\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("headline", "headline", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"headline…      \"headline\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull(PurchaseInfo.REQUEST_ID, "id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"requestI…            \"id\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (trackingInfo = this.trackingInfoAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("tracking", "tracking", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"tracking\", \"tracking\", reader)");
                throw unexpectedNull4;
            }
        }
        jsonReader.endObject();
        if (list == null) {
            JsonDataException missingProperty = Util.missingProperty(FirebaseAnalytics.Param.ITEMS, FirebaseAnalytics.Param.ITEMS, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"items\", \"items\", reader)");
            throw missingProperty;
        } else if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty("headline", "headline", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"headline\", \"headline\", reader)");
            throw missingProperty2;
        } else if (str2 == null) {
            JsonDataException missingProperty3 = Util.missingProperty(PurchaseInfo.REQUEST_ID, "id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"requestId\", \"id\", reader)");
            throw missingProperty3;
        } else if (trackingInfo != null) {
            return new SwimlaneResponse(list, str, str2, trackingInfo);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("tracking", "tracking", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"tracking\", \"tracking\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable SwimlaneResponse swimlaneResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (swimlaneResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.listOfProductAdapter.toJson(jsonWriter, swimlaneResponse.getItems());
            jsonWriter.name("headline");
            this.stringAdapter.toJson(jsonWriter, swimlaneResponse.getHeadline());
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, swimlaneResponse.getRequestId());
            jsonWriter.name("tracking");
            this.trackingInfoAdapter.toJson(jsonWriter, swimlaneResponse.getTracking());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
