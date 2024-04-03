package com.deliveryhero.chatsdk.network.websocket.converter.adapters;

import com.deliveryhero.chatsdk.network.websocket.model.IncomingWebSocketMessage;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/converter/adapters/IgnoreUnknownListAdapterFactory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "()V", "create", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IgnoreUnknownListAdapterFactory implements JsonAdapter.Factory {
    @Nullable
    public JsonAdapter<?> create(@NotNull Type type, @NotNull Set<? extends Annotation> set, @NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(set, "annotations");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        if ((!set.isEmpty()) || !(type instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getRawType() != List.class || parameterizedType.getActualTypeArguments()[0] != IncomingWebSocketMessage.class) {
            return null;
        }
        JsonAdapter adapter = moshi.adapter(parameterizedType.getActualTypeArguments()[0]);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(elementType)");
        return new IgnoreUnknownListAdapter(adapter).nullSafe();
    }
}
