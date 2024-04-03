package com.deliveryhero.repository.gccchat.model;

import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.FileMessage;
import com.deliveryhero.contract.model.User;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006+"}, d2 = {"Lcom/deliveryhero/repository/gccchat/model/GccChatFileMessage;", "Lcom/deliveryhero/contract/model/FileMessage;", "messageId", "", "createdAt", "", "sender", "Lcom/deliveryhero/contract/model/User;", "url", "thumbnails", "", "Lcom/deliveryhero/contract/model/FileMessage$Thumbnail;", "metadata", "Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "correlationId", "(Ljava/lang/String;JLcom/deliveryhero/contract/model/User;Ljava/lang/String;Ljava/util/List;Lcom/deliveryhero/contract/model/BaseMessage$MetaData;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getCreatedAt", "()J", "getMessageId", "getMetadata", "()Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "getSender", "()Lcom/deliveryhero/contract/model/User;", "getThumbnails", "()Ljava/util/List;", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccChatFileMessage implements FileMessage {
    @Nullable
    private final String correlationId;
    private final long createdAt;
    @NotNull
    private final String messageId;
    @Nullable
    private final BaseMessage.MetaData metadata;
    @NotNull
    private final User sender;
    @NotNull
    private final List<FileMessage.Thumbnail> thumbnails;
    @NotNull
    private final String url;

    public GccChatFileMessage(@NotNull String str, long j11, @NotNull User user, @NotNull String str2, @NotNull List<FileMessage.Thumbnail> list, @Nullable BaseMessage.MetaData metaData, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(user, "sender");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(list, "thumbnails");
        this.messageId = str;
        this.createdAt = j11;
        this.sender = user;
        this.url = str2;
        this.thumbnails = list;
        this.metadata = metaData;
        this.correlationId = str3;
    }

    public static /* synthetic */ GccChatFileMessage copy$default(GccChatFileMessage gccChatFileMessage, String str, long j11, User user, String str2, List list, BaseMessage.MetaData metaData, String str3, int i11, Object obj) {
        return gccChatFileMessage.copy((i11 & 1) != 0 ? gccChatFileMessage.getMessageId() : str, (i11 & 2) != 0 ? gccChatFileMessage.getCreatedAt() : j11, (i11 & 4) != 0 ? gccChatFileMessage.getSender() : user, (i11 & 8) != 0 ? gccChatFileMessage.getUrl() : str2, (i11 & 16) != 0 ? gccChatFileMessage.getThumbnails() : list, (i11 & 32) != 0 ? gccChatFileMessage.getMetadata() : metaData, (i11 & 64) != 0 ? gccChatFileMessage.getCorrelationId() : str3);
    }

    @NotNull
    public final String component1() {
        return getMessageId();
    }

    public final long component2() {
        return getCreatedAt();
    }

    @NotNull
    public final User component3() {
        return getSender();
    }

    @NotNull
    public final String component4() {
        return getUrl();
    }

    @NotNull
    public final List<FileMessage.Thumbnail> component5() {
        return getThumbnails();
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
    public final GccChatFileMessage copy(@NotNull String str, long j11, @NotNull User user, @NotNull String str2, @NotNull List<FileMessage.Thumbnail> list, @Nullable BaseMessage.MetaData metaData, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(user, "sender");
        Intrinsics.checkNotNullParameter(str2, "url");
        List<FileMessage.Thumbnail> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "thumbnails");
        return new GccChatFileMessage(str, j11, user, str2, list2, metaData, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GccChatFileMessage)) {
            return false;
        }
        GccChatFileMessage gccChatFileMessage = (GccChatFileMessage) obj;
        return Intrinsics.areEqual((Object) getMessageId(), (Object) gccChatFileMessage.getMessageId()) && getCreatedAt() == gccChatFileMessage.getCreatedAt() && Intrinsics.areEqual((Object) getSender(), (Object) gccChatFileMessage.getSender()) && Intrinsics.areEqual((Object) getUrl(), (Object) gccChatFileMessage.getUrl()) && Intrinsics.areEqual((Object) getThumbnails(), (Object) gccChatFileMessage.getThumbnails()) && Intrinsics.areEqual((Object) getMetadata(), (Object) gccChatFileMessage.getMetadata()) && Intrinsics.areEqual((Object) getCorrelationId(), (Object) gccChatFileMessage.getCorrelationId());
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

    @NotNull
    public User getSender() {
        return this.sender;
    }

    @NotNull
    public List<FileMessage.Thumbnail> getThumbnails() {
        return this.thumbnails;
    }

    @NotNull
    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((getMessageId().hashCode() * 31) + a.a(getCreatedAt())) * 31) + getSender().hashCode()) * 31) + getUrl().hashCode()) * 31) + getThumbnails().hashCode()) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31;
        if (getCorrelationId() != null) {
            i11 = getCorrelationId().hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "GccChatFileMessage(messageId=" + getMessageId() + ", createdAt=" + getCreatedAt() + ", sender=" + getSender() + ", url=" + getUrl() + ", thumbnails=" + getThumbnails() + ", metadata=" + getMetadata() + ", correlationId=" + getCorrelationId() + ')';
    }
}
