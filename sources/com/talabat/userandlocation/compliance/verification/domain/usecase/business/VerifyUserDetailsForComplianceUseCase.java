package com.talabat.userandlocation.compliance.verification.domain.usecase.business;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nJ\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase;", "", "verifyUserDetailsForCompliance", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$UserVerificationForComplianceResult;", "arguments", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$Arguments;", "(Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$Arguments;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Arguments", "Field", "UserVerificationForComplianceResult", "ValidationError", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VerifyUserDetailsForComplianceUseCase {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$Arguments;", "", "firstName", "", "lastName", "dateOfBirth", "email", "isPrivacyTermsConsentChecked", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDateOfBirth", "()Ljava/lang/String;", "getEmail", "getFirstName", "()Z", "getLastName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Arguments {
        @NotNull
        private final String dateOfBirth;
        @NotNull
        private final String email;
        @NotNull
        private final String firstName;
        private final boolean isPrivacyTermsConsentChecked;
        @NotNull
        private final String lastName;

        public Arguments(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "firstName");
            Intrinsics.checkNotNullParameter(str2, "lastName");
            Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
            Intrinsics.checkNotNullParameter(str4, "email");
            this.firstName = str;
            this.lastName = str2;
            this.dateOfBirth = str3;
            this.email = str4;
            this.isPrivacyTermsConsentChecked = z11;
        }

        public static /* synthetic */ Arguments copy$default(Arguments arguments, String str, String str2, String str3, String str4, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = arguments.firstName;
            }
            if ((i11 & 2) != 0) {
                str2 = arguments.lastName;
            }
            String str5 = str2;
            if ((i11 & 4) != 0) {
                str3 = arguments.dateOfBirth;
            }
            String str6 = str3;
            if ((i11 & 8) != 0) {
                str4 = arguments.email;
            }
            String str7 = str4;
            if ((i11 & 16) != 0) {
                z11 = arguments.isPrivacyTermsConsentChecked;
            }
            return arguments.copy(str, str5, str6, str7, z11);
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
            return this.dateOfBirth;
        }

        @NotNull
        public final String component4() {
            return this.email;
        }

        public final boolean component5() {
            return this.isPrivacyTermsConsentChecked;
        }

        @NotNull
        public final Arguments copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "firstName");
            Intrinsics.checkNotNullParameter(str2, "lastName");
            Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
            Intrinsics.checkNotNullParameter(str4, "email");
            return new Arguments(str, str2, str3, str4, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Arguments)) {
                return false;
            }
            Arguments arguments = (Arguments) obj;
            return Intrinsics.areEqual((Object) this.firstName, (Object) arguments.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) arguments.lastName) && Intrinsics.areEqual((Object) this.dateOfBirth, (Object) arguments.dateOfBirth) && Intrinsics.areEqual((Object) this.email, (Object) arguments.email) && this.isPrivacyTermsConsentChecked == arguments.isPrivacyTermsConsentChecked;
        }

        @NotNull
        public final String getDateOfBirth() {
            return this.dateOfBirth;
        }

        @NotNull
        public final String getEmail() {
            return this.email;
        }

        @NotNull
        public final String getFirstName() {
            return this.firstName;
        }

        @NotNull
        public final String getLastName() {
            return this.lastName;
        }

        public int hashCode() {
            int hashCode = ((((((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31) + this.dateOfBirth.hashCode()) * 31) + this.email.hashCode()) * 31;
            boolean z11 = this.isPrivacyTermsConsentChecked;
            if (z11) {
                z11 = true;
            }
            return hashCode + (z11 ? 1 : 0);
        }

        public final boolean isPrivacyTermsConsentChecked() {
            return this.isPrivacyTermsConsentChecked;
        }

        @NotNull
        public String toString() {
            String str = this.firstName;
            String str2 = this.lastName;
            String str3 = this.dateOfBirth;
            String str4 = this.email;
            boolean z11 = this.isPrivacyTermsConsentChecked;
            return "Arguments(firstName=" + str + ", lastName=" + str2 + ", dateOfBirth=" + str3 + ", email=" + str4 + ", isPrivacyTermsConsentChecked=" + z11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$Field;", "", "(Ljava/lang/String;I)V", "FIRST_NAME", "LAST_NAME", "DATE_OF_BIRTH", "EMAIL", "PRIVACY_TERMS_CONSENT", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Field {
        FIRST_NAME,
        LAST_NAME,
        DATE_OF_BIRTH,
        EMAIL,
        PRIVACY_TERMS_CONSENT
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$UserVerificationForComplianceResult;", "", "()V", "VerificationFailed", "VerificationSuccess", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$UserVerificationForComplianceResult$VerificationSuccess;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$UserVerificationForComplianceResult$VerificationFailed;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class UserVerificationForComplianceResult {

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J%\u0010\u000b\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$UserVerificationForComplianceResult$VerificationFailed;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$UserVerificationForComplianceResult;", "invalidFields", "", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$Field;", "", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$ValidationError;", "(Ljava/util/Map;)V", "getInvalidFields", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class VerificationFailed extends UserVerificationForComplianceResult {
            @NotNull
            private final Map<Field, List<ValidationError>> invalidFields;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public VerificationFailed(@NotNull Map<Field, ? extends List<? extends ValidationError>> map) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(map, "invalidFields");
                this.invalidFields = map;
            }

            public static /* synthetic */ VerificationFailed copy$default(VerificationFailed verificationFailed, Map<Field, List<ValidationError>> map, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    map = verificationFailed.invalidFields;
                }
                return verificationFailed.copy(map);
            }

            @NotNull
            public final Map<Field, List<ValidationError>> component1() {
                return this.invalidFields;
            }

            @NotNull
            public final VerificationFailed copy(@NotNull Map<Field, ? extends List<? extends ValidationError>> map) {
                Intrinsics.checkNotNullParameter(map, "invalidFields");
                return new VerificationFailed(map);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof VerificationFailed) && Intrinsics.areEqual((Object) this.invalidFields, (Object) ((VerificationFailed) obj).invalidFields);
            }

            @NotNull
            public final Map<Field, List<ValidationError>> getInvalidFields() {
                return this.invalidFields;
            }

            public int hashCode() {
                return this.invalidFields.hashCode();
            }

            @NotNull
            public String toString() {
                Map<Field, List<ValidationError>> map = this.invalidFields;
                return "VerificationFailed(invalidFields=" + map + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$UserVerificationForComplianceResult$VerificationSuccess;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$UserVerificationForComplianceResult;", "()V", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class VerificationSuccess extends UserVerificationForComplianceResult {
            @NotNull
            public static final VerificationSuccess INSTANCE = new VerificationSuccess();

            private VerificationSuccess() {
                super((DefaultConstructorMarker) null);
            }
        }

        private UserVerificationForComplianceResult() {
        }

        public /* synthetic */ UserVerificationForComplianceResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$ValidationError;", "", "(Ljava/lang/String;I)V", "EMPTY", "EMAIL_PATTERN_ERROR", "NAME_LENGTH_EXCEEDED", "PRIVACY_TERMS_NOT_AGREED", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ValidationError {
        EMPTY,
        EMAIL_PATTERN_ERROR,
        NAME_LENGTH_EXCEEDED,
        PRIVACY_TERMS_NOT_AGREED
    }

    @Nullable
    Object verifyUserDetailsForCompliance(@NotNull Arguments arguments, @NotNull Continuation<? super UserVerificationForComplianceResult> continuation);
}
