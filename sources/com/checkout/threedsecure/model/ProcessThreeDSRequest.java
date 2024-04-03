package com.checkout.threedsecure.model;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/checkout/threedsecure/model/ProcessThreeDSRequest;", "", "redirectUrl", "", "successUrl", "failureUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFailureUrl", "()Ljava/lang/String;", "getRedirectUrl", "getSuccessUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ProcessThreeDSRequest {
    @NotNull
    private final String failureUrl;
    @Nullable
    private final String redirectUrl;
    @NotNull
    private final String successUrl;

    public ProcessThreeDSRequest(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, "successUrl");
        Intrinsics.checkNotNullParameter(str3, "failureUrl");
        this.redirectUrl = str;
        this.successUrl = str2;
        this.failureUrl = str3;
    }

    public static /* synthetic */ ProcessThreeDSRequest copy$default(ProcessThreeDSRequest processThreeDSRequest, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = processThreeDSRequest.redirectUrl;
        }
        if ((i11 & 2) != 0) {
            str2 = processThreeDSRequest.successUrl;
        }
        if ((i11 & 4) != 0) {
            str3 = processThreeDSRequest.failureUrl;
        }
        return processThreeDSRequest.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.redirectUrl;
    }

    @NotNull
    public final String component2() {
        return this.successUrl;
    }

    @NotNull
    public final String component3() {
        return this.failureUrl;
    }

    @NotNull
    public final ProcessThreeDSRequest copy(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, "successUrl");
        Intrinsics.checkNotNullParameter(str3, "failureUrl");
        return new ProcessThreeDSRequest(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessThreeDSRequest)) {
            return false;
        }
        ProcessThreeDSRequest processThreeDSRequest = (ProcessThreeDSRequest) obj;
        return Intrinsics.areEqual((Object) this.redirectUrl, (Object) processThreeDSRequest.redirectUrl) && Intrinsics.areEqual((Object) this.successUrl, (Object) processThreeDSRequest.successUrl) && Intrinsics.areEqual((Object) this.failureUrl, (Object) processThreeDSRequest.failureUrl);
    }

    @NotNull
    public final String getFailureUrl() {
        return this.failureUrl;
    }

    @Nullable
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @NotNull
    public final String getSuccessUrl() {
        return this.successUrl;
    }

    public int hashCode() {
        String str = this.redirectUrl;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.successUrl.hashCode()) * 31) + this.failureUrl.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.redirectUrl;
        String str2 = this.successUrl;
        String str3 = this.failureUrl;
        return "ProcessThreeDSRequest(redirectUrl=" + str + ", successUrl=" + str2 + ", failureUrl=" + str3 + ")";
    }
}
