package com.talabat.darkstores.feature.categoriesOverview;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.talabat.darkstores.model.Category;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheetArgs;", "Landroidx/navigation/NavArgs;", "categories", "", "Lcom/talabat/darkstores/model/Category;", "([Lcom/talabat/darkstores/model/Category;)V", "getCategories", "()[Lcom/talabat/darkstores/model/Category;", "[Lcom/talabat/darkstores/model/Category;", "component1", "copy", "([Lcom/talabat/darkstores/model/Category;)Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheetArgs;", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoriesOverviewBottomSheetArgs implements NavArgs {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Category[] categories;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheetArgs$Companion;", "", "()V", "fromBundle", "Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheetArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final CategoriesOverviewBottomSheetArgs fromBundle(@NotNull Bundle bundle) {
            Category[] categoryArr;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(CategoriesOverviewBottomSheetArgs.class.getClassLoader());
            if (bundle.containsKey("categories")) {
                Parcelable[] parcelableArray = bundle.getParcelableArray("categories");
                if (parcelableArray != null) {
                    ArrayList arrayList = new ArrayList(parcelableArray.length);
                    int length = parcelableArray.length;
                    int i11 = 0;
                    while (i11 < length) {
                        Parcelable parcelable = parcelableArray[i11];
                        if (parcelable != null) {
                            arrayList.add((Category) parcelable);
                            i11++;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.talabat.darkstores.model.Category");
                        }
                    }
                    Object[] array = arrayList.toArray(new Category[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    categoryArr = (Category[]) array;
                } else {
                    categoryArr = null;
                }
                if (categoryArr != null) {
                    return new CategoriesOverviewBottomSheetArgs(categoryArr);
                }
                throw new IllegalArgumentException("Argument \"categories\" is marked as non-null but was passed a null value.");
            }
            throw new IllegalArgumentException("Required argument \"categories\" is missing and does not have an android:defaultValue");
        }

        @JvmStatic
        @NotNull
        public final CategoriesOverviewBottomSheetArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
            Category[] categoryArr;
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("categories")) {
                Parcelable[] parcelableArr = (Parcelable[]) savedStateHandle.get("categories");
                if (parcelableArr != null) {
                    ArrayList arrayList = new ArrayList(parcelableArr.length);
                    for (Parcelable parcelable : parcelableArr) {
                        arrayList.add((Category) parcelable);
                    }
                    Object[] array = arrayList.toArray(new Category[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    categoryArr = (Category[]) array;
                } else {
                    categoryArr = null;
                }
                if (categoryArr != null) {
                    return new CategoriesOverviewBottomSheetArgs(categoryArr);
                }
                throw new IllegalArgumentException("Argument \"categories\" is marked as non-null but was passed a null value");
            }
            throw new IllegalArgumentException("Required argument \"categories\" is missing and does not have an android:defaultValue");
        }
    }

    public CategoriesOverviewBottomSheetArgs(@NotNull Category[] categoryArr) {
        Intrinsics.checkNotNullParameter(categoryArr, "categories");
        this.categories = categoryArr;
    }

    public static /* synthetic */ CategoriesOverviewBottomSheetArgs copy$default(CategoriesOverviewBottomSheetArgs categoriesOverviewBottomSheetArgs, Category[] categoryArr, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            categoryArr = categoriesOverviewBottomSheetArgs.categories;
        }
        return categoriesOverviewBottomSheetArgs.copy(categoryArr);
    }

    @JvmStatic
    @NotNull
    public static final CategoriesOverviewBottomSheetArgs fromBundle(@NotNull Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    @NotNull
    public static final CategoriesOverviewBottomSheetArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    @NotNull
    public final Category[] component1() {
        return this.categories;
    }

    @NotNull
    public final CategoriesOverviewBottomSheetArgs copy(@NotNull Category[] categoryArr) {
        Intrinsics.checkNotNullParameter(categoryArr, "categories");
        return new CategoriesOverviewBottomSheetArgs(categoryArr);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CategoriesOverviewBottomSheetArgs) && Intrinsics.areEqual((Object) this.categories, (Object) ((CategoriesOverviewBottomSheetArgs) obj).categories);
    }

    @NotNull
    public final Category[] getCategories() {
        return this.categories;
    }

    public int hashCode() {
        return Arrays.hashCode(this.categories);
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArray("categories", (Parcelable[]) this.categories);
        return bundle;
    }

    @NotNull
    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("categories", this.categories);
        return savedStateHandle;
    }

    @NotNull
    public String toString() {
        String arrays = Arrays.toString(this.categories);
        return "CategoriesOverviewBottomSheetArgs(categories=" + arrays + ")";
    }
}
