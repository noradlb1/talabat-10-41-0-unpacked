package com.deliveryhero.chatsdk.domain.model.messages;

import com.deliveryhero.chatsdk.domain.model.MetaData;
import com.deliveryhero.chatsdk.domain.model.User;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/model/messages/TextMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "id", "", "channelId", "timestamp", "", "metadata", "Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "message", "sender", "Lcom/deliveryhero/chatsdk/domain/model/User;", "translations", "", "correlationId", "(Ljava/lang/String;Ljava/lang/String;JLcom/deliveryhero/chatsdk/domain/model/MetaData;Ljava/lang/String;Lcom/deliveryhero/chatsdk/domain/model/User;Ljava/util/Map;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getCorrelationId", "getId", "getMessage", "getMetadata", "()Lcom/deliveryhero/chatsdk/domain/model/MetaData;", "getSender", "()Lcom/deliveryhero/chatsdk/domain/model/User;", "getTimestamp", "()J", "getTranslations", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextMessage implements Message {
    @NotNull
    private final String channelId;
    @Nullable
    private final String correlationId;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29389id;
    @NotNull
    private final String message;
    @Nullable
    private final MetaData metadata;
    @NotNull
    private final User sender;
    private final long timestamp;
    @NotNull
    private final Map<String, String> translations;

    public TextMessage(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData, @NotNull String str3, @NotNull User user, @NotNull Map<String, String> map, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(str3, "message");
        Intrinsics.checkNotNullParameter(user, "sender");
        Intrinsics.checkNotNullParameter(map, "translations");
        this.f29389id = str;
        this.channelId = str2;
        this.timestamp = j11;
        this.metadata = metaData;
        this.message = str3;
        this.sender = user;
        this.translations = map;
        this.correlationId = str4;
    }

    public static /* synthetic */ TextMessage copy$default(TextMessage textMessage, String str, String str2, long j11, MetaData metaData, String str3, User user, Map map, String str4, int i11, Object obj) {
        TextMessage textMessage2 = textMessage;
        int i12 = i11;
        return textMessage.copy((i12 & 1) != 0 ? textMessage.getId() : str, (i12 & 2) != 0 ? textMessage.getChannelId() : str2, (i12 & 4) != 0 ? textMessage.getTimestamp() : j11, (i12 & 8) != 0 ? textMessage.getMetadata() : metaData, (i12 & 16) != 0 ? textMessage2.message : str3, (i12 & 32) != 0 ? textMessage2.sender : user, (i12 & 64) != 0 ? textMessage2.translations : map, (i12 & 128) != 0 ? textMessage2.correlationId : str4);
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
        return this.message;
    }

    @NotNull
    public final User component6() {
        return this.sender;
    }

    @NotNull
    public final Map<String, String> component7() {
        return this.translations;
    }

    @Nullable
    public final String component8() {
        return this.correlationId;
    }

    @NotNull
    public final TextMessage copy(@NotNull String str, @NotNull String str2, long j11, @Nullable MetaData metaData, @NotNull String str3, @NotNull User user, @NotNull Map<String, String> map, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.Notification.CHANNEL_ID);
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "message");
        User user2 = user;
        Intrinsics.checkNotNullParameter(user2, "sender");
        Map<String, String> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "translations");
        return new TextMessage(str, str2, j11, metaData, str5, user2, map2, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextMessage)) {
            return false;
        }
        TextMessage textMessage = (TextMessage) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) textMessage.getId()) && Intrinsics.areEqual((Object) getChannelId(), (Object) textMessage.getChannelId()) && getTimestamp() == textMessage.getTimestamp() && Intrinsics.areEqual((Object) getMetadata(), (Object) textMessage.getMetadata()) && Intrinsics.areEqual((Object) this.message, (Object) textMessage.message) && Intrinsics.areEqual((Object) this.sender, (Object) textMessage.sender) && Intrinsics.areEqual((Object) this.translations, (Object) textMessage.translations) && Intrinsics.areEqual((Object) this.correlationId, (Object) textMessage.correlationId);
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
        return this.f29389id;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
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

    @NotNull
    public final Map<String, String> getTranslations() {
        return this.translations;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((((getId().hashCode() * 31) + getChannelId().hashCode()) * 31) + a.a(getTimestamp())) * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31) + this.message.hashCode()) * 31) + this.sender.hashCode()) * 31) + this.translations.hashCode()) * 31;
        String str = this.correlationId;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "TextMessage(id=" + getId() + ", channelId=" + getChannelId() + ", timestamp=" + getTimestamp() + ", metadata=" + getMetadata() + ", message=" + this.message + ", sender=" + this.sender + ", translations=" + this.translations + ", correlationId=" + this.correlationId + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextMessage(java.lang.String r14, java.lang.String r15, long r16, com.deliveryhero.chatsdk.domain.model.MetaData r18, java.lang.String r19, com.deliveryhero.chatsdk.domain.model.User r20, java.util.Map r21, java.lang.String r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r8 = r2
            goto L_0x000b
        L_0x0009:
            r8 = r18
        L_0x000b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0015
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            r11 = r1
            goto L_0x0017
        L_0x0015:
            r11 = r21
        L_0x0017:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x001d
            r12 = r2
            goto L_0x001f
        L_0x001d:
            r12 = r22
        L_0x001f:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r9 = r19
            r10 = r20
            r3.<init>(r4, r5, r6, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatsdk.domain.model.messages.TextMessage.<init>(java.lang.String, java.lang.String, long, com.deliveryhero.chatsdk.domain.model.MetaData, java.lang.String, com.deliveryhero.chatsdk.domain.model.User, java.util.Map, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
