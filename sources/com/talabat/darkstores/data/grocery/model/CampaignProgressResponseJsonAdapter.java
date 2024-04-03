package com.talabat.darkstores.data.grocery.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/data/grocery/model/CampaignProgressResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/grocery/model/CampaignProgressResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "campaignProgressAdapter", "Lcom/talabat/darkstores/data/grocery/model/CampaignProgress;", "nullableCampaignProgressAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressResponseJsonAdapter extends JsonAdapter<CampaignProgressResponse> {
    @NotNull
    private final JsonAdapter<CampaignProgress> campaignProgressAdapter;
    @NotNull
    private final JsonAdapter<CampaignProgress> nullableCampaignProgressAdapter;
    @NotNull
    private final JsonReader.Options options;

    public CampaignProgressResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(FacebookRequestErrorClassification.KEY_TRANSIENT, "permanent");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"transient\", \"permanent\")");
        this.options = of2;
        Class<CampaignProgress> cls = CampaignProgress.class;
        JsonAdapter<CampaignProgress> adapter = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), FacebookRequestErrorClassification.KEY_TRANSIENT);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(CampaignPr… emptySet(), \"transient\")");
        this.nullableCampaignProgressAdapter = adapter;
        JsonAdapter<CampaignProgress> adapter2 = moshi.adapter(cls, SetsKt__SetsKt.emptySet(), "permanent");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(CampaignPr… emptySet(), \"permanent\")");
        this.campaignProgressAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CampaignProgressResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public CampaignProgressResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        CampaignProgress campaignProgress = null;
        CampaignProgress campaignProgress2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                campaignProgress = this.nullableCampaignProgressAdapter.fromJson(jsonReader);
            } else if (selectName == 1 && (campaignProgress2 = this.campaignProgressAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("permanent", "permanent", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"permanent\", \"permanent\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (campaignProgress2 != null) {
            return new CampaignProgressResponse(campaignProgress, campaignProgress2);
        }
        JsonDataException missingProperty = Util.missingProperty("permanent", "permanent", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"permanent\", \"permanent\", reader)");
        throw missingProperty;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CampaignProgressResponse campaignProgressResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (campaignProgressResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name(FacebookRequestErrorClassification.KEY_TRANSIENT);
            this.nullableCampaignProgressAdapter.toJson(jsonWriter, campaignProgressResponse.getTransient());
            jsonWriter.name("permanent");
            this.campaignProgressAdapter.toJson(jsonWriter, campaignProgressResponse.getPermanent());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
