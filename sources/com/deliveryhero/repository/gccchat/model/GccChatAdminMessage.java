package com.deliveryhero.repository.gccchat.model;

import com.deliveryhero.contract.model.AdminMessage;
import com.deliveryhero.contract.model.BaseMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/deliveryhero/repository/gccchat/model/GccChatAdminMessage;", "Lcom/deliveryhero/contract/model/AdminMessage;", "messageId", "", "createdAt", "", "message", "metadata", "Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "correlationId", "(Ljava/lang/String;JLjava/lang/String;Lcom/deliveryhero/contract/model/BaseMessage$MetaData;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getCreatedAt", "()J", "getMessage", "getMessageId", "getMetadata", "()Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccChatAdminMessage implements AdminMessage {
    @Nullable
    private final String correlationId;
    private final long createdAt;
    @NotNull
    private final String message;
    @NotNull
    private final String messageId;
    @Nullable
    private final BaseMessage.MetaData metadata;

    public GccChatAdminMessage(@NotNull String str, long j11, @NotNull String str2, @Nullable BaseMessage.MetaData metaData, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(str2, "message");
        this.messageId = str;
        this.createdAt = j11;
        this.message = str2;
        this.metadata = metaData;
        this.correlationId = str3;
    }

    public static /* synthetic */ GccChatAdminMessage copy$default(GccChatAdminMessage gccChatAdminMessage, String str, long j11, String str2, BaseMessage.MetaData metaData, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gccChatAdminMessage.getMessageId();
        }
        if ((i11 & 2) != 0) {
            j11 = gccChatAdminMessage.getCreatedAt();
        }
        long j12 = j11;
        if ((i11 & 4) != 0) {
            str2 = gccChatAdminMessage.getMessage();
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            metaData = gccChatAdminMessage.getMetadata();
        }
        BaseMessage.MetaData metaData2 = metaData;
        if ((i11 & 16) != 0) {
            str3 = gccChatAdminMessage.getCorrelationId();
        }
        return gccChatAdminMessage.copy(str, j12, str4, metaData2, str3);
    }

    @NotNull
    public final String component1() {
        return getMessageId();
    }

    public final long component2() {
        return getCreatedAt();
    }

    @NotNull
    public final String component3() {
        return getMessage();
    }

    @Nullable
    public final BaseMessage.MetaData component4() {
        return getMetadata();
    }

    @Nullable
    public final String component5() {
        return getCorrelationId();
    }

    @NotNull
    public final GccChatAdminMessage copy(@NotNull String str, long j11, @NotNull String str2, @Nullable BaseMessage.MetaData metaData, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(str2, "message");
        return new GccChatAdminMessage(str, j11, str2, metaData, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GccChatAdminMessage)) {
            return false;
        }
        GccChatAdminMessage gccChatAdminMessage = (GccChatAdminMessage) obj;
        return Intrinsics.areEqual((Object) getMessageId(), (Object) gccChatAdminMessage.getMessageId()) && getCreatedAt() == gccChatAdminMessage.getCreatedAt() && Intrinsics.areEqual((Object) getMessage(), (Object) gccChatAdminMessage.getMessage()) && Intrinsics.areEqual((Object) getMetadata(), (Object) gccChatAdminMessage.getMetadata()) && Intrinsics.areEqual((Object) getCorrelationId(), (Object) gccChatAdminMessage.getCorrelationId());
    }

    @Nullable
    public String getCorrelationId() {
        return this.correlationId;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    public String getMessage() {
        return this.message;
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
        int hashCode = ((((((getMessageId().hashCode() * 31) + a.a(getCreatedAt())) * 31) + getMessage().hashCode()) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31;
        if (getCorrelationId() != null) {
            i11 = getCorrelationId().hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "GccChatAdminMessage(messageId=" + getMessageId() + ", createdAt=" + getCreatedAt() + ", message=" + getMessage() + ", metadata=" + getMetadata() + ", correlationId=" + getCorrelationId() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GccChatAdminMessage(String str, long j11, String str2, BaseMessage.MetaData metaData, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11, str2, metaData, (i11 & 16) != 0 ? null : str3);
    }
}
