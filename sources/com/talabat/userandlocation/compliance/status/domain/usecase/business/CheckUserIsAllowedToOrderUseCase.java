package com.talabat.userandlocation.compliance.status.domain.usecase.business;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase;", "", "isUserAllowedToOrder", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result;", "firstName", "", "lastName", "dateOfBirth", "isAfterUpdatingUserInfo", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Result", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CheckUserIsAllowedToOrderUseCase {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result;", "", "()V", "AllowedToOrder", "Blocked", "ShouldVerifyUserInfo", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result$AllowedToOrder;", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result$Blocked;", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result$ShouldVerifyUserInfo;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Result {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result$AllowedToOrder;", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class AllowedToOrder extends Result {
            @NotNull
            public static final AllowedToOrder INSTANCE = new AllowedToOrder();

            private AllowedToOrder() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result$Blocked;", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Blocked extends Result {
            @NotNull
            public static final Blocked INSTANCE = new Blocked();

            private Blocked() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result$ShouldVerifyUserInfo;", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result;", "firstName", "", "lastName", "dateOfBirth", "email", "mobileNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDateOfBirth", "()Ljava/lang/String;", "getEmail", "getFirstName", "getLastName", "getMobileNumber", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class ShouldVerifyUserInfo extends Result {
            @NotNull
            private final String dateOfBirth;
            @NotNull
            private final String email;
            @NotNull
            private final String firstName;
            @NotNull
            private final String lastName;
            @Nullable
            private final String mobileNumber;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShouldVerifyUserInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "firstName");
                Intrinsics.checkNotNullParameter(str2, "lastName");
                Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
                Intrinsics.checkNotNullParameter(str4, "email");
                this.firstName = str;
                this.lastName = str2;
                this.dateOfBirth = str3;
                this.email = str4;
                this.mobileNumber = str5;
            }

            public static /* synthetic */ ShouldVerifyUserInfo copy$default(ShouldVerifyUserInfo shouldVerifyUserInfo, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = shouldVerifyUserInfo.firstName;
                }
                if ((i11 & 2) != 0) {
                    str2 = shouldVerifyUserInfo.lastName;
                }
                String str6 = str2;
                if ((i11 & 4) != 0) {
                    str3 = shouldVerifyUserInfo.dateOfBirth;
                }
                String str7 = str3;
                if ((i11 & 8) != 0) {
                    str4 = shouldVerifyUserInfo.email;
                }
                String str8 = str4;
                if ((i11 & 16) != 0) {
                    str5 = shouldVerifyUserInfo.mobileNumber;
                }
                return shouldVerifyUserInfo.copy(str, str6, str7, str8, str5);
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

            @Nullable
            public final String component5() {
                return this.mobileNumber;
            }

            @NotNull
            public final ShouldVerifyUserInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5) {
                Intrinsics.checkNotNullParameter(str, "firstName");
                Intrinsics.checkNotNullParameter(str2, "lastName");
                Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
                Intrinsics.checkNotNullParameter(str4, "email");
                return new ShouldVerifyUserInfo(str, str2, str3, str4, str5);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ShouldVerifyUserInfo)) {
                    return false;
                }
                ShouldVerifyUserInfo shouldVerifyUserInfo = (ShouldVerifyUserInfo) obj;
                return Intrinsics.areEqual((Object) this.firstName, (Object) shouldVerifyUserInfo.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) shouldVerifyUserInfo.lastName) && Intrinsics.areEqual((Object) this.dateOfBirth, (Object) shouldVerifyUserInfo.dateOfBirth) && Intrinsics.areEqual((Object) this.email, (Object) shouldVerifyUserInfo.email) && Intrinsics.areEqual((Object) this.mobileNumber, (Object) shouldVerifyUserInfo.mobileNumber);
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

            @Nullable
            public final String getMobileNumber() {
                return this.mobileNumber;
            }

            public int hashCode() {
                int hashCode = ((((((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31) + this.dateOfBirth.hashCode()) * 31) + this.email.hashCode()) * 31;
                String str = this.mobileNumber;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            @NotNull
            public String toString() {
                String str = this.firstName;
                String str2 = this.lastName;
                String str3 = this.dateOfBirth;
                String str4 = this.email;
                String str5 = this.mobileNumber;
                return "ShouldVerifyUserInfo(firstName=" + str + ", lastName=" + str2 + ", dateOfBirth=" + str3 + ", email=" + str4 + ", mobileNumber=" + str5 + ")";
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    Object isUserAllowedToOrder(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11, @NotNull Continuation<? super Result> continuation);
}
