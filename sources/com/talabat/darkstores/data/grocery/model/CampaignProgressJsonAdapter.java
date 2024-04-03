package com.talabat.darkstores.data.grocery.model;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.talabat.darkstores.data.grocery.model.CampaignProgress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/data/grocery/model/CampaignProgressJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/grocery/model/CampaignProgress;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableBooleanAdapter", "", "nullableFloatAdapter", "", "nullableLongAdapter", "", "nullableStateAdapter", "Lcom/talabat/darkstores/data/grocery/model/CampaignProgress$State;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressJsonAdapter extends JsonAdapter<CampaignProgress> {
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<Float> nullableFloatAdapter;
    @NotNull
    private final JsonAdapter<Long> nullableLongAdapter;
    @NotNull
    private final JsonAdapter<CampaignProgress.State> nullableStateAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public CampaignProgressJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(ViewHierarchyConstants.ICON_BITMAP, "message", "progress_value", "show_for_seconds", "view_state", "is_tpro_campaign");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"icon_image\", \"messag…ate\", \"is_tpro_campaign\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "iconImage");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl… emptySet(), \"iconImage\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Float> adapter2 = moshi.adapter(Float.class, SetsKt__SetsKt.emptySet(), "progressValue");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Float::cla…tySet(), \"progressValue\")");
        this.nullableFloatAdapter = adapter2;
        JsonAdapter<Long> adapter3 = moshi.adapter(Long.class, SetsKt__SetsKt.emptySet(), "showForSeconds");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Long::clas…ySet(), \"showForSeconds\")");
        this.nullableLongAdapter = adapter3;
        JsonAdapter<CampaignProgress.State> adapter4 = moshi.adapter(CampaignProgress.State.class, SetsKt__SetsKt.emptySet(), "state");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(CampaignPr…ava, emptySet(), \"state\")");
        this.nullableStateAdapter = adapter4;
        JsonAdapter<Boolean> adapter5 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "isTPro");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Boolean::c…pe, emptySet(), \"isTPro\")");
        this.nullableBooleanAdapter = adapter5;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CampaignProgress");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public CampaignProgress fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        Float f11 = null;
        Long l11 = null;
        CampaignProgress.State state = null;
        Boolean bool = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 2:
                    f11 = this.nullableFloatAdapter.fromJson(jsonReader);
                    break;
                case 3:
                    l11 = this.nullableLongAdapter.fromJson(jsonReader);
                    break;
                case 4:
                    state = this.nullableStateAdapter.fromJson(jsonReader);
                    break;
                case 5:
                    bool = this.nullableBooleanAdapter.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.endObject();
        return new CampaignProgress(str, str2, f11, l11, state, bool);
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CampaignProgress campaignProgress) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (campaignProgress != null) {
            jsonWriter.beginObject();
            jsonWriter.name(ViewHierarchyConstants.ICON_BITMAP);
            this.nullableStringAdapter.toJson(jsonWriter, campaignProgress.getIconImage());
            jsonWriter.name("message");
            this.nullableStringAdapter.toJson(jsonWriter, campaignProgress.getMessage());
            jsonWriter.name("progress_value");
            this.nullableFloatAdapter.toJson(jsonWriter, campaignProgress.getProgressValue());
            jsonWriter.name("show_for_seconds");
            this.nullableLongAdapter.toJson(jsonWriter, campaignProgress.getShowForSeconds());
            jsonWriter.name("view_state");
            this.nullableStateAdapter.toJson(jsonWriter, campaignProgress.getState());
            jsonWriter.name("is_tpro_campaign");
            this.nullableBooleanAdapter.toJson(jsonWriter, campaignProgress.isTPro());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
