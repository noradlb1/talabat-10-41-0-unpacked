package com.talabat.notifications.brazemigrator.guestuser.model;

import androidx.autofill.HintConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserRequestBody;", "", "firstName", "", "lastName", "phoneNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFirstName", "()Ljava/lang/String;", "getLastName", "getPhoneNumber", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestUserRequestBody {
    @SerializedName("firstname")
    @NotNull
    private final String firstName;
    @SerializedName("lastname")
    @NotNull
    private final String lastName;
    @SerializedName("phoneNumber")
    @NotNull
    private final String phoneNumber;

    public GuestUserRequestBody(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "firstName");
        Intrinsics.checkNotNullParameter(str2, "lastName");
        Intrinsics.checkNotNullParameter(str3, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        this.firstName = str;
        this.lastName = str2;
        this.phoneNumber = str3;
    }

    public static /* synthetic */ GuestUserRequestBody copy$default(GuestUserRequestBody guestUserRequestBody, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = guestUserRequestBody.firstName;
        }
        if ((i11 & 2) != 0) {
            str2 = guestUserRequestBody.lastName;
        }
        if ((i11 & 4) != 0) {
            str3 = guestUserRequestBody.phoneNumber;
        }
        return guestUserRequestBody.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.firstName;
    }

    @NotNull
    public final String component2() {
        return this.lastName;
    }

    @NotNull
    public final String component3() {
        return this.phoneNumber;
    }

    @NotNull
    public final GuestUserRequestBody copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "firstName");
        Intrinsics.checkNotNullParameter(str2, "lastName");
        Intrinsics.checkNotNullParameter(str3, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        return new GuestUserRequestBody(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuestUserRequestBody)) {
            return false;
        }
        GuestUserRequestBody guestUserRequestBody = (GuestUserRequestBody) obj;
        return Intrinsics.areEqual((Object) this.firstName, (Object) guestUserRequestBody.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) guestUserRequestBody.lastName) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) guestUserRequestBody.phoneNumber);
    }

    @NotNull
    public final String getFirstName() {
        return this.firstName;
    }

    @NotNull
    public final String getLastName() {
        return this.lastName;
    }

    @NotNull
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int hashCode() {
        return (((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31) + this.phoneNumber.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.firstName;
        String str2 = this.lastName;
        String str3 = this.phoneNumber;
        return "GuestUserRequestBody(firstName=" + str + ", lastName=" + str2 + ", phoneNumber=" + str3 + ")";
    }
}
