package com.talabat.darkstores.data.search.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0017\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/data/search/model/Filters;", "", "categories", "", "Lcom/talabat/darkstores/data/search/model/Filters$Category;", "(Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Category", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Filters {
    @Nullable
    private final List<Category> categories;

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/data/search/model/Filters$Category;", "", "count", "", "id", "", "name", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/darkstores/data/search/model/Filters$Category;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Category {
        @Nullable
        private final Integer count;
        @Nullable

        /* renamed from: id  reason: collision with root package name */
        private final String f56214id;
        @Nullable

        /* renamed from: name  reason: collision with root package name */
        private final String f56215name;

        public Category(@Nullable @Json(name = "count") Integer num, @Nullable @Json(name = "id") String str, @Nullable @Json(name = "name") String str2) {
            this.count = num;
            this.f56214id = str;
            this.f56215name = str2;
        }

        public static /* synthetic */ Category copy$default(Category category, Integer num, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                num = category.count;
            }
            if ((i11 & 2) != 0) {
                str = category.f56214id;
            }
            if ((i11 & 4) != 0) {
                str2 = category.f56215name;
            }
            return category.copy(num, str, str2);
        }

        @Nullable
        public final Integer component1() {
            return this.count;
        }

        @Nullable
        public final String component2() {
            return this.f56214id;
        }

        @Nullable
        public final String component3() {
            return this.f56215name;
        }

        @NotNull
        public final Category copy(@Nullable @Json(name = "count") Integer num, @Nullable @Json(name = "id") String str, @Nullable @Json(name = "name") String str2) {
            return new Category(num, str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Category)) {
                return false;
            }
            Category category = (Category) obj;
            return Intrinsics.areEqual((Object) this.count, (Object) category.count) && Intrinsics.areEqual((Object) this.f56214id, (Object) category.f56214id) && Intrinsics.areEqual((Object) this.f56215name, (Object) category.f56215name);
        }

        @Nullable
        public final Integer getCount() {
            return this.count;
        }

        @Nullable
        public final String getId() {
            return this.f56214id;
        }

        @Nullable
        public final String getName() {
            return this.f56215name;
        }

        public int hashCode() {
            Integer num = this.count;
            int i11 = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.f56214id;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f56215name;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode2 + i11;
        }

        @NotNull
        public String toString() {
            Integer num = this.count;
            String str = this.f56214id;
            String str2 = this.f56215name;
            return "Category(count=" + num + ", id=" + str + ", name=" + str2 + ")";
        }
    }

    public Filters(@Nullable @Json(name = "categories") List<Category> list) {
        this.categories = list;
    }

    public static /* synthetic */ Filters copy$default(Filters filters, List<Category> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = filters.categories;
        }
        return filters.copy(list);
    }

    @Nullable
    public final List<Category> component1() {
        return this.categories;
    }

    @NotNull
    public final Filters copy(@Nullable @Json(name = "categories") List<Category> list) {
        return new Filters(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Filters) && Intrinsics.areEqual((Object) this.categories, (Object) ((Filters) obj).categories);
    }

    @Nullable
    public final List<Category> getCategories() {
        return this.categories;
    }

    public int hashCode() {
        List<Category> list = this.categories;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<Category> list = this.categories;
        return "Filters(categories=" + list + ")";
    }
}
