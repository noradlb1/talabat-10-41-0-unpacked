package datamodels.filters;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Ldatamodels/filters/SelectableSortType;", "Ljava/io/Serializable;", "Ldatamodels/filters/Selectable;", "type", "Ldatamodels/filters/SortType;", "isOn", "", "id", "", "(Ldatamodels/filters/SortType;ZLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "()Z", "setOn", "(Z)V", "getType", "()Ldatamodels/filters/SortType;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SelectableSortType implements Serializable, Selectable {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f13883id;
    private boolean isOn;
    @NotNull
    private final SortType type;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectableSortType(@NotNull SortType sortType, boolean z11) {
        this(sortType, z11, (String) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(sortType, "type");
    }

    @JvmOverloads
    public SelectableSortType(@NotNull SortType sortType, boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(sortType, "type");
        Intrinsics.checkNotNullParameter(str, "id");
        this.type = sortType;
        this.isOn = z11;
        this.f13883id = str;
    }

    public static /* synthetic */ SelectableSortType copy$default(SelectableSortType selectableSortType, SortType sortType, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            sortType = selectableSortType.type;
        }
        if ((i11 & 2) != 0) {
            z11 = selectableSortType.isOn();
        }
        if ((i11 & 4) != 0) {
            str = selectableSortType.f13883id;
        }
        return selectableSortType.copy(sortType, z11, str);
    }

    @NotNull
    public final SortType component1() {
        return this.type;
    }

    public final boolean component2() {
        return isOn();
    }

    @NotNull
    public final String component3() {
        return this.f13883id;
    }

    @NotNull
    public final SelectableSortType copy(@NotNull SortType sortType, boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(sortType, "type");
        Intrinsics.checkNotNullParameter(str, "id");
        return new SelectableSortType(sortType, z11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectableSortType)) {
            return false;
        }
        SelectableSortType selectableSortType = (SelectableSortType) obj;
        return this.type == selectableSortType.type && isOn() == selectableSortType.isOn() && Intrinsics.areEqual((Object) this.f13883id, (Object) selectableSortType.f13883id);
    }

    @NotNull
    public final String getId() {
        return this.f13883id;
    }

    @NotNull
    public final SortType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        boolean isOn2 = isOn();
        if (isOn2) {
            isOn2 = true;
        }
        return ((hashCode + (isOn2 ? 1 : 0)) * 31) + this.f13883id.hashCode();
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void setOn(boolean z11) {
        this.isOn = z11;
    }

    @NotNull
    public String toString() {
        SortType sortType = this.type;
        boolean isOn2 = isOn();
        String str = this.f13883id;
        return "SelectableSortType(type=" + sortType + ", isOn=" + isOn2 + ", id=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectableSortType(SortType sortType, boolean z11, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(sortType, z11, (i11 & 4) != 0 ? "" : str);
    }
}
