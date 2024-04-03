package com.talabat.feature.tmart.growth.data.remote.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder_BasicJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Basic;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthReminder_BasicJsonAdapter extends JsonAdapter<TMartGrowthReminder.Basic> {
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public TMartGrowthReminder_BasicJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("deep_link", "icon_image_url", "subtext", "text");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"deep_link\", \"icon_im…\n      \"subtext\", \"text\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "deeplink");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ySet(),\n      \"deeplink\")");
        this.stringAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TMartGrowthReminder.Basic");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public TMartGrowthReminder.Basic fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("deeplink", "deep_link", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"deeplink…     \"deep_link\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("iconUrl", "icon_image_url", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"iconUrl\"…\"icon_image_url\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str3 = this.stringAdapter.fromJson(jsonReader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("subtitle", "subtext", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"subtitle…       \"subtext\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (str4 = this.stringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("title", "text", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"title\", …ext\",\n            reader)");
                throw unexpectedNull4;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("deeplink", "deep_link", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"deeplink\", \"deep_link\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("iconUrl", "icon_image_url", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"iconUrl…\"icon_image_url\", reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("subtitle", "subtext", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"subtitle\", \"subtext\", reader)");
            throw missingProperty3;
        } else if (str4 != null) {
            return new TMartGrowthReminder.Basic(str, str2, str3, str4);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("title", "text", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"title\", \"text\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable TMartGrowthReminder.Basic basic) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (basic != null) {
            jsonWriter.beginObject();
            jsonWriter.name("deep_link");
            this.stringAdapter.toJson(jsonWriter, basic.getDeeplink());
            jsonWriter.name("icon_image_url");
            this.stringAdapter.toJson(jsonWriter, basic.getIconUrl());
            jsonWriter.name("subtext");
            this.stringAdapter.toJson(jsonWriter, basic.getSubtitle());
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, basic.getTitle());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
