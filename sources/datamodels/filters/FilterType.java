package datamodels.filters;

import datamodels.Restaurant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\nHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001d"}, d2 = {"Ldatamodels/filters/FilterType;", "Ljava/io/Serializable;", "name", "", "slugName", "predicate", "Lkotlin/Function1;", "Ldatamodels/Restaurant;", "", "id", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;I)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getPredicate", "()Lkotlin/jvm/functions/Function1;", "getSlugName", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilterType implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private final int f13881id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f13882name;
    @NotNull
    private final Function1<Restaurant, Boolean> predicate;
    @NotNull
    private final String slugName;

    public FilterType(@NotNull String str, @NotNull String str2, @NotNull Function1<? super Restaurant, Boolean> function1, int i11) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "slugName");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        this.f13882name = str;
        this.slugName = str2;
        this.predicate = function1;
        this.f13881id = i11;
    }

    public static /* synthetic */ FilterType copy$default(FilterType filterType, String str, String str2, Function1<Restaurant, Boolean> function1, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = filterType.f13882name;
        }
        if ((i12 & 2) != 0) {
            str2 = filterType.slugName;
        }
        if ((i12 & 4) != 0) {
            function1 = filterType.predicate;
        }
        if ((i12 & 8) != 0) {
            i11 = filterType.f13881id;
        }
        return filterType.copy(str, str2, function1, i11);
    }

    @NotNull
    public final String component1() {
        return this.f13882name;
    }

    @NotNull
    public final String component2() {
        return this.slugName;
    }

    @NotNull
    public final Function1<Restaurant, Boolean> component3() {
        return this.predicate;
    }

    public final int component4() {
        return this.f13881id;
    }

    @NotNull
    public final FilterType copy(@NotNull String str, @NotNull String str2, @NotNull Function1<? super Restaurant, Boolean> function1, int i11) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "slugName");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return new FilterType(str, str2, function1, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterType)) {
            return false;
        }
        FilterType filterType = (FilterType) obj;
        return Intrinsics.areEqual((Object) this.f13882name, (Object) filterType.f13882name) && Intrinsics.areEqual((Object) this.slugName, (Object) filterType.slugName) && Intrinsics.areEqual((Object) this.predicate, (Object) filterType.predicate) && this.f13881id == filterType.f13881id;
    }

    public final int getId() {
        return this.f13881id;
    }

    @NotNull
    public final String getName() {
        return this.f13882name;
    }

    @NotNull
    public final Function1<Restaurant, Boolean> getPredicate() {
        return this.predicate;
    }

    @NotNull
    public final String getSlugName() {
        return this.slugName;
    }

    public int hashCode() {
        return (((((this.f13882name.hashCode() * 31) + this.slugName.hashCode()) * 31) + this.predicate.hashCode()) * 31) + this.f13881id;
    }

    @NotNull
    public String toString() {
        String str = this.f13882name;
        String str2 = this.slugName;
        Function1<Restaurant, Boolean> function1 = this.predicate;
        int i11 = this.f13881id;
        return "FilterType(name=" + str + ", slugName=" + str2 + ", predicate=" + function1 + ", id=" + i11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterType(String str, String str2, Function1 function1, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i12 & 4) != 0 ? AnonymousClass1.INSTANCE : function1, (i12 & 8) != 0 ? -1 : i11);
    }
}
