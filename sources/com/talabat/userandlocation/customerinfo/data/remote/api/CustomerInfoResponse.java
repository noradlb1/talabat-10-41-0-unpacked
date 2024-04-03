package com.talabat.userandlocation.customerinfo.data.remote.api;

import com.google.gson.annotations.SerializedName;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/data/remote/api/CustomerInfoResponse;", "", "timestamp", "", "result", "Ldatamodels/CustomerInfo;", "(Ljava/lang/String;Ldatamodels/CustomerInfo;)V", "getResult", "()Ldatamodels/CustomerInfo;", "getTimestamp", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerInfoResponse {
    @SerializedName("result")
    @Nullable
    private final CustomerInfo result;
    @SerializedName("timestamp")
    @Nullable
    private final String timestamp;

    public CustomerInfoResponse(@Nullable String str, @Nullable CustomerInfo customerInfo) {
        this.timestamp = str;
        this.result = customerInfo;
    }

    public static /* synthetic */ CustomerInfoResponse copy$default(CustomerInfoResponse customerInfoResponse, String str, CustomerInfo customerInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = customerInfoResponse.timestamp;
        }
        if ((i11 & 2) != 0) {
            customerInfo = customerInfoResponse.result;
        }
        return customerInfoResponse.copy(str, customerInfo);
    }

    @Nullable
    public final String component1() {
        return this.timestamp;
    }

    @Nullable
    public final CustomerInfo component2() {
        return this.result;
    }

    @NotNull
    public final CustomerInfoResponse copy(@Nullable String str, @Nullable CustomerInfo customerInfo) {
        return new CustomerInfoResponse(str, customerInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerInfoResponse)) {
            return false;
        }
        CustomerInfoResponse customerInfoResponse = (CustomerInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.timestamp, (Object) customerInfoResponse.timestamp) && Intrinsics.areEqual((Object) this.result, (Object) customerInfoResponse.result);
    }

    @Nullable
    public final CustomerInfo getResult() {
        return this.result;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.timestamp;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        CustomerInfo customerInfo = this.result;
        if (customerInfo != null) {
            i11 = customerInfo.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.timestamp;
        CustomerInfo customerInfo = this.result;
        return "CustomerInfoResponse(timestamp=" + str + ", result=" + customerInfo + ")";
    }
}
