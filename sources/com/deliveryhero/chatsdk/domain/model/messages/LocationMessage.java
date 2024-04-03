package com.deliveryhero.chatsdk.domain.model.messages;

import com.deliveryhero.chatsdk.domain.model.Location;
import com.deliveryhero.chatsdk.domain.model.MetaData;
import com.deliveryhero.chatsdk.domain.model.User;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/model/messages/LocationMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "id", "", "channelId", "timestamp", "", "metadata", "Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "location", "Lcom/deliveryhero/chatsdk/domain/model/Location;", "sender", "Lcom/deliveryhero/chatsdk/domain/model/User;", "correlationId", "(Ljava/lang/String;Ljava/lang/String;JLcom/deliveryhero/chatsdk/domain/model/MetaData;Lcom/deliveryhero/chatsdk/domain/model/Location;Lcom/deliveryhero/chatsdk/domain/model/User;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getCorrelationId", "getId", "getLocation", "()Lcom/deliveryhero/chatsdk/domain/model/Location;", "getMetadata", "()Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "getSender", "()Lcom/deliveryhero/chatsdk/domain/model/User;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationMessage implements Message {
    @NotNull
    private final String channelId;
    @Nullable
    private final String correlationId;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29388id;
    @NotNull
    private final Location location;
    @Nullable
    private final MetaData metadata;
    @NotNull
    private final User sender;
    private final long timestamp;

    public LocationMessage(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData, @NotNull Location location2, @NotNull User user, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(location2, "location");
        Intrinsics.checkNotNullParameter(user, "sender");
        this.f29388id = str;
        this.channelId = str2;
        this.timestamp = j11;
        this.metadata = metaData;
        this.location = location2;
        this.sender = user;
        this.correlationId = str3;
    }

    public static /* synthetic */ LocationMessage copy$default(LocationMessage locationMessage, String str, String str2, long j11, MetaData metaData, Location location2, User user, String str3, int i11, Object obj) {
        LocationMessage locationMessage2 = locationMessage;
        return locationMessage.copy((i11 & 1) != 0 ? locationMessage.getId() : str, (i11 & 2) != 0 ? locationMessage.getChannelId() : str2, (i11 & 4) != 0 ? locationMessage.getTimestamp() : j11, (i11 & 8) != 0 ? locationMessage.getMetadata() : metaData, (i11 & 16) != 0 ? locationMessage2.location : location2, (i11 & 32) != 0 ? locationMessage2.sender : user, (i11 & 64) != 0 ? locationMessage2.correlationId : str3);
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
    public final Location component5() {
        return this.location;
    }

    @NotNull
    public final User component6() {
        return this.sender;
    }

    @Nullable
    public final String component7() {
        return this.correlationId;
    }

    @NotNull
    public final LocationMessage copy(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData, @NotNull Location location2, @NotNull User user, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        Location location3 = location2;
        Intrinsics.checkNotNullParameter(location3, "location");
        User user2 = user;
        Intrinsics.checkNotNullParameter(user2, "sender");
        return new LocationMessage(str, str2, j11, metaData, location3, user2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationMessage)) {
            return false;
        }
        LocationMessage locationMessage = (LocationMessage) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) locationMessage.getId()) && Intrinsics.areEqual((Object) getChannelId(), (Object) locationMessage.getChannelId()) && getTimestamp() == locationMessage.getTimestamp() && Intrinsics.areEqual((Object) getMetadata(), (Object) locationMessage.getMetadata()) && Intrinsics.areEqual((Object) this.location, (Object) locationMessage.location) && Intrinsics.areEqual((Object) this.sender, (Object) locationMessage.sender) && Intrinsics.areEqual((Object) this.correlationId, (Object) locationMessage.correlationId);
    }

    @NotNull
    public String getChannelId() {
        return this.channelId;
    }

    @Nullable
    public final String getCorrelationId() {
        return this.correlationId;
    }

    @NotNull
    public String getId() {
        return this.f29388id;
    }

    @NotNull
    public final Location getLocation() {
        return this.location;
    }

    @Nullable
    public MetaData getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final User getSender() {
        return this.sender;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((getId().hashCode() * 31) + getChannelId().hashCode()) * 31) + a.a(getTimestamp())) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31) + this.location.hashCode()) * 31) + this.sender.hashCode()) * 31;
        String str = this.correlationId;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "LocationMessage(id=" + getId() + ", channelId=" + getChannelId() + ", timestamp=" + getTimestamp() + ", metadata=" + getMetadata() + ", location=" + this.location + ", sender=" + this.sender + ", correlationId=" + this.correlationId + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationMessage(String str, String str2, long j11, MetaData metaData, Location location2, User user, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j11, (i11 & 8) != 0 ? null : metaData, location2, user, (i11 & 64) != 0 ? null : str3);
    }
}
