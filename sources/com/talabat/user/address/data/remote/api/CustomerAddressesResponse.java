package com.talabat.user.address.data.remote.api;

import com.google.gson.annotations.SerializedName;
import com.talabat.feature.address.data.AddressDto;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/talabat/user/address/data/remote/api/CustomerAddressesResponse;", "", "timestamp", "", "baseUrl", "result", "", "Lcom/talabat/feature/address/data/AddressDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBaseUrl", "()Ljava/lang/String;", "getResult", "()Ljava/util/List;", "getTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerAddressesResponse {
    @SerializedName("baseUrl")
    @Nullable
    private final String baseUrl;
    @SerializedName("result")
    @Nullable
    private final List<AddressDto> result;
    @SerializedName("timestamp")
    @Nullable
    private final String timestamp;

    public CustomerAddressesResponse(@Nullable String str, @Nullable String str2, @Nullable List<AddressDto> list) {
        this.timestamp = str;
        this.baseUrl = str2;
        this.result = list;
    }

    public static /* synthetic */ CustomerAddressesResponse copy$default(CustomerAddressesResponse customerAddressesResponse, String str, String str2, List<AddressDto> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = customerAddressesResponse.timestamp;
        }
        if ((i11 & 2) != 0) {
            str2 = customerAddressesResponse.baseUrl;
        }
        if ((i11 & 4) != 0) {
            list = customerAddressesResponse.result;
        }
        return customerAddressesResponse.copy(str, str2, list);
    }

    @Nullable
    public final String component1() {
        return this.timestamp;
    }

    @Nullable
    public final String component2() {
        return this.baseUrl;
    }

    @Nullable
    public final List<AddressDto> component3() {
        return this.result;
    }

    @NotNull
    public final CustomerAddressesResponse copy(@Nullable String str, @Nullable String str2, @Nullable List<AddressDto> list) {
        return new CustomerAddressesResponse(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerAddressesResponse)) {
            return false;
        }
        CustomerAddressesResponse customerAddressesResponse = (CustomerAddressesResponse) obj;
        return Intrinsics.areEqual((Object) this.timestamp, (Object) customerAddressesResponse.timestamp) && Intrinsics.areEqual((Object) this.baseUrl, (Object) customerAddressesResponse.baseUrl) && Intrinsics.areEqual((Object) this.result, (Object) customerAddressesResponse.result);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Nullable
    public final List<AddressDto> getResult() {
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
        String str2 = this.baseUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<AddressDto> list = this.result;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.timestamp;
        String str2 = this.baseUrl;
        List<AddressDto> list = this.result;
        return "CustomerAddressesResponse(timestamp=" + str + ", baseUrl=" + str2 + ", result=" + list + ")";
    }
}
