package com.talabat.feature.darkstores.swimlanes.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesResponse;", "", "result", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimLanesResult;", "traceId", "", "(Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimLanesResult;Ljava/lang/String;)V", "getResult", "()Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimLanesResult;", "getTraceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesResponse {
    @Nullable
    private final SwimLanesResult result;
    @Nullable
    private final String traceId;

    public SwimlanesResponse() {
        this((SwimLanesResult) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public SwimlanesResponse(@Nullable @Json(name = "result") SwimLanesResult swimLanesResult, @Nullable @Json(name = "trace_id") String str) {
        this.result = swimLanesResult;
        this.traceId = str;
    }

    public static /* synthetic */ SwimlanesResponse copy$default(SwimlanesResponse swimlanesResponse, SwimLanesResult swimLanesResult, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            swimLanesResult = swimlanesResponse.result;
        }
        if ((i11 & 2) != 0) {
            str = swimlanesResponse.traceId;
        }
        return swimlanesResponse.copy(swimLanesResult, str);
    }

    @Nullable
    public final SwimLanesResult component1() {
        return this.result;
    }

    @Nullable
    public final String component2() {
        return this.traceId;
    }

    @NotNull
    public final SwimlanesResponse copy(@Nullable @Json(name = "result") SwimLanesResult swimLanesResult, @Nullable @Json(name = "trace_id") String str) {
        return new SwimlanesResponse(swimLanesResult, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlanesResponse)) {
            return false;
        }
        SwimlanesResponse swimlanesResponse = (SwimlanesResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) swimlanesResponse.result) && Intrinsics.areEqual((Object) this.traceId, (Object) swimlanesResponse.traceId);
    }

    @Nullable
    public final SwimLanesResult getResult() {
        return this.result;
    }

    @Nullable
    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        SwimLanesResult swimLanesResult = this.result;
        int i11 = 0;
        int hashCode = (swimLanesResult == null ? 0 : swimLanesResult.hashCode()) * 31;
        String str = this.traceId;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        SwimLanesResult swimLanesResult = this.result;
        String str = this.traceId;
        return "SwimlanesResponse(result=" + swimLanesResult + ", traceId=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwimlanesResponse(SwimLanesResult swimLanesResult, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : swimLanesResult, (i11 & 2) != 0 ? null : str);
    }
}
