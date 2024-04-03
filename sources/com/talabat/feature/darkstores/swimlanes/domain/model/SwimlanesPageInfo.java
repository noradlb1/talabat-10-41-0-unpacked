package com.talabat.feature.darkstores.swimlanes.domain.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesPageInfo;", "", "last", "", "pageNumber", "", "(ZI)V", "getLast", "()Z", "getPageNumber", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_feature_darkstores-swimlanes_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesPageInfo {
    private final boolean last;
    private final int pageNumber;

    public SwimlanesPageInfo(boolean z11, int i11) {
        this.last = z11;
        this.pageNumber = i11;
    }

    public static /* synthetic */ SwimlanesPageInfo copy$default(SwimlanesPageInfo swimlanesPageInfo, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z11 = swimlanesPageInfo.last;
        }
        if ((i12 & 2) != 0) {
            i11 = swimlanesPageInfo.pageNumber;
        }
        return swimlanesPageInfo.copy(z11, i11);
    }

    public final boolean component1() {
        return this.last;
    }

    public final int component2() {
        return this.pageNumber;
    }

    @NotNull
    public final SwimlanesPageInfo copy(boolean z11, int i11) {
        return new SwimlanesPageInfo(z11, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlanesPageInfo)) {
            return false;
        }
        SwimlanesPageInfo swimlanesPageInfo = (SwimlanesPageInfo) obj;
        return this.last == swimlanesPageInfo.last && this.pageNumber == swimlanesPageInfo.pageNumber;
    }

    public final boolean getLast() {
        return this.last;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public int hashCode() {
        boolean z11 = this.last;
        if (z11) {
            z11 = true;
        }
        return ((z11 ? 1 : 0) * true) + this.pageNumber;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.last;
        int i11 = this.pageNumber;
        return "SwimlanesPageInfo(last=" + z11 + ", pageNumber=" + i11 + ")";
    }
}
