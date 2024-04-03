package com.talabat.userandlocation.otp.data.remote.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001\u001aB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/userandlocation/otp/data/remote/api/GetOtpResult;", "", "message", "", "remainingRequests", "", "status", "Lcom/talabat/userandlocation/otp/data/remote/api/GetOtpResult$Status;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/talabat/userandlocation/otp/data/remote/api/GetOtpResult$Status;)V", "getMessage", "()Ljava/lang/String;", "getRemainingRequests", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "()Lcom/talabat/userandlocation/otp/data/remote/api/GetOtpResult$Status;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/talabat/userandlocation/otp/data/remote/api/GetOtpResult$Status;)Lcom/talabat/userandlocation/otp/data/remote/api/GetOtpResult;", "equals", "", "other", "hashCode", "toString", "Status", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetOtpResult {
    @SerializedName("msg")
    @Nullable
    private final String message;
    @SerializedName("otpRequestRemaining")
    @Nullable
    private final Integer remainingRequests;
    @SerializedName("otpStatus")
    @Nullable
    private final Status status;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/otp/data/remote/api/GetOtpResult$Status;", "", "(Ljava/lang/String;I)V", "PASS", "FAILED_TO_INSERT_OTP", "PHONE_VALIDATION_ERROR", "ERROR_MAX_RETRY", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Status {
        PASS,
        FAILED_TO_INSERT_OTP,
        PHONE_VALIDATION_ERROR,
        ERROR_MAX_RETRY
    }

    public GetOtpResult(@Nullable String str, @Nullable Integer num, @Nullable Status status2) {
        this.message = str;
        this.remainingRequests = num;
        this.status = status2;
    }

    public static /* synthetic */ GetOtpResult copy$default(GetOtpResult getOtpResult, String str, Integer num, Status status2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = getOtpResult.message;
        }
        if ((i11 & 2) != 0) {
            num = getOtpResult.remainingRequests;
        }
        if ((i11 & 4) != 0) {
            status2 = getOtpResult.status;
        }
        return getOtpResult.copy(str, num, status2);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @Nullable
    public final Integer component2() {
        return this.remainingRequests;
    }

    @Nullable
    public final Status component3() {
        return this.status;
    }

    @NotNull
    public final GetOtpResult copy(@Nullable String str, @Nullable Integer num, @Nullable Status status2) {
        return new GetOtpResult(str, num, status2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetOtpResult)) {
            return false;
        }
        GetOtpResult getOtpResult = (GetOtpResult) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) getOtpResult.message) && Intrinsics.areEqual((Object) this.remainingRequests, (Object) getOtpResult.remainingRequests) && this.status == getOtpResult.status;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Integer getRemainingRequests() {
        return this.remainingRequests;
    }

    @Nullable
    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.message;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.remainingRequests;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Status status2 = this.status;
        if (status2 != null) {
            i11 = status2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.message;
        Integer num = this.remainingRequests;
        Status status2 = this.status;
        return "GetOtpResult(message=" + str + ", remainingRequests=" + num + ", status=" + status2 + ")";
    }
}
