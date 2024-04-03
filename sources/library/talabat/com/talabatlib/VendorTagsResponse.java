package library.talabat.com.talabatlib;

import datamodels.QuickFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "", "cuisines", "Llibrary/talabat/com/talabatlib/CuisinesContainer;", "collections", "Ljava/util/ArrayList;", "Ldatamodels/QuickFilter;", "filters", "Llibrary/talabat/com/talabatlib/FiltersContainer;", "sorting", "", "Llibrary/talabat/com/talabatlib/Sort;", "(Llibrary/talabat/com/talabatlib/CuisinesContainer;Ljava/util/ArrayList;Llibrary/talabat/com/talabatlib/FiltersContainer;Ljava/util/List;)V", "getCollections", "()Ljava/util/ArrayList;", "setCollections", "(Ljava/util/ArrayList;)V", "getCuisines", "()Llibrary/talabat/com/talabatlib/CuisinesContainer;", "getFilters", "()Llibrary/talabat/com/talabatlib/FiltersContainer;", "setFilters", "(Llibrary/talabat/com/talabatlib/FiltersContainer;)V", "getSorting", "()Ljava/util/List;", "setSorting", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorTagsResponse {
    @Nullable
    private ArrayList<QuickFilter> collections;
    @Nullable
    private final CuisinesContainer cuisines;
    @Nullable
    private FiltersContainer filters;
    @Nullable
    private List<Sort> sorting;

    public VendorTagsResponse(@Nullable CuisinesContainer cuisinesContainer, @Nullable ArrayList<QuickFilter> arrayList, @Nullable FiltersContainer filtersContainer, @Nullable List<Sort> list) {
        this.cuisines = cuisinesContainer;
        this.collections = arrayList;
        this.filters = filtersContainer;
        this.sorting = list;
    }

    public static /* synthetic */ VendorTagsResponse copy$default(VendorTagsResponse vendorTagsResponse, CuisinesContainer cuisinesContainer, ArrayList<QuickFilter> arrayList, FiltersContainer filtersContainer, List<Sort> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisinesContainer = vendorTagsResponse.cuisines;
        }
        if ((i11 & 2) != 0) {
            arrayList = vendorTagsResponse.collections;
        }
        if ((i11 & 4) != 0) {
            filtersContainer = vendorTagsResponse.filters;
        }
        if ((i11 & 8) != 0) {
            list = vendorTagsResponse.sorting;
        }
        return vendorTagsResponse.copy(cuisinesContainer, arrayList, filtersContainer, list);
    }

    @Nullable
    public final CuisinesContainer component1() {
        return this.cuisines;
    }

    @Nullable
    public final ArrayList<QuickFilter> component2() {
        return this.collections;
    }

    @Nullable
    public final FiltersContainer component3() {
        return this.filters;
    }

    @Nullable
    public final List<Sort> component4() {
        return this.sorting;
    }

    @NotNull
    public final VendorTagsResponse copy(@Nullable CuisinesContainer cuisinesContainer, @Nullable ArrayList<QuickFilter> arrayList, @Nullable FiltersContainer filtersContainer, @Nullable List<Sort> list) {
        return new VendorTagsResponse(cuisinesContainer, arrayList, filtersContainer, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorTagsResponse)) {
            return false;
        }
        VendorTagsResponse vendorTagsResponse = (VendorTagsResponse) obj;
        return Intrinsics.areEqual((Object) this.cuisines, (Object) vendorTagsResponse.cuisines) && Intrinsics.areEqual((Object) this.collections, (Object) vendorTagsResponse.collections) && Intrinsics.areEqual((Object) this.filters, (Object) vendorTagsResponse.filters) && Intrinsics.areEqual((Object) this.sorting, (Object) vendorTagsResponse.sorting);
    }

    @Nullable
    public final ArrayList<QuickFilter> getCollections() {
        return this.collections;
    }

    @Nullable
    public final CuisinesContainer getCuisines() {
        return this.cuisines;
    }

    @Nullable
    public final FiltersContainer getFilters() {
        return this.filters;
    }

    @Nullable
    public final List<Sort> getSorting() {
        return this.sorting;
    }

    public int hashCode() {
        CuisinesContainer cuisinesContainer = this.cuisines;
        int i11 = 0;
        int hashCode = (cuisinesContainer == null ? 0 : cuisinesContainer.hashCode()) * 31;
        ArrayList<QuickFilter> arrayList = this.collections;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        FiltersContainer filtersContainer = this.filters;
        int hashCode3 = (hashCode2 + (filtersContainer == null ? 0 : filtersContainer.hashCode())) * 31;
        List<Sort> list = this.sorting;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode3 + i11;
    }

    public final void setCollections(@Nullable ArrayList<QuickFilter> arrayList) {
        this.collections = arrayList;
    }

    public final void setFilters(@Nullable FiltersContainer filtersContainer) {
        this.filters = filtersContainer;
    }

    public final void setSorting(@Nullable List<Sort> list) {
        this.sorting = list;
    }

    @NotNull
    public String toString() {
        CuisinesContainer cuisinesContainer = this.cuisines;
        ArrayList<QuickFilter> arrayList = this.collections;
        FiltersContainer filtersContainer = this.filters;
        List<Sort> list = this.sorting;
        return "VendorTagsResponse(cuisines=" + cuisinesContainer + ", collections=" + arrayList + ", filters=" + filtersContainer + ", sorting=" + list + ")";
    }
}
