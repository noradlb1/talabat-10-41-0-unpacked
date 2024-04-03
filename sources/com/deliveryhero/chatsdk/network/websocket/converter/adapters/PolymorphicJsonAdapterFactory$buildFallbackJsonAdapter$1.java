package com.deliveryhero.chatsdk.network.websocket.converter.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/deliveryhero/chatsdk/network/websocket/converter/adapters/PolymorphicJsonAdapterFactory$buildFallbackJsonAdapter$1", "Lcom/squareup/moshi/JsonAdapter;", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolymorphicJsonAdapterFactory$buildFallbackJsonAdapter$1 extends JsonAdapter<Object> {
    final /* synthetic */ T $defaultValue;
    final /* synthetic */ PolymorphicJsonAdapterFactory<T> this$0;

    public PolymorphicJsonAdapterFactory$buildFallbackJsonAdapter$1(T t11, PolymorphicJsonAdapterFactory<T> polymorphicJsonAdapterFactory) {
        this.$defaultValue = t11;
        this.this$0 = polymorphicJsonAdapterFactory;
    }

    @Nullable
    public Object fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.skipValue();
        return this.$defaultValue;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Object obj) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected one of ");
        sb2.append(this.this$0.subtypes);
        sb2.append(" but found ");
        sb2.append(obj);
        sb2.append(", a ");
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        sb2.append(cls);
        sb2.append(". Register this subtype.");
        throw new IllegalArgumentException(sb2.toString());
    }
}
