package com.talabat.feature.darkstorescampaignmessage.data.model;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgress;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBooleanAdapter", "", "nullableFloatAdapter", "", "nullableLongAdapter", "", "nullableNetworkCampaignProgressStateAdapter", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressState;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-campaign-message_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkCampaignProgressJsonAdapter extends JsonAdapter<NetworkCampaignProgress> {
    @Nullable
    private volatile Constructor<NetworkCampaignProgress> constructorRef;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<Float> nullableFloatAdapter;
    @NotNull
    private final JsonAdapter<Long> nullableLongAdapter;
    @NotNull
    private final JsonAdapter<NetworkCampaignProgressState> nullableNetworkCampaignProgressStateAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public NetworkCampaignProgressJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(ViewHierarchyConstants.ICON_BITMAP, "message", "progress_value", "show_for_seconds", "view_state", "is_tpro_campaign", "message_source");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"icon_image\", \"messag…paign\", \"message_source\")");
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
        JsonAdapter<NetworkCampaignProgressState> adapter4 = moshi.adapter(NetworkCampaignProgressState.class, SetsKt__SetsKt.emptySet(), "state");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(NetworkCam…ava, emptySet(), \"state\")");
        this.nullableNetworkCampaignProgressStateAdapter = adapter4;
        JsonAdapter<Boolean> adapter5 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "isTPro");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Boolean::c…pe, emptySet(), \"isTPro\")");
        this.nullableBooleanAdapter = adapter5;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NetworkCampaignProgress");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public NetworkCampaignProgress fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        String str = null;
        String str2 = null;
        Float f11 = null;
        Long l11 = null;
        NetworkCampaignProgressState networkCampaignProgressState = null;
        Boolean bool = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -2;
                    break;
                case 1:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -3;
                    break;
                case 2:
                    f11 = this.nullableFloatAdapter.fromJson(jsonReader2);
                    i11 &= -5;
                    break;
                case 3:
                    l11 = this.nullableLongAdapter.fromJson(jsonReader2);
                    i11 &= -9;
                    break;
                case 4:
                    networkCampaignProgressState = this.nullableNetworkCampaignProgressStateAdapter.fromJson(jsonReader2);
                    i11 &= -17;
                    break;
                case 5:
                    bool = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -33;
                    break;
                case 6:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -65;
                    break;
            }
        }
        jsonReader.endObject();
        if (i11 == -128) {
            return new NetworkCampaignProgress(str, str2, f11, l11, networkCampaignProgressState, bool, str3);
        }
        Constructor<NetworkCampaignProgress> constructor = this.constructorRef;
        if (constructor == null) {
            Class<String> cls = String.class;
            constructor = NetworkCampaignProgress.class.getDeclaredConstructor(new Class[]{cls, cls, Float.class, Long.class, NetworkCampaignProgressState.class, Boolean.class, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "NetworkCampaignProgress:…his.constructorRef = it }");
        }
        NetworkCampaignProgress newInstance = constructor.newInstance(new Object[]{str, str2, f11, l11, networkCampaignProgressState, bool, str3, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable NetworkCampaignProgress networkCampaignProgress) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (networkCampaignProgress != null) {
            jsonWriter.beginObject();
            jsonWriter.name(ViewHierarchyConstants.ICON_BITMAP);
            this.nullableStringAdapter.toJson(jsonWriter, networkCampaignProgress.getIconImage());
            jsonWriter.name("message");
            this.nullableStringAdapter.toJson(jsonWriter, networkCampaignProgress.getMessage());
            jsonWriter.name("progress_value");
            this.nullableFloatAdapter.toJson(jsonWriter, networkCampaignProgress.getProgressValue());
            jsonWriter.name("show_for_seconds");
            this.nullableLongAdapter.toJson(jsonWriter, networkCampaignProgress.getShowForSeconds());
            jsonWriter.name("view_state");
            this.nullableNetworkCampaignProgressStateAdapter.toJson(jsonWriter, networkCampaignProgress.getState());
            jsonWriter.name("is_tpro_campaign");
            this.nullableBooleanAdapter.toJson(jsonWriter, networkCampaignProgress.isTPro());
            jsonWriter.name("message_source");
            this.nullableStringAdapter.toJson(jsonWriter, networkCampaignProgress.getMessageSource());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
