package com.talabat.feature.tmart.growth.data.remote.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthClaimResponse;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse_PostConfirmationJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse$PostConfirmation;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthClaimResponse_PostConfirmationJsonAdapter extends JsonAdapter<TMartGrowthClaimResponse.PostConfirmation> {
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public TMartGrowthClaimResponse_PostConfirmationJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("headline", "image_url", "tagline");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"headline\", \"image_url\",\n      \"tagline\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "title");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…mptySet(),\n      \"title\")");
        this.stringAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(63);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TMartGrowthClaimResponse.PostConfirmation");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public TMartGrowthClaimResponse.PostConfirmation fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("title", "headline", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"title\",\n…      \"headline\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(ObservableAttributesNames.IMAGE_URL_V2, "image_url", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"imageUrl…     \"image_url\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (str3 = this.stringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("description", "tagline", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"description\", \"tagline\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("title", "headline", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"title\", \"headline\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty(ObservableAttributesNames.IMAGE_URL_V2, "image_url", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"imageUrl\", \"image_url\", reader)");
            throw missingProperty2;
        } else if (str3 != null) {
            return new TMartGrowthClaimResponse.PostConfirmation(str, str2, str3);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("description", "tagline", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"description\", \"tagline\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable TMartGrowthClaimResponse.PostConfirmation postConfirmation) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (postConfirmation != null) {
            jsonWriter.beginObject();
            jsonWriter.name("headline");
            this.stringAdapter.toJson(jsonWriter, postConfirmation.getTitle());
            jsonWriter.name("image_url");
            this.stringAdapter.toJson(jsonWriter, postConfirmation.getImageUrl());
            jsonWriter.name("tagline");
            this.stringAdapter.toJson(jsonWriter, postConfirmation.getDescription());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
