package com.talabat.darkstores.data.mission.control.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/data/mission/control/model/PageInfo;", "", "pageNumber", "", "isLast", "", "(IZ)V", "()Z", "getPageNumber", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PageInfo {
    private final boolean isLast;
    private final int pageNumber;

    public PageInfo(@Json(name = "page_number") int i11, @Json(name = "last") boolean z11) {
        this.pageNumber = i11;
        this.isLast = z11;
    }

    public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = pageInfo.pageNumber;
        }
        if ((i12 & 2) != 0) {
            z11 = pageInfo.isLast;
        }
        return pageInfo.copy(i11, z11);
    }

    public final int component1() {
        return this.pageNumber;
    }

    public final boolean component2() {
        return this.isLast;
    }

    @NotNull
    public final PageInfo copy(@Json(name = "page_number") int i11, @Json(name = "last") boolean z11) {
        return new PageInfo(i11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageInfo)) {
            return false;
        }
        PageInfo pageInfo = (PageInfo) obj;
        return this.pageNumber == pageInfo.pageNumber && this.isLast == pageInfo.isLast;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public int hashCode() {
        int i11 = this.pageNumber * 31;
        boolean z11 = this.isLast;
        if (z11) {
            z11 = true;
        }
        return i11 + (z11 ? 1 : 0);
    }

    public final boolean isLast() {
        return this.isLast;
    }

    @NotNull
    public String toString() {
        int i11 = this.pageNumber;
        boolean z11 = this.isLast;
        return "PageInfo(pageNumber=" + i11 + ", isLast=" + z11 + ")";
    }
}
