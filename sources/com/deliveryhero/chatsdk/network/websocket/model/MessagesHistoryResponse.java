package com.deliveryhero.chatsdk.network.websocket.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/MessagesHistoryResponse;", "", "correlationId", "", "messages", "", "Lcom/deliveryhero/chatsdk/network/websocket/model/IncomingWebSocketMessage;", "(Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getMessages", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessagesHistoryResponse {
    @NotNull
    private final String correlationId;
    @NotNull
    private final List<IncomingWebSocketMessage> messages;

    public MessagesHistoryResponse(@NotNull @Json(name = "correlation_id") String str, @NotNull @Json(name = "messages") List<? extends IncomingWebSocketMessage> list) {
        Intrinsics.checkNotNullParameter(str, "correlationId");
        Intrinsics.checkNotNullParameter(list, "messages");
        this.correlationId = str;
        this.messages = list;
    }

    public static /* synthetic */ MessagesHistoryResponse copy$default(MessagesHistoryResponse messagesHistoryResponse, String str, List<IncomingWebSocketMessage> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = messagesHistoryResponse.correlationId;
        }
        if ((i11 & 2) != 0) {
            list = messagesHistoryResponse.messages;
        }
        return messagesHistoryResponse.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.correlationId;
    }

    @NotNull
    public final List<IncomingWebSocketMessage> component2() {
        return this.messages;
    }

    @NotNull
    public final MessagesHistoryResponse copy(@NotNull @Json(name = "correlation_id") String str, @NotNull @Json(name = "messages") List<? extends IncomingWebSocketMessage> list) {
        Intrinsics.checkNotNullParameter(str, "correlationId");
        Intrinsics.checkNotNullParameter(list, "messages");
        return new MessagesHistoryResponse(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessagesHistoryResponse)) {
            return false;
        }
        MessagesHistoryResponse messagesHistoryResponse = (MessagesHistoryResponse) obj;
        return Intrinsics.areEqual((Object) this.correlationId, (Object) messagesHistoryResponse.correlationId) && Intrinsics.areEqual((Object) this.messages, (Object) messagesHistoryResponse.messages);
    }

    @NotNull
    public final String getCorrelationId() {
        return this.correlationId;
    }

    @NotNull
    public final List<IncomingWebSocketMessage> getMessages() {
        return this.messages;
    }

    public int hashCode() {
        return (this.correlationId.hashCode() * 31) + this.messages.hashCode();
    }

    @NotNull
    public String toString() {
        return "MessagesHistoryResponse(correlationId=" + this.correlationId + ", messages=" + this.messages + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessagesHistoryResponse(String str, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
