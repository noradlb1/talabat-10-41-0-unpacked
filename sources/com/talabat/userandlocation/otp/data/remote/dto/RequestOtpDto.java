package com.talabat.userandlocation.otp.data.remote.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/userandlocation/otp/data/remote/dto/RequestOtpDto;", "", "remainingRequests", "", "status", "Lcom/talabat/userandlocation/otp/data/remote/dto/RequestOtpDto$Status;", "message", "", "(ILcom/talabat/userandlocation/otp/data/remote/dto/RequestOtpDto$Status;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getRemainingRequests", "()I", "getStatus", "()Lcom/talabat/userandlocation/otp/data/remote/dto/RequestOtpDto$Status;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Status", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestOtpDto {
    @NotNull
    private final String message;
    private final int remainingRequests;
    @NotNull
    private final Status status;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/otp/data/remote/dto/RequestOtpDto$Status;", "", "(Ljava/lang/String;I)V", "PASS", "FAILED_TO_INSERT_OTP", "PHONE_VALIDATION_ERROR", "ERROR_MAX_RETRY", "NULL_STATUS", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Status {
        PASS,
        FAILED_TO_INSERT_OTP,
        PHONE_VALIDATION_ERROR,
        ERROR_MAX_RETRY,
        NULL_STATUS
    }

    public RequestOtpDto(int i11, @NotNull Status status2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(status2, "status");
        Intrinsics.checkNotNullParameter(str, "message");
        this.remainingRequests = i11;
        this.status = status2;
        this.message = str;
    }

    public static /* synthetic */ RequestOtpDto copy$default(RequestOtpDto requestOtpDto, int i11, Status status2, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = requestOtpDto.remainingRequests;
        }
        if ((i12 & 2) != 0) {
            status2 = requestOtpDto.status;
        }
        if ((i12 & 4) != 0) {
            str = requestOtpDto.message;
        }
        return requestOtpDto.copy(i11, status2, str);
    }

    public final int component1() {
        return this.remainingRequests;
    }

    @NotNull
    public final Status component2() {
        return this.status;
    }

    @NotNull
    public final String component3() {
        return this.message;
    }

    @NotNull
    public final RequestOtpDto copy(int i11, @NotNull Status status2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(status2, "status");
        Intrinsics.checkNotNullParameter(str, "message");
        return new RequestOtpDto(i11, status2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestOtpDto)) {
            return false;
        }
        RequestOtpDto requestOtpDto = (RequestOtpDto) obj;
        return this.remainingRequests == requestOtpDto.remainingRequests && this.status == requestOtpDto.status && Intrinsics.areEqual((Object) this.message, (Object) requestOtpDto.message);
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final int getRemainingRequests() {
        return this.remainingRequests;
    }

    @NotNull
    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((this.remainingRequests * 31) + this.status.hashCode()) * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.remainingRequests;
        Status status2 = this.status;
        String str = this.message;
        return "RequestOtpDto(remainingRequests=" + i11 + ", status=" + status2 + ", message=" + str + ")";
    }
}
