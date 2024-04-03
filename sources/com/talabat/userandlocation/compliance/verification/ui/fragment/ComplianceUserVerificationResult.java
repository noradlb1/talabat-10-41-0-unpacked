package com.talabat.userandlocation.compliance.verification.ui.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003JC\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationResult;", "Landroid/os/Parcelable;", "firstName", "", "lastName", "dateOfBirth", "email", "isPromotionsConsentChecked", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDateOfBirth", "()Ljava/lang/String;", "getEmail", "getFirstName", "()Z", "getLastName", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class ComplianceUserVerificationResult implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ComplianceUserVerificationResult> CREATOR = new Creator();
    @Nullable
    private final String dateOfBirth;
    @Nullable
    private final String email;
    @Nullable
    private final String firstName;
    private final boolean isPromotionsConsentChecked;
    @Nullable
    private final String lastName;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ComplianceUserVerificationResult> {
        @NotNull
        public final ComplianceUserVerificationResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ComplianceUserVerificationResult(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @NotNull
        public final ComplianceUserVerificationResult[] newArray(int i11) {
            return new ComplianceUserVerificationResult[i11];
        }
    }

    public ComplianceUserVerificationResult(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z11) {
        this.firstName = str;
        this.lastName = str2;
        this.dateOfBirth = str3;
        this.email = str4;
        this.isPromotionsConsentChecked = z11;
    }

    public static /* synthetic */ ComplianceUserVerificationResult copy$default(ComplianceUserVerificationResult complianceUserVerificationResult, String str, String str2, String str3, String str4, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = complianceUserVerificationResult.firstName;
        }
        if ((i11 & 2) != 0) {
            str2 = complianceUserVerificationResult.lastName;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = complianceUserVerificationResult.dateOfBirth;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            str4 = complianceUserVerificationResult.email;
        }
        String str7 = str4;
        if ((i11 & 16) != 0) {
            z11 = complianceUserVerificationResult.isPromotionsConsentChecked;
        }
        return complianceUserVerificationResult.copy(str, str5, str6, str7, z11);
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

    public final boolean component5() {
        return this.isPromotionsConsentChecked;
    }

    @NotNull
    public final ComplianceUserVerificationResult copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z11) {
        return new ComplianceUserVerificationResult(str, str2, str3, str4, z11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComplianceUserVerificationResult)) {
            return false;
        }
        ComplianceUserVerificationResult complianceUserVerificationResult = (ComplianceUserVerificationResult) obj;
        return Intrinsics.areEqual((Object) this.firstName, (Object) complianceUserVerificationResult.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) complianceUserVerificationResult.lastName) && Intrinsics.areEqual((Object) this.dateOfBirth, (Object) complianceUserVerificationResult.dateOfBirth) && Intrinsics.areEqual((Object) this.email, (Object) complianceUserVerificationResult.email) && this.isPromotionsConsentChecked == complianceUserVerificationResult.isPromotionsConsentChecked;
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

    public int hashCode() {
        String str = this.firstName;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.lastName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dateOfBirth;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.email;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        int i12 = (hashCode3 + i11) * 31;
        boolean z11 = this.isPromotionsConsentChecked;
        if (z11) {
            z11 = true;
        }
        return i12 + (z11 ? 1 : 0);
    }

    public final boolean isPromotionsConsentChecked() {
        return this.isPromotionsConsentChecked;
    }

    @NotNull
    public String toString() {
        String str = this.firstName;
        String str2 = this.lastName;
        String str3 = this.dateOfBirth;
        String str4 = this.email;
        boolean z11 = this.isPromotionsConsentChecked;
        return "ComplianceUserVerificationResult(firstName=" + str + ", lastName=" + str2 + ", dateOfBirth=" + str3 + ", email=" + str4 + ", isPromotionsConsentChecked=" + z11 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.dateOfBirth);
        parcel.writeString(this.email);
        parcel.writeInt(this.isPromotionsConsentChecked ? 1 : 0);
    }
}
