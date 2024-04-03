package com.talabat.talabatlife.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatlife/data/remote/dto/Filter;", "", "id", "", "name", "", "slug", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getSlug", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Filter {
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    private final int f12036id;
    @SerializedName("name")
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f12037name;
    @SerializedName("slug")
    @NotNull
    private final String slug;

    public Filter(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "slug");
        this.f12036id = i11;
        this.f12037name = str;
        this.slug = str2;
    }

    public static /* synthetic */ Filter copy$default(Filter filter, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = filter.f12036id;
        }
        if ((i12 & 2) != 0) {
            str = filter.f12037name;
        }
        if ((i12 & 4) != 0) {
            str2 = filter.slug;
        }
        return filter.copy(i11, str, str2);
    }

    public final int component1() {
        return this.f12036id;
    }

    @NotNull
    public final String component2() {
        return this.f12037name;
    }

    @NotNull
    public final String component3() {
        return this.slug;
    }

    @NotNull
    public final Filter copy(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "slug");
        return new Filter(i11, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Filter)) {
            return false;
        }
        Filter filter = (Filter) obj;
        return this.f12036id == filter.f12036id && Intrinsics.areEqual((Object) this.f12037name, (Object) filter.f12037name) && Intrinsics.areEqual((Object) this.slug, (Object) filter.slug);
    }

    public final int getId() {
        return this.f12036id;
    }

    @NotNull
    public final String getName() {
        return this.f12037name;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    public int hashCode() {
        return (((this.f12036id * 31) + this.f12037name.hashCode()) * 31) + this.slug.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.f12036id;
        String str = this.f12037name;
        String str2 = this.slug;
        return "Filter(id=" + i11 + ", name=" + str + ", slug=" + str2 + ")";
    }
}
