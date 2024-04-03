package com.talabat.darkstores.feature.cart.ageRestriction;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/feature/cart/ageRestriction/AgeRestrictionBottomSheetArgs;", "Landroidx/navigation/NavArgs;", "age", "", "(Ljava/lang/String;)V", "getAge", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AgeRestrictionBottomSheetArgs implements NavArgs {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String age;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/cart/ageRestriction/AgeRestrictionBottomSheetArgs$Companion;", "", "()V", "fromBundle", "Lcom/talabat/darkstores/feature/cart/ageRestriction/AgeRestrictionBottomSheetArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final AgeRestrictionBottomSheetArgs fromBundle(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(AgeRestrictionBottomSheetArgs.class.getClassLoader());
            if (bundle.containsKey("age")) {
                String string = bundle.getString("age");
                if (string != null) {
                    return new AgeRestrictionBottomSheetArgs(string);
                }
                throw new IllegalArgumentException("Argument \"age\" is marked as non-null but was passed a null value.");
            }
            throw new IllegalArgumentException("Required argument \"age\" is missing and does not have an android:defaultValue");
        }

        @JvmStatic
        @NotNull
        public final AgeRestrictionBottomSheetArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("age")) {
                String str = (String) savedStateHandle.get("age");
                if (str != null) {
                    return new AgeRestrictionBottomSheetArgs(str);
                }
                throw new IllegalArgumentException("Argument \"age\" is marked as non-null but was passed a null value");
            }
            throw new IllegalArgumentException("Required argument \"age\" is missing and does not have an android:defaultValue");
        }
    }

    public AgeRestrictionBottomSheetArgs(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "age");
        this.age = str;
    }

    public static /* synthetic */ AgeRestrictionBottomSheetArgs copy$default(AgeRestrictionBottomSheetArgs ageRestrictionBottomSheetArgs, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = ageRestrictionBottomSheetArgs.age;
        }
        return ageRestrictionBottomSheetArgs.copy(str);
    }

    @JvmStatic
    @NotNull
    public static final AgeRestrictionBottomSheetArgs fromBundle(@NotNull Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    @NotNull
    public static final AgeRestrictionBottomSheetArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    @NotNull
    public final String component1() {
        return this.age;
    }

    @NotNull
    public final AgeRestrictionBottomSheetArgs copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "age");
        return new AgeRestrictionBottomSheetArgs(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AgeRestrictionBottomSheetArgs) && Intrinsics.areEqual((Object) this.age, (Object) ((AgeRestrictionBottomSheetArgs) obj).age);
    }

    @NotNull
    public final String getAge() {
        return this.age;
    }

    public int hashCode() {
        return this.age.hashCode();
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("age", this.age);
        return bundle;
    }

    @NotNull
    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("age", this.age);
        return savedStateHandle;
    }

    @NotNull
    public String toString() {
        String str = this.age;
        return "AgeRestrictionBottomSheetArgs(age=" + str + ")";
    }
}
