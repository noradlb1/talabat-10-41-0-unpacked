package com.talabat.darkstores.feature.home;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/feature/home/SearchViewHolderData;", "", "canShowGreySearchBar", "", "canShowTopHeaderChanges", "(ZZ)V", "getCanShowGreySearchBar", "()Z", "getCanShowTopHeaderChanges", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchViewHolderData {
    private final boolean canShowGreySearchBar;
    private final boolean canShowTopHeaderChanges;

    public SearchViewHolderData(boolean z11, boolean z12) {
        this.canShowGreySearchBar = z11;
        this.canShowTopHeaderChanges = z12;
    }

    public static /* synthetic */ SearchViewHolderData copy$default(SearchViewHolderData searchViewHolderData, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = searchViewHolderData.canShowGreySearchBar;
        }
        if ((i11 & 2) != 0) {
            z12 = searchViewHolderData.canShowTopHeaderChanges;
        }
        return searchViewHolderData.copy(z11, z12);
    }

    public final boolean component1() {
        return this.canShowGreySearchBar;
    }

    public final boolean component2() {
        return this.canShowTopHeaderChanges;
    }

    @NotNull
    public final SearchViewHolderData copy(boolean z11, boolean z12) {
        return new SearchViewHolderData(z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchViewHolderData)) {
            return false;
        }
        SearchViewHolderData searchViewHolderData = (SearchViewHolderData) obj;
        return this.canShowGreySearchBar == searchViewHolderData.canShowGreySearchBar && this.canShowTopHeaderChanges == searchViewHolderData.canShowTopHeaderChanges;
    }

    public final boolean getCanShowGreySearchBar() {
        return this.canShowGreySearchBar;
    }

    public final boolean getCanShowTopHeaderChanges() {
        return this.canShowTopHeaderChanges;
    }

    public int hashCode() {
        boolean z11 = this.canShowGreySearchBar;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.canShowTopHeaderChanges;
        if (!z13) {
            z12 = z13;
        }
        return i11 + (z12 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        boolean z11 = this.canShowGreySearchBar;
        boolean z12 = this.canShowTopHeaderChanges;
        return "SearchViewHolderData(canShowGreySearchBar=" + z11 + ", canShowTopHeaderChanges=" + z12 + ")";
    }
}
