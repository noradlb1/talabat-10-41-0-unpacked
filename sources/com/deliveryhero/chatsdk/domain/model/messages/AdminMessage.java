package com.deliveryhero.chatsdk.domain.model.messages;

import com.deliveryhero.chatsdk.domain.model.MetaData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001%B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006&"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/model/messages/AdminMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "id", "", "channelId", "timestamp", "", "metadata", "Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "userNickname", "type", "Lcom/deliveryhero/chatsdk/domain/model/messages/AdminMessage$Type;", "(Ljava/lang/String;Ljava/lang/String;JLcom/deliveryhero/chatsdk/domain/model/MetaData;Ljava/lang/String;Lcom/deliveryhero/chatsdk/domain/model/messages/AdminMessage$Type;)V", "getChannelId", "()Ljava/lang/String;", "getId", "getMetadata", "()Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "getTimestamp", "()J", "getType", "()Lcom/deliveryhero/chatsdk/domain/model/messages/AdminMessage$Type;", "getUserNickname", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Type", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AdminMessage implements Message {
    @NotNull
    private final String channelId;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29383id;
    @Nullable
    private final MetaData metadata;
    private final long timestamp;
    @NotNull
    private final Type type;
    @NotNull
    private final String userNickname;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/model/messages/AdminMessage$Type;", "", "(Ljava/lang/String;I)V", "JOINED", "LEFT", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Type {
        JOINED,
        LEFT
    }

    public AdminMessage(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData, @NotNull String str3, @NotNull Type type2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str3, "userNickname");
        Intrinsics.checkNotNullParameter(type2, "type");
        this.f29383id = str;
        this.channelId = str2;
        this.timestamp = j11;
        this.metadata = metaData;
        this.userNickname = str3;
        this.type = type2;
    }

    public static /* synthetic */ AdminMessage copy$default(AdminMessage adminMessage, String str, String str2, long j11, MetaData metaData, String str3, Type type2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = adminMessage.getId();
        }
        if ((i11 & 2) != 0) {
            str2 = adminMessage.getChannelId();
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            j11 = adminMessage.getTimestamp();
        }
        long j12 = j11;
        if ((i11 & 8) != 0) {
            metaData = adminMessage.getMetadata();
        }
        MetaData metaData2 = metaData;
        if ((i11 & 16) != 0) {
            str3 = adminMessage.userNickname;
        }
        String str5 = str3;
        if ((i11 & 32) != 0) {
            type2 = adminMessage.type;
        }
        return adminMessage.copy(str, str4, j12, metaData2, str5, type2);
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @NotNull
    public final String component2() {
        return getChannelId();
    }

    public final long component3() {
        return getTimestamp();
    }

    @Nullable
    public final MetaData component4() {
        return getMetadata();
    }

    @NotNull
    public final String component5() {
        return this.userNickname;
    }

    @NotNull
    public final Type component6() {
        return this.type;
    }

    @NotNull
    public final AdminMessage copy(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData, @NotNull String str3, @NotNull Type type2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str3, "userNickname");
        Type type3 = type2;
        Intrinsics.checkNotNullParameter(type3, "type");
        return new AdminMessage(str, str2, j11, metaData, str3, type3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdminMessage)) {
            return false;
        }
        AdminMessage adminMessage = (AdminMessage) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) adminMessage.getId()) && Intrinsics.areEqual((Object) getChannelId(), (Object) adminMessage.getChannelId()) && getTimestamp() == adminMessage.getTimestamp() && Intrinsics.areEqual((Object) getMetadata(), (Object) adminMessage.getMetadata()) && Intrinsics.areEqual((Object) this.userNickname, (Object) adminMessage.userNickname) && this.type == adminMessage.type;
    }

    @NotNull
    public String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public String getId() {
        return this.f29383id;
    }

    @Nullable
    public MetaData getMetadata() {
        return this.metadata;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    @NotNull
    public final String getUserNickname() {
        return this.userNickname;
    }

    public int hashCode() {
        return (((((((((getId().hashCode() * 31) + getChannelId().hashCode()) * 31) + a.a(getTimestamp())) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31) + this.userNickname.hashCode()) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdminMessage(id=" + getId() + ", channelId=" + getChannelId() + ", timestamp=" + getTimestamp() + ", metadata=" + getMetadata() + ", userNickname=" + this.userNickname + ", type=" + this.type + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdminMessage(String str, String str2, long j11, MetaData metaData, String str3, Type type2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j11, (i11 & 8) != 0 ? null : metaData, str3, type2);
    }
}
