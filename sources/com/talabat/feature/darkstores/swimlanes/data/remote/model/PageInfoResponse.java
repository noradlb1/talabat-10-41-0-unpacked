package com.talabat.feature.darkstores.swimlanes.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/PageInfoResponse;", "", "last", "", "pageNumber", "", "(Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getLast", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPageNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/PageInfoResponse;", "equals", "other", "hashCode", "toString", "", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PageInfoResponse {
    @Nullable
    private final Boolean last;
    @Nullable
    private final Integer pageNumber;

    public PageInfoResponse() {
        this((Boolean) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public PageInfoResponse(@Nullable @Json(name = "last") Boolean bool, @Nullable @Json(name = "page_number") Integer num) {
        this.last = bool;
        this.pageNumber = num;
    }

    public static /* synthetic */ PageInfoResponse copy$default(PageInfoResponse pageInfoResponse, Boolean bool, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = pageInfoResponse.last;
        }
        if ((i11 & 2) != 0) {
            num = pageInfoResponse.pageNumber;
        }
        return pageInfoResponse.copy(bool, num);
    }

    @Nullable
    public final Boolean component1() {
        return this.last;
    }

    @Nullable
    public final Integer component2() {
        return this.pageNumber;
    }

    @NotNull
    public final PageInfoResponse copy(@Nullable @Json(name = "last") Boolean bool, @Nullable @Json(name = "page_number") Integer num) {
        return new PageInfoResponse(bool, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageInfoResponse)) {
            return false;
        }
        PageInfoResponse pageInfoResponse = (PageInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.last, (Object) pageInfoResponse.last) && Intrinsics.areEqual((Object) this.pageNumber, (Object) pageInfoResponse.pageNumber);
    }

    @Nullable
    public final Boolean getLast() {
        return this.last;
    }

    @Nullable
    public final Integer getPageNumber() {
        return this.pageNumber;
    }

    public int hashCode() {
        Boolean bool = this.last;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.pageNumber;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.last;
        Integer num = this.pageNumber;
        return "PageInfoResponse(last=" + bool + ", pageNumber=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PageInfoResponse(Boolean bool, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : num);
    }
}
