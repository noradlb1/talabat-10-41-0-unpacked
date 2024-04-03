package com.checkout.network.response;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/checkout/network/response/ErrorResponse;", "", "requestId", "", "errorType", "errorCodes", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getErrorCodes", "()Ljava/util/List;", "getErrorType", "()Ljava/lang/String;", "getRequestId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ErrorResponse {
    @Nullable
    private final List<String> errorCodes;
    @Nullable
    private final String errorType;
    @Nullable
    private final String requestId;

    public ErrorResponse(@Nullable @Json(name = "request_id") String str, @Nullable @Json(name = "error_type") String str2, @Nullable @Json(name = "error_codes") List<String> list) {
        this.requestId = str;
        this.errorType = str2;
        this.errorCodes = list;
    }

    public static /* synthetic */ ErrorResponse copy$default(ErrorResponse errorResponse, String str, String str2, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = errorResponse.requestId;
        }
        if ((i11 & 2) != 0) {
            str2 = errorResponse.errorType;
        }
        if ((i11 & 4) != 0) {
            list = errorResponse.errorCodes;
        }
        return errorResponse.copy(str, str2, list);
    }

    @Nullable
    public final String component1() {
        return this.requestId;
    }

    @Nullable
    public final String component2() {
        return this.errorType;
    }

    @Nullable
    public final List<String> component3() {
        return this.errorCodes;
    }

    @NotNull
    public final ErrorResponse copy(@Nullable @Json(name = "request_id") String str, @Nullable @Json(name = "error_type") String str2, @Nullable @Json(name = "error_codes") List<String> list) {
        return new ErrorResponse(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResponse)) {
            return false;
        }
        ErrorResponse errorResponse = (ErrorResponse) obj;
        return Intrinsics.areEqual((Object) this.requestId, (Object) errorResponse.requestId) && Intrinsics.areEqual((Object) this.errorType, (Object) errorResponse.errorType) && Intrinsics.areEqual((Object) this.errorCodes, (Object) errorResponse.errorCodes);
    }

    @Nullable
    public final List<String> getErrorCodes() {
        return this.errorCodes;
    }

    @Nullable
    public final String getErrorType() {
        return this.errorType;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        String str = this.requestId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.errorCodes;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.requestId;
        String str2 = this.errorType;
        List<String> list = this.errorCodes;
        return "ErrorResponse(requestId=" + str + ", errorType=" + str2 + ", errorCodes=" + list + ")";
    }
}
