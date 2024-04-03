package com.deliveryhero.chatsdk.domain.model.messages;

import com.deliveryhero.chatsdk.domain.model.MetaData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/model/messages/ConfigUpdateMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "id", "", "channelId", "timestamp", "", "metadata", "Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "(Ljava/lang/String;Ljava/lang/String;JLcom/deliveryhero/chatsdk/domain/model/MetaData;)V", "getChannelId", "()Ljava/lang/String;", "getId", "getMetadata", "()Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfigUpdateMessage implements Message {
    @NotNull
    private final String channelId;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29386id;
    @Nullable
    private final MetaData metadata;
    private final long timestamp;

    public ConfigUpdateMessage(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        this.f29386id = str;
        this.channelId = str2;
        this.timestamp = j11;
        this.metadata = metaData;
    }

    public static /* synthetic */ ConfigUpdateMessage copy$default(ConfigUpdateMessage configUpdateMessage, String str, String str2, long j11, MetaData metaData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = configUpdateMessage.getId();
        }
        if ((i11 & 2) != 0) {
            str2 = configUpdateMessage.getChannelId();
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            j11 = configUpdateMessage.getTimestamp();
        }
        long j12 = j11;
        if ((i11 & 8) != 0) {
            metaData = configUpdateMessage.getMetadata();
        }
        return configUpdateMessage.copy(str, str3, j12, metaData);
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
    public final ConfigUpdateMessage copy(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        return new ConfigUpdateMessage(str, str2, j11, metaData);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigUpdateMessage)) {
            return false;
        }
        ConfigUpdateMessage configUpdateMessage = (ConfigUpdateMessage) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) configUpdateMessage.getId()) && Intrinsics.areEqual((Object) getChannelId(), (Object) configUpdateMessage.getChannelId()) && getTimestamp() == configUpdateMessage.getTimestamp() && Intrinsics.areEqual((Object) getMetadata(), (Object) configUpdateMessage.getMetadata());
    }

    @NotNull
    public String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public String getId() {
        return this.f29386id;
    }

    @Nullable
    public MetaData getMetadata() {
        return this.metadata;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((getId().hashCode() * 31) + getChannelId().hashCode()) * 31) + a.a(getTimestamp())) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode());
    }

    @NotNull
    public String toString() {
        return "ConfigUpdateMessage(id=" + getId() + ", channelId=" + getChannelId() + ", timestamp=" + getTimestamp() + ", metadata=" + getMetadata() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConfigUpdateMessage(String str, String str2, long j11, MetaData metaData, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j11, (i11 & 8) != 0 ? null : metaData);
    }
}
