package com.talabat.userandlocation.login.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/login/data/model/EmailVerification;", "", "()V", "Data", "Error", "Lcom/talabat/userandlocation/login/data/model/EmailVerification$Data;", "Lcom/talabat/userandlocation/login/data/model/EmailVerification$Error;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class EmailVerification {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/userandlocation/login/data/model/EmailVerification$Data;", "Lcom/talabat/userandlocation/login/data/model/EmailVerification;", "isKnown", "", "isB2BCustomer", "hasSocialLogin", "hasPassword", "(ZZZZ)V", "getHasPassword", "()Z", "getHasSocialLogin", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Data extends EmailVerification {
        private final boolean hasPassword;
        private final boolean hasSocialLogin;
        private final boolean isB2BCustomer;
        private final boolean isKnown;

        public Data(boolean z11, boolean z12, boolean z13, boolean z14) {
            super((DefaultConstructorMarker) null);
            this.isKnown = z11;
            this.isB2BCustomer = z12;
            this.hasSocialLogin = z13;
            this.hasPassword = z14;
        }

        public static /* synthetic */ Data copy$default(Data data, boolean z11, boolean z12, boolean z13, boolean z14, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = data.isKnown;
            }
            if ((i11 & 2) != 0) {
                z12 = data.isB2BCustomer;
            }
            if ((i11 & 4) != 0) {
                z13 = data.hasSocialLogin;
            }
            if ((i11 & 8) != 0) {
                z14 = data.hasPassword;
            }
            return data.copy(z11, z12, z13, z14);
        }

        public final boolean component1() {
            return this.isKnown;
        }

        public final boolean component2() {
            return this.isB2BCustomer;
        }

        public final boolean component3() {
            return this.hasSocialLogin;
        }

        public final boolean component4() {
            return this.hasPassword;
        }

        @NotNull
        public final Data copy(boolean z11, boolean z12, boolean z13, boolean z14) {
            return new Data(z11, z12, z13, z14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return this.isKnown == data.isKnown && this.isB2BCustomer == data.isB2BCustomer && this.hasSocialLogin == data.hasSocialLogin && this.hasPassword == data.hasPassword;
        }

        public final boolean getHasPassword() {
            return this.hasPassword;
        }

        public final boolean getHasSocialLogin() {
            return this.hasSocialLogin;
        }

        public int hashCode() {
            boolean z11 = this.isKnown;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (z11 ? 1 : 0) * true;
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
            boolean z11 = this.isKnown;
            boolean z12 = this.isB2BCustomer;
            boolean z13 = this.hasSocialLogin;
            boolean z14 = this.hasPassword;
            return "Data(isKnown=" + z11 + ", isB2BCustomer=" + z12 + ", hasSocialLogin=" + z13 + ", hasPassword=" + z14 + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/talabat/userandlocation/login/data/model/EmailVerification$Error;", "Lcom/talabat/userandlocation/login/data/model/EmailVerification;", "message", "", "errorType", "Lcom/talabat/userandlocation/login/data/model/EmailVerification$Error$ErrorType;", "(Ljava/lang/String;Lcom/talabat/userandlocation/login/data/model/EmailVerification$Error$ErrorType;)V", "getErrorType", "()Lcom/talabat/userandlocation/login/data/model/EmailVerification$Error$ErrorType;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ErrorType", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends EmailVerification {
        @Nullable
        private final ErrorType errorType;
        @NotNull
        private final String message;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/userandlocation/login/data/model/EmailVerification$Error$ErrorType;", "", "(Ljava/lang/String;I)V", "OAUTH_OAUTH_FAILED_EXCEPTION", "INVALID_EMAIL", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public enum ErrorType {
            OAUTH_OAUTH_FAILED_EXCEPTION,
            INVALID_EMAIL
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str, @Nullable ErrorType errorType2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
            this.errorType = errorType2;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, ErrorType errorType2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = error.message;
            }
            if ((i11 & 2) != 0) {
                errorType2 = error.errorType;
            }
            return error.copy(str, errorType2);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        @Nullable
        public final ErrorType component2() {
            return this.errorType;
        }

        @NotNull
        public final Error copy(@NotNull String str, @Nullable ErrorType errorType2) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Error(str, errorType2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) error.message) && this.errorType == error.errorType;
        }

        @Nullable
        public final ErrorType getErrorType() {
            return this.errorType;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int hashCode = this.message.hashCode() * 31;
            ErrorType errorType2 = this.errorType;
            return hashCode + (errorType2 == null ? 0 : errorType2.hashCode());
        }

        @NotNull
        public String toString() {
            String str = this.message;
            ErrorType errorType2 = this.errorType;
            return "Error(message=" + str + ", errorType=" + errorType2 + ")";
        }
    }

    private EmailVerification() {
    }

    public /* synthetic */ EmailVerification(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
