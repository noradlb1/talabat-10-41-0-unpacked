package com.deliveryhero.contract.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/deliveryhero/contract/model/ChatDetails;", "Landroid/os/Parcelable;", "id", "", "unreadCount", "", "hasUnRepliedMessage", "", "(Ljava/lang/String;IZ)V", "getHasUnRepliedMessage", "()Z", "getId", "()Ljava/lang/String;", "getUnreadCount", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class ChatDetails implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ChatDetails> CREATOR = new Creator();
    private final boolean hasUnRepliedMessage;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29718id;
    private final int unreadCount;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ChatDetails> {
        @NotNull
        public final ChatDetails createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChatDetails(parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
        }

        @NotNull
        public final ChatDetails[] newArray(int i11) {
            return new ChatDetails[i11];
        }
    }

    public ChatDetails(@NotNull String str, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.f29718id = str;
        this.unreadCount = i11;
        this.hasUnRepliedMessage = z11;
    }

    public static /* synthetic */ ChatDetails copy$default(ChatDetails chatDetails, String str, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = chatDetails.f29718id;
        }
        if ((i12 & 2) != 0) {
            i11 = chatDetails.unreadCount;
        }
        if ((i12 & 4) != 0) {
            z11 = chatDetails.hasUnRepliedMessage;
        }
        return chatDetails.copy(str, i11, z11);
    }

    @NotNull
    public final String component1() {
        return this.f29718id;
    }

    public final int component2() {
        return this.unreadCount;
    }

    public final boolean component3() {
        return this.hasUnRepliedMessage;
    }

    @NotNull
    public final ChatDetails copy(@NotNull String str, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new ChatDetails(str, i11, z11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatDetails)) {
            return false;
        }
        ChatDetails chatDetails = (ChatDetails) obj;
        return Intrinsics.areEqual((Object) this.f29718id, (Object) chatDetails.f29718id) && this.unreadCount == chatDetails.unreadCount && this.hasUnRepliedMessage == chatDetails.hasUnRepliedMessage;
    }

    public final boolean getHasUnRepliedMessage() {
        return this.hasUnRepliedMessage;
    }

    @NotNull
    public final String getId() {
        return this.f29718id;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public int hashCode() {
        int hashCode = ((this.f29718id.hashCode() * 31) + this.unreadCount) * 31;
        boolean z11 = this.hasUnRepliedMessage;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "ChatDetails(id=" + this.f29718id + ", unreadCount=" + this.unreadCount + ", hasUnRepliedMessage=" + this.hasUnRepliedMessage + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f29718id);
        parcel.writeInt(this.unreadCount);
        parcel.writeInt(this.hasUnRepliedMessage ? 1 : 0);
    }
}
