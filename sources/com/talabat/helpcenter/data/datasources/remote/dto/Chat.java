package com.talabat.helpcenter.data.datasources.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/talabat/helpcenter/data/datasources/remote/dto/Chat;", "", "unreadMessageCount", "", "active", "", "(IZ)V", "getActive", "()Z", "getUnreadMessageCount", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Chat {
    private final boolean active;
    @SerializedName("unread_message_count")
    private final int unreadMessageCount;

    public Chat(int i11, boolean z11) {
        this.unreadMessageCount = i11;
        this.active = z11;
    }

    public static /* synthetic */ Chat copy$default(Chat chat, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = chat.unreadMessageCount;
        }
        if ((i12 & 2) != 0) {
            z11 = chat.active;
        }
        return chat.copy(i11, z11);
    }

    public final int component1() {
        return this.unreadMessageCount;
    }

    public final boolean component2() {
        return this.active;
    }

    @NotNull
    public final Chat copy(int i11, boolean z11) {
        return new Chat(i11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Chat)) {
            return false;
        }
        Chat chat = (Chat) obj;
        return this.unreadMessageCount == chat.unreadMessageCount && this.active == chat.active;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final int getUnreadMessageCount() {
        return this.unreadMessageCount;
    }

    public int hashCode() {
        int i11 = this.unreadMessageCount * 31;
        boolean z11 = this.active;
        if (z11) {
            z11 = true;
        }
        return i11 + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        int i11 = this.unreadMessageCount;
        boolean z11 = this.active;
        return "Chat(unreadMessageCount=" + i11 + ", active=" + z11 + ")";
    }
}
