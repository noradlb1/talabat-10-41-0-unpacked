package com.deliveryhero.repository.gccchat.model;

import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.ConfigUpdateMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/deliveryhero/repository/gccchat/model/GccChatConfigUpdateMessage;", "Lcom/deliveryhero/contract/model/ConfigUpdateMessage;", "messageId", "", "createdAt", "", "metadata", "Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "correlationId", "(Ljava/lang/String;JLcom/deliveryhero/contract/model/BaseMessage$MetaData;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getCreatedAt", "()J", "getMessageId", "getMetadata", "()Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccChatConfigUpdateMessage implements ConfigUpdateMessage {
    @Nullable
    private final String correlationId;
    private final long createdAt;
    @NotNull
    private final String messageId;
    @Nullable
    private final BaseMessage.MetaData metadata;

    public GccChatConfigUpdateMessage(@NotNull String str, long j11, @Nullable BaseMessage.MetaData metaData, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        this.messageId = str;
        this.createdAt = j11;
        this.metadata = metaData;
        this.correlationId = str2;
    }

    public static /* synthetic */ GccChatConfigUpdateMessage copy$default(GccChatConfigUpdateMessage gccChatConfigUpdateMessage, String str, long j11, BaseMessage.MetaData metaData, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gccChatConfigUpdateMessage.getMessageId();
        }
        if ((i11 & 2) != 0) {
            j11 = gccChatConfigUpdateMessage.getCreatedAt();
        }
        long j12 = j11;
        if ((i11 & 4) != 0) {
            metaData = gccChatConfigUpdateMessage.getMetadata();
        }
        BaseMessage.MetaData metaData2 = metaData;
        if ((i11 & 8) != 0) {
            str2 = gccChatConfigUpdateMessage.getCorrelationId();
        }
        return gccChatConfigUpdateMessage.copy(str, j12, metaData2, str2);
    }

    @NotNull
    public final String component1() {
        return getMessageId();
    }

    public final long component2() {
        return getCreatedAt();
    }

    @Nullable
    public final BaseMessage.MetaData component3() {
        return getMetadata();
    }

    @Nullable
    public final String component4() {
        return getCorrelationId();
    }

    @NotNull
    public final GccChatConfigUpdateMessage copy(@NotNull String str, long j11, @Nullable BaseMessage.MetaData metaData, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        return new GccChatConfigUpdateMessage(str, j11, metaData, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GccChatConfigUpdateMessage)) {
            return false;
        }
        GccChatConfigUpdateMessage gccChatConfigUpdateMessage = (GccChatConfigUpdateMessage) obj;
        return Intrinsics.areEqual((Object) getMessageId(), (Object) gccChatConfigUpdateMessage.getMessageId()) && getCreatedAt() == gccChatConfigUpdateMessage.getCreatedAt() && Intrinsics.areEqual((Object) getMetadata(), (Object) gccChatConfigUpdateMessage.getMetadata()) && Intrinsics.areEqual((Object) getCorrelationId(), (Object) gccChatConfigUpdateMessage.getCorrelationId());
    }

    @Nullable
    public String getCorrelationId() {
        return this.correlationId;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    public String getMessageId() {
        return this.messageId;
    }

    @Nullable
    public BaseMessage.MetaData getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getMessageId().hashCode() * 31) + a.a(getCreatedAt())) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31;
        if (getCorrelationId() != null) {
            i11 = getCorrelationId().hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "GccChatConfigUpdateMessage(messageId=" + getMessageId() + ", createdAt=" + getCreatedAt() + ", metadata=" + getMetadata() + ", correlationId=" + getCorrelationId() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GccChatConfigUpdateMessage(String str, long j11, BaseMessage.MetaData metaData, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11, (i11 & 4) != 0 ? null : metaData, (i11 & 8) != 0 ? null : str2);
    }
}
