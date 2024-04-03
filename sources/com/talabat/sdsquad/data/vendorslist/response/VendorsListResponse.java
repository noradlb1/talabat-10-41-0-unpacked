package com.talabat.sdsquad.data.vendorslist.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResponse;", "", "error", "hasserror", "", "result", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResult;", "timestamp", "", "version", "(Ljava/lang/Object;Ljava/lang/Boolean;Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResult;Ljava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/Object;", "getHasserror", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResult", "()Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResult;", "getTimestamp", "()Ljava/lang/String;", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Object;Ljava/lang/Boolean;Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResult;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResponse;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListResponse {
    @SerializedName("error")
    @Nullable
    private final Object error;
    @SerializedName("hasserror")
    @Nullable
    private final Boolean hasserror;
    @SerializedName("result")
    @Nullable
    private final VendorsListResult result;
    @SerializedName("timestamp")
    @Nullable
    private final String timestamp;
    @SerializedName("version")
    @Nullable
    private final String version;

    public VendorsListResponse(@Nullable Object obj, @Nullable Boolean bool, @Nullable VendorsListResult vendorsListResult, @Nullable String str, @Nullable String str2) {
        this.error = obj;
        this.hasserror = bool;
        this.result = vendorsListResult;
        this.timestamp = str;
        this.version = str2;
    }

    public static /* synthetic */ VendorsListResponse copy$default(VendorsListResponse vendorsListResponse, Object obj, Boolean bool, VendorsListResult vendorsListResult, String str, String str2, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = vendorsListResponse.error;
        }
        if ((i11 & 2) != 0) {
            bool = vendorsListResponse.hasserror;
        }
        Boolean bool2 = bool;
        if ((i11 & 4) != 0) {
            vendorsListResult = vendorsListResponse.result;
        }
        VendorsListResult vendorsListResult2 = vendorsListResult;
        if ((i11 & 8) != 0) {
            str = vendorsListResponse.timestamp;
        }
        String str3 = str;
        if ((i11 & 16) != 0) {
            str2 = vendorsListResponse.version;
        }
        return vendorsListResponse.copy(obj, bool2, vendorsListResult2, str3, str2);
    }

    @Nullable
    public final Object component1() {
        return this.error;
    }

    @Nullable
    public final Boolean component2() {
        return this.hasserror;
    }

    @Nullable
    public final VendorsListResult component3() {
        return this.result;
    }

    @Nullable
    public final String component4() {
        return this.timestamp;
    }

    @Nullable
    public final String component5() {
        return this.version;
    }

    @NotNull
    public final VendorsListResponse copy(@Nullable Object obj, @Nullable Boolean bool, @Nullable VendorsListResult vendorsListResult, @Nullable String str, @Nullable String str2) {
        return new VendorsListResponse(obj, bool, vendorsListResult, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorsListResponse)) {
            return false;
        }
        VendorsListResponse vendorsListResponse = (VendorsListResponse) obj;
        return Intrinsics.areEqual(this.error, vendorsListResponse.error) && Intrinsics.areEqual((Object) this.hasserror, (Object) vendorsListResponse.hasserror) && Intrinsics.areEqual((Object) this.result, (Object) vendorsListResponse.result) && Intrinsics.areEqual((Object) this.timestamp, (Object) vendorsListResponse.timestamp) && Intrinsics.areEqual((Object) this.version, (Object) vendorsListResponse.version);
    }

    @Nullable
    public final Object getError() {
        return this.error;
    }

    @Nullable
    public final Boolean getHasserror() {
        return this.hasserror;
    }

    @Nullable
    public final VendorsListResult getResult() {
        return this.result;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        Object obj = this.error;
        int i11 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Boolean bool = this.hasserror;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        VendorsListResult vendorsListResult = this.result;
        int hashCode3 = (hashCode2 + (vendorsListResult == null ? 0 : vendorsListResult.hashCode())) * 31;
        String str = this.timestamp;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        Object obj = this.error;
        Boolean bool = this.hasserror;
        VendorsListResult vendorsListResult = this.result;
        String str = this.timestamp;
        String str2 = this.version;
        return "VendorsListResponse(error=" + obj + ", hasserror=" + bool + ", result=" + vendorsListResult + ", timestamp=" + str + ", version=" + str2 + ")";
    }
}
