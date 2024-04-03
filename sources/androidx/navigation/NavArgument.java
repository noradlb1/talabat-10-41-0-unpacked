package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB1\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Landroidx/navigation/NavArgument;", "", "type", "Landroidx/navigation/NavType;", "isNullable", "", "defaultValue", "defaultValuePresent", "(Landroidx/navigation/NavType;ZLjava/lang/Object;Z)V", "getDefaultValue", "()Ljava/lang/Object;", "isDefaultValuePresent", "()Z", "getType", "()Landroidx/navigation/NavType;", "equals", "other", "hashCode", "", "putDefaultValue", "", "name", "", "bundle", "Landroid/os/Bundle;", "toString", "verify", "Builder", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavArgument {
    @Nullable
    private final Object defaultValue;
    private final boolean isDefaultValuePresent;
    private final boolean isNullable;
    @NotNull
    private final NavType<Object> type;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\r\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u000e0\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavArgument$Builder;", "", "()V", "defaultValue", "defaultValuePresent", "", "isNullable", "type", "Landroidx/navigation/NavType;", "build", "Landroidx/navigation/NavArgument;", "setDefaultValue", "setIsNullable", "setType", "T", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        @Nullable
        private Object defaultValue;
        private boolean defaultValuePresent;
        private boolean isNullable;
        @Nullable
        private NavType<Object> type;

        @NotNull
        public final NavArgument build() {
            NavType<Object> navType = this.type;
            if (navType == null) {
                navType = NavType.Companion.inferFromValueType(this.defaultValue);
            }
            return new NavArgument(navType, this.isNullable, this.defaultValue, this.defaultValuePresent);
        }

        @NotNull
        public final Builder setDefaultValue(@Nullable Object obj) {
            this.defaultValue = obj;
            this.defaultValuePresent = true;
            return this;
        }

        @NotNull
        public final Builder setIsNullable(boolean z11) {
            this.isNullable = z11;
            return this;
        }

        @NotNull
        public final <T> Builder setType(@NotNull NavType<T> navType) {
            Intrinsics.checkNotNullParameter(navType, "type");
            this.type = navType;
            return this;
        }
    }

    public NavArgument(@NotNull NavType<Object> navType, boolean z11, @Nullable Object obj, boolean z12) {
        boolean z13;
        Intrinsics.checkNotNullParameter(navType, "type");
        boolean z14 = false;
        if (navType.isNullableAllowed() || !z11) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            if ((z11 || !z12 || obj != null) ? true : z14) {
                this.type = navType;
                this.isNullable = z11;
                this.defaultValue = obj;
                this.isDefaultValuePresent = z12;
                return;
            }
            throw new IllegalArgumentException(("Argument with type " + navType.getName() + " has null value but is not nullable.").toString());
        }
        throw new IllegalArgumentException((navType.getName() + " does not allow nullable values").toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) NavArgument.class, (Object) obj.getClass())) {
            return false;
        }
        NavArgument navArgument = (NavArgument) obj;
        if (this.isNullable != navArgument.isNullable || this.isDefaultValuePresent != navArgument.isDefaultValuePresent || !Intrinsics.areEqual((Object) this.type, (Object) navArgument.type)) {
            return false;
        }
        Object obj2 = this.defaultValue;
        if (obj2 != null) {
            return Intrinsics.areEqual(obj2, navArgument.defaultValue);
        }
        if (navArgument.defaultValue == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    @NotNull
    public final NavType<Object> getType() {
        return this.type;
    }

    public int hashCode() {
        int i11;
        int hashCode = ((((this.type.hashCode() * 31) + (this.isNullable ? 1 : 0)) * 31) + (this.isDefaultValuePresent ? 1 : 0)) * 31;
        Object obj = this.defaultValue;
        if (obj != null) {
            i11 = obj.hashCode();
        } else {
            i11 = 0;
        }
        return hashCode + i11;
    }

    public final boolean isDefaultValuePresent() {
        return this.isDefaultValuePresent;
    }

    public final boolean isNullable() {
        return this.isNullable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void putDefaultValue(@NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (this.isDefaultValuePresent) {
            this.type.put(bundle, str, this.defaultValue);
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(NavArgument.class.getSimpleName());
        sb2.append(" Type: " + this.type);
        sb2.append(" Nullable: " + this.isNullable);
        if (this.isDefaultValuePresent) {
            sb2.append(" DefaultValue: " + this.defaultValue);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
        return sb3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean verify(@NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!this.isNullable && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.type.get(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }
}
