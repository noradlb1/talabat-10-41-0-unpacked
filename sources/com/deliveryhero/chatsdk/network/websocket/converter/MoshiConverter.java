package com.deliveryhero.chatsdk.network.websocket.converter;

import com.deliveryhero.chatsdk.network.websocket.okhttp.model.MessageEvent;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\b\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\r0\nH\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/converter/MoshiConverter;", "Lcom/deliveryhero/chatsdk/network/websocket/converter/Converter;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "serialize", "", "In", "data", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/String;", "tryConvert", "Out", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent;", "(Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent;Ljava/lang/Class;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MoshiConverter implements Converter {
    @NotNull
    private final Moshi moshi;

    public MoshiConverter(@NotNull Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.moshi = moshi2;
    }

    @NotNull
    public <In> String serialize(In in2, @NotNull Class<In> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        String json = this.moshi.adapter(cls).toJson(in2);
        Intrinsics.checkNotNullExpressionValue(json, "moshi.adapter(clazz).toJson(data)");
        return json;
    }

    @Nullable
    public <Out> Out tryConvert(@NotNull MessageEvent messageEvent, @NotNull Class<Out> cls) {
        Intrinsics.checkNotNullParameter(messageEvent, "data");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        try {
            if (messageEvent instanceof MessageEvent.TextReceived) {
                return this.moshi.adapter(cls).fromJson(((MessageEvent.TextReceived) messageEvent).getText());
            }
            if (messageEvent instanceof MessageEvent.ByteReceived) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        } catch (JsonDataException unused) {
            return null;
        }
    }
}
