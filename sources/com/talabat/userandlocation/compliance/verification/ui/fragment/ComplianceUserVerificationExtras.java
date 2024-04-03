package com.talabat.userandlocation.compliance.verification.ui.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001+BO\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020 HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras;", "Landroid/os/Parcelable;", "firstName", "", "lastName", "dateOfBirth", "email", "mobileNumber", "mode", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras$Mode;", "updateUserInfoAfterVerification", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras$Mode;Z)V", "getDateOfBirth", "()Ljava/lang/String;", "getEmail", "getFirstName", "getLastName", "getMobileNumber", "getMode", "()Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras$Mode;", "getUpdateUserInfoAfterVerification", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Mode", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class ComplianceUserVerificationExtras implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ComplianceUserVerificationExtras> CREATOR = new Creator();
    @Nullable
    private final String dateOfBirth;
    @Nullable
    private final String email;
    @Nullable
    private final String firstName;
    @Nullable
    private final String lastName;
    @Nullable
    private final String mobileNumber;
    @NotNull
    private final Mode mode;
    private final boolean updateUserInfoAfterVerification;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ComplianceUserVerificationExtras> {
        @NotNull
        public final ComplianceUserVerificationExtras createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ComplianceUserVerificationExtras(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), Mode.valueOf(parcel.readString()), parcel.readInt() != 0);
        }

        @NotNull
        public final ComplianceUserVerificationExtras[] newArray(int i11) {
            return new ComplianceUserVerificationExtras[i11];
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras$Mode;", "", "(Ljava/lang/String;I)V", "EXISTING_USER", "NEW_USER", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Mode {
        EXISTING_USER,
        NEW_USER
    }

    @JvmOverloads
    public ComplianceUserVerificationExtras(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this(str, str2, str3, str4, (String) null, (Mode) null, false, 112, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ComplianceUserVerificationExtras(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this(str, str2, str3, str4, str5, (Mode) null, false, 96, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ComplianceUserVerificationExtras(@org.jetbrains.annotations.Nullable java.lang.String r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.Nullable java.lang.String r14, @org.jetbrains.annotations.Nullable java.lang.String r15, @org.jetbrains.annotations.Nullable java.lang.String r16, @org.jetbrains.annotations.NotNull com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationExtras.Mode r17) {
        /*
            r11 = this;
            java.lang.String r0 = "mode"
            r7 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r8 = 0
            r9 = 64
            r10 = 0
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationExtras.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationExtras$Mode):void");
    }

    @JvmOverloads
    public ComplianceUserVerificationExtras(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull Mode mode2, boolean z11) {
        Intrinsics.checkNotNullParameter(mode2, SessionsConfigParameter.SYNC_MODE);
        this.firstName = str;
        this.lastName = str2;
        this.dateOfBirth = str3;
        this.email = str4;
        this.mobileNumber = str5;
        this.mode = mode2;
        this.updateUserInfoAfterVerification = z11;
    }

    public static /* synthetic */ ComplianceUserVerificationExtras copy$default(ComplianceUserVerificationExtras complianceUserVerificationExtras, String str, String str2, String str3, String str4, String str5, Mode mode2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = complianceUserVerificationExtras.firstName;
        }
        if ((i11 & 2) != 0) {
            str2 = complianceUserVerificationExtras.lastName;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = complianceUserVerificationExtras.dateOfBirth;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = complianceUserVerificationExtras.email;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = complianceUserVerificationExtras.mobileNumber;
        }
        String str9 = str5;
        if ((i11 & 32) != 0) {
            mode2 = complianceUserVerificationExtras.mode;
        }
        Mode mode3 = mode2;
        if ((i11 & 64) != 0) {
            z11 = complianceUserVerificationExtras.updateUserInfoAfterVerification;
        }
        return complianceUserVerificationExtras.copy(str, str6, str7, str8, str9, mode3, z11);
    }

    @Nullable
    public final String component1() {
        return this.firstName;
    }

    @Nullable
    public final String component2() {
        return this.lastName;
    }

    @Nullable
    public final String component3() {
        return this.dateOfBirth;
    }

    @Nullable
    public final String component4() {
        return this.email;
    }

    @Nullable
    public final String component5() {
        return this.mobileNumber;
    }

    @NotNull
    public final Mode component6() {
        return this.mode;
    }

    public final boolean component7() {
        return this.updateUserInfoAfterVerification;
    }

    @NotNull
    public final ComplianceUserVerificationExtras copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull Mode mode2, boolean z11) {
        Intrinsics.checkNotNullParameter(mode2, SessionsConfigParameter.SYNC_MODE);
        return new ComplianceUserVerificationExtras(str, str2, str3, str4, str5, mode2, z11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComplianceUserVerificationExtras)) {
            return false;
        }
        ComplianceUserVerificationExtras complianceUserVerificationExtras = (ComplianceUserVerificationExtras) obj;
        return Intrinsics.areEqual((Object) this.firstName, (Object) complianceUserVerificationExtras.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) complianceUserVerificationExtras.lastName) && Intrinsics.areEqual((Object) this.dateOfBirth, (Object) complianceUserVerificationExtras.dateOfBirth) && Intrinsics.areEqual((Object) this.email, (Object) complianceUserVerificationExtras.email) && Intrinsics.areEqual((Object) this.mobileNumber, (Object) complianceUserVerificationExtras.mobileNumber) && this.mode == complianceUserVerificationExtras.mode && this.updateUserInfoAfterVerification == complianceUserVerificationExtras.updateUserInfoAfterVerification;
    }

    @Nullable
    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final String getFirstName() {
        return this.firstName;
    }

    @Nullable
    public final String getLastName() {
        return this.lastName;
    }

    @Nullable
    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    @NotNull
    public final Mode getMode() {
        return this.mode;
    }

    public final boolean getUpdateUserInfoAfterVerification() {
        return this.updateUserInfoAfterVerification;
    }

    public int hashCode() {
        String str = this.firstName;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.lastName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dateOfBirth;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.email;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mobileNumber;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        int hashCode5 = (((hashCode4 + i11) * 31) + this.mode.hashCode()) * 31;
        boolean z11 = this.updateUserInfoAfterVerification;
        if (z11) {
            z11 = true;
        }
        return hashCode5 + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        String str = this.firstName;
        String str2 = this.lastName;
        String str3 = this.dateOfBirth;
        String str4 = this.email;
        String str5 = this.mobileNumber;
        Mode mode2 = this.mode;
        boolean z11 = this.updateUserInfoAfterVerification;
        return "ComplianceUserVerificationExtras(firstName=" + str + ", lastName=" + str2 + ", dateOfBirth=" + str3 + ", email=" + str4 + ", mobileNumber=" + str5 + ", mode=" + mode2 + ", updateUserInfoAfterVerification=" + z11 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.dateOfBirth);
        parcel.writeString(this.email);
        parcel.writeString(this.mobileNumber);
        parcel.writeString(this.mode.name());
        parcel.writeInt(this.updateUserInfoAfterVerification ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComplianceUserVerificationExtras(String str, String str2, String str3, String str4, String str5, Mode mode2, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? Mode.NEW_USER : mode2, (i11 & 64) != 0 ? false : z11);
    }
}
