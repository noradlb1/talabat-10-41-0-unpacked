package com.talabat.feature.tmart.growth.data.remote.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthClaimResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "confirmationAdapter", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse$Confirmation;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "postConfirmationAdapter", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse$PostConfirmation;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthClaimResponseJsonAdapter extends JsonAdapter<TMartGrowthClaimResponse> {
    @NotNull
    private final JsonAdapter<TMartGrowthClaimResponse.Confirmation> confirmationAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<TMartGrowthClaimResponse.PostConfirmation> postConfirmationAdapter;

    public TMartGrowthClaimResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("confirmation", "post_confirmation");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"confirmation\",\n      \"post_confirmation\")");
        this.options = of2;
        JsonAdapter<TMartGrowthClaimResponse.Confirmation> adapter = moshi.adapter(TMartGrowthClaimResponse.Confirmation.class, SetsKt__SetsKt.emptySet(), "confirmation");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(TMartGrowt…ptySet(), \"confirmation\")");
        this.confirmationAdapter = adapter;
        JsonAdapter<TMartGrowthClaimResponse.PostConfirmation> adapter2 = moshi.adapter(TMartGrowthClaimResponse.PostConfirmation.class, SetsKt__SetsKt.emptySet(), "postConfirmation");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(TMartGrowt…      \"postConfirmation\")");
        this.postConfirmationAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TMartGrowthClaimResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public TMartGrowthClaimResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        TMartGrowthClaimResponse.Confirmation confirmation = null;
        TMartGrowthClaimResponse.PostConfirmation postConfirmation = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                confirmation = this.confirmationAdapter.fromJson(jsonReader);
                if (confirmation == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("confirmation", "confirmation", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"confirma…, \"confirmation\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (postConfirmation = this.postConfirmationAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("postConfirmation", "post_confirmation", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"postConf…st_confirmation\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (confirmation == null) {
            JsonDataException missingProperty = Util.missingProperty("confirmation", "confirmation", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"confirm…ion\",\n            reader)");
            throw missingProperty;
        } else if (postConfirmation != null) {
            return new TMartGrowthClaimResponse(confirmation, postConfirmation);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("postConfirmation", "post_confirmation", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"postCon…st_confirmation\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable TMartGrowthClaimResponse tMartGrowthClaimResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (tMartGrowthClaimResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("confirmation");
            this.confirmationAdapter.toJson(jsonWriter, tMartGrowthClaimResponse.getConfirmation());
            jsonWriter.name("post_confirmation");
            this.postConfirmationAdapter.toJson(jsonWriter, tMartGrowthClaimResponse.getPostConfirmation());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
