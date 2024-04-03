package com.talabat.helpcenter.domain.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/talabat/helpcenter/domain/entity/UnreadChatMessages;", "", "unreadMessageCount", "", "isActive", "", "(IZ)V", "()Z", "getUnreadMessageCount", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnreadChatMessages {
    private final boolean isActive;
    private final int unreadMessageCount;

    public UnreadChatMessages(int i11, boolean z11) {
        this.unreadMessageCount = i11;
        this.isActive = z11;
    }

    public static /* synthetic */ UnreadChatMessages copy$default(UnreadChatMessages unreadChatMessages, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = unreadChatMessages.unreadMessageCount;
        }
        if ((i12 & 2) != 0) {
            z11 = unreadChatMessages.isActive;
        }
        return unreadChatMessages.copy(i11, z11);
    }

    public final int component1() {
        return this.unreadMessageCount;
    }

    public final boolean component2() {
        return this.isActive;
    }

    @NotNull
    public final UnreadChatMessages copy(int i11, boolean z11) {
        return new UnreadChatMessages(i11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnreadChatMessages)) {
            return false;
        }
        UnreadChatMessages unreadChatMessages = (UnreadChatMessages) obj;
        return this.unreadMessageCount == unreadChatMessages.unreadMessageCount && this.isActive == unreadChatMessages.isActive;
    }

    public final int getUnreadMessageCount() {
        return this.unreadMessageCount;
    }

    public int hashCode() {
        int i11 = this.unreadMessageCount * 31;
        boolean z11 = this.isActive;
        if (z11) {
            z11 = true;
        }
        return i11 + (z11 ? 1 : 0);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    @NotNull
    public String toString() {
        int i11 = this.unreadMessageCount;
        boolean z11 = this.isActive;
        return "UnreadChatMessages(unreadMessageCount=" + i11 + ", isActive=" + z11 + ")";
    }
}
