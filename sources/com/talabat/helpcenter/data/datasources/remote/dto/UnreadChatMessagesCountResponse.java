package com.talabat.helpcenter.data.datasources.remote.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/helpcenter/data/datasources/remote/dto/UnreadChatMessagesCountResponse;", "", "chat", "Lcom/talabat/helpcenter/data/datasources/remote/dto/Chat;", "(Lcom/talabat/helpcenter/data/datasources/remote/dto/Chat;)V", "getChat", "()Lcom/talabat/helpcenter/data/datasources/remote/dto/Chat;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnreadChatMessagesCountResponse {
    @NotNull
    private final Chat chat;

    public UnreadChatMessagesCountResponse(@NotNull Chat chat2) {
        Intrinsics.checkNotNullParameter(chat2, "chat");
        this.chat = chat2;
    }

    public static /* synthetic */ UnreadChatMessagesCountResponse copy$default(UnreadChatMessagesCountResponse unreadChatMessagesCountResponse, Chat chat2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            chat2 = unreadChatMessagesCountResponse.chat;
        }
        return unreadChatMessagesCountResponse.copy(chat2);
    }

    @NotNull
    public final Chat component1() {
        return this.chat;
    }

    @NotNull
    public final UnreadChatMessagesCountResponse copy(@NotNull Chat chat2) {
        Intrinsics.checkNotNullParameter(chat2, "chat");
        return new UnreadChatMessagesCountResponse(chat2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UnreadChatMessagesCountResponse) && Intrinsics.areEqual((Object) this.chat, (Object) ((UnreadChatMessagesCountResponse) obj).chat);
    }

    @NotNull
    public final Chat getChat() {
        return this.chat;
    }

    public int hashCode() {
        return this.chat.hashCode();
    }

    @NotNull
    public String toString() {
        Chat chat2 = this.chat;
        return "UnreadChatMessagesCountResponse(chat=" + chat2 + ")";
    }
}
