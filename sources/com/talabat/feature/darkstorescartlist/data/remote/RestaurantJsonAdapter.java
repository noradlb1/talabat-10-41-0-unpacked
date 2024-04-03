package com.talabat.feature.darkstorescartlist.data.remote;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.ToJson;
import datamodels.Restaurant;
import java.lang.reflect.Type;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/remote/RestaurantJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Ldatamodels/Restaurant;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantJsonAdapter extends JsonAdapter<Restaurant> {
    @NotNull
    private final Gson gson;

    @Inject
    public RestaurantJsonAdapter(@NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
    }

    @FromJson
    @Nullable
    public Restaurant fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Gson gson2 = this.gson;
        Object readJsonValue = jsonReader.readJsonValue();
        String json = !(gson2 instanceof Gson) ? gson2.toJson(readJsonValue) : GsonInstrumentation.toJson(gson2, readJsonValue);
        Class cls = Restaurant.class;
        return (Restaurant) (!(gson2 instanceof Gson) ? gson2.fromJson(json, cls) : GsonInstrumentation.fromJson(gson2, json, cls));
    }

    @ToJson
    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        Gson gson2 = this.gson;
        String json = !(gson2 instanceof Gson) ? gson2.toJson((Object) restaurant) : GsonInstrumentation.toJson(gson2, (Object) restaurant);
        Type type = new RestaurantJsonAdapter$toJson$1().getType();
        jsonWriter.jsonValue(!(gson2 instanceof Gson) ? gson2.fromJson(json, type) : GsonInstrumentation.fromJson(gson2, json, type));
    }
}
