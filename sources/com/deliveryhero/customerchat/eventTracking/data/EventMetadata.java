package com.deliveryhero.customerchat.eventTracking.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "", "globalEntityID", "", "orderID", "channelID", "userID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelID", "()Ljava/lang/String;", "getGlobalEntityID", "getOrderID", "getUserID", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventMetadata {
    @NotNull
    private final String channelID;
    @NotNull
    private final String globalEntityID;
    @NotNull
    private final String orderID;
    @NotNull
    private final String userID;

    public EventMetadata(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "globalEntityID");
        Intrinsics.checkNotNullParameter(str2, "orderID");
        Intrinsics.checkNotNullParameter(str3, "channelID");
        Intrinsics.checkNotNullParameter(str4, "userID");
        this.globalEntityID = str;
        this.orderID = str2;
        this.channelID = str3;
        this.userID = str4;
    }

    public static /* synthetic */ EventMetadata copy$default(EventMetadata eventMetadata, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = eventMetadata.globalEntityID;
        }
        if ((i11 & 2) != 0) {
            str2 = eventMetadata.orderID;
        }
        if ((i11 & 4) != 0) {
            str3 = eventMetadata.channelID;
        }
        if ((i11 & 8) != 0) {
            str4 = eventMetadata.userID;
        }
        return eventMetadata.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.globalEntityID;
    }

    @NotNull
    public final String component2() {
        return this.orderID;
    }

    @NotNull
    public final String component3() {
        return this.channelID;
    }

    @NotNull
    public final String component4() {
        return this.userID;
    }

    @NotNull
    public final EventMetadata copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "globalEntityID");
        Intrinsics.checkNotNullParameter(str2, "orderID");
        Intrinsics.checkNotNullParameter(str3, "channelID");
        Intrinsics.checkNotNullParameter(str4, "userID");
        return new EventMetadata(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventMetadata)) {
            return false;
        }
        EventMetadata eventMetadata = (EventMetadata) obj;
        return Intrinsics.areEqual((Object) this.globalEntityID, (Object) eventMetadata.globalEntityID) && Intrinsics.areEqual((Object) this.orderID, (Object) eventMetadata.orderID) && Intrinsics.areEqual((Object) this.channelID, (Object) eventMetadata.channelID) && Intrinsics.areEqual((Object) this.userID, (Object) eventMetadata.userID);
    }

    @NotNull
    public final String getChannelID() {
        return this.channelID;
    }

    @NotNull
    public final String getGlobalEntityID() {
        return this.globalEntityID;
    }

    @NotNull
    public final String getOrderID() {
        return this.orderID;
    }

    @NotNull
    public final String getUserID() {
        return this.userID;
    }

    public int hashCode() {
        return (((((this.globalEntityID.hashCode() * 31) + this.orderID.hashCode()) * 31) + this.channelID.hashCode()) * 31) + this.userID.hashCode();
    }

    @NotNull
    public String toString() {
        return "EventMetadata(globalEntityID=" + this.globalEntityID + ", orderID=" + this.orderID + ", channelID=" + this.channelID + ", userID=" + this.userID + ')';
    }
}
