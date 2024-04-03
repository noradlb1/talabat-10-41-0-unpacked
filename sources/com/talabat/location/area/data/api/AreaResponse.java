package com.talabat.location.area.data.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/talabat/location/area/data/api/AreaResponse;", "", "message", "", "timestamp", "baseUrl", "result", "Lcom/talabat/location/area/data/api/Result;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/location/area/data/api/Result;)V", "getBaseUrl", "()Ljava/lang/String;", "getMessage", "getResult", "()Lcom/talabat/location/area/data/api/Result;", "getTimestamp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AreaResponse {
    @SerializedName("baseUrl")
    @Nullable
    private final String baseUrl;
    @SerializedName("message")
    @Nullable
    private final String message;
    @SerializedName("result")
    @Nullable
    private final Result result;
    @SerializedName("timestamp")
    @Nullable
    private final String timestamp;

    public AreaResponse(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Result result2) {
        this.message = str;
        this.timestamp = str2;
        this.baseUrl = str3;
        this.result = result2;
    }

    public static /* synthetic */ AreaResponse copy$default(AreaResponse areaResponse, String str, String str2, String str3, Result result2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = areaResponse.message;
        }
        if ((i11 & 2) != 0) {
            str2 = areaResponse.timestamp;
        }
        if ((i11 & 4) != 0) {
            str3 = areaResponse.baseUrl;
        }
        if ((i11 & 8) != 0) {
            result2 = areaResponse.result;
        }
        return areaResponse.copy(str, str2, str3, result2);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @Nullable
    public final String component2() {
        return this.timestamp;
    }

    @Nullable
    public final String component3() {
        return this.baseUrl;
    }

    @Nullable
    public final Result component4() {
        return this.result;
    }

    @NotNull
    public final AreaResponse copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Result result2) {
        return new AreaResponse(str, str2, str3, result2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AreaResponse)) {
            return false;
        }
        AreaResponse areaResponse = (AreaResponse) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) areaResponse.message) && Intrinsics.areEqual((Object) this.timestamp, (Object) areaResponse.timestamp) && Intrinsics.areEqual((Object) this.baseUrl, (Object) areaResponse.baseUrl) && Intrinsics.areEqual((Object) this.result, (Object) areaResponse.result);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Result getResult() {
        return this.result;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.message;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.timestamp;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.baseUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Result result2 = this.result;
        if (result2 != null) {
            i11 = result2.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.message;
        String str2 = this.timestamp;
        String str3 = this.baseUrl;
        Result result2 = this.result;
        return "AreaResponse(message=" + str + ", timestamp=" + str2 + ", baseUrl=" + str3 + ", result=" + result2 + ")";
    }
}
