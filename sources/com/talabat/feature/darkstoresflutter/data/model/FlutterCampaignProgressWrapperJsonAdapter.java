package com.talabat.feature.darkstoresflutter.data.model;

import com.facebook.internal.FacebookRequestErrorClassification;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgressWrapperJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgressWrapper;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableFlutterCampaignProgressAdapter", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgress;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCampaignProgressWrapperJsonAdapter extends JsonAdapter<FlutterCampaignProgressWrapper> {
    @Nullable
    private volatile Constructor<FlutterCampaignProgressWrapper> constructorRef;
    @NotNull
    private final JsonAdapter<FlutterCampaignProgress> nullableFlutterCampaignProgressAdapter;
    @NotNull
    private final JsonReader.Options options;

    public FlutterCampaignProgressWrapperJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("permanent", FacebookRequestErrorClassification.KEY_TRANSIENT);
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"permanent\", \"transient\")");
        this.options = of2;
        JsonAdapter<FlutterCampaignProgress> adapter = moshi.adapter(FlutterCampaignProgress.class, SetsKt__SetsKt.emptySet(), "permanent");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(FlutterCam… emptySet(), \"permanent\")");
        this.nullableFlutterCampaignProgressAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FlutterCampaignProgressWrapper");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public FlutterCampaignProgressWrapper fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        FlutterCampaignProgress flutterCampaignProgress = null;
        FlutterCampaignProgress flutterCampaignProgress2 = null;
        int i11 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                flutterCampaignProgress = this.nullableFlutterCampaignProgressAdapter.fromJson(jsonReader);
                i11 &= -2;
            } else if (selectName == 1) {
                flutterCampaignProgress2 = this.nullableFlutterCampaignProgressAdapter.fromJson(jsonReader);
                i11 &= -3;
            }
        }
        jsonReader.endObject();
        if (i11 == -4) {
            return new FlutterCampaignProgressWrapper(flutterCampaignProgress, flutterCampaignProgress2);
        }
        Constructor<FlutterCampaignProgressWrapper> constructor = this.constructorRef;
        if (constructor == null) {
            Class<FlutterCampaignProgress> cls = FlutterCampaignProgress.class;
            constructor = FlutterCampaignProgressWrapper.class.getDeclaredConstructor(new Class[]{cls, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "FlutterCampaignProgressW…his.constructorRef = it }");
        }
        FlutterCampaignProgressWrapper newInstance = constructor.newInstance(new Object[]{flutterCampaignProgress, flutterCampaignProgress2, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable FlutterCampaignProgressWrapper flutterCampaignProgressWrapper) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (flutterCampaignProgressWrapper != null) {
            jsonWriter.beginObject();
            jsonWriter.name("permanent");
            this.nullableFlutterCampaignProgressAdapter.toJson(jsonWriter, flutterCampaignProgressWrapper.getPermanent());
            jsonWriter.name(FacebookRequestErrorClassification.KEY_TRANSIENT);
            this.nullableFlutterCampaignProgressAdapter.toJson(jsonWriter, flutterCampaignProgressWrapper.getTransient());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
