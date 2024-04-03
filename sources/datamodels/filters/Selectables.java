package datamodels.filters;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B;\u0012\u0010\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00070\u0003j\u0002`\b\u0012\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\u00070\u0003j\u0002`\bHÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000bHÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00070\u0003j\u0002`\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\t\u001a\f\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001b\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00070\u0003j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Ldatamodels/filters/Selectables;", "Ljava/io/Serializable;", "selectableFilters", "", "Ldatamodels/filters/SelectableFilter;", "Ldatamodels/SelectableFilters;", "selectableSortTypes", "Ldatamodels/filters/SelectableSortType;", "Ldatamodels/SelectableSortTypes;", "selectablePopularFilters", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getSelectableFilters", "()Ljava/util/List;", "getSelectablePopularFilters", "getSelectableSortTypes", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Selectables implements Serializable {
    @NotNull
    private final List<SelectableFilter> selectableFilters;
    @NotNull
    private final List<SelectablePopularFilter> selectablePopularFilters;
    @NotNull
    private final List<SelectableSortType> selectableSortTypes;

    public Selectables(@NotNull List<SelectableFilter> list, @NotNull List<SelectableSortType> list2, @NotNull List<SelectablePopularFilter> list3) {
        Intrinsics.checkNotNullParameter(list, "selectableFilters");
        Intrinsics.checkNotNullParameter(list2, "selectableSortTypes");
        Intrinsics.checkNotNullParameter(list3, "selectablePopularFilters");
        this.selectableFilters = list;
        this.selectableSortTypes = list2;
        this.selectablePopularFilters = list3;
    }

    public static /* synthetic */ Selectables copy$default(Selectables selectables, List<SelectableFilter> list, List<SelectableSortType> list2, List<SelectablePopularFilter> list3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = selectables.selectableFilters;
        }
        if ((i11 & 2) != 0) {
            list2 = selectables.selectableSortTypes;
        }
        if ((i11 & 4) != 0) {
            list3 = selectables.selectablePopularFilters;
        }
        return selectables.copy(list, list2, list3);
    }

    @NotNull
    public final List<SelectableFilter> component1() {
        return this.selectableFilters;
    }

    @NotNull
    public final List<SelectableSortType> component2() {
        return this.selectableSortTypes;
    }

    @NotNull
    public final List<SelectablePopularFilter> component3() {
        return this.selectablePopularFilters;
    }

    @NotNull
    public final Selectables copy(@NotNull List<SelectableFilter> list, @NotNull List<SelectableSortType> list2, @NotNull List<SelectablePopularFilter> list3) {
        Intrinsics.checkNotNullParameter(list, "selectableFilters");
        Intrinsics.checkNotNullParameter(list2, "selectableSortTypes");
        Intrinsics.checkNotNullParameter(list3, "selectablePopularFilters");
        return new Selectables(list, list2, list3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Selectables)) {
            return false;
        }
        Selectables selectables = (Selectables) obj;
        return Intrinsics.areEqual((Object) this.selectableFilters, (Object) selectables.selectableFilters) && Intrinsics.areEqual((Object) this.selectableSortTypes, (Object) selectables.selectableSortTypes) && Intrinsics.areEqual((Object) this.selectablePopularFilters, (Object) selectables.selectablePopularFilters);
    }

    @NotNull
    public final List<SelectableFilter> getSelectableFilters() {
        return this.selectableFilters;
    }

    @NotNull
    public final List<SelectablePopularFilter> getSelectablePopularFilters() {
        return this.selectablePopularFilters;
    }

    @NotNull
    public final List<SelectableSortType> getSelectableSortTypes() {
        return this.selectableSortTypes;
    }

    public int hashCode() {
        return (((this.selectableFilters.hashCode() * 31) + this.selectableSortTypes.hashCode()) * 31) + this.selectablePopularFilters.hashCode();
    }

    @NotNull
    public String toString() {
        List<SelectableFilter> list = this.selectableFilters;
        List<SelectableSortType> list2 = this.selectableSortTypes;
        List<SelectablePopularFilter> list3 = this.selectablePopularFilters;
        return "Selectables(selectableFilters=" + list + ", selectableSortTypes=" + list2 + ", selectablePopularFilters=" + list3 + ")";
    }
}
