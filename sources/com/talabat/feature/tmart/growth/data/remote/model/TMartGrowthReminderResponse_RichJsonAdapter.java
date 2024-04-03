package com.talabat.feature.tmart.growth.data.remote.model;

import androidx.core.app.NotificationCompat;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminderResponse;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse_RichJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse$Rich;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableTMartGrowthTrackingInfoResponseAdapter", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "richAdapter", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Rich;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthReminderResponse_RichJsonAdapter extends JsonAdapter<TMartGrowthReminderResponse.Rich> {
    @NotNull
    private final JsonAdapter<TMartGrowthTrackingInfoResponse> nullableTMartGrowthTrackingInfoResponseAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<TMartGrowthReminder.Rich> richAdapter;

    public TMartGrowthReminderResponse_RichJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("data", "tracking_info");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"data\", \"tracking_info\")");
        this.options = of2;
        JsonAdapter<TMartGrowthReminder.Rich> adapter = moshi.adapter(TMartGrowthReminder.Rich.class, SetsKt__SetsKt.emptySet(), NotificationCompat.CATEGORY_REMINDER);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(TMartGrowt…, emptySet(), \"reminder\")");
        this.richAdapter = adapter;
        JsonAdapter<TMartGrowthTrackingInfoResponse> adapter2 = moshi.adapter(TMartGrowthTrackingInfoResponse.class, SetsKt__SetsKt.emptySet(), NavigationMethodChannel.SEARCH_TRACKING);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(TMartGrowt…ptySet(), \"trackingInfo\")");
        this.nullableTMartGrowthTrackingInfoResponseAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TMartGrowthReminderResponse.Rich");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public TMartGrowthReminderResponse.Rich fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        TMartGrowthReminder.Rich rich = null;
        TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                rich = this.richAdapter.fromJson(jsonReader);
                if (rich == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(NotificationCompat.CATEGORY_REMINDER, "data", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"reminder…          \"data\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                tMartGrowthTrackingInfoResponse = this.nullableTMartGrowthTrackingInfoResponseAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        if (rich != null) {
            return new TMartGrowthReminderResponse.Rich(rich, tMartGrowthTrackingInfoResponse);
        }
        JsonDataException missingProperty = Util.missingProperty(NotificationCompat.CATEGORY_REMINDER, "data", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"reminder\", \"data\", reader)");
        throw missingProperty;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable TMartGrowthReminderResponse.Rich rich) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (rich != null) {
            jsonWriter.beginObject();
            jsonWriter.name("data");
            this.richAdapter.toJson(jsonWriter, rich.getReminder());
            jsonWriter.name("tracking_info");
            this.nullableTMartGrowthTrackingInfoResponseAdapter.toJson(jsonWriter, rich.getTrackingInfo());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
