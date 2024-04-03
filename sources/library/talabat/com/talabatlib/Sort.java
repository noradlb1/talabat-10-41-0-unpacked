package library.talabat.com.talabatlib;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Llibrary/talabat/com/talabatlib/Sort;", "", "name", "", "slug", "id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getSlug", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Sort {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f26526id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f26527name;
    @NotNull
    private final String slug;

    public Sort(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "slug");
        Intrinsics.checkNotNullParameter(str3, "id");
        this.f26527name = str;
        this.slug = str2;
        this.f26526id = str3;
    }

    public static /* synthetic */ Sort copy$default(Sort sort, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sort.f26527name;
        }
        if ((i11 & 2) != 0) {
            str2 = sort.slug;
        }
        if ((i11 & 4) != 0) {
            str3 = sort.f26526id;
        }
        return sort.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.f26527name;
    }

    @NotNull
    public final String component2() {
        return this.slug;
    }

    @NotNull
    public final String component3() {
        return this.f26526id;
    }

    @NotNull
    public final Sort copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "slug");
        Intrinsics.checkNotNullParameter(str3, "id");
        return new Sort(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sort)) {
            return false;
        }
        Sort sort = (Sort) obj;
        return Intrinsics.areEqual((Object) this.f26527name, (Object) sort.f26527name) && Intrinsics.areEqual((Object) this.slug, (Object) sort.slug) && Intrinsics.areEqual((Object) this.f26526id, (Object) sort.f26526id);
    }

    @NotNull
    public final String getId() {
        return this.f26526id;
    }

    @NotNull
    public final String getName() {
        return this.f26527name;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    public int hashCode() {
        return (((this.f26527name.hashCode() * 31) + this.slug.hashCode()) * 31) + this.f26526id.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f26527name;
        String str2 = this.slug;
        String str3 = this.f26526id;
        return "Sort(name=" + str + ", slug=" + str2 + ", id=" + str3 + ")";
    }
}
