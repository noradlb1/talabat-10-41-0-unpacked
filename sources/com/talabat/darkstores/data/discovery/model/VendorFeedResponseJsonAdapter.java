package com.talabat.darkstores.data.discovery.model;

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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/VendorFeedResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/data/discovery/model/VendorFeedResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableFeedResponseAdapter", "Lcom/talabat/darkstores/data/discovery/model/FeedResponse;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorFeedResponseJsonAdapter extends JsonAdapter<VendorFeedResponse> {
    @Nullable
    private volatile Constructor<VendorFeedResponse> constructorRef;
    @NotNull
    private final JsonAdapter<FeedResponse> nullableFeedResponseAdapter;
    @NotNull
    private final JsonReader.Options options;

    public VendorFeedResponseJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("feed");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"feed\")");
        this.options = of2;
        JsonAdapter<FeedResponse> adapter = moshi.adapter(FeedResponse.class, SetsKt__SetsKt.emptySet(), "feed");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(FeedRespon…java, emptySet(), \"feed\")");
        this.nullableFeedResponseAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("VendorFeedResponse");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public VendorFeedResponse fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        FeedResponse feedResponse = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                feedResponse = this.nullableFeedResponseAdapter.fromJson(jsonReader);
                i11 &= -2;
            }
        }
        jsonReader.endObject();
        if (i11 == -2) {
            return new VendorFeedResponse(feedResponse);
        }
        Constructor<VendorFeedResponse> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = VendorFeedResponse.class.getDeclaredConstructor(new Class[]{FeedResponse.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "VendorFeedResponse::clas…his.constructorRef = it }");
        }
        VendorFeedResponse newInstance = constructor.newInstance(new Object[]{feedResponse, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable VendorFeedResponse vendorFeedResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (vendorFeedResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("feed");
            this.nullableFeedResponseAdapter.toJson(jsonWriter, vendorFeedResponse.getFeed());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
