package com.talabat.feature.darkstorescart.data.model;

import com.braze.models.inappmessage.InAppMessageBase;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo_TagJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Tag;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableColorResourceAdapter", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ColorResource;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductExtendedInfo_TagJsonAdapter extends JsonAdapter<ProductExtendedInfo.Tag> {
    @NotNull
    private final JsonAdapter<ProductExtendedInfo.ColorResource> nullableColorResourceAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public ProductExtendedInfo_TagJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("text", "icon", "background_color", InAppMessageBase.MESSAGE_TEXT_COLOR);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"text\", \"icon\",\n     …und_color\", \"text_color\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "text");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…      emptySet(), \"text\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<ProductExtendedInfo.ColorResource> adapter2 = moshi.adapter(ProductExtendedInfo.ColorResource.class, SetsKt__SetsKt.emptySet(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(ProductExt…Set(), \"backgroundColor\")");
        this.nullableColorResourceAdapter = adapter2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ProductExtendedInfo.Tag");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public ProductExtendedInfo.Tag fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        ProductExtendedInfo.ColorResource colorResource = null;
        ProductExtendedInfo.ColorResource colorResource2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                colorResource = this.nullableColorResourceAdapter.fromJson(jsonReader);
            } else if (selectName == 3) {
                colorResource2 = this.nullableColorResourceAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        return new ProductExtendedInfo.Tag(str, str2, colorResource, colorResource2);
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable ProductExtendedInfo.Tag tag) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (tag != null) {
            jsonWriter.beginObject();
            jsonWriter.name("text");
            this.nullableStringAdapter.toJson(jsonWriter, tag.getText());
            jsonWriter.name("icon");
            this.nullableStringAdapter.toJson(jsonWriter, tag.getIcon());
            jsonWriter.name("background_color");
            this.nullableColorResourceAdapter.toJson(jsonWriter, tag.getBackgroundColor());
            jsonWriter.name(InAppMessageBase.MESSAGE_TEXT_COLOR);
            this.nullableColorResourceAdapter.toJson(jsonWriter, tag.getTextColor());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
