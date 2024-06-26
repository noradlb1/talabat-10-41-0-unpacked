package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.navigation.NavOptions;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\"\u001a\u00020#2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020#0%¢\u0006\u0002\b'J\r\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J+\u0010\u000e\u001a\u00020#2\b\b\u0001\u0010+\u001a\u00020\r2\u0019\b\u0002\u0010,\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020#0%¢\u0006\u0002\b'J)\u0010\u000e\u001a\u00020#2\u0006\u0010.\u001a\u00020\u00172\u0019\b\u0002\u0010,\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020#0%¢\u0006\u0002\b'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@GX\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8\u0006@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u0017@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00068F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u000e\u0010!\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/navigation/NavOptionsBuilder;", "", "()V", "builder", "Landroidx/navigation/NavOptions$Builder;", "inclusive", "", "launchSingleTop", "getLaunchSingleTop", "()Z", "setLaunchSingleTop", "(Z)V", "value", "", "popUpTo", "getPopUpTo$annotations", "getPopUpTo", "()I", "setPopUpTo", "(I)V", "popUpToId", "getPopUpToId", "setPopUpToId$navigation_common_release", "", "popUpToRoute", "getPopUpToRoute", "()Ljava/lang/String;", "setPopUpToRoute", "(Ljava/lang/String;)V", "<set-?>", "restoreState", "getRestoreState", "setRestoreState", "saveState", "anim", "", "animBuilder", "Lkotlin/Function1;", "Landroidx/navigation/AnimBuilder;", "Lkotlin/ExtensionFunctionType;", "build", "Landroidx/navigation/NavOptions;", "build$navigation_common_release", "id", "popUpToBuilder", "Landroidx/navigation/PopUpToBuilder;", "route", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@NavOptionsDsl
public final class NavOptionsBuilder {
    @NotNull
    private final NavOptions.Builder builder = new NavOptions.Builder();
    private boolean inclusive;
    private boolean launchSingleTop;
    @IdRes
    private int popUpToId = -1;
    @Nullable
    private String popUpToRoute;
    private boolean restoreState;
    private boolean saveState;

    @Deprecated(message = "Use the popUpToId property.")
    public static /* synthetic */ void getPopUpTo$annotations() {
    }

    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder navOptionsBuilder, int i11, Function1 function1, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            function1 = NavOptionsBuilder$popUpTo$1.INSTANCE;
        }
        navOptionsBuilder.popUpTo(i11, (Function1<? super PopUpToBuilder, Unit>) function1);
    }

    private final void setPopUpToRoute(String str) {
        if (str == null) {
            return;
        }
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            this.popUpToRoute = str;
            this.inclusive = false;
            return;
        }
        throw new IllegalArgumentException("Cannot pop up to an empty route".toString());
    }

    public final void anim(@NotNull Function1<? super AnimBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "animBuilder");
        AnimBuilder animBuilder = new AnimBuilder();
        function1.invoke(animBuilder);
        this.builder.setEnterAnim(animBuilder.getEnter()).setExitAnim(animBuilder.getExit()).setPopEnterAnim(animBuilder.getPopEnter()).setPopExitAnim(animBuilder.getPopExit());
    }

    @NotNull
    public final NavOptions build$navigation_common_release() {
        NavOptions.Builder builder2 = this.builder;
        builder2.setLaunchSingleTop(this.launchSingleTop);
        builder2.setRestoreState(this.restoreState);
        String str = this.popUpToRoute;
        if (str != null) {
            builder2.setPopUpTo(str, this.inclusive, this.saveState);
        } else {
            builder2.setPopUpTo(this.popUpToId, this.inclusive, this.saveState);
        }
        return builder2.build();
    }

    public final boolean getLaunchSingleTop() {
        return this.launchSingleTop;
    }

    public final int getPopUpTo() {
        return this.popUpToId;
    }

    public final int getPopUpToId() {
        return this.popUpToId;
    }

    @Nullable
    public final String getPopUpToRoute() {
        return this.popUpToRoute;
    }

    public final boolean getRestoreState() {
        return this.restoreState;
    }

    public final void popUpTo(@IdRes int i11, @NotNull Function1<? super PopUpToBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "popUpToBuilder");
        setPopUpToId$navigation_common_release(i11);
        setPopUpToRoute((String) null);
        PopUpToBuilder popUpToBuilder = new PopUpToBuilder();
        function1.invoke(popUpToBuilder);
        this.inclusive = popUpToBuilder.getInclusive();
        this.saveState = popUpToBuilder.getSaveState();
    }

    public final void setLaunchSingleTop(boolean z11) {
        this.launchSingleTop = z11;
    }

    @Deprecated(message = "Use the popUpTo function and passing in the id.")
    public final void setPopUpTo(int i11) {
        popUpTo$default(this, i11, (Function1) null, 2, (Object) null);
    }

    public final void setPopUpToId$navigation_common_release(int i11) {
        this.popUpToId = i11;
        this.inclusive = false;
    }

    public final void setRestoreState(boolean z11) {
        this.restoreState = z11;
    }

    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder navOptionsBuilder, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = NavOptionsBuilder$popUpTo$2.INSTANCE;
        }
        navOptionsBuilder.popUpTo(str, (Function1<? super PopUpToBuilder, Unit>) function1);
    }

    public final void popUpTo(@NotNull String str, @NotNull Function1<? super PopUpToBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        Intrinsics.checkNotNullParameter(function1, "popUpToBuilder");
        setPopUpToRoute(str);
        setPopUpToId$navigation_common_release(-1);
        PopUpToBuilder popUpToBuilder = new PopUpToBuilder();
        function1.invoke(popUpToBuilder);
        this.inclusive = popUpToBuilder.getInclusive();
        this.saveState = popUpToBuilder.getSaveState();
    }
}
