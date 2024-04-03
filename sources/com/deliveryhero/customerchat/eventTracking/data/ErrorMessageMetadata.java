package com.deliveryhero.customerchat.eventTracking.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/data/ErrorMessageMetadata;", "", "errorMessage", "", "errorCode", "correlationID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationID", "()Ljava/lang/String;", "getErrorCode", "getErrorMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ErrorMessageMetadata {
    @Nullable
    private final String correlationID;
    @Nullable
    private final String errorCode;
    @Nullable
    private final String errorMessage;

    public ErrorMessageMetadata(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.errorMessage = str;
        this.errorCode = str2;
        this.correlationID = str3;
    }

    public static /* synthetic */ ErrorMessageMetadata copy$default(ErrorMessageMetadata errorMessageMetadata, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = errorMessageMetadata.errorMessage;
        }
        if ((i11 & 2) != 0) {
            str2 = errorMessageMetadata.errorCode;
        }
        if ((i11 & 4) != 0) {
            str3 = errorMessageMetadata.correlationID;
        }
        return errorMessageMetadata.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.errorMessage;
    }

    @Nullable
    public final String component2() {
        return this.errorCode;
    }

    @Nullable
    public final String component3() {
        return this.correlationID;
    }

    @NotNull
    public final ErrorMessageMetadata copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new ErrorMessageMetadata(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorMessageMetadata)) {
            return false;
        }
        ErrorMessageMetadata errorMessageMetadata = (ErrorMessageMetadata) obj;
        return Intrinsics.areEqual((Object) this.errorMessage, (Object) errorMessageMetadata.errorMessage) && Intrinsics.areEqual((Object) this.errorCode, (Object) errorMessageMetadata.errorCode) && Intrinsics.areEqual((Object) this.correlationID, (Object) errorMessageMetadata.correlationID);
    }

    @Nullable
    public final String getCorrelationID() {
        return this.correlationID;
    }

    @Nullable
    public final String getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        String str = this.errorMessage;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.correlationID;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        return "ErrorMessageMetadata(errorMessage=" + this.errorMessage + ", errorCode=" + this.errorCode + ", correlationID=" + this.correlationID + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ErrorMessageMetadata(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, str3);
    }
}
