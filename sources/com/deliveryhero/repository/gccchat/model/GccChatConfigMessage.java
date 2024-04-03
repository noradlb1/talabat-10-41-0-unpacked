package com.deliveryhero.repository.gccchat.model;

import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.ConfigMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/deliveryhero/repository/gccchat/model/GccChatConfigMessage;", "Lcom/deliveryhero/contract/model/ConfigMessage;", "messageId", "", "createdAt", "", "configs", "", "Lcom/deliveryhero/contract/model/ConfigMessage$Config;", "metadata", "Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "correlationId", "(Ljava/lang/String;JLjava/util/List;Lcom/deliveryhero/contract/model/BaseMessage$MetaData;Ljava/lang/String;)V", "getConfigs", "()Ljava/util/List;", "getCorrelationId", "()Ljava/lang/String;", "getCreatedAt", "()J", "getMessageId", "getMetadata", "()Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccChatConfigMessage implements ConfigMessage {
    @NotNull
    private final List<ConfigMessage.Config> configs;
    @Nullable
    private final String correlationId;
    private final long createdAt;
    @NotNull
    private final String messageId;
    @Nullable
    private final BaseMessage.MetaData metadata;

    public GccChatConfigMessage(@NotNull String str, long j11, @NotNull List<ConfigMessage.Config> list, @Nullable BaseMessage.MetaData metaData, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(list, "configs");
        this.messageId = str;
        this.createdAt = j11;
        this.configs = list;
        this.metadata = metaData;
        this.correlationId = str2;
    }

    public static /* synthetic */ GccChatConfigMessage copy$default(GccChatConfigMessage gccChatConfigMessage, String str, long j11, List<ConfigMessage.Config> list, BaseMessage.MetaData metaData, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gccChatConfigMessage.getMessageId();
        }
        if ((i11 & 2) != 0) {
            j11 = gccChatConfigMessage.getCreatedAt();
        }
        long j12 = j11;
        if ((i11 & 4) != 0) {
            list = gccChatConfigMessage.getConfigs();
        }
        List<ConfigMessage.Config> list2 = list;
        if ((i11 & 8) != 0) {
            metaData = gccChatConfigMessage.getMetadata();
        }
        BaseMessage.MetaData metaData2 = metaData;
        if ((i11 & 16) != 0) {
            str2 = gccChatConfigMessage.getCorrelationId();
        }
        return gccChatConfigMessage.copy(str, j12, list2, metaData2, str2);
    }

    @NotNull
    public final String component1() {
        return getMessageId();
    }

    public final long component2() {
        return getCreatedAt();
    }

    @NotNull
    public final List<ConfigMessage.Config> component3() {
        return getConfigs();
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
    public final GccChatConfigMessage copy(@NotNull String str, long j11, @NotNull List<ConfigMessage.Config> list, @Nullable BaseMessage.MetaData metaData, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(list, "configs");
        return new GccChatConfigMessage(str, j11, list, metaData, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GccChatConfigMessage)) {
            return false;
        }
        GccChatConfigMessage gccChatConfigMessage = (GccChatConfigMessage) obj;
        return Intrinsics.areEqual((Object) getMessageId(), (Object) gccChatConfigMessage.getMessageId()) && getCreatedAt() == gccChatConfigMessage.getCreatedAt() && Intrinsics.areEqual((Object) getConfigs(), (Object) gccChatConfigMessage.getConfigs()) && Intrinsics.areEqual((Object) getMetadata(), (Object) gccChatConfigMessage.getMetadata()) && Intrinsics.areEqual((Object) getCorrelationId(), (Object) gccChatConfigMessage.getCorrelationId());
    }

    @NotNull
    public List<ConfigMessage.Config> getConfigs() {
        return this.configs;
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
        int hashCode = ((((((getMessageId().hashCode() * 31) + a.a(getCreatedAt())) * 31) + getConfigs().hashCode()) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31;
        if (getCorrelationId() != null) {
            i11 = getCorrelationId().hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "GccChatConfigMessage(messageId=" + getMessageId() + ", createdAt=" + getCreatedAt() + ", configs=" + getConfigs() + ", metadata=" + getMetadata() + ", correlationId=" + getCorrelationId() + ')';
    }
}
