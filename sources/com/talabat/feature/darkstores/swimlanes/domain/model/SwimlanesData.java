package com.talabat.feature.darkstores.swimlanes.domain.model;

import com.visa.checkout.PurchaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesData;", "", "swimlanes", "", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/Swimlanes;", "pageInfo", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesPageInfo;", "requestId", "", "traceId", "(Ljava/util/List;Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesPageInfo;Ljava/lang/String;Ljava/lang/String;)V", "getPageInfo", "()Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesPageInfo;", "getRequestId", "()Ljava/lang/String;", "getSwimlanes", "()Ljava/util/List;", "getTraceId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-swimlanes_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesData {
    @Nullable
    private final SwimlanesPageInfo pageInfo;
    @NotNull
    private final String requestId;
    @NotNull
    private final List<Swimlanes> swimlanes;
    @Nullable
    private final String traceId;

    public SwimlanesData(@NotNull List<Swimlanes> list, @Nullable SwimlanesPageInfo swimlanesPageInfo, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, "swimlanes");
        Intrinsics.checkNotNullParameter(str, PurchaseInfo.REQUEST_ID);
        this.swimlanes = list;
        this.pageInfo = swimlanesPageInfo;
        this.requestId = str;
        this.traceId = str2;
    }

    public static /* synthetic */ SwimlanesData copy$default(SwimlanesData swimlanesData, List<Swimlanes> list, SwimlanesPageInfo swimlanesPageInfo, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = swimlanesData.swimlanes;
        }
        if ((i11 & 2) != 0) {
            swimlanesPageInfo = swimlanesData.pageInfo;
        }
        if ((i11 & 4) != 0) {
            str = swimlanesData.requestId;
        }
        if ((i11 & 8) != 0) {
            str2 = swimlanesData.traceId;
        }
        return swimlanesData.copy(list, swimlanesPageInfo, str, str2);
    }

    @NotNull
    public final List<Swimlanes> component1() {
        return this.swimlanes;
    }

    @Nullable
    public final SwimlanesPageInfo component2() {
        return this.pageInfo;
    }

    @NotNull
    public final String component3() {
        return this.requestId;
    }

    @Nullable
    public final String component4() {
        return this.traceId;
    }

    @NotNull
    public final SwimlanesData copy(@NotNull List<Swimlanes> list, @Nullable SwimlanesPageInfo swimlanesPageInfo, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, "swimlanes");
        Intrinsics.checkNotNullParameter(str, PurchaseInfo.REQUEST_ID);
        return new SwimlanesData(list, swimlanesPageInfo, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlanesData)) {
            return false;
        }
        SwimlanesData swimlanesData = (SwimlanesData) obj;
        return Intrinsics.areEqual((Object) this.swimlanes, (Object) swimlanesData.swimlanes) && Intrinsics.areEqual((Object) this.pageInfo, (Object) swimlanesData.pageInfo) && Intrinsics.areEqual((Object) this.requestId, (Object) swimlanesData.requestId) && Intrinsics.areEqual((Object) this.traceId, (Object) swimlanesData.traceId);
    }

    @Nullable
    public final SwimlanesPageInfo getPageInfo() {
        return this.pageInfo;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final List<Swimlanes> getSwimlanes() {
        return this.swimlanes;
    }

    @Nullable
    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int hashCode = this.swimlanes.hashCode() * 31;
        SwimlanesPageInfo swimlanesPageInfo = this.pageInfo;
        int i11 = 0;
        int hashCode2 = (((hashCode + (swimlanesPageInfo == null ? 0 : swimlanesPageInfo.hashCode())) * 31) + this.requestId.hashCode()) * 31;
        String str = this.traceId;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        List<Swimlanes> list = this.swimlanes;
        SwimlanesPageInfo swimlanesPageInfo = this.pageInfo;
        String str = this.requestId;
        String str2 = this.traceId;
        return "SwimlanesData(swimlanes=" + list + ", pageInfo=" + swimlanesPageInfo + ", requestId=" + str + ", traceId=" + str2 + ")";
    }
}
