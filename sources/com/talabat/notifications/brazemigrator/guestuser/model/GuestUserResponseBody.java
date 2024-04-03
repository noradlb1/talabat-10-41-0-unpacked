package com.talabat.notifications.brazemigrator.guestuser.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserResponseBody;", "", "userHashValue", "", "(Ljava/lang/String;)V", "getUserHashValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestUserResponseBody {
    @SerializedName("result")
    @NotNull
    private final String userHashValue;

    public GuestUserResponseBody(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userHashValue");
        this.userHashValue = str;
    }

    public static /* synthetic */ GuestUserResponseBody copy$default(GuestUserResponseBody guestUserResponseBody, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = guestUserResponseBody.userHashValue;
        }
        return guestUserResponseBody.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.userHashValue;
    }

    @NotNull
    public final GuestUserResponseBody copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userHashValue");
        return new GuestUserResponseBody(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GuestUserResponseBody) && Intrinsics.areEqual((Object) this.userHashValue, (Object) ((GuestUserResponseBody) obj).userHashValue);
    }

    @NotNull
    public final String getUserHashValue() {
        return this.userHashValue;
    }

    public int hashCode() {
        return this.userHashValue.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.userHashValue;
        return "GuestUserResponseBody(userHashValue=" + str + ")";
    }
}
