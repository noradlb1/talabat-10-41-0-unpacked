package com.deliveryhero.chatsdk.domain.model.messages;

import com.deliveryhero.chatsdk.domain.model.Config;
import com.deliveryhero.chatsdk.domain.model.MetaData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/model/messages/ConfigMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "id", "", "channelId", "timestamp", "", "metadata", "Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "configs", "", "Lcom/deliveryhero/chatsdk/domain/model/Config;", "correlationId", "(Ljava/lang/String;Ljava/lang/String;JLcom/deliveryhero/chatsdk/domain/model/MetaData;Ljava/util/List;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getConfigs", "()Ljava/util/List;", "getCorrelationId", "getId", "getMetadata", "()Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfigMessage implements Message {
    @NotNull
    private final String channelId;
    @NotNull
    private final List<Config> configs;
    @Nullable
    private final String correlationId;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29385id;
    @Nullable
    private final MetaData metadata;
    private final long timestamp;

    public ConfigMessage(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData, @NotNull List<Config> list, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(list, "configs");
        this.f29385id = str;
        this.channelId = str2;
        this.timestamp = j11;
        this.metadata = metaData;
        this.configs = list;
        this.correlationId = str3;
    }

    public static /* synthetic */ ConfigMessage copy$default(ConfigMessage configMessage, String str, String str2, long j11, MetaData metaData, List<Config> list, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = configMessage.getId();
        }
        if ((i11 & 2) != 0) {
            str2 = configMessage.getChannelId();
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            j11 = configMessage.getTimestamp();
        }
        long j12 = j11;
        if ((i11 & 8) != 0) {
            metaData = configMessage.getMetadata();
        }
        MetaData metaData2 = metaData;
        if ((i11 & 16) != 0) {
            list = configMessage.configs;
        }
        List<Config> list2 = list;
        if ((i11 & 32) != 0) {
            str3 = configMessage.correlationId;
        }
        return configMessage.copy(str, str4, j12, metaData2, list2, str3);
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
    public final List<Config> component5() {
        return this.configs;
    }

    @Nullable
    public final String component6() {
        return this.correlationId;
    }

    @NotNull
    public final ConfigMessage copy(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData, @NotNull List<Config> list, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(list, "configs");
        return new ConfigMessage(str, str2, j11, metaData, list, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigMessage)) {
            return false;
        }
        ConfigMessage configMessage = (ConfigMessage) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) configMessage.getId()) && Intrinsics.areEqual((Object) getChannelId(), (Object) configMessage.getChannelId()) && getTimestamp() == configMessage.getTimestamp() && Intrinsics.areEqual((Object) getMetadata(), (Object) configMessage.getMetadata()) && Intrinsics.areEqual((Object) this.configs, (Object) configMessage.configs) && Intrinsics.areEqual((Object) this.correlationId, (Object) configMessage.correlationId);
    }

    @NotNull
    public String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final List<Config> getConfigs() {
        return this.configs;
    }

    @Nullable
    public final String getCorrelationId() {
        return this.correlationId;
    }

    @NotNull
    public String getId() {
        return this.f29385id;
    }

    @Nullable
    public MetaData getMetadata() {
        return this.metadata;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((getId().hashCode() * 31) + getChannelId().hashCode()) * 31) + a.a(getTimestamp())) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31) + this.configs.hashCode()) * 31;
        String str = this.correlationId;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "ConfigMessage(id=" + getId() + ", channelId=" + getChannelId() + ", timestamp=" + getTimestamp() + ", metadata=" + getMetadata() + ", configs=" + this.configs + ", correlationId=" + this.correlationId + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConfigMessage(String str, String str2, long j11, MetaData metaData, List list, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j11, (i11 & 8) != 0 ? null : metaData, list, (i11 & 32) != 0 ? null : str3);
    }
}
