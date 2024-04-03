package com.talabat.darkstores.feature.categories;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.talabat.darkstores.model.Category;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/feature/categories/CategoriesFragmentArgs;", "Landroidx/navigation/NavArgs;", "category", "Lcom/talabat/darkstores/model/Category;", "eventOrigin", "", "(Lcom/talabat/darkstores/model/Category;Ljava/lang/String;)V", "getCategory", "()Lcom/talabat/darkstores/model/Category;", "getEventOrigin", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoriesFragmentArgs implements NavArgs {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Category category;
    @NotNull
    private final String eventOrigin;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/categories/CategoriesFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/talabat/darkstores/feature/categories/CategoriesFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final CategoriesFragmentArgs fromBundle(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(CategoriesFragmentArgs.class.getClassLoader());
            if (bundle.containsKey("category")) {
                Class<Category> cls = Category.class;
                if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                    Category category = (Category) bundle.get("category");
                    if (category == null) {
                        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
                    } else if (bundle.containsKey("eventOrigin")) {
                        String string = bundle.getString("eventOrigin");
                        if (string != null) {
                            return new CategoriesFragmentArgs(category, string);
                        }
                        throw new IllegalArgumentException("Argument \"eventOrigin\" is marked as non-null but was passed a null value.");
                    } else {
                        throw new IllegalArgumentException("Required argument \"eventOrigin\" is missing and does not have an android:defaultValue");
                    }
                } else {
                    String name2 = cls.getName();
                    throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
                }
            } else {
                throw new IllegalArgumentException("Required argument \"category\" is missing and does not have an android:defaultValue");
            }
        }

        @JvmStatic
        @NotNull
        public final CategoriesFragmentArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("category")) {
                Class<Category> cls = Category.class;
                if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                    Category category = (Category) savedStateHandle.get("category");
                    if (category == null) {
                        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value");
                    } else if (savedStateHandle.contains("eventOrigin")) {
                        String str = (String) savedStateHandle.get("eventOrigin");
                        if (str != null) {
                            return new CategoriesFragmentArgs(category, str);
                        }
                        throw new IllegalArgumentException("Argument \"eventOrigin\" is marked as non-null but was passed a null value");
                    } else {
                        throw new IllegalArgumentException("Required argument \"eventOrigin\" is missing and does not have an android:defaultValue");
                    }
                } else {
                    String name2 = cls.getName();
                    throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
                }
            } else {
                throw new IllegalArgumentException("Required argument \"category\" is missing and does not have an android:defaultValue");
            }
        }
    }

    public CategoriesFragmentArgs(@NotNull Category category2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(category2, "category");
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        this.category = category2;
        this.eventOrigin = str;
    }

    public static /* synthetic */ CategoriesFragmentArgs copy$default(CategoriesFragmentArgs categoriesFragmentArgs, Category category2, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            category2 = categoriesFragmentArgs.category;
        }
        if ((i11 & 2) != 0) {
            str = categoriesFragmentArgs.eventOrigin;
        }
        return categoriesFragmentArgs.copy(category2, str);
    }

    @JvmStatic
    @NotNull
    public static final CategoriesFragmentArgs fromBundle(@NotNull Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    @NotNull
    public static final CategoriesFragmentArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    @NotNull
    public final Category component1() {
        return this.category;
    }

    @NotNull
    public final String component2() {
        return this.eventOrigin;
    }

    @NotNull
    public final CategoriesFragmentArgs copy(@NotNull Category category2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(category2, "category");
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        return new CategoriesFragmentArgs(category2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoriesFragmentArgs)) {
            return false;
        }
        CategoriesFragmentArgs categoriesFragmentArgs = (CategoriesFragmentArgs) obj;
        return Intrinsics.areEqual((Object) this.category, (Object) categoriesFragmentArgs.category) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) categoriesFragmentArgs.eventOrigin);
    }

    @NotNull
    public final Category getCategory() {
        return this.category;
    }

    @NotNull
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    public int hashCode() {
        return (this.category.hashCode() * 31) + this.eventOrigin.hashCode();
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        Class<Category> cls = Category.class;
        if (Parcelable.class.isAssignableFrom(cls)) {
            bundle.putParcelable("category", this.category);
        } else if (Serializable.class.isAssignableFrom(cls)) {
            bundle.putSerializable("category", (Serializable) this.category);
        } else {
            String name2 = cls.getName();
            throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        bundle.putString("eventOrigin", this.eventOrigin);
        return bundle;
    }

    @NotNull
    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        Class<Category> cls = Category.class;
        if (Parcelable.class.isAssignableFrom(cls)) {
            savedStateHandle.set("category", this.category);
        } else if (Serializable.class.isAssignableFrom(cls)) {
            savedStateHandle.set("category", (Serializable) this.category);
        } else {
            String name2 = cls.getName();
            throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        savedStateHandle.set("eventOrigin", this.eventOrigin);
        return savedStateHandle;
    }

    @NotNull
    public String toString() {
        Category category2 = this.category;
        String str = this.eventOrigin;
        return "CategoriesFragmentArgs(category=" + category2 + ", eventOrigin=" + str + ")";
    }
}
