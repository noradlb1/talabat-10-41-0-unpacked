package com.talabat.userandlocation.login.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail;", "", "()V", "Error", "InvalidEmail", "Success", "Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail$Success;", "Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail$InvalidEmail;", "Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail$Error;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class VerifiedEmail {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail$Error;", "Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends VerifiedEmail {
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = error.message;
            }
            return error.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        @NotNull
        public final Error copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Error(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual((Object) this.message, (Object) ((Error) obj).message);
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.message;
            return "Error(message=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail$InvalidEmail;", "Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InvalidEmail extends VerifiedEmail {
        @NotNull
        public static final InvalidEmail INSTANCE = new InvalidEmail();

        private InvalidEmail() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail$Success;", "Lcom/talabat/userandlocation/login/domain/entity/VerifiedEmail;", "email", "", "isKnown", "", "isB2BCustomer", "hasSocialLogin", "hasPassword", "(Ljava/lang/String;ZZZZ)V", "getEmail", "()Ljava/lang/String;", "getHasPassword", "()Z", "getHasSocialLogin", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Success extends VerifiedEmail {
        @NotNull
        private final String email;
        private final boolean hasPassword;
        private final boolean hasSocialLogin;
        private final boolean isB2BCustomer;
        private final boolean isKnown;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull String str, boolean z11, boolean z12, boolean z13, boolean z14) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "email");
            this.email = str;
            this.isKnown = z11;
            this.isB2BCustomer = z12;
            this.hasSocialLogin = z13;
            this.hasPassword = z14;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, boolean z11, boolean z12, boolean z13, boolean z14, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = success.email;
            }
            if ((i11 & 2) != 0) {
                z11 = success.isKnown;
            }
            boolean z15 = z11;
            if ((i11 & 4) != 0) {
                z12 = success.isB2BCustomer;
            }
            boolean z16 = z12;
            if ((i11 & 8) != 0) {
                z13 = success.hasSocialLogin;
            }
            boolean z17 = z13;
            if ((i11 & 16) != 0) {
                z14 = success.hasPassword;
            }
            return success.copy(str, z15, z16, z17, z14);
        }

        @NotNull
        public final String component1() {
            return this.email;
        }

        public final boolean component2() {
            return this.isKnown;
        }

        public final boolean component3() {
            return this.isB2BCustomer;
        }

        public final boolean component4() {
            return this.hasSocialLogin;
        }

        public final boolean component5() {
            return this.hasPassword;
        }

        @NotNull
        public final Success copy(@NotNull String str, boolean z11, boolean z12, boolean z13, boolean z14) {
            Intrinsics.checkNotNullParameter(str, "email");
            return new Success(str, z11, z12, z13, z14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Success)) {
                return false;
            }
            Success success = (Success) obj;
            return Intrinsics.areEqual((Object) this.email, (Object) success.email) && this.isKnown == success.isKnown && this.isB2BCustomer == success.isB2BCustomer && this.hasSocialLogin == success.hasSocialLogin && this.hasPassword == success.hasPassword;
        }

        @NotNull
        public final String getEmail() {
            return this.email;
        }

        public final boolean getHasPassword() {
            return this.hasPassword;
        }

        public final boolean getHasSocialLogin() {
            return this.hasSocialLogin;
        }

        public int hashCode() {
            int hashCode = this.email.hashCode() * 31;
            boolean z11 = this.isKnown;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.isB2BCustomer;
            if (z13) {
                z13 = true;
            }
            int i12 = (i11 + (z13 ? 1 : 0)) * 31;
            boolean z14 = this.hasSocialLogin;
            if (z14) {
                z14 = true;
            }
            int i13 = (i12 + (z14 ? 1 : 0)) * 31;
            boolean z15 = this.hasPassword;
            if (!z15) {
                z12 = z15;
            }
            return i13 + (z12 ? 1 : 0);
        }

        public final boolean isB2BCustomer() {
            return this.isB2BCustomer;
        }

        public final boolean isKnown() {
            return this.isKnown;
        }

        @NotNull
        public String toString() {
            String str = this.email;
            boolean z11 = this.isKnown;
            boolean z12 = this.isB2BCustomer;
            boolean z13 = this.hasSocialLogin;
            boolean z14 = this.hasPassword;
            return "Success(email=" + str + ", isKnown=" + z11 + ", isB2BCustomer=" + z12 + ", hasSocialLogin=" + z13 + ", hasPassword=" + z14 + ")";
        }
    }

    private VerifiedEmail() {
    }

    public /* synthetic */ VerifiedEmail(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
