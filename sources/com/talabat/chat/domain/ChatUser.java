package com.talabat.chat.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/chat/domain/ChatUser;", "", "id", "", "dhAuthToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getDhAuthToken", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_chat_chat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatUser {
    @NotNull
    private final String dhAuthToken;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f55540id;

    public ChatUser(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "dhAuthToken");
        this.f55540id = str;
        this.dhAuthToken = str2;
    }

    public static /* synthetic */ ChatUser copy$default(ChatUser chatUser, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = chatUser.f55540id;
        }
        if ((i11 & 2) != 0) {
            str2 = chatUser.dhAuthToken;
        }
        return chatUser.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.f55540id;
    }

    @NotNull
    public final String component2() {
        return this.dhAuthToken;
    }

    @NotNull
    public final ChatUser copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "dhAuthToken");
        return new ChatUser(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatUser)) {
            return false;
        }
        ChatUser chatUser = (ChatUser) obj;
        return Intrinsics.areEqual((Object) this.f55540id, (Object) chatUser.f55540id) && Intrinsics.areEqual((Object) this.dhAuthToken, (Object) chatUser.dhAuthToken);
    }

    @NotNull
    public final String getDhAuthToken() {
        return this.dhAuthToken;
    }

    @NotNull
    public final String getId() {
        return this.f55540id;
    }

    public int hashCode() {
        return (this.f55540id.hashCode() * 31) + this.dhAuthToken.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f55540id;
        String str2 = this.dhAuthToken;
        return "ChatUser(id=" + str + ", dhAuthToken=" + str2 + ")";
    }
}
