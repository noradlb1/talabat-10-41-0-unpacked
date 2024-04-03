package com.deliveryhero.chatsdk.domain.model.messages;

import com.deliveryhero.chatsdk.domain.model.MetaData;
import com.deliveryhero.chatsdk.domain.model.User;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00061"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/model/messages/FileMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "id", "", "channelId", "timestamp", "", "metadata", "Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "url", "caption", "sender", "Lcom/deliveryhero/chatsdk/domain/model/User;", "thumbnails", "", "Lcom/deliveryhero/chatsdk/domain/model/messages/Thumbnail;", "correlationId", "(Ljava/lang/String;Ljava/lang/String;JLcom/deliveryhero/chatsdk/domain/model/MetaData;Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/chatsdk/domain/model/User;Ljava/util/List;Ljava/lang/String;)V", "getCaption", "()Ljava/lang/String;", "getChannelId", "getCorrelationId", "getId", "getMetadata", "()Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "getSender", "()Lcom/deliveryhero/chatsdk/domain/model/User;", "getThumbnails", "()Ljava/util/List;", "getTimestamp", "()J", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileMessage implements Message {
    @NotNull
    private final String caption;
    @NotNull
    private final String channelId;
    @Nullable
    private final String correlationId;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29387id;
    @Nullable
    private final MetaData metadata;
    @NotNull
    private final User sender;
    @NotNull
    private final List<Thumbnail> thumbnails;
    private final long timestamp;
    @NotNull
    private final String url;

    public FileMessage(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData, @NotNull String str3, @NotNull String str4, @NotNull User user, @NotNull List<Thumbnail> list, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(str4, ShareConstants.FEED_CAPTION_PARAM);
        Intrinsics.checkNotNullParameter(user, "sender");
        Intrinsics.checkNotNullParameter(list, "thumbnails");
        this.f29387id = str;
        this.channelId = str2;
        this.timestamp = j11;
        this.metadata = metaData;
        this.url = str3;
        this.caption = str4;
        this.sender = user;
        this.thumbnails = list;
        this.correlationId = str5;
    }

    public static /* synthetic */ FileMessage copy$default(FileMessage fileMessage, String str, String str2, long j11, MetaData metaData, String str3, String str4, User user, List list, String str5, int i11, Object obj) {
        FileMessage fileMessage2 = fileMessage;
        int i12 = i11;
        return fileMessage.copy((i12 & 1) != 0 ? fileMessage.getId() : str, (i12 & 2) != 0 ? fileMessage.getChannelId() : str2, (i12 & 4) != 0 ? fileMessage.getTimestamp() : j11, (i12 & 8) != 0 ? fileMessage.getMetadata() : metaData, (i12 & 16) != 0 ? fileMessage2.url : str3, (i12 & 32) != 0 ? fileMessage2.caption : str4, (i12 & 64) != 0 ? fileMessage2.sender : user, (i12 & 128) != 0 ? fileMessage2.thumbnails : list, (i12 & 256) != 0 ? fileMessage2.correlationId : str5);
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
        return this.url;
    }

    @NotNull
    public final String component6() {
        return this.caption;
    }

    @NotNull
    public final User component7() {
        return this.sender;
    }

    @NotNull
    public final List<Thumbnail> component8() {
        return this.thumbnails;
    }

    @Nullable
    public final String component9() {
        return this.correlationId;
    }

    @NotNull
    public final FileMessage copy(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData, @NotNull String str3, @NotNull String str4, @NotNull User user, @NotNull List<Thumbnail> list, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "url");
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, ShareConstants.FEED_CAPTION_PARAM);
        User user2 = user;
        Intrinsics.checkNotNullParameter(user2, "sender");
        List<Thumbnail> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "thumbnails");
        return new FileMessage(str, str2, j11, metaData, str6, str7, user2, list2, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileMessage)) {
            return false;
        }
        FileMessage fileMessage = (FileMessage) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) fileMessage.getId()) && Intrinsics.areEqual((Object) getChannelId(), (Object) fileMessage.getChannelId()) && getTimestamp() == fileMessage.getTimestamp() && Intrinsics.areEqual((Object) getMetadata(), (Object) fileMessage.getMetadata()) && Intrinsics.areEqual((Object) this.url, (Object) fileMessage.url) && Intrinsics.areEqual((Object) this.caption, (Object) fileMessage.caption) && Intrinsics.areEqual((Object) this.sender, (Object) fileMessage.sender) && Intrinsics.areEqual((Object) this.thumbnails, (Object) fileMessage.thumbnails) && Intrinsics.areEqual((Object) this.correlationId, (Object) fileMessage.correlationId);
    }

    @NotNull
    public final String getCaption() {
        return this.caption;
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
        return this.f29387id;
    }

    @Nullable
    public MetaData getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final User getSender() {
        return this.sender;
    }

    @NotNull
    public final List<Thumbnail> getThumbnails() {
        return this.thumbnails;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((((((getId().hashCode() * 31) + getChannelId().hashCode()) * 31) + a.a(getTimestamp())) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31) + this.url.hashCode()) * 31) + this.caption.hashCode()) * 31) + this.sender.hashCode()) * 31) + this.thumbnails.hashCode()) * 31;
        String str = this.correlationId;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "FileMessage(id=" + getId() + ", channelId=" + getChannelId() + ", timestamp=" + getTimestamp() + ", metadata=" + getMetadata() + ", url=" + this.url + ", caption=" + this.caption + ", sender=" + this.sender + ", thumbnails=" + this.thumbnails + ", correlationId=" + this.correlationId + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FileMessage(java.lang.String r15, java.lang.String r16, long r17, com.deliveryhero.chatsdk.domain.model.MetaData r19, java.lang.String r20, java.lang.String r21, com.deliveryhero.chatsdk.domain.model.User r22, java.util.List r23, java.lang.String r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r8 = r2
            goto L_0x000b
        L_0x0009:
            r8 = r19
        L_0x000b:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0011
            r13 = r2
            goto L_0x0013
        L_0x0011:
            r13 = r24
        L_0x0013:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r3.<init>(r4, r5, r6, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatsdk.domain.model.messages.FileMessage.<init>(java.lang.String, java.lang.String, long, com.deliveryhero.chatsdk.domain.model.MetaData, java.lang.String, java.lang.String, com.deliveryhero.chatsdk.domain.model.User, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
