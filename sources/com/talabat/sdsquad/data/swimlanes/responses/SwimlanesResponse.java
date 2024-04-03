package com.talabat.sdsquad.data.swimlanes.responses;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/sdsquad/data/swimlanes/responses/SwimlanesResponse;", "", "baseUrl", "", "result", "Lcom/talabat/sdsquad/data/swimlanes/responses/Result;", "timestamp", "(Ljava/lang/String;Lcom/talabat/sdsquad/data/swimlanes/responses/Result;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getResult", "()Lcom/talabat/sdsquad/data/swimlanes/responses/Result;", "getTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesResponse {
    @SerializedName("baseUrl")
    @Nullable
    private final String baseUrl;
    @SerializedName("result")
    @Nullable
    private final Result result;
    @SerializedName("timestamp")
    @Nullable
    private final String timestamp;

    public SwimlanesResponse(@Nullable String str, @Nullable Result result2, @Nullable String str2) {
        this.baseUrl = str;
        this.result = result2;
        this.timestamp = str2;
    }

    public static /* synthetic */ SwimlanesResponse copy$default(SwimlanesResponse swimlanesResponse, String str, Result result2, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = swimlanesResponse.baseUrl;
        }
        if ((i11 & 2) != 0) {
            result2 = swimlanesResponse.result;
        }
        if ((i11 & 4) != 0) {
            str2 = swimlanesResponse.timestamp;
        }
        return swimlanesResponse.copy(str, result2, str2);
    }

    @Nullable
    public final String component1() {
        return this.baseUrl;
    }

    @Nullable
    public final Result component2() {
        return this.result;
    }

    @Nullable
    public final String component3() {
        return this.timestamp;
    }

    @NotNull
    public final SwimlanesResponse copy(@Nullable String str, @Nullable Result result2, @Nullable String str2) {
        return new SwimlanesResponse(str, result2, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlanesResponse)) {
            return false;
        }
        SwimlanesResponse swimlanesResponse = (SwimlanesResponse) obj;
        return Intrinsics.areEqual((Object) this.baseUrl, (Object) swimlanesResponse.baseUrl) && Intrinsics.areEqual((Object) this.result, (Object) swimlanesResponse.result) && Intrinsics.areEqual((Object) this.timestamp, (Object) swimlanesResponse.timestamp);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
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
        String str = this.baseUrl;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Result result2 = this.result;
        int hashCode2 = (hashCode + (result2 == null ? 0 : result2.hashCode())) * 31;
        String str2 = this.timestamp;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.baseUrl;
        Result result2 = this.result;
        String str2 = this.timestamp;
        return "SwimlanesResponse(baseUrl=" + str + ", result=" + result2 + ", timestamp=" + str2 + ")";
    }
}
