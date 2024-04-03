package com.deliveryhero.chatsdk.network.websocket.converter.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/converter/adapters/IgnoreUnknownListAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "", "elementAdapter", "(Lcom/squareup/moshi/JsonAdapter;)V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IgnoreUnknownListAdapter<T> extends JsonAdapter<List<? extends T>> {
    @NotNull
    private final JsonAdapter<T> elementAdapter;

    public IgnoreUnknownListAdapter(@NotNull JsonAdapter<T> jsonAdapter) {
        Intrinsics.checkNotNullParameter(jsonAdapter, "elementAdapter");
        this.elementAdapter = jsonAdapter;
    }

    @NotNull
    public List<T> fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            try {
                T fromJson = this.elementAdapter.fromJson(jsonReader.peekJson());
                if (fromJson != null) {
                    arrayList.add(fromJson);
                }
            } catch (JsonDataException unused) {
            }
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return arrayList;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable List<? extends T> list) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (list != null) {
            jsonWriter.beginArray();
            for (Object json : list) {
                this.elementAdapter.toJson(jsonWriter, json);
            }
            jsonWriter.endArray();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
