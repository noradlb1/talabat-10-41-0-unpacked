package com.talabat.darkstores.feature.categories.subcategories.experiment;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewArgs;", "Landroidx/navigation/NavArgs;", "categoryId", "", "categoryName", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategoryId", "()Ljava/lang/String;", "getCategoryName", "getEventOrigin", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentNewArgs implements NavArgs {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String categoryId;
    @NotNull
    private final String categoryName;
    @NotNull
    private final String eventOrigin;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewArgs$Companion;", "", "()V", "fromBundle", "Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SubcategoriesFragmentNewArgs fromBundle(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(SubcategoriesFragmentNewArgs.class.getClassLoader());
            if (bundle.containsKey("categoryId")) {
                String string = bundle.getString("categoryId");
                if (string == null) {
                    throw new IllegalArgumentException("Argument \"categoryId\" is marked as non-null but was passed a null value.");
                } else if (bundle.containsKey("categoryName")) {
                    String string2 = bundle.getString("categoryName");
                    if (string2 == null) {
                        throw new IllegalArgumentException("Argument \"categoryName\" is marked as non-null but was passed a null value.");
                    } else if (bundle.containsKey("eventOrigin")) {
                        String string3 = bundle.getString("eventOrigin");
                        if (string3 != null) {
                            return new SubcategoriesFragmentNewArgs(string, string2, string3);
                        }
                        throw new IllegalArgumentException("Argument \"eventOrigin\" is marked as non-null but was passed a null value.");
                    } else {
                        throw new IllegalArgumentException("Required argument \"eventOrigin\" is missing and does not have an android:defaultValue");
                    }
                } else {
                    throw new IllegalArgumentException("Required argument \"categoryName\" is missing and does not have an android:defaultValue");
                }
            } else {
                throw new IllegalArgumentException("Required argument \"categoryId\" is missing and does not have an android:defaultValue");
            }
        }

        @JvmStatic
        @NotNull
        public final SubcategoriesFragmentNewArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("categoryId")) {
                String str = (String) savedStateHandle.get("categoryId");
                if (str == null) {
                    throw new IllegalArgumentException("Argument \"categoryId\" is marked as non-null but was passed a null value");
                } else if (savedStateHandle.contains("categoryName")) {
                    String str2 = (String) savedStateHandle.get("categoryName");
                    if (str2 == null) {
                        throw new IllegalArgumentException("Argument \"categoryName\" is marked as non-null but was passed a null value");
                    } else if (savedStateHandle.contains("eventOrigin")) {
                        String str3 = (String) savedStateHandle.get("eventOrigin");
                        if (str3 != null) {
                            return new SubcategoriesFragmentNewArgs(str, str2, str3);
                        }
                        throw new IllegalArgumentException("Argument \"eventOrigin\" is marked as non-null but was passed a null value");
                    } else {
                        throw new IllegalArgumentException("Required argument \"eventOrigin\" is missing and does not have an android:defaultValue");
                    }
                } else {
                    throw new IllegalArgumentException("Required argument \"categoryName\" is missing and does not have an android:defaultValue");
                }
            } else {
                throw new IllegalArgumentException("Required argument \"categoryId\" is missing and does not have an android:defaultValue");
            }
        }
    }

    public SubcategoriesFragmentNewArgs(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "categoryId");
        Intrinsics.checkNotNullParameter(str2, "categoryName");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        this.categoryId = str;
        this.categoryName = str2;
        this.eventOrigin = str3;
    }

    public static /* synthetic */ SubcategoriesFragmentNewArgs copy$default(SubcategoriesFragmentNewArgs subcategoriesFragmentNewArgs, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subcategoriesFragmentNewArgs.categoryId;
        }
        if ((i11 & 2) != 0) {
            str2 = subcategoriesFragmentNewArgs.categoryName;
        }
        if ((i11 & 4) != 0) {
            str3 = subcategoriesFragmentNewArgs.eventOrigin;
        }
        return subcategoriesFragmentNewArgs.copy(str, str2, str3);
    }

    @JvmStatic
    @NotNull
    public static final SubcategoriesFragmentNewArgs fromBundle(@NotNull Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    @NotNull
    public static final SubcategoriesFragmentNewArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    @NotNull
    public final String component1() {
        return this.categoryId;
    }

    @NotNull
    public final String component2() {
        return this.categoryName;
    }

    @NotNull
    public final String component3() {
        return this.eventOrigin;
    }

    @NotNull
    public final SubcategoriesFragmentNewArgs copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "categoryId");
        Intrinsics.checkNotNullParameter(str2, "categoryName");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        return new SubcategoriesFragmentNewArgs(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubcategoriesFragmentNewArgs)) {
            return false;
        }
        SubcategoriesFragmentNewArgs subcategoriesFragmentNewArgs = (SubcategoriesFragmentNewArgs) obj;
        return Intrinsics.areEqual((Object) this.categoryId, (Object) subcategoriesFragmentNewArgs.categoryId) && Intrinsics.areEqual((Object) this.categoryName, (Object) subcategoriesFragmentNewArgs.categoryName) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) subcategoriesFragmentNewArgs.eventOrigin);
    }

    @NotNull
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    public int hashCode() {
        return (((this.categoryId.hashCode() * 31) + this.categoryName.hashCode()) * 31) + this.eventOrigin.hashCode();
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("categoryId", this.categoryId);
        bundle.putString("categoryName", this.categoryName);
        bundle.putString("eventOrigin", this.eventOrigin);
        return bundle;
    }

    @NotNull
    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("categoryId", this.categoryId);
        savedStateHandle.set("categoryName", this.categoryName);
        savedStateHandle.set("eventOrigin", this.eventOrigin);
        return savedStateHandle;
    }

    @NotNull
    public String toString() {
        String str = this.categoryId;
        String str2 = this.categoryName;
        String str3 = this.eventOrigin;
        return "SubcategoriesFragmentNewArgs(categoryId=" + str + ", categoryName=" + str2 + ", eventOrigin=" + str3 + ")";
    }
}
