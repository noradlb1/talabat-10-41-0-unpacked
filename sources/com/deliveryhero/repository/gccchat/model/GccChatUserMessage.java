package com.deliveryhero.repository.gccchat.model;

import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.User;
import com.deliveryhero.contract.model.UserMessage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J_\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/deliveryhero/repository/gccchat/model/GccChatUserMessage;", "Lcom/deliveryhero/contract/model/UserMessage;", "messageId", "", "createdAt", "", "message", "translations", "", "sender", "Lcom/deliveryhero/contract/model/User;", "metadata", "Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "correlationId", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/Map;Lcom/deliveryhero/contract/model/User;Lcom/deliveryhero/contract/model/BaseMessage$MetaData;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getCreatedAt", "()J", "getMessage", "getMessageId", "getMetadata", "()Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "getSender", "()Lcom/deliveryhero/contract/model/User;", "getTranslations", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccChatUserMessage implements UserMessage {
    @Nullable
    private final String correlationId;
    private final long createdAt;
    @NotNull
    private final String message;
    @NotNull
    private final String messageId;
    @Nullable
    private final BaseMessage.MetaData metadata;
    @NotNull
    private final User sender;
    @NotNull
    private final Map<String, String> translations;

    public GccChatUserMessage(@NotNull String str, long j11, @NotNull String str2, @NotNull Map<String, String> map, @NotNull User user, @Nullable BaseMessage.MetaData metaData, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(map, "translations");
        Intrinsics.checkNotNullParameter(user, "sender");
        this.messageId = str;
        this.createdAt = j11;
        this.message = str2;
        this.translations = map;
        this.sender = user;
        this.metadata = metaData;
        this.correlationId = str3;
    }

    public static /* synthetic */ GccChatUserMessage copy$default(GccChatUserMessage gccChatUserMessage, String str, long j11, String str2, Map map, User user, BaseMessage.MetaData metaData, String str3, int i11, Object obj) {
        return gccChatUserMessage.copy((i11 & 1) != 0 ? gccChatUserMessage.getMessageId() : str, (i11 & 2) != 0 ? gccChatUserMessage.getCreatedAt() : j11, (i11 & 4) != 0 ? gccChatUserMessage.getMessage() : str2, (i11 & 8) != 0 ? gccChatUserMessage.getTranslations() : map, (i11 & 16) != 0 ? gccChatUserMessage.getSender() : user, (i11 & 32) != 0 ? gccChatUserMessage.getMetadata() : metaData, (i11 & 64) != 0 ? gccChatUserMessage.getCorrelationId() : str3);
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

    @NotNull
    public final Map<String, String> component4() {
        return getTranslations();
    }

    @NotNull
    public final User component5() {
        return getSender();
    }

    @Nullable
    public final BaseMessage.MetaData component6() {
        return getMetadata();
    }

    @Nullable
    public final String component7() {
        return getCorrelationId();
    }

    @NotNull
    public final GccChatUserMessage copy(@NotNull String str, long j11, @NotNull String str2, @NotNull Map<String, String> map, @NotNull User user, @Nullable BaseMessage.MetaData metaData, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(map, "translations");
        User user2 = user;
        Intrinsics.checkNotNullParameter(user2, "sender");
        return new GccChatUserMessage(str, j11, str2, map, user2, metaData, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GccChatUserMessage)) {
            return false;
        }
        GccChatUserMessage gccChatUserMessage = (GccChatUserMessage) obj;
        return Intrinsics.areEqual((Object) getMessageId(), (Object) gccChatUserMessage.getMessageId()) && getCreatedAt() == gccChatUserMessage.getCreatedAt() && Intrinsics.areEqual((Object) getMessage(), (Object) gccChatUserMessage.getMessage()) && Intrinsics.areEqual((Object) getTranslations(), (Object) gccChatUserMessage.getTranslations()) && Intrinsics.areEqual((Object) getSender(), (Object) gccChatUserMessage.getSender()) && Intrinsics.areEqual((Object) getMetadata(), (Object) gccChatUserMessage.getMetadata()) && Intrinsics.areEqual((Object) getCorrelationId(), (Object) gccChatUserMessage.getCorrelationId());
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

    @NotNull
    public User getSender() {
        return this.sender;
    }

    @NotNull
    public Map<String, String> getTranslations() {
        return this.translations;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((getMessageId().hashCode() * 31) + a.a(getCreatedAt())) * 31) + getMessage().hashCode()) * 31) + getTranslations().hashCode()) * 31) + getSender().hashCode()) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31;
        if (getCorrelationId() != null) {
            i11 = getCorrelationId().hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "GccChatUserMessage(messageId=" + getMessageId() + ", createdAt=" + getCreatedAt() + ", message=" + getMessage() + ", translations=" + getTranslations() + ", sender=" + getSender() + ", metadata=" + getMetadata() + ", correlationId=" + getCorrelationId() + ')';
    }
}
