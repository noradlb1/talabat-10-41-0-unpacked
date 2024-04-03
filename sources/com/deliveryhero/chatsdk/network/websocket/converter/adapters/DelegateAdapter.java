package com.deliveryhero.chatsdk.network.websocket.converter.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/converter/adapters/DelegateAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "delegate", "(Lcom/squareup/moshi/JsonAdapter;)V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "(Lcom/squareup/moshi/JsonReader;)Ljava/lang/Object;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "(Lcom/squareup/moshi/JsonWriter;Ljava/lang/Object;)V", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DelegateAdapter<T> extends JsonAdapter<T> {
    @NotNull
    private final JsonAdapter<T> delegate;

    public DelegateAdapter(@NotNull JsonAdapter<T> jsonAdapter) {
        Intrinsics.checkNotNullParameter(jsonAdapter, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = jsonAdapter;
    }

    @Nullable
    public T fromJson(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        return this.delegate.fromJson(jsonReader);
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable T t11) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        this.delegate.toJson(jsonWriter, t11);
    }
}
