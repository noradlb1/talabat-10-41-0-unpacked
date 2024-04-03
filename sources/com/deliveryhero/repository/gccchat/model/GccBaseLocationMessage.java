package com.deliveryhero.repository.gccchat.model;

import com.deliveryhero.contract.model.BaseLocationMessage;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.User;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/deliveryhero/repository/gccchat/model/GccBaseLocationMessage;", "Lcom/deliveryhero/contract/model/BaseLocationMessage;", "messageId", "", "createdAt", "", "latitude", "", "longitude", "sender", "Lcom/deliveryhero/contract/model/User;", "metadata", "Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "correlationId", "(Ljava/lang/String;JDDLcom/deliveryhero/contract/model/User;Lcom/deliveryhero/contract/model/BaseMessage$MetaData;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getCreatedAt", "()J", "getLatitude", "()D", "getLongitude", "getMessageId", "getMetadata", "()Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "getSender", "()Lcom/deliveryhero/contract/model/User;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccBaseLocationMessage implements BaseLocationMessage {
    @Nullable
    private final String correlationId;
    private final long createdAt;
    private final double latitude;
    private final double longitude;
    @NotNull
    private final String messageId;
    @Nullable
    private final BaseMessage.MetaData metadata;
    @NotNull
    private final User sender;

    public GccBaseLocationMessage(@NotNull String str, long j11, double d11, double d12, @NotNull User user, @Nullable BaseMessage.MetaData metaData, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(user, "sender");
        this.messageId = str;
        this.createdAt = j11;
        this.latitude = d11;
        this.longitude = d12;
        this.sender = user;
        this.metadata = metaData;
        this.correlationId = str2;
    }

    public static /* synthetic */ GccBaseLocationMessage copy$default(GccBaseLocationMessage gccBaseLocationMessage, String str, long j11, double d11, double d12, User user, BaseMessage.MetaData metaData, String str2, int i11, Object obj) {
        return gccBaseLocationMessage.copy((i11 & 1) != 0 ? gccBaseLocationMessage.getMessageId() : str, (i11 & 2) != 0 ? gccBaseLocationMessage.getCreatedAt() : j11, (i11 & 4) != 0 ? gccBaseLocationMessage.getLatitude() : d11, (i11 & 8) != 0 ? gccBaseLocationMessage.getLongitude() : d12, (i11 & 16) != 0 ? gccBaseLocationMessage.getSender() : user, (i11 & 32) != 0 ? gccBaseLocationMessage.getMetadata() : metaData, (i11 & 64) != 0 ? gccBaseLocationMessage.getCorrelationId() : str2);
    }

    @NotNull
    public final String component1() {
        return getMessageId();
    }

    public final long component2() {
        return getCreatedAt();
    }

    public final double component3() {
        return getLatitude();
    }

    public final double component4() {
        return getLongitude();
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
    public final GccBaseLocationMessage copy(@NotNull String str, long j11, double d11, double d12, @NotNull User user, @Nullable BaseMessage.MetaData metaData, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        User user2 = user;
        Intrinsics.checkNotNullParameter(user2, "sender");
        return new GccBaseLocationMessage(str, j11, d11, d12, user2, metaData, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GccBaseLocationMessage)) {
            return false;
        }
        GccBaseLocationMessage gccBaseLocationMessage = (GccBaseLocationMessage) obj;
        return Intrinsics.areEqual((Object) getMessageId(), (Object) gccBaseLocationMessage.getMessageId()) && getCreatedAt() == gccBaseLocationMessage.getCreatedAt() && Intrinsics.areEqual((Object) Double.valueOf(getLatitude()), (Object) Double.valueOf(gccBaseLocationMessage.getLatitude())) && Intrinsics.areEqual((Object) Double.valueOf(getLongitude()), (Object) Double.valueOf(gccBaseLocationMessage.getLongitude())) && Intrinsics.areEqual((Object) getSender(), (Object) gccBaseLocationMessage.getSender()) && Intrinsics.areEqual((Object) getMetadata(), (Object) gccBaseLocationMessage.getMetadata()) && Intrinsics.areEqual((Object) getCorrelationId(), (Object) gccBaseLocationMessage.getCorrelationId());
    }

    @Nullable
    public String getCorrelationId() {
        return this.correlationId;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
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

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((getMessageId().hashCode() * 31) + a.a(getCreatedAt())) * 31) + Double.doubleToLongBits(getLatitude())) * 31) + Double.doubleToLongBits(getLongitude())) * 31) + getSender().hashCode()) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31;
        if (getCorrelationId() != null) {
            i11 = getCorrelationId().hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "GccBaseLocationMessage(messageId=" + getMessageId() + ", createdAt=" + getCreatedAt() + ", latitude=" + getLatitude() + ", longitude=" + getLongitude() + ", sender=" + getSender() + ", metadata=" + getMetadata() + ", correlationId=" + getCorrelationId() + ')';
    }
}
