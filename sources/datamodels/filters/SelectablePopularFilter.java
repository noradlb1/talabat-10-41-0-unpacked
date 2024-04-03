package datamodels.filters;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Ldatamodels/filters/SelectablePopularFilter;", "Ljava/io/Serializable;", "Ldatamodels/filters/Selectable;", "filter", "Ldatamodels/filters/FilterType;", "isOn", "", "(Ldatamodels/filters/FilterType;Z)V", "getFilter", "()Ldatamodels/filters/FilterType;", "()Z", "setOn", "(Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SelectablePopularFilter implements Serializable, Selectable {
    @NotNull
    private final FilterType filter;
    private boolean isOn;

    public SelectablePopularFilter(@NotNull FilterType filterType, boolean z11) {
        Intrinsics.checkNotNullParameter(filterType, "filter");
        this.filter = filterType;
        this.isOn = z11;
    }

    public static /* synthetic */ SelectablePopularFilter copy$default(SelectablePopularFilter selectablePopularFilter, FilterType filterType, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filterType = selectablePopularFilter.filter;
        }
        if ((i11 & 2) != 0) {
            z11 = selectablePopularFilter.isOn();
        }
        return selectablePopularFilter.copy(filterType, z11);
    }

    @NotNull
    public final FilterType component1() {
        return this.filter;
    }

    public final boolean component2() {
        return isOn();
    }

    @NotNull
    public final SelectablePopularFilter copy(@NotNull FilterType filterType, boolean z11) {
        Intrinsics.checkNotNullParameter(filterType, "filter");
        return new SelectablePopularFilter(filterType, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectablePopularFilter)) {
            return false;
        }
        SelectablePopularFilter selectablePopularFilter = (SelectablePopularFilter) obj;
        return Intrinsics.areEqual((Object) this.filter, (Object) selectablePopularFilter.filter) && isOn() == selectablePopularFilter.isOn();
    }

    @NotNull
    public final FilterType getFilter() {
        return this.filter;
    }

    public int hashCode() {
        int hashCode = this.filter.hashCode() * 31;
        boolean isOn2 = isOn();
        if (isOn2) {
            isOn2 = true;
        }
        return hashCode + (isOn2 ? 1 : 0);
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void setOn(boolean z11) {
        this.isOn = z11;
    }

    @NotNull
    public String toString() {
        FilterType filterType = this.filter;
        boolean isOn2 = isOn();
        return "SelectablePopularFilter(filter=" + filterType + ", isOn=" + isOn2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectablePopularFilter(FilterType filterType, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(filterType, (i11 & 2) != 0 ? false : z11);
    }
}
