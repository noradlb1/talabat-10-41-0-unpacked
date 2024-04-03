package com.talabat.darkstores.feature.categories.subcategories.sort;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.talabat.darkstores.data.discovery.model.SortOption;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetArgs;", "Landroidx/navigation/NavArgs;", "sortOptions", "", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "([Lcom/talabat/darkstores/data/discovery/model/SortOption;)V", "getSortOptions", "()[Lcom/talabat/darkstores/data/discovery/model/SortOption;", "[Lcom/talabat/darkstores/data/discovery/model/SortOption;", "component1", "copy", "([Lcom/talabat/darkstores/data/discovery/model/SortOption;)Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetArgs;", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SortOptionBottomSheetArgs implements NavArgs {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final SortOption[] sortOptions;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetArgs$Companion;", "", "()V", "fromBundle", "Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SortOptionBottomSheetArgs fromBundle(@NotNull Bundle bundle) {
            SortOption[] sortOptionArr;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(SortOptionBottomSheetArgs.class.getClassLoader());
            if (bundle.containsKey("sortOptions")) {
                Parcelable[] parcelableArray = bundle.getParcelableArray("sortOptions");
                if (parcelableArray != null) {
                    ArrayList arrayList = new ArrayList(parcelableArray.length);
                    int length = parcelableArray.length;
                    int i11 = 0;
                    while (i11 < length) {
                        Parcelable parcelable = parcelableArray[i11];
                        if (parcelable != null) {
                            arrayList.add((SortOption) parcelable);
                            i11++;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.talabat.darkstores.data.discovery.model.SortOption");
                        }
                    }
                    Object[] array = arrayList.toArray(new SortOption[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    sortOptionArr = (SortOption[]) array;
                } else {
                    sortOptionArr = null;
                }
                if (sortOptionArr != null) {
                    return new SortOptionBottomSheetArgs(sortOptionArr);
                }
                throw new IllegalArgumentException("Argument \"sortOptions\" is marked as non-null but was passed a null value.");
            }
            throw new IllegalArgumentException("Required argument \"sortOptions\" is missing and does not have an android:defaultValue");
        }

        @JvmStatic
        @NotNull
        public final SortOptionBottomSheetArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
            SortOption[] sortOptionArr;
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("sortOptions")) {
                Parcelable[] parcelableArr = (Parcelable[]) savedStateHandle.get("sortOptions");
                if (parcelableArr != null) {
                    ArrayList arrayList = new ArrayList(parcelableArr.length);
                    for (Parcelable parcelable : parcelableArr) {
                        arrayList.add((SortOption) parcelable);
                    }
                    Object[] array = arrayList.toArray(new SortOption[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    sortOptionArr = (SortOption[]) array;
                } else {
                    sortOptionArr = null;
                }
                if (sortOptionArr != null) {
                    return new SortOptionBottomSheetArgs(sortOptionArr);
                }
                throw new IllegalArgumentException("Argument \"sortOptions\" is marked as non-null but was passed a null value");
            }
            throw new IllegalArgumentException("Required argument \"sortOptions\" is missing and does not have an android:defaultValue");
        }
    }

    public SortOptionBottomSheetArgs(@NotNull SortOption[] sortOptionArr) {
        Intrinsics.checkNotNullParameter(sortOptionArr, "sortOptions");
        this.sortOptions = sortOptionArr;
    }

    public static /* synthetic */ SortOptionBottomSheetArgs copy$default(SortOptionBottomSheetArgs sortOptionBottomSheetArgs, SortOption[] sortOptionArr, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            sortOptionArr = sortOptionBottomSheetArgs.sortOptions;
        }
        return sortOptionBottomSheetArgs.copy(sortOptionArr);
    }

    @JvmStatic
    @NotNull
    public static final SortOptionBottomSheetArgs fromBundle(@NotNull Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    @NotNull
    public static final SortOptionBottomSheetArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    @NotNull
    public final SortOption[] component1() {
        return this.sortOptions;
    }

    @NotNull
    public final SortOptionBottomSheetArgs copy(@NotNull SortOption[] sortOptionArr) {
        Intrinsics.checkNotNullParameter(sortOptionArr, "sortOptions");
        return new SortOptionBottomSheetArgs(sortOptionArr);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SortOptionBottomSheetArgs) && Intrinsics.areEqual((Object) this.sortOptions, (Object) ((SortOptionBottomSheetArgs) obj).sortOptions);
    }

    @NotNull
    public final SortOption[] getSortOptions() {
        return this.sortOptions;
    }

    public int hashCode() {
        return Arrays.hashCode(this.sortOptions);
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArray("sortOptions", (Parcelable[]) this.sortOptions);
        return bundle;
    }

    @NotNull
    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("sortOptions", this.sortOptions);
        return savedStateHandle;
    }

    @NotNull
    public String toString() {
        String arrays = Arrays.toString(this.sortOptions);
        return "SortOptionBottomSheetArgs(sortOptions=" + arrays + ")";
    }
}
