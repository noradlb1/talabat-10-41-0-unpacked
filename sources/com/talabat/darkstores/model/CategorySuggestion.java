package com.talabat.darkstores.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/model/CategorySuggestion;", "Lcom/talabat/darkstores/model/SearchSuggestion;", "category", "Lcom/talabat/darkstores/model/Category;", "(Lcom/talabat/darkstores/model/Category;)V", "getCategory", "()Lcom/talabat/darkstores/model/Category;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategorySuggestion extends SearchSuggestion {
    @NotNull
    private final Category category;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategorySuggestion(@NotNull @Json(name = "data") Category category2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(category2, "category");
        this.category = category2;
    }

    public static /* synthetic */ CategorySuggestion copy$default(CategorySuggestion categorySuggestion, Category category2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            category2 = categorySuggestion.category;
        }
        return categorySuggestion.copy(category2);
    }

    @NotNull
    public final Category component1() {
        return this.category;
    }

    @NotNull
    public final CategorySuggestion copy(@NotNull @Json(name = "data") Category category2) {
        Intrinsics.checkNotNullParameter(category2, "category");
        return new CategorySuggestion(category2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CategorySuggestion) && Intrinsics.areEqual((Object) this.category, (Object) ((CategorySuggestion) obj).category);
    }

    @NotNull
    public final Category getCategory() {
        return this.category;
    }

    public int hashCode() {
        return this.category.hashCode();
    }

    @NotNull
    public String toString() {
        Category category2 = this.category;
        return "CategorySuggestion(category=" + category2 + ")";
    }
}
