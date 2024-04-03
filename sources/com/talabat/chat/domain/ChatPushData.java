package com.talabat.chat.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/chat/domain/ChatPushData;", "", "senderName", "", "pushAlert", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getPushAlert", "getSenderName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_chat_chat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatPushData {
    @NotNull
    private final String message;
    @NotNull
    private final String pushAlert;
    @NotNull
    private final String senderName;

    public ChatPushData(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "senderName");
        Intrinsics.checkNotNullParameter(str2, "pushAlert");
        Intrinsics.checkNotNullParameter(str3, "message");
        this.senderName = str;
        this.pushAlert = str2;
        this.message = str3;
    }

    public static /* synthetic */ ChatPushData copy$default(ChatPushData chatPushData, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = chatPushData.senderName;
        }
        if ((i11 & 2) != 0) {
            str2 = chatPushData.pushAlert;
        }
        if ((i11 & 4) != 0) {
            str3 = chatPushData.message;
        }
        return chatPushData.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.senderName;
    }

    @NotNull
    public final String component2() {
        return this.pushAlert;
    }

    @NotNull
    public final String component3() {
        return this.message;
    }

    @NotNull
    public final ChatPushData copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "senderName");
        Intrinsics.checkNotNullParameter(str2, "pushAlert");
        Intrinsics.checkNotNullParameter(str3, "message");
        return new ChatPushData(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatPushData)) {
            return false;
        }
        ChatPushData chatPushData = (ChatPushData) obj;
        return Intrinsics.areEqual((Object) this.senderName, (Object) chatPushData.senderName) && Intrinsics.areEqual((Object) this.pushAlert, (Object) chatPushData.pushAlert) && Intrinsics.areEqual((Object) this.message, (Object) chatPushData.message);
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getPushAlert() {
        return this.pushAlert;
    }

    @NotNull
    public final String getSenderName() {
        return this.senderName;
    }

    public int hashCode() {
        return (((this.senderName.hashCode() * 31) + this.pushAlert.hashCode()) * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.senderName;
        String str2 = this.pushAlert;
        String str3 = this.message;
        return "ChatPushData(senderName=" + str + ", pushAlert=" + str2 + ", message=" + str3 + ")";
    }
}
