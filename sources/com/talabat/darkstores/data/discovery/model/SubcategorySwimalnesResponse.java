package com.talabat.darkstores.data.discovery.model;

import com.talabat.darkstores.model.Swimlane;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/SubcategorySwimalnesResponse;", "", "swimlanes", "", "Lcom/talabat/darkstores/model/Swimlane;", "sortOptions", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "(Ljava/util/List;Ljava/util/List;)V", "getSortOptions", "()Ljava/util/List;", "getSwimlanes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubcategorySwimalnesResponse {
    @NotNull
    private final List<SortOption> sortOptions;
    @NotNull
    private final List<Swimlane> swimlanes;

    public SubcategorySwimalnesResponse(@NotNull List<Swimlane> list, @NotNull List<SortOption> list2) {
        Intrinsics.checkNotNullParameter(list, "swimlanes");
        Intrinsics.checkNotNullParameter(list2, "sortOptions");
        this.swimlanes = list;
        this.sortOptions = list2;
    }

    public static /* synthetic */ SubcategorySwimalnesResponse copy$default(SubcategorySwimalnesResponse subcategorySwimalnesResponse, List<Swimlane> list, List<SortOption> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = subcategorySwimalnesResponse.swimlanes;
        }
        if ((i11 & 2) != 0) {
            list2 = subcategorySwimalnesResponse.sortOptions;
        }
        return subcategorySwimalnesResponse.copy(list, list2);
    }

    @NotNull
    public final List<Swimlane> component1() {
        return this.swimlanes;
    }

    @NotNull
    public final List<SortOption> component2() {
        return this.sortOptions;
    }

    @NotNull
    public final SubcategorySwimalnesResponse copy(@NotNull List<Swimlane> list, @NotNull List<SortOption> list2) {
        Intrinsics.checkNotNullParameter(list, "swimlanes");
        Intrinsics.checkNotNullParameter(list2, "sortOptions");
        return new SubcategorySwimalnesResponse(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubcategorySwimalnesResponse)) {
            return false;
        }
        SubcategorySwimalnesResponse subcategorySwimalnesResponse = (SubcategorySwimalnesResponse) obj;
        return Intrinsics.areEqual((Object) this.swimlanes, (Object) subcategorySwimalnesResponse.swimlanes) && Intrinsics.areEqual((Object) this.sortOptions, (Object) subcategorySwimalnesResponse.sortOptions);
    }

    @NotNull
    public final List<SortOption> getSortOptions() {
        return this.sortOptions;
    }

    @NotNull
    public final List<Swimlane> getSwimlanes() {
        return this.swimlanes;
    }

    public int hashCode() {
        return (this.swimlanes.hashCode() * 31) + this.sortOptions.hashCode();
    }

    @NotNull
    public String toString() {
        List<Swimlane> list = this.swimlanes;
        List<SortOption> list2 = this.sortOptions;
        return "SubcategorySwimalnesResponse(swimlanes=" + list + ", sortOptions=" + list2 + ")";
    }
}
