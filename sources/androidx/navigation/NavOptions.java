package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u00002\u00020\u0001:\u0001\"BQ\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eBY\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\n\u0012\b\b\u0001\u0010\f\u001a\u00020\n\u0012\b\b\u0001\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001c\u001a\u00020\nH\u0007J\b\u0010\u001d\u001a\u00020\nH\u0016J\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0003R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\f\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\r\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0014\u0010\u000f\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/navigation/NavOptions;", "", "singleTop", "", "restoreState", "popUpToRoute", "", "popUpToInclusive", "popUpToSaveState", "enterAnim", "", "exitAnim", "popEnterAnim", "popExitAnim", "(ZZLjava/lang/String;ZZIIII)V", "popUpToId", "(ZZIZZIIII)V", "getEnterAnim", "()I", "getExitAnim", "getPopEnterAnim", "getPopExitAnim", "getPopUpToId", "<set-?>", "getPopUpToRoute", "()Ljava/lang/String;", "equals", "other", "getPopUpTo", "hashCode", "isPopUpToInclusive", "shouldLaunchSingleTop", "shouldPopUpToSaveState", "shouldRestoreState", "Builder", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavOptions {
    private final int enterAnim;
    private final int exitAnim;
    private final int popEnterAnim;
    private final int popExitAnim;
    @IdRes
    private final int popUpToId;
    private final boolean popUpToInclusive;
    @Nullable
    private String popUpToRoute;
    private final boolean popUpToSaveState;
    private final boolean restoreState;
    private final boolean singleTop;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0015\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0004J$\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J$\u0010\u0017\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nR\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/navigation/NavOptions$Builder;", "", "()V", "enterAnim", "", "exitAnim", "popEnterAnim", "popExitAnim", "popUpToId", "popUpToInclusive", "", "popUpToRoute", "", "popUpToSaveState", "restoreState", "singleTop", "build", "Landroidx/navigation/NavOptions;", "setEnterAnim", "setExitAnim", "setLaunchSingleTop", "setPopEnterAnim", "setPopExitAnim", "setPopUpTo", "destinationId", "inclusive", "saveState", "route", "setRestoreState", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        @AnimRes
        @AnimatorRes
        private int enterAnim = -1;
        @AnimRes
        @AnimatorRes
        private int exitAnim = -1;
        @AnimRes
        @AnimatorRes
        private int popEnterAnim = -1;
        @AnimRes
        @AnimatorRes
        private int popExitAnim = -1;
        @IdRes
        private int popUpToId = -1;
        private boolean popUpToInclusive;
        @Nullable
        private String popUpToRoute;
        private boolean popUpToSaveState;
        private boolean restoreState;
        private boolean singleTop;

        public static /* synthetic */ Builder setPopUpTo$default(Builder builder, int i11, boolean z11, boolean z12, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                z12 = false;
            }
            return builder.setPopUpTo(i11, z11, z12);
        }

        @NotNull
        public final NavOptions build() {
            String str = this.popUpToRoute;
            if (str != null) {
                return new NavOptions(this.singleTop, this.restoreState, str, this.popUpToInclusive, this.popUpToSaveState, this.enterAnim, this.exitAnim, this.popEnterAnim, this.popExitAnim);
            }
            return new NavOptions(this.singleTop, this.restoreState, this.popUpToId, this.popUpToInclusive, this.popUpToSaveState, this.enterAnim, this.exitAnim, this.popEnterAnim, this.popExitAnim);
        }

        @NotNull
        public final Builder setEnterAnim(@AnimRes @AnimatorRes int i11) {
            this.enterAnim = i11;
            return this;
        }

        @NotNull
        public final Builder setExitAnim(@AnimRes @AnimatorRes int i11) {
            this.exitAnim = i11;
            return this;
        }

        @NotNull
        public final Builder setLaunchSingleTop(boolean z11) {
            this.singleTop = z11;
            return this;
        }

        @NotNull
        public final Builder setPopEnterAnim(@AnimRes @AnimatorRes int i11) {
            this.popEnterAnim = i11;
            return this;
        }

        @NotNull
        public final Builder setPopExitAnim(@AnimRes @AnimatorRes int i11) {
            this.popExitAnim = i11;
            return this;
        }

        @NotNull
        @JvmOverloads
        public final Builder setPopUpTo(@IdRes int i11, boolean z11) {
            return setPopUpTo$default(this, i11, z11, false, 4, (Object) null);
        }

        @NotNull
        @JvmOverloads
        public final Builder setPopUpTo(@IdRes int i11, boolean z11, boolean z12) {
            this.popUpToId = i11;
            this.popUpToRoute = null;
            this.popUpToInclusive = z11;
            this.popUpToSaveState = z12;
            return this;
        }

        @NotNull
        @JvmOverloads
        public final Builder setPopUpTo(@Nullable String str, boolean z11) {
            return setPopUpTo$default(this, str, z11, false, 4, (Object) null);
        }

        @NotNull
        public final Builder setRestoreState(boolean z11) {
            this.restoreState = z11;
            return this;
        }

        public static /* synthetic */ Builder setPopUpTo$default(Builder builder, String str, boolean z11, boolean z12, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            return builder.setPopUpTo(str, z11, z12);
        }

        @NotNull
        @JvmOverloads
        public final Builder setPopUpTo(@Nullable String str, boolean z11, boolean z12) {
            this.popUpToRoute = str;
            this.popUpToId = -1;
            this.popUpToInclusive = z11;
            this.popUpToSaveState = z12;
            return this;
        }
    }

    public NavOptions(boolean z11, boolean z12, @IdRes int i11, boolean z13, boolean z14, @AnimRes @AnimatorRes int i12, @AnimRes @AnimatorRes int i13, @AnimRes @AnimatorRes int i14, @AnimRes @AnimatorRes int i15) {
        this.singleTop = z11;
        this.restoreState = z12;
        this.popUpToId = i11;
        this.popUpToInclusive = z13;
        this.popUpToSaveState = z14;
        this.enterAnim = i12;
        this.exitAnim = i13;
        this.popEnterAnim = i14;
        this.popExitAnim = i15;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) NavOptions.class, (Object) obj.getClass())) {
            return false;
        }
        NavOptions navOptions = (NavOptions) obj;
        if (this.singleTop == navOptions.singleTop && this.restoreState == navOptions.restoreState && this.popUpToId == navOptions.popUpToId && Intrinsics.areEqual((Object) this.popUpToRoute, (Object) navOptions.popUpToRoute) && this.popUpToInclusive == navOptions.popUpToInclusive && this.popUpToSaveState == navOptions.popUpToSaveState && this.enterAnim == navOptions.enterAnim && this.exitAnim == navOptions.exitAnim && this.popEnterAnim == navOptions.popEnterAnim && this.popExitAnim == navOptions.popExitAnim) {
            return true;
        }
        return false;
    }

    @AnimRes
    @AnimatorRes
    public final int getEnterAnim() {
        return this.enterAnim;
    }

    @AnimRes
    @AnimatorRes
    public final int getExitAnim() {
        return this.exitAnim;
    }

    @AnimRes
    @AnimatorRes
    public final int getPopEnterAnim() {
        return this.popEnterAnim;
    }

    @AnimRes
    @AnimatorRes
    public final int getPopExitAnim() {
        return this.popExitAnim;
    }

    @Deprecated(message = "Use popUpToId instead.", replaceWith = @ReplaceWith(expression = "popUpToId", imports = {}))
    @IdRes
    public final int getPopUpTo() {
        return this.popUpToId;
    }

    @IdRes
    public final int getPopUpToId() {
        return this.popUpToId;
    }

    @Nullable
    public final String getPopUpToRoute() {
        return this.popUpToRoute;
    }

    public int hashCode() {
        int i11;
        int i12 = (((((shouldLaunchSingleTop() ? 1 : 0) * true) + (shouldRestoreState() ? 1 : 0)) * 31) + this.popUpToId) * 31;
        String str = this.popUpToRoute;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        return ((((((((((((i12 + i11) * 31) + (isPopUpToInclusive() ? 1 : 0)) * 31) + (shouldPopUpToSaveState() ? 1 : 0)) * 31) + this.enterAnim) * 31) + this.exitAnim) * 31) + this.popEnterAnim) * 31) + this.popExitAnim;
    }

    public final boolean isPopUpToInclusive() {
        return this.popUpToInclusive;
    }

    public final boolean shouldLaunchSingleTop() {
        return this.singleTop;
    }

    public final boolean shouldPopUpToSaveState() {
        return this.popUpToSaveState;
    }

    public final boolean shouldRestoreState() {
        return this.restoreState;
    }

    public NavOptions(boolean z11, boolean z12, @Nullable String str, boolean z13, boolean z14, int i11, int i12, int i13, int i14) {
        this(z11, z12, NavDestination.Companion.createRoute(str).hashCode(), z13, z14, i11, i12, i13, i14);
        this.popUpToRoute = str;
    }
}
