package com.talabat.fluttercore.domain.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/talabat/fluttercore/domain/entities/SearchFlutterTrackingInfo;", "", "searchTerm", "", "searchRequestId", "eventOrigin", "productIndex", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEventOrigin", "()Ljava/lang/String;", "getProductIndex", "()I", "getSearchRequestId", "getSearchTerm", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchFlutterTrackingInfo {
    @NotNull
    private final String eventOrigin;
    private final int productIndex;
    @NotNull
    private final String searchRequestId;
    @NotNull
    private final String searchTerm;

    public SearchFlutterTrackingInfo() {
        this((String) null, (String) null, (String) null, 0, 15, (DefaultConstructorMarker) null);
    }

    public SearchFlutterTrackingInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11) {
        Intrinsics.checkNotNullParameter(str, "searchTerm");
        Intrinsics.checkNotNullParameter(str2, "searchRequestId");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        this.searchTerm = str;
        this.searchRequestId = str2;
        this.eventOrigin = str3;
        this.productIndex = i11;
    }

    public static /* synthetic */ SearchFlutterTrackingInfo copy$default(SearchFlutterTrackingInfo searchFlutterTrackingInfo, String str, String str2, String str3, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = searchFlutterTrackingInfo.searchTerm;
        }
        if ((i12 & 2) != 0) {
            str2 = searchFlutterTrackingInfo.searchRequestId;
        }
        if ((i12 & 4) != 0) {
            str3 = searchFlutterTrackingInfo.eventOrigin;
        }
        if ((i12 & 8) != 0) {
            i11 = searchFlutterTrackingInfo.productIndex;
        }
        return searchFlutterTrackingInfo.copy(str, str2, str3, i11);
    }

    @NotNull
    public final String component1() {
        return this.searchTerm;
    }

    @NotNull
    public final String component2() {
        return this.searchRequestId;
    }

    @NotNull
    public final String component3() {
        return this.eventOrigin;
    }

    public final int component4() {
        return this.productIndex;
    }

    @NotNull
    public final SearchFlutterTrackingInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11) {
        Intrinsics.checkNotNullParameter(str, "searchTerm");
        Intrinsics.checkNotNullParameter(str2, "searchRequestId");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        return new SearchFlutterTrackingInfo(str, str2, str3, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchFlutterTrackingInfo)) {
            return false;
        }
        SearchFlutterTrackingInfo searchFlutterTrackingInfo = (SearchFlutterTrackingInfo) obj;
        return Intrinsics.areEqual((Object) this.searchTerm, (Object) searchFlutterTrackingInfo.searchTerm) && Intrinsics.areEqual((Object) this.searchRequestId, (Object) searchFlutterTrackingInfo.searchRequestId) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) searchFlutterTrackingInfo.eventOrigin) && this.productIndex == searchFlutterTrackingInfo.productIndex;
    }

    @NotNull
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    public final int getProductIndex() {
        return this.productIndex;
    }

    @NotNull
    public final String getSearchRequestId() {
        return this.searchRequestId;
    }

    @NotNull
    public final String getSearchTerm() {
        return this.searchTerm;
    }

    public int hashCode() {
        return (((((this.searchTerm.hashCode() * 31) + this.searchRequestId.hashCode()) * 31) + this.eventOrigin.hashCode()) * 31) + this.productIndex;
    }

    @NotNull
    public String toString() {
        String str = this.searchTerm;
        String str2 = this.searchRequestId;
        String str3 = this.eventOrigin;
        int i11 = this.productIndex;
        return "SearchFlutterTrackingInfo(searchTerm=" + str + ", searchRequestId=" + str2 + ", eventOrigin=" + str3 + ", productIndex=" + i11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchFlutterTrackingInfo(String str, String str2, String str3, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? "N/A" : str, (i12 & 2) != 0 ? "N/A" : str2, (i12 & 4) != 0 ? "N/A" : str3, (i12 & 8) != 0 ? -1 : i11);
    }
}
