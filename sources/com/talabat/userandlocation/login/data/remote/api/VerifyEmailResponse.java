package com.talabat.userandlocation.login.data.remote.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/userandlocation/login/data/remote/api/VerifyEmailResponse;", "", "statusCode", "", "data", "Lcom/talabat/userandlocation/login/data/remote/api/VerifyEmailResponse$Data;", "(ILcom/talabat/userandlocation/login/data/remote/api/VerifyEmailResponse$Data;)V", "getData", "()Lcom/talabat/userandlocation/login/data/remote/api/VerifyEmailResponse$Data;", "getStatusCode", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Data", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyEmailResponse {
    @SerializedName("data")
    @Nullable
    private final Data data;
    @SerializedName("status_code")
    private final int statusCode;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ>\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0004\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/userandlocation/login/data/remote/api/VerifyEmailResponse$Data;", "", "isKnown", "", "isB2BCustomer", "hasSocialLogin", "hasPassword", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getHasPassword", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasSocialLogin", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/userandlocation/login/data/remote/api/VerifyEmailResponse$Data;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Data {
        @SerializedName("has_password")
        @Nullable
        private final Boolean hasPassword;
        @SerializedName("has_social_login")
        @Nullable
        private final Boolean hasSocialLogin;
        @SerializedName("is_b2b_customer")
        @Nullable
        private final Boolean isB2BCustomer;
        @SerializedName("is_known")
        @Nullable
        private final Boolean isKnown;

        public Data(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4) {
            this.isKnown = bool;
            this.isB2BCustomer = bool2;
            this.hasSocialLogin = bool3;
            this.hasPassword = bool4;
        }

        public static /* synthetic */ Data copy$default(Data data, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bool = data.isKnown;
            }
            if ((i11 & 2) != 0) {
                bool2 = data.isB2BCustomer;
            }
            if ((i11 & 4) != 0) {
                bool3 = data.hasSocialLogin;
            }
            if ((i11 & 8) != 0) {
                bool4 = data.hasPassword;
            }
            return data.copy(bool, bool2, bool3, bool4);
        }

        @Nullable
        public final Boolean component1() {
            return this.isKnown;
        }

        @Nullable
        public final Boolean component2() {
            return this.isB2BCustomer;
        }

        @Nullable
        public final Boolean component3() {
            return this.hasSocialLogin;
        }

        @Nullable
        public final Boolean component4() {
            return this.hasPassword;
        }

        @NotNull
        public final Data copy(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4) {
            return new Data(bool, bool2, bool3, bool4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual((Object) this.isKnown, (Object) data.isKnown) && Intrinsics.areEqual((Object) this.isB2BCustomer, (Object) data.isB2BCustomer) && Intrinsics.areEqual((Object) this.hasSocialLogin, (Object) data.hasSocialLogin) && Intrinsics.areEqual((Object) this.hasPassword, (Object) data.hasPassword);
        }

        @Nullable
        public final Boolean getHasPassword() {
            return this.hasPassword;
        }

        @Nullable
        public final Boolean getHasSocialLogin() {
            return this.hasSocialLogin;
        }

        public int hashCode() {
            Boolean bool = this.isKnown;
            int i11 = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.isB2BCustomer;
            int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.hasSocialLogin;
            int hashCode3 = (hashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.hasPassword;
            if (bool4 != null) {
                i11 = bool4.hashCode();
            }
            return hashCode3 + i11;
        }

        @Nullable
        public final Boolean isB2BCustomer() {
            return this.isB2BCustomer;
        }

        @Nullable
        public final Boolean isKnown() {
            return this.isKnown;
        }

        @NotNull
        public String toString() {
            Boolean bool = this.isKnown;
            Boolean bool2 = this.isB2BCustomer;
            Boolean bool3 = this.hasSocialLogin;
            Boolean bool4 = this.hasPassword;
            return "Data(isKnown=" + bool + ", isB2BCustomer=" + bool2 + ", hasSocialLogin=" + bool3 + ", hasPassword=" + bool4 + ")";
        }
    }

    public VerifyEmailResponse(int i11, @Nullable Data data2) {
        this.statusCode = i11;
        this.data = data2;
    }

    public static /* synthetic */ VerifyEmailResponse copy$default(VerifyEmailResponse verifyEmailResponse, int i11, Data data2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = verifyEmailResponse.statusCode;
        }
        if ((i12 & 2) != 0) {
            data2 = verifyEmailResponse.data;
        }
        return verifyEmailResponse.copy(i11, data2);
    }

    public final int component1() {
        return this.statusCode;
    }

    @Nullable
    public final Data component2() {
        return this.data;
    }

    @NotNull
    public final VerifyEmailResponse copy(int i11, @Nullable Data data2) {
        return new VerifyEmailResponse(i11, data2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerifyEmailResponse)) {
            return false;
        }
        VerifyEmailResponse verifyEmailResponse = (VerifyEmailResponse) obj;
        return this.statusCode == verifyEmailResponse.statusCode && Intrinsics.areEqual((Object) this.data, (Object) verifyEmailResponse.data);
    }

    @Nullable
    public final Data getData() {
        return this.data;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        int i11 = this.statusCode * 31;
        Data data2 = this.data;
        return i11 + (data2 == null ? 0 : data2.hashCode());
    }

    @NotNull
    public String toString() {
        int i11 = this.statusCode;
        Data data2 = this.data;
        return "VerifyEmailResponse(statusCode=" + i11 + ", data=" + data2 + ")";
    }
}
